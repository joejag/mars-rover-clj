(ns mars-rover.core-test
  (:require [midje.sweet :refer :all]
            [mars-rover.core :as subject]))

(facts "compass directions"
       (tabular "can be rotated"
                (fact (subject/compass-rotate ?current-direction ?way-to-rotate) => ?new-direction)
                ?current-direction ?way-to-rotate ?new-direction
                "N"                 "L"           "W"
                "W"                 "L"           "S"
                "S"                 "L"           "E"
                "E"                 "L"           "N"

                "N"                 "R"           "E"
                "W"                 "R"           "N"
                "S"                 "R"           "W"
                "E"                 "R"           "S"))


