(ns mars-rover.robot-factory)

(defn string->robot [str]
  (let [splitted (clojure.string/split str #" ")
        x (Integer. (first splitted))
        y (Integer. (second splitted))
        direction (last splitted)]
    {:cords [x y] :direction direction}))

(defn robot->string [{:keys [cords direction]}]
  (str (first cords) " " (second cords) " " direction))
