@Test
Feature: Validating functionality of RAM Services Page


  Scenario: Validating Click action on Local Services to view the information of different Local courier services.
   # Given User is on Home page
    When User Click on Services menu
    And Click on Local Services
    Then RAM Local Services page should open
    #And User navigate to home page

  Scenario: Validating Click action on Special Services to view the information of different Special courier services.
 #   Given User is on Home page
  #  When User Click on Services menu
    When Click on Special Services
    Then RAM Special Services page should open
   # And User navigate to home page

  Scenario: Validating Click action on Distribution services to view the information of different Distribution services
    #Given User is on Home page
    # When User Click on Services menu
    When Click on Distribution Services
    Then RAM Distribution Services page should open
    # And User navigate to home page

  Scenario: Validating Click action on International Services to view the information of different International services
    # Given User is on Home page
    #When User Click on Services menu
    When Click on International Services
    Then RAM International Services page should open
    # And User navigate to home page

  Scenario: Validating Click action on Warehousing Services to view the information related to Warehousing services
    # Given User is on Home page
    # When User Click on Services menu
    When Click on Warehousing Services
    Then RAM Warehousing Services page should open
    # And User navigate to home page

  Scenario: Validating Click action on Fuel Surcharge to View the information related to Fuel Surcharge for current month
   # Given User is on Home page
    When User Click on Services menu
    When Click on Fuel Surcharge
    Then RAM Fuel Surcharge page should open
    # And User navigate to home page

  Scenario: Verifying if page displaying information of fuel surcharge rate is for current month
    # Given User is on Home page
    Given User is on Fuel Surcharge Page
    Then Get information of fuel surcharge rate for current month

  Scenario: Verifying whether firearm transport certificate of RAM should open after clicking link "click here to view our Firearm Transport Certificate"
  #  Given User is on Home page
    When User Click on Services menu
    And Click on Special Services
    And User click on link - Click here to view our Firearm Transport Certificate.
    Then Firearm Transport Certificate should open in next tab
    And User navigate to home page

  Scenario: Verifying whether  "RAM Standard Terms and Conditions" page should open after clicking link " RAMs Standard Terms and Conditions"
  #  Given User is on Home page
    When User Click on Services menu
    And Click on Special Services
    And User click on link - RAMs Standard Terms and Conditions.
    Then RAM's Standard Terms & Conditions of Service  document should open in new tab
    And User navigate to home page