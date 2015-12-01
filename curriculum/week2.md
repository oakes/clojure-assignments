## Week 2 - Recursion and Java Interop

### Day 1

* Review assignment (clojure web - ring and hiccup)
* Difference between Java and Clojure `for` loops
* Review the four primary data structures (vector, map, list, set)
* Create [cards-clojure](../projects/cards-clojure)
  * Create Run and REPL configurations
  * Make a `def` for suits and ranks
  * `create-deck` returns a deck of cards
  * `rank-names` associates numbers to card names
  * `create-hands` returns all possible combinations
  * `flush?` returns true if the hand is a flush
  * Write a test for the `flush?` function
* Create [Cards](../projects/Cards)
  * Create `Card` class
  * Define `Suit` and `Rank` enums
  * `createDeck` returns a deck of cards
  * Test the `HashSet` from `createDeck`
    * Override `equals` and `hashCode` in `Card` so the `HashSet` works
  * `createHands` returns all possible combinations
  * `isFlush` returns true if the hand is a flush
* Benchmark the two projects

### Day 2

* Review assignment (clojure review - cards)
* Recursion
  * Running a function inside itself
  * Use instead of normal `for` loop if you want to control when the loop continues and update its values
  * `(loop [num 0] (if (< num 10) (recur (inc num)) num))`
* Create [maze-clojure](../projects/maze-clojure)
  * Define `size`
  * `create-rooms` returns a vector of vectors containing maps for each room
  * `-main` calls `create-rooms` in a `let` and prints out the maze
  * `possible-neighbors` returns a vector of rooms
  * `random-neighbor` takes `rooms row col`
    * Filter `possible-neighbors` so they are not nil and not visited
    * Use `rand-nth` to return a random neighbor if there is at least one neighbor
  * `tear-down-wall` takes `rooms old-row old-col new-row new-col`
    * `(> new-row old-row) ; going down`
    * `(> new-col old-col) ; going right`
    * `(< new-row old-row) ; going up`
    * `(< new-col old-col) ; going left`
  * `create-maze` takes `rooms row col`
    * Add `:visited? true` to the room and assoc it into the rooms
    * Get `random-neighbor`
    * If it isn't nil, run `tear-down-wall` and create a `loop` that calls `create-maze` until it stops returning new rooms
* Create [Maze](../projects/Maze)
  * Create `Room` class with `row, col, wasVisited, hasBottom, hasRight`
  * Define `size`
  * `createRooms` returns an `ArrayList` of `ArrayList` containing objects for each room
  * `main` calls `createRooms` and prints out the maze
  * `possibleNeighbors` returns an `ArrayList` of rooms
    * Add `if` statements to prevent out of bounds exception
  * `randomNeighbor` takes `ArrayList<ArrayList<Room>> rooms, int row, int col`
    * Filter `possible-neighbors` so they are not visited
    * Use `Random` to return a random neighbor if there is at least one neighbor
  * `tearDownWall` takes `Room oldRoom, Room newRoom`
  * `createMaze` takes `ArrayList<ArrayList<Room>> rooms, Room room` and returns a `boolean`
    * Set `room.hasVisited` to true
    * Get `randomNeighbor`
    * If it is null, return false
    * Otherwise, run `tearDownWall`, run `createMaze` in a while loop and then return true

### Day 3

* Review assignment
* Lists
  * Fast at prepending
  * Lazy sequences
    * The functional alternative to using `break` to get out of a loop
    * `(def nums (map inc [1 2 3])) ; inc hasn't run yet!`
    * `(first nums) ; (inc only ran once)`
    * `(def all-nums (range)) ; (0 1 2 3 4 …)`
    * `(def all-evens (filter even? all-nums)) ; (0 2 4 6 …)`
    * `(take 5 all-evens) ; (0 2 4 6 8)`
    * `(take-while #(< % 10) all-nums) ; (0 1 2 3 4 5 6 7 8 9)`
* Parallelism
  * Clojure `pmap` and `pvalues`
  * Java `parallelStream`
  * Caveat: Amdahl's law
* Java interop with Clojure
* Return JSON instead of HTML in Clojure
* Deploying to a server

### Day 4

* Review assignment
* Wrap up
