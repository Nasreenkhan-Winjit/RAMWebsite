@Test
Feature:Recover Password
  #Scenario: test
   # When user read mail

  Scenario: Verify if the forgot password link is working correctly and landing on the correct page.
    Given User is on Home page
    And User click on Login Link
    And Login Form will open
    And User click on Forgot Password
    Then Password Recovery page should open

  Scenario: Verify if the link to change the password is sent to the email id enter by user only.
   Given User is on Password Recovery page
   And User enter password recovery email address "swati.winjit123@gmail.com"
   And Click on Submit Button on password recovery page
   Then Notification msg should display
   And Link to change password is sent to email id enter by user

#  Scenario:test
 # And Link to change password is sent to user's email id
  #When User click on Reset Password link


  Scenario: Verify if the user is able to reset password by link sent to the user's email id.
    #Given Link to change password is sent to user's email id
    When User click on Reset Password link
    And User enter new password "Swati12345"
    And User reenter new password "Swati12345"
    And User click on submit button
    Then Password is reset and user is on password reset page
    And User navigate to home page


  Scenario:  Verify if the login is possible with the newly changed password.
    Given User is on Home page
    And User click on Login Link
    #And Login Form will open
    When Enter email address "swati.winjit123@gmail.com"
    And Enter Password "Swati12345"
    And Click on Submit Button to submit login form
    Then User "Swati" logged in
    And Click on username
    And Logged out
    And User navigate to home page
