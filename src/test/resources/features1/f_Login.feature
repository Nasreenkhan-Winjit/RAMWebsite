@Test
Feature: Validate User Login Functionality

  Scenario: Verify that the user is able to login by entering valid credentials and clicking on the ‘Login’ button.
    Given User is on Home page
    And User click on Login Link
    And Login Form will open
    When Enter email address "swati.winjit123@gmail.com"
    And Enter Password "Swati12345"
    And Click on Submit Button to submit login form
    Then User "Swati" logged in
    And Click on username
    And Logged out

  Scenario: Verify that as soon as the login page opens, by default the cursor should remain on the username textbox.
    Given User is on Home page
    And User click on Login Link
    When Login Form will open
    Then Mouse cursor is on email address textbox.
    And User close login form

  Scenario: Check if the password is in masked form when typed in the password field.
    Given User is on Home page
    And User click on Login Link
    When Login Form will open
    And Enter Password "abc123"
    Then Shows password in masked format
    And User close login form

 # Scenario: Verify that the user is able to navigate or access the different controls by pressing the ‘Tab’ key on the keyboard.


  Scenario: Check that the user is not able to login with an invalid username.
    Given User is on Home page
    And User click on Login Link
    And Login Form will open
    When Enter email address "swati111.winjit123@gmail.com"
    And Enter Password "Swati@123"
    And Click on Submit Button to submit login form
    Then Get toaster message "Invalid credentials, Please check details and try again later."
    And User not logged in
    And User close login form

  Scenario: Check that the user is not able to login with an valid email and invalid password.
    Given User is on Home page
    And User click on Login Link
    And Login Form will open
    When Enter email address "swatithakare@winjit.com"
    And Enter Password "Swati@123"
    And Click on Submit Button to submit login form
    Then Get toaster message "Invalid credentials, Please check details and try again later."
    And User not logged in
    And User close login form


  Scenario: Verify that the validation message gets displayed in case the user leaves the Email Address  or Password field as blank.
    Given User is on Home page
    And User click on Login Link
    And Login Form will open
    When Enter email address ""
    And Enter Password "abc12345"
    And Click on Submit Button to submit login form
    Then Display validation message
    And User close login form
    And User navigate to home page



