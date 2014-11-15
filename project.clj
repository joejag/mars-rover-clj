(defproject mars-rover "0.1.0"
            :dependencies [[org.clojure/clojure "1.6.0"]
                           [midje "1.6.3"]]
            :plugins [[lein-midje "3.1.1"]]
            :main mars-rover.core
            :aot [mars-rover.core])
