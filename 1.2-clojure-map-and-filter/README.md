# Clojure Map and Filter

![screenshot](screenshot.png)

## Description

Read and parse the CSV file of purchase data. Allow the user to filter the list by typing in a category name.

## Requirements

* Create a project with `purchases.csv` in it
  * Create New Project -> Leiningen
  * Template: `app`
* Read the file and parse it into a vector of lines
* Split each line into vectors (delimited by commas)
* Separate the header from the rest of the lines
* Make each line a hash map that associates each item in the header with each item in the line
* Keywordize all the keys in the hash maps
* Ask the user to type a category
  * The possible categories are: Furniture, Alcohol, Toiletries, Shoes, Food, Jewelry
* Read a line of input from the user
* Filter the vector so it only contains hash maps whose category equals the input from the user
* Save the results into a file called `filtered_purchases.edn`
