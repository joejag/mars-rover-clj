(ns mars-rover.core
  (:gen-class))

(def compass-rotations
  {"N" {"L" "W", "R" "E"}
   "E" {"L" "N", "R" "S"}
   "S" {"L" "E", "R" "W"}
   "W" {"L" "S", "R" "N"}})

(defn compass-rotate [current-direction way-to-rotate]
  (get-in compass-rotations [current-direction way-to-rotate]))

(defn rotate [{:keys [cords direction]} way-to-rotate]
  {:cords cords :direction (compass-rotate direction way-to-rotate)})



(def cord-movers
  {"N" (fn [[x y]] [x       (inc y)])
   "E" (fn [[x y]] [(inc x) y])
   "S" (fn [[x y]] [x       (dec y)])
   "W" (fn [[x y]] [(dec x) y])})

(defn move [{:keys [cords direction]}]
  {:cords ((get cord-movers direction) cords) :direction direction})



(def commands
  {"M" (fn [robot _]         (move robot))
   "L" (fn [robot direction] (rotate robot direction))
   "R" (fn [robot direction] (rotate robot direction))})

(defn command-parser [robot command]
  ((get commands command (constantly robot)) robot command))



(defn command-robot [starting-robot commands]
  (reduce
    (fn [updated-robot command]
      (command-parser updated-robot command))
    starting-robot
    (clojure.string/split commands #"")))

(defn- string-to-robot [str]
  (let [splitted (clojure.string/split str #" ")
        x (Integer. (first splitted))
        y (Integer. (second splitted))
        direction (last splitted)]
    {:cords [x y] :direction direction}))

(defn- robot-to-string [{:keys [cords direction]}]
  (str (first cords) " " (second cords) " " direction))

(defn- go [robot-str commands]
  (robot-to-string
    (command-robot (string-to-robot robot-str) commands)))

(defn -main [& _]
  (println "On separate lines please enter: grid, 1st robot, commands, 2nd robot, commands")
  (let [_               (read-line)
        first-robot     (read-line)
        first-commands  (read-line)
        second-robot    (read-line)
        second-commands (read-line)]
    (println (go first-robot first-commands))
    (println (go second-robot second-commands))))