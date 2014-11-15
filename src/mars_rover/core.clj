(ns mars-rover.core
  (:require [mars-rover.commands :refer [run-commands-on-robot]]
            [mars-rover.robot-mapper :refer :all])
  (:gen-class))

(defn execute-commands [robot-str commands]
  (robot->string
    (run-commands-on-robot (string->robot robot-str) commands)))

(defn -main [& _]
  (println "On separate lines please enter: grid, 1st robot, commands, 2nd robot, commands")
  (let [_ (read-line)
        first-robot (read-line)
        first-commands (read-line)
        second-robot (read-line)
        second-commands (read-line)]
    (println (execute-commands first-robot first-commands))
    (println (execute-commands second-robot second-commands))))