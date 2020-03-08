; parsing console params
(def input-array (vec (map read-string (vec *command-line-args*))))

; development
(defn my-sort [array]
  (loop [input {:sorted-array array
                :has-changes true}]
    (if (get input :has-changes)
      (recur
        (loop [i 0
               new-array (get input :sorted-array)
               has-changes false]
          (if (< i (- (count array) 1))
            (recur
              (inc i)
              (if (> (get new-array i) (get new-array (+ i 1)))
                (assoc new-array
                  (+ i 1) (get new-array i)
                  i (get new-array (+ i 1)))
                new-array)
              (or has-changes (> (get new-array i) (get new-array (+ i 1)))))
            {:sorted-array new-array
             :has-changes has-changes})))
      (get input :sorted-array))))

; test
(println input-array "->" (my-sort input-array))
