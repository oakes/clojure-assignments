## Week 1 - Intro

### Day 1

* Overview of programming languages
  * Major syntax families
    * C (Java, JavaScript)
      * `int score = 1;`
      * `sayHello("Alice");`
      * `if (isDone) { sayHello("Alice"); }`
    * Lisp (Scheme, Clojure)
      * `(def score 1)`
      * `(say-hello "Alice")`
      * `(if is-done? (say-hello "Alice"))`
    * ML (Haskell, F#)
  * Major paradigms
    * Procedural: `add(nameList, "Charlie")`
    * Object-Oriented: `nameList.add("Charlie")`
    * Functional: `nameList = add(nameList, "Charlie")`
  * Java is an *object-oriented* language in the *C* family
  * Clojure is a *functional* language in the *Lisp* family
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
  * Sets
    * `(def unique-names #{"Alice" "Bob" "Charlie"})`
    * `(conj unique-names "Alice")`
  * Lists
    * All functions are simply lists of data
    * To prevent the function from running, you must quote it
    * `(def names-list '("Alice" "Bob" "Charlie"))`
    * `(conj names-list "Daniel")`
  * Print strings and loop over vector
    * `(println "Hello, world!")`
    * `(doseq [name names] (println name))`
    * `(format "Hello, %s!" (get player :name))`
    * `(doseq [name names] (println (format "Hello, %s!" name)))`
  * Define a function
    * `(fn [name] (println (format "Hello, %s!" name)))`
    * `(def say-hello (fn [name] (println (format "Hello, %s!" name))))`
    * `(defn say-hello [name] (println (format "Hello, %s!" name)))`
    * `(defn say-hello [& names] (doseq [name names] (println (format "Hello, %s!" name))))`

### Day 2

* Create to-do-clojure
  * Add "Run" configuration
    * Edit Configurations... -> Add -> Leiningen
    * Arguments: `run`
    * Check "Use trampoline"
  * Open `core.clj`
  * Create `atom`
  * Create `let` that adds the result of `read-line` to the atom
  * Use a `loop` to continuously read until `q` is pressed
  * Use a `doseq` to print out the results
  * Save the to-do list to a file
* Create people-clojure
  * Add "REPL" configuration
    * Edit Configurations... -> Add -> Clojure REPL -> Local
    * Name: `REPL`
  * Read the file and split it into lines
  * Split each line by commas
  * Pull out the header row
  * Map over the people to interleave the header into them
  * Turn all the people into hash-maps
  * Keywordize the keys
  * Filter out only people from a certain country

### Day 3

* Open people-clojure
  * Display people in HTML
    * Dependencies
      * `[ring "1.4.0"]`
      * `[hiccup "1.0.5"]`
    * Create a handler function that returns:
      * `{:status 200 :headers {"Content-Type" "text/html"} :body "Hello World"}`
    * Require `ring.adapter.jetty`
    * In the main function, run:
      * `(jetty/run-jetty handler {:port 3000 :join? false})`
    * Require `hiccup.core`
    * Use `hiccup/html` to generate html
* Functional programming in Java
