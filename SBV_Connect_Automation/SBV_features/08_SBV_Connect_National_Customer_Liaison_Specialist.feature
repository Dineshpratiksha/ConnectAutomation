Feature: National Customer Liaison Specialist

  @WeeklyRegression
  Scenario Outline: National Customer Liaison Specialist
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
    And User switch to Tab "2"
    Given Reginal User able to Login into Connect system With olga_Username and Olga_Password
    And User switch to Tab "3"
    And Reginal User Verifies the Login into Connect System
    And User switch to Tab "2"
    And User enters OTP
    And Reginal User Navigates to Caselist,Search with Latest Case id and Verify whether it is assigned to National Customer Liasion User by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    Then User able to Logout into Connect System
    And User opens new Browser Tab
    Given National Customer Liasion User able to Login into Connect System with National_Customer_Liasion_User_Username and National_Customer_Liasion_User_password
    And User opens new Browser Tab
    And National Customer Liasion User Verifies the Login into Connect System
    And User switch to Tab "6"
    And User enters OTP
    And National Customer Liasion User Navigates to TaskList,Search with New Case Id and Update the Case by using Excelsheetdata "<SheetName>" and row number "<rowNumber>" Logged by External User
    Then User able to Logout into Connect System
    And User switch to Tab "0"
    Given External User able to Login into Connect System with External_Username and External_password
    And User switch to Tab "1"
    And External User Verifies the Login into Connect System
    And User switch to Tab "0"
    And User enters OTP
    And External User Navigates to TaskList,Search with Latest Case id,Click on Review Completion and Reject Resolution
    Then User able to Logout into Connect System
    And User switch to Tab "2"
    Given Reginal User able to Login into Connect system With olga_Username and Olga_Password
    And User switch to Tab "3"
    And Reginal User Verifies the Login into Connect System
    And User switch to Tab "2"
    And User enters OTP
    And Reginal User Navigates to Caselist,Search with Latest Case id and Verify whether it is assigned to National Customer Liasion User by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    Then User able to Logout into Connect System
    And User switch to Tab "6"
    Given National Customer Liasion User able to Login into Connect System with National_Customer_Liasion_User_Username and National_Customer_Liasion_User_password
    And User switch to Tab "7"
    And National Customer Liasion User Verifies the Login into Connect System
    And User switch to Tab "6"
    And User enters OTP
    And National Customer Liasion User User Navigates to TaskList,Search with Latest Case id,Click on RTL Intervention and Update the Case
    Then User able to Logout into Connect System
    And User switch to Tab "0"
    Given External User able to Login into Connect System with External_Username and External_password
    And User switch to Tab "1"
    And External User Verifies the Login into Connect System
    And User switch to Tab "0"
    And User enters OTP
    And External User Navigates to TaskList,Search with Latest Case id,Click on Review Completion and Reject Resolution
    Then User able to Logout into Connect System
    And User switch to Tab "2"
    Given Reginal User able to Login into Connect system With olga_Username and Olga_Password
    And User switch to Tab "3"
    And Reginal User Verifies the Login into Connect System
    And User switch to Tab "2"
    And User enters OTP
    And Reginal User Navigates to Caselist,Search with Latest Case id and Assign to National User by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    Then User able to Logout into Connect System
    And User opens new Browser Tab
    Given National User able to Login into Connect system with lauren_Username and lauren_password
    And User opens new Browser Tab
    And National User Verifies the Login into Connect System
    And User switch to Tab "8"
    And User enters OTP
    And National User Navigates to TaskList,Search with Latest Case id,Click on NCS Intervention and Update the Case
    Then User able to Logout into Connect System
    And User switch to Tab "0"
    Given External User able to Login into Connect System with External_Username and External_password
    And User switch to Tab "1"
    And External User Verifies the Login into Connect System
    And User switch to Tab "0"
    And User enters OTP
    And External User Navigates to TaskList,Search with Latest Case id,Click on Review Completion and Reject Resolution
    Then User able to Logout into Connect System
    And User switch to Tab "2"
    Given Reginal User able to Login into Connect system With olga_Username and Olga_Password
    And User switch to Tab "3"
    And Reginal User Verifies the Login into Connect System
    And User switch to Tab "2"
    And User enters OTP
    And Reginal User Navigates to Caselist,Search with Latest Case id and Verify whether it is assigned to National Customer Liasion User by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    Then User able to Logout into Connect System
    And User switch to Tab "6"
    Given National Customer Liasion User able to Login into Connect System with National_Customer_Liasion_User_Username and National_Customer_Liasion_User_password
    And User switch to Tab "7"
    And National Customer Liasion User Verifies the Login into Connect System
    And User switch to Tab "6"
    And User enters OTP
    And National Customer Liasion User User Navigates to TaskList,Search with Latest Case id,Click on NCSM Intervention and Update the Case
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
