Feature: External Dashboards

  @WeeklyRegression
  Scenario Outline: External Dashboards
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
    And User switch to Tab "0"
    Given External User able to Login into Connect System with External_Username and External_password
    And User switch to Tab "1"
    And External User Verifies the Login into Connect System
    And User switch to Tab "0"
    And User enters OTP
    And User Navigates to Dashboard and Verify the Top Five cases in My Task
    And User Verifies the Total Cases logged,Total Cases Open,Tasks Completed in Dashboard
    And External User Clicks on Select Filters
    And External User Select Region,CashCentre,CaseType,Case_Subtype By using SheetName "<SheetName>" and row number "<rowNumber>" in External Connect System
    And External User Enters SearchwithRegion value in SearchField and click on ApplyFilters By using SheetName "<SheetName>" and row number "<rowNumber>" in External Connect System
    And External User Enters CashCenter value in SearchField and click on ApplyFilters By using SheetName "<SheetName>" and row number "<rowNumber>" in External Connect System
    And External User Enters Case_type value in SearchField and click on ApplyFilters By using SheetName "<SheetName>" and row number "<rowNumber>" in External Connect System
    And External User Enters Case_Subtype value in SearchField and click on ApplyFilters By using SheetName "<SheetName>" and row number "<rowNumber>" in External Connect System
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
    And Internal User Verifies Cases and Click on SeeAll
    And User Sort SortByOption1 in SortByDropdown By using SheetName "<SheetName>" and row number "<rowNumber>" in Internal Connect System
    And User SortBy SortByOption2 in SortByDropdown By using SheetName "<SheetName>" and row number "<rowNumber>" in Internal Connect System
    And User SortBy SortByOption3 in SortByDropdown By using SheetName "<SheetName>" and row number "<rowNumber>" in Internal Connect System
    And User SortBy SortByOption4 in SortByDropdown By using SheetName "<SheetName>" and row number "<rowNumber>" in Internal Connect System
    And User SortBy SortByOption5 in SortByDropdown By using SheetName "<SheetName>" and row number "<rowNumber>" in Internal Connect System
    And User SortBy SortByOption6 in SortByDropdown By using SheetName "<SheetName>" and row number "<rowNumber>" in Internal Connect System
    Then User able to Logout into Connect System
    And User switch to Tab "4"
    Given Internal User able to Login into Connect System with Internal_Username and Internal_password
    And User switch to Tab "5"
    And Internal User Verifies the Login into Connect System
    And User switch to Tab "4"
    And User enters OTP
    And Internal User Navigates to TaskList,Search with New Case Id
    And User Update the Case by using Excelsheetdata "<SheetName>" and row number "<rowNumber>" Logged by External User
    And Internal User Navigates to CaseList and Verify OpenCases
    And Internal User Navigates to CaseList and Verify ResolvedCases
    And Internal User Navigates to CaseList and Verify ClosedCases
    Then User able to Logout into Connect System

    Examples: 
      | SheetName       | rowNumber |
      | ConnectTestDeta |         1 |
