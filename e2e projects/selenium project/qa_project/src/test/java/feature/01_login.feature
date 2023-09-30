Feature: Identifikimi dhe Hyrja e Përdoruesit

  #@Demo
  @01 @01.1
  Scenario: 01.1 - Unsuccessful Login - Wrong credentials
    Given the homepage is opened
    Then we type 'test' in the 'Username' input field
    And we type 'password' in the 'Password' input field
    And click 'Login' button
    Then make sure an error message with the following text is shown
      | Epic sadface: Username and password do not match any user in this service |

  #@Demo
  @01 @01.2
  Scenario: 01.2 - Successful Login
    Given the homepage is opened
    Then we type 'standard_user' in the 'Username' input field
    And we type 'secret_sauce' in the 'Password' input field
    And click 'Login' button
    Then make sure user navigates to products page

  #@Demo
  @01 @01.3
  Scenario: 01.3 - Log out
    Given the homepage is opened
    Then we type 'standard_user' in the 'Username' input field
    And we type 'secret_sauce' in the 'Password' input field
    And click 'Login' button
    Then make sure user navigates to products page
    And click 'Menu' button
    And click 'Logout' button
    Then make sure user navigates to login page