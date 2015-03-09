(ns famous-cljs.navigation
  (:require [cljs.core.async :refer [chan >!]])
  (:require-macros [cljs.core.async.macros :refer [go go-loop]]))

(def center-top-mod
  (js/famous.core.Modifier. (clj->js {:align [0.5 0]
                                      :origin [0.5 0]})))

(defn- notify-navigation
  [ch target]
  (go
   (>! ch {:event :navigation
           :target name})))

(defn- nav-link
  [ch target]
  (let [surface (js/famous.core.Surface.
                 (clj->js {:content target
                           :size [200 100]
                           :classes ["Navigation-link"]
                           :properties {:line-height "100px"}}))]
    (.on surface
         "click"
         (fn []
           (notify-navigation ch target)
           (.setClasses surface (array "Navigation-link" "Navigation-link--active"))))
    surface))

(defn- create-nav-links
  [nav-ch]
  (clj->js [(nav-link nav-ch "Foo")
            (nav-link nav-ch "Bar")
            (nav-link nav-ch "Baz")]))

(defn- create-layout
  [nav-links]
  (doto (js/famous.views.SequentialLayout. #js{:direction 0})
    (.sequenceFrom nav-links)))

(defn- fade-in
  [sm]
  (.setOpacity sm 1 #js{:duration 2000
                        :curve (.-outBack js/famous.transitions.Easing)}))

(defn add-navigation
  "Adds the navigation bar to the given context. Returns the channel where the navigation events are sent."
  [ctx]
  (println "[famous-cljs] Adding navigation bar.")
  (let [nav-ch (chan)
        nav-links (create-nav-links nav-ch)
        layout (create-layout nav-links)
        state-mod (js/famous.modifiers.StateModifier. #js{:opacity 0})]
    (-> ctx
        (.add center-top-mod)
        (.add state-mod)
        (.add layout))
    (fade-in state-mod)
    nav-ch))
