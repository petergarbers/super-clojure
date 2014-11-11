(defproject super-clojure "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [
                 ;;[cheshire "5.3.1"]
                 ;;[environ "1.0.0"]
                 [compojure "1.1.3"]
                 [liberator "0.12.2"]
                 [org.clojure/clojure "1.6.0"]
                 [ring/ring-core "1.3.1"]]

  :plugins [[lein-ring "0.8.13"]
            ;;[lein-environ "1.0.0"]
            ;;[lein-release "1.0.5"]
            ;;[org.clojure/tools.logging "0.3.1"]
            ]

  :ring {:handler super-clojure.core/handler
         :port 8080
         :nrepl {:start? true
                 :port 4433}})


;; TODO::
;; Logging. Create proper log files
;; Start server from repl - start server from ring command xx
;; Setup environment variables
;; Set propper http headers
;; Example authenticated routes with friend
;; Correct create jar
;; TOols.namespace
;; Remote repl server (drawbridge)?
;; Transit
