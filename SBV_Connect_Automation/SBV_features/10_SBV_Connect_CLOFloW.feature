Feature: Clo Flow

  @DailyRegression
  Scenario Outline: Clo Flow
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
    And External User add ten files and Complete Updating Process
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
    And Internal User Navigates to TaskList,Search with New Case Id and Update the Case it by download ten attachments By using SheetName "<SheetName>" and row number "<rowNumber>"in Internal Connect System
    Then User able to Logout into Connect System
    And User switch to Tab "4"
    Given Internal User able to Login into Connect System with Internal_Username and Internal_password
    And User switch to Tab "5"
    And Internal User Verifies the Login into Connect System
    And User switch to Tab "4"
    And User enters OTP
    And Internal User Verifies Cases and Click on SeeAll
    And User Sort SortByOption1 in SortByDropdown By using SheetName "<SheetName>" and row number "<rowNumber>" in Internal Connect System
    And User SortBy SortByOption2 in SortByDropdown By using SheetName "<SheetName>" and row number "<rowNumber>" in Internal Connect System
    And User SortBy SortByOption3 in SortByDropdown By using SheetName "<SheetName>" and row number "<rowNumber>" in Internal Connect System
    And User SortBy SortByOption4 in SortByDropdown By using SheetName "<SheetName>" and row number "<rowNumber>" in Internal Connect System
    And User SortBy SortByOption5 in SortByDropdown By using SheetName "<SheetName>" and row number "<rowNumber>" in Internal Connect System
    And User SortBy SortByOption6 in SortByDropdown By using SheetName "<SheetName>" and row number "<rowNumber>" in Internal Connect System
    Then User able to Logout into Connect System
    Given External User able to Login into Connect System with External_Username and External_password
    And User switch to Tab "0"
    Given External User able to Login into Connect System with External_Username and External_password
    And User switch to Tab "1"
    And External User Verifies the Login into Connect System
    And User switch to Tab "0"
    And User enters OTP
    Then External User Navigates to Caselist and Verify the Logged Case
    Then User able to Logout into Connect System
    And User switch to Tab "2"
    Given Reginal User able to Login into Connect system With olga_Username and Olga_Password
    And User switch to Tab "3"
    And Reginal User Verifies the Login into Connect System
    And User switch to Tab "2"
    And User enters OTP
    Then Reginal User Navigates to Caselist,Search with Latest Case id and Verify whether it is assigned to Internal User CLO Flow by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    Then User able to Logout into Connect System
    And User switch to Tab "4"
    Given Internal User able to Login into Connect System with Internal_Username and Internal_password
    And User switch to Tab "5"
    And Internal User Verifies the Login into Connect System
    And User switch to Tab "4"
    And User enters OTP
    And Internal User Navigates to TaskList,Search with New Case Id and Update the Status as Pause Timer by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    Then User able to Logout into Connect System
    And User switch to Tab "2"
    Given Reginal User able to Login into Connect system With olga_Username and Olga_Password
    And User switch to Tab "3"
    And Reginal User Verifies the Login into Connect System
    And User switch to Tab "2"
    And User enters OTP
    And Reginal User Navigates to Caselist,Search with Latest Case id and Verify whether it is assigned to Regional User by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    Then User able to Logout into Connect System
    And User switch to Tab "2"
    Given Reginal User able to Login into Connect system With olga_Username and Olga_Password
    And User switch to Tab "3"
    And Reginal User Verifies the Login into Connect System
    And User switch to Tab "2"
    And User enters OTP
    Then Reginal User Navigates to Tasklist,Search with Latest Case Id ,Click On Pause Apporval and Update the Case with Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    Then User able to Logout into Connect System
    And User switch to Tab "2"
    Given Reginal User able to Login into Connect system With olga_Username and Olga_Password
    And User switch to Tab "3"
    And Reginal User Verifies the Login into Connect System
    And User switch to Tab "2"
    And User enters OTP
    Then Reginal User Navigates to Caselist,Search with Latest Case id and Verify whether it is assigned to Internal User CLO Flow by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    Then User able to Logout into Connect System
    And User switch to Tab "4"
    Given Internal User able to Login into Connect System with Internal_Username and Internal_password
    And User switch to Tab "5"
    And Internal User Verifies the Login into Connect System
    And User switch to Tab "4"
    And User enters OTP
    And Internal User Navigates to TaskList,Search with New Case Id and Update the Status as Resolved
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
    And Reginal User Navigates to Caselist,Search with Latest Case id and Verify whether it is assigned to Regional User by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
    Then User able to Logout into Connect System
    And User switch to Tab "2"
    Given Reginal User able to Login into Connect system With olga_Username and Olga_Password
    And User switch to Tab "3"
    And Reginal User Verifies the Login into Connect System
    And User switch to Tab "2"
    And User enters OTP
    And Reginal User Navigates to TaskList,Search with Latest Case id,Click on RTL Intervention and Update the Case
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
    And Reginal User Navigates to Caselist,Search with Latest Case id and Verify whether it is assigned to Regional User by using Excelsheetdata "<SheetName>" and row number "<rowNumber>"
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
    And User switch to Tab "6"
    And User enters OTP
    And National User Navigates to TaskList,Search with Latest Case id,Click on NCS Intervention and Update the Case
    Then User able to Logout into Connect System
    And User switch to Tab "0"
    Given External User able to Login into Connect System with External_Username and External_password
    And User switch to Tab "1"
    And External User Verifies the Login into Connect System
    And User switch to Tab "0"
    And User enters OTP
    And External User Navigates to TaskList,Search with Latest Case id,Click on Review Completion and Accept Resolution
    Then User able to Logout into Connect System

    Examples: 
      | SheetName       | rowNumber |
      | ConnectTestDeta |         1 |

  @DailyRegression
  Scenario Outline: CLO Flow with AuditTrail
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
    And Reginal User Navigates to Caselist,Search with Latest Case id and Click on AuditTrail
    And Reginal User Enters Comment as "AuditTrailComment" and Submit Comments
    And Reginal User records all Date and Time Stamps in Connect System
    Then User able to Logout into Connect System

    Examples: 
      | SheetName       | rowNumber |
      | ConnectTestDeta |         1 |
