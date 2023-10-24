Feature: Verify the Maintanance Scenario for registered User

  @WeeklyRegression
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
    And AdminUser Cleck on Reject Button
    And AdminUser search the RegisteUser by EmailID
    And AdminUser Verify the Serch Result
    Then User able to Logout into Connect System
    And User Close the Tab "4"
    And User Close the Tab "3"
    And User Close the Tab "2"
    And User Close the Tab "1"
    And User switch to Tab "0"
    And User Enter Connect URL and Navigate to Login Page
    And User Click on RegisterNow
    And User Enters Name in Registration Page
    And User Enters SurName in Registration Page
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
    And AdminUser Sort the Users by Name in Ascending and Decending order
    And AdminUser Sort the Users by its profile type
    And AdminUser Sort the Users by Created on and last updated basis
    And AdminUser Sort the Users by its Status
    Then User able to Logout into Connect System
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
    Then User Click on Profile setting
    Then User edit the profile by clicking on edit button in profile setting
    Then User Click on Save Changes button
    Then User able to Logout into Connect System
    And User switch to Tab "3"
    And User Log in Connect System By Entering ConnectAdminUsername as "<ConnectAdminUsername>" and ConnectAdminpassword as "<ConnectAdminpassword>"
    And User switch to Tab "4"
    And ConnectAdmin User Verifies the Login into Connect System
    And User switch to Tab "3"
    And User enters OTP
    And User click on Manage User Access Button
    And AdminUser search the RegisteUser by EmailID
    And AdminUser click on latest Registered User
    And AdminUser Verify the status of Registered User as "SBV Update"
    And AdminUser click on latest selected Registered User
    And AdminUser Enters the coment once change request is Came to AdminUser
    And AdminUser Click on Approve button
    And AdminUser Verify the status of Registered User as "Active"
    Then User able to Logout into Connect System

    Examples: 
      | SheetName             | rowNumber | ConnectAdminUsername   | ConnectAdminpassword |
      | UserRegisterationData |         1 | connectadmin@sbv.co.za | P@ssword             |
