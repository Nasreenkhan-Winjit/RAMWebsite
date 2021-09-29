@Test
Feature: Validating functionality of RAM Solution Page
  To verify links on solutions page are working correctly and landing the correct page.


  Scenario: Validating Click action on page sidebar link-Pharmaceutical Solutions.
   #Given User is on Home page
    When User Click on Solutions menu
    And User click on Pharmaceutical Solutions
    Then Pharmaceutical Solutions page should open

  Scenario: Verify if user is able to open Hand-to-Hand Pharmaceuticals document by clicking on link given in Pharmaceutical Solutions page
   # Given User is on Supply Chain Page
    # When User Click on Solutions menu
    When User click on link-Click here to download
    Then Hand-to-Hand Pharmaceuticals document should open in next tab


  Scenario: Validating Click action on page sidebar link-IT and Cellular Solutions.
  #  Given User is on Home page
   # When User Click on Solutions menu
    When User click on IT and Cellular Solutions
    Then IT and Cellular Solutions page should open

  Scenario: Validating Click action on page sidebar link-Retail Solutions.
  #  Given User is on Home page
   # When User Click on Solutions menu
    When User click on Retail Solutions
    Then Retail Solutions page should open

  Scenario: Verify if user is able to open Hand-to-Hand Retail document by clicking on link given in Retail Solutions page
   # Given User is on Supply Chain Page
    # When User Click on Solutions menu
    When User click on link-Click here to download
    Then Hand-to-Hand Retail document should open in next tab

  Scenario: Validating Click action on page sidebar link-Financial Solutions.
  #  Given User is on Home page
    #When User Click on Solutions menu
    When User click on Financial Solutions
    Then Financial Solutions page should open

  Scenario: Verify if user is able to open Hand-to-Hand Banking document by clicking on link given in Financial Solutions page
   # Given User is on Supply Chain Page
    # When User Click on Solutions menu
    When User click on link-Click here to download
    Then Hand-to-Hand Banking document should open in next tab

  Scenario: Validating Click action on page sidebar link-Beauty and Cosmetic Solutions.
  #  Given User is on Home page
    #When User Click on Solutions menu
    When User click on Beauty and Cosmetic Solutions
    Then Beauty and Cosmetics Solutions page should open

  Scenario: Validating Click action on page sidebar link-Business to Consumer.
  #  Given User is on Home page
   # When User Click on Solutions menu
    When User click on Business to Consumer
    Then Business to Consumer Solutions page should open

  Scenario: Verify if user is able to view Hand-to-Hand B2C document by clicking on link given in Business to Consumer page
    #Given User is on Business to Consumer Page
    # When User Click on Solutions menu
    When User click on link-Click here to download
    Then Hand-to-Hand BToC document should open in next tab


  Scenario: Validating Click action on page sidebar link-Supply Chain.
  #  Given User is on Home page
    # When User Click on Solutions menu
    When User click on Supply Chain
    Then Supply Chain Solutions page should open


  Scenario: Verify if user is able to open Contact Me form by clicking on link "Contact Me" given in Supply Chain page
   # Given User is on Supply Chain Page
    # When User Click on Solutions menu
    When User click on link-Contact Me
    Then Contact Me form should open
    And Contact Me form closed
    And User navigate to home page

