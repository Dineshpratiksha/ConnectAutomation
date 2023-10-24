Feature: External User Resolve case after follow-up

  @DailyRegression
  Scenario Outline: External User Resolve case after follow-up
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
    Then External User Log a New Case by using town,Case_type,Case_Subtype By using SheetName "<SheetName>" and row number "<rowNumber>" in Connect System
    And External User add a file and Complete Updating Process
    And User able to Logout into Connect System
    And User switch to Tab "0"
    Given External User able to Login into Connect System with External_Username and External_password
    And User switch to Tab "1"
    And External User Verifies the Login into Connect System
    And User switch to Tab "0"
    And User enters OTP
    Then External User Navigates to Caselist and Verify the Logged Case
    Then User able to Logout into Connect System
    And User opens new Browser Tab
    Given Reginal User able to Login into Connect system With olga_Username and Olga_Password
    And User opens new Browser Tab
    And Reginal User Verifies the Login into Connect System
    And User switch to Tab "2"
    And User enters OTP
    And Reginal User Navigates to Caselist,Search with Latest Case id
    And Reginal User Verify whether it is assigned to Internal User by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    Then User able to Logout into Connect System
    And User opens new Browser Tab
    Given Internal User able to Login into Connect System with Internal_Username and Internal_password
    And User opens new Browser Tab
    And Internal User Verifies the Login into Connect System
    And User switch to Tab "4"
    And User enters OTP
    And Internal User Navigates to TaskList,Search with New Case Id and Update the Case by using Excelsheetdata "<SheetName>" and row number "<rowNumber>" Logged by External User
    Then User able to Logout into Connect System
    And User switch to Tab "4"
    Given Internal User able to Login into Connect System with Internal_Username and Internal_password
    And User switch to Tab "5"
    And Internal User Verifies the Login into Connect System
    And User switch to Tab "4"
    And User enters OTP
    And User Navigates to TaskList,Search with NewCase Id
    And Update the status as "Follow-up"
    Then User able to Logout into Connect System
    And User switch to Tab "0"
    Given External User able to Login into Connect System with External_Username and External_password
    And User switch to Tab "1"
    And External User Verifies the Login into Connect System
    And User switch to Tab "0"
    And User enters OTP
    And External User Navigates to TaskList,Search with Latest Case id,Click on FeedBackRequired
    And External User update the feedback of the Case
    Then User able to Logout into Connect System
    And User switch to Tab "2"
    Given Reginal User able to Login into Connect system With olga_Username and Olga_Password
    And User switch to Tab "3"
    And Reginal User Verifies the Login into Connect System
    And User switch to Tab "2"
    And User enters OTP
    And Reginal User Navigates to Caselist,Search with Latest Case id
    And Reginal User Verify whether it is assigned to Internal User by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    Then User able to Logout into Connect System
    And User switch to Tab "4"
    Given Internal User able to Login into Connect System with Internal_Username and Internal_password
    And User switch to Tab "5"
    And Internal User Verifies the Login into Connect System
    And User switch to Tab "4"
    And User enters OTP
    And User Navigates to TaskList,Search with NewCase Id
    And Update the status as "Resolved"
    Then User able to Logout into Connect System
    And User switch to Tab "0"
    Given External User able to Login into Connect System with External_Username and External_password
    And User switch to Tab "1"
    And External User Verifies the Login into Connect System
    And User switch to Tab "0"
    And User enters OTP
    And External User Navigates to TaskList,Search with Latest Case id,Click on Review Completion and Accept Resolution
    Then User able to Logout into Connect System
    And User switch to Tab "0"
    Given External User able to Login into Connect System with External_Username and External_password
    And User switch to Tab "1"
    And External User Verifies the Login into Connect System
    And User switch to Tab "0"
    And User enters OTP
    And External User Navigates to TaskList,Search with Latest Case id,Click on Complete Survey
    And User Select "Very satisfied" as the Satisfication Review
    And User Select "Excellent" as the rate of level of Service and Enter the Comment Submit the Case
    Then User able to Logout into Connect System

    Examples: 
      | SheetName       | rowNumber |
      | ConnectTestDeta |         1 |
