(defproject trackmytime "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [ring/ring-core "1.4.0"]
                 [ring/ring-jetty-adapter "1.4.0"]
                 [compojure "1.4.0"]
                 [expectations "2.1.4"]]

  :source-paths ["src/clj" "src/cljs"]

  :test-paths ["test/clj" "test/cljs"]

  :plugins [[lein-ring "0.9.7"] ; Simplifies running ring server. How to run ring server without this plugin? Only REPL?
            [lein-autoexpect "1.7.0"]]

  :ring {:handler trackmytime.handler/app ; Set entry point for lein-ring plugin
         :nrepl {:start? true
                 :port 9998}}

  :main trackmytime.core ; Set entry point for lein run. Am I right?

  :profiles {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                                  [ring-mock "0.1.5"]]}
             :uberjar {:aot :all}})
