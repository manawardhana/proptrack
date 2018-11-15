(ns proptrack.core
  (:require [clojure.spec.alpha :as s]
            [proptrack.specs :as ps]
            [proptrack.sample-data :refer [state]]))

;; Helper Fns
;; ------------------------------
(defn -get-post-code
  "Helper fn: Get post code from property address"
  [property]
  (-> property
      :address
      (clojure.string/split #" ")
      last
      read-string))

(defn -get-suburb
  "Helper fn: Get the suburb entity of a property"
  [property suburbs]
  (-> property
      -get-post-code
      ((fn [pc] (filter #(= pc (:post-code %)) suburbs)))
      first))


;; Util Fn Factories
;; ------------------------------
(defn find-properties-fn
  "Returns a fn in which the state enclosed in
  and finds all the properties for a person"
  [{:keys [properties]}]
  (fn [person]
    (filter #(= (person :id) (:owner-id %))
            properties)))

(defn compute-fees-fn
  "Returns a fn in which the state enclosed in
  and computes all the fees that a given person should pay"
  [{:keys [suburbs] :as state}]
  (fn [person]
    (let [person-properties ((find-properties-fn state) person)
          property-suberb (map #(merge % (-get-suburb % suburbs))
                               person-properties)
          fees (mapcat
                (juxt :value :stamp-duty :transfer-fees)
                property-suberb)]
      (reduce + fees))))

(defn highest-fees-fn
  "Returns a fn in which the state enclosed in
  and finds which person will pay the highest fees"
  [state]
  (fn [people]
    (->> people
         (map (juxt identity (compute-fees-fn state)))
         (reduce (partial max-key second))
         first)))

;; State enclosed fns
;; ------------------------------

(def find-properties
  (find-properties-fn state))

(def compute-fees
  (compute-fees-fn state))

(def highest-fees
  (highest-fees-fn state))

(highest-fees (state :persons))
