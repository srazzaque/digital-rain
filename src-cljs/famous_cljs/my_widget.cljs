(ns famous-cljs.my-widget
  (:require [cljs.core.async :refer [>! <! take! put! chan]])
  (:require-macros [cljs.core.async.macros :refer [go go-loop]]))

(def surface-settings (clj->js {:content "<h3>Widget</h3>"
                                :size [200 200]
                                :properties {:backgroundColor "#fa5c4f"}}))

(defn- move
  [modifier]
  (.setTransform modifier
                 (.translate js/famous.core.Transform (rand 100) (rand 300) 0)
                 (clj->js {:duration 200
                           :curve "easeInOut"})))

(defn add
  [render-tree]
  (let [modifier (js/famous.modifiers.StateModifier.)
        surface (js/famous.core.Surface. surface-settings)]
    (.on surface
         "click"
         (fn [_]
           (move modifier)))
    (-> render-tree
        (.add modifier)
        (.add surface))))
