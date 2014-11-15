(ns mars-rover.rotator-test
  (:require [midje.sweet :refer :all]
            [mars-rover.rotator :as subject]))

(facts "compass directions"
       (tabular "can be rotated"
                (fact (subject/rotate-compass ?current-direction ?way-to-rotate) => ?new-direction)
                ?current-direction ?way-to-rotate ?new-direction
                "N" "L" "W"
                "W" "L" "S"
                "S" "L" "E"
                "E" "L" "N"

                "N" "R" "E"
                "W" "R" "N"
                "S" "R" "W"
                "E" "R" "S"))

(fact "can rotate a robot"
      (subject/rotate-robot {:cords [1 1] :direction "N"} "R") => {:cords [1 1] :direction "E"})
