Feature: Verify National Bank User Loged Case Visible to Regional Bank User

  @WeeklyRegression
  Scenario Outline: Verify the Branch Manager should log a Case and it is visible to higher Users
    When User opens the Browser
    And User Enter Connect URL and Navigate to Login Page
    And User Log in Connect System By Entering UserName as "<BranchManegerusername>" and password as "<BranchManegarpassword>"
    And User opens new Browser Tab
    And Branch Manager User Verifies the Login into Connect System
    And User switch to Tab "0"
    And User enters OTP
    Then User Navigates to Dashboard and click on Log a New case in Connect System
    And Bank User Log a New Case by using town,Case_type,Case_Subtype By using SheetName "<SheetName>" and row number "<rowNumber>" in Connect System
    And User add a file and Complete Updating Process
    And User able to Logout into Connect System
    And User switch to Tab "0"
    And User Log in Connect System By Entering UserName as "<BranchManegerusername>" and password as "<BranchManegarpassword>"
    And User switch to Tab "1"
    And Branch Manager User Verifies the Login into Connect System
    And User switch to Tab "0"
    And User enters OTP
    And User Navigates to Caselist and click on Select filter
    And User Verify he is able to access the respective Branch by searching with "Vaal"
    Then Branch Manager User Navigates to Caselist and Verify the Logged Case
    Then User able to Logout into Connect System
    And User switch to Tab "0"
    And User Log in Connect System By Entering UserName as "<BranchManegerusername>" and password as "<BranchManegarpassword>"
    And User switch to Tab "1"
    And Branch Manager User Verifies the Login into Connect System
    And User switch to Tab "0"
    And User enters OTP
    And User Navigate to dashboard click on select filter button
    Then User will filter the loged Cases Nationally
    Then User will filter the local loged Cases
    Then User able to Logout into Connect System
    And User opens new Browser Tab
    And User Enter Connect URL and Navigate to Login Page
    And User Log in Connect System By Entering UserName as "<RegionalManagerUserName>" and password as "<RegionalManagerPassword>"
    And User opens new Browser Tab
    And Regional Manager User Verifies the Login into Connect System
    And User switch to Tab "2"
    And User enters OTP
    And User Navigates to Caselist and click on Select filter
    And User Verify he is able to access the respective Region by searching with "Gauteng"
    Then Regional Manager User Navigates to Caselist and Verify the Logged Case
    Then User able to Logout into Connect System
    And User switch to Tab "2"
    And User Log in Connect System By Entering UserName as "<RegionalManagerUserName>" and password as "<RegionalManagerPassword>"
    And User switch to Tab "3"
    And Regional Manager User Verifies the Login into Connect System
    And User switch to Tab "2"
    And User enters OTP
    And User Navigate to dashboard click on select filter button
    Then User will filter the loged Cases Nationally
    Then User will filter the local loged Cases
    Then User able to Logout into Connect System
    And User opens new Browser Tab
    And User Enter Connect URL and Navigate to Login Page
    And User Log in Connect System By Entering UserName as "<NationalManegerusername>" and password as "<NationalManegarpassword>"
    And User opens new Browser Tab
    And National Maneger User Verifies the Login into Connect System
    And User switch to Tab "4"
    And User enters OTP
    And User Navigates to Caselist and click on Select filter
    And User Verify he is able to access the respective Region by searching with "Vaal"
    Then User Navigates to Caselist and Verify the Logged Case
    Then User able to Logout into Connect System
    And User switch to Tab "4"
    And User Log in Connect System By Entering UserName as "<NationalManegerusername>" and password as "<NationalManegarpassword>"
    And User switch to Tab "5"
    And National Maneger User Verifies the Login into Connect System
    And User switch to Tab "4"
    And User enters OTP
    And User Navigate to dashboard click on select filter button
    Then User will filter the loged Cases Nationally
    Then User will filter the local loged Cases
    Then User will filter the loged Cases By reigonaly selecting Region Value,Cash Center Value By using SheetName "<SheetName>" and row number "<rowNumber>" in Connect System
    Then User able to Logout into Connect System
    And User opens new Browser Tab
    And User Enter Connect URL and Navigate to Login Page
    And User Log in Connect System By Entering UserName as "<BankExecutiveUsername>" and password as "<BankExecutivePassword>"
    And User opens new Browser Tab
    And Bank Executive User Verifies the Login into Connect System
    And User switch to Tab "6"
    And User enters OTP
    And User Navigates to Caselist and click on Select filter
    And User Verify he is able to access the respective Region by searching with "Durban"
    Then User Navigates to Caselist and Verify the Logged Case
    Then User able to Logout into Connect System
    And User switch to Tab "6"
    And User Enter Connect URL and Navigate to Login Page
    And User Log in Connect System By Entering UserName as "<BankExecutiveUsername>" and password as "<BankExecutivePassword>"
    And User switch to Tab "7"
    And Bank Executive User Verifies the Login into Connect System
    And User switch to Tab "6"
    And User enters OTP
    And User Navigate to dashboard click on select filter button
    Then User will filter the loged Cases Nationally
    Then User will filter the local loged Cases
    Then User will filter the loged Cases By reigonaly selecting Region Value,Cash Center Value By using SheetName "<SheetName>" and row number "<rowNumber>" in Connect System
    Then User able to Logout into Connect System

    Examples: 
      | SheetName | rowNumber | NationalManegerusername | NationalManegarpassword | RegionalManagerUserName | RegionalManagerPassword | BranchManegerusername   | BranchManegarpassword | BankExecutiveUsername    | BankExecutivePassword |
      | Bank Deta |         1 | ajaygadade@connect.com  | P@ssword                | dipaksharma@connect.com | P@ssword                | sahilmulani@conncet.com | P@ssword              | Harikamadane@connect.com | P@ssword              |
