(ns mars-rover.robot-mapper-test
  (:require [midje.sweet :refer :all]
            [mars-rover.robot-mapper :as subject]))

(fact "goes from string to robot map"
      (subject/string->robot "1 2 N") > {:cords [1 2] :direction "N"})

(fact "goes from robot map to string"
      (subject/robot->string {:cords [1 2] :direction "N"}) => "1 2 N")