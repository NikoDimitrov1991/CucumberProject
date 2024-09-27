Feature: Search and Place an order for Products

Scenario: Search Experience for product search in both Home Page and Offers Page

Given user is on GreenCard Landing page
When user searched with shortname "Tom" and excract actual name of product
Then user search for same shortname in offers page to check if product exist