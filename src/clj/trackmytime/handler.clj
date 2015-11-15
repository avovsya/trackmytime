(ns trackmytime.handler
  (:use compojure.core)
  (:require [compojure.core :refer [GET POST defroutes]]))

(defn- get-log-for-date [date] (str "No log for " date ". Ha ha!"))

(defroutes app
  (GET "/log/:date" [date] (get-log-for-date date)))
