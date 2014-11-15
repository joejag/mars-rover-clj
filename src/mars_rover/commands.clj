(ns mars-rover.commands
  (:require [mars-rover.rotator :as compass]
            [mars-rover.mover :as mover]))

(def commands
  {"M" (fn [robot _] (mover/move robot))
   "L" (fn [robot direction] (compass/rotate-robot robot direction))
   "R" (fn [robot direction] (compass/rotate-robot robot direction))})

(defn command-parser [robot command]
  ((get commands command (constantly robot)) robot command))

(defn command-robot [starting-robot commands]
  (reduce
    (fn [updated-robot command]
      (command-parser updated-robot command))
    starting-robot
    (clojure.string/split commands #"")))
