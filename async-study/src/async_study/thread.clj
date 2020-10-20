(ns async-study.thread
  (:require [clojure.core.async :refer [chan <!! >!! put! take!
                                        sliding-buffer
                                        dropping-buffer
                                        close!
                                        thread
                                        go
                                        >!
                                        <!]]))

(<!! (thread
       (println "Inside thread")
       42))

;;bad side-effect (memory)
(<!! (thread
       (let [t1 (thread "Thread 1")
             t2 (thread "Thread 2")]
         [(<!! t1)
          (<!! t2)])))

(let [c (chan)]
  (thread
    (dotimes [x 3]
      (>!! c x)
      (println "Put: " x)))
  (thread
    (dotimes [x 3]
      (println "Take: " (<!! c)))))

(let [c (chan)]
  (go (dotimes [x 3]
        (>! c x)
        (println "Put: " x)))
  (go (dotimes [x 3]
        (println "Take: " (<! c)))))