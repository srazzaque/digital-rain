(ns famous-cljs.pages)

(defn- center-mod
  []
  (js/famous.core.Modifier. (clj->js {:align [0.5 0]
                                      :origin [0.5 0]
                                      :size [400 300]})))

(defn- add-login
  [ctx]
  (let [form-layout (js/famous.views.GridLayout. (clj->js {:dimensions [1 2]}))
        fields-layout (js/famous.views.GridLayout. (clj->js {:dimensions [2 2]}))
        fields (clj->js [(js/famous.core.Surface. (clj->js {:content "Username"
                                                            :size [nil 50]}))
                         (js/famous.surfaces.InputSurface. (clj->js {:type "text"
                                                                     :size [nil 50]}))
                         (js/famous.core.Surface. (js/famous.core.Surface. (clj->js {:content "Password"
                                                                                     :size [nil 50]})))
                         (js/famous.surfaces.InputSurface. (clj->js {:type "password"
                                                                     :size [nil 50]}))])
        button (js/famous.surfaces.InputSurface. #js{:type "button"})
        form-items #js[fields-layout button]]
    (.sequenceFrom fields-layout fields)
    (.sequenceFrom form-layout form-items)
    (-> ctx
        (.add form-layout))))

(defn add-pages
  [ctx nav-ch]
  (println "[famous-cljs] Adding pages.")
  (-> ctx
      (.add (center-mod))
      add-login))
