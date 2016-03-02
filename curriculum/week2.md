## Week 2 - Recursion and Parallelism

### Day 1

* Difference between Java and Clojure `for` loops
* Review the four primary data structures (vector, map, list, set)
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

* Parallelism
  * Clojure `pmap` and `pvalues`
  * Java `parallelStream`
  * Caveat: Amdahl's law
* Create [ants-clojure](../projects/ants-clojure)
  * `(def ant-count 100)`
  * `(def ants (atom nil))`
  * `create-ants` returns a list of maps with random `:x` and `:y` fields
  * Call `(reset! ants (create-ants))` before the timer is started
  * `draw-ants` takes a `context`
    * Run `clearRect` to clear the screen
    * `doseq` over the ants
      * `(.setFill context Color/BACK)`
      * `(.fillOval context (:x ant) (:y ant) 5 5)`
  * Run `draw-ants` in the timer
  * `random-step` returns a number between -1 and 1
  * `move-ant` takes an `ant` and `assoc`es a new `:x` and `:y` changed by `(random-step)`
  * Before drawing the ants, run `(reset! ants (map move-ant (deref ants)))`
  * `(def last-timestamp (atom 0))`
  * `fps` takes a `now` and returns the frames per second
    * Calculate the difference between `now` and `last-timestamp`
    * Divide by `1000000` to get milliseconds
    * Divide into `1000` to get frames per second
  * Display the frames per second: `(.setText fps-label (str (fps now)))`
  * Add `(Thread/sleep 1)` to `move-ant` and use `pmap` to improve performance
* Create [Ants](../projects/Ants)
  * `static final int ANT_COUNT = 100;`
  * Define `Ant` class with `double x` and `double y`
  * Define `ArrayList<Ant> ants` and the `createAnts` method
  * `createAnts` returns an `ArrayList<Ant>`
  * Call `createAnts` before the timer is started
  * `drawAnts` takes `ArrayList<Ant> ant, GraphicsContext context`
  * `randomStep` returns a number between -1 and 1
  * `moveAnt` takes an `Ant ant`, changes its position by `randomStep()`, and returns it
  * `updateAnts` maps over the `ArrayList<Ant>` with `moveAnt`
  * Before drawing the ants, run `updateAnts`
  * `long lastTimestamp = 0;`
  * `fps` takes a `long now` and returns the frames per second
    * Calculate the difference between `now` and `lastTimestamp`
    * Divide by `1000000` to get milliseconds
    * Divide into `1000` to get frames per second
  * Display the frames per second: `fpsLabel.setText(fps(now) + "");`
  * Add `Thread.sleep(1)` to `moveAnt` and use `parallelStream` to improve performance
