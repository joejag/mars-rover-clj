(ns mars-rover.mover-test
  (:require [midje.sweet :refer :all]
            [mars-rover.mover :as subject]))

(tabular "move x y cordinate based off compass direction"
         (fact (subject/move-robot {:cords [1 1] :direction ?direction}) => {:cords ?new-cords :direction ?direction})
         ?direction ?new-cords
         "N" [1 2]
         "E" [2 1]
         "S" [1 0]
         "W" [0 1])
