Feature: Checkout product scenarios

  Background: Log in
    Given the homepage is opened
    Then we type 'standard_user' in the 'Username' input field
    And we type 'secret_sauce' in the 'Password' input field
    And click 'Login' button
    Then make sure user navigates to products page


  @Demo
  @04 @04.1
  Scenario:04.1 - Place a successful order
    And Add to Cart product 'Sauce Labs Backpack'
    Then shopping cart number is '1'
    Then click 'Shopping Cart' button
    Then make sure the following items are shown in the shopping cart
      | Sauce Labs Backpack |
    And click 'Checkout' button from cart page
    Then make sure user navigates to checkout step 1 page
    And click 'Cancel' button from checkout page
    Then make sure the following items are shown in the shopping cart
      | Sauce Labs Backpack |
    And click 'Checkout' button from cart page
    Then type 'Ledjon' in 'First Name' input field
    And type 'Cili' in 'Last Name' input field
    And type '5001' in 'Zip/Postal Code' input field
    Then  click 'Continue' button from checkout page
    Then make sure user navigates to checkout step 2 page
    Then click 'Finish' button from checkout page
    And check the following message is shown
      | Thank you for your order! |