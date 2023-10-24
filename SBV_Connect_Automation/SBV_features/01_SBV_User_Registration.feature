Feature: User Registration

 @DailyRegression
Scenario Outline: User Registration for SBV User
    When User opens the Browser
    And User Enter Connect URL and Navigate to Login Page
    And User Click on RegisterNow
    And User Enters Name in Registration Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And User Enters SurName in Registration Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And User Enters Email in Registration Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And User Enters Contact Number in Registration Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And User Clicks on Accept Terms and Conditions CheckBox
    And User Clicks on VerifyEmail
    And User Verify the Verification Email Sent to Respected Email
    And User opens new Browser Tab
    And User Verifies the Login into Connect System
    And User Verifies and Copy the OTT URL
    And User opens new Browser Tab
    And User Paste the OTT URL and Click on Enter
    And User successfully navigate to UserAccountsDetails Page
    And User Select UserType in Registration Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And User Select Role in Registration Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And User Enter Organisation in Registration Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And User Enter JobTitle in Registration Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And User Enter Department in Registration Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And User Enter LineManager Name in Registration Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And User Enter LineManager ContactNumber in Registration Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And User Click on next button
    And User Select CashCentres in Registration Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And User Click on Request Access button
    Then Verify the User Successfully Registered for SBV Connect
    And User opens new Browser Tab
    And User Enter Connect URL and Navigate to Login Page
    And User Log in Connect System By Entering ConnectAdminUsername as "<ConnectAdminUsername>" and ConnectAdminpassword as "<ConnectAdminpassword>" 
    And User opens new Browser Tab
    And ConnectAdmin User Verifies the Login into Connect System
    And User switch to Tab "3"
    And User enters OTP
    And User click on Manage User Access Button
    And AdminUser search the RegisteUser by EmailID
    And AdminUser click on latest Registered User
    And AdminUser Verify the status of Registered User as "SBV Pending"
    And AdminUser click on latest selected Registered User
    And AdminUser select Site Type in User approval page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And AdminUser select Cash Center in User approval page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And AdminUser Enter Comments in User approval page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And AdminUser Click on Approve button
    And AdminUser Verify the status of Registered User as "Active"
    And User opens new Browser Tab
    And User Verifies the Login into Connect System
    And User Verifies and Copy the OTT URL
    And User opens new Browser Tab
    And User Paste the OTT URL and Click on Enter
    And User Enters Password in SetUp Password Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And User Enters Re-Enter Password in SetUp Password Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And User click on Set New Password Button
    And User opens new Browser Tab
    And User Enter Connect URL and Navigate to Login Page
    And User Log in Connect System By Entering RegisteredUserName & Password
    And User opens new Browser Tab
    And User Verifies the Login into Connect System
    And User Verifies and Copy the OTT URL
    And User switch to Tab "7"
    And User enters OTP
    Then Verify the User Successfully Loged In the Connect System
    Then User able to Logout into Connect System

  Examples: 
      | SheetName             | rowNumber |ConnectAdminUsername   |ConnectAdminpassword|
      | UserRegisterationData |         1 |connectadmin@sbv.co.za |P@ssword            |

 
@DailyRegression
Scenario Outline: User Registration for Merchant User
    When User opens the Browser
    And User Enter Connect URL and Navigate to Login Page
    And User Click on RegisterNow
    And User Enters Name in Registration Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And User Enters SurName in Registration Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And User Enters Email in Registration Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And User Enters Contact Number in Registration Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And User Clicks on Accept Terms and Conditions CheckBox
    And User Clicks on VerifyEmail
    And User Verify the Verification Email Sent to Respected Email
    And User opens new Browser Tab
    And User Verifies the Login into Connect System
    And User Verifies and Copy the OTT URL
    And User opens new Browser Tab
    And User Paste the OTT URL and Click on Enter
    And User successfully navigate to UserAccountsDetails Page
    And User Select UserType in Registration Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And User Select Role in Registration Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And User Enter Organisation in Registration Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And User Enter JobTitle in Registration Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And User Enter Department in Registration Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And User Enter LineManager Name in Registration Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And User Enter LineManager ContactNumber in Registration Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And User Click on next button
    Then Verify the User Successfully Registered for SBV Connect
    And User opens new Browser Tab
    And User Enter Connect URL and Navigate to Login Page
    And User Log in Connect System By Entering ConnectAdminUsername as "<ConnectAdminUsername>" and ConnectAdminpassword as "<ConnectAdminpassword>" 
    And User opens new Browser Tab
    And ConnectAdmin User Verifies the Login into Connect System
    And User switch to Tab "3"
    And User enters OTP
    And User click on Manage User Access Button
    And AdminUser search the RegisteUser by EmailID
    And AdminUser click on latest Registered User
    And AdminUser Verify the status of Registered User as "SBV Pending"
    And AdminUser click on latest selected Registered User
    And AdminUser Click on Add Button in User approval page
    And AdminUser Select the Sites in User approval page
    And AdminUser Click on Add Selected site button in User approval page
    And AdminUser Enter Comments in User approval page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And AdminUser Click on Approve button
    And AdminUser Verify the status of Registered User as "Active"
    And User opens new Browser Tab
    And User Verifies the Login into Connect System
    And User Verifies and Copy the OTT URL
    And User opens new Browser Tab
    And User Paste the OTT URL and Click on Enter
    And User Enters Password in SetUp Password Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And User Enters Re-Enter Password in SetUp Password Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And User click on Set New Password Button
    And User opens new Browser Tab
    And User Enter Connect URL and Navigate to Login Page
    And User Log in Connect System By Entering RegisteredUserName & Password
    And User opens new Browser Tab
    And User Verifies the Login into Connect System
    And User Verifies and Copy the OTT URL
    And User switch to Tab "7"
    And User enters OTP
    Then Verify the User Successfully Loged In the Connect System
    Then User able to Logout into Connect System
    
  Examples: 
      | SheetName             | rowNumber |ConnectAdminUsername   |ConnectAdminpassword|
      | UserRegisterationData |         2 |connectadmin@sbv.co.za |P@ssword            |

 

@DailyRegression
  Scenario Outline: User Registration for Bnk User
    When User opens the Browser
    And User Enter Connect URL and Navigate to Login Page
    And User Click on RegisterNow
    And User Enters Name in Registration Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And User Enters SurName in Registration Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And User Enters Email in Registration Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And User Enters Contact Number in Registration Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And User Clicks on Accept Terms and Conditions CheckBox
    And User Clicks on VerifyEmail
    And User Verify the Verification Email Sent to Respected Email
    And User opens new Browser Tab
    And User Verifies the Login into Connect System
    And User Verifies and Copy the OTT URL
    And User opens new Browser Tab
    And User Paste the OTT URL and Click on Enter
    And User successfully navigate to UserAccountsDetails Page
    And User Select UserType in Registration Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And User Select Role in Registration Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And User Enter Organisation in Registration Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And User Enter JobTitle in Registration Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And User Enter Department in Registration Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And User Enter LineManager Name in Registration Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And User Enter LineManager ContactNumber in Registration Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And User Click on next button
    And User Select CashCentres in Registration Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And User Click on Request Access button
    Then Verify the User Successfully Registered for SBV Connect
    And User opens new Browser Tab
    And User Enter Connect URL and Navigate to Login Page
    And User Log in Connect System By Entering ConnectAdminUsername as "<ConnectAdminUsername>" and ConnectAdminpassword as "<ConnectAdminpassword>" 
    And User opens new Browser Tab
    And ConnectAdmin User Verifies the Login into Connect System
    And User switch to Tab "3"
    And User enters OTP
    And User click on Manage User Access Button
    And AdminUser search the RegisteUser by EmailID
    And AdminUser click on latest Registered User
    And AdminUser Verify the status of Registered User as "SBV Pending"
    And AdminUser click on latest selected Registered User
    And AdminUser select Customer in User approval page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And AdminUser select Site Type in User approval Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And AdminUser select Cash Center in User approval Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And AdminUser Enter Comments in User approval page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And AdminUser Click on Approve button
    And AdminUser Verify the status of Registered User as "Bank Pending"
    And User opens new Browser Tab
    And User Enter Connect URL and Navigate to Login Page
    And User Log in Connect System By Entering BankAdminUsername as "<BankAdminUsername>" and BankAdminpassword as "<BankAdminPassword>" 
    And User opens new Browser Tab
    And BankAdmin User Verifies the Login into Connect System
    And User switch to Tab "5"
    And User enters OTP
    And User click on Manage User Access Button
    And BankAdminUser search the RegisteUser by EmailID
    And BankAdminUser click on latest Registered User
    And BankAdminUser Verify the status of Registered User as "Bank Pending"
    And BankAdminUser click on latest selected Registered User
    And BankAdminUser Enter Comments in User approval page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And BankAdminUser Click on Approve button
    And BankAdminUser Verify the status of Registered User as "Active"
    And User opens new Browser Tab
    And User Verifies the Login into Connect System
    And User Verifies and Copy the OTT URL
    And User opens new Browser Tab
    And User Paste the OTT URL and Click on Enter
    And User Enters Password in SetUp Password Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And User Enters Re-Enter Password in SetUp Password Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And User click on Set New Password Button
    And User opens new Browser Tab
    And User Enter Connect URL and Navigate to Login Page
    And User Log in Connect System By Entering RegisteredUserName & Password
    And User opens new Browser Tab
    And User Verifies the Login into Connect System
    And User Verifies and Copy the OTT URL
    And User switch to Tab "9"
    And User enters OTP
    Then Verify the User Successfully Loged In the Connect System
    Then User able to Logout into Connect System
    
Examples: 
      | SheetName             | rowNumber |ConnectAdminUsername   |ConnectAdminpassword|BankAdminUsername        |BankAdminPassword|
      | UserRegisterationData |         3 |connectadmin@sbv.co.za |P@ssword            |connectnedadmin@sbv.co.za|P@ssword         |
#
#
