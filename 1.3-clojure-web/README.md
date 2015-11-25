# Clojure Web

![screenshot](screenshot.jpg)

## Description

Display the purchase data from the previous assignment in a webpage using ring and hiccup.

## Requirements

* Add the necessary dependencies to project.clj
  * `[ring "1.4.0"]`
  * `[hiccup "1.0.5"]`
* Require `ring.adapter.jetty` and `hiccup.core` in your core.clj file
* Move the code in your `-main` function to a separate function
* Create your `handler` function and run jetty in your `-main` function
* In the `handler` function, use hiccup to generate html that displays your purchase data
