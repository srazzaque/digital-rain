(ns famous-cljs.matrix
  (:require [cljs.core.async :refer [chan >! <! timeout]])
  (:require-macros [cljs.core.async.macros :refer [go go-loop]]))

(def ^:private charset "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*()][{}\\/<>,.0123456789")

(defn- random-character
  []
  (let [n (.floor js/Math (rand (.-length charset)))]
    (.charAt charset n)))

(defn- new-character
  []
  (let [node (js/famous.core.RenderNode.)
        opacity-state (js/famous.transitions.Transitionable. 1)
        modifier (js/famous.core.Modifier.
                  (clj->js {:opacity (fn [] (.get opacity-state))}))
        surface (js/famous.core.Surface.
                 (clj->js {:content (random-character)
                           :size [12 10]
                           :properties {:backgroundColor "#000000"
                                        :lineHeight "8px"
                                        :fontWeight "bold"
                                        :fontSize "0.8em"
                                        :color "#33FF00"}}))]
    (-> node
        (.add modifier)
        (.add surface))
    (go
     (<! (timeout 200))
     (.set opacity-state 0.1 #js{:duration 1000}))
    node))

(defn- make-column
  []
  (let [col-seq (js/famous.views.SequentialLayout.)
        characters (array)]
    (.sequenceFrom col-seq characters)
    (go-loop [n 0]
             (<! (timeout (rand 1000)))
             (aset characters (mod n 60) (new-character))
             (recur (inc n)))
    col-seq))

(defn- make-columns
  []
  (clj->js (vec (repeatedly 100 make-column))))

(defn- add-matrix
  [ctx]
  (let [column-layout (js/famous.views.SequentialLayout. #js{:direction 0})
        columns (make-columns)]
    (.sequenceFrom column-layout columns)
    (.add ctx column-layout)))
