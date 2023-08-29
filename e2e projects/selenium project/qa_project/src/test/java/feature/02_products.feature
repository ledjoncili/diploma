Feature: Product details scenarios

  Background: Log in
    Given the homepage is opened
    Then we type 'standard_user' in the 'Username' input field
    And we type 'secret_sauce' in the 'Password' input field
    And click 'Login' button
    Then make sure user navigates to products page

  #@Demo
  @02 @02.1
  Scenario:02.1 - should navigate to product details page and return to product overview page
    Then click product with name 'Sauce Labs Backpack'
    Then make sure product 'name' is 'Sauce Labs Backpack'
    And make sure product 'details' is 'carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.'
    And make sure product 'price' is '$29.99'
    Then click 'Back to products' button from product details page
    Then make sure user navigates to products page

  #@Demo
  @02 @02.2
  Scenario:02.2 - should sort products by price (low to high)
    And select 'Price (low to high)' from filter dropdown
    Then make sure the products are sorted by 'Price (low to high)'