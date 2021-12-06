(ns takehome.core
  (:require [java-time :as time]))

(def patriota-access '(:series :podcasts :debates :interview))
(def premium-access '(:series :podcasts :debates :interview :curses))
(def macenas-access '(:series :podcasts :debates :interview :curses :patron))

(defn expired-view [object purchase]
  (time/before? (:subscription-start purchase)
                       (:released-at object)
                       (:subscription-end purchase)))

(defn in? 
  "true if coll contains elm"
  [coll elm]  
  (if (nil? (some #(= elm %) coll)) false true))

;; Todos usuários podem ver series, mesmo com assinaturas vencidas, seguindo a mesma lógica atual da BP, onde há acesso Free.
;; Conteúdos de assinaturas específicas só permitem acesso aos conteúdos criados no periodo de assinatura, mesmo após o vencimento da assinatura.
(defn valid-media [object purchase product-list]
  (if (not= (:type object) :series)
    (and (in? product-list (:type object)) (expired-view object purchase))
    true)
  )

(defn can-access? [object, purchase]
  (if (= (:type purchase) :patriota)
    (valid-media object purchase patriota-access)
    (if (= (:type purchase) :premium)
      (valid-media object purchase premium-access)
      (if (= (:type purchase) :macenas)
        (valid-media object purchase macenas-access)
        (= (:type object) :series)))))

;; Custom test
;; (can-access?
;;  {:type :podcasts
;;   :name "1964: O Brasil entre Armas e Livros"
;;   :released-at (time/local-date-time "2019-07-24T20:02:34.691")}
;;  {:type               :free
;;   :subscription-start (time/local-date-time "2019-01-24T11:46:22.811")
;;   :subscription-end   (time/local-date-time "2020-01-24T11:46:22.811")})