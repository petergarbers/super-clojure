(ns super-clojure.core
  (:require [compojure.core :refer [defroutes ANY]]
            [environ.core :refer [env]]
            [liberator.core :refer [defresource]]
            [ring.middleware.params :refer [wrap-params]]
            [super-clojure.middleware :as middleware]))

(defresource healthcheck []
  :allowed-methods [:get]
  :available-media-types ["application/json"]
  :handle-ok {:status (env :application-environment)})

(defroutes app
  (ANY "/healthcheck" [] (healthcheck)))

(def handler
  (-> app
      wrap-params
      middleware/wrap-request-logger
      middleware/wrap-response-logger))
