(ns famous-cljs.app
  (:require [famous-cljs.navigation :as nav]
            [famous-cljs.pages :as pages]
            [famous-cljs.matrix :as matrix]
            [cljs.core.async :refer [<!]])
  (:require-macros [cljs.core.async.macros :refer [go-loop]]))

(enable-console-print!)

(defn ^:export start-app
  []
  (println "Starting up.")
  (let [context (.createContext js/famous.core.Engine)
        layout (js/famous.views.HeaderFooterLayout. #js{:headerSize 100
                                                        :footerSize 50})
        nav-chan (nav/add-navigation (.-header layout))]
    (pages/add-pages (.-content layout) nav-chan)
    (.add context layout)))

(defn ^:export start
  []
  (println "The matrix has you.")
  (let [context (.createContext js/famous.core.Engine)]
    (matrix/add-matrix context)))

