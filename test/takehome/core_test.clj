#_{:clj-kondo/ignore [:refer-all]}
(ns takehome.core-test
  (:require [clojure.test :refer :all]
            [java-time :as time]
            [takehome.core :as sub]))

(deftest test-patriota
  (are [result obj purchase] (= result (sub/can-access? obj purchase))
    true  {:type :series
           :name "1964: O Brasil entre Armas e Livros",
           :released-at (time/local-date-time "2019-07-24T20:02:34.691")} 
          {:type               :patriota
           :subscription-start (time/local-date-time "2019-01-24T11:46:22.811")
           :subscription-end   (time/local-date-time "2020-01-24T11:46:22.811")}
    true  {:type :podcasts
           :name "1964: O Brasil entre Armas e Livros",
           :released-at (time/local-date-time "2019-07-24T20:02:34.691")} 
          {:type               :patriota
           :subscription-start (time/local-date-time "2019-01-24T11:46:22.811")
           :subscription-end   (time/local-date-time "2020-01-24T11:46:22.811")}
    true  {:type :debates
           :name "1964: O Brasil entre Armas e Livros",
           :released-at (time/local-date-time "2019-07-24T20:02:34.691")} 
          {:type               :patriota
           :subscription-start (time/local-date-time "2019-01-24T11:46:22.811")
           :subscription-end   (time/local-date-time "2020-01-24T11:46:22.811")}
    true  {:type :interview
           :name "1964: O Brasil entre Armas e Livros",
           :released-at (time/local-date-time "2019-07-24T20:02:34.691")} 
          {:type               :patriota
           :subscription-start (time/local-date-time "2019-01-24T11:46:22.811")
           :subscription-end   (time/local-date-time "2020-01-24T11:46:22.811")}
    false {:type :series 
           :name "1964: O Brasil entre Armas e Livros", 
           :released-at (time/local-date-time "2019-07-24T20:02:34.691")}
          {:type               :patriota
           :subscription-start (time/local-date-time "2017-01-24T11:46:22.811")
           :subscription-end   (time/local-date-time "2019-01-24T11:46:22.811")}
    false  {:type :curses
           :name "1964: O Brasil entre Armas e Livros",
           :released-at (time/local-date-time "2019-07-24T20:02:34.691")} 
          {:type               :patriota
           :subscription-start (time/local-date-time "2019-01-24T11:46:22.811")
           :subscription-end   (time/local-date-time "2020-01-24T11:46:22.811")}
    false  {:type :macenas
           :name "1964: O Brasil entre Armas e Livros",
           :released-at (time/local-date-time "2019-07-24T20:02:34.691")} 
          {:type               :patriota
           :subscription-start (time/local-date-time "2019-01-24T11:46:22.811")
           :subscription-end   (time/local-date-time "2020-01-24T11:46:22.811")}
  )
)

(deftest test-premium
  (are [result obj purchase] (= result (sub/can-access? obj purchase))
    true  {:type :series
           :name "1964: O Brasil entre Armas e Livros",
           :released-at (time/local-date-time "2019-07-24T20:02:34.691")} 
          {:type               :premium
           :subscription-start (time/local-date-time "2019-01-24T11:46:22.811")
           :subscription-end   (time/local-date-time "2020-01-24T11:46:22.811")}
    true  {:type :podcasts
           :name "1964: O Brasil entre Armas e Livros",
           :released-at (time/local-date-time "2019-07-24T20:02:34.691")} 
          {:type               :premium
           :subscription-start (time/local-date-time "2019-01-24T11:46:22.811")
           :subscription-end   (time/local-date-time "2020-01-24T11:46:22.811")}
    true  {:type :debates
           :name "1964: O Brasil entre Armas e Livros",
           :released-at (time/local-date-time "2019-07-24T20:02:34.691")} 
          {:type               :premium
           :subscription-start (time/local-date-time "2019-01-24T11:46:22.811")
           :subscription-end   (time/local-date-time "2020-01-24T11:46:22.811")}
    true  {:type :interview
           :name "1964: O Brasil entre Armas e Livros",
           :released-at (time/local-date-time "2019-07-24T20:02:34.691")} 
          {:type               :premium
           :subscription-start (time/local-date-time "2019-01-24T11:46:22.811")
           :subscription-end   (time/local-date-time "2020-01-24T11:46:22.811")}
    true  {:type :curses
           :name "1964: O Brasil entre Armas e Livros",
           :released-at (time/local-date-time "2019-07-24T20:02:34.691")} 
          {:type               :premium
           :subscription-start (time/local-date-time "2019-01-24T11:46:22.811")
           :subscription-end   (time/local-date-time "2020-01-24T11:46:22.811")}
    false {:type :series 
           :name "1964: O Brasil entre Armas e Livros", 
           :released-at (time/local-date-time "2019-07-24T20:02:34.691")}
          {:type               :premium
           :subscription-start (time/local-date-time "2017-01-24T11:46:22.811")
           :subscription-end   (time/local-date-time "2019-01-24T11:46:22.811")}
    false  {:type :macenas
           :name "1964: O Brasil entre Armas e Livros",
           :released-at (time/local-date-time "2019-07-24T20:02:34.691")} 
          {:type               :premium
           :subscription-start (time/local-date-time "2019-01-24T11:46:22.811")
           :subscription-end   (time/local-date-time "2020-01-24T11:46:22.811")}
    )
  )

(deftest test-macenas
  (are [result obj purchase] (= result (sub/can-access? obj purchase))
    true  {:type :series
           :name "1964: O Brasil entre Armas e Livros",
           :released-at (time/local-date-time "2019-07-24T20:02:34.691")} 
          {:type               :macenas
           :subscription-start (time/local-date-time "2019-01-24T11:46:22.811")
           :subscription-end   (time/local-date-time "2020-01-24T11:46:22.811")}
    true  {:type :podcasts
           :name "1964: O Brasil entre Armas e Livros",
           :released-at (time/local-date-time "2019-07-24T20:02:34.691")} 
          {:type               :macenas
           :subscription-start (time/local-date-time "2019-01-24T11:46:22.811")
           :subscription-end   (time/local-date-time "2020-01-24T11:46:22.811")}
    true  {:type :debates
           :name "1964: O Brasil entre Armas e Livros",
           :released-at (time/local-date-time "2019-07-24T20:02:34.691")} 
          {:type               :macenas
           :subscription-start (time/local-date-time "2019-01-24T11:46:22.811")
           :subscription-end   (time/local-date-time "2020-01-24T11:46:22.811")}
    true  {:type :interview
           :name "1964: O Brasil entre Armas e Livros",
           :released-at (time/local-date-time "2019-07-24T20:02:34.691")} 
          {:type               :macenas
           :subscription-start (time/local-date-time "2019-01-24T11:46:22.811")
           :subscription-end   (time/local-date-time "2020-01-24T11:46:22.811")}
    true  {:type :curses
           :name "1964: O Brasil entre Armas e Livros",
           :released-at (time/local-date-time "2019-07-24T20:02:34.691")} 
          {:type               :macenas
           :subscription-start (time/local-date-time "2019-01-24T11:46:22.811")
           :subscription-end   (time/local-date-time "2020-01-24T11:46:22.811")}
    true  {:type :macenas
           :name "1964: O Brasil entre Armas e Livros",
           :released-at (time/local-date-time "2019-07-24T20:02:34.691")} 
          {:type               :macenas
           :subscription-start (time/local-date-time "2019-01-24T11:46:22.811")
           :subscription-end   (time/local-date-time "2020-01-24T11:46:22.811")}
    false {:type :series 
           :name "1964: O Brasil entre Armas e Livros", 
           :released-at (time/local-date-time "2019-07-24T20:02:34.691")}
          {:type               :macenas
           :subscription-start (time/local-date-time "2017-01-24T11:46:22.811")
           :subscription-end   (time/local-date-time "2019-01-24T11:46:22.811")}
    )
  )
