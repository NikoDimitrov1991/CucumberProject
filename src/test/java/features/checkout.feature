Feature: Search and Place an order for Products

  @PlaceOrder
  Scenario Outline: Search Experience for product search in both Home Page and Offers Page

    Given user is on GreenCard Landing page
    When user searched with shortname <Name> and extract actual name of product
    And Added "3" items of the selected product to cart
    Then User proceeds to Checkout and validate the <Name> items in checkout page
    And verify user has ability to enter promo code and place the order

    Examples:
      | Name |
      | Tom  |