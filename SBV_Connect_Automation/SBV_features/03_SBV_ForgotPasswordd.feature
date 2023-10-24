Feature: Forgot Password

@WeeklyRegression
  Scenario Outline: Forgot Password for Bank User
  When User opens the Browser
  And User Enter Connect URL and Navigate to Login Page
  And User Click on Forgot Password in Connect Login Page
  And User Enter Valid Email Address in Connect Login Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
  And User Click on Reset Password
  And User Verify the Verification Email Sent to Respected Email
  And User opens new Browser Tab
  And User Verifies the ForgotPassword into Connect System
  And User Verifies and Copy the OTT URL
  And User opens new Browser Tab
  And User Paste the OTT URL and Click on Enter
  And User Enter Password in Finish Account SetUp Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
  And User Enter Re-Enter Password in Finish Account SetUp Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
  And User Click on Set New Password in Finish Account SetUp Page
  Then Verify the User Successfully Changed Password for SBV Connect
  And User Click on Return to Login Button
  And User able to Login into Connect System with Bank_Username as as "<BankUsername>" and Bank_Password as "<BankPassword>"
  And User opens new Browser Tab
  And User Verifies the ForgotPassword into Connect System
  And User switch to Tab "2"
  And User enters OTP
  And Verify the User able to Login to SBV Connect Home Page
  Then User able to Logout into Connect System
  
  Examples:
  | SheetName          | rowNumber | BankUsername           | BankPassword |
  | ForgotPasswordData |         1 | Connect107@connect.com | Connect@     |
  
  @WeeklyRegression
  Scenario Outline: Forgot Password for SBV User
  When User opens the Browser
  And User Enter Connect URL and Navigate to Login Page
  And User Click on Forgot Password in Connect Login Page
  And User Enter Valid SBVEmail Address in Connect Login Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
  And User Click on Reset Password
  And User Verify the Verification Email Sent to Respected Email
  And User opens new Browser Tab
  And User Verifies the SBVUserForgotPassword into Connect System
  And User Verifies and Copy the OTT URL
  And User opens new Browser Tab
  And User Paste the OTT URL and Click on Enter
  And User Enter Password in Finish Account SetUp Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
  And User Enter Re-Enter Password in Finish Account SetUp Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
  And User Click on Set New Password in Finish Account SetUp Page
  Then Verify the User Successfully Changed Password for SBV Connect
  And User Click on Return to Login Button
  And User able to Login into Connect System with SBVBank_Username as as "<SBVUsername>" and SBVBank_Password as "<SBVPassword>"
  And User opens new Browser Tab
  And User Verifies the SBVUserForgotPassword into Connect System
  And User switch to Tab "2"
  And User enters OTP
  And Verify the User able to Login to SBV Connect Home Page
  Then User able to Logout into Connect System
  
  Examples:
  | SheetName          | rowNumber | SBVUsername            | SBVPassword |
  | ForgotPasswordData |         1 | Connect109@connect.com | Connect@    |
  
  @WeeklyRegression
  Scenario Outline: Forgot Password for Merchant User
  When User opens the Browser
  And User Enter Connect URL and Navigate to Login Page
  And User Click on Forgot Password in Connect Login Page
  And User Enter Valid MerchantEmail Address in Connect Login Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
  And User Click on Reset Password
  And User Verify the Verification Email Sent to Respected Email
  And User opens new Browser Tab
  And User Verifies the MerchantUserForgotPassword into Connect System
  And User Verifies and Copy the OTT URL
  And User opens new Browser Tab
  And User Paste the OTT URL and Click on Enter 
  And User Enter Password in Finish Account SetUp Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
  And User Enter Re-Enter Password in Finish Account SetUp Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
  And User Click on Set New Password in Finish Account SetUp Page
  Then Verify the User Successfully Changed Password for SBV Connect
  And User Click on Return to Login Button
  And User able to Login into Connect System with Merchant_Username as as "<MerchantUsername>" and Merchant_Password as "<MerchantPassword>"
  And User opens new Browser Tab
  And User Verifies the MerchantUserForgotPassword into Connect System
  And User switch to Tab "2"
  And User enters OTP
  And Verify the User able to Login to SBV Connect Home Page
  Then User able to Logout into Connect System
  
  Examples:
  | SheetName          | rowNumber | MerchantUsername       | MerchantPassword |
  | ForgotPasswordData |         1 | Connect38@connect.com | Connect@         |
  
  @WeeklyRegression
  Scenario Outline: Invalid Password Criteria
    When User opens the Browser
    And User Enter Connect URL and Navigate to Login Page
    And User Click on Forgot Password in Connect Login Page
    And User Enter Valid MerchantEmail Address in Connect Login Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And User Click on Reset Password
    And User Verify the Verification Email Sent to Respected Email
    And User opens new Browser Tab
    And User Verifies the MerchantUserForgotPassword into Connect System
    And User Verifies and Copy the OTT URL
    And User opens new Browser Tab
    And User Paste the OTT URL and Click on Enter
    And User Enter Invalid Password in Finish Account SetUp Page by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    And User Click on Set New Password in Finish Account SetUp Page
    And User Verifies the Error Message is Displaying on Finish Account SetUp Page

    Examples: 
      | SheetName          | rowNumber | MerchantUsername      | MerchantPassword |
      | ForgotPasswordData |         1 | Connect38@connect.com | Connect@         |
