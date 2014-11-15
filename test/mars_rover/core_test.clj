(ns mars-rover.core-test
  (:require [midje.sweet :refer :all]
            [mars-rover.core :as subject]))

(tabular "acceptance tests"
         (fact (subject/execute-commands ?start-robot ?commands) => ?end-robot)
         ?start-robot ?end-robot ?commands
         "1 2 N" "1 3 N" "LMLMLMLMM"
         "3 3 E" "5 1 E" "MMRMMRMRRM")
