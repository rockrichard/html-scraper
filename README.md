# Project: Sainsburys HTML Scaper

* Sainsburys Software Engineering Test
* Author: Richard Ho

## Installation

* In project directory:
* > mvn clean install

## Usage

* Ensure you follow Installation step above.
* > cd target
* > java -jar scraper-1.0-SNAPSHOT.jar

## Tests

> mvn test

## Dependencies

* jsoup
* jackson
* slf4j
* junit

## Java Package Layout
+ com.sainsburys
    + scraper
        + helpers: (contains helper classes)
            - ProductHtmlHelper.java (css locators for parsing product HTML pages)
        + model: (contains value objects and interfaces)
            - Product (Product value object)
            - Results (Output value object, it contains a list of Product and the total)
        - HtmlScraper.java (java main)
    + utils (contains common utils to be shared between different components)
        - JsonUtils 

