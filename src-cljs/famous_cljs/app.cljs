(ns famous-cljs.app
  (:require [famous-cljs.matrix :as matrix]))

(enable-console-print!)

(defn ^:export start
  []
  (println "The matrix has you.")
  (let [context (.createContext js/famous.core.Engine)]
    (matrix/add-matrix context)))

