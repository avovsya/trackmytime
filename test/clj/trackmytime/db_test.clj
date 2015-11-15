(ns trackmytime.db-test
  (:require  [expectations :refer :all]
             [trackmytime.db :as db]))

(expect 0 (count (do
                   (db/init-db)
                   (db/get-today-log))))


(expect (more-> 1 count
                "Log entry" (-> first
                                :description)
                2 (-> first
                      :duration))
        (do
          (db/add-log-entry "Log entry" 2)
          (db/get-today-log)))


(expect (more-> 1 count
                "Log entry" (-> first
                                :description)
                7 (-> first
                      :duration))
        (do
          (db/add-log-entry "Log entry" 5)
          (db/get-today-log)))
