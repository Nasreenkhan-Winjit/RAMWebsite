@Test
Feature: Validating functionality of Send A Parcel module.


  Scenario: Verify if user is able to fill customer service form and will able to send request successfuly with valid data.
    Given User click on Contact Us quick tool
    When User fill details in Customer Service Page
      | name            | SS                                    |
      | contact_number  | 1234567890                            |
      | email           | swati.winji123@gmail.com              |
      | tracking_number | 123                                   |
      | case_type       | Change Of Address                     |
      | details         | Demo query to check its functionality |
    And Click on Send button
    And Accept alert box

  Scenario: Verify if user is able to see tracking order details through contact Us page-for valid waybill
    Given User Click on Contact Us menu
    When User click on Track your parcel
    And User enter waybill number "RW20958630" in textbox of track your parcel
    And User click on submit waybill button
    Then User is on Track your Parcel page
    And shows the tracking details for waybill "RW20958630"

  Scenario: Verify if user is able to see tracking order details through contact Us page-for invalid/wrong waybill
    Given User Click on Contact Us menu
    When User click on Track your parcel
    And User enter waybill number "123" in textbox of track your parcel
    And User click on submit waybill button
    Then User is on Track your Parcel page
    And Display message "No results found"


  Scenario: Verify if user is able to see tracking order details through contact Us page-for blank waybill
    Given User Click on Contact Us menu
    When User click on Track your parcel
    And User enter waybill number " " in textbox of track your parcel
    And User click on submit waybill button
    Then User is on Track your Parcel page
    And Display message "Please enter a waybill number"

  Scenario: Verify if user is able to navigate to RAM sales page through Contact Us page
    Given user click on  Contact Us link
    When User click on  Sales
    Then RAM Sales page should open

  Scenario: Verify if user is able to navigate to RAM Careers page through Contact Us page
    Given user click on  Contact Us link
    When User click on Careers
    Then RAM Career page should open
    And User navigate to home page