@Test
Feature: Page Footer
  To verify footer links are working correctly and landing the correct page.

  Scenario: Validating click action on About Us link present at footer
    Given User is on Home page
    When user click on  About Us link
    Then RAM history page should open
    And User navigate to home page

  Scenario: Validating click action on No Sub-contracting link present at footer
    Given User is on Home page
    When user click on  NO Sub-Contracting link
    Then NO Sub-Contracting page should open
    And User navigate to home page

  Scenario: Validating click action on History link present at footer
    Given User is on Home page
    When user click on  History link
    Then RAM history page should open
    And User navigate to home page

  Scenario: Validating click action on Careers link present at footer
    Given User is on Home page
    When user click on Careers link
    Then RAM Career page should open
    And User navigate to home page

  Scenario: Validating click action on Local Courier Services link present at footer
    Given User is on Home page
    When user click on  Local Courier Services link
    Then RAM Local Services page should open
    And User navigate to home page

  Scenario: Validating click action on Special Courier Services link present at footer
    Given User is on Home page
    When user click on  Special Courier Services link
    Then RAM Special Services page should open
    And User navigate to home page

  Scenario: Validating click action on Distribution Services link present at footer
    Given User is on Home page
    When user click on  Distribution Services link
    Then RAM Distribution Services page should open
    And User navigate to home page

  Scenario: Validating click action on International Services link present at footer
    Given User is on Home page
    When user click on  International Services link
    Then RAM International Services page should open
    And User navigate to home page

  Scenario: Validating click action on Warehousing Services link present at footer
    Given User is on Home page
    When user click on  Warehousing Services link
    Then RAM Warehousing Services page should open
    And User navigate to home page

  Scenario: Validating click action on RAM's Standard Terms & Conditions of Service link present at footer
    Given User is on Home page
    When user click on RAM's Standard Terms & Conditions of Service link
    Then RAM's Standard Terms & Conditions of Service  document should open in new tab
    And User navigate to home page

  Scenario: Validating click action on RAM IT Platform Terms and Conditions link present at footer
    Given User is on Home page
    When user click on IT Platform Terms and Conditions link
    Then RAM IT Platform Terms and Conditions document should open in new tab
    And User navigate to home page

  Scenario: Validating click action on Legal Documents link present at footer
    Given User is on Home page
    When user click on Legal Documents link
    Then User is on Legal Documents
    And User navigate to home page

  Scenario: Validating click action on Contact Us link present at footer
    Given User is on Home page
    When user click on  Contact Us link
    Then User is on Contact Us page
    And User navigate to home page

  Scenario: Validating click action on Sales link present at footer
    Given User is on Home page
    When user click on  Sales link
    Then RAM Sales page should open
    And User navigate to home page

  Scenario: Validating click action on Payment Options link present at footer
    Given User is on Home page
    When user click on  Payment Options link
    Then RAM Payment Options page should open
    And User navigate to home page

  Scenario: Validating click action on Fuel Surcharge link present at footer
    Given User is on Home page
    When user click on  Fuel Surcharge link
    Then RAM Fuel Surcharge page should open
    And User navigate to home page

  Scenario: Validating click action on FAQs link present at footer
    Given User is on Home page
    When user click on  FAQs link
    Then RAM FAQ Services and Logistics page should open
    And User navigate to home page

  Scenario: Validating click action on Coronavirus ESP Certificate link present at footer
    Given User is on Home page
    When user click on  Coronavirus ESP Certificate link
    Then RAM Coronavirus ESP Certificate document should open in new tab
    And User navigate to home page

  Scenario: Validating if there any broken links present on legal documents page
    Given User is on Home page
    When user click on Legal Documents link
    And Click on every links to verify broken links
