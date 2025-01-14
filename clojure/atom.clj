(def data
   [{:title "Getting started"
     :reset_lesson_position false
     :lessons [{:name "Welcome"}
               {:name "Installation"}]}
    {:title "Basic operator"
     :reset_lesson_position false
     :lessons [{:name "Addition / Subtraction"}
               {:name "Multiplication / Division"}]}
    {:title "Advanced topics"
     :reset_lesson_position true
     :lessons [{:name "Mutability"}
               {:name "Immutability"}]}])

(def lesson-position (atom 0))
(defn lessons [{:keys [lessons reset_lesson_position]}]
   (when reset_lesson_position (reset! lesson-position 0))
   (into [] (map #(assoc % :position (swap! lesson-position inc))) lessons))
(into [] (map-indexed #(assoc %2 :position (inc %1) :lessons (lessons %2))) data)
