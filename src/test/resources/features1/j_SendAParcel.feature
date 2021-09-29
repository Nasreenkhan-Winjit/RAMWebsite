@TAL
Feature: Validating functionality of Send A Parcel module.

    #____________Send a Parcel with invalid data______________________________________________
  @InvalidData
  Scenario Outline: Verify if user is not able to complete step-1 Start your order with invalid data
 # Given User is on Home page
    Given User Click on Send a Parcel menu
    When User fill details
      | parcelSendType | <parcelSendType> |
      | parcelType     | <parcelType>     |
      | parcelContent  | <parcelContent>  |
      | fromAddress    | <fromAddress>    |
      | toAddress      | <toAddress>      |
    And Click on Next button
    Then Get error in ParcelType "<error_parcelType>"
    And Get error in ParcelContent "<error_parcelContent>"
    And Get error in from address textbox "<error_fromAddress>"
    And Get error in to address textbox "<error_toAddress>"
    Examples:
      | parcelSendType | parcelType | parcelContent                      | fromAddress                                        | toAddress | error_parcelType | error_parcelContent | error_fromAddress | error_toAddress |
      | Domestic       |            |                                    |                                                    |           | Yes              | Yes                 | Yes               | Yes             |
      | Domestic       | Parcel     |                                    |                                                    |           | No               | Yes                 | yes               | yes             |
      | Domestic       | Document   | No                                 |                                                    |           | no               | no                  | yes               | yes             |
      | Domestic       | Firearm    |                                    |                                                    |           | no               | no                  | yes               | yes             |
      | Domestic       | Parcel     | No                                 | 21 Wrench Road, Isando, Kempton Park, South Africa |           | no               | no                  | no                | yes             |
      | International  |            |                                    |                                                    |           | Yes              | yes                 | yes               | no              |
      | International  | Document   | Restricted - Aerosol Cans / Sprays | ram mandir nashik                                  |           | no               | Yes                 | No                | no              |

  @InvalidData
    Scenario: Verify the system behaviour when user selects Domestic Send a Parcel and prohibited parcel content
    Given User Click on Send a Parcel menu
    When Select parcel send type as "Domestic"
    And Select parcelContent as "Prohibited - Box With A Hazardous Label"
   # And Click on Next button
    Then Displays error Toaster message
    And Disable the field From Address
    And Disable the field To Address

  @InvalidData
  Scenario: Verify the system behaviour when user selects International Send a Parcel and prohibited parcel content
    Given User Click on Send a Parcel menu
    When Select parcel send type as "International"
    And Select parcelContent as "Prohibited - Box With A Hazardous Label"
   # And Click on Next button
    Then Displays error Toaster message
    And Disable the field From Address

  @InvalidData
  Scenario: Verify if toaster message displays when user selects International Send a Parcel and restricted parcel content
    Given User Click on Send a Parcel menu
    When Select parcel send type as "International"
    And Select parcelContent as "Restricted - Aerosol Cans / Sprays"
    And Click on Next button
    Then Displays error Toaster message

  Scenario: Complete Send a Parcel Step-1 "Order your parcel" to land to the step 2 "Parcel Dimensions page"
    Given User Click on Send a Parcel menu
    When Select parcel send type as "Domestic"
    And Select parcelType as a "Parcel"
    And Select parcelContent as "No"
    And Enter collection address as "21 Wrench Road, Isando, Kempton Park, South Africa"
    And Enter delivery address as "23 Isando Road, Isando, Kempton Park, South Africa"
    And Click on Next button
    Then Step "Start Your Order" completed

  @InvalidData
  Scenario Outline: Verify if user is not able to complete step-2 "Parcel Dimensions" with invalid data
    Given Step "Start Your Order" completed
   # And Click on Next button
    When Select parcel count as "1 Parcel"
    And Select "Parcel 1" to enter details as
    And Parcel 1 Weight= "<parcelWeight>"
    And Parcel 1 Length= "<parcelLength>"
    And Parcel 1 Width= "<parcelWidth>"
    And Parcel 1 Height= "<parcelHeight>"
    And Click on Next button
    Then Get error in Parcel 1 Weight "<error_parcelWeight>"
    And Get error in Parcel 1 Lenght "<error_parcelLength>"
    And Get error in Parcel 1 Width "<error_parcelWidth>"
    And Get error in Parcel 1 Height "<error_parcelHeight>"
    Examples:
      | parcelWeight | parcelLength | parcelWidth | parcelHeight | error_parcelWeight | error_parcelLength | error_parcelWidth | error_parcelHeight |
      | 0.1          | 9            | 10          | 1            | No                 | Yes                | No                | Yes                |
      | 30           | 121          | 9           | 61           | No                 | Yes                | Yes               | Yes                |
      | 0            | 10           | 61          | 2            | Yes                | No                 | Yes               | No                 |
      | 31           | 120          | 11          | 60           | Yes                | No                 | No                | No                 |
      |              |              |             |              | Yes                | yes                | yes               | yes                |


  Scenario: Complete step-2 "Parcel Dimensions" with valid data.
    Given Select parcel count as "1 Parcel"
    And Select "Parcel 1" to enter details as
    And Parcel 1 Weight= "1"
    And Parcel 1 Length= "11"
    And Parcel 1 Width= "11"
    And Parcel 1 Height= "11"
    And Click on Next button
    Then Step "Parcel Dimensions" completed

  Scenario: Complete step-3 "Select your Service". Also execute different scenarios for step-3.
    When User click on Show all link
    And Select service type "Next Day by 11:00"
    And Click on Change button
    Then User is on "Select Your Service" step
    When Select service type "Express Road"
    And Click on Close button
    Then User is on "Select Your Service" step
    When Select service type "Economy Service"
    And Click on Confirm button
    Then Step "Select Your Service" completed

  @InvalidData
  Scenario: Verify if user is not able to register with already registered email id
     #Given User is on Home page
    Given Step "Select Your Service" completed
    When User enter details to register
      | usertype       | Private                   |
      | firstname      | Swati                     |
      | surname        | Thakare                   |
      | billingaddress | Nashik                    |
      | propertytype   | Home                      |
      | det1           |                           |
      | det2           |                           |
      | det3           |                           |
      | det4           |                           |
      | mobile         | 1234567890                |
      | telephone      |                           |
      | email          | swati.winjit123@gmail.com |
      | password       | abc123                    |
      | cpassword      | abc123                    |
    And User Click on Register Button
    Then Get toaster message "Registration was not successful Email address already registred."


  @InvalidData
  Scenario Outline:Verify if Private user "<firstname>" is able to complete user registration part of step-4 Collection and Delivery with invalid combination of data for mandatory fields
    Given Step "Select Your Service" completed
   # When User enter details
    When enter userType = "Private"
    And enter firstname = "<firstname>"
    And enter surname = "<surname>"
    And enter billingAddress = "<billingaddress>"
    # And  "propertytype" = "Home"
    And enter mobile = "<mobile>"
    And enter email = "<email>"
    And enter password = "<password>"
    And enter confirmPassword = "<cPassword>"
    And Click on Submit button
    Then Get error for "firstname" = "<fn_e>"
    And  Get error for "surname" = "<sn_e>"
    And  Get error for "billingAddress" = "<ba_e>"
    And  Get error for "mobile" = "<mob_e>"
    And  Get error for "email" = "<email_e>"
    And Get error for "password" = "<pass_e>"
    And Get error for "confirmPassword" = "<cpass_e>"
    Examples:
      | firstname   | surname  | billingaddress                                     | mobile                     | email             | password   | cPassword | fn_e | sn_e | ba_e | mob_e | email_e | pass_e | cpass_e |
      |             |          |                                                    |                            |                   |            |           | Yes  | Yes  | Yes  | Yes   | Yes     | Yes    | No      |
      | demo        | demo     | 21, wrench road                                    | 123                        | test,123@test.com |            |           | No   | No   | No   | No    | No      | Yes    | No      |
      | demo123     | demo123  | southAfrica                                        | abc                        | test@t            |            |           | No   | No   | No   | No    | Yes     | Yes    | No      |
      | d           | d        | India                                              | @@@@@@@                    | abc@com           |            |           | No   | No   | No   | No    | Yes     | Yes    | No      |
      | 1           | 1        | Nashik                                             | @#$%^&*()                  | abc<abc@12.com    |            |           | No   | No   | No   | No    | No      | Yes    | No      |
      | demo@123    | demo@123 | Nashik@1                                           | abcderfgtaaaaaaaaaaaaaaaaa | 123@12..abctest   |            |           | No   | No   | No   | No    | No      | Yes    | No      |
      | demo_123    | demo_123 | 123                                                | ;';';,./?                  | abc'?abc'@12.com  |            |           | No   | No   | No   | No    | No      | Yes    | No      |
      | demo+1      | demo+1   | 21 Isando Road, Isando, Kempton Park, South Africa | 1                          | abc?abc\\\@12.com |            |           | No   | No   | No   | No    | No      | Yes    | No      |
      #| ss          | ss       | demobilling address                                | ;                          | abc/abc##@12.com    | Demo123456 | Demo123456 | No   | No   | No   | Yes   | Yes     | No     | No      |
      | @@@@$%!&*** | &&^%$#@  | #@!^&%$                                            | \\\\\\\*                   | abc(abc)@12.com   | Demo123456 |           | No   | No   | No   | No    | No      | No     | Yes     |
      | +-\\?^      | +-\\?^   | +-\\?^                                             | !@#$%^&*(){}[]             | pqr[abc]@12.com   | Demo123456 | demo      | No   | no   | No   | No    | No      | No     | Yes     |
    #  | Swati       | Thakare  | 21 Isando Road, Isando, Kempton Park, South Africa | 1234567890                 | Demo.demo1@demo.com | Demo12345  | Demo12345 | No   | No   | No   | No    | No      | No     | No      |


  Scenario: Verify if user is able to complete user registration part of step-4 "Collection & Delivery Details" with already registered user .
    Given User is on Send a Parcel-Register page
    When User enter email "swati.winjit123@gmail.com"
    And Enter Password as "Swati12345"
    And Click on Login button
    Then User logged in
    #Then Send Address page get opened
  Scenario: Verify if user is able to navigate to any step by clicking on step name
    When User click on step "1"
    Then User is navigate to Start you order
    And Click on username
    And Logged out

  @InvalidData
  Scenario Outline: Verifying if user is able to complete part-2 (address details) of step 4 "Collection & Delivery Details" with invalid data
  #details of the person from collect parcel
    Given  User Click on Send a Parcel menu
    And User is on Start your Order page
    When Select parcel send type as "Domestic"
    And Select parcelType as a "Parcel"
    And Select parcelContent as "No"
    And Enter collection address as "21 Wrench Road, Isando, Kempton Park, South Africa"
    And Enter delivery address as "23 Isando Road, Isando, Kempton Park, South Africa"
    And Click on Next button
    Then Step "Start Your Order" completed
#  Scenario: Verifying if user is able to complete step 2 "Parcel Dimensions" with valid data
   # Given Step-1 "Start Your Order" completed
    When Select parcel count as "1 Parcel"
    And Select "Parcel 1" to enter details as
    And Parcel 1 Weight= "1"
    And Parcel 1 Length= "11"
    And Parcel 1 Width= "11"
    And Parcel 1 Height= "11"
    And Click on Next button
    Then Step "Parcel Dimensions" completed
# Scenario: Verifying if user is able to complete step 3 "Select Your Service" with valid data
  #  When User click on Show all options
    When Select default service type
    And Click on Confirm button
    Then Step "Select Your Service" completed
    And User is on Send a Parcel-Register page
    When User enter email "swati.winjit123@gmail.com"
    And Enter Password as "Swati12345"
    And Click on Login button
    Then Send Address page get opened

  #  Scenario: Verifying if user is able to complete step 4 "Collection & Delivery Details" with valid data
    #  details of the person from collect parcel
    When User enter collection details as  collection_Firstname="<c_firstname>"
    And Collection_Surname="<c_surname>"
    And Collection_Mobile no="<c_mobile>"
    And Collection_email address="<c_email>"
    And Collection_Property type="<c_propertytype>"
   #  details of the person to deliver parcel
    And User enter delivery details as  delivery_Firstname="<d_firstname>"
    And Delivery_Surname="<d_surname>"
    And Delivery_Mobile no="<d_mobile>"
    And Delivery_email address="<d_email>"
    And Delivery_Property type="<d_propertytype>"
#  And Delivery_Address="21, Ram Charan Sett Road, Baruipara, Ichapur, Howrah, West Bengal, India"
#  And Upload Invoice "C:\\Users\\swatithakare\\Downloads\\COMMERCIAL_INVOICE_TEMPLATE.pdf"
    And Click on Submit button
    Then Get error and send confirm page not opened
    And Close the application
    And Open Application
    Examples:
      | c_firstname | c_surname | c_mobile   | c_email                   | c_propertytype | d_firstname | d_surname | d_mobile   | d_email                   | d_propertytype |
      |             |           |            |                           |                |             |           |            |                           |                |
#      | @#&*^%      | Thakare   | 1234567890                       | swati.winjit123@gmail.com | Home           | Swati       | Thakare   | 1234567890                  | swati.winjit123@gmail.com | Home           |
 #     | Swati       | @#&*^%    | 1234567890                       | swati.winjit123@gmail.com | Home           | Swati       | Thakare   | 1234567890                  | swati.winjit123@gmail.com | Home           |
  #    | Swati       | Thakare   | 123                              | swati.winjit123@gmail.com | Home           | Swati       | Thakare   | 1234567890                  | swati.winjit123@gmail.com | Home           |
   #   | Swati       | Thakare   | @@###$$$                         | swati.winjit123@gmail.com | Home           | Swati       | Thakare   | 1234567890                  | swati.winjit123@gmail.com | Home           |
    #  | Swati       | Thakare   | ABCDE                            | swati.winjit123@gmail.com | Home           | Swati       | Thakare   | 1234567890                  | swati.winjit123@gmail.com | Home           |
     # | Swati       | Thakare   | 123455555555555555897665555      | swati.winjit123@gmail.com | Home           | Swati       | Thakare   | 1234567890                  | swati.winjit123@gmail.com |                |
      |             | Thakare   | 1234567890 | swati.winjit123@gmail.com | Home           | Swati       | Thakare   | 1234567890 | swati.winjit123@gmail.com |                |
      | Swati       |           | 1234567890 | swati.winjit123@gmail.com | Home           | Swati       | Thakare   | 1234567890 | swati.winjit123@gmail.com |                |
      | Swati       | Thakare   |            | swati.winjit123@gmail.com | Home           | Swati       | Thakare   | 1111111111 | swati.winjit123@gmail.com |                |
      | Swati       | Thakare   | 1234567890 |                           | Home           | Swati       | Thakare   | 1234567890 | swati.winjit123@gmail.com |                |
      | Swati       | Thakare   | 1234567890 | test,123@test.com         |                | Swati       | Thakare   | 1234567890 | swati.winjit123@gmail.com |                |
      | Swati       | Thakare   | 1234567890 | abc@com                   |                | Swati       | Thakare   | 1234567890 | swati.winjit123@gmail.com |                |
      | Swati       | Thakare   | 1234567890 | 123@12..abctest           |                | Swati       | Thakare   | 1234567890 | swati.winjit123@gmail.com |                |
      | Swati       | Thakare   | 1234567890 | abc<abc@12.com            |                | Swati       | Thakare   | 1234567890 | swati.winjit123@gmail.com |                |
      | Swati       | Thakare   | 1234567890 | abc(abc)@12.com           |                | @#&*^%      | Thakare   | 1234567890 | swati.winjit123@gmail.com | Home           |
      #| Swati       | Thakare   | 1234567890                       | swati.winjit123@gmail.com | Home           | Swati       | @#&*^%    | 1234567890                  | swati.winjit123@gmail.com | Home           |
      #| Swati       | Thakare   | 1234567890                       | swati.winjit123@gmail.com | Home           | Swati       | Thakare   | 123                         | swati.winjit123@gmail.com | Home           |
      #| Swati       | Thakare   | 1234567890                       | swati.winjit123@gmail.com | Home           | Swati       | Thakare   | @@###$$$                    | swati.winjit123@gmail.com | Home           |
      #| Swati       | Thakare   | 1234567890                       | swati.winjit123@gmail.com | Home           | Swati       | Thakare   | ABCDE                       | swati.winjit123@gmail.com | Home           |
      #| Swati       | Thakare   | 1234567890                       | swati.winjit123@gmail.com | Home           | Swati       | Thakare   | 123455555555555555897665555 | swati.winjit123@gmail.com | Home           |
      | Swati       | Thakare   | 1234567890 | swati.winjit123@gmail.com | Home           |             | Thakare   | 1234567890 | swati.winjit123@gmail.com | Home           |
      | Swati       | Thakare   | 1234567890 | swati.winjit123@gmail.com | Home           | Swati       |           | 1234567890 | swati.winjit123@gmail.com | Home           |
      | Swati       | Thakare   | 1234567890 | swati.winjit123@gmail.com | Home           | Swati       | Thakare   |            | swati.winjit123@gmail.com | Home           |
      | Swati       | Thakare   | 1234567890 | swati.winjit123@gmail.com | Home           | Swati       | Thakare   | 1234567890 |                           | Home           |
      #| Swati       | Thakare   | 1234567890                       | swati.winjit123@gmail.com | Home           | Swati       | Thakare   | 1234567890 | test,123@test.com         |                |
      | Swati       | Thakare   | 1234567890 | swati.winjit123@gmail.com | Home           | Swati       | Thakare   | 1234567890 | abc@com                   |                |
      #| Swati       | Thakare   | 1234567890                       | swati.winjit123@gmail.com | Home           | Swati       | Thakare   | 1234567890 | 123@12..abctest           |                |
      #| Swati       | Thakare   | 1234567890                       | swati.winjit123@gmail.com | Home           | Swati       | Thakare   | 1234567890 | abc<abc@12.com            |                |
      | Swati       | Thakare   | 1234567890 | swati.winjit123@gmail.com |                | Swati       | Thakare   | 1234567890 | abc(abc)@12.com           |                |


  Scenario: Verify if user is navigate to password Recovery page by clicking on Forgot password link present on "Send a parcel-Register" page
    Given User Click on Send a Parcel menu
    When Select parcel send type as "Domestic"
    And Select parcelType as a "Firearm"
  #  And Select parcelContent as "No"
    And Enter collection address as "21 Wrench Road, Isando, Kempton Park, South Africa"
    And Enter delivery address as "23 Isando Road, Isando, Kempton Park, South Africa"
    And Click on Next button
    Then Step "Start Your Order" completed
#  Scenario: Verifying if user is able to complete step 2 "Parcel Dimensions" with valid data
   # Given Step-1 "Start Your Order" completed
    When Select parcel count as "1 Parcel"
    And Select "Parcel 1" to enter details as
    And Parcel 1 Weight= "1"
    And Parcel 1 Length= "11"
    And Parcel 1 Width= "11"
    And Parcel 1 Height= "11"
    And Click on Next button
    Then Step "Parcel Dimensions" completed
# Scenario: Verifying if user is able to complete step 3 "Select Your Service" with valid data
  #  When User click on Show all options
    When Select default service type
    And Click on Confirm button
    Then Step "Select Your Service" completed
    And User is on Send a Parcel-Register page
    When User click on Forgot Password link
    Then Password Recovery page should open
    And Close the application
    And Open Application


    #______________________________________Domestic with registered User_______________________#

  Scenario: Verifying if registered user is able to use Domestic-send a parcel functionality for firearm with valid data
    #Case 1-for registered user with user login
  #Scenario: Verifying if user is able to complete step 1 "Start your order" with valid data
    Given User Click on Send a Parcel menu
    When Select parcel send type as "Domestic"
    And Select parcelType as a "Firearm"
  #  And Select parcelContent as "No"
    And Enter collection address as "21 Wrench Road, Isando, Kempton Park, South Africa"
    And Enter delivery address as "23 Isando Road, Isando, Kempton Park, South Africa"
    And Click on Next button
    Then Step "Start Your Order" completed
#  Scenario: Verifying if user is able to complete step 2 "Parcel Dimensions" with valid data
   # Given Step-1 "Start Your Order" completed
    When Select parcel count as "1 Parcel"
    And Select "Parcel 1" to enter details as
    And Parcel 1 Weight= "1"
    And Parcel 1 Length= "11"
    And Parcel 1 Width= "11"
    And Parcel 1 Height= "11"
    And Click on Next button
    Then Step "Parcel Dimensions" completed
# Scenario: Verifying if user is able to complete step 3 "Select Your Service" with valid data
  #  When User click on Show all options
    When Select default service type
    And Click on Confirm button
    Then Step "Select Your Service" completed
#  Scenario: Verifying if user is able to complete user login part of step 4 "Collection & Delivery Details" with valid data
    When User enter email "swati.winjit123@gmail.com"
    And Enter Password as "Swati12345"
    And Click on Login button
    Then Send Address page get opened
#  Scenario: Verifying if user is able to complete step 4 "Collection & Delivery Details" with valid data
    #  details of the person from collect parcel
    When User enter collection details as  collection_Firstname="Swati"
    And Collection_Surname="Thakare"
    And Collection_Mobile no="1234567890"
    And Collection_email address="swati.winji123@gmail.com"
    And Collection_Property type="Home"
   #  details of the person to deliver parcel
    And User enter delivery details as  delivery_Firstname="SSP"
    And Delivery_Surname="SThakare"
    And Delivery_Mobile no="1234567890"
    And Delivery_email address="swati.winji123@gmail.com"
    And Delivery_Property type="Home"
     # Firearm details
    And User enter Firearm details as Firearm_Id="123"
    And Select Firearm_Type="Pistol"
    And Make of Firearm="Make123"
    And Firearm serial number="123"
    And Firearm has telescope="Yes"
    And Firearm Magazines="2"
    And Firearm other="none"
    And Click on Submit button
    Then Send Confirm page get opened
     #Scenario: Verify user is able to complete the payment selection step
    And Select payment type="Pay with Instant EFT"
    And Accept terms and condition
    And Click on Confirm and Proceed to Payment button
    Then User navigated to secure EFT payment page
    And Close the application
    And Open Application

    #______________________________________Domestic with registered User and Parcel_count=>1_______________________#

  Scenario: Verifying if registered user is able to use Domestic-send a parcel functionality for multiple parcels with valid data
    #Case 1-for registered user with user login
  #Scenario: Verifying if user is able to complete step 1 "Start your order" with valid data
    Given User Click on Send a Parcel menu
    When Select parcel send type as "Domestic"
    And Select parcelType as a "Parcel"
    And Select parcelContent as "No"
    And Enter collection address as "21 Wrench Road, Isando, Kempton Park, South Africa"
    And Enter delivery address as "23 Isando Road, Isando, Kempton Park, South Africa"
    And Click on Next button
    Then Step "Start Your Order" completed
#  Scenario: Verifying if user is able to complete step 2 "Parcel Dimensions" with valid data
   # Given Step-1 "Start Your Order" completed
    When Select parcel count as "4 Parcels"
    And Select "Parcel 1" to enter details as
    And Parcel 1 Weight= "1"
    And Parcel 1 Length= "11"
    And Parcel 1 Width= "11"
    And Parcel 1 Height= "11"
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
    And click on next slide_arrow
    And Select "Parcel 4" to enter details as
    And Parcel 4 Weight= "4"
    And Parcel 4 Length= "11"
    And Parcel 4 Width= "11"
    And Parcel 4 Height= "11"
    And Click on Next button
    Then Step "Parcel Dimensions" completed
# Scenario: Verifying if user is able to complete step 3 "Select Your Service" with valid data
    When User click on Show all options
    And Select service type "Economy Service"
    And Click on Confirm button
    Then Step "Select Your Service" completed
#  Scenario: Verifying if user is able to complete user login part of step 4 "Collection & Delivery Details" with valid data
    When User enter email "swati.winjit123@gmail.com"
    And Enter Password as "Swati12345"
    And Click on Login button
   # Then User "Swati" logged in
    Then Send Address page get opened
#  Scenario: Verifying if user is able to complete step 4 "Collection & Delivery Details" with valid data
    #  details of the person from collect parcel
    When User enter collection details as  collection_Firstname="Swati"
    And Collection_Surname="Thakare"
    And Collection_Mobile no="1234567890"
    And Collection_email address="swati.winji123@gmail.com"
    And Collection_Property type="Home"
   #  details of the person to deliver parcel
    And User enter delivery details as  delivery_Firstname="SSP"
    And Delivery_Surname="SThakare"
    And Delivery_Mobile no="1234567890"
    And Delivery_email address="swati.winji123@gmail.com"
    And Delivery_Property type="Home"
    And Click on Submit button
    Then Send Confirm page get opened

     #Scenario: Verify user is able to complete the payment selection step
    And Select payment type="Pay with Instant EFT"
    And Accept terms and condition
    And Click on Confirm and Proceed to Payment button
    Then User navigated to secure EFT payment page
    And Close the application
    And Open Application

#________________________International with Registered User__________________________________________________________#
  Scenario:Verifying if registered user is able to use International-send a parcel functionality with all valid data
    #Case 1-for registered user with user login
  #Scenario: Verifying if user is able to complete step 1 "Start your order" with valid data
    Given User Click on Send a Parcel menu
    When Select parcel send type as "International"
    And Select parcelType as a "Parcel"
    And Select parcelContent as "No"
    And Enter collection address as "21 Wrench Road, Isando, Kempton Park, South Africa"
    And Select delivery address country as "India"
    And Click on Next button
    Then Step "Start Your Order" completed

  #Scenario: Verifying if user is able to complete step 2 "Parcel Dimensions" with valid data
   # Given Step-1 "Start Your Order" completed
    When Select parcel count as "1 Parcel"
    And Select "Parcel 1" to enter details as
    And Parcel 1 Weight= "1"
    And Parcel 1 Length= "11"
    And Parcel 1 Width= "11"
    And Parcel 1 Height= "11"
    And Click on Next button
    Then Step "Parcel Dimensions" completed

    #Scenario: Verifying if user is able to complete step 3 "Select Your Service" with valid data
    When User click on Show all options
    And Select service type "International Parcel"
    And Click on Confirm button
    Then Step "Select Your Service" completed

  #Scenario: Verifying if user is able to complete user login part of step 4 "Collection & Delivery Details" with valid data
    When User enter email "swati.winjit123@gmail.com"
    And Enter Password as "Swati12345"
    And Click on Login button
    #And Click on Login button
    #And User "Swati" logged in
    Then Send Address page get opened

   #Scenario: Verifying if user is able to complete step 4 "Collection & Delivery Details" with valid data
  #details of the person from collect parcel
    When User enter collection details as  collection_Firstname="Swati"
    And Collection_Surname="Thakare"
    And Collection_Mobile no="1234567890"
    And Collection_email address="swati.winji123@gmail.com"
    And Collection_Property type="Home"
   #  details of the person to deliver parcel
    And User enter delivery details as  delivery_Firstname="SSP"
    And Delivery_Surname="SThakare"
    And Delivery_Mobile no="1234567890"
    And Delivery_email address="swati.winji123@gmail.com"
    And Delivery_Property type="Home"
    And Delivery_Address="21, Ram Charan Sett Road, Baruipara, Ichapur, Howrah, West Bengal, India"
    And Upload Invoice "C:\\Users\\swatithakare\\Downloads\\COMMERCIAL_INVOICE_TEMPLATE.pdf"
    And Click on Submit button for International parcel
    Then Send Confirm page get opened

     #Scenario: Verify user is able to complete the payment selection step
    And Select payment type="Pay with Instant EFT"
    And Accept terms and condition
    And Click on Confirm and Proceed to Payment button
    Then User navigated to secure EFT payment page
    And Close the application
    And Open Application


  #__________________________________Domestic with non registered User ____________________________________________#
  Scenario: Verifying if non registered user is able to use Domestic-send a parcel functionality with valid data
    #Case 1-for non registered user
    #Scenario: Verifying if user is able to complete step 1 "Start your order" with valid data
    Given User Click on Send a Parcel menu
    When Select parcel send type as "Domestic"
    And Select parcelType as a "Document"
    And Select parcelContent as "No"
    And Enter collection address as "21 Wrench Road, Isando, Kempton Park, South Africa"
    And Enter delivery address as "23 Isando Road, Isando, Kempton Park, South Africa"
    And Click on Next button
    Then Step "Start Your Order" completed
#  Scenario: Verifying if user is able to complete step 2 "Parcel Dimensions" with valid data
    When Select parcel count as "1 Parcel"
    And Select "Parcel 1" to enter details as
    And Parcel 1 Weight= "1"
    And Parcel 1 Length= "11"
    And Parcel 1 Width= "11"
    And Parcel 1 Height= "11"
    And Click on Next button
    Then Step "Parcel Dimensions" completed

# Scenario: Verifying if user is able to complete step 3 "Select Your Service" with valid data
    When User click on Show all options
    And Select service type "Express Road"
    And Click on Confirm button
    Then Step "Select Your Service" completed

#  Scenario: Verifying if user is able to complete user REGISTRATION part of step 4 "Collection & Delivery Details" with valid data
    When User enter details to register
      | usertype       | Company                                             |
      | companyname    | SwatiDomestic Company                               |
      | vatNumber      | Thakare123                                          |
      | billingaddress | 21 Wrench Road, Isando, Kempton Park, 1600, Gauteng |
      | propertytype   | Home                                                |
      | det1           |                                                     |
      | det2           |                                                     |
      | det3           |                                                     |
      | det4           |                                                     |
      | mobile         | 1234567890                                          |
      | telephone      |                                                     |
      | email          | testS17@test12.com                                  |
      | password       | test12345                                           |
      | cpassword      | test12345                                           |

    And Click on Submit button
    #Then User "SwatiDomestic Company" logged in
    Then Send Address page get opened

#  Scenario: Verifying if user is able to complete step 4 "Collection & Delivery Details" with valid data
    #  details of the person from collect parcel
    When User enter collection details as  collection_Firstname="Swati"
    And Collection_Surname="Thakare"
    And Collection_Mobile no="1234567890"
    And Collection_email address="swati.winji123@gmail.com"
    And Collection_Property type="Home"
   #  details of the person to deliver parcel
    And User enter delivery details as  delivery_Firstname="SSP"
    And Delivery_Surname="SThakare"
    And Delivery_Mobile no="1234567890"
    And Delivery_email address="swati.winji123@gmail.com"
    And Delivery_Property type="Home"
    And Click on Submit button
    Then Send Confirm page get opened

     #Scenario: Verify user is able to complete the payment selection step
    And Select payment type="Pay with Instant EFT"
    And Accept terms and condition
    And Click on Confirm and Proceed to Payment button
    Then User navigated to secure EFT payment page
    And Close the application
    And Open Application



  #_______________________International with non registered user_______________________________#
  Scenario:Verifying if non registered user is able to use International-send a parcel functionality with all valid data
    #Case 1-for registered user with user login
  #Scenario: Verifying if user is able to complete step 1 "Start your order" with valid data
    Given User Click on Send a Parcel menu
    When Select parcel send type as "International"
    And Select parcelType as a "Document"
    And Select parcelContent as "No"
    And Enter collection address as "21 Wrench Road, Isando, Kempton Park, South Africa"
    And Select delivery address country as "India"
    And Click on Next button
    Then Step "Start Your Order" completed

  #Scenario: Verifying if user is able to complete step 2 "Parcel Dimensions" with valid data
   # Given Step-1 "Start Your Order" completed
    When Select parcel count as "1 Parcel"
    And Select "Parcel 1" to enter details as
    And Parcel 1 Weight= "1"
    And Parcel 1 Length= "11"
    And Parcel 1 Width= "11"
    And Parcel 1 Height= "11"
    And Click on Next button
    Then Step "Parcel Dimensions" completed

  #Scenario: Verifying if user is able to complete step 3 "Select Your Service" with valid data
    When User click on Show all options
    And Select service type "International Parcel"
    And Click on Confirm button
    Then Step "Select Your Service" completed

  #Scenario: Verifying if user is able to complete user REGISTRATION part of step 4 "Collection & Delivery Details" with valid data
    And User enter details to register
      | usertype       | Company                                            |
      | companyname    | sendAParcelInternational                           |
      | vatNumber      | Vat123                                             |
      | billingaddress | 21 Wrench Road, Isando, Kempton Park, South Africa |
      | propertytype   | Home                                               |
      | det1           |                                                    |
      | det2           |                                                    |
      | det3           |                                                    |
      | det4           |                                                    |
      | mobile         | 1234567890                                         |
      | telephone      |                                                    |
      | email          | demoInternatioanlcompanyS17@ram.co.za              |
      | password       | demo123                                            |
      | cpassword      | demo123                                            |

    And Click on Submit button
    #Then User "sendAParcelInternational" logged in
    Then Send Address page get opened

  #Scenario: Verifying if user is able to complete step 4 "Collection & Delivery Details" with valid data
  #details of the person from collect parcel
    When User enter collection details as  collection_Firstname="Swati"
    And Collection_Surname="Thakare"
    And Collection_Mobile no="1234567890"
    And Collection_email address="swati.winji123@gmail.com"
    And Collection_Property type="Home"
   #  details of the person to deliver parcel
    And User enter delivery details as  delivery_Firstname="SSP"
    And Delivery_Surname="SThakare"
    And Delivery_Mobile no="1234567890"
    And Delivery_email address="swati.winji123@gmail.com"
    And Delivery_Property type="Home"
    And Delivery_Address="21, Ram Charan Sett Road, Baruipara, Ichapur, Howrah, West Bengal, India"
    And Upload Invoice "C:\\Users\\swatithakare\\Downloads\\COMMERCIAL_INVOICE_TEMPLATE.pdf"
    And Click on Submit button for International parcel
    Then Send Confirm page get opened

    #Scenario: Verify user is able to complete the payment selection step
    And Select payment type="Pay with Instant EFT"
    And Accept terms and condition
    And Click on Confirm and Proceed to Payment button
    Then User navigated to secure EFT payment page
    #Scenario: Close the current instance of browser and open new browser instannce
    And Close the application
    And Open Application

     #_____________________Domestic with non registered User and Used Collection Address as a billing address in registration form ____________________________________________#
  #Scenario: Verifying if non registered user is able to use collection address as a billing address for registration in Domestic-send a parcel functionality with valid data
    #Case 1-for non registered user
    #Scenario: Verifying if user is able to complete step 1 "Start your order" with valid data
    #Given User Click on Send a Parcel menu
    #When Select parcel send type as "Domestic"
    #And Select parcelType as a "Firearm"
    #And Select parcelContent as "No"
    #And Enter collection address as "21 Wrench Road, Isando, Kempton Park, South Africa"
    #And Enter delivery address as "23 Isando Road, Isando, Kempton Park, South Africa"
    #And Click on Next button
    #Then Step "Start Your Order" completed
#  Scenario: Verifying if user is able to complete step 2 "Parcel Dimensions" with valid data
    #When Select parcel count as "1 Parcel"
    #And Select "Parcel 1" to enter details as
    #And Parcel 1 Weight= "1"
    #And Parcel 1 Length= "11"
    #And Parcel 1 Width= "11"
    #And Parcel 1 Height= "11"
    #And Click on Next button
    #Then Step "Parcel Dimensions" completed

# Scenario: Verifying if user is able to complete step 3 "Select Your Service" with valid data
  #  When User click on Show all options
    #When Select default service type
    #And Click on Confirm button
    #Then Step "Select Your Service" completed

#  Scenario: Verifying if user is able to complete user REGISTRATION part of step 4 "Collection & Delivery Details" with valid data
    #And User enter details to register
      #| usertype       | Company                |
      #| companyname    | sendAParcelDomestic    |
      #| vatNumber      | Vat123                 |
      #| billingaddress |                        |
      #| propertytype   | Home                   |
      #| det1           |                        |
      #| det2           |                        |
     # | det3           |                        |
      #| det4           |                        |
      #| mobile         | 1234567890             |
     # | telephone      |                        |
      #| email          | democompany1@ram.co.za |
      #| password       | demo123                |
     # | cpassword      | demo123                |

    #And Click on Button "Use Collection Address"
    #And Click on Submit button
    #Then Send Address page get opened

#  Scenario: Verifying if user is able to complete step 4 "Collection & Delivery Details" with valid data
    #  details of the person from collect parcel
    #When User enter collection details as  collection_Firstname="Swati"
    #And Collection_Surname="Thakare"
    #And Collection_Mobile no="1234567890"
    #And Collection_email address="swati.winji123@gmail.com"
    #And Collection_Property type="Home"
   #  details of the person to deliver parcel
    #And User enter delivery details as  delivery_Firstname="SSP"
    #And Delivery_Surname="SThakare"
    #And Delivery_Mobile no="1234567890"
    #And Delivery_email address="swati.winji123@gmail.com"
    #And Delivery_Property type="Home"
    # Firearm details
    #And User enter Firearm details as Firearm_Id="123"
    #And Select Firearm_Type="Pistol"
    #And Make of Firearm="Make123"
    #And Firearm serial number="123"
    #And Firearm has telescope="Yes"
    #And Firearm Magazines="2"
    #And Firearm other="none"
    #And Click on Submit button
    #Then Send Confirm page get opened

     #Scenario: Verify user is able to complete the payment selection step
    #And Select payment type="Pay with Instant EFT"
    #And Accept terms and condition
    #And Click on Confirm and Proceed to Payment button
    #Then User navigated to secure EFT payment page
    #And Close the application
   # And Open Application

      #__________________________________Domestic with non registered User and Use Delivery Address as a billing address in registration form ____________________________________________#

  #Scenario: Domestic-send a parcel: Verifying if user is able to use delivery address as a billing address to registered with valid data
    #Case 1-for non registered user
    #Scenario: Verifying if user is able to complete step 1 "Start your order" with valid data
    #Given User Click on Send a Parcel menu
    #When Select parcel send type as "Domestic"
    #And Select parcelType as a "Parcel"
   # And Select parcelContent as "No"
    #And Enter collection address as "21 Wrench Road, Isando, Kempton Park, South Africa"
    #And Enter delivery address as "23 Isando Road, Isando, Kempton Park, South Africa"
    #And Click on Next button
    #Then Step "Start Your Order" completed
#  Scenario: Verifying if user is able to complete step 2 "Parcel Dimensions" with valid data
    #When Select parcel count as "1 Parcel"
    #And Select "Parcel 1" to enter details as
    #And Parcel 1 Weight= "1"
    #And Parcel 1 Length= "11"
    #And Parcel 1 Width= "11"
    #And Parcel 1 Height= "11"
   # And Click on Next button
    #Then Step "Parcel Dimensions" completed
# Scenario: Verifying if user is able to complete step 3 "Select Your Service" with valid data
    #When User click on Show all options
    #And Select service type "Express Road"
    #And Click on Confirm button
    #Then Step "Select Your Service" completed
#  Scenario: Verifying if user is able to complete user REGISTRATION part of step 4 "Collection & Delivery Details" with valid data
    #When User enter details to register
     # | usertype       | Private            |
      #| companyname    | Swati              |
      #| vatNumber      | Thakare123         |
      #| billingaddress |                    |
      #| propertytype   | Home               |
      #| det1           |                    |
      #| det2           |                    |
      #| det3           |                    |
      #| det4           |                    |
      #| mobile         | 1234567890         |
      #| telephone      |                    |
      #| email          | test111@test12.com |
      #| password       | test12345          |
      #| cpassword      | test12345          |
    #And Click on Button "Use Delivery Address"
    #And Click on Submit button
    #Then Send Address page get opened

#  Scenario: Verifying if user is able to complete step 4 "Collection & Delivery Details" with valid data
    #  details of the person from collect parcel
    #When User enter collection details as  collection_Firstname="Swati"
   # And Collection_Surname="Thakare"
    #And Collection_Mobile no="1234567890"
    #And Collection_email address="swati.winji123@gmail.com"
   # And Collection_Property type="Home"
   #  details of the person to deliver parcel
    #And User enter delivery details as  delivery_Firstname="SSP"
    #And Delivery_Surname="SThakare"
    #And Delivery_Mobile no="1234567890"
    #And Delivery_email address="swati.winji123@gmail.com"
    #And Delivery_Property type="Home"
    #And Click on Submit button
    #Then Send Confirm page get opened

     #Scenario: Verify user is able to complete the payment selection step
   # And Select payment type="Pay with Instant EFT"
  #  And Accept terms and condition
 #   And Click on Confirm and Proceed to Payment button
#    Then User navigated to secure EFT payment page
   # And Close the application
  #  And Open Application

