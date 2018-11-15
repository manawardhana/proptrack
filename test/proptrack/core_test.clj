(ns proptrack.core-test
  (:require [clojure.test :refer :all]
            [proptrack.core :refer :all]
            [proptrack.sample-data :refer [state]]
            [proptrack.specs :as ps]))

(deftest proptrack-tests
  (let [find-properties (find-properties-fn state)
        compute-fees (compute-fees-fn state)
        higherst-fees (highest-fees-fn state)]

    (testing "find-properties fn"
      (let [annes-properties (find-properties {:id 2})]
      (is (= 2 (count annes-properties)))
      (is (some #{"30 Baker Street 2118"} (map  :address annes-properties)))
      (is (some #{"53 Henry Street 2750"} (map  :address annes-properties)))))

    (testing "compute-fees fn"
      (is (= 1000300 (compute-fees {:id 1})))
      (is (= 2300545 (compute-fees {:id 2}))))

    (testing "higherst-fees fn"
      (is (= 2 (get (highest-fees (state :persons)) :id))))))
