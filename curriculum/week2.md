## Week 2 - Parallelism and Java Interop

### Day 1

* Review assignment (clojure web - ring and hiccup)
* Difference between Java and Clojure `for` loops
* Review the four primary data structures (vector, map, list, set)
* Create cards-clojure
  * Create Run and REPL configurations
  * Make a `def` for suits and ranks
  * `create-deck` returns a deck of cards
  * `rank-names` associates numbers to card names
  * `create-hands` returns all possible combinations
  * `flush?` returns true if the hand is a flush
  * Write a test for the `flush?` function
* Create Cards
  * Create `Card` class
  * Define `Suit` and `Rank` enums
  * `createDeck` returns a deck of cards
  * Test the `HashSet` from `createDeck`
    * Override `equals` and `hashCode` in `Card` so the `HashSet` works
  * `createHands` returns all possible combinations
  * `isFlush` returns true if the hand is a flush
* Benchmark the two projects

### Day 2

* Review assignment
* Java interop with Clojure
* Return JSON instead of HTML in Clojure
* Contrast Java streams and traditional loops in solving problems

### Day 3

* Review assignment
* Review web app development in Clojure and Java
* Deploying to a server

### Day 4

* Review assignment
* Wrap up