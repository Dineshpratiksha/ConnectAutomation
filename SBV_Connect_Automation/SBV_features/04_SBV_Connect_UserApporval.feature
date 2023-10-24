Feature: User Apporval

  @WeeklyRegression
  Scenario Outline: Verify Admin user is able to log in a manage user page  and decline/Reject Users pending approval
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
    And AdminUser able to Review the user Details
    And AdminUser select Site Type in User approval page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And AdminUser select Cash Center in User approval page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And AdminUser Enter Comments in User approval page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And AdminUser Cleck on Reject Button
    And AdminUser search the RegisteUser by EmailID
    And AdminUser Verify the Serch Result
    Then User able to Logout into Connect System

    Examples: 
      | SheetName             | rowNumber | ConnectAdminUsername   | ConnectAdminpassword |
      | UserRegisterationData |         9 | connectadmin@sbv.co.za | P@ssword             |

  @WeeklyRegression
  Scenario Outline: AdminUser Deactivate the Active User And View All Users
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
    And AdminUser search the RegisteUser by EmailID
    And AdminUser click on latest Registered User
    And AdminUser Enters the Comment
    And AdminUser Click on Deactivate User Button
    And AdminUser Verify the status of Registered User as "Disabled"
    And AdminUser View the Existing User
    And AdminUser View the Awaiting Approval user
    Then User able to Logout into Connect System

    Examples: 
      | SheetName             | rowNumber | ConnectAdminUsername   | ConnectAdminpassword |
      | UserRegisterationData |         1 | connectadmin@sbv.co.za | P@ssword             |
