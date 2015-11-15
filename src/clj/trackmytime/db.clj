(ns trackmytime.db)

(def db (atom []))

(defn init-db []
  (reset! db []))

(defn- find-entry-by-description [description]
  (first (keep-indexed (fn [index entry]
                         (when (= description (:description entry))
                           {:entry entry :index index})) @db)))

(defn get-today-log []
  @db)

(defn add-log-entry [description duration]
  (if-let [{existing-entry :entry index :index} (find-entry-by-description description)]
    (swap! db assoc index {:description description :duration (+ duration (:duration existing-entry))} )
    (swap! db conj {:description description :duration duration})))
