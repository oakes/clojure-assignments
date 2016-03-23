# Clojure Web

![screenshot](screenshot.jpg)

## Description

Display the purchase data from the previous assignment in a webpage using ring, compojure, and hiccup.

## Requirements

* Add the necessary dependencies to project.clj
  * `[ring "1.4.0"]`
  * `[hiccup "1.0.5"]`
  * `[compojure "1.5.0"]`
* Move the code in your `-main` function to a separate function
* Create your `/` route and run jetty in your `-main` function
* In the `/` route, use hiccup to generate html that displays your purchase data
* Add links at the top to filter by category.
