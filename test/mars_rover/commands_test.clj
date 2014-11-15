(ns mars-rover.commands-test
  (:require [midje.sweet :refer :all]
            [mars-rover.commands :as subject]
            [mars-rover.mover :as mover]
            [mars-rover.rotator :as compass]))

(fact "understands move command"
      (subject/command-executer ..robot.. "M") => irrelevant
      (provided
        (mover/move-robot ..robot..) => anything))

(fact "understands rotate command"
      (subject/command-executer ..robot.. "L") => irrelevant
      (provided
        (compass/rotate-robot ..robot.. "L") => anything))

(fact "can command robot"
      (subject/run-commands-on-robot {:cords [2 2] :direction "N"} "lM") > {:cords [1 2] :direction "W"})