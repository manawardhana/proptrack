(ns proptrack.specs
  (:require [clojure.spec.alpha :as s]))

;; Fields
(s/def ::first string?)
(s/def ::last string?)
(s/def ::birth-date string?);;TODO date validation
(s/def ::city string?)
(s/def ::state string?)
(s/def ::id int?)
(s/def ::owner-id int?)
(s/def ::value number?)
(s/def ::stamp-duty number?)
(s/def ::transfer-fee number?)
(s/def ::post-code number?)

(s/def ::address (s/and string?
                        (fn [s]
                          (-> s
                              (clojure.string/split #" ")
                              last
                              read-string
                              number?))))
;; Records
(s/def ::person (s/keys :req-un [::id ::first ::last]
                        :opt-un [::birth-date]))

(s/def ::property (s/keys :req-un [::address ::owner-id ::value]
                          :opt-un [::state ::city]))

(s/def ::suburbs (s/keys :req-un [::post-code ::state ::stamp-duty ::transfer-fees]
                         :opt-un [::city]))
