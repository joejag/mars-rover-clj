(ns mars-rover.mover)

(def cord-movers
  {"N" (fn [[x y]] [x       (inc y)])
   "E" (fn [[x y]] [(inc x) y])
   "S" (fn [[x y]] [x       (dec y)])
   "W" (fn [[x y]] [(dec x) y])})

(defn move [{:keys [cords direction]}]
  {:cords ((get cord-movers direction) cords) :direction direction})
