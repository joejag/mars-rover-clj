(ns mars-rover.commands
  (:require [mars-rover.rotator :as compass]
            [mars-rover.mover :as mover]))

(def available-commands
  {"M" (fn [robot _] (mover/move-robot robot))
   "L" (fn [robot direction] (compass/rotate-robot robot direction))
   "R" (fn [robot direction] (compass/rotate-robot robot direction))})

(defn command-executer [robot command]
  ((get available-commands command (constantly robot)) robot command))

(defn run-commands-on-robot [starting-robot commands]
  (reduce
    (fn [updated-robot command]
      (command-executer updated-robot command))
    starting-robot
    (clojure.string/split commands #"")))
