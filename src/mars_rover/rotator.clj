(ns mars-rover.rotator)

(def compass-rotation-results
  {"N" {"L" "W", "R" "E"}
   "E" {"L" "N", "R" "S"}
   "S" {"L" "E", "R" "W"}
   "W" {"L" "S", "R" "N"}})

(defn rotate-compass [current-direction way-to-rotate]
  (get-in compass-rotation-results [current-direction way-to-rotate]))

(defn rotate-robot [{:keys [cords direction]} way-to-rotate]
  {:cords cords :direction (rotate-compass direction way-to-rotate)})