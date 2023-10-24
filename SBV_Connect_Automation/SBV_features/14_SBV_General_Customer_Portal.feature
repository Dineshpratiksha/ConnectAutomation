Feature: General Customer Portal

@WeeklyRegression
  Scenario Outline: General Customer Portals
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
    Then External User Navigates to Dashboard and click on Log a New case in Connect System
    And User Log a New Case by using town,Case_type,Case_Subtype By using SheetName "<SheetName>" and row number "<rowNumber>" in Connect System
    And External User add files and Complete Updating Process
    And User able to Logout into Connect System
    
    Examples: 
      | SheetName       | rowNumber |
      | ConnectTestDeta |         1 |
