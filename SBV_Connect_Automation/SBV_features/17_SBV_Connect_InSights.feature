Feature: User Verify Insights Graphs

  @WeeklyRegression
  Scenario Outline: External User Verify Insights Graphs
    When User opens the Browser
    And External User able to Login into Connect System with External_Username and External_password
    And User opens new Browser Tab
    And External User Verifies the Login into Connect System
    And User switch to Tab "0"
    And User enters OTP
    Then External User Navigates to Caselist and Verify Existing case displayed
    Then User able to Logout into Connect System
    And User switch to Tab "0"
    Given External User able to Login into Connect System with External_Username and External_password
    And User switch to Tab "1"
    And External User Verifies the Login into Connect System
    And User switch to Tab "0"
    And User enters OTP
    And External User Navigates to Dashboard and click on Log a New case in Connect System
    And User Log a New Case by using town,Case_type,Case_Subtype By using SheetName "<SheetName>" and row number "<rowNumber>" in Connect System
    And External User add a file and Complete Updating Process
    And User able to Logout into Connect System
    And User switch to Tab "0"
    Given External User able to Login into Connect System with External_Username and External_password
    And User switch to Tab "1"
    And External User Verifies the Login into Connect System
    And User switch to Tab "0"
    And User enters OTP
    And User Click on Dashboard and Verify the Cases by Type,
    And User Verify the Cases by Channel
    And User Verify the Cases by CashCentre
    And User Verify the Cases by Age in Days
    And User able to Logout into Connect System

    Examples: 
      | SheetName       | rowNumber |
      | ConnectTestDeta |         1 |

  Scenario Outline: Internal User Verify Insights Graphs
    When User opens the Browser
    And External User able to Login into Connect System with External_Username and External_password
    And User opens new Browser Tab
    And External User Verifies the Login into Connect System
    And User switch to Tab "0"
    And User enters OTP
    Then External User Navigates to Caselist and Verify Existing case displayed
    Then User able to Logout into Connect System
    And User opens new Browser Tab
    Given Internal User able to Login into Connect System with Internal_Username and Internal_password
    And User opens new Browser Tab
    And Internal User Verifies the Login into Connect System
    And User switch to Tab "2"
    And User enters OTP
    Then Internal User Navigates to Dashboard and click on Log a New case in Internal Connect System
    Then Internal User Log a New Case by using town,Case_type,Case_Subtype By using SheetName "<SheetName>" and row number "<rowNumber>" in Internal Connect System
    And Internal User add a file and Complete Updating Process
    Then User able to Logout into Connect System
    And User switch to Tab "0"
    Given Internal User able to Login into Connect System with Internal_Username and Internal_password
    And User switch to Tab "1"
    And Internal User Verifies the Login into Connect System
    And User switch to Tab "0"
    And User enters OTP
    And User Click on Dashboard and Verify the Cases by Type,
    And User Verify the Cases by Channel
    And User Verify the Cases by CashCentre
    And User Verify the Cases by Age in Days
    And User able to Logout into Connect System

    Examples: 
      | SheetName       | rowNumber |
      | ConnectTestDeta |         1 |
