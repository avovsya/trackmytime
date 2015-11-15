(ns trackmytime.handler-test
  (:require [trackmytime.handler :refer :all]
            [clojure.test :refer :all]
            [ring.mock.request :as mock]))

(deftest test-handler
  (testing "log enpoint"
    (let [response (app (mock/request :get "/log/date"))]
      (is (= (:status response) 200))
      (is (= (:body response) "No log for date. Ha ha!")))))

