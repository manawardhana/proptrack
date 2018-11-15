(ns proptrack.sample-data)

;; Sample Data
;; ------------------------------
(def state
  {:persons
   [{:first "John" :last "Smith" :birth-date "10/09/1977" :id 1}
    {:first "Anne" :last "Hunter" :birth-date "10/09/1983" :id 2}
    {:first "Kate" :last "Jackson" :birth-date "10/09/1971" :id 3}
    {:first "Paul" :last "Johnson" :birth-date "10/09/1987" :id 4}]

   :properties
   [{:address "2 Park Street 2000" :city "Sydney" :state "NSW" :owner-id 1 :value 1000000}
    {:address "30 Baker Street 2118" :city "Carlingford" :state "NSW" :owner-id 2 :value 1200000}
    {:address "53 Henry Street 2750" :city "Penrith" :state "NSW" :owner-id 2 :value 1100000}
    {:address "2 Park Street 2000" :city "Sydney" :state "NSW" :owner-id 3 :value 1150000}
    {:address "22 Sussex Street 2000" :city "Sydney" :state "NSW" :owner-id 4 :value 900000}]

   :suburbs
   [{:post-code 2000 :city "Sydney" :state "NSW" :stamp-duty 100 :transfer-fees 200}
    {:post-code 2118 :city "Carlingford" :state "NSW" :stamp-duty 105 :transfer-fees 190}
    {:post-code 2077 :city "Hornsby" :state "NSW" :stamp-duty 115 :transfer-fees 250}
    {:post-code 2150 :city "Parramatta" :state "NSW" :stamp-duty 120 :transfer-fees 240}
    {:post-code 2750 :city "Penrith" :state "NSW" :stamp-duty 90 :transfer-fees 160}]})
