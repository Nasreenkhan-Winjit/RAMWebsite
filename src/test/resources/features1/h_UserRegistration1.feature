
Feature: Verify User Registration Functionality of RAM.

  @ValidData
  Scenario Outline: Verify that the new Private user (Email-Address "<email>") registration is successful after passing the correct inputs.
    Given User is on Home page
    When User click on Register link
    And User enter details to register
      | usertype       | <usertype>       |
      | firstname      | <firstname>      |
      | surname        | <surname>        |
      | billingaddress | <billingaddress> |
      | propertytype   | <propertytype>   |
      | det1           | <det1>           |
      | det2           | <det2>           |
      | det3           | <det3>           |
      | det4           | <det4>           |
      | mobile         | <mobile>         |
      | telephone      | <telephone>      |
      | email          | <email>          |
      | password       | <password>       |
      | cpassword      | <cpassword>      |

    And User Click on Register Button
    Then User "<firstname>" registered and navigate to dashboard
    And Logged out
    Examples:
      | usertype | firstname | surname | billingaddress | propertytype | det1  | det2 | det3 | det4 | mobile     | telephone | email                   | password | cpassword |
      | Private  | Swati     | Thakare | Nashik, India  | Home         |       |      |      |      | 1234567890 | 1234      | someonep117@someone.com | abc123   | abc123    |
    #  | Private  | Swati     | Thakare | Nashik, India  | Residential Complex | abc         | 1    | 12   |      | 1234567890 | 1234      | someonep2@someone.com | abc123   | abc123    |
     # | Private  | Swati     | Thakare | Nashik, India  | Business     | abc         | 1    | 12   |      | 1234567890 | 1234      | someonep3@someone.com | abc123   | abc123    |
      #| Private  | Swati     | Thakare | Nashik, India  | Office Park  | park1       | 1    | 1    | 12   | 1234567890 | 1234      | someonep4@someone.com | abc123   | abc123    |
      #| Private  | Swati     | Thakare | Nashik, India  | Business     | abc         | 1    | 12   |      | 1234567890 | 1234      | someonep5@someone.com | abc123   | abc123    |
      | Private  | Swati     | Thakare | Nashik, India  | Office Park  | park1 | 1    | 1    | 12   | 1234567890 | 1234      | someonep118@someone.com | abc123   | abc123    |
      #| Private  | Swati     | Thakare | Nashik, India  | Hospital     | abchospital | 1    | 12   | 3    | 1234567890 | 1234      | someonep7@someone.com | abc123   | abc123    |

 # @ValidData
  Scenario Outline: Verify that the new Company user (Email-Address "<email>") registration is successful after passing the correct inputs.
  #  Given User is on Home page
    When User click on Register link
    And User enter details to register
      | usertype       | <usertype>       |
      | companyname    | <companyname>    |
      | vatNumber      | <vatNumber>      |
      | billingaddress | <billingaddress> |
      | propertytype   | <propertytype>   |
      | det1           | <det1>           |
      | det2           | <det2>           |
      | det3           | <det3>           |
      | det4           | <det4>           |
      | mobile         | <mobile>         |
      | telephone      | <telephone>      |
      | email          | <email>          |
      | password       | <password>       |
      | cpassword      | <cpassword>      |

    And User Click on Register Button
    Then User "<companyname>" registered and navigate to dashboard
    And Logged out
    Examples:
      | usertype | companyname | vatNumber | billingaddress | propertytype | det1 | det2 | det3 | det4 | mobile     | telephone | email                   | password | cpassword |
      | Company  | DemoCompany | 121       | Nashik, India  | Home         |      |      |      |      | 1234567890 | 1234      | someoneC117@someone.com | abc123   | abc123    |
      #| Company  | DemoCompany | 121       | Nashik, India  | Residential Complex | abc         | 1    | 12   |      | 1234567890 | 1234      | someonep2@someone.com | abc123   | abc123    |
      | Company  | DemoCompany | 121       | Nashik, India  | Business     | abc  | 1    | 12   |      | 1234567890 | 1234      | someoneC118@someone.com | abc123   | abc123    |
      #| Company  | DemoCompany | 121       | Nashik, India  | Office Park  | park1       | 1    | 1    | 12   | 1234567890 | 1234      | someonep4@someone.com | abc123   | abc123    |
      #| Company  | DemoCompany | abc       | Nashik, India  | Business     | abc         | 1    | 12   |      | 1234567890 | 1234      | someonep5@someone.com | abc123   | abc123    |
      #| Company  | DemoCompany | ab12      | Nashik, India  | Office Park  | park1       | 1    | 1    | 12   | 1234567890 | 1234      | someonep6@someone.com | abc123   | abc123    |
      #| Company  | DemoCompany | 12abc     | Nashik, India  | Hospital     | abchospital | 1    | 12   | 3    | 1234567890 | 1234      | someonep7@someone.com | abc123   | abc123    |


  @ValidData
  Scenario Outline: Verify that not filling the optional fields for Private User and clicking the Register button will still allow user to register without any validation error.
   # Given User is on Home page
    When User click on Register link
    And User enter details to register
      | usertype       | <usertype>       |
      | firstname      | <firstname>      |
      | surname        | <surname>        |
      | billingaddress | <billingaddress> |
      | propertytype   | <propertytype>   |
      | det1           | <det1>           |
      | det2           | <det2>           |
      | det3           | <det3>           |
      | det4           | <det4>           |
      | mobile         | <mobile>         |
      | telephone      | <telephone>      |
      | email          | <email>          |
      | password       | <password>       |
      | cpassword      | <cpassword>      |
    And User Click on Register Button
    Then User "<firstname>" registered and navigate to dashboard
    And Logged out
    Examples:
      | usertype | firstname | surname | billingaddress                                    | propertytype | det1 | det2 | det3 | det4 | mobile     | telephone | email                   | password | cpassword |
      | Private  | Swati     | Thakare | 21 Wrench Road, Glenlily, Cape Town, South Africa |              |      |      |      |      | 1234567890 |           | someonePWO4@someone.com | abc123   | abc123    |

  @ValidData
  Scenario Outline: Verify that not filling the optional fields for Company User and clicking the Register button will still allow user to register without any validation error.
   # Given User is on Home page
    When User click on Register link
    And User enter details to register
      | usertype       | <usertype>       |
      | companyname    | <companyname>    |
      | vatNumber      | <vatNumber>      |
      | billingaddress | <billingaddress> |
      | propertytype   | <propertytype>   |
      | det1           | <det1>           |
      | det2           | <det2>           |
      | det3           | <det3>           |
      | det4           | <det4>           |
      | mobile         | <mobile>         |
      | telephone      | <telephone>      |
      | email          | <email>          |
      | password       | <password>       |
      | cpassword      | <cpassword>      |
    And User Click on Register Button
    Then User "<companyname>" registered and navigate to dashboard
    And Logged out
    Examples:
      | usertype | companyname | vatNumber | billingaddress                                    | propertytype | det1 | det2 | det3 | det4 | mobile     | telephone | email                   | password | cpassword |
      | Company  | SDemo       |           | 21 Wrench Road, Glenlily, Cape Town, South Africa |              |      |      |      |      | 1234567890 |           | someoneCWO4@someone.com | abc123   | abc123    |


  @InvalidData
  Scenario: Verify that new Private user registration is unsuccessful after passing blank values in mandatory fields.
    #Given User is on Home page
    When User click on Register link
    And User enter details to register
      | usertype       | Private |
      | firstname      |         |
      | surname        |         |
      | billingaddress |         |
      | propertytype   |         |
      | det1           |         |
      | det2           |         |
      | det3           |         |
      | det4           |         |
      | mobile         |         |
      | telephone      |         |
      | email          |         |
      | password       |         |
      | cpassword      |         |

    And User Click on Register Button
    Then Get error for field "firstname"
    And Get error for field "surname"
    And Get error for field "billingAddress"
    And Get error for field "mobile"
    And Get error for field "email"
    And Get error for field "password"

  @InvalidData
  Scenario: Verify that new Company user registration is unsuccessful after passing blank values in mandatory fields.
    #Given User is on Home page
    When User click on Register link
    And User enter details to register
      | usertype       | Company |
      | companyname    |         |
      | vatNumber      |         |
      | billingaddress |         |
      | propertytype   |         |
      | det1           |         |
      | det2           |         |
      | det3           |         |
      | det4           |         |
      | mobile         |         |
      | telephone      |         |
      | email          |         |
      | password       |         |
      | cpassword      |         |

    And User Click on Register Button
    Then Get error for field "companyname"
   # And Get error for field "surname"
    And Get error for field "billingAddress"
    And Get error for field "mobile"
    And Get error for field "email"
    And Get error for field "password"
    And User not registered and is on user registration page
    And User navigate to home page


  @InvalidData
  Scenario: Verify if display error for field confirm password when user enter mismatched value for password and confirm password field.
    #Given User is on Home page
    When User click on Register link
    And User enter details to register
      | usertype       | Private                       |
      | firstname      | Swati                         |
      | surname        | Thakare                       |
      | billingaddress | Nashik                        |
      | propertytype   | Home                          |
      | det1           |                               |
      | det2           |                               |
      | det3           |                               |
      | det4           |                               |
      | mobile         | 1345                          |
      | telephone      |                               |
      | email          | someoneprivate342@someone.com |
      | password       | abc123                        |
      | cpassword      | abc                           |
    And User Click on Register Button
    Then Get error for field "confirmPassword"
   And User navigate to home page

  @InvalidData
  Scenario: Verify if display error for field confirm password when user enter mismatched value for password and confirm password field.
    #Given User is on Home page
    When User click on Register link
    And User enter details to register
      | usertype       | Company                       |
      | companyname    | SwatiDemoCompany              |
      | vatNumber      |                               |
      | billingaddress | Nashik                        |
      | propertytype   | Home                          |
      | det1           |                               |
      | det2           |                               |
      | det3           |                               |
      | det4           |                               |
      | mobile         | 1345                          |
      | telephone      |                               |
      | email          | someonecompany342@someone.com |
      | password       | abc123                        |
      | cpassword      | abc                           |
    And User Click on Register Button
    Then Get error for field "confirmPassword"
    And User navigate to home page

  @InvalidData
  Scenario Outline: Verify if email field gets error when user enter "<email>" email  address and submit form.
    #Given User is on Home page
    When User click on Register link
    And User enter details to register
      | usertype       | <usertype>                                        |
      | firstname      | Swati                                             |
      | surname        | Thakare                                           |
      | billingaddress | 21 Wrench Road, Glenlily, Cape Town, South Africa |
      | propertytype   | Home                                              |
      | det1           |                                                   |
      | det2           |                                                   |
      | det3           |                                                   |
      | det4           |                                                   |
      | mobile         | 23                                                 |
      | telephone      |                                                   |
      | email          | <email>                                           |
      | password       | abc123                                            |
      | cpassword      | abc123                                            |
    And User Click on Register Button
    Then Get error for field "email"
    And User navigate to home page
    Examples:
      | usertype | email   |
      #| Private  | test,123@test.com |
      | Private  | test@t  |
      | Private  | abc@com |
      #| Private  | abc<abc@12.com  |
      #| Private  | 123@12..abctest |
      #| Private  | abc"abc"@12.com   |
      #| Private  | abc?abc'@12.com |
      #| Private  | abc/abc'@12.com |
      #| Private  | abc(abc)@12.com |
      #| Private  | pqr[abc]@12.com |


#  @InvalidData
 # Scenario Outline: Verify if mobile number field gets error when user enter "<mobile>" mobile number and submit form.
    #Given User is on Home page
  #  When User click on Register link
   # And User enter details to register
    #  | usertype       | <usertype>                                        |
     # | firstname      | Swati                                             |
      #| surname        | Thakare                                           |
      #| billingaddress | 21 Wrench Road, Glenlily, Cape Town, South Africa |
      #| propertytype |                           |
      #| det1      |                           |
      #| det2      |                           |
      #| det3      |                           |
      #| det4      |                           |
      #| mobile    | <mobile>                  |
      #| telephone |                           |
      #| email     | swati.winjit123@gmail.com |
      #| password  | abc123            |
      #| cpassword | abc123            |
    #And User Click on Register Button
    #Then Get error for field "mobile"
    # And User navigate to home page
    #Examples:
     # | usertype | mobile         |
#      | Private  | 123                        |
 #     | Private  | abc                        |
  #    | Private  | @@@@@@@                    |
   #   | Private  | @#$%^&*()                  |
    #  | Private  | abcderfgtaaaaaaaaaaaaaaaaa |
     # | Private  | ;';';,./?      |
      #| Private  | 1                 |
      #| Private  | ;                 |
      #| Private  | \\\\\\\*          |
      #| Private  | !@#$%^&*(){}[]    |


  @InvalidData
  Scenario: Verify if user is able to register with already registered email id
     #Given User is on Home page
    When User click on Register link
    And User enter details to register
      | usertype       | Private                                           |
      | firstname      | Swati                                             |
      | surname        | Thakare                                           |
      | billingaddress | 21 Wrench Road, Glenlily, Cape Town, South Africa |
      | propertytype   | Home                                              |
      | det1           |                                                   |
      | det2           |                                                   |
      | det3           |                                                   |
      | det4           |                                                   |
      | mobile         | 1234567890                                        |
      | telephone      |                                                   |
      | email          | swati.winjit123@gmail.com                         |
      | password       | abc123                                            |
      | cpassword      | abc123                                            |
    And User Click on Register Button
    Then Get toaster message "Registration was not successful Email address already registred."

  Scenario: Reopen the application
    Given Close the application
    And Open Application
