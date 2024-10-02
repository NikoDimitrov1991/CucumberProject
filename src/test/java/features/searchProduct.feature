Feature: Search and Place an order for Products

  Scenario Outline: Search Experience for product search in both Home Page and Offers Page

    Given user is on GreenCard Landing page
    When user searched with shortname <Name> and extract actual name of product
    Then user search for <Name> shortname in offers page
    And validate product name in offers page matches with Landing Page

    Examples:
      | Name |
      | Tom  |
      | Beet |
