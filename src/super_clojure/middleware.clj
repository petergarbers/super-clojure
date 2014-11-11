(ns super-clojure.middleware
  (:require [clojure.string :as string :refer [upper-case]]
            [taoensso.timbre :as log]))

(defn wrap-request-logger
  "Ring middleware function that uses clojure.tools.logging to write a debug message
  containing remote address, request method & URI of incoming request"
  [handler]
  (fn [request]
    (log/info :in ::wrap-request-logger :request (dissoc request :body))
    (handler request)))

(defn wrap-response-logger
  "Ring middleware function that uses clojure.tools.logging to write a debug message
  containing remote address, request method, URI & response status of outgoing response"
  [handler]
  (fn [req]
    (let [response (handler req)]
      (log/info :in ::wrap-response-logger :response response)
      response)))
