(ns async-study.core
  (:require [clojure.core.async :refer [chan <!! >!! put! take!
                                        sliding-buffer
                                        dropping-buffer
                                        close!]]))
;
;(defn channels []
;  ;;must comum way to create a channel simple FIFO (first in first out)
;  (let [c (chan)]
;    ;;puts values in chan (FIFO)
;    (future (dotimes [x 10]
;              (>!! c x)))
;
;    (future (dotimes [x 10]
;              (>!! c x)))
;
;    ;;pop values from chan
;    (future (dotimes [x 20]
;              (println (<!! c))))))
;
;(channels)
;
;;;put value and take value from chan
;(let [c (chan)]
;  (put! c 42 (fn [v] (println "Sent: " v)))
;  (take! c (fn [v] (println "Got: " v))))
;
;;;chann with a buffer size 1
;;;
;(let [c (chan 3)]
;  (future
;    (dotimes [x 3]
;      (>!! c x)
;      (println "Sent : " x))
;    (println "done"))
;  (future
;    (dotimes [x 3]
;      (println "Got:" (<!! c)))))
;
;
;
;(let [c (chan (dropping-buffer 2))]
;  (future
;    (dotimes [x 3]
;      (>!! c x)
;      #_(println "Sent : " x)
;      )
;    #_(println "done")
;    )
;  (future
;    (dotimes [x 3]
;      (println "Got:" (<!! c)))
;    (println "done getting")))
;
;
;
;(let [c (chan (sliding-buffer 2))]
;  (future
;    (dotimes [x 3]
;      (>!! c x)
;      (println "Sent : " x))
;    (println "done"))
;  (future
;    (dotimes [x 3]
;      (println "Got:" (<!! c)))
;    (println "done getting")))
;
;
;;;;Close a channels
;(let [c (chan)]
;  (future
;    (dotimes [x 2]
;      (>!! c x))
;    (close! c)
;    (println "Closed."))
;  (future
;    (loop []
;      (when-some [v (<!! c)]
;        (println "Got: " v)
;        (recur)))
;    (println "Exiting")))
;
