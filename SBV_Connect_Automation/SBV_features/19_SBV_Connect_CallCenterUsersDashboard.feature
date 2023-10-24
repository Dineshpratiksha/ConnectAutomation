Feature: Verify the Call Center user Dashboard

  @WeeklyRegression
  Scenario Outline: Verify Call Center Agent able to log a Case and it is Visible to Call Center Manager
    When User opens the Browser
    And User Enter Connect URL and Navigate to Login Page
    And User Log in Connect System By Entering UserName as "<CallcenterAgentusername>" and password as "<CallcenterAgentpassword>"
    And User opens new Browser Tab
    And Call Center Agent User Verifies the Login into Connect System
    And User switch to Tab "0"
    And User enters OTP
    Then User Navigates to Dashboard and click on Log a New case in Connect System
    And Bank User Log a New Case by using town,Case_type,Case_Subtype By using SheetName "<SheetName>" and row number "<rowNumber>" in Connect System
    And User add a file and Complete Updating Process
    And User able to Logout into Connect System
    And User switch to Tab "0"
    And User Log in Connect System By Entering UserName as "<CallcenterAgentusername>" and password as "<CallcenterAgentpassword>"
    And User switch to Tab "1"
    And Call Center Agent User Verifies the Login into Connect System
    And User switch to Tab "0"
    And User enters OTP
    And User Navigates to Caselist and click on Select filter
    And User Verify he is able to access the respective Branch by searching with "Vaal"
    Then Branch Manager User Navigates to Caselist and Verify the Logged Case
    Then User able to Logout into Connect System
    And User switch to Tab "0"
    And User Log in Connect System By Entering UserName as "<CallcenterAgentusername>" and password as "<CallcenterAgentpassword>"
    And User switch to Tab "1"
    And Call Center Agent User Verifies the Login into Connect System
    And User switch to Tab "0"
    And User enters OTP
    And User Navigate to dashboard click on select filter button
    Then User will filter the loged Cases Nationally
    Then User will filter the local loged Cases
    Then User will filter the loged Cases By reigonaly selecting Region Value,Cash Center Value By using SheetName "<SheetName>" and row number "<rowNumber>" in Connect System
    Then User able to Logout into Connect System
    And User opens new Browser Tab
    And User Enter Connect URL and Navigate to Login Page
    And User Log in Connect System By Entering UserName as "<CallCenterManegerusername>" and password as "<CallCenterManegarpassword>"
    And User opens new Browser Tab
    And Call Center Manager User Verifies the Login into Connect System
    And User switch to Tab "2"
    And User enters OTP
    And User Navigates to Caselist and click on Select filter
    And User Verify he is able to access the respective Region by searching with "Vaal"
    Then User Navigates to Caselist and Verify the Logged Case
    Then User able to Logout into Connect System
    And User switch to Tab "2"
    And User Enter Connect URL and Navigate to Login Page
    And User Log in Connect System By Entering UserName as "<CallCenterManegerusername>" and password as "<CallCenterManegarpassword>"
    And User switch to Tab "3"
    And Call Center Manager User Verifies the Login into Connect System
    And User switch to Tab "2"
    And User enters OTP
    And User Navigate to dashboard click on select filter button
    Then User will filter the loged Cases Nationally
    Then User will filter the local loged Cases
    Then User will filter the loged Cases By reigonaly selecting Region Value,Cash Center Value By using SheetName "<SheetName>" and row number "<rowNumber>" in Connect System
    Then User able to Logout into Connect System

    Examples: 
      | SheetName | rowNumber | CallcenterAgentusername   | CallcenterAgentpassword | CallCenterManegerusername  | CallCenterManegarpassword |
      | Bank Deta |         1 | jagadishreddy@connect.com | P@ssword                | Satishlokhande@connect.com | P@ssword                  |
