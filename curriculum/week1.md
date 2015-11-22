## Week 1 - Intro

### Day 1

* Install the [Cursive](https://cursiveclojure.com/staging/userguide/) IntelliJ plugin
* Create hello-clojure
  * Create New Project -> Leiningen
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
    * `(count names)`
    * `(conj names "Daniel")`
  * Maps
    * `(def player {:name "Alice" :age 25})`
    * `(get player :name)`
    * `(assoc player :score 5)`
