(use 'clojure.java.io)

(defn calculate-distance [list1 list2]
  (let [sorted1 (sort list1)
        sorted2 (sort list2)
        pairs (map vector sorted1 sorted2)
        differences (map #(Math/abs (- (first %) (second %))) pairs)]
    (reduce + differences)))

(defn read-input-file [file-path]
  (with-open [rdr (reader file-path)]
    (doall
      (map
        #(let [nums (map read-string (clojure.string/split % #" "))]
          [(first nums) (second nums)])
        (line-seq rdr)))))

(defn process-file []
  (let [entries (read-input-file "one-input.txt")
        left-list (map first entries)
        right-list (map second entries)]
    (println (calculate-distance left-list right-list))))

(process-file)
