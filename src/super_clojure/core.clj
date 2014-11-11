(ns super-clojure.core
  (:require [compojure.core :refer [defroutes GET]]
            [liberator.core :refer [defresource]]
            [ring.middleware.params :refer [wrap-params]]))

(defresource healthcheck []
  :available-media-types ["application/json"]
  :handle-ok {:status 200})

(defroutes app
  (GET "/healthcheck" [] (healthcheck)))

(def handler
  (-> app
      wrap-params))
