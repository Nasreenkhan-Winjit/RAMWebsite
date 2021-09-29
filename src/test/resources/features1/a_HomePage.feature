@Test
Feature: Validating functionality of RAM website's Home Page

  Scenario:Validating navigation to home page of RAM website by clicking on HOME menu
    When User Click on Home menu
    Then User is on Home page

  Scenario:Validating navigation to Services page of RAM website by clicking on Services menu
    When User Click on Services menu
    Then User is on Services page

  Scenario:Validating navigation to Solutions page of RAM website by clicking on Solutions menu
    When User Click on Solutions menu
    Then User is on Solutions page

  Scenario:Validating navigation to Send a Parcel page of RAM website by clicking on Send a Parcel menu
    When User Click on Send a Parcel menu
    Then User is on Send a Parcel page

  Scenario:Validating navigation to Track your Parcel page of RAM website by clicking on Track your Parcel menu
    When User Click on Track your Parcel menu
    Then User is on Track your Parcel page

  Scenario:Validating navigation to Contact Us page of RAM website by clicking on Contact Us menu
    When User Click on Contact Us menu
    Then User is on Contact Us page

  Scenario: Verifying if alert box is display after user click on take a lot menu without login to the system
    When User Click on take a Lot menu
    And Display alert box "Please login first in order to use the Takealot service"

  Scenario: Verifying if login form is open after user accept login alert message displayed after clicking on take a lot menu
   # When User Click on take a Lot menu
    Given Display alert box "Please login first in order to use the Takealot service"
    When Accept alert box
    Then Login Form will open
   # And User close login form


  Scenario: Validating Click action on take a lot link with user logged in to system
    Given Enter email address "swati.winjit123@gmail.com"
    And Enter Password "Swati12345"
    And Click on Submit Button to submit login form
    And Wait for login form to be disappear
    When User Click on take a Lot link
    Then User is on take a lot-Start your Order page
    And Close current page
    And Click on username
    And Logged out

  Scenario: Validating Click action on Business Portal link
    When User click on Business Portal Link
    Then RAM Customer Portal page will open in next tab

  Scenario:Validating Click action on Login Link
    When User click on Login Link
    Then Login Form will open
    And User close login form

  Scenario: Validating Click action on Register Link
    When User click on Register link
    Then User registration page will open
    And User navigate to home page

  Scenario: Validating click action on Send a Parcel quick tool on home page
    Given User is on Home page
    When User click on Send a parcel quick tool
    Then User is on Send a Parcel page
    And User navigate to home page

  Scenario: Validating click action on Track Your Parcel quick tool on home page
    Given User is on Home page
    When User enter waybill number "RW20958630" in textbox of track your parcel quick tool
    And Click on Find Parcel
    Then User is on Track your Parcel page
    And User navigate to home page

  Scenario: Validating click action on contact us quick tool
    Given User is on Home page
    When User click on Contact Us quick tool
    Then User is on Contact Us page
    And User navigate to home page

  Scenario: Validating click action on Pharmaceutical Icon
    Given User is on Home page
    When user click on pharmaceutical Icon
    Then Pharmaceutical Solutions page should open
    And User navigate to home page

  Scenario: Validating click action on IT and Cellular Icon
    Given User is on Home page
    When user click on IT and Cellular Icon
    Then IT and Cellular Solutions page should open
    And User navigate to home page

  Scenario: Validating click action on Beauty and Cosmetics Icon
    Given User is on Home page
    When user click on Beauty and Cosmetics Icon
    Then Beauty and Cosmetics Solutions page should open
    And User navigate to home page

  Scenario: Validating click action on Financial Icon
    Given User is on Home page
    When user click on Financial Icon
    Then Financial Solutions page should open
    And User navigate to home page

  Scenario: Validating click action on Retail Icon
    Given User is on Home page
    When user click on Retail Icon
    Then Retail Solutions page should open
    And User navigate to home page

  Scenario: Validating click action on Explore Seamless Supply Chain Solutions Icon
    Given User is on Home page
    When user click on  Explore Seamless Supply Chain Solutions Icon
    Then Supply Chain Solutions page should open
    And User navigate to home page

