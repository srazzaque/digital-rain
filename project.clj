(defproject famous-cljs "0.1.0-SNAPSHOT"
  :description "famous-cljs"
  :url ""
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2727"]
                 [org.clojure/core.async "0.1.346.0-17112a-alpha"]
                 [org.clojure/tools.trace "0.7.8"]]
  :plugins [[lein-ring "0.8.10"]
            [lein-cljsbuild "1.0.4"]]
  :ring {:handler cronic-web.handler/app}
  :profiles {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                                  [ring-mock "0.1.5"]]}}
  :clean-targets ^{:protect false} ["resources/private/js/*" "resources/public/js/*" "target/*"]
  :cljsbuild {:builds {:prod {:source-paths ["src-cljs"]
                              :compiler {:output-to "resources/public/js/app.js"
                                         :output-dir "resources/public/js"
                                         :source-map "resources/public/js/app.map"
                                         :externs ["externs/famous.extern.js"]
                                         :optimizations :advanced}}
                       }})
