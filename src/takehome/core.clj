(ns takehome.core
  (:require [java-time :as time]))

(def patriota-access '(:series :podcasts :debates :interview))
(def premium-access '(:series :podcasts :debates :interview :curses))
(def macenas-access '(:series :podcasts :debates :interview :curses :macenas))

(defn expired-view [object purchase]
  (time/before? (:subscription-start purchase)
                       (:released-at object)
                       (:subscription-end purchase)))

(defn in? 
  "true if coll contains elm"
  [coll elm]  
  (some #(= elm %) coll))

(defn valid-media [object purchase product-list]
  (and (in? product-list (:type object)) (expired-view object purchase)))

(defn can-access? [object, purchase]
  (if (= (:type purchase) :patriota)
    (valid-media object purchase patriota-access)
    (if (= (:type purchase) :premium)
      (valid-media object purchase premium-access)
      (if (= (:type purchase) :macenas)
        (valid-media object purchase macenas-access)
        (= (:type object) :series)))))

