
Feature: Validating functionality of Take A Lot module.

  Scenario: Verify if toaster message displays when user enters invalid credentials for login
    Given User is on Home page
    When User Click on take a Lot menu
    Then Display alert box "Please login first in order to use the Takealot service"
    And Accept alert box
  #  And User click on Login Link
    Then Login Form will open
    And Enter email address "swati.winjit123@gmail.com"
    And Enter Password "Swati12"
    And Click on Submit Button to submit login form
    Then Get toaster message "Invalid credentials, Please check details and try again later."

  Scenario: Verify if user is not able to complete Step-1 "Start your order" with blank data in all fields
    Given Login Form is open
    When Enter email address "swati.winjit123@gmail.com"
    And Enter Password "Swati12345"
    And Click on Submit Button to submit login form
    Then User "Swati" logged in
    And User Click on take a Lot link
    And User is on take a lot-Start your Order page
    When Click on TAL Next button
    Then Get error for TAL parcelContent field = "Yes"
    And Get error for TAL collection address field= "Yes"
    And Get error for Take a lot destination field "Yes"
    And Get error for TAL PO Number field ="Yes"


  Scenario: Verify if user is not able to select prohibited item for field parcel content
    #Given User click on step "1"
    When Select Prohibited parcelContent
    And Enter TAL collection address as "21 Wrench Road, Isando, Kempton Park, South Africa"
    And Select Take a lot destination as "TAKEALOT CAPE TOWN WAREHOUSE"
    And Enter PO Number as "PO63215123"
    And Click on TAL form
    When Click on TAL Next button
    Then Get error for TAL parcelContent field = "Yes"


  Scenario: Verify if alert box displays when user not enter unique PO number
    Given User click on step "1"
    When Select TAL parcelContent as "No"
    And Enter TAL collection address as "21 Wrench Road, Isando, Kempton Park, South Africa"
    And Select Take a lot destination as "TAKEALOT CAPE TOWN WAREHOUSE"
    And Enter PO Number as "PO11111111"
    And Click on TAL form
    Then Get error toaster message "PONumber has to be unique."
    And Get error for TAL PO Number field ="Yes"

  Scenario: Verify if user is able to complete step-1 to land on parcel dimensions page with valid data
    Given User click on step "1"
    When Select TAL parcelContent as "No"
    And Enter TAL collection address as "21 Wrench Road, Isando, Kempton Park, South Africa"
    And Select Take a lot destination as "TAKEALOT CAPE TOWN WAREHOUSE"
    And Enter PO Number as "PO12311123"
    And Click on TAL form
    And Click on TAL Next button
    Then Step TAL "Start Your Order" completed

  Scenario Outline: Verify if user is not able to complete TAL Parcel Dimensions step for out of range value
    Given Step TAL "Start Your Order" completed
    When Select TAL "Parcel 1" to enter details as
    And TAL Parcel 1 Weight= "<parcelWeight>"
    And TAL Parcel 1 Length= "<parcelLength>"
    And TAL Parcel 1 Width= "<parcelWidth>"
    And TAL Parcel 1 Height= "<parcelHeight>"
    And Click on TAL Next button
    Then Get error in TAL Parcel 1 Weight "<error_parcelWeight>"
    And Get error in TAL Parcel 1 Lenght "<error_parcelLength>"
    And Get error in TAL Parcel 1 Width "<error_parcelWidth>"
    And Get error in TAL Parcel 1 Height "<error_parcelHeight>"
    Examples:
      | parcelWeight | parcelLength | parcelWidth | parcelHeight | error_parcelWeight | error_parcelLength | error_parcelWidth | error_parcelHeight |
      | 0.1          | 9            | 10          | 1            | No                 | Yes                | No                | Yes                |
      | 30           | 121          | 9           | 61           | No                 | Yes                | Yes               | Yes                |
      | 0            | 10           | 61          | 2            | Yes                | No                 | Yes               | No                 |
      | 31           | 120          | 11          | 60           | Yes                | No                 | No                | No                 |
      |              |              |             |              | Yes                | yes                | yes               | yes                |


  Scenario: Verify if user navigate to previous page by clicking on Back button
    Given User is on TAL "Parcel Dimensions" step
    When Click on TAL Back button
    Then User is navigate to TAL Start you order

  Scenario: Scenario: Verifying if system works properly for different operations on "Select Your Service" page and then complete Step 3 "Select Your Service"
    Given User click on step "1"
    When Select TAL parcelContent as "No"
    And Enter TAL collection address as "21 Wrench Road, Isando, Kempton Park, South Africa"
    And Select Take a lot destination as "TAKEALOT CAPE TOWN WAREHOUSE"
    And Enter PO Number as "PO12311123"
    And Click on TAL form
    And Click on TAL Next button
    Then Step TAL "Start Your Order" completed
  #Scenario: Verifying if user is able to complete step 2 "Parcel Dimensions" with valid data
    When Select TAL parcel count as "1 Parcel"
    And Select TAL "Parcel 1" to enter details as
    And TAL Parcel 1 Weight= "1"
    And TAL Parcel 1 Length= "11"
    And TAL Parcel 1 Width= "12"
    And TAL Parcel 1 Height= "31"
    And Click on TAL Next button
    Then Step TAL "Parcel Dimensions" completed

   And User is on take a lot-Select Your Serice page
     When Select TAL default service type
     Then TAL Confirm window opens
     When Click on TAL Change button
     Then TAL Confirm window is disappear
     And User is on take a lot-Select Your Serice page
     When Select TAL default service type
     Then TAL Confirm window opens
     When Click on TAL Confirm close button
     Then TAL Confirm window is disappear
     And User is on take a lot-Select Your Serice page
     When Select TAL default service type
     Then TAL Confirm window opens
     When Click on Confirm button
    Then Step TAL "Select Your Service" completed

  Scenario: Verify if user is navigated back to TAL address page by clicking on Edit address
  # details of the person from collect parcel
    Given TAL Address page is opened
    When Use registration details is "Yes"
    And Collection_Property type="Home"
    And Collection_address="24 Wrench Road, Isando, Kempton Park, South Africa"
    And Click on Submit button
    Then TAL Confirm page get opened
#   Given TAL Confirm page is opened
    When Click on Edit Address Button
    Then User navigate to TAL Address page

  Scenario: Verify if payment type selection error message displayed when user submit form without selecting payment method
     Given TAL Address page is opened
     When Use registration details is "Yes"
     And Collection_Property type="Home"
     And Collection_address="24 Wrench Road, Isando, Kempton Park, South Africa"
     And Click on Submit button
     Then TAL Confirm page get opened
#       Given TAL Confirm page is opened
       When Click on Confirm and Proceed to Payment button
       Then Displays TAL Payment Type Error message

  Scenario: Verify if user is unable to complete Step TAl "Collection & Delivery Details" without accepting Terms and conditions and will change the text of confirm button accordingly
    Given TAL Confirm page is opened
    When Select payment type="Pay by Card"
    And Click on Confirm and Proceed to Payment button
    Then Display msg "Please agree to the terms and conditions before you continue" on Confirm and Proceed to Payment button
         #And User not navigated to secure EFT payment page

  Scenario: Verify if display error when Notifications check boxes are selected and but relative textboxes are empty
         Given TAL Confirm page is opened
         When Select check box  On Delivery Email
         And Select check box On Delivery SMS
         And Select check box  Full Tracking Email
         And Select check box Full Tracking SMS
         And Click on Confirm and Proceed to Payment button
         Then Get notification for On Delivery Email textBox
         And Get notification for On Delivery SMS textBox
         And Get notification for Full Tracking Email textBox
         And Get notification for Full Tracking SMS textBox

  Scenario: Verify if user is landing on secure payment page by clicking on Confirm and Proceed to Payment button after filling valid details
    Given TAL Confirm page is opened
    And all notification check boxes are selected
     When Select payment type="Pay with Instant EFT"
    And Enter On Delivery Email = "swati.winjit123@gmail.com"
    And Enter On Delivery SMS = "12345"
    And Enter Full Tracking Email = "swati.winjit123@gmail.com"
    And Enter Full Tracking SMS = "12345"
    And Accept terms and condition
    And Click on Confirm and Proceed to Payment button
    Then User navigated to secure EFT payment page


  Scenario: close and reopen the application
    Given Close the application
    And Open Application


  Scenario: Verifying if Private user is able to perform take a lot functionality for "TAKEALOT JOHANNESBURG WAREHOUSE" and Use registration details in collection details field=Yes
    Given User is on Home page
    When User Click on take a Lot menu
    Then Display alert box "Please login first in order to use the Takealot service"
    And Accept alert box
  #  And User click on Login Link
    Then Login Form will open
    When Enter email address "swati.winjit123@gmail.com"
    And Enter Password "Swati12345"
    And Click on Submit Button to submit login form
    Then User "Swati" logged in
    And User Click on take a Lot link
    Then User is on take a lot-Start your Order page

  #Scenario: Verify if user is able to complete Step-1 Start your order
    When Select parcelContent as "Restricted - Firearm"
    And Enter collection address as "21 Wrench Road, Isando, Kempton Park, South Africa"
    And Select Take a lot destination as "TAKEALOT JOHANNESBURG WAREHOUSE"
    And Enter PO Number as "PO54313311"
    And Click on TAL form
    And Click on TAL Next button
    Then Step "Start Your Order" completed
  #Scenario: Verifying if user is able to complete step 2 "Parcel Dimensions" with valid data
    When Select parcel count as "1 Parcel"
    And Select "Parcel 1" to enter details as
    And Parcel 1 Weight= "2"
    And Parcel 1 Length= "21"
    And Parcel 1 Width= "12"
    And Parcel 1 Height= "13"
    And Click on TAL Next button
    Then Step TAL "Parcel Dimensions" completed

  #Scenario: Verifying if user is able to complete step 3 "Select Your Service" with valid data
    When Select default service type
    And Click on Confirm button
    Then Step "Select Your Service" completed

  #Scenario: Verifying if user is able to complete step 4 "Collection & Delivery Details" with valid data
  #details of the person from collect parcel
    When TAL Address page is opened
    And Use registration details is "Yes"
    And Collection_Property type="Residential Complex"
    And Collection_address="24 Wrench Road, Isando, Kempton Park, South Africa"
    And Click on Submit button
    Then TAL Confirm page get opened
    When Select payment type="Pay with Instant EFT"
    And Accept terms and condition
    And Click on Confirm and Proceed to Payment button
    Then User navigated to secure EFT payment page

  Scenario: close and reopen the application
    Given Close the application
    And Open Application


  Scenario: Verifying if Private user is able to perform take a lot functionality for "TAKEALOT CAPE TOWN WAREHOUSE" with parcel count=3 and Use registration details in collection details field=No
    Given User is on Home page
    When User click on Login Link
   # And Accept alert box
    Then Login Form will open
    When Enter email address "swati.winjit123@gmail.com"
    And Enter Password "Swati12345"
    And Click on Submit Button to submit login form
    Then User "Swati" logged in
    And User Click on take a Lot link
    Then User is on take a lot-Start your Order page
  #Scenario: Verify if user is able to complete Step-1 Start your order
    When Select parcelContent as "No"
    And Enter collection address as "21 Wrench Road, Isando, Kempton Park, South Africa"
    And Select Take a lot destination as "TAKEALOT CAPE TOWN WAREHOUSE"
    And Enter PO Number as "PO23313311"
    And Click on TAL form
    And Click on TAL Next button
    Then Step "Start Your Order" completed
  #Scenario: Verifying if user is able to complete step 2 "Parcel Dimensions" with valid data
    When Select parcel count as "3 Parcels"
    And Select "Parcel 1" to enter details as
    And Parcel 1 Weight= "2"
    And Parcel 1 Length= "21"
    And Parcel 1 Width= "12"
    And Parcel 1 Height= "13"
    And Select "Parcel 2" to enter details as
    And Parcel 2 Weight= "2"
    And Parcel 2 Length= "11"
    And Parcel 2 Width= "11"
    And Parcel 2 Height= "11"
    And Select "Parcel 3" to enter details as
    And Parcel 3 Weight= "3"
    And Parcel 3 Length= "11"
    And Parcel 3 Width= "11"
    And Parcel 3 Height= "11"
    And Click on TAL Next button
    Then Step TAL "Parcel Dimensions" completed
  #Scenario: Verifying if user is able to complete step 3 "Select Your Service" with valid data
    When Select default service type
    And Click on Confirm button
    Then Step "Select Your Service" completed
  #Scenario: Verifying if user is able to complete step 4 "Collection & Delivery Details" with valid data
  #details of the person from collect parcel
  When TAL Address page is opened
    And Use registration details is "No"
    And User enter collection details as  collection_Firstname="Swati"
    And Collection_Surname="Thakare"
    And Collection_Mobile no="1234567890"
    And Collection_email address="swati.winji123@gmail.com"
    And Collection_Property type="Home"
  #And Collection_address="24 Wrench Road, Isando, Kempton Park, South Africa"
    And Click on Submit button
    Then TAL Confirm page get opened
    When Select payment type="Pay with Instant EFT"
    And Accept terms and condition
    And Click on Confirm and Proceed to Payment button
    Then User navigated to secure EFT payment page

  Scenario: close and reopen the application
    Given Close the application
    And Open Application

  Scenario: Verifying if Company user is able to perform take a lot functionality for "TAKEALOT JOHANNESBURG WAREHOUSE" and Use registration details in collection details field=Yes
    Given User is on Home page
    When User click on Login Link
   # And Accept alert box
    Then Login Form will open
    When Enter email address "swati.company1@gmail.com"
    And Enter Password "Swati12345"
    And Click on Submit Button to submit login form
    Then User logged in
    And User Click on take a Lot link
    Then User is on take a lot-Start your Order page

  #Scenario: Verify if user is able to complete Step-1 Start your order
    When Select parcelContent as "No"
    And Enter collection address as "21 Wrench Road, Isando, Kempton Park, South Africa"
    And Select Take a lot destination as "TAKEALOT JOHANNESBURG WAREHOUSE"
    And Enter PO Number as "PO83313311"
    And Click on TAL form
    And Click on TAL Next button
    Then Step "Start Your Order" completed
  #Scenario: Verifying if user is able to complete step 2 "Parcel Dimensions" with valid data
    When Select parcel count as "1 Parcel"
    And Select "Parcel 1" to enter details as
    And Parcel 1 Weight= "2"
    And Parcel 1 Length= "21"
    And Parcel 1 Width= "12"
    And Parcel 1 Height= "13"
    And Click on TAL Next button
    Then Step TAL "Parcel Dimensions" completed

  #Scenario: Verifying if user is able to complete step 3 "Select Your Service" with valid data
    When Select default service type
    And Click on Confirm button
    Then Step "Select Your Service" completed
    And User navigate to TAL Address page
  #Scenario: Verifying if user is able to complete step 4 "Collection & Delivery Details" with valid data
  #details of the person from collect parcel
    When TAL Address page is opened
    And Use registration details is "Yes"
    Then Disable the field collection_Firstname
    And Disable the field collection_Surname
    And Collection_Property type="Home"
    And Collection_address="24 Wrench Road, Isando, Kempton Park, South Africa"
    And Click on Submit button
    Then TAL Confirm page get opened
    When Select payment type="Pay with Instant EFT"
    And Accept terms and condition
    And Click on Confirm and Proceed to Payment button
    Then User navigated to secure EFT payment page

  Scenario: close and reopen the application
    Given Close the application
    And Open Application

