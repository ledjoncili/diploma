Feature:03 - Shporta e Blerjeve

  Background: Log in
    Given the homepage is opened
    Then we type 'standard_user' in the 'Username' input field
    And we type 'secret_sauce' in the 'Password' input field
    And click 'Login' button
    Then make sure user navigates to products page

  #@Demo
  @03 @03.1
  Scenario:03.1 -Add and delete products into shopping cart
    And Add to Cart product 'Sauce Labs Onesie'
    Then shopping cart number is '1'
    Then click 'Shopping Cart' button
    Then make sure the following items are shown in the shopping cart
      | Sauce Labs Onesie |
    Then remove 'Sauce Labs Onesie' from shopping cart
    And click 'Continue Shopping' button from cart page
    Then make sure user navigates to products page
    And Add to Cart product 'Sauce Labs Bike Light'
    And Add to Cart product 'Sauce Labs Onesie'
    Then shopping cart number is '2'
    Then click 'Shopping Cart' button
    Then make sure the following items are shown in the shopping cart
      | Sauce Labs Bike Light |
      | Sauce Labs Onesie     |