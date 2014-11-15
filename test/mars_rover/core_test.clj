(ns mars-rover.core-test
  (:require [midje.sweet :refer :all]
            [mars-rover.core :as subject]))

(facts "compass directions"
       (tabular "can be rotated"
                (fact (subject/compass-rotate ?current-direction ?way-to-rotate) => ?new-direction)
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
      (fact (subject/rotate {:cords [1 1] :direction "N"} "R") => {:cords [1 1] :direction "E"}))

(tabular "move x y cordinate based off compass direction"
         (fact (subject/move {:cords [1 1] :direction ?direction}) => {:cords ?new-cords :direction ?direction})
         ?direction ?new-cords
         "N" [1 2]
         "E" [2 1]
         "S" [1 0]
         "W" [0 1])

(facts "rule parser"
       (fact "understands move command"
             (subject/command-parser ..robot.. "M") => irrelevant
             (provided
               (subject/move ..robot..) => anything))
       (fact "understands rotate command"
             (subject/command-parser ..robot.. "L") => irrelevant
             (provided
               (subject/rotate ..robot.. "L") => anything)))

(facts "acceptance tests"
       (tabular
         (fact (subject/command-robot ?start-robot ?commands) => ?end-robot)
         ?start-robot ?end-robot ?commands
         {:cords [1 2] :direction "N"} {:cords [1 3] :direction "N"} "LMLMLMLMM"
         {:cords [3 3] :direction "E"} {:cords [5 1] :direction "E"} "MMRMMRMRRM"))
