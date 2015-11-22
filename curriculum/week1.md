## Week 1 - Intro

### Day 1

* Install the [Cursive](https://cursiveclojure.com/staging/userguide/) IntelliJ plugin
* Create hello-clojure
  * Create New Project -> Leiningen
  * Template: `app`
* Add "REPL" configuration
  * Edit Configurations... -> Add -> Clojure REPL -> Local
  * Name: `REPL`
* Use the REPL
  * Scalar variables
    * `(def score 1)`
    * `(+ score 1)`
    * `(def score (+ score 1))`
    * `(def health 100)`
    * `(def health (* health 0.75))`
    * `(def player-name "Alice")`
    * `(= score 1)`
    * `(not= score 1)`
    * `(= player-name "Bob")`
    * `(if (> score 0) "You won" "You lost")`
  * Vectors
    * `(def names ["Alice" "Bob" "Charlie"])`
    * `(get names 0)`
    * `(conj names "Daniel")`
    * `(count names)`
    * `(shuffle names)`
    * `(rand-nth names)`
  * Maps
    * `(def player {:name "Alice" :age 25})`
    * `(get player :name)`
    * `(assoc player :score 5)`
  * Loops
    * `(doseq [name names] (println name))`
  * Define a function
    * `(println "Hello, world!")`
    * `(format "Hello, %s!" (get player :name))`
    * `(defn say-hello [] (println "Hello, world!"))`
    * `(defn say-hello [& names] (doseq [name names] (println (format "Hello, %s!" name))))`
* Add "Run" configuration
  * Edit Configurations... -> Add -> Leiningen
  * Arguments: `run`
* Edit and run `core.clj`
