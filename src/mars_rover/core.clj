(ns mars-rover.core)

(def compass-rotations
  {"N" {"L" "W", "R" "E"}
   "E" {"L" "N", "R" "S"}
   "S" {"L" "E", "R" "W"}
   "W" {"L" "S", "R" "N"}})

(defn compass-rotate [current-direction way-to-rotate]
  (get-in compass-rotations [current-direction way-to-rotate]))


(defn -main []
  (println "hi"))