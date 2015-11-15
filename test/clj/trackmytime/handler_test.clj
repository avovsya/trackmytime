(ns trackmytime.handler-test
  (:require [trackmytime.handler :refer :all]
            [expectations :refer :all]
            [ring.mock.request :as mock]))

;; log endpoint
(expect (more-> 200 :status
                "No log for date. Ha ha!" :body)
        (app (mock/request :get "/log/date")))
