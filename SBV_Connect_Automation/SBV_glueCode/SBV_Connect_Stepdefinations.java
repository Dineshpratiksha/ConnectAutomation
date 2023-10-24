package SBV_glueCode;

import org.junit.Assert;
import org.openqa.selenium.Keys;

import SBV_pageObjects.SBV_Connect_CommonPageObject;
import SBV_pageObjects.SBV_Connect_Login_pageObject;
import SBV_pageObjects.SBV_Connect_PageObjects;
import SBV_testBase.TestBase;
import SBV_testBase.pageBase;
import SBV_utility.Excel_Utility;
import SBV_utility.ExceptionHandling;
import SBV_utility.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SBV_Connect_Stepdefinations {
	
	public static String NewCase;
	public static String ResolvedCaseNumber;
	public static String ClosedCaseNumber;
	public static String CaseNumber;
	public static String TotalCasesLogged;
	public static String TotalCasesOPen;
	public static String TotalCasesCompleted;
	public static String actualassignstatus;
	public static String MytaskCase1;
	public static String MytaskCase2;
	public static String MytaskCase3;
	public static String MytaskCase4;
	public static String MytaskCase5;
	public static String filepath = "./TestData/TestData_Excel/SBV_connectTestData.xlsx";
    public static String sheetName = "ConnectTestDeta";
    public static String Forgotpasswordsheet="ForgotPasswordData";
    public static String BranchManagerCase1;
    public static String RegionalManagerCase1;
    public static String NationalManagerCase1;
    public static String BankDetasheet="Bank Deta";
    

@Then("External User Navigates to Dashboard and click on Log a New case in Connect System")
public void external_User_Navigates_to_Dashboard_and_click_on_Log_a_New_case_in_Connect_System() throws Exception {

	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Dashboard, 40);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Dashboard, "dashboard");
	TestBase.RefreshPage();

	Thread.sleep(25000);
	TestBase.driver.switchTo().frame("myFrame");
	TestBase.driver.switchTo().frame("bonitaframe");
	Thread.sleep(3000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_New_Case, 40);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_New_Case, "Log a new Case");
}

@Then("External User Log a New Case by using town,Case_type,Case_Subtype By using SheetName {string} and row number \"{int}\" in Connect System")
public void external_User_Log_a_New_Case_by_using_town_Case_type_Case_Subtype_By_using_SheetName_and_row_number_in_Connect_System(String string, Integer int1) throws Throwable {
	
	Thread.sleep(5000);
	TestBase.driver.switchTo().defaultContent();
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Log_New_Case_Button,30);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Log_New_Case_Button, "Log new case button");
	TestBase.RefreshPage();

	Thread.sleep(25000);
	TestBase.driver.switchTo().frame("myFrame");
	TestBase.driver.switchTo().frame("bonitaframe");
	TestBase.driver.switchTo().frame(TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_inner_frame));
	Thread.sleep(4000);
    Excel_Utility.setExcelFile(filepath, sheetName);
    String town = Excel_Utility.getCellData(int1, 8);
    String Case_type= Excel_Utility.getCellData(int1, 35);
    String CaseSubType = Excel_Utility.getCellData(int1, 36);
    Thread.sleep(4000);
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_query_menu, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_query_menu, "CaseTypedropdown");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(Case_type), 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(Case_type), Case_type+" to select "+Case_type+"from case type dropdown");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_query_menu, 40);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_query_menu, "CaseSubTypedropdown");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(CaseSubType), 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(CaseSubType), CaseSubType+" to select "+CaseSubType+"from case Sub type dropdown");
	
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_click_next_button, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_next_button, "Next button");

    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_type_search_key, 50);
    TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_type_search_key, town, "enter data");
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_search_button, "search button");
    
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_type_search_key, 50);
    TestBase.getElements(SBV_Connect_CommonPageObject.SBV_Select_Cash_Center);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Select_Cash_Center, 500);
    TestBase.ClickViaMouse(SBV_Connect_CommonPageObject.SBV_Select_Cash_Center, "cash canter");
    
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_CIT_Number, 50);
    if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_CIT_Number, "CIT Number"))) {

        ExceptionHandling.HandleAssertion("CIT_Number is not diaplayed");
    }
    
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Region, 50);
    if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Region, "Region"))) {

    	ExceptionHandling.HandleAssertion("Region is not diaplayed");
    }
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Cash_Center, 50);

    if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Cash_Center,  "Cash_Center"))) {

    	ExceptionHandling.HandleAssertion("Cash_Center is not diaplayed");
    }
    
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_click_next_button, 30);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_next_button, "Next button");
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Select_Date, 30);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Select_Date, "Select Date");
    Thread.sleep(5000);
	Excel_Utility.setExcelFile(filepath, sheetName);
	String StopLoss_Number = Excel_Utility.getCellData_Integer(int1,32);
	String BagSeal_Number= Excel_Utility.getCellData_Integer(int1, 33);
	String Container_Number = Excel_Utility.getCellData_Integer(int1, 34);
	   
	Thread.sleep(5000);  
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Stoploss, 50);
	TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_Stoploss, StopLoss_Number, "Qusetionthree");
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_BagSeal, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_BagSeal, "new case button");
	TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_BagSeal, BagSeal_Number, "Qusetionthree");
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Container, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Container, "new case button");
	TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_Container, Container_Number, "Qusetionthree");
    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_click_next_button, 30);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_next_button, "Next button");
}

@Then("User Log a New Case by using town,Case_type,Case_Subtype By using SheetName {string} and row number \"{int}\" in Connect System")
public void User_Log_a_New_Case_by_using_town_Case_type_Case_Subtype_By_using_SheetName_and_row_number_in_Connect_System(String string, Integer int1) throws Throwable {
	Thread.sleep(5000);
	TestBase.RefreshPage();
	Thread.sleep(15000);
	TestBase.driver.switchTo().frame("myFrame");
	TestBase.driver.switchTo().frame("bonitaframe");
	TestBase.driver.switchTo().frame(TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_inner_frame));
	Thread.sleep(5000);

    Excel_Utility.setExcelFile(filepath, sheetName);
    String town = Excel_Utility.getCellData(int1, 8);
    String Case_type= Excel_Utility.getCellData(int1, 35);
    String CaseSubType = Excel_Utility.getCellData(int1, 36);
    Thread.sleep(4000);
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_query_menu, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_query_menu, "CaseTypedropdown");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(Case_type), 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(Case_type), Case_type+" to select "+Case_type+"from case type dropdown");
	
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_query_menu, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_query_menu, "CaseSubTypedropdown");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(CaseSubType), 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(CaseSubType), CaseSubType+" to select "+CaseSubType+"from case Sub type dropdown");
	
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_click_next_button, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_next_button, "Next button");

    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_type_search_key, 500);
    TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_type_search_key, town, "enter data");
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_search_button, "search button");
    
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_type_search_key, 30);
    TestBase.getElements(SBV_Connect_CommonPageObject.SBV_Select_Cash_Center);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Select_Cash_Center, 500);
    TestBase.ClickViaMouse(SBV_Connect_CommonPageObject.SBV_Select_Cash_Center, "cash canter");
    
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_CIT_Number, 50);
    if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_CIT_Number, "CIT Number"))) {

        ExceptionHandling.HandleAssertion("CIT_Number is not diaplayed");
    }
    
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Region, 50);
    if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Region, "Region"))) {

    	ExceptionHandling.HandleAssertion("Region is not diaplayed");
    }
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Cash_Center, 50);

    if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Cash_Center,  "Cash_Center"))) {

    	ExceptionHandling.HandleAssertion("Cash_Center is not diaplayed");
    }
    
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_click_next_button, 30);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_next_button, "Next button");
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Select_Date, 30);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Select_Date, "Select Date");
    Thread.sleep(5000);
    
	Excel_Utility.setExcelFile(filepath, sheetName);
	String StopLoss_Number = Excel_Utility.getCellData_Integer(int1,32);
	String BagSeal_Number= Excel_Utility.getCellData_Integer(int1, 33);
	String Container_Number = Excel_Utility.getCellData_Integer(int1, 34);
	
	Thread.sleep(5000);  
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Stoploss, 50);
	TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_Stoploss, StopLoss_Number, "Qusetionthree");
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_BagSeal, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_BagSeal, "new case button");
	TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_BagSeal, BagSeal_Number, "Qusetionthree");
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Container, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Container, "new case button");
	TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_Container, Container_Number, "Qusetionthree");
    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_click_next_button, 40);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_next_button, "Next button");
}


@Then("External User Log a New Case by using town,Case_type,Case_Subtype By using SheetName {string} and row number \"{int}\" in Internal Connect System")
public void external_User_Log_a_New_Case_by_using_town_Case_type_Case_Subtype_By_using_SheetName_and_row_number_in_Internal_Connect_System(String string, Integer int1) throws Throwable {

	Thread.sleep(4000);
	TestBase.RefreshPage();
	Thread.sleep(15000);
	TestBase.driver.switchTo().frame("myFrame");
	TestBase.driver.switchTo().frame("bonitaframe");
	TestBase.driver.switchTo().frame(TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_inner_frame));
	
    Excel_Utility.setExcelFile(filepath, sheetName);
    String town = Excel_Utility.getCellData(int1, 8);
    String Case_type= Excel_Utility.getCellData(int1, 35);
    String CaseSubType = Excel_Utility.getCellData(int1, 36);
	
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_query_menu, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_query_menu, "CaseTypedropdown");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(Case_type), 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(Case_type), Case_type+" to select "+Case_type+"from case type dropdown");
	
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_query_menu, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_query_menu, "CaseSubTypedropdown");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(CaseSubType), 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(CaseSubType), CaseSubType+" to select "+CaseSubType+"from case Sub type dropdown");
	
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_click_next_button, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_next_button, "Next button");

    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_type_search_key, 50);
    TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_type_search_key, town, "enter data");
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_search_button, "search button");
    
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_type_search_key, 40);
    TestBase.getElements(SBV_Connect_CommonPageObject.SBV_Select_Cash_Center);
    TestBase.ClickViaMouse(SBV_Connect_CommonPageObject.SBV_Select_Cash_Center, "cash canter");
    
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_CIT_Number, 40);
    if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_CIT_Number, "CIT Number"))) {

        ExceptionHandling.HandleAssertion("CIT_Number is not diaplayed");
    }
    
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Region, 40);
    if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Region, "Region"))) {

    	ExceptionHandling.HandleAssertion("Region is not diaplayed");
    }
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Cash_Center, 40);

    if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Cash_Center,  "Cash_Center"))) {

    	ExceptionHandling.HandleAssertion("Cash_Center is not diaplayed");
    }
    
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_click_next_button, 40);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_next_button, "Next button");
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Select_Date, 40);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Select_Date, "Select Date");
    Thread.sleep(5000);
	Excel_Utility.setExcelFile(filepath, sheetName);
	String StopLoss_Number = Excel_Utility.getCellData_Integer(int1,32);
	String BagSeal_Number= Excel_Utility.getCellData_Integer(int1, 33);
	String Container_Number = Excel_Utility.getCellData_Integer(int1, 34);
	   
	Thread.sleep(5000);  
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Stoploss, 40);
	TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_Stoploss, StopLoss_Number, "Qusetionthree");
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_BagSeal, 40);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_BagSeal, "new case button");
	TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_BagSeal, BagSeal_Number, "Qusetionthree");
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Container, 40);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Container, "new case button");
	TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_Container, Container_Number, "Qusetionthree");
    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_click_next_button, 40);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_next_button, "Next button");
}

@Given("User Log a New Case by Entering Invalid data By using SheetName {string} and row number \"{int}\" in Connect System")
public void user_Log_a_New_Case_by_Entering_Invalid_data_By_using_SheetName_and_row_number_in_Connect_System(String string, Integer int1) throws Throwable {
	
	Thread.sleep(4000);
	TestBase.RefreshPage();
	Thread.sleep(25000);
	TestBase.driver.switchTo().frame("myFrame");
	TestBase.driver.switchTo().frame("bonitaframe");
	TestBase.driver.switchTo().frame(TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_inner_frame));

    Excel_Utility.setExcelFile(filepath, sheetName);
    String town = Excel_Utility.getCellData(int1, 8);
    String Case_type= Excel_Utility.getCellData(int1, 35);
    String CaseSubType = Excel_Utility.getCellData(int1, 36);
	
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_query_menu, 40);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_query_menu, "CaseTypedropdown");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(Case_type), 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(Case_type), Case_type+" to select "+Case_type+"from case type dropdown");
	
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_query_menu, 40);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_query_menu, "CaseSubTypedropdown");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(CaseSubType), 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(CaseSubType), CaseSubType+" to select "+CaseSubType+"from case Sub type dropdown");
	
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_click_next_button, 40);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_next_button, "Next button");

    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_type_search_key, 40);
    TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_type_search_key, town, "enter data");
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_search_button, "search button");
    
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_type_search_key, 40);
    TestBase.getElements(SBV_Connect_CommonPageObject.SBV_Select_Cash_Center);
    TestBase.ClickViaMouse(SBV_Connect_CommonPageObject.SBV_Select_Cash_Center, "cash canter");
    
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_CIT_Number, 50);
    if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_CIT_Number, "CIT Number"))) {

        ExceptionHandling.HandleAssertion("CIT_Number is not diaplayed");
    }
    
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Region, 40);
    if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Region, "Region"))) {

    	ExceptionHandling.HandleAssertion("Region is not diaplayed");
    }
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Cash_Center, 40);

    if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Cash_Center,  "Cash_Center"))) {

    	ExceptionHandling.HandleAssertion("Cash_Center is not diaplayed");
    }
    
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_click_next_button, 40);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_next_button, "Next button");
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Select_Date, 40);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Select_Date, "Select Date");
}

@Given("External User Enters and Veify StopLossNumber as {string}")
public void external_User_Enters_and_Veify_StopLossNumber_as(String StopLoss_Number) throws Exception {
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Stoploss, 40);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Stoploss, "Select Date");
	TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_Stoploss, StopLoss_Number, "Qusetionthree");
	Thread.sleep(3000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Stoploss_errorMessage, 40);
   if (!(TestBase.isElementVisible(SBV_Connect_PageObjects.SBV_Stoploss_errorMessage, "Region"))) {

   	ExceptionHandling.HandleAssertion("StopLossNumber is not diaplayed");
   }
}

@Given("External User Enters and Veify BagSealNumber as {string}")
public void external_User_Enters_and_Veify_BagSealNumber_as(String BagSeal_Number) throws Exception {
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_BagSeal, 40);
	TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_BagSeal, BagSeal_Number, "Qusetionthree");
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_BagSeal_errorMessage, 40);
   if (!(TestBase.isElementVisible(SBV_Connect_PageObjects.SBV_BagSeal_errorMessage, "Region"))) {

   	ExceptionHandling.HandleAssertion("BagSealNumber is not diaplayed");
   }
}

@Given("External User Enters and Veify ContainerNumber as {string}")
public void external_User_Enters_and_Veify_ContainerNumber_as(String Container_Number) throws Exception {
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Container, 40);
	TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_Container, Container_Number, "Qusetionthree");
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Container_errorMessage, 40);
   if (!(TestBase.isElementVisible(SBV_Connect_PageObjects.SBV_Container_errorMessage, "Region"))) {

   	ExceptionHandling.HandleAssertion("ContainerNumber is not diaplayed");
   }
}

@Given("External User Enters and Verify Value as {string}")
public void external_User_Enters_and_Verify_Value_as(String Value) throws Exception {
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Value, 40);
	TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_Value, Value, "Qusetionthree");
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Value_errorMessage, 40);
   if (!(TestBase.isElementVisible(SBV_Connect_PageObjects.SBV_Value_errorMessage, "Region"))) {

   	ExceptionHandling.HandleAssertion("ContainerNumber is not diaplayed");
   }
}

@Then("External User add a file and Complete Updating Process")
public void external_User_add_a_file_and_Complete_Updating_Process() throws Exception {

    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AddFile, 40);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AddFile, "AddFile button");

    String PdfFile = "TestData/UploadFiles/dummy.pdf";
    TestBase.FileUpload(SBV_Connect_CommonPageObject.SBV_Uploadfile1, PdfFile);
    
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Add_Notes, 40);
    TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_Add_Notes, "Testing", "Enter Notes");
    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Submit_Button, 500);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Submit_Button, "Submit button");
    Thread.sleep(6000);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Logcase_Successful_Message, 500);
    if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Logcase_Successful_Message, "Succussufuly Log"))) {

    	ExceptionHandling.HandleAssertion("Succesful Message is not diaplayed");
    }
}

@When("External User add files and Complete Updating Process")
public void external_User_add_files_and_Complete_Updating_Process() throws Exception {
	    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AddFile, 40);
	    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AddFile, "AddFile button");
	    Thread.sleep(3000);
	    String VideoFile = "TestData/UploadFiles/VideoFile.mp4";
	    TestBase.FileUpload(SBV_Connect_CommonPageObject.SBV_Uploadfile1, VideoFile);
	    Thread.sleep(16000);
	    
	    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AddFile, 40);
	    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AddFile, "AddFile button");
	    String PdfFile = "TestData/UploadFiles/dummy.pdf";
	    TestBase.FileUpload(SBV_Connect_CommonPageObject.SBV_Uploadfile2, PdfFile);
	    
	    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AddFile, 40);
	    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AddFile, "AddFile button");
	    Thread.sleep(3000);
	    String PPTFile = "TestData/UploadFiles/pptxfile.pptx";
	    TestBase.FileUpload(SBV_Connect_CommonPageObject.SBV_Uploadfile3, PPTFile);
	    
	    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AddFile, 40);
	    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AddFile, "AddFile button");
	    Thread.sleep(3000);
	    String CSVFile = "TestData/UploadFiles/CSVFile.csv";
	    TestBase.FileUpload(SBV_Connect_CommonPageObject.SBV_Uploadfile4, CSVFile);
	    
	    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AddFile, 40);
	    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AddFile, "AddFile button");
	    Thread.sleep(3000);
	    String ExcelFile1 = "TestData/UploadFiles/Excelfile.xlsx";
	    TestBase.FileUpload(SBV_Connect_CommonPageObject.SBV_Uploadfile5, ExcelFile1);
	    
	    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Add_Notes, 40);
	    TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_Add_Notes, "Testing", "Enter Notes");
	    
	    Thread.sleep(25000);
	    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Submit_Button, 40);
	    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Submit_Button, "Submit button");
	    
	    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Logcase_Successful_Message, 500);
	    if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Logcase_Successful_Message, "Succussufuly Log"))) {

	    	ExceptionHandling.HandleAssertion("Succesful Message is not diaplayed");
	    }
}


@Then("Internal User add a file and Complete Updating Process")
public void internal_User_add_a_file_and_Complete_Updating_Process() throws Exception {

	    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AddFile, 40);
	    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AddFile, "AddFile button");
	    Thread.sleep(3000);

	    String PdfFile = "TestData/UploadFiles/dummy.pdf";
	    TestBase.FileUpload(SBV_Connect_CommonPageObject.SBV_Uploadfile1, PdfFile);

	    Thread.sleep(5000);
	    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Add_Notes, 40);
	    TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_Add_Notes, "Testing", "Enter Notes");

	    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Submit_Button, 40);
	    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Submit_Button, "Submit button");

	    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Logcase_Successful_Message, 500);
	    if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Logcase_Successful_Message, "Succussufuly Log"))) {

	        ExceptionHandling.HandleAssertion("Succesful Message is not diaplayed");
	    }
}

@Then("Internal User add ten files and Complete Updating Process")
public void internal_User_add_ten_files_and_Complete_Updating_Process() throws Exception {

    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AddFile, 40);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AddFile, "AddFile button");
    Thread.sleep(3000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_FileUpload1, 40);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_FileUpload1, "upload button");
    Thread.sleep(3000);
    Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\TestData\\AutoIT\\textfile.exe");
   
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AddFile, 40);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AddFile, "AddFile button");
    Thread.sleep(3000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_FileUpload2, 40);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_FileUpload2, "upload button");
    Thread.sleep(3000);
    Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\TestData\\AutoIT\\pptxFile.exe");
   
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AddFile, 40);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AddFile, "AddFile button");
    Thread.sleep(3000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_FileUpload3, 40);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_FileUpload3, "upload button");
    Thread.sleep(3000);
    Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\TestData\\AutoIT\\ExcelFile.exe");
   
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AddFile, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AddFile, "AddFile button");
    Thread.sleep(3000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_FileUpload4, 40);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_FileUpload4, "upload button");
    Thread.sleep(3000);
    Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\TestData\\AutoIT\\textfile.exe");
   
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AddFile, 40);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AddFile, "AddFile button");
    Thread.sleep(3000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_FileUpload5, 40);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_FileUpload5, "upload button");
    Thread.sleep(3000);
    Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\TestData\\AutoIT\\WordFile.exe");
   
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AddFile, 40);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AddFile, "AddFile button");
    Thread.sleep(3000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_FileUpload6, 40);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_FileUpload6, "upload button");
    Thread.sleep(3000);
    Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\TestData\\AutoIT\\CsvFile.exe");
   
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AddFile, 40);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AddFile, "AddFile button");
    Thread.sleep(3000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_FileUpload7, 40);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_FileUpload7, "upload button");
    Thread.sleep(3000);
    Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\TestData\\AutoIT\\ExcelFile.exe");
    
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AddFile, 40);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AddFile, "AddFile button");
    Thread.sleep(3000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_FileUpload8, 40);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_FileUpload8, "upload button");
    Thread.sleep(3000);
    Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\TestData\\AutoIT\\pptxFile.exe");
   
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AddFile, 40);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AddFile, "AddFile button");
    Thread.sleep(3000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_FileUpload9, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_FileUpload9, "upload button");
    Thread.sleep(3000);
    Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\TestData\\AutoIT\\CsvFile.exe");
   
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AddFile, 40);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AddFile, "AddFile button");
    Thread.sleep(3000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_FileUpload10, 40);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_FileUpload10, "upload button");
    Thread.sleep(3000);
    Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\TestData\\AutoIT\\textfile.exe");
    
    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Add_Notes, 50);
    TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_Add_Notes, "Testing", "Enter Notes");
    
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Submit_Button, 500);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Submit_Button, "Submit button");
    
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Logcase_Successful_Message, 500);
    if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Logcase_Successful_Message, "Succussufuly Log"))) {

    	ExceptionHandling.HandleAssertion("Succesful Message is not diaplayed");
    }
}

@Then("External User add ten files and Complete Updating Process")
public void External_User_add_ten_files_and_Complete_Updating_Process() throws Exception {

    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AddFile, 30);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AddFile, "AddFile button");
    Thread.sleep(3000);
    String PdfFile = "TestData/UploadFiles/dummy.pdf";
    TestBase.FileUpload(SBV_Connect_CommonPageObject.SBV_Uploadfile1, PdfFile);
    
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AddFile, 30);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AddFile, "AddFile button");
    Thread.sleep(3000);
    String CSVFile = "TestData/UploadFiles/CSVFile.csv";
    TestBase.FileUpload(SBV_Connect_CommonPageObject.SBV_Uploadfile2, CSVFile);
    
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AddFile, 30);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AddFile, "AddFile button");
    String ExcelFile = "TestData/UploadFiles/Excelfile.xlsx";
    TestBase.FileUpload(SBV_Connect_CommonPageObject.SBV_Uploadfile3, ExcelFile);
    
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AddFile, 30);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AddFile, "AddFile button");
    String PPTFile = "TestData/UploadFiles/pptxfile.pptx";
    TestBase.FileUpload(SBV_Connect_CommonPageObject.SBV_Uploadfile4, PPTFile);
    
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AddFile, 30);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AddFile, "AddFile button");
    String TextFile = "TestData/UploadFiles/TextFileUpload.txt";
    TestBase.FileUpload(SBV_Connect_CommonPageObject.SBV_Uploadfile5, TextFile);
    
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AddFile, 30);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AddFile, "AddFile button");
    Thread.sleep(3000);
    String DocFile = "TestData/UploadFiles/wordfile.docx";
    TestBase.FileUpload(SBV_Connect_CommonPageObject.SBV_Uploadfile6, DocFile);
    
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AddFile, 30);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AddFile, "AddFile button");
    Thread.sleep(3000);
    String CSVFile1 = "TestData/UploadFiles/CSVFile.csv";
    TestBase.FileUpload(SBV_Connect_CommonPageObject.SBV_Uploadfile7, CSVFile1);
    
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AddFile, 30);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AddFile, "AddFile button");
    Thread.sleep(3000);
    String DocFile1 = "TestData/UploadFiles/wordfile.docx";
    TestBase.FileUpload(SBV_Connect_CommonPageObject.SBV_Uploadfile8, DocFile1);
    
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AddFile, 30);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AddFile, "AddFile button");
    Thread.sleep(3000);
    String TextFile1 = "TestData/UploadFiles/TextFileUpload.txt";
    TestBase.FileUpload(SBV_Connect_CommonPageObject.SBV_Uploadfile9, TextFile1);
    
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AddFile, 30);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AddFile, "AddFile button");
    Thread.sleep(3000);
    String ExcelFile1 = "TestData/UploadFiles/Excelfile.xlsx";
    TestBase.FileUpload(SBV_Connect_CommonPageObject.SBV_Uploadfile10, ExcelFile1);
    
    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Add_Notes, 30);
    TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_Add_Notes, "Testing", "Enter Notes");
   
    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Submit_Button, 500);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Submit_Button, "Submit button");
    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Logcase_Successful_Message, 500);
    if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Logcase_Successful_Message, "Succussufuly Log"))) {

    	ExceptionHandling.HandleAssertion("Succesful Message is not diaplayed");
    }
}



@Given("Reginal User Verify whether it is assigned to Internal User by using Excelsheetdata {string} and row number {string}")
public void reginal_User_Verify_whether_it_is_assigned_to_Internal_User_by_using_Excelsheetdata_and_row_number(String string, String string2) throws Throwable {
	Thread.sleep(5000);
	Excel_Utility.setExcelFile(filepath, sheetName);
    String User_level = Excel_Utility.getCellData(1, 14);
    String Cash_center = Excel_Utility.getCellData(1, 15);
    
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_UserLevel, 30);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_UserLevel, "new case button");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(User_level), 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(User_level), User_level+" to select "+User_level+"from User level dropdown");
	
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_CashCenter, 30);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_CashCenter, "new case button");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(Cash_center), 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(Cash_center), Cash_center+" to select "+Cash_center+"from Cash center dropdown");  
	Thread.sleep(3000);
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Tholana, 30);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Tholana, "new case button");
	Thread.sleep(5000);
	TestBase.ScrollDownBottom();
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Assign, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Assign, "new case button");

	String expectedassigstatus="Case successfully reassigned";
	TestBase.waitForElement(SBV_Connect_CommonPageObject.userassignstatus, 100);
	if(TestBase.isElementVisible(SBV_Connect_CommonPageObject.userassignstatus, "olgaassignstatus")) {
		actualassignstatus=TestBase.getElementText(SBV_Connect_CommonPageObject.userassignstatus, "olgastatus");
		
	}
	Assert.assertEquals(expectedassigstatus, actualassignstatus);
}

@Given("Reginal User Navigates to Caselist,Search with Latest Case id")
public void reginal_User_Navigates_to_Caselist_Search_with_Latest_Case_id() throws Throwable {

 
 Thread.sleep(5000);
 TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_see_case_list, 30);
 TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_see_case_list, "case list");
 Thread.sleep(5000);
 TestBase.RefreshPage();
 Thread.sleep(25000);
 TestBase.driver.switchTo().frame("myFrame");
 TestBase.driver.switchTo().frame("bonitaframe");
 TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_SearchByinput_olga, 30);
 TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_SearchByinput_olga, "Latestcase Number");
 System.out.println(NewCase);
 TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_SearchByinput_olga, NewCase, "Enter");
 Thread.sleep(5000);
 TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_LatestCaseNumber, 500);
 TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_LatestCaseNumber, "Latestcase Number");
 Thread.sleep(5000);
 TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AuditTrail, 30);
 TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AuditTrail, "new case button");
 TestBase.ScrollDownBottom();
 Thread.sleep(5000);
 TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Admin, 40);
 TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Admin, "new case button");
 Thread.sleep(5000);

}
@Given("User Navigates to TaskList,Search with NewCase Id")
public void user_Navigates_to_TaskList_Search_with_NewCase_Id() throws Exception {
    Thread.sleep(6000);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Task_list, 40);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Task_list, "View task list");
   
    Thread.sleep(5000);
    TestBase.RefreshPage();
    Thread.sleep(15000);
    TestBase.driver.switchTo().frame("myFrame");
    TestBase.driver.switchTo().frame("bonitaframe");

    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, "new case button");
    Thread.sleep(5000);
    System.out.println("letestcaseno"+ NewCase);
    TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_SearchByinput, NewCase, "Enter");

  for(int i=0;i<13;i++) {

      TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.LEFT));
      }

  TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.BACK_SPACE));
  
  Thread.sleep(4000);
  TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_update_Case, 500);
  TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_update_Case, "new case button");
}

@Given("Internal User Navigates to TaskList,Search with New Case Id")
public void Internal_user_Navigates_to_TaskList_Search_with_New_Case_Id() throws Exception {
	Thread.sleep(6000);
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Task_list, 30);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Task_list, "View task list");
	
	Thread.sleep(5000);
	TestBase.driver.navigate().refresh();
	Thread.sleep(25000);
	
	TestBase.driver.switchTo().frame("myFrame");
	TestBase.driver.switchTo().frame("bonitaframe");

	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, 40);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, "new case button");
	Thread.sleep(5000);
	System.out.println("letestcaseno"+ NewCase);
	TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_SearchByinput, NewCase, "Enter");

  for(int i=0;i<13;i++) {

	  TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.LEFT));
      }

  TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.BACK_SPACE));
  
  Thread.sleep(5000);
  TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_New_Case, 40);
  TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_New_Case, "new case button");
  
  TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_CIT_Number, 40);
  if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_CIT_Number, "CIT Number"))) {

	  ExceptionHandling.HandleAssertion("CIT_Number is not diaplayed");

  }
  
  TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Region, 40);
  if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Region,  "Region"))) {

	  ExceptionHandling.HandleAssertion("Region is not diaplayed");

  }
  
  TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Cash_Center, 40);
   if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Cash_Center,   "Cash_Center"))) {

    	  ExceptionHandling.HandleAssertion("Cash_Center is not diaplayed");

      }

}


@Given("User Update the Case by using Excelsheetdata {string} and row number \"{int}\" Logged by External User")
public void user_Update_the_Case_by_using_Excelsheetdata_and_row_number_Logged_by_External_User(String sheetName, Integer int1) throws Exception {

	   Excel_Utility.setExcelFile(filepath, sheetName);
	   String resolutionValue = Excel_Utility.getCellData(int1, 37);
	   String BuisnessWorkflow= Excel_Utility.getCellData(int1, 12);
	   String ResponsibleParty = Excel_Utility.getCellData(int1, 13);
	   Thread.sleep(5000);
	   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Resolution_Dropdown, 30);
	   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Resolution_Dropdown, "ResolutionDropdown");
	   TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(resolutionValue), 50);
	   TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(resolutionValue), resolutionValue+" to select "+resolutionValue+"from Resolution dropdown");
	  
	   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Business_workflow_Dropdown, 30);
	   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Business_workflow_Dropdown, "Buisness Work flow");
	   TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(BuisnessWorkflow), 50);
	   TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(BuisnessWorkflow), BuisnessWorkflow+" to select "+BuisnessWorkflow+"from Buisness Work flow dropdown");

	   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Responsible_party_Dropdown, 30);
	   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Responsible_party_Dropdown, "Resonsible Party dropdown");
	   TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(ResponsibleParty), 50);
	   TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(ResponsibleParty), ResponsibleParty+" to select "+ResponsibleParty+"from Responsible Party dropdown");

	   Thread.sleep(5000);
	   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Add_Notes, 30);
	   TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_Add_Notes, "Testing", "Enter Notes");
	   Thread.sleep(5000);
	   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Update, 30);
	   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Update, "Update button"); 

}
    
	
	@Given("External User Logs a case for {string} using {string},{string} for Customer flow")
	public void external_User_Logs_a_case_for_using_for_Customer_flow(String town, String Case_type, String Case_Subtype) throws Throwable {
	   
		Thread.sleep(5000);
		TestBase.driver.switchTo().defaultContent();
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Log_New_Case_Button,30);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Log_New_Case_Button, "Log new case button");

		Thread.sleep(4000);
	    TestBase.RefreshPage();
		Thread.sleep(15000);
		TestBase.driver.switchTo().frame("myFrame");
	    TestBase.driver.switchTo().frame("bonitaframe");
		TestBase.driver.switchTo().frame(TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_inner_frame));
		
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_query_menu, 30);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_query_menu, "CaseTypedropdown");
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(Case_type), 50);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(Case_type), Case_type+" to select "+Case_type+"from case type dropdown");
		
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_query_menu, 30);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_query_menu, "CaseSubTypedropdown");
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(Case_Subtype), 50);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(Case_Subtype), Case_Subtype+" to select "+Case_Subtype+"from case Sub type dropdown");
		
        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_click_next_button, 30);
        TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_next_button, "Next button");

        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_type_search_key, 30);
        TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_type_search_key, town, "enter data");
        TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_search_button, "search button");
        
        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_type_search_key, 30);
        TestBase.getElements(SBV_Connect_CommonPageObject.SBV_Select_Cash_Center);
        TestBase.ClickViaMouse(SBV_Connect_CommonPageObject.SBV_Select_Cash_Center, "cash canter");
        
        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_click_next_button, 30);
        TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_next_button, "Next button");
        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Select_Date, 30);
        TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Select_Date, "Select Date");
	}

	@Given("Internal User Navigates to TaskList,Search with New Case Id and Update the Case it by download ten attachments By using SheetName {string} and row number \"{int}\"in Internal Connect System")
	public void internal_User_Navigates_to_TaskList_Search_with_New_Case_Id_and_Update_the_Case_it_by_download_ten_attachments_By_using_SheetName_and_row_number_in_Internal_Connect_System(String sheetName, Integer int1) throws Exception {
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_view_task_list, 40);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_view_task_list, "View task list");
		TestBase.driver.navigate().refresh();
		
		Thread.sleep(5000);
	    TestBase.RefreshPage();
		Thread.sleep(15000);
		TestBase.driver.switchTo().frame("myFrame");
		TestBase.driver.switchTo().frame("bonitaframe");

		TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, 30);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, "new case button");
		Thread.sleep(4000);
		System.out.println(NewCase);
		TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_SearchByinput, NewCase, "Enter");

      for(int i=0;i<13;i++) {

    	  TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.LEFT));
          }

      TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.BACK_SPACE));
      
      Thread.sleep(5000);
      TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_New_Case, 30);
      TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_New_Case, "update case");

      Thread.sleep(5000);
      TestBase.waitForElement(SBV_Connect_PageObjects.SBV_DownloadedFile1, 30);
      TestBase.clickonElement(SBV_Connect_PageObjects.SBV_DownloadedFile1, "downloadedd file");
      
      Thread.sleep(5000);
      TestBase.waitForElement(SBV_Connect_PageObjects.SBV_DownloadedFile2, 30);
      TestBase.clickonElement(SBV_Connect_PageObjects.SBV_DownloadedFile2, "downloadedd file");

      Thread.sleep(5000);
      TestBase.waitForElement(SBV_Connect_PageObjects.SBV_DownloadedFile3, 30);
      TestBase.clickonElement(SBV_Connect_PageObjects.SBV_DownloadedFile3, "downloadedd file");

      Thread.sleep(5000);
      TestBase.waitForElement(SBV_Connect_PageObjects.SBV_DownloadedFile4, 30);
      TestBase.clickonElement(SBV_Connect_PageObjects.SBV_DownloadedFile4, "downloadedd file");

      Thread.sleep(5000);
      TestBase.waitForElement(SBV_Connect_PageObjects.SBV_DownloadedFile5, 30);
      TestBase.clickonElement(SBV_Connect_PageObjects.SBV_DownloadedFile5, "downloadedd file");

      Thread.sleep(5000);
      TestBase.waitForElement(SBV_Connect_PageObjects.SBV_DownloadedFile6, 30);
      TestBase.clickonElement(SBV_Connect_PageObjects.SBV_DownloadedFile6, "downloadedd file");

      Thread.sleep(5000);
      TestBase.waitForElement(SBV_Connect_PageObjects.SBV_DownloadedFile7, 30);
      TestBase.clickonElement(SBV_Connect_PageObjects.SBV_DownloadedFile7, "downloadedd file");

      Thread.sleep(5000);
      TestBase.waitForElement(SBV_Connect_PageObjects.SBV_DownloadedFile8, 30);
      TestBase.clickonElement(SBV_Connect_PageObjects.SBV_DownloadedFile8, "downloadedd file");

      Thread.sleep(5000);
      TestBase.waitForElement(SBV_Connect_PageObjects.SBV_DownloadedFile9, 30);
      TestBase.clickonElement(SBV_Connect_PageObjects.SBV_DownloadedFile9, "downloadedd file");

      Thread.sleep(5000);
      TestBase.waitForElement(SBV_Connect_PageObjects.SBV_DownloadedFile10, 30);
      TestBase.clickonElement(SBV_Connect_PageObjects.SBV_DownloadedFile10, "downloadedd file");

      Excel_Utility.setExcelFile(filepath, sheetName);
      String resolutionValue = Excel_Utility.getCellData(int1, 37);
      String BuisnessWorkflow= Excel_Utility.getCellData(int1, 12);
      String ResponsibleParty = Excel_Utility.getCellData(int1, 13);
      
      TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Resolution_Dropdown, 30);
      TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Resolution_Dropdown, "ResolutionDropdown");
      TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(resolutionValue), 30);
      TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(resolutionValue), resolutionValue+" to select "+resolutionValue+"from Resolution dropdown");
     
      TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Business_workflow_Dropdown, 30);
      TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Business_workflow_Dropdown, "Buisness Work flow");
      TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(BuisnessWorkflow), 50);
      TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(BuisnessWorkflow), BuisnessWorkflow+" to select "+BuisnessWorkflow+"from Buisness Work flow dropdown");

      TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Responsible_party_Dropdown, 30);
      TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Responsible_party_Dropdown, "Resonsible Party dropdown");
      TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(ResponsibleParty), 50);
      TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(ResponsibleParty), ResponsibleParty+" to select "+ResponsibleParty+"from Responsible Party dropdown");

	   Thread.sleep(5000);
	   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Add_Notes, 30);
	   TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_Add_Notes, "Testing", "Enter Notes");
	   
	   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Update, 500);
	   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Update, "Update button"); 
	}
	
	
	@Then("External User Navigates to Dashboard and click on Log a New case by using {string},{string},{string} in External Connect System")
	public void external_User_Navigates_to_Dashboard_and_click_on_Log_a_New_case_by_using_in_External_Connect_System(String town, String Case_type, String CaseSubType) throws Throwable {
	   
		Thread.sleep(5000);
		TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Dashboard, 30);
		TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Dashboard, "dashbord");

		Thread.sleep(5000);
	    TestBase.RefreshPage();
		Thread.sleep(15000);
		TestBase.driver.switchTo().frame("myFrame");
		TestBase.driver.switchTo().frame("bonitaframe");
		
		TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Log_New_Case,30);
		TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Log_New_Case, "Log new case button");
		
		Thread.sleep(5000);
	    TestBase.RefreshPage();
		Thread.sleep(15000);
		TestBase.driver.switchTo().frame("myFrame");
		TestBase.driver.switchTo().frame("bonitaframe");
		TestBase.driver.switchTo().frame(TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_inner_frame));
		
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_query_menu, 30);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_query_menu, "CaseTypedropdown");
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(Case_type), 50);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(Case_type), Case_type+" to select "+Case_type+"from case type dropdown");
		
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_query_menu, 30);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_query_menu, "CaseSubTypedropdown");
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(CaseSubType), 50);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(CaseSubType), CaseSubType+" to select "+CaseSubType+"from case Sub type dropdown");
		
        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_click_next_button, 30);
        TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_next_button, "Next button");

        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_type_search_key, 30);
        TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_type_search_key, town, "enter data");
        TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_search_button, "search button");
        
        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_type_search_key, 30);
        TestBase.getElements(SBV_Connect_CommonPageObject.SBV_Select_Cash_Center);
        TestBase.ClickViaMouse(SBV_Connect_CommonPageObject.SBV_Select_Cash_Center, "cash canter");
        
        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_CIT_Number, 30);
        if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_CIT_Number, "CIT Number"))) {

            ExceptionHandling.HandleAssertion("CIT_Number is not diaplayed");
        }
        
        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Region, 30);
        if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Region, "Region"))) {

        	ExceptionHandling.HandleAssertion("Region is not diaplayed");
        }
        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Cash_Center, 30);

        if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Cash_Center,  "Cash_Center"))) {

        	ExceptionHandling.HandleAssertion("Cash_Center is not diaplayed");
        }
        
        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_click_next_button, 30);
        TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_next_button, "Next button");
        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Select_Date, 30);
        TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Select_Date, "Select Date");
        
        Thread.sleep(5000);
        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Bank, 30);
        if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Bank, "Bank"))) {

        	ExceptionHandling.HandleAssertion("Bank is not diaplayed");
        }
        
        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_click_next_button, 30);
        TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_next_button, "Next button");
        
        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AddFile, 40);
        TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AddFile, "AddFile button");
        Thread.sleep(3000);

        TestBase.waitForElement(SBV_Connect_PageObjects.SBV_FileUpload1, 30);
        TestBase.clickonElement(SBV_Connect_PageObjects.SBV_FileUpload1, "upload button");
        Thread.sleep(3000);

        Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\TestData\\AutoIT\\textfile.exe");
    
        Thread.sleep(5000);
        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Add_Notes, 30);
        TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_Add_Notes, "Testing", "Enter Notes");
        
        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Submit_Button, 30);
        TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Submit_Button, "Submit button");
        
        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Logcase_Successful_Message, 500);
        if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Logcase_Successful_Message, "Succussufuly Log"))) {

        	ExceptionHandling.HandleAssertion("Succesful Message is not diaplayed");
        }

		
	}

	@Given("External User Navigates to Dashboard and Verify the Top five cases in My Task")
	public void external_User_Navigates_to_Dashboard_and_Verify_the_Top_cases_in_My_Task() throws Exception {
	   
		Thread.sleep(5000);
		TestBase.waitForElement(SBV_Connect_PageObjects.SBV_ViewDashboard, 30);
		TestBase.clickonElement(SBV_Connect_PageObjects.SBV_ViewDashboard, "dashboard file");
		
		Thread.sleep(5000);
	    TestBase.RefreshPage();
		Thread.sleep(15000);
		TestBase.driver.switchTo().frame("myFrame");
		TestBase.driver.switchTo().frame("bonitaframe"); 
		TestBase.waitForElement(SBV_Connect_PageObjects.SBV_CaseNumber, 30);
	    CaseNumber=TestBase.getElementText(SBV_Connect_PageObjects.SBV_CaseNumber, "TotalCasesLogged");
	    System.out.println(CaseNumber);
	}

	@Given("User Verifies the Total Cases logged,Total Cases Open,Tasks Completed in Dashboard")
	public void user_Verifies_the_Total_Cases_logged_Total_Cases_Open_Tasks_Completed_in_Dashboard() throws Exception {
		
		Thread.sleep(5000);
		TestBase.waitForElement(SBV_Connect_PageObjects.SBV_TotalCasesLogged, 30);
		TestBase.clickonElement(SBV_Connect_PageObjects.SBV_TotalCasesLogged, "TotalCasesLogged");
	    TotalCasesLogged=TestBase.getElementText(SBV_Connect_PageObjects.SBV_TotalCasesLogged, "TotalCasesLogged");
	    System.out.println(TotalCasesLogged);
	    
	    Thread.sleep(5000);
	    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_TotalCasesOpen, 50);
	    TotalCasesOPen=TestBase.getElementText(SBV_Connect_PageObjects.SBV_TotalCasesOpen, "TotalCasesLogged");
	    System.out.println(TotalCasesOPen);

	    Thread.sleep(5000);
	    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_TotalCasesCompleted, 50);
	    TotalCasesCompleted=TestBase.getElementText(SBV_Connect_PageObjects.SBV_TotalCasesCompleted, "TotalCasesLogged");
	    System.out.println(TotalCasesCompleted);
	    
	
	}

	@Given("External User Clicks on Select Filters")
	public void external_User_Clicks_on_Select_Filters() throws Exception {
	   
		Thread.sleep(5000);
		TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Selectfilters, 30);
		TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Selectfilters, "Select filters");
		
	}
	
	@Given("Regional User Clicks on Select Filters")
	public void Regional_User_Clicks_on_Select_Filters() throws Exception {
	   
		Thread.sleep(5000);
		TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Selectfilters, 30);
		TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Selectfilters, "Select filters");
		
	}

@Given("Internal User Enters {string} in SearchField and click on ApplyFilters")
public void internal_User_Enters_in_SearchField_and_click_on_ApplyFilters(String string) throws Exception {

	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Selectfilters, 30);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Selectfilters, "Select filters");

	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Search_field, 30);
	TestBase.clearTextbox(SBV_Connect_PageObjects.SBV_Search_field, "serch field");
	
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Search_field, "searchfield");
	TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_Search_field, string, "Seachfield");
	
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Apply_Filters, 30);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Apply_Filters, "Filterbutton");
}

	@Given("External User Select Region as {string},CashCentre as {string},CaseType as {string},CaseSubType as {string}")
	public void external_User_Select_Region_as_CashCentre_as_CaseType_as_CaseSubType_as_CustomerType_as_Transcating_Bank_as(String RegionValue, String CashcenterValue, String CaseTypevalue, String CasesubTypevalue) throws Exception {
	    
		Thread.sleep(3000);
		TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Region_Filters, 30);
		TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Region_Filters, "regin filter");
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(RegionValue), 30);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(RegionValue), RegionValue+" to select "+RegionValue+"from Region dropdown");
		
		Thread.sleep(3000);
		TestBase.waitForElement(SBV_Connect_PageObjects.SBV_ExternalCashcentre, 30);
		TestBase.clickonElement(SBV_Connect_PageObjects.SBV_ExternalCashcentre, "cashcenterDropown");
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(CashcenterValue), 50);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(CashcenterValue), CashcenterValue+" to select "+CashcenterValue+"from Cash Center dropdown");		
		
		Thread.sleep(3000);
		TestBase.waitForElement(SBV_Connect_PageObjects.SBV_CaseType, 30);
		TestBase.clickonElement(SBV_Connect_PageObjects.SBV_CaseType, "CaseTpye");
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(CaseTypevalue), 30);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(CaseTypevalue), CaseTypevalue+" to select "+CaseTypevalue+"from Case Type dropdown");		
		
		Thread.sleep(3000);
		TestBase.waitForElement(SBV_Connect_PageObjects.SBV_External_CaseSubType, 30);
		TestBase.clickonElement(SBV_Connect_PageObjects.SBV_External_CaseSubType, "CasesubTpye");
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(CasesubTypevalue), 30);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(CasesubTypevalue), CasesubTypevalue+" to select "+CasesubTypevalue+"from Case SubType dropdown");				
	
	}

	@Given("External User Enter {string} in SearchField and click on ApplyFilters")
	public void external_User_Enter_in_SearchField_and_click_on_ApplyFilters(String string) throws Exception {
		
		Thread.sleep(5000);
		TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Search_field, 30);
		TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Search_field, "searchfield");
		TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_Search_field, string, "Seachfield");
		
		Thread.sleep(5000);
		TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Apply_Filters, 30);
		TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Apply_Filters, "Filterbutton");
		
	}
	@Given("External User Enters {string} in SearchField and click on ApplyFilters")
	public void external_User_Enters_in_SearchField_and_click_on_ApplyFilters(String string) throws Exception {
		
		Thread.sleep(5000);
		TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Selectfilters, 30);
		TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Selectfilters, "Select filters");
	
		Thread.sleep(5000);
		TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Search_field, 30);
		TestBase.clearTextbox(SBV_Connect_PageObjects.SBV_Search_field, "serch field");
		
		TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Search_field, "searchfield");
		TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_Search_field, string, "Seachfield");
		
		Thread.sleep(5000);
		TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Apply_Filters, 30);
		TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Apply_Filters, "Filterbutton");

	}

	@Given("Internal User Verifies Cases and Click on SeeAll")
	public void internal_User_Verifies_Cases_and_Click_on_SeeAll() throws Exception {
	   
		Thread.sleep(5000);
		TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Dashboard, 30);
		TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Dashboard, "dashboard");
		
		Thread.sleep(5000);
	    TestBase.RefreshPage();
		Thread.sleep(25000);
		TestBase.driver.switchTo().frame("myFrame");
		TestBase.driver.switchTo().frame("bonitaframe");
		
		TestBase.waitForElement(SBV_Connect_PageObjects.SBV_See_All, 30);
		TestBase.clickonElement(SBV_Connect_PageObjects.SBV_See_All, "see all");
	    
	}

	@Given("User Sort {string} in SortByDropdown")
	public void user_Select_in_SortByDropdown(String string) throws Exception {
	    
		Thread.sleep(25000);
		TestBase.driver.switchTo().frame("myFrame");
		TestBase.driver.switchTo().frame("bonitaframe");
		
		TestBase.waitForElement(SBV_Connect_PageObjects.SBV_SortBy, 40);
		TestBase.clickonElement(SBV_Connect_PageObjects.SBV_SortBy, "sortBydropdown");
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(string), 50);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(string), string+" to select "+string+"from sortBy dropdown");
		
	}
	
	@Given("User SortBy {string} in SortByDropdown")
	public void user_SortBy_in_SortByDropdown(String string) throws Exception {
	    
		TestBase.waitForElement(SBV_Connect_PageObjects.SBV_SortBy, 40);
		TestBase.clickonElement(SBV_Connect_PageObjects.SBV_SortBy, "sortBydropdown");
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(string), 50);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(string), string+" to select "+string+"from sortBy dropdown");
		Thread.sleep(5000);
	}

	@Given("Internal User Navigates to CaseList and Verify OpenCases")
	public void internal_User_Navigates_to_CaseList_and_Verify_OpenCases() throws Throwable {
	    
		TestBase.waitForElement(SBV_Connect_PageObjects.CaseList, 40);
		TestBase.clickonElement(SBV_Connect_PageObjects.CaseList, "Caselist");
		
		Thread.sleep(5000);
	    TestBase.RefreshPage();
		Thread.sleep(25000);
		TestBase.driver.switchTo().frame("myFrame");
		TestBase.driver.switchTo().frame("bonitaframe");
		
		TestBase.waitForElement(SBV_Connect_CommonPageObject.OpenCasebutton, 40);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.OpenCasebutton, "openCasebutton");
		Thread.sleep(5000);
		 if(!TestBase.isElementVisible(SBV_Connect_CommonPageObject.NoDatastatus, "validateNodata")) {
				ExceptionHandling.HandleAssertion("data is not available");

		TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_openCasestatus, 50);
		 }else if(!TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_openCasestatus, "openCasestatus")) {
			ExceptionHandling.HandleAssertion("in progress status is not displayed");
		}
		
		 TestBase.ScrollDownBottom();
	}

	@Given("Internal User Navigates to CaseList and Verify ResolvedCases")
	public void internal_User_Navigates_to_CaseList_and_Verify_ResolvedCases() throws Throwable {

		TestBase.waitForElement(SBV_Connect_CommonPageObject.ResolvedCasebutton, 50);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.ResolvedCasebutton, "ResolvedCasebutton");
		Thread.sleep(5000);
        if(!TestBase.isElementVisible(SBV_Connect_CommonPageObject.NoDatastatus, "validateNodata")) {
			ExceptionHandling.HandleAssertion("data is not available");
			
		TestBase.waitForElement(SBV_Connect_CommonPageObject.ResolvedCasestatus, 50);
		 }else if(!TestBase.isElementVisible(SBV_Connect_CommonPageObject.ResolvedCasestatus, "ResolvedCasestatus")) {
			ExceptionHandling.HandleAssertion("resolved status is not displayed");
		}
        TestBase.ScrollDownBottom();
	}

	@Given("Internal User Navigates to CaseList and Verify ClosedCases")
	public void internal_User_Navigates_to_CaseList_and_Verify_ClosedCases() throws Throwable {
	   
		TestBase.waitForElement(SBV_Connect_CommonPageObject.ClosedCasebutton, 50);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.ClosedCasebutton, "ClosedCasebutton");
		Thread.sleep(5000);
        if(!TestBase.isElementVisible(SBV_Connect_CommonPageObject.NoDatastatus, "validateNodata")) {
			ExceptionHandling.HandleAssertion("data is not available");

		TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_ClosedCasestatus, 50);
		 }else if(!TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_ClosedCasestatus, "ClosedCasestatus")) {
			ExceptionHandling.HandleAssertion("in progress status is not displayed");
		}
        TestBase.ScrollDownBottom();
        }
	
	@Then("Internal User Navigates to Dashboard and click on Log a New case in Internal Connect System")
	public void internal_User_Navigates_to_Dashboard_and_click_on_Log_a_New_case_in_Internal_Connect_System() throws Exception {
	   
		TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Dashboard, 50);
		TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Dashboard, "dashboard");
		
		Thread.sleep(5000);
	    TestBase.RefreshPage();
		Thread.sleep(25000);
		TestBase.driver.switchTo().frame("myFrame");
		TestBase.driver.switchTo().frame("bonitaframe");
		Thread.sleep(6000);
		TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Log_New_Case, 200);
		TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Log_New_Case, "Log a new Case");
		
	}

	@Then("Internal User Log a New Case by using {string},{string},{string} in internal Connect System")
	public void internal_User_Log_a_New_Case_by_using_in_internal_Connect_System(String town, String Case_type, String CaseSubType) throws Throwable {
	   
		Thread.sleep(5000);
	    TestBase.RefreshPage();
		Thread.sleep(15000);
		TestBase.driver.switchTo().frame("myFrame");
		TestBase.driver.switchTo().frame("bonitaframe");
		TestBase.driver.switchTo().frame(TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_inner_frame));
		
		Thread.sleep(3000);
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_query_menu, 50);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_query_menu, "CaseTypedropdown");
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(Case_type), 50);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(Case_type), Case_type+" to select "+Case_type+"from case type dropdown");
		
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_query_sub_menu, 50);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_query_sub_menu, "CaseSubTypedropdown");
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(CaseSubType), 50);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(CaseSubType), CaseSubType+" to select "+CaseSubType+"from case Sub type dropdown");
		
        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_click_next_button, 50);
        TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_next_button, "Next button");

        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_type_search_key, 50);
        TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_type_search_key, town, "enter data");
        TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_search_button, "search button");
        
        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_type_search_key, 50);
        TestBase.getElements(SBV_Connect_CommonPageObject.SBV_Select_Cash_Center_Internal);
        TestBase.ClickViaMouse(SBV_Connect_CommonPageObject.SBV_Select_Cash_Center_Internal, "cash canter");
        
        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_CIT_Number, 50);
        if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_CIT_Number, "CIT Number"))) {

            ExceptionHandling.HandleAssertion("CIT_Number is not diaplayed");
        }
        
        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Region, 50);
        if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Region, "Region"))) {

        	ExceptionHandling.HandleAssertion("Region is not diaplayed");
        }
        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Cash_Center, 50);

        if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Cash_Center,  "Cash_Center"))) {

        	ExceptionHandling.HandleAssertion("Cash_Center is not diaplayed");
        }
        
        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_click_next_button, 50);
        TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_next_button, "Next button");
        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Select_Date, 50);
        TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Select_Date, "Select Date");
        
        Thread.sleep(5000);
        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_click_next_button, 50);
        TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_next_button, "Next button");
        
        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AddFile, 50);
        TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AddFile, "AddFile button");
        Thread.sleep(3000);

        TestBase.waitForElement(SBV_Connect_PageObjects.SBV_FileUpload1, 50);
        TestBase.clickonElement(SBV_Connect_PageObjects.SBV_FileUpload1, "upload button");
        Thread.sleep(3000);

        Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\TestData\\AutoIT\\fileupload.exe");
    
        Thread.sleep(5000);
        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Add_Notes, 50);
        TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_Add_Notes, "Testing", "Enter Notes");
        
        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Submit_Button, 50);
        TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Submit_Button, "Submit button");
        
        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Logcase_Successful_Message, 50);
        if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Logcase_Successful_Message, "Succussufuly Log"))) {

        	ExceptionHandling.HandleAssertion("Succesful Message is not diaplayed");
        }

	}
	

@Given("Reginal User Navigates to Caselist,Search with Latest Case id and Verify whether it is assigned to Internal User CLO Flow by using Excelsheetdata {string} and row number {string}")
public void reginal_User_Navigates_to_Caselist_Search_with_Latest_Case_id_and_Verify_whether_it_is_assigned_to_Internal_User_CLO_Flow_by_using_Excelsheetdata_and_row_number(String string, String string2) throws Throwable {

	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_see_case_list, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_see_case_list, "case list");

	Thread.sleep(5000);
	TestBase.RefreshPage();
	Thread.sleep(15000);
	TestBase.driver.switchTo().frame("myFrame");
	TestBase.driver.switchTo().frame("bonitaframe");
	
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, "SearchByfield");
	TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_SearchByinput, NewCase, "Enter");
    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_LatestCaseNumber_Reporting, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_LatestCaseNumber_Reporting, "Latestcase Number");

    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AuditTrail, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AuditTrail, "new case button");
    TestBase.ScrollDownBottom();
    
    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Admin, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Admin, "new case button");
    
    Thread.sleep(5000);

	Excel_Utility.setExcelFile(filepath, sheetName);
    String User_level = Excel_Utility.getCellData(1, 14);
    String Cash_center = Excel_Utility.getCellData(1, 15);
    
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_UserLevel, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_UserLevel, "new case button");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(User_level), 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(User_level), User_level+" to select "+User_level+"from User level dropdown");
	
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_CashCenter, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_CashCenter, "new case button");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(Cash_center), 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(Cash_center), Cash_center+" to select "+Cash_center+"from Cash center dropdown");  
	Thread.sleep(3000);
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Tholana, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Tholana, "new case button");
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Assign, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Assign, "new case button");

	String expectedassigstatus="Case successfully reassigned";
	TestBase.waitForElement(SBV_Connect_CommonPageObject.userassignstatus, 50);
	if(TestBase.isElementVisible(SBV_Connect_CommonPageObject.userassignstatus, "olgaassignstatus")) {
		actualassignstatus=TestBase.getElementText(SBV_Connect_CommonPageObject.userassignstatus, "olgastatus");
		
	}
	Assert.assertEquals(expectedassigstatus, actualassignstatus);
}
	
@Given("Reginal User Navigates to Caselist,Search with Latest Case id and Verify whether it is assigned to Internal User by using Excelsheetdata {string} and row number {string}")
public void reginal_User_Navigates_to_Caselist_Search_with_Latest_Case_id_and_Verify_whether_it_is_assigned_to_Internal_User_by_using_Excelsheetdata_and_row_number(String string, String string2) throws Throwable {

	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_see_case_list, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_see_case_list, "case list");

	Thread.sleep(25000);
	TestBase.driver.switchTo().frame("myFrame");
	TestBase.driver.switchTo().frame("bonitaframe");
	
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, "SearchByfield");
	TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_SearchByinput, NewCase, "Enter");
    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_LatestCaseNumber, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_LatestCaseNumber, "Latestcase Number");

    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AuditTrail, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AuditTrail, "new case button");
    TestBase.ScrollDownBottom();
    
    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Admin, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Admin, "new case button");
    
    Thread.sleep(5000);
	Excel_Utility.setExcelFile(filepath, sheetName);
    String User_level = Excel_Utility.getCellData(1, 14);
    String Cash_center = Excel_Utility.getCellData(1, 15);
    
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_UserLevel, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_UserLevel, "new case button");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(User_level), 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(User_level), User_level+" to select "+User_level+"from User level dropdown");
	
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_CashCenter, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_CashCenter, "new case button");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(Cash_center), 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(Cash_center), Cash_center+" to select "+Cash_center+"from Cash center dropdown");  
	Thread.sleep(3000);
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Tholana, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Tholana, "new case button");
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Assign, 40);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Assign, "new case button");

	String expectedassigstatus="Case successfully reassigned";
	TestBase.waitForElement(SBV_Connect_CommonPageObject.userassignstatus, 30);
	if(TestBase.isElementVisible(SBV_Connect_CommonPageObject.userassignstatus, "olgaassignstatus")) {
		actualassignstatus=TestBase.getElementText(SBV_Connect_CommonPageObject.userassignstatus, "olgastatus");
		
	}
	Assert.assertEquals(expectedassigstatus, actualassignstatus);
}

	@Given("User Navigates to Dashboard and Verify the Top Five cases in My Task")
	public void User_Navigates_to_Dashboard_and_Verify_the_Top_cases_in_My_Task() throws Throwable {
	    
		TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Dashboard, 50);
		TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Dashboard, "dashboard");
		
		Thread.sleep(25000);
		TestBase.driver.switchTo().frame("myFrame");
		TestBase.driver.switchTo().frame("bonitaframe");
		
		TestBase.waitForElement(SBV_Connect_PageObjects.mytaskCase1, 30);
		MytaskCase1 =TestBase.getElementText(SBV_Connect_PageObjects.mytaskCase1, "case1");
		System.out.println(MytaskCase1);
		
		Thread.sleep(5000);
		TestBase.waitForElement(SBV_Connect_PageObjects.mytaskCase2, 50);
		MytaskCase2 =TestBase.getElementText(SBV_Connect_PageObjects.mytaskCase2, "case2");
		System.out.println(MytaskCase2);
		TestBase.ScrollDownBottom();
		
		Thread.sleep(5000);
		TestBase.waitForElement(SBV_Connect_PageObjects.mytaskCase3, 50);
		MytaskCase3 =TestBase.getElementText(SBV_Connect_PageObjects.mytaskCase3, "case3");
		System.out.println(MytaskCase3);
		
		Thread.sleep(5000);
		TestBase.waitForElement(SBV_Connect_PageObjects.mytaskCase4, 50);
		MytaskCase4 =TestBase.getElementText(SBV_Connect_PageObjects.mytaskCase4, "case4");
		System.out.println(MytaskCase4);
		Thread.sleep(5000);
		TestBase.waitForElement(SBV_Connect_PageObjects.mytaskCase5, 50);
		MytaskCase5 =TestBase.getElementText(SBV_Connect_PageObjects.mytaskCase5, "case5S");
		System.out.println(MytaskCase5);
	}

	@Given("Internal User Clicks on Select Filters")
	public void internal_User_Clicks_on_Select_Filters() throws Exception {
		Thread.sleep(5000);
		TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Selectfilters, 50);
		TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Selectfilters, "Select filters");
	}

	@Given("Internal User Select Region as {string},CashCentre as {string},CaseType as {string},CaseSubType as {string},CustomerType as {string},Transcating Bank as {string}")
	public void internal_User_Select_Region_as_CashCentre_as_CaseType_as_CaseSubType_as_CustomerType_as_Transcating_Bank_as(String RegionValue, String CashcenterValue, String CaseTypevalue, String CasesubTypevalue) throws Exception {
		Thread.sleep(3000);
		TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Region_Filters, 50);
		TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Region_Filters, "regin filter");
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(RegionValue), 50);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(RegionValue), RegionValue+" to select "+RegionValue+"from Region dropdown");
		
		Thread.sleep(3000);
		TestBase.waitForElement(SBV_Connect_PageObjects.SBV_ExternalCashcentre, 50);
		TestBase.clickonElement(SBV_Connect_PageObjects.SBV_ExternalCashcentre, "cashcenterDropown");
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(CashcenterValue), 50);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(CashcenterValue), CashcenterValue+" to select "+CashcenterValue+"from Cash Center dropdown");		
		
		Thread.sleep(3000);
		TestBase.waitForElement(SBV_Connect_PageObjects.SBV_CaseType, 50);
		TestBase.clickonElement(SBV_Connect_PageObjects.SBV_CaseType, "CaseTpye");
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(CaseTypevalue), 50);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(CaseTypevalue), CaseTypevalue+" to select "+CaseTypevalue+"from Case Type dropdown");		
		
		Thread.sleep(3000);
		TestBase.waitForElement(SBV_Connect_PageObjects.SBV_External_CaseSubType, 50);
		TestBase.clickonElement(SBV_Connect_PageObjects.SBV_External_CaseSubType, "CasesubTpye");
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(CasesubTypevalue), 50);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(CasesubTypevalue), CasesubTypevalue+" to select "+CasesubTypevalue+"from Case SubType dropdown");				
	
	}

	@Given("Internal User Enter {string} in SearchField and click on ApplyFilters")
	public void internal_User_Enter_in_SearchField_and_click_on_ApplyFilters(String string) throws Exception {

		Thread.sleep(5000);
		TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Search_field, 50);
		TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Search_field, "searchfield");
		TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_Search_field, string, "Seachfield");
		
		Thread.sleep(5000);
		TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Apply_Filters, 50);
		TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Apply_Filters, "Filterbutton");
	}

	
	@Given("Regional User Navigates to Dashboard and Verify the Top Five cases in My Task")
	public void regional_User_Navigates_to_Dashboard_and_Verify_the_Top_Five_cases_in_My_Task() throws Exception {

		TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Dashboard, 50);
		TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Dashboard, "dashboard");
		
		Thread.sleep(25000);
		TestBase.driver.switchTo().frame("myFrame");
		TestBase.driver.switchTo().frame("bonitaframe");
		
		TestBase.waitForElement(SBV_Connect_PageObjects.mytaskCase1, 50);
		MytaskCase1 =TestBase.getElementText(SBV_Connect_PageObjects.mytaskCase1, "case1");
		System.out.println(MytaskCase1);
		
		TestBase.waitForElement(SBV_Connect_PageObjects.mytaskCase2, 50);
		MytaskCase2 =TestBase.getElementText(SBV_Connect_PageObjects.mytaskCase2, "case2");
		System.out.println(MytaskCase2);
		
		TestBase.waitForElement(SBV_Connect_PageObjects.mytaskCase3, 50);
		MytaskCase3 =TestBase.getElementText(SBV_Connect_PageObjects.mytaskCase3, "case3");
		System.out.println(MytaskCase3);
		
		TestBase.waitForElement(SBV_Connect_PageObjects.mytaskCase4, 50);
		MytaskCase4 =TestBase.getElementText(SBV_Connect_PageObjects.mytaskCase4, "case4");
		System.out.println(MytaskCase4);
		
		TestBase.waitForElement(SBV_Connect_PageObjects.mytaskCase5, 50);
		MytaskCase5 =TestBase.getElementText(SBV_Connect_PageObjects.mytaskCase5, "case5S");
		System.out.println(MytaskCase5);
	}


	@Given("Regional User Select Region as {string},CashCentre as {string},CaseType as {string},CaseSubType as {string},CustomerType as {string},Transcating Bank as {string}")
	public void regional_User_Select_Region_as_CashCentre_as_CaseType_as_CaseSubType_as_CustomerType_as_Transcating_Bank_as(String RegionValue, String CashcenterValue, String CaseTypevalue, String CasesubTypevalue) throws Exception {
		Thread.sleep(3000);
		TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Region_Filters, 50);
		TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Region_Filters, "regin filter");
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(RegionValue), 50);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(RegionValue), RegionValue+" to select "+RegionValue+"from Region dropdown");
		
		Thread.sleep(3000);
		TestBase.waitForElement(SBV_Connect_PageObjects.SBV_ExternalCashcentre, 50);
		TestBase.clickonElement(SBV_Connect_PageObjects.SBV_ExternalCashcentre, "cashcenterDropown");
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(CashcenterValue), 50);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(CashcenterValue), CashcenterValue+" to select "+CashcenterValue+"from Cash Center dropdown");		
		
		Thread.sleep(3000);
		TestBase.waitForElement(SBV_Connect_PageObjects.SBV_CaseType, 50);
		TestBase.clickonElement(SBV_Connect_PageObjects.SBV_CaseType, "CaseTpye");
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(CaseTypevalue), 50);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(CaseTypevalue), CaseTypevalue+" to select "+CaseTypevalue+"from Case Type dropdown");		
		
		Thread.sleep(3000);
		TestBase.waitForElement(SBV_Connect_PageObjects.SBV_External_CaseSubType, 50);
		TestBase.clickonElement(SBV_Connect_PageObjects.SBV_External_CaseSubType, "CasesubTpye");
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(CasesubTypevalue), 50);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(CasesubTypevalue), CasesubTypevalue+" to select "+CasesubTypevalue+"from Case SubType dropdown");				
	
	}

	@Given("Regional User Enter {string} in SearchField and click on ApplyFilters")
	public void regional_User_Enter_in_SearchField_and_click_on_ApplyFilters(String string) throws Exception {

		Thread.sleep(5000);
		TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Search_field, 50);
		TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Search_field, "searchfield");
		TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_Search_field, string, "Seachfield");
		
		Thread.sleep(5000);
		TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Apply_Filters, 50);
		TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Apply_Filters, "Filterbutton");
	}

	@Given("Regional User Verifies Cases and Click on SeeAll")
	public void regional_User_Verifies_Cases_and_Click_on_SeeAll() throws Exception {
		   
				TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Dashboard, 50);
				TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Dashboard, "dashboard");
				
				Thread.sleep(25000);
				TestBase.driver.switchTo().frame("myFrame");
				TestBase.driver.switchTo().frame("bonitaframe");
				
				TestBase.waitForElement(SBV_Connect_PageObjects.SBV_See_All, 50);
				TestBase.clickonElement(SBV_Connect_PageObjects.SBV_See_All, "see all");
	}


@Given("Regional User Select Region,CashCentre,CaseType,Case_Subtype By using SheetName {string} and row number \"{int}\" in Regional Connect System")
public void regional_User_Select_Region_CashCentre_CaseType_Case_Subtype_By_using_SheetName_and_row_number_in_Regional_Connect_System(String sheetName, Integer int1) throws Exception {

	Excel_Utility.setExcelFile(filepath, sheetName);
    String RegionValue = Excel_Utility.getCellData(int1, 17);
    String CashcenterValue = Excel_Utility.getCellData(int1, 18);
    String Case_type= Excel_Utility.getCellData(int1, 9);
    String CaseSubType = Excel_Utility.getCellData(int1, 50);
    String ConsumerType = Excel_Utility.getCellData(int1, 26);
    String TranscatingBank = Excel_Utility.getCellData(int1, 27);
    
	Thread.sleep(3000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Region_Filters, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Region_Filters, "regin filter");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(RegionValue), 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(RegionValue), RegionValue+" to select "+RegionValue+"from Region dropdown");
	
	Thread.sleep(3000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_ExternalCashcentre, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_ExternalCashcentre, "cashcenterDropown");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(CashcenterValue), 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(CashcenterValue), CashcenterValue+" to select "+CashcenterValue+"from Cash Center dropdown");		
	
	Thread.sleep(3000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_CaseType, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_CaseType, "CaseTpye");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(Case_type), 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(Case_type), Case_type+" to select "+Case_type+"from Case Type dropdown");		
	
	Thread.sleep(3000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_External_CaseSubType, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_External_CaseSubType, "CasesubTpye");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(CaseSubType), 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(CaseSubType), CaseSubType+" to select "+CaseSubType+"from Case SubType dropdown");				

	Thread.sleep(3000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_ConsumerType, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_ConsumerType, "ConsumerType");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(ConsumerType), 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(ConsumerType), ConsumerType+" to select "+ConsumerType+"from Case SubType dropdown");				

	Thread.sleep(3000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_TranscatingBank, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_TranscatingBank, "TranscatingBank");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(TranscatingBank), 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(TranscatingBank), TranscatingBank+" to select "+TranscatingBank+"from Case SubType dropdown");				

}

@Given("Regional User Enters SearchwithRegion value in SearchField and click on ApplyFilters By using SheetName {string} and row number \"{int}\" in Regional Connect System")
public void regional_User_Enters_SearchwithRegion_value_in_SearchField_and_click_on_ApplyFilters_By_using_SheetName_and_row_number_in_Regional_Connect_System(String sheetName, Integer int1) throws Throwable {
	Excel_Utility.setExcelFile(filepath, sheetName);
    String RegionValue = Excel_Utility.getCellData(int1, 17);
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Search_field, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Search_field, "searchfield");
	TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_Search_field, RegionValue, "Seachfield");
	
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Apply_Filters, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Apply_Filters, "Filterbutton");
	
	Thread.sleep(5000);
	TestBase.ScrollDownBottom();
}

@Given("Regional User Enters CashCenter value in SearchField and click on ApplyFilters By using SheetName {string} and row number \"{int}\" in Regional Connect System")
public void regional_User_Enters_CashCenter_value_in_SearchField_and_click_on_ApplyFilters_By_using_SheetName_and_row_number_in_Regional_Connect_System(String sheetName, Integer int1) throws Throwable {
	Excel_Utility.setExcelFile(filepath, sheetName);
    String RegionValue = Excel_Utility.getCellData(int1, 17);
    Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Selectfilters, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Selectfilters, "Select filters");
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Search_field, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Search_field, "searchfield");
	TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_Search_field, RegionValue, "Seachfield");
	
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Apply_Filters, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Apply_Filters, "Filterbutton");
	
	Thread.sleep(5000);
	TestBase.ScrollDownBottom();
}

@Given("Regional User Enters Case_type value in SearchField and click on ApplyFilters By using SheetName {string} and row number \"{int}\" in Regional Connect System")
public void regional_User_Enters_Case_type_value_in_SearchField_and_click_on_ApplyFilters_By_using_SheetName_and_row_number_in_Regional_Connect_System(String sheetName, Integer int1) throws Throwable {
	Excel_Utility.setExcelFile(filepath, sheetName);
	String CashcenterValue = Excel_Utility.getCellData(int1, 18);
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Selectfilters, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Selectfilters, "Select filters");
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Search_field, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Search_field, "searchfield");
	TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_Search_field, CashcenterValue, "Seachfield");
	
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Apply_Filters, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Apply_Filters, "Filterbutton");
	
	Thread.sleep(5000);
	TestBase.ScrollDownBottom();
}

@Given("Regional User Enters Case_Subtype value in SearchField and click on ApplyFilters By using SheetName {string} and row number \"{int}\" in Regional Connect System")
public void regional_User_Enters_Case_Subtype_value_in_SearchField_and_click_on_ApplyFilters_By_using_SheetName_and_row_number_in_Regional_Connect_System(String sheetName, Integer int1) throws Throwable {
	Excel_Utility.setExcelFile(filepath, sheetName);
	String CaseSubType = Excel_Utility.getCellData(int1, 50);
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Selectfilters, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Selectfilters, "Select filters");

	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Search_field, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Search_field, "searchfield");
	TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_Search_field, CaseSubType, "Seachfield");
	
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Apply_Filters, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Apply_Filters, "Filterbutton");
	
	Thread.sleep(5000);
	TestBase.ScrollDownBottom();
}


	@Given("Regional User Navigates to CaseList and Verify OpenCases")
	public void regional_User_Navigates_to_CaseList_and_Verify_OpenCases() throws Throwable {
		TestBase.waitForElement(SBV_Connect_PageObjects.CaseList, 50);
		TestBase.clickonElement(SBV_Connect_PageObjects.CaseList, "Caselist");
		
		Thread.sleep(25000);
		TestBase.driver.switchTo().frame("myFrame");
		TestBase.driver.switchTo().frame("bonitaframe");
		
		TestBase.waitForElement(SBV_Connect_CommonPageObject.OpenCasebutton, 50);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.OpenCasebutton, "openCasebutton");
		Thread.sleep(4000);
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_openCasestatus, 50);
		if(!TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_openCasestatus, "openCasestatus")) {
			ExceptionHandling.HandleAssertion("in progress status is not displayed");
		}
		
		TestBase.ScrollDownBottom();
	}

	@Given("Regional User Navigates to CaseList and Verify ResolvedCases")
	public void regional_User_Navigates_to_CaseList_and_Verify_ResolvedCases() throws Throwable {

		TestBase.waitForElement(SBV_Connect_CommonPageObject.ResolvedCasebutton, 50);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.ResolvedCasebutton, "ResolvedCasebutton");
		Thread.sleep(4000);
        if(!TestBase.isElementVisible(SBV_Connect_CommonPageObject.NoDatastatus, "validateNodata")) {
			ExceptionHandling.HandleAssertion("data is not available");
			
		TestBase.waitForElement(SBV_Connect_CommonPageObject.ResolvedCasestatus, 50);
		 }else if(!TestBase.isElementVisible(SBV_Connect_CommonPageObject.ResolvedCasestatus, "ResolvedCasestatus")) {
			ExceptionHandling.HandleAssertion("resolved status is not displayed");
		}

		TestBase.ScrollDownBottom();

	}

	@Given("Regional User Navigates to CaseList and Verify ClosedCases")
	public void regional_User_Navigates_to_CaseList_and_Verify_ClosedCases() throws Throwable {
		TestBase.waitForElement(SBV_Connect_CommonPageObject.ClosedCasebutton, 50);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.ClosedCasebutton, "ClosedCasebutton");
		Thread.sleep(4000);
        if(!TestBase.isElementVisible(SBV_Connect_CommonPageObject.NoDatastatus, "validateNodata")) {
			ExceptionHandling.HandleAssertion("data is not available");

		TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_ClosedCasestatus, 50);
		 }else if(!TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_ClosedCasestatus, "ClosedCasestatus")) {
			ExceptionHandling.HandleAssertion("in progress status is not displayed");
        }
        
		TestBase.ScrollDownBottom();

	}

@Given("Regional User Enters {string} in SearchField and click on ApplyFilters")
public void regional_User_Enters_in_SearchField_and_click_on_ApplyFilters(String string) throws Exception {

	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Selectfilters, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Selectfilters, "Select filters");

	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Search_field, 50);
	TestBase.clearTextbox(SBV_Connect_PageObjects.SBV_Search_field, "serch field");
	
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Search_field, "searchfield");
	TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_Search_field, string, "Seachfield");
	
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Apply_Filters, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Apply_Filters, "Filterbutton");
}


@Given("User Search with New Case Id and Update the With {string},{string},{string} Case Logged by External User")
public void User_Search_with_New_Case_Id_and_Update_the_With_Case_Logged_by_External_User(String resolutionValue, String BuisnessWorkflow, String ResponsibleParty) throws Exception {

	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, "new case button");
	TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_SearchByinput, NewCase, "Enter");

    for(int i=0;i<13;i++) {

    	TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.LEFT));

    }

    TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.BACK_SPACE));

  Thread.sleep(5000);
  TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_New_Case, 50);
  TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_New_Case, "new case button");
  
  TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_CIT_Number, 50);
  if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_CIT_Number, "CIT Number"))) {

	  ExceptionHandling.HandleAssertion("CIT_Number is not diaplayed");

  }
  
  TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Region, 50);
  if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Region,  "Region"))) {

	  ExceptionHandling.HandleAssertion("Region is not diaplayed");

  }
  
  TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Cash_Center, 50);
   if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Cash_Center,   "Cash_Center"))) {

    	  ExceptionHandling.HandleAssertion("Cash_Center is not diaplayed");

      }

   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Resolution_Dropdown, 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Resolution_Dropdown, "ResolutionDropdown");
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(resolutionValue), 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(resolutionValue), resolutionValue+" to select "+resolutionValue+"from Resolution dropdown");
  
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Business_workflow_Dropdown, 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Business_workflow_Dropdown, "Buisness Work flow");
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(BuisnessWorkflow), 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(BuisnessWorkflow), BuisnessWorkflow+" to select "+BuisnessWorkflow+"from Buisness Work flow dropdown");

   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Responsible_party_Dropdown, 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Responsible_party_Dropdown, "Resonsible Party dropdown");
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(ResponsibleParty), 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(ResponsibleParty), ResponsibleParty+" to select "+ResponsibleParty+"from Responsible Party dropdown");

   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AddFile, 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AddFile, "AddFile button");
   Thread.sleep(3000);

   TestBase.waitForElement(SBV_Connect_PageObjects.SBV_FileUpload1, 50);
   TestBase.clickonElement(SBV_Connect_PageObjects.SBV_FileUpload1, "upload button");
   Thread.sleep(3000);

   Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\TestData\\AutoIT\\fileupload.exe");

   Thread.sleep(5000);
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Add_Notes, 50);
   TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_Add_Notes, "Testing", "Enter Notes");
   
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Update, 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Update, "Update button");  
    
}
	@Given("Internal User Verifies the InProgress is displayed in status Dropdown")
	public void internal_User_Verifies_the_InProgress_is_displayed_in_status_Dropdown() throws Exception {
		String expectedassigstatus="In Progress";
		TestBase.waitForElement(SBV_Connect_CommonPageObject.InProgressStatus, 50);
		if(TestBase.isElementVisible(SBV_Connect_CommonPageObject.InProgressStatus, "InProgressStatus")) {
			actualassignstatus=TestBase.getElementText(SBV_Connect_CommonPageObject.InProgressStatus, "InProgressStatus");
			
		}
	}

	@Given("Internal User Navigates to TaskList,Search with New Case Id and Update the Status as {string}")
	public void internal_User_Navigates_to_TaskList_Search_with_New_Case_Id_and_Update_the_Status_as(String resolutionValue,String status,String BuisnessWorkflow,String ResponsibleParty) throws Exception {
		Thread.sleep(5000);
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_view_task_list, 50);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_view_task_list, "View task list");
		TestBase.driver.navigate().refresh();
		
		Thread.sleep(5000);
		TestBase.driver.switchTo().frame("myFrame");
		TestBase.driver.switchTo().frame("bonitaframe");
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, 50);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, "new case button");
		Thread.sleep(4000);
		System.out.println(NewCase);
		TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_SearchByinput, NewCase, "Enter");

      for(int i=0;i<13;i++) {

    	  TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.LEFT));
          }

      TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.BACK_SPACE));

      TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_CIT_Number, 50);
      if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_CIT_Number, "CIT Number"))) {

    	  ExceptionHandling.HandleAssertion("CIT_Number is not diaplayed");

      }
      
      TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Region, 50);
      if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Region,  "Region"))) {

    	  ExceptionHandling.HandleAssertion("Region is not diaplayed");

      }
      
      TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Cash_Center, 50);
       if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Cash_Center,   "Cash_Center"))) {

        	  ExceptionHandling.HandleAssertion("Cash_Center is not diaplayed");

          }
       TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Resolution_Dropdown, 50);
       TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Resolution_Dropdown, "ResolutionDropdown");
	   TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(resolutionValue), 50);
	   TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(resolutionValue), resolutionValue+" to select "+resolutionValue+"from Resolution dropdown");
       TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Status, 50);
       TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Status, "Status");
	   TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(status), 50);
	   TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(status), status+" to select "+status+"from Status dropdown");
	  
	   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Business_workflow_Dropdown, 50);
       TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Business_workflow_Dropdown, "Buisness Work flow");
	   TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(BuisnessWorkflow), 50);
	   TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(BuisnessWorkflow), BuisnessWorkflow+" to select "+BuisnessWorkflow+"from Buisness Work flow dropdown");

	   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Responsible_party_Dropdown, 50);
       TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Responsible_party_Dropdown, "Resonsible Party dropdown");
	   TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(ResponsibleParty), 50);
	   TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(ResponsibleParty), ResponsibleParty+" to select "+ResponsibleParty+"from Responsible Party dropdown");

       TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AddFile, 50);
       TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AddFile, "AddFile button");
       Thread.sleep(3000);

       TestBase.waitForElement(SBV_Connect_PageObjects.SBV_FileUpload1, 50);
       TestBase.clickonElement(SBV_Connect_PageObjects.SBV_FileUpload1, "upload button");
       Thread.sleep(3000);

       Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\TestData\\AutoIT\\fileupload.exe");
   
	   Thread.sleep(5000);
	   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Add_Notes, 50);
	   TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_Add_Notes, "Testing", "Enter Notes");
	   
	   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Update, 50);
	   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Update, "Update button");      
      
		
	}

	@Given("Internal User Verifies the AwaitingFeedback is displayed in status Dropdown")
	public void internal_User_Verifies_the_AwaitingFeedback_is_displayed_in_status_Dropdown() throws Exception {
		String expectedassigstatus="Awaiting Feedback";
		TestBase.waitForElement(SBV_Connect_CommonPageObject.AwaitingFeedbackStatus, 50);
		if(TestBase.isElementVisible(SBV_Connect_CommonPageObject.AwaitingFeedbackStatus, "Awaiting Feedback")) {
			actualassignstatus=TestBase.getElementText(SBV_Connect_CommonPageObject.AwaitingFeedbackStatus, "Awaiting Feedback");
			
		}
	}
	
	@Given("Internal User Navigates to TaskList,Search with New Case Id,click on Feed back Required and Update the Case")
	public void internal_User_Navigates_to_TaskList_Search_with_New_Case_Id_click_on_Feed_back_Required_and_Update_the_Case() throws Exception {
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_view_task_list, 50);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_view_task_list, "View task list");
		TestBase.driver.navigate().refresh();
		
		Thread.sleep(5000);
		TestBase.driver.switchTo().frame("myFrame");
		TestBase.driver.switchTo().frame("bonitaframe");
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, 50);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, "new case button");
		Thread.sleep(4000);
		System.out.println(NewCase);
		TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_SearchByinput, NewCase, "Enter");

      for(int i=0;i<13;i++) {

    	  TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.LEFT));
          }

      TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.BACK_SPACE));
      
      Thread.sleep(5000);
      TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_FeedbackRequired, 50);
      TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_FeedbackRequired, "update case");

	   Thread.sleep(5000);
	   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Add_Notes, 50);
	   TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_Add_Notes, "Testing", "Enter Notes");
	   
	   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Update, 50);
	   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Update, "Update button"); 
		
	}

	@Given("External User Navigates to TaskList,Search with Latest Case id,Click on Review Completion and Accept Resolution")
	public void external_User_Navigates_to_TaskList_Search_with_Latest_Case_id_Click_on_Review_Completion_and_Accept_Resolution() throws Exception {
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_view_task_list, 50);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_view_task_list, "View task list");
		TestBase.driver.navigate().refresh();
		
		Thread.sleep(5000);
		TestBase.driver.switchTo().frame("myFrame");
		TestBase.driver.switchTo().frame("bonitaframe");
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, 50);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, "new case button");
		Thread.sleep(4000);
		System.out.println(NewCase);
		TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_SearchByinput, NewCase, "Enter");

      for(int i=0;i<13;i++) {

    	  TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.LEFT));
          }

      TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.BACK_SPACE));
      
      Thread.sleep(5000);
      TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_ReviewCompletion, 50);
      TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_ReviewCompletion, "update case");

      Thread.sleep(5000);
      TestBase.waitForElement(SBV_Connect_PageObjects.SBV_AcceptResolution, 50);
      TestBase.clickonElement(SBV_Connect_PageObjects.SBV_AcceptResolution, "new case button");
  
	   Thread.sleep(5000);
	   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Add_Notes, 50);
	   TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_Add_Notes, "The  Case resolution is accept by External User", "Enter Notes");
	   
	   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Update, 50);
	   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Update, "Update button"); 
	}

	@Given("External User Navigates to TaskList,Search with Latest Case id,Click on Complete Survey and Submit it by selecting the {string},{string},{string} Values")
	public void external_User_Navigates_to_TaskList_Search_with_Latest_Case_id_Click_on_Complete_Survey_and_Submit_it_by_selecting_the_Values(String Questionone, String QuestionTwo, String QuestionThree) throws Exception {
		Thread.sleep(5000);
		TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Complete_Survey, 50);
		TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Complete_Survey, "new case button");
		TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Questionone, 50);
	      TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Questionone, "Allowed_Time dropdown");
		   TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(Questionone), 50);
		   TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(Questionone), Questionone+" to select "+Questionone+"from Responsible Party dropdown");
	      Thread.sleep(5000);
	      TestBase.waitForElement(SBV_Connect_PageObjects.SBV_QuestionTwo, 50);
	      TestBase.clickonElement(SBV_Connect_PageObjects.SBV_QuestionTwo, "Allowed_Time dropdown");
		   TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(QuestionTwo), 50);
		   TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(QuestionTwo), QuestionTwo+" to select "+QuestionTwo+"from Responsible Party dropdown");
	      Thread.sleep(5000);
	      TestBase.waitForElement(SBV_Connect_PageObjects.SBV_QuestionThree, 50);
	      TestBase.clickonElement(SBV_Connect_PageObjects.SBV_QuestionThree, "Allowed_Time dropdown");
		   TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(QuestionThree), 50);
		   TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(QuestionThree), QuestionThree+" to select "+QuestionThree+"from Responsible Party dropdown");
	      Thread.sleep(5000);
	      Thread.sleep(5000);
	      TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Submit, 50);
	      TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Submit, "new case button");
	}

	@Then("Reginal User Navigates to Tasklist,Search with Latest Case Id ,Click On Pause Apporval and Update the Case with {string}")
	public void reginal_User_Navigates_to_Tasklist_Search_with_Latest_Case_Id_Click_On_Pause_Apporval_and_Update_the_Case_with(String Allowed_Time) throws Exception {
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_view_task_list, 50);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_view_task_list, "View task list");
		TestBase.driver.navigate().refresh();
		
		Thread.sleep(5000);
		TestBase.driver.switchTo().frame("myFrame");
		TestBase.driver.switchTo().frame("bonitaframe");
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, 50);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, "new case button");
		Thread.sleep(4000);
		System.out.println(NewCase);
		TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_SearchByinput, NewCase, "Enter");

      for(int i=0;i<13;i++) {

    	  TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.LEFT));
          }

      TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.BACK_SPACE));
      
      Thread.sleep(5000);
      TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_PauseApporval, 50);
      TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_PauseApporval, "update case");
      Thread.sleep(5000);
      TestBase.waitForElement(SBV_Connect_PageObjects.SBV_YesButton, 50);
      TestBase.clickonElement(SBV_Connect_PageObjects.SBV_YesButton, "yes button");
      
	   TestBase.waitForElement(SBV_Connect_PageObjects.SBV_24, 50);
      TestBase.clickonElement(SBV_Connect_PageObjects.SBV_24, "Allowed_Time dropdown");
	   TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(Allowed_Time), 50);
	   TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(Allowed_Time), Allowed_Time+" to select "+Allowed_Time+"from Responsible Party dropdown");

	   Thread.sleep(5000);
	   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Add_Notes, 50);
	   TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_Add_Notes, "Testing", "Enter Notes");
	   
	   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Update, 50);
	   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Update, "Update button"); 
		
	}

	@Given("External User Navigates to TaskList,Search with Latest Case id,Click on Review Completion and Reject Resolution")
	public void external_User_Navigates_to_TaskList_Search_with_Latest_Case_id_Click_on_Review_Completion_and_Reject_Resolution() throws Exception {
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_view_task_list, 50);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_view_task_list, "View task list");
		TestBase.driver.navigate().refresh();
		
		Thread.sleep(15000);
		TestBase.driver.switchTo().frame("myFrame");
		TestBase.driver.switchTo().frame("bonitaframe");
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, 50);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, "new case button");
		Thread.sleep(4000);
		System.out.println("NewCase"+NewCase);
		TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_SearchByinput, NewCase, "Enter");

      for(int i=0;i<13;i++) {

    	  TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.LEFT));
          }

      TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.BACK_SPACE));
      
      Thread.sleep(5000);
      TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_ReviewCompletion, 50);
      TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_ReviewCompletion, "update case");

      Thread.sleep(5000);
      TestBase.waitForElement(SBV_Connect_PageObjects.SBV_RejectResolution, 50);
      TestBase.clickonElement(SBV_Connect_PageObjects.SBV_RejectResolution, "new case button");
  
	   Thread.sleep(5000);
	   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Add_Notes, 50);
	   TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_Add_Notes, "Testing", "Enter Notes");
	   
	   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Update, 50);
	   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Update, "Update button"); 
	}

	@Given("Reginal User Navigates to TaskList,Search with Latest Case id,Click on RTL Intervention and Update the Case")
	public void reginal_User_Navigates_to_TaskList_Search_with_Latest_Case_id_Click_on_RTL_Intervention_and_Update_the_Case() throws Exception {
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_view_task_list, 50);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_view_task_list, "View task list");
		TestBase.driver.navigate().refresh();
		
		Thread.sleep(5000);
		TestBase.driver.switchTo().frame("myFrame");
		TestBase.driver.switchTo().frame("bonitaframe");
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, 50);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, "new case button");
		Thread.sleep(4000);
		System.out.println(NewCase);
		TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_SearchByinput, NewCase, "Enter");

      for(int i=0;i<13;i++) {

    	  TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.LEFT));
          }

      TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.BACK_SPACE));
      
      Thread.sleep(5000);
      TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_RTLIntervention, 50);
      TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_RTLIntervention, "update case");

	   Thread.sleep(5000);
	   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Add_Notes, 50);
	   TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_Add_Notes, "Testing", "Enter Notes");
	   
	   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Update, 50);
	   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Update, "Update button"); 
	}

	@Given("Internal User Navigates to TaskList,Search with New Case Id and Update the Status as Resolved")
    public void internal_User_Navigates_to_TaskList_Search_with_New_Case_Id_and_Update_the_Status_as() throws Exception {
        Thread.sleep(5000);
        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_view_task_list, 50);
        TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_view_task_list, "View task list");
        TestBase.driver.navigate().refresh();

        Thread.sleep(5000);
        TestBase.driver.switchTo().frame("myFrame");
        TestBase.driver.switchTo().frame("bonitaframe");
        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, 50);
        TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, "new case button");
        Thread.sleep(4000);
        System.out.println(NewCase);
        TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_SearchByinput, NewCase, "Enter");
      for(int i=0;i<13;i++) {
          TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.LEFT));
          }
      TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.BACK_SPACE));
      Thread.sleep(3000);
      TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_UpdateCase, 50);
      TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_UpdateCase, "update Case link");

      TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_CIT_Number, 50);
      if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_CIT_Number, "CIT Number"))) {
          ExceptionHandling.HandleAssertion("CIT_Number is not diaplayed");
      }

      TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Region, 50);
      if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Region,  "Region"))) {

          ExceptionHandling.HandleAssertion("Region is not diaplayed");

      }

      TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Cash_Center, 50);
       if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Cash_Center,   "Cash_Center"))) {

              ExceptionHandling.HandleAssertion("Cash_Center is not diaplayed");
          }
       Excel_Utility.setExcelFile(filepath, sheetName);
       String statusResolved = Excel_Utility.getCellData(1, 38);
       System.out.println(statusResolved);

       TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Status, 50);
       TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Status, "Status");
       Thread.sleep(5000);
       TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Status, 50);
       TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Status, "Status");
       TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(statusResolved), 40);
       TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(statusResolved), statusResolved+" to select "+statusResolved+"from Status dropdown");

       Thread.sleep(5000);
       TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Add_Notes, 50);
       TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_Add_Notes, "Case is Resolved", "Enter Notes");

       Thread.sleep(5000);
       TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Update, 50);
       TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Update, "Update button");      

    }


	@Given("National User Navigates to TaskList,Search with Latest Case id,Click on NCS Intervention and Update the Case")
	public void national_User_Navigates_to_TaskList_Search_with_Latest_Case_id_Click_on_NCS_Intervention_and_Update_the_Case() throws Exception {
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_view_task_list, 50);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_view_task_list, "View task list");
		TestBase.driver.navigate().refresh();
		
		Thread.sleep(5000);
		TestBase.driver.switchTo().frame("myFrame");
		TestBase.driver.switchTo().frame("bonitaframe");
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, 50);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, "new case button");
		Thread.sleep(4000);
		System.out.println(NewCase);
		TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_SearchByinput, NewCase, "Enter");

      for(int i=0;i<13;i++) {

    	  TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.LEFT));
          }

      TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.BACK_SPACE));
      
      Thread.sleep(5000);
      TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_NCSIntervention, 50);
      TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_NCSIntervention, "update case");

	   Thread.sleep(5000);
	   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Add_Notes, 50);
	   TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_Add_Notes, "Testing", "Enter Notes");
	   
	   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Update, 50);
	   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Update, "Update button"); 
	}


@Given("Reginal User Navigates to Caselist,Search with Latest Case id and Assign to Laureen User by selecting the {string},{string} Values")
public void reginal_User_Navigates_to_Caselist_Search_with_Latest_Case_id_and_Assign_to_Laureen_User_by_selecting_the_Values(String User_level_Lauren, String CLO_Lauren) throws Throwable {

				TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_see_case_list, 50);
				TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_see_case_list, "case list");

				Thread.sleep(25000);
				TestBase.driver.switchTo().frame("myFrame");
				TestBase.driver.switchTo().frame("bonitaframe");
				
				TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, 50);
				TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, "SearchByfield");
				TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_SearchByinput, NewCase, "Enter");
		        Thread.sleep(5000);
		        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_LatestCaseNumber, 50);
		        TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_LatestCaseNumber, "Latestcase Number");

		        Thread.sleep(5000);
		        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AuditTrail, 50);
		        TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AuditTrail, "new case button");
		        TestBase.ScrollDownBottom();
		        
		        Thread.sleep(5000);
		        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Admin, 50);
		        TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Admin, "new case button");
		        
		        Thread.sleep(5000);

				TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_UserLevel, 50);
				TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_UserLevel, "new case button");
				TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(User_level_Lauren), 50);
				TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(User_level_Lauren), User_level_Lauren+" to select "+User_level_Lauren+"from User level dropdown");
				
				TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Lauren_Lau, 50);
				TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Lauren_Lau, "new case button");
				TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(CLO_Lauren), 50);
				TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(CLO_Lauren), CLO_Lauren+" to select "+CLO_Lauren+"from CLO dropdown");		
				
				Thread.sleep(5000);
				TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Assign, 50);
				TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Assign, "new case button");

				String expectedassigstatus="Case successfully reassigned";
				TestBase.waitForElement(SBV_Connect_CommonPageObject.userassignstatus, 50);
				if(TestBase.isElementVisible(SBV_Connect_CommonPageObject.userassignstatus, "olgaassignstatus")) {
					actualassignstatus=TestBase.getElementText(SBV_Connect_CommonPageObject.userassignstatus, "olgastatus");
					
				}
				Assert.assertEquals(expectedassigstatus, actualassignstatus);
	}
		

@Given("Internal User Navigates to TaskList,Search with New Case Id and Update the Status as Pause Timer by using Excelsheetdata {string} and row number \"{int}\"")
public void internal_User_Navigates_to_TaskList_Search_with_New_Case_Id_and_Update_the_Status_as_Pause_Timer_by_using_Excelsheetdata_and_row_number(String sheetName, Integer int1) throws Exception {
   Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_view_task_list, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_view_task_list, "View task list");
	Thread.sleep(5000);
	TestBase.RefreshPage();
	Thread.sleep(15000);
	TestBase.driver.switchTo().frame("myFrame");
	TestBase.driver.switchTo().frame("bonitaframe");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, "new case button");
	Thread.sleep(4000);
	System.out.println(NewCase);
	TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_SearchByinput, NewCase, "Enter");

  for(int i=0;i<13;i++) {

	  TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.LEFT));
      }

  TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.BACK_SPACE));

  Thread.sleep(5000);
  TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_UpdateCase, 50);
  TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_UpdateCase, "update case");
  Thread.sleep(5000);
  TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_CIT_Number, 50);
  if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_CIT_Number, "CIT Number"))) {

	  ExceptionHandling.HandleAssertion("CIT_Number is not diaplayed");

  }
  
  TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Region, 50);
  if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Region,  "Region"))) {

	  ExceptionHandling.HandleAssertion("Region is not diaplayed");

  }
  
  TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Cash_Center, 50);
   if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Cash_Center,   "Cash_Center"))) {

    	  ExceptionHandling.HandleAssertion("Cash_Center is not diaplayed");

      }

Excel_Utility.setExcelFile(filepath, sheetName);
String resolutionValue = Excel_Utility.getCellData(int1, 37);
String BuisnessWorkflow= Excel_Utility.getCellData(int1, 12);
String ResponsibleParty = Excel_Utility.getCellData(int1, 13);
String Status_PauseTimer=Excel_Utility.getCellData(int1,16);
System.out.println(Status_PauseTimer);

Thread.sleep(4000);
TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Status, 50);
TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Status, "Status");
TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(Status_PauseTimer), 50);
TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(Status_PauseTimer), Status_PauseTimer+" to select "+Status_PauseTimer+"from Status dropdown");
  
TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Resolution_Dropdown, 50);
TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Resolution_Dropdown, "ResolutionDropdown");
TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(resolutionValue), 50);
TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(resolutionValue), resolutionValue+" to select "+resolutionValue+"from Resolution dropdown");

TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Business_workflow_Dropdown, 50);
TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Business_workflow_Dropdown, "Buisness Work flow");
TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(BuisnessWorkflow), 50);
TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(BuisnessWorkflow), BuisnessWorkflow+" to select "+BuisnessWorkflow+"from Buisness Work flow dropdown");

TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Responsible_party_Dropdown, 50);
TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Responsible_party_Dropdown, "Resonsible Party dropdown");
TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(ResponsibleParty), 50);
TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(ResponsibleParty), ResponsibleParty+" to select "+ResponsibleParty+"from Responsible Party dropdown");

Thread.sleep(5000);
TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Add_Notes, 50);
TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_Add_Notes, "Testing", "Enter Notes");
TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Update, 150);
TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Update, "Update button");

}

@Then("External User Navigates to Caselist and Verify the Logged Case")
public void external_User_Navigates_to_Caselist_and_Verify_the_Logged_Case() throws Exception {
    
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_see_case_list, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_see_case_list, "case list");
	Thread.sleep(5000);
	TestBase.RefreshPage();
	Thread.sleep(30000);
	TestBase.driver.switchTo().frame("myFrame");
	TestBase.driver.switchTo().frame("bonitaframe");
	 Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_LatestCaseNumber, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_LatestCaseNumber, "Latestcase Number");

    Thread.sleep(5000);
    if(!(TestBase.waitForElementToBevisible(SBV_Connect_CommonPageObject.SBV_GetCaseid,500))) {
    	TestBase.driver.navigate().refresh();
        NewCase = TestBase.getElementText(SBV_Connect_CommonPageObject.SBV_GetCaseid," Firstrow");

      }
    else if(TestBase.waitForElementToBevisible(SBV_Connect_CommonPageObject.SBV_GetCaseid,500) ){
          
          Thread.sleep(5000);
          NewCase = TestBase.getElementText(SBV_Connect_CommonPageObject.SBV_GetCaseid," Firstrow");    

      }else {

    	  ExceptionHandling.HandleAssertion("unable to copy Firstrow");
      }

    System.out.println(NewCase);

  }

@Then("External User Navigates to Caselist and Verify the Reporting Logged Case")
public void external_User_Navigates_to_Caselist_and_Verify_the_Reporting_Logged_Case() throws Exception {
	
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_see_case_list, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_see_case_list, "case list");
	Thread.sleep(5000);
	TestBase.RefreshPage();
	Thread.sleep(15000);
	TestBase.driver.switchTo().frame("myFrame");
	TestBase.driver.switchTo().frame("bonitaframe");
  
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_LatestCaseNumber_Reporting, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_LatestCaseNumber_Reporting, "Latestcase Number");

    Thread.sleep(5000);
    if(!(TestBase.waitForElementToBevisible(SBV_Connect_CommonPageObject.SBV_GetCaseid,500))) {

    	TestBase.driver.navigate().refresh();
        NewCase = TestBase.getElementText(SBV_Connect_CommonPageObject.SBV_GetCaseid," Firstrow");

      }
    else if(TestBase.waitForElementToBevisible(SBV_Connect_CommonPageObject.SBV_GetCaseid,500) ){
          
          Thread.sleep(5000);
          NewCase = TestBase.getElementText(SBV_Connect_CommonPageObject.SBV_GetCaseid," Firstrow");    

      }else {

    	  ExceptionHandling.HandleAssertion("unable to copy Firstrow");
      }

    System.out.println(NewCase);

}
@Given("Internal User Navigates to TaskList,Search with New Case Id and Update the Case by using Excelsheetdata {string} and row number \"{int}\" Logged by External User")
public void internal_User_Navigates_to_TaskList_Search_with_New_Case_Id_and_Update_the_Case_by_using_Excelsheetdata_and_row_number_Logged_by_External_User(String sheetName, Integer int1) throws Exception {
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_view_task_list, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_view_task_list, "View task list");
	TestBase.driver.navigate().refresh();
	
	Thread.sleep(25000);
	TestBase.driver.switchTo().frame("myFrame");
	TestBase.driver.switchTo().frame("bonitaframe");

	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, "new case button");
	Thread.sleep(5000);
	System.out.println("letestcaseno"+ NewCase);
	TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_SearchByinput, NewCase, "Enter");

  for(int i=0;i<13;i++) {

	  TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.LEFT));
      }

  TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.BACK_SPACE));
  
  Thread.sleep(5000);
  TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_New_Case, 50);
  TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_New_Case, "new case button");
  
  TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_CIT_Number, 50);
  if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_CIT_Number, "CIT Number"))) {

	  ExceptionHandling.HandleAssertion("CIT_Number is not diaplayed");

  }
  
  TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Region, 50);
  if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Region,  "Region"))) {

	  ExceptionHandling.HandleAssertion("Region is not diaplayed");

  }
  
  TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Cash_Center, 50);
   if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Cash_Center,   "Cash_Center"))) {

    	  ExceptionHandling.HandleAssertion("Cash_Center is not diaplayed");
      }

   Excel_Utility.setExcelFile(filepath, sheetName);
   String resolutionValue = Excel_Utility.getCellData(int1, 11);
   String BuisnessWorkflow= Excel_Utility.getCellData(int1, 12);
   String ResponsibleParty = Excel_Utility.getCellData(int1, 13);
   
   Thread.sleep(3000);
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Resolution_Dropdown, 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Resolution_Dropdown, "ResolutionDropdown");
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(resolutionValue), 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(resolutionValue), resolutionValue+" to select "+resolutionValue+"from Resolution dropdown");
  
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Business_workflow_Dropdown, 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Business_workflow_Dropdown, "Buisness Work flow");
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(BuisnessWorkflow), 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(BuisnessWorkflow), BuisnessWorkflow+" to select "+BuisnessWorkflow+"from Buisness Work flow dropdown");

   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Responsible_party_Dropdown, 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Responsible_party_Dropdown, "Resonsible Party dropdown");
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(ResponsibleParty), 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(ResponsibleParty), ResponsibleParty+" to select "+ResponsibleParty+"from Responsible Party dropdown");

   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AddFile, 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AddFile, "AddFile button");
   Thread.sleep(3000);

   String PdfFile = "TestData/UploadFiles/dummy.pdf";
   TestBase.FileUpload(SBV_Connect_CommonPageObject.SBV_Uploadfile1, PdfFile);

   Thread.sleep(5000);
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Add_Notes, 50);
   TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_Add_Notes, "Internal user updated the Case", "Enter Notes");
   
   Thread.sleep(8000);
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Update, 500);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Update, "Update button"); 


}
@Given("User Navigates to TaskList,Search with New Case Id and Update the Case by using Excelsheetdata {string} and row number \"{int}\" Logged by External User")
public void User_Navigates_to_TaskList_Search_with_New_Case_Id_and_Update_the_Case_by_using_Excelsheetdata_and_row_number_Logged_by_External_User(String sheetName, Integer int1) throws Exception {
	
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_view_task_list, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_view_task_list, "View task list");
	TestBase.driver.navigate().refresh();
	
	Thread.sleep(25000);
	TestBase.driver.switchTo().frame("myFrame");
	TestBase.driver.switchTo().frame("bonitaframe");

	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, "new case button");
	Thread.sleep(5000);
	System.out.println("letestcaseno"+ NewCase);
	TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_SearchByinput, NewCase, "Enter");

  for(int i=0;i<13;i++) {

	  TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.LEFT));
      }

  TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.BACK_SPACE));
  
  Thread.sleep(5000);
  TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_UpdateCase, 50);
  TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_UpdateCase, "new case button");
  
  TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_CIT_Number, 50);
  if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_CIT_Number, "CIT Number"))) {

	  ExceptionHandling.HandleAssertion("CIT_Number is not diaplayed");

  }
  
  TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Region, 50);
  if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Region,  "Region"))) {

	  ExceptionHandling.HandleAssertion("Region is not diaplayed");

  }
  
  TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Cash_Center, 50);
   if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Cash_Center,   "Cash_Center"))) {

    	  ExceptionHandling.HandleAssertion("Cash_Center is not diaplayed");

      }

   Excel_Utility.setExcelFile(filepath, sheetName);
   String resolutionValue = Excel_Utility.getCellData(int1, 11);
   String BuisnessWorkflow= Excel_Utility.getCellData(int1, 12);
   String ResponsibleParty = Excel_Utility.getCellData(int1, 13);
   
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Resolution_Dropdown, 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Resolution_Dropdown, "ResolutionDropdown");
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(resolutionValue), 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(resolutionValue), resolutionValue+" to select "+resolutionValue+"from Resolution dropdown");
  
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Business_workflow_Dropdown, 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Business_workflow_Dropdown, "Buisness Work flow");
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(BuisnessWorkflow), 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(BuisnessWorkflow), BuisnessWorkflow+" to select "+BuisnessWorkflow+"from Buisness Work flow dropdown");

   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Responsible_party_Dropdown, 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Responsible_party_Dropdown, "Resonsible Party dropdown");
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(ResponsibleParty), 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(ResponsibleParty), ResponsibleParty+" to select "+ResponsibleParty+"from Responsible Party dropdown");

   Thread.sleep(5000);
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Add_Notes, 50);
   TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_Add_Notes, "Testing", "Enter Notes");
   
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Update, 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Update, "Update button"); 

}

@Given("Internal User Navigates to TaskList,Search with New Case Id and Update the Case by using Excelsheetdata {string} and row number \"{int}\" Logged by Internal User")
public void internal_User_Navigates_to_TaskList_Search_with_New_Case_Id_and_Update_the_Case_by_using_Excelsheetdata_and_row_number_Logged_by_Internal_User(String sheetName, Integer int1) throws Exception {
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, "new case button");
	Thread.sleep(5000);
	System.out.println("letestcaseno"+ NewCase);
	TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_SearchByinput, NewCase, "Enter");

  for(int i=0;i<13;i++) {

	  TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.LEFT));
      }

  TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.BACK_SPACE));
  
  Thread.sleep(5000);
  TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_New_Case, 50);
  TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_New_Case, "new case button");
  
  TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_CIT_Number, 50);
  if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_CIT_Number, "CIT Number"))) {

	  ExceptionHandling.HandleAssertion("CIT_Number is not diaplayed");

  }
  
  TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Region, 50);
  if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Region,  "Region"))) {

	  ExceptionHandling.HandleAssertion("Region is not diaplayed");

  }
  
  TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Cash_Center, 50);
   if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Cash_Center,   "Cash_Center"))) {

    	  ExceptionHandling.HandleAssertion("Cash_Center is not diaplayed");

      }

   Excel_Utility.setExcelFile(filepath, sheetName);
   String resolutionValue = Excel_Utility.getCellData(int1, 11);
   String BuisnessWorkflow= Excel_Utility.getCellData(int1, 12);
   String ResponsibleParty = Excel_Utility.getCellData(int1, 13);
   
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Resolution_Dropdown, 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Resolution_Dropdown, "ResolutionDropdown");
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(resolutionValue), 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(resolutionValue), resolutionValue+" to select "+resolutionValue+"from Resolution dropdown");
  
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Business_workflow_Dropdown, 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Business_workflow_Dropdown, "Buisness Work flow");
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(BuisnessWorkflow), 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(BuisnessWorkflow), BuisnessWorkflow+" to select "+BuisnessWorkflow+"from Buisness Work flow dropdown");

   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Responsible_party_Dropdown, 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Responsible_party_Dropdown, "Resonsible Party dropdown");
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(ResponsibleParty), 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(ResponsibleParty), ResponsibleParty+" to select "+ResponsibleParty+"from Responsible Party dropdown");

   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AddFile, 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AddFile, "AddFile button");
   Thread.sleep(3000);
   TestBase.waitForElement(SBV_Connect_PageObjects.SBV_FileUpload1, 50);
   TestBase.clickonElement(SBV_Connect_PageObjects.SBV_FileUpload1, "upload button");
   Thread.sleep(3000);

   Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\TestData\\AutoIT\\fileupload.exe");

   Thread.sleep(5000);
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Add_Notes, 50);
   TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_Add_Notes, "Testing", "Enter Notes");
   
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Update, 500);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Update, "Update button"); 

}

@Then("User Log a New Case in CLOFlow By using SheetName {string} and row number \"{int}\"in External Connect System")
public void user_Log_a_New_Case_in_CLOFlow_By_using_SheetName_and_row_number_in_External_Connect_System(String string, Integer int1) throws Throwable {

Thread.sleep(5000);
TestBase.driver.switchTo().defaultContent();
TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Log_New_Case_Button,30);
TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Log_New_Case_Button, "Log new case button");

Thread.sleep(5000);
TestBase.RefreshPage();
Thread.sleep(15000);
TestBase.driver.switchTo().frame("myFrame");
TestBase.driver.switchTo().frame("bonitaframe");
TestBase.driver.switchTo().frame(TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_inner_frame));

TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_query_menu, 50);
TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_query_menu, "CaseTypedropdown");

Excel_Utility.setExcelFile(filepath, sheetName);
String town = Excel_Utility.getCellData(int1, 8);
String Case_type= Excel_Utility.getCellData(int1, 35);
String CaseSubType = Excel_Utility.getCellData(int1, 36);

TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(Case_type), 50);
TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(Case_type), Case_type+" to select "+Case_type+"from case type dropdown");

TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_query_sub_menu, 50);
TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_query_sub_menu, "CaseSubTypedropdown");

TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(CaseSubType), 50);
TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(CaseSubType), CaseSubType+" to select "+CaseSubType+"from case Sub type dropdown");

TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_click_next_button, 50);
TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_next_button, "Next button");

TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_type_search_key, 50);
TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_type_search_key, town, "enter data");
TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_search_button, "search button");

TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_type_search_key, 50);
TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Select_Cash_Center, 50);
TestBase.getElements(SBV_Connect_CommonPageObject.SBV_Select_Cash_Center);
TestBase.ClickViaMouse(SBV_Connect_CommonPageObject.SBV_Select_Cash_Center, "cash canter");

TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_CIT_Number, 50);
if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_CIT_Number, "CIT Number"))) {

ExceptionHandling.HandleAssertion("CIT_Number is not diaplayed");
}

TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Region, 50);
if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Region, "Region"))) {

ExceptionHandling.HandleAssertion("Region is not diaplayed");
}
TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Cash_Center, 50);

if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Cash_Center,  "Cash_Center"))) {

ExceptionHandling.HandleAssertion("Cash_Center is not diaplayed");
}

TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_click_next_button, 50);
TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_next_button, "Next button");
TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Select_Date, 50);
TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Select_Date, "Select Date");


}
@Then("User Log a New Case By using SheetName {string} and row number \"{int}\"in External Connect System")
public void user_Log_a_New_Case_By_using_SheetName_and_row_number_in_External_Connect_System(String sheetName, Integer int1) throws Throwable {

Thread.sleep(5000);
TestBase.driver.switchTo().defaultContent();
TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Log_New_Case_Button,30);
TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Log_New_Case_Button, "Log new case button");

Thread.sleep(4000);
TestBase.RefreshPage();
Thread.sleep(25000);
TestBase.driver.switchTo().frame("myFrame");
TestBase.driver.switchTo().frame("bonitaframe");
TestBase.driver.switchTo().frame(TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_inner_frame));

TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_query_menu, 50);
TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_query_menu, "CaseTypedropdown");

Excel_Utility.setExcelFile(filepath, sheetName);
String town = Excel_Utility.getCellData(int1, 8);
String Case_type= Excel_Utility.getCellData(int1, 9);
String CaseSubType = Excel_Utility.getCellData(int1, 50);

TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(Case_type), 50);
TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(Case_type), Case_type+" to select "+Case_type+"from case type dropdown");

TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_query_sub_menu, 50);
TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_query_sub_menu, "CaseSubTypedropdown");

TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(CaseSubType), 50);
TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(CaseSubType), CaseSubType+" to select "+CaseSubType+"from case Sub type dropdown");

TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_click_next_button, 50);
TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_next_button, "Next button");

TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_type_search_key, 50);
TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_type_search_key, town, "enter data");
TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_search_button, "search button");

TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_type_search_key, 50);
TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Select_Cash_Center, 50);
TestBase.getElements(SBV_Connect_CommonPageObject.SBV_Select_Cash_Center);
TestBase.ClickViaMouse(SBV_Connect_CommonPageObject.SBV_Select_Cash_Center, "cash canter");

TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_CIT_Number, 50);
if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_CIT_Number, "CIT Number"))) {

ExceptionHandling.HandleAssertion("CIT_Number is not diaplayed");
}

TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Region, 30);
if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Region, "Region"))) {

ExceptionHandling.HandleAssertion("Region is not diaplayed");
}
TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Cash_Center, 30);

if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Cash_Center,  "Cash_Center"))) {

ExceptionHandling.HandleAssertion("Cash_Center is not diaplayed");
}

TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_click_next_button, 30);
TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_next_button, "Next button");
TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Select_Date, 30);
TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Select_Date, "Select Date");

Thread.sleep(5000);

TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_click_next_button, 30);
TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_next_button, "Next button");

TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AddFile, 50);
TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AddFile, "AddFile button");
Thread.sleep(3000);

TestBase.waitForElement(SBV_Connect_PageObjects.SBV_FileUpload1, 50);
TestBase.clickonElement(SBV_Connect_PageObjects.SBV_FileUpload1, "upload button");
Thread.sleep(3000);

Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\TestData\\AutoIT\\fileupload.exe");

Thread.sleep(5000);
TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Add_Notes, 50);
TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_Add_Notes, "Testing", "Enter Notes");

TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Submit_Button, 500);
TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Submit_Button, "Submit button");

TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Logcase_Successful_Message, 30);
if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Logcase_Successful_Message, "Succussufuly Log"))) {

ExceptionHandling.HandleAssertion("Succesful Message is not diaplayed");
}}


@Then("External User Navigates to Dashboard and click on Log a New case by using town,Case_type,Case_Subtype By using SheetName {string} and row number \"{int}\" in External Connect System")
public void external_User_Navigates_to_Dashboard_and_click_on_Log_a_New_case_by_using_town_Case_type_Case_Subtype_By_using_SheetName_and_row_number_in_External_Connect_System(String SheetName, Integer int1) throws Throwable {
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Dashboard, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Dashboard, "dashbord");
	TestBase.RefreshPage();
	Thread.sleep(25000);
	TestBase.driver.switchTo().frame("myFrame");
	TestBase.driver.switchTo().frame("bonitaframe");
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Log_New_Case,50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Log_New_Case, "Log new case button");

	TestBase.RefreshPage();
	Thread.sleep(25000);
	TestBase.driver.switchTo().frame("myFrame");
	TestBase.driver.switchTo().frame("bonitaframe");
	TestBase.driver.switchTo().frame(TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_inner_frame));

    Excel_Utility.setExcelFile(filepath, sheetName);
    String town = Excel_Utility.getCellData(int1, 8);
    String Case_type= Excel_Utility.getCellData(int1, 9);
    String CaseSubType = Excel_Utility.getCellData(int1, 50);
	
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_query_menu, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_query_menu, "CaseTypedropdown");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(Case_type), 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(Case_type), Case_type+" to select "+Case_type+"from case type dropdown");
	
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_query_menu, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_query_menu, "CaseSubTypedropdown");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(CaseSubType), 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(CaseSubType), CaseSubType+" to select "+CaseSubType+"from case Sub type dropdown");
	
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_click_next_button, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_next_button, "Next button");

    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_type_search_key, 50);
    TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_type_search_key, town, "enter data");
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_search_button, "search button");
    
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_type_search_key, 50);
    TestBase.getElements(SBV_Connect_CommonPageObject.SBV_Select_Cash_Center);
    TestBase.ClickViaMouse(SBV_Connect_CommonPageObject.SBV_Select_Cash_Center, "cash canter");
    
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_CIT_Number, 50);
    if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_CIT_Number, "CIT Number"))) {

        ExceptionHandling.HandleAssertion("CIT_Number is not diaplayed");
    }
    
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Region, 50);
    if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Region, "Region"))) {

    	ExceptionHandling.HandleAssertion("Region is not diaplayed");
    }
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Cash_Center, 50);

    if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Cash_Center,  "Cash_Center"))) {

    	ExceptionHandling.HandleAssertion("Cash_Center is not diaplayed");
    }
    
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_click_next_button, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_next_button, "Next button");
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Select_Date, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Select_Date, "Select Date");
    
    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_click_next_button, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_next_button, "Next button");
    
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AddFile, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AddFile, "AddFile button");
    Thread.sleep(3000);

    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_FileUpload1, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_FileUpload1, "upload button");
    Thread.sleep(3000);

    Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\TestData\\AutoIT\\fileupload.exe");

    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Add_Notes, 50);
    TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_Add_Notes, "Testing", "Enter Notes");
    
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Submit_Button, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Submit_Button, "Submit button");
    
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Logcase_Successful_Message, 50);
    if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Logcase_Successful_Message, "Succussufuly Log"))) {

    	ExceptionHandling.HandleAssertion("Succesful Message is not diaplayed");
    }

}

@Given("External User Select Region,CashCentre,CaseType,Case_Subtype By using SheetName {string} and row number \"{int}\" in External Connect System")
public void external_User_Select_Region_CashCentre_CaseType_Case_Subtype_By_using_SheetName_and_row_number_in_External_Connect_System(String SheetName, Integer int1) throws Exception {
	

    Excel_Utility.setExcelFile(filepath, sheetName);
    String RegionValue = Excel_Utility.getCellData(int1, 17);
    String CashcenterValue = Excel_Utility.getCellData(int1, 18);
    String Case_type= Excel_Utility.getCellData(int1, 35);
    String CaseSubType = Excel_Utility.getCellData(int1, 36);
    
	Thread.sleep(3000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Region_Filters, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Region_Filters, "regin filter");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(RegionValue), 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(RegionValue), RegionValue+" to select "+RegionValue+"from Region dropdown");
	
	Thread.sleep(3000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_ExternalCashcentre, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_ExternalCashcentre, "cashcenterDropown");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(CashcenterValue), 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(CashcenterValue), CashcenterValue+" to select "+CashcenterValue+"from Cash Center dropdown");		
	
	Thread.sleep(3000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_CaseType, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_CaseType, "CaseTpye");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(Case_type), 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(Case_type), Case_type+" to select "+Case_type+"from Case Type dropdown");		
	
	Thread.sleep(3000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_External_CaseSubType, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_External_CaseSubType, "CasesubTpye");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(CaseSubType), 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(CaseSubType), CaseSubType+" to select "+CaseSubType+"from Case SubType dropdown");				

}


@Given("External User Enters SearchwithRegion value in SearchField and click on ApplyFilters By using SheetName {string} and row number \"{int}\" in External Connect System")
public void external_User_Enters_SearchwithRegion_value_in_SearchField_and_click_on_ApplyFilters_By_using_SheetName_and_row_number_in_External_Connect_System(String sheetName, Integer int1) throws Throwable {
	
	Excel_Utility.setExcelFile(filepath, sheetName);
    String RegionValue = Excel_Utility.getCellData(int1, 17);
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Search_field, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Search_field, "searchfield");
	TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_Search_field, RegionValue, "Seachfield");
	
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Apply_Filters, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Apply_Filters, "Filterbutton");
	
	Thread.sleep(5000);
	TestBase.ScrollDownBottom();
}

@Given("External User Enters CashCenter value in SearchField and click on ApplyFilters By using SheetName {string} and row number \"{int}\" in External Connect System")
public void external_User_Enters_CashCenter_value_in_SearchField_and_click_on_ApplyFilters_By_using_SheetName_and_row_number_in_External_Connect_System(String sheetName, Integer int1) throws Throwable {
	
	Excel_Utility.setExcelFile(filepath, sheetName);
	String CashcenterValue = Excel_Utility.getCellData(int1, 18);
	
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Selectfilters, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Selectfilters, "Select filters");

	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Search_field, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Search_field, "searchfield");
	TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_Search_field, CashcenterValue, "Seachfield");
	
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Apply_Filters, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Apply_Filters, "Filterbutton");
	
	Thread.sleep(5000);
	TestBase.ScrollDownBottom();
}

@Given("External User Enters Case_type value in SearchField and click on ApplyFilters By using SheetName {string} and row number \"{int}\" in External Connect System")
public void external_User_Enters_Case_type_value_in_SearchField_and_click_on_ApplyFilters_By_using_SheetName_and_row_number_in_External_Connect_System(String sheetName, Integer int1) throws Throwable {

	Excel_Utility.setExcelFile(filepath, sheetName);
	String Case_type= Excel_Utility.getCellData(int1, 35);
	Thread.sleep(5000);
	
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Selectfilters, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Selectfilters, "Select filters");

	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Search_field, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Search_field, "searchfield");
	TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_Search_field, Case_type, "Seachfield");
	
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Apply_Filters, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Apply_Filters, "Filterbutton");
	
	Thread.sleep(5000);
	TestBase.ScrollDownBottom();
}

@Given("External User Enters Case_Subtype value in SearchField and click on ApplyFilters By using SheetName {string} and row number \"{int}\" in External Connect System")
public void external_User_Enters_Case_Subtype_value_in_SearchField_and_click_on_ApplyFilters_By_using_SheetName_and_row_number_in_External_Connect_System(String sheetName, Integer int1) throws Throwable {

	Excel_Utility.setExcelFile(filepath, sheetName);
	String CaseSubType = Excel_Utility.getCellData(int1, 36);
	Thread.sleep(5000);
	
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Selectfilters, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Selectfilters, "Select filters");

	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Search_field, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Search_field, "searchfield");
	TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_Search_field, CaseSubType, "Seachfield");
	
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Apply_Filters, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Apply_Filters, "Filterbutton");
	
	Thread.sleep(5000);
	TestBase.ScrollDownBottom();
}

@Given("Reginal User Navigates to Caselist,Search with Latest Case id and Verify whether it is assigned to Regional User by selecting the User_level,Cash_Center,CLO Values By using SheetName {string} and row number \"{int}\" in External Connect System")
public void reginal_User_Navigates_to_Caselist_Search_with_Latest_Case_id_and_Verify_whether_it_is_assigned_to_Regional_User_by_selecting_the_User_level_Cash_Center_CLO_Values_By_using_SheetName_and_row_number_in_External_Connect_System(String sheetName, Integer int1) throws Throwable {
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_see_case_list, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_see_case_list, "case list");
	Thread.sleep(5000);
	TestBase.RefreshPage();
	Thread.sleep(25000);
	TestBase.driver.switchTo().frame("myFrame");
	TestBase.driver.switchTo().frame("bonitaframe");
	
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, "SearchByfield");
	TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_SearchByinput, NewCase, "Enter");
    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_LatestCaseNumber, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_LatestCaseNumber, "Latestcase Number");

    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AuditTrail, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AuditTrail, "new case button");
    TestBase.ScrollDownBottom();
    
    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Admin, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Admin, "new case button");
    
    Thread.sleep(5000);

    Excel_Utility.setExcelFile(filepath, sheetName);
    String User_level_Regional = Excel_Utility.getCellData(int1, 19);
    String Cash_center = Excel_Utility.getCellData(int1, 17);
    
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_UserLevel, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_UserLevel, "new case button");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(User_level_Regional), 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(User_level_Regional), User_level_Regional+" to select "+User_level_Regional+"from User level dropdown");
	
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_CashCenter, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_CashCenter, "new case button");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(Cash_center), 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(Cash_center), Cash_center+" to select "+Cash_center+"from Cash center dropdown");  

	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_OLga, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_OLga, "new case button");
	
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Assign, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Assign, "new case button");

	String expectedassigstatus="Case successfully reassigned";
	TestBase.waitForElement(SBV_Connect_CommonPageObject.userassignstatus, 50);
	if(TestBase.isElementVisible(SBV_Connect_CommonPageObject.userassignstatus, "userassignstatus")) {
		actualassignstatus=TestBase.getElementText(SBV_Connect_CommonPageObject.userassignstatus, "userassignstatus");
		
	}
    Assert.assertEquals(expectedassigstatus, actualassignstatus);
}


@Given("User Sort SortByOption1 in SortByDropdown By using SheetName {string} and row number \"{int}\" in External Connect System")
public void user_Sort_SortByOption1_in_SortByDropdown_By_using_SheetName_and_row_number_in_External_Connect_System(String sheetName, Integer int1) throws Exception {
	Thread.sleep(25000);
	TestBase.driver.switchTo().frame("myFrame");
	TestBase.driver.switchTo().frame("bonitaframe");
	
	Thread.sleep(5000);

    Excel_Utility.setExcelFile(filepath, sheetName);
    String SortOption1 = Excel_Utility.getCellData(int1, 50);
    
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_SortBy, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_SortBy, "sortBydropdown");
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(SortOption1), 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(SortOption1), SortOption1+" to select "+SortOption1+"from sortBy dropdown");
	
}

@Given("User SortBy SortByOption2 in SortByDropdown By using SheetName {string} and row number \"{int}\" in External Connect System")
public void user_SortBy_SortByOption2_in_SortByDropdown_By_using_SheetName_and_row_number_in_External_Connect_System(String sheetName, Integer int1) throws Exception {
	Thread.sleep(5000);

    Excel_Utility.setExcelFile(filepath, sheetName);
    String SortOption2 = Excel_Utility.getCellData(int1, 21);
    
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_SortBy, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_SortBy, "sortBydropdown");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(SortOption2), 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(SortOption2), SortOption2+" to select "+SortOption2+"from sortBy dropdown");
	Thread.sleep(5000);
}

@Given("User SortBy SortByOption3 in SortByDropdown By using SheetName {string} and row number \"{int}\" in External Connect System")
public void user_SortBy_SortByOption3_in_SortByDropdown_By_using_SheetName_and_row_number_in_External_Connect_System(String sheetName, Integer int1) throws Exception {
	
	Thread.sleep(5000);

    Excel_Utility.setExcelFile(filepath, sheetName);
    String SortOption3 = Excel_Utility.getCellData(int1, 22);
    
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_SortBy, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_SortBy, "sortBydropdown");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(SortOption3), 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(SortOption3), SortOption3+" to select "+SortOption3+"from sortBy dropdown");
	Thread.sleep(5000);
}

@Given("User SortBy SortByOption4 in SortByDropdown By using SheetName {string} and row number \"{int}\" in External Connect System")
public void user_SortBy_SortByOption4_in_SortByDropdown_By_using_SheetName_and_row_number_in_External_Connect_System(String sheetName, Integer int1) throws Exception {
	Thread.sleep(5000);

    Excel_Utility.setExcelFile(filepath, sheetName);
    String SortOption4 = Excel_Utility.getCellData(int1, 23);
    
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_SortBy, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_SortBy, "sortBydropdown");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(SortOption4), 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(SortOption4), SortOption4+" to select "+SortOption4+"from sortBy dropdown");
	Thread.sleep(5000);
}

@Given("User SortBy SortByOption5 in SortByDropdown By using SheetName {string} and row number \"{int}\" in External Connect System")
public void user_SortBy_SortByOption5_in_SortByDropdown_By_using_SheetName_and_row_number_in_External_Connect_System(String sheetName, Integer int1) throws Exception {
	Thread.sleep(5000);

    Excel_Utility.setExcelFile(filepath, sheetName);
    String SortOption5 = Excel_Utility.getCellData(int1, 24);
    
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_SortBy, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_SortBy, "sortBydropdown");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(SortOption5), 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(SortOption5), SortOption5+" to select "+SortOption5+"from sortBy dropdown");
	Thread.sleep(5000);
}

@Given("User SortBy SortByOption6 in SortByDropdown By using SheetName {string} and row number \"{int}\" in External Connect System")
public void user_SortBy_SortByOption6_in_SortByDropdown_By_using_SheetName_and_row_number_in_External_Connect_System(String sheetName, Integer int1) throws Exception {
	Thread.sleep(5000);

    Excel_Utility.setExcelFile(filepath, sheetName);
    String SortOption6 = Excel_Utility.getCellData(int1, 25);
    
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_SortBy, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_SortBy, "sortBydropdown");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(SortOption6), 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(SortOption6), SortOption6+" to select "+SortOption6+"from sortBy dropdown");
	Thread.sleep(5000);
}

@Given("Internal User Search with New Case Id and Update the With Resolution,Business_Workflow,Responsible_Party Case Logged by External User By using SheetName {string} and row number \"{int}\" in External Connect System")
public void internal_User_Search_with_New_Case_Id_and_Update_the_With_Resolution_Business_Workflow_Responsible_Party_Case_Logged_by_External_User_By_using_SheetName_and_row_number_in_External_Connect_System(String sheetName, Integer int1) throws Exception {

	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, "new case button");
	TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_SearchByinput, NewCase, "Enter");

    for(int i=0;i<13;i++) {
    	TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.LEFT));
    }
    TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.BACK_SPACE));
  Thread.sleep(5000);
  TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_New_Case, 50);
  TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_New_Case, "new case button");
  
  TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_CIT_Number, 50);
  if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_CIT_Number, "CIT Number"))) {
	  ExceptionHandling.HandleAssertion("CIT_Number is not diaplayed");
  }
  
  TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Region, 50);
  if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Region,  "Region"))) {

	  ExceptionHandling.HandleAssertion("Region is not diaplayed");

  }
  
  TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Cash_Center, 50);
   if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Cash_Center,   "Cash_Center"))) {

    	  ExceptionHandling.HandleAssertion("Cash_Center is not diaplayed");
      }

   Excel_Utility.setExcelFile(filepath, sheetName);
   String resolutionValue = Excel_Utility.getCellData(int1, 11);
   String BuisnessWorkflow= Excel_Utility.getCellData(int1, 12);
   String ResponsibleParty = Excel_Utility.getCellData(int1, 13);
   
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Resolution_Dropdown, 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Resolution_Dropdown, "ResolutionDropdown");
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(resolutionValue), 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(resolutionValue), resolutionValue+" to select "+resolutionValue+"from Resolution dropdown");
  
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Business_workflow_Dropdown, 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Business_workflow_Dropdown, "Buisness Work flow");
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(BuisnessWorkflow), 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(BuisnessWorkflow), BuisnessWorkflow+" to select "+BuisnessWorkflow+"from Buisness Work flow dropdown");

   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Responsible_party_Dropdown, 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Responsible_party_Dropdown, "Resonsible Party dropdown");
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(ResponsibleParty), 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(ResponsibleParty), ResponsibleParty+" to select "+ResponsibleParty+"from Responsible Party dropdown");

   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AddFile, 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AddFile, "AddFile button");
   Thread.sleep(3000);

   TestBase.waitForElement(SBV_Connect_PageObjects.SBV_FileUpload1, 50);
   TestBase.clickonElement(SBV_Connect_PageObjects.SBV_FileUpload1, "upload button");
   Thread.sleep(3000);

   Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\TestData\\AutoIT\\fileupload.exe");

   Thread.sleep(5000);
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Add_Notes, 50);
   TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_Add_Notes, "Testing", "Enter Notes");
   
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Update, 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Update, "Update button"); 

}
@Given("User Enters StopLoss_Number,BagSeal_Number,Container_Number and upload ten attachements By using SheetName {string} and row number \"{int}\"in Internal Connect System")
public void user_Enters_StopLoss_Number_BagSeal_Number_Container_Number_and_upload_ten_attachements_By_using_SheetName_and_row_number_in_Internal_Connect_System(String sheetName, Integer int1) throws Exception {

	Thread.sleep(5000);
	 Excel_Utility.setExcelFile(filepath, sheetName);
	   String StopLoss_Number = Excel_Utility.getCellData_Integer(int1,32);
	   String BagSeal_Number= Excel_Utility.getCellData_Integer(int1, 33);
	   String Container_Number = Excel_Utility.getCellData_Integer(int1, 34);
	   Thread.sleep(5000);  
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Stoploss, 50);
	TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_Stoploss, StopLoss_Number, "Qusetionthree");
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_BagSeal, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_BagSeal, "new case button");
	TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_BagSeal, BagSeal_Number, "Qusetionthree");
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Container, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Container, "new case button");
	TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_Container, Container_Number, "Qusetionthree");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_click_next_button, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_next_button, "Next button");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AddFile, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AddFile, "AddFile button");
    Thread.sleep(5000);
   TestBase.waitForElement(SBV_Connect_PageObjects.SBV_FileUpload1, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_FileUpload1, "upload button");
  Thread.sleep(3000);
   Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\TestData\\AutoIT\\textfile.exe");
  TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AddFile, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AddFile, "AddFile button");
   Thread.sleep(3000);
  TestBase.waitForElement(SBV_Connect_PageObjects.SBV_FileUpload2, 50);
  TestBase.clickonElement(SBV_Connect_PageObjects.SBV_FileUpload2, "upload button");
   Thread.sleep(3000);
    Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\TestData\\AutoIT\\pptxFile.exe");
    
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AddFile, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AddFile, "AddFile button");
    Thread.sleep(3000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_FileUpload3, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_FileUpload3, "upload button");
    Thread.sleep(3000);
    Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\TestData\\AutoIT\\ExcelFile.exe");
    
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AddFile, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AddFile, "AddFile button");
    Thread.sleep(3000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_FileUpload4, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_FileUpload4, "upload button");
    Thread.sleep(3000);
    Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\TestData\\AutoIT\\textfile.exe");
    
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AddFile, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AddFile, "AddFile button");
    Thread.sleep(3000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_FileUpload5, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_FileUpload5, "upload button");
    Thread.sleep(3000);
    Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\TestData\\AutoIT\\WordFile.exe");
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AddFile, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AddFile, "AddFile button");
    Thread.sleep(3000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_FileUpload6, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_FileUpload6, "upload button");
    Thread.sleep(3000);
    Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\TestData\\AutoIT\\CsvFile.exe");
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AddFile, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AddFile, "AddFile button");
    Thread.sleep(3000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_FileUpload7, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_FileUpload7, "upload button");
    Thread.sleep(3000);
    Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\TestData\\AutoIT\\ExcelFile.exe");
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AddFile, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AddFile, "AddFile button");
    Thread.sleep(3000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_FileUpload8, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_FileUpload8, "upload button");
    Thread.sleep(3000);
    Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\TestData\\AutoIT\\pptxFile.exe");
    
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AddFile, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AddFile, "AddFile button");
    Thread.sleep(3000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_FileUpload9, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_FileUpload9, "upload button");
    Thread.sleep(3000);
    Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\TestData\\AutoIT\\CsvFile.exe");
    
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AddFile, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AddFile, "AddFile button");
    Thread.sleep(3000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_FileUpload10, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_FileUpload10, "upload button");
    Thread.sleep(3000);
    Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\TestData\\AutoIT\\textfile.exe");
    
    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Add_Notes, 50);
    TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_Add_Notes, "successfully upload the files", "Enter Notes");
    
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Submit_Button, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Submit_Button, "Submit button");
    
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Logcase_Successful_Message, 50);
    if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Logcase_Successful_Message, "Succussufuly Log"))) {

    	ExceptionHandling.HandleAssertion("Succesful Message is not diaplayed");
    }
}

@Given("Internal User Select Region,CashCentre,CaseType,Case_Subtype By using SheetName {string} and row number \"{int}\" in Internal Connect System")
public void internal_User_Select_Region_CashCentre_CaseType_Case_Subtype_By_using_SheetName_and_row_number_in_Internal_Connect_System(String sheetName, Integer int1) throws Throwable {

    Excel_Utility.setExcelFile(filepath, sheetName);
    String RegionValue = Excel_Utility.getCellData(int1, 17);
    String CashcenterValue = Excel_Utility.getCellData(int1, 18);
    String Case_type= Excel_Utility.getCellData(int1, 9);
    String CaseSubType = Excel_Utility.getCellData(int1, 10);
    String ConsumerType = Excel_Utility.getCellData(int1, 26);
    String TranscatingBank = Excel_Utility.getCellData(int1, 27);
    
	Thread.sleep(3000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Region_Filters, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Region_Filters, "regin filter");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(RegionValue), 20);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(RegionValue), RegionValue+" to select "+RegionValue+"from Region dropdown");
	
	Thread.sleep(3000);
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Cash_Center_Internal, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Cash_Center_Internal, "cashcenterDropown");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(CashcenterValue), 20);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(CashcenterValue), CashcenterValue+" to select "+CashcenterValue+"from Cash Center dropdown");		
	
	Thread.sleep(3000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_CaseType, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_CaseType, "CaseTpye");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(Case_type), 20);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(Case_type), Case_type+" to select "+Case_type+"from Case Type dropdown");		
	
	Thread.sleep(3000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_External_CaseSubType, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_External_CaseSubType, "CasesubTpye");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(CaseSubType), 20);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(CaseSubType), CaseSubType+" to select "+CaseSubType+"from Case SubType dropdown");				

	
	if(TestBase.isElementVisible(SBV_Connect_PageObjects.SBV_ConsumerType, "Consumer Type dropdown")) {
	Thread.sleep(3000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_ConsumerType, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_ConsumerType, "ConsumerType");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(ConsumerType), 20);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(ConsumerType), ConsumerType+" to select "+ConsumerType+"from Case SubType dropdown");				

	Thread.sleep(3000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_TranscatingBank, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_TranscatingBank, "TranscatingBank");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(TranscatingBank), 20);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(TranscatingBank), TranscatingBank+" to select "+TranscatingBank+"from Case SubType dropdown");				
	}
	
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Apply_Filters, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Apply_Filters, "Filterbutton");
	
	Thread.sleep(5000);
	TestBase.ScrollDownBottom();
	Thread.sleep(5000);
}
@Given("Internal User Enters SearchwithRegion value in SearchField and click on ApplyFilters By using SheetName {string} and row number \"{int}\" in Internal Connect System")
public void internal_User_Enters_SearchwithRegion_value_in_SearchField_and_click_on_ApplyFilters_By_using_SheetName_and_row_number_in_Internal_Connect_System(String sheetName, Integer int1) throws Throwable {

	Excel_Utility.setExcelFile(filepath, sheetName);
    String RegionValue = Excel_Utility.getCellData(int1, 17);
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Search_field, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Search_field, "searchfield");
	TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_Search_field, RegionValue, "Seachfield");
	
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Apply_Filters, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Apply_Filters, "Filterbutton");
	
	Thread.sleep(5000);
	TestBase.ScrollDownBottom();
	Thread.sleep(5000);
}

@Given("Internal User Enters CashCenter value in SearchField and click on ApplyFilters By using SheetName {string} and row number \"{int}\" in Internal Connect System")
public void internal_User_Enters_CashCenter_value_in_SearchField_and_click_on_ApplyFilters_By_using_SheetName_and_row_number_in_Internal_Connect_System(String sheetName, Integer int1) throws Throwable {
	Excel_Utility.setExcelFile(filepath, sheetName);
	String CashcenterValue = Excel_Utility.getCellData(int1, 15);
	
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Selectfilters, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Selectfilters, "Select filters");

	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Search_field, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Search_field, "searchfield");
	TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_Search_field, CashcenterValue, "Seachfield");
	
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Apply_Filters, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Apply_Filters, "Filterbutton");
	
	Thread.sleep(5000);
	TestBase.ScrollDownBottom();
	Thread.sleep(5000);
}

@Then("Regional User Log a New Case by using town,Case_type,Case_Subtype By using SheetName {string} and row number \"{int}\" in Regional Connect System")
public void regional_User_Log_a_New_Case_by_using_town_Case_type_Case_Subtype_By_using_SheetName_and_row_number_in_Regional_Connect_System(String string, Integer int1) throws Throwable {
	TestBase.RefreshPage();
    Thread.sleep(25000);
    TestBase.driver.switchTo().frame("myFrame");
    TestBase.driver.switchTo().frame("bonitaframe");
    TestBase.driver.switchTo().frame(TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_inner_frame));

    Excel_Utility.setExcelFile(filepath, sheetName);
    String town = Excel_Utility.getCellData(int1, 8);
    String Case_type= Excel_Utility.getCellData(int1, 35);
    String CaseSubType = Excel_Utility.getCellData(int1, 36);
    
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_query_menu, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_query_menu, "CaseTypedropdown");
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(Case_type), 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(Case_type), Case_type+" to select "+Case_type+"from case type dropdown");

    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_query_menu, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_query_menu, "CaseSubTypedropdown");
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(CaseSubType), 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(CaseSubType), CaseSubType+" to select "+CaseSubType+"from case Sub type dropdown");

    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_click_next_button, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_next_button, "Next button");

    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_type_search_key, 50);
    TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_type_search_key, town, "enter data");
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_search_button, "search button");

    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_type_search_key, 50);
    TestBase.getElements(SBV_Connect_CommonPageObject.SBV_Select_CashcenterRegional);
    TestBase.ClickViaMouse(SBV_Connect_CommonPageObject.SBV_Select_CashcenterRegional, "cash canter");

    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_CIT_Number, 50);
    if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_CIT_Number, "CIT Number"))) {

        ExceptionHandling.HandleAssertion("CIT_Number is not diaplayed");
    }

    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Region, 50);
    if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Region, "Region"))) {

        ExceptionHandling.HandleAssertion("Region is not diaplayed");
    }
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Cash_Center, 50);

    if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Cash_Center,  "Cash_Center"))) {

        ExceptionHandling.HandleAssertion("Cash_Center is not diaplayed");
    }

    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_click_next_button, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_next_button, "Next button");
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Select_Date, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Select_Date, "Select Date");
    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_click_next_button, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_next_button, "Next button");

}

@Then("Regional User add a file and Complete Updating Process")
public void regional_User_add_a_file_and_Complete_Updating_Process() throws Exception {

    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AddFile, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AddFile, "AddFile button");
    Thread.sleep(3000);

    String PdfFile = "TestData/UploadFiles/dummy.pdf";
    TestBase.FileUpload(SBV_Connect_CommonPageObject.SBV_Uploadfile1, PdfFile);

    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Add_Notes, 50);
    TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_Add_Notes, "Testing", "Enter Notes");

    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Submit_Button, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Submit_Button, "Submit button");

    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Logcase_Successful_Message, 50);
    if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Logcase_Successful_Message, "Succussufuly Log"))) {

        ExceptionHandling.HandleAssertion("Succesful Message is not diaplayed");
    }

}

@Then("Regional User Navigates to Dashboard and click on Log a New case in Regional Connect System")
public void regional_User_Navigates_to_Dashboard_and_click_on_Log_a_New_case_in_Regional_Connect_System() throws Exception {

    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Dashboard, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Dashboard, "dashboard");
    TestBase.RefreshPage();
    Thread.sleep(15000);
    TestBase.driver.switchTo().frame("myFrame");
    TestBase.driver.switchTo().frame("bonitaframe");
    Thread.sleep(3000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Log_New_Case, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Log_New_Case, "Log a new Case");

}
@Given("Internal User Enters Case_type value in SearchField and click on ApplyFilters By using SheetName {string} and row number \"{int}\" in Internal Connect System")
public void internal_User_Enters_Case_type_value_in_SearchField_and_click_on_ApplyFilters_By_using_SheetName_and_row_number_in_Internal_Connect_System(String sheetName, Integer int1) throws Throwable {
	Excel_Utility.setExcelFile(filepath, sheetName);
	String Case_type= Excel_Utility.getCellData(int1, 35);
	Thread.sleep(5000);
	
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Selectfilters, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Selectfilters, "Select filters");

	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Search_field, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Search_field, "searchfield");
	TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_Search_field, Case_type, "Seachfield");
	
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Apply_Filters, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Apply_Filters, "Filterbutton");
	
	Thread.sleep(5000);
	TestBase.ScrollDownBottom();
	Thread.sleep(5000);
}

@Given("Internal User Enters Case_Subtype value in SearchField and click on ApplyFilters By using SheetName {string} and row number \"{int}\" in Internal Connect System")
public void internal_User_Enters_Case_Subtype_value_in_SearchField_and_click_on_ApplyFilters_By_using_SheetName_and_row_number_in_Internal_Connect_System(String sheetName, Integer int1) throws Throwable {
	Excel_Utility.setExcelFile(filepath, sheetName);
	String CaseSubType = Excel_Utility.getCellData(int1, 36);
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Selectfilters, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Selectfilters, "Select filters");

	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Search_field, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Search_field, "searchfield");
	TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_Search_field, CaseSubType, "Seachfield");
	
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Apply_Filters, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Apply_Filters, "Filterbutton");
	
	Thread.sleep(5000);
	TestBase.ScrollDownBottom();
	Thread.sleep(5000);
}

@Given("User Sort SortByOption1 in SortByDropdown By using SheetName {string} and row number \"{int}\" in Internal Connect System")
public void user_Sort_SortByOption1_in_SortByDropdown_By_using_SheetName_and_row_number_in_Internal_Connect_System(String sheetName, Integer int1) throws Exception {
	Thread.sleep(15000);
	TestBase.driver.switchTo().frame("myFrame");
	TestBase.driver.switchTo().frame("bonitaframe");
	
	Thread.sleep(5000);

    Excel_Utility.setExcelFile(filepath, sheetName);
    String SortOption1 = Excel_Utility.getCellData(int1, 20);
    
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_SortBy, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_SortBy, "sortBydropdown");
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(SortOption1), 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(SortOption1), SortOption1+" to select "+SortOption1+"from sortBy dropdown");
	TestBase.ScrollToElementByPixel(300);
}

@Given("User SortBy SortByOption2 in SortByDropdown By using SheetName {string} and row number \"{int}\" in Internal Connect System")
public void user_SortBy_SortByOption2_in_SortByDropdown_By_using_SheetName_and_row_number_in_Internal_Connect_System(String sheetName, Integer int1) throws Exception {
	Thread.sleep(5000);

    Excel_Utility.setExcelFile(filepath, sheetName);
    String SortOption2 = Excel_Utility.getCellData(int1, 21);
    
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_SortBy, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_SortBy, "sortBydropdown");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(SortOption2), 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(SortOption2), SortOption2+" to select "+SortOption2+"from sortBy dropdown");
	Thread.sleep(5000);
	TestBase.ScrollToElementByPixel(300);
}

@Given("User SortBy SortByOption3 in SortByDropdown By using SheetName {string} and row number \"{int}\" in Internal Connect System")
public void user_SortBy_SortByOption3_in_SortByDropdown_By_using_SheetName_and_row_number_in_Internal_Connect_System(String sheetName, Integer int1) throws Exception {
	Thread.sleep(5000);

    Excel_Utility.setExcelFile(filepath, sheetName);
    String SortOption3 = Excel_Utility.getCellData(int1, 22);
    
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_SortBy, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_SortBy, "sortBydropdown");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(SortOption3), 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(SortOption3), SortOption3+" to select "+SortOption3+"from sortBy dropdown");
	Thread.sleep(5000);
	TestBase.ScrollToElementByPixel(300);
}

@Given("User SortBy SortByOption4 in SortByDropdown By using SheetName {string} and row number \"{int}\" in Internal Connect System")
public void user_SortBy_SortByOption4_in_SortByDropdown_By_using_SheetName_and_row_number_in_Internal_Connect_System(String sheetName, Integer int1) throws Exception {
	Thread.sleep(5000);

    Excel_Utility.setExcelFile(filepath, sheetName);
    String SortOption4 = Excel_Utility.getCellData(int1, 23);
    
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_SortBy, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_SortBy, "sortBydropdown");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(SortOption4), 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(SortOption4), SortOption4+" to select "+SortOption4+"from sortBy dropdown");
	Thread.sleep(5000);
	TestBase.ScrollToElementByPixel(300);
}

@Given("User SortBy SortByOption5 in SortByDropdown By using SheetName {string} and row number \"{int}\" in Internal Connect System")
public void user_SortBy_SortByOption5_in_SortByDropdown_By_using_SheetName_and_row_number_in_Internal_Connect_System(String sheetName, Integer int1) throws Exception {
	Thread.sleep(5000);

    Excel_Utility.setExcelFile(filepath, sheetName);
    String SortOption5 = Excel_Utility.getCellData(int1, 24);
    
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_SortBy, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_SortBy, "sortBydropdown");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(SortOption5), 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(SortOption5), SortOption5+" to select "+SortOption5+"from sortBy dropdown");
	Thread.sleep(5000);
	TestBase.ScrollToElementByPixel(300);
}

@Given("User SortBy SortByOption6 in SortByDropdown By using SheetName {string} and row number \"{int}\" in Internal Connect System")
public void user_SortBy_SortByOption6_in_SortByDropdown_By_using_SheetName_and_row_number_in_Internal_Connect_System(String sheetName, Integer int1) throws Exception {
	Thread.sleep(5000);

    Excel_Utility.setExcelFile(filepath, sheetName);
    String SortOption6 = Excel_Utility.getCellData(int1, 25);
    
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_SortBy, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_SortBy, "sortBydropdown");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(SortOption6), 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(SortOption6), SortOption6+" to select "+SortOption6+"from sortBy dropdown");
	Thread.sleep(5000);
	TestBase.ScrollToElementByPixel(500);
}

@Given("Internal User Search with New Case Id and Update the With Resolution,Business_Workflow,Responsible_Party Case Logged by Internal User By using SheetName {string} and row number \"{int}\" in Internal Connect System")
public void internal_User_Search_with_New_Case_Id_and_Update_the_With_Resolution_Business_Workflow_Responsible_Party_Case_Logged_by_Internal_User_By_using_SheetName_and_row_number_in_Internal_Connect_System(String sheetName, Integer int1) throws Exception {

	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, "new case button");
	TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_SearchByinput, NewCase, "Enter");

    for(int i=0;i<13;i++) {

    	TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.LEFT));
    }

    TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.BACK_SPACE));

  Thread.sleep(5000);
  TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_UpdateCase, 50);
  TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_UpdateCase, "new case button");
  
  TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_CIT_Number, 50);
  if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_CIT_Number, "CIT Number"))) {

	  ExceptionHandling.HandleAssertion("CIT_Number is not diaplayed");

  }
  
  TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Region, 50);
  if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Region,  "Region"))) {

	  ExceptionHandling.HandleAssertion("Region is not diaplayed");

  }
  
  TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Cash_Center, 50);
   if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Cash_Center,   "Cash_Center"))) {

    	  ExceptionHandling.HandleAssertion("Cash_Center is not diaplayed");

      }

   Excel_Utility.setExcelFile(filepath, sheetName);
   String resolutionValue = Excel_Utility.getCellData(int1, 11);
   String BuisnessWorkflow= Excel_Utility.getCellData(int1, 12);
   String ResponsibleParty = Excel_Utility.getCellData(int1, 13);
   
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Resolution_Dropdown, 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Resolution_Dropdown, "ResolutionDropdown");
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(resolutionValue), 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(resolutionValue), resolutionValue+" to select "+resolutionValue+"from Resolution dropdown");
  
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Business_workflow_Dropdown, 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Business_workflow_Dropdown, "Buisness Work flow");
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(BuisnessWorkflow), 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(BuisnessWorkflow), BuisnessWorkflow+" to select "+BuisnessWorkflow+"from Buisness Work flow dropdown");

   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Responsible_party_Dropdown, 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Responsible_party_Dropdown, "Resonsible Party dropdown");
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(ResponsibleParty), 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(ResponsibleParty), ResponsibleParty+" to select "+ResponsibleParty+"from Responsible Party dropdown");

   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AddFile, 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AddFile, "AddFile button");
   Thread.sleep(3000);

   TestBase.waitForElement(SBV_Connect_PageObjects.SBV_FileUpload1, 50);
   TestBase.clickonElement(SBV_Connect_PageObjects.SBV_FileUpload1, "upload button");
   Thread.sleep(3000);

   Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\TestData\\AutoIT\\fileupload.exe");
   Thread.sleep(5000);
   TestBase.waitForElement(SBV_Connect_PageObjects.SBV_FileUpload2, 50);
   TestBase.clickonElement(SBV_Connect_PageObjects.SBV_FileUpload2, "upload button");
   Thread.sleep(3000);

   Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\TestData\\AutoIT\\fileupload.exe");
   Thread.sleep(5000);
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Add_Notes, 50);
   TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_Add_Notes, "Testing", "Enter Notes");
   
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Update, 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Update, "Update button"); 
}


@Given("Reginal User Navigates to Caselist,Search with Latest Case id and Verify whether it is assigned to Regional User by using Excelsheetdata {string} and row number \"{int}\"")
public void reginal_User_Navigates_to_Caselist_Search_with_Latest_Case_id_and_Verify_whether_it_is_assigned_to_Regional_User_by_using_Excelsheetdata_and_row_number(String sheetName, Integer int1) throws Throwable {

    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_see_case_list, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_see_case_list, "case list");
    Thread.sleep(5000);
    TestBase.RefreshPage();
    Thread.sleep(30000);
    TestBase.driver.switchTo().frame("myFrame");
    TestBase.driver.switchTo().frame("bonitaframe");
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, 500);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, "SearchByfield");
    TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_SearchByinput, NewCase, "Enter");
    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_LatestCaseNumber, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_LatestCaseNumber, "Latestcase Number");

    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AuditTrail, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AuditTrail, "new case button");
    TestBase.ScrollDownBottom();
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Date_And_TimeStamp1, 50);
	String actauStatus = TestBase.getElementText(SBV_Connect_PageObjects.SBV_Date_And_TimeStamp1, "status column");
	System.out.println(actauStatus);
    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Admin, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Admin, "new case button");

    Thread.sleep(5000);

    Excel_Utility.setExcelFile(filepath, sheetName);
    String User_level1 = Excel_Utility.getCellData(int1, 19);
    String Cash_center1 = Excel_Utility.getCellData(int1, 17);

    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_UserLevel, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_UserLevel, "new case button");
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(User_level1), 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(User_level1), User_level1+" to select "+User_level1+"from User level dropdown");

    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_CashCenter, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_CashCenter, "new case button");
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(Cash_center1), 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(Cash_center1), Cash_center1+" to select "+Cash_center1+"from Cash center dropdown");  
    Thread.sleep(3000);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Reginaluser, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Reginaluser, "regional user");
    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Assign, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Assign, "new case button");

    String expectedassigstatus="Case successfully reassigned";
    TestBase.waitForElement(SBV_Connect_CommonPageObject.userassignstatus, 50);
    if(TestBase.isElementVisible(SBV_Connect_CommonPageObject.userassignstatus, "olgaassignstatus")) {
        actualassignstatus=TestBase.getElementText(SBV_Connect_CommonPageObject.userassignstatus, "olgastatus");

    }
    Assert.assertEquals(expectedassigstatus, actualassignstatus);
}

@Then("Reginal User Navigates to Tasklist,Search with Latest Case Id ,Click On Pause Apporval and Update the Case with Excelsheetdata {string} and row number \"{int}\"")
public void reginal_User_Navigates_to_Tasklist_Search_with_Latest_Case_Id_Click_On_Pause_Apporval_and_Update_the_Case_with_Excelsheetdata_and_row_number(String sheetName, int int1) throws Exception {

    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_view_task_list, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_view_task_list, "View task list");
    TestBase.driver.navigate().refresh();
    Thread.sleep(5000);
    TestBase.driver.switchTo().frame("myFrame");
    TestBase.driver.switchTo().frame("bonitaframe");
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, "new case button");
    Thread.sleep(4000);
    System.out.println(NewCase);
    TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_SearchByinput, NewCase, "Enter");

  for(int i=0;i<13;i++) {

      TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.LEFT));
      }

  TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.BACK_SPACE));

  Thread.sleep(5000);
  TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_PauseApporval, 50);
  TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_PauseApporval, "update case");
  Thread.sleep(5000);
  TestBase.waitForElement(SBV_Connect_PageObjects.SBV_YesButton, 50);
  TestBase.clickonElement(SBV_Connect_PageObjects.SBV_YesButton, "yes button");

  Thread.sleep(3000);
  TestBase.waitForElement(SBV_Connect_PageObjects.Allowedtimedropdown, 50);
  TestBase.clickonElement(SBV_Connect_PageObjects.Allowedtimedropdown, "Allowed_Time dropdown");

   Thread.sleep(5000);
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Add_Notes, 50);
   TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_Add_Notes, "Case resolution", "Enter Notes");

   Thread.sleep(5000);
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Update, 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Update, "Update button"); 

}

@Then("Internal User Log a New Case by using town,Case_type,Case_Subtype By using SheetName {string} and row number \"{int}\" in Internal Connect System")
public void internal_User_Log_a_New_Case_by_using_town_Case_type_Case_Subtype_By_using_SheetName_and_row_number_in_Internal_Connect_System(String sheetName, Integer int1) throws Throwable {
	Thread.sleep(5000);
	TestBase.RefreshPage();
	Thread.sleep(25000);
	TestBase.driver.switchTo().frame("myFrame");
	TestBase.driver.switchTo().frame("bonitaframe");
	TestBase.driver.switchTo().frame(TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_inner_frame));
	
    Excel_Utility.setExcelFile(filepath, sheetName);
    String town = Excel_Utility.getCellData(int1, 8);
    String Case_type= Excel_Utility.getCellData(int1, 35);
    String CaseSubType = Excel_Utility.getCellData(int1, 36);
	
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_query_menu, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_query_menu, "CaseTypedropdown");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(Case_type), 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(Case_type), Case_type+" to select "+Case_type+"from case type dropdown");
	
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_query_menu, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_query_menu, "CaseSubTypedropdown");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(CaseSubType), 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(CaseSubType), CaseSubType+" to select "+CaseSubType+"from case Sub type dropdown");
	
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_click_next_button, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_next_button, "Next button");

    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_type_search_key, 50);
    TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_type_search_key, town, "enter data");
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_search_button, "search button");
    
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_type_search_key, 50);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Select_Cash_Center_Internal,200);
    TestBase.ClickViaMouse(SBV_Connect_CommonPageObject.SBV_Select_Cash_Center_Internal, "cash canter");
    
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_CIT_Number, 50);
    if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_CIT_Number, "CIT Number"))) {

        ExceptionHandling.HandleAssertion("CIT_Number is not diaplayed");
    }
    
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Region, 50);
    if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Region, "Region"))) {

    	ExceptionHandling.HandleAssertion("Region is not diaplayed");
    }
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Cash_Center, 50);

    if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Cash_Center,  "Cash_Center"))) {

    	ExceptionHandling.HandleAssertion("Cash_Center is not diaplayed");
    }
    
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_click_next_button, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_next_button, "Next button");
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Select_Date, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Select_Date, "Select Date");
    Thread.sleep(5000);
	 Excel_Utility.setExcelFile(filepath, sheetName);
	   String StopLoss_Number = Excel_Utility.getCellData_Integer(int1,32);
	   String BagSeal_Number= Excel_Utility.getCellData_Integer(int1, 33);
	   String Container_Number = Excel_Utility.getCellData_Integer(int1, 34);
	   Thread.sleep(5000);  
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Stoploss, 50);
	TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_Stoploss, StopLoss_Number, "Qusetionthree");
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_BagSeal, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_BagSeal, "new case button");
	TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_BagSeal, BagSeal_Number, "Qusetionthree");
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Container, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Container, "new case button");
	TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_Container, Container_Number, "Qusetionthree");
    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_click_next_button, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_next_button, "Next button");
    
}


@Given("Reginal User Navigates to Caselist,Search with Latest Case id and Assign to National User by using Excelsheetdata {string} and row number \"{int}\"")
public void reginal_User_Navigates_to_Caselist_Search_with_Latest_Case_id_and_Assign_to_National_User_by_using_Excelsheetdata_and_row_number(String sheetName, Integer int1) throws Throwable {
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_see_case_list, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_see_case_list, "case list");
	 Thread.sleep(5000);
	    TestBase.RefreshPage();
	Thread.sleep(25000);
	TestBase.driver.switchTo().frame("myFrame");
	TestBase.driver.switchTo().frame("bonitaframe");
	
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, 500);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, "SearchByfield");
	TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_SearchByinput, NewCase, "Enter");
    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_LatestCaseNumber, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_LatestCaseNumber, "Latestcase Number");

    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AuditTrail, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AuditTrail, "new case button");
    TestBase.ScrollDownBottom();
    
    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Admin, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Admin, "new case button");
    
    Thread.sleep(5000);

	Excel_Utility.setExcelFile(filepath, sheetName);
    String User_level = Excel_Utility.getCellData(1, 28);
    
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_UserLevel, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_UserLevel, "new case button");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(User_level), 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(User_level), User_level+" to select "+User_level+"from User level dropdown");
	
	Thread.sleep(3000);
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Lauren_Lau, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Lauren_Lau, "new case button");
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Assign, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Assign, "new case button");

	String expectedassigstatus="Case successfully reassigned";
	TestBase.waitForElement(SBV_Connect_CommonPageObject.userassignstatus, 50);
	if(TestBase.isElementVisible(SBV_Connect_CommonPageObject.userassignstatus, "olgaassignstatus")) {
		actualassignstatus=TestBase.getElementText(SBV_Connect_CommonPageObject.userassignstatus, "olgastatus");
		
	}
	Assert.assertEquals(expectedassigstatus, actualassignstatus);
}


@Given("Regional User Navigates to CaseList and Click on All Cases")
public void regional_User_Navigates_to_CaseList_and_Click_on_All_Cases() throws Exception {

    TestBase.waitForElement(SBV_Connect_PageObjects.CaseList, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.CaseList, "Caselist");

    Thread.sleep(25000);
    TestBase.driver.switchTo().frame("myFrame");
    TestBase.driver.switchTo().frame("bonitaframe");

    TestBase.waitForElement(SBV_Connect_PageObjects.AllCases, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.AllCases, "All Cases");

}


@Given("Sort the CaseID By DESC")
public void sort_the_CaseID_By_DESC() throws Exception {

    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_PageObjects.CaseIDDesc, 100);
    TestBase.clickonElement(SBV_Connect_PageObjects.CaseIDDesc, "CaseIdDesc");

    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_PageObjects.CaseIDDesc, 100);
    TestBase.clickonElement(SBV_Connect_PageObjects.CaseIDDesc, "CaseIdDesc");

}

@Given("Verify the Case loged by Regional User")
public void verify_the_Case_loged_by_Regional_User() throws Exception {

	
	    Thread.sleep(5000);
	    TestBase.waitForElement(SBV_Connect_PageObjects.CaseIDDesc, 100);
	    TestBase.clickonElement(SBV_Connect_PageObjects.CaseIDDesc, "CaseIdDesc");

	    Thread.sleep(5000);
	    TestBase.waitForElement(SBV_Connect_PageObjects.CaseIDDesc, 100);
	    TestBase.clickonElement(SBV_Connect_PageObjects.CaseIDDesc, "CaseIdDesc");

    Thread.sleep(5000);
    TestBase.RefreshPage();
//    if(!TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_LatestCaseNumber, "latest Row")) {
//    
//    	TestBase.RefreshPage();
//    }
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_LatestCasenumber, 200);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_LatestCasenumber, "Latestcase Number");
    Thread.sleep(5000);
    if(!(TestBase.waitForElementToBevisible(SBV_Connect_CommonPageObject.SBV_GetCaseid,500))) {
        TestBase.driver.navigate().refresh();
        NewCase = TestBase.getElementText(SBV_Connect_CommonPageObject.SBV_GetCaseid," Firstrow");
      }
    else if(TestBase.waitForElementToBevisible(SBV_Connect_CommonPageObject.SBV_GetCaseid,500) ){

          Thread.sleep(5000);
          NewCase = TestBase.getElementText(SBV_Connect_CommonPageObject.SBV_GetCaseid," Firstrow");    

      }else {

          ExceptionHandling.HandleAssertion("unable to copy Firstrow");
      }

    System.out.println(NewCase);
}


@Given("External User Navigates to TaskList,Search with Latest Case id,Click on Complete Survey and Submit it by selecting the QuestionOne,QuestionTwo,QuestionThree Values using Excelsheetdata {string} and row number \"{int}\"")
public void external_User_Navigates_to_TaskList_Search_with_Latest_Case_id_Click_on_Complete_Survey_and_Submit_it_by_selecting_the_QuestionOne_QuestionTwo_QuestionThree_Values_using_Excelsheetdata_and_row_number(String sheetName, Integer int1) throws Exception {
	 Thread.sleep(5000);
	    TestBase.RefreshPage();
	Thread.sleep(25000);
	TestBase.driver.switchTo().frame("myFrame");
	TestBase.driver.switchTo().frame("bonitaframe");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, "new case button");
	TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_SearchByinput, NewCase, "Enter");
    for(int i=0;i<13;i++) {

    	TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.LEFT));

    }
    TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.BACK_SPACE));
    Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Complete_Survey, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Complete_Survey, "new case button");
	Excel_Utility.setExcelFile(filepath, sheetName);
    String Questionone = Excel_Utility.getCellData(1, 29);
    String QuestionTwo = Excel_Utility.getCellData(1, 30);
    String Qusetionthree = Excel_Utility.getCellData(1, 31);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Questionone, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Questionone, "questionone dropdown");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(Questionone), 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(Questionone), Questionone+" to select "+Questionone+"from Responsible Party dropdown");
    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_QuestionTwo, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_QuestionTwo, "questionotwo dropdown");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(QuestionTwo), 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(QuestionTwo), QuestionTwo+" to select "+QuestionTwo+"from Responsible Party dropdown");
    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_QuestionThree, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_QuestionThree, "new case button");
    TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_QuestionThree, Qusetionthree, "Qusetionthree");
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Submit, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Submit, "new case button");
}

/////////////////////Regisration user steps/////////////////////////////////


@When("User Enter Connect URL and Navigate to Login Page")
public void user_Enter_Connect_URL_and_Navigate_to_Login_Page() throws InterruptedException {
   
	Thread.sleep(3000);
	String url=Utils.getFileProperty("Application_SBV_ConnectURL");
	pageBase.driver.get(url);

}

@When("User Click on RegisterNow")
public void user_Click_on_RegisterNow() throws Exception {
   
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_RegisterNow, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_RegisterNow, "RegisterNow link");
}

@When("User Enters {string} as Name in Registration Page")
public void user_Enters_as_Name_in_Registration_Page(String Name) throws Exception {
  
   Thread.sleep(5000);
   TestBase.waitForElement(SBV_Connect_PageObjects.SBV_RegisterName, 50);
   TestBase.clickonElement(SBV_Connect_PageObjects.SBV_RegisterName, "Name textBox");
   TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_RegisterName, Name, "Name textBox");
}

@When("User Enters {string} as SurName in Registration Page")
public void user_Enters_as_SurName_in_Registration_Page(String SurName) throws Exception {
	   Thread.sleep(5000);
	   TestBase.waitForElement(SBV_Connect_PageObjects.SBV_registerSurname, 50);
	   TestBase.clickonElement(SBV_Connect_PageObjects.SBV_registerSurname, "Name textBox");
	   TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_registerSurname, SurName, "Name textBox");
}


@When("User Enters {string} as ContactNumber in Registration Page")
public void user_Enters_as_ContactNumber_in_Registration_Page(String ContactNumber) throws Exception {
       
	   Thread.sleep(5000);
	   TestBase.waitForElement(SBV_Connect_PageObjects.SBV_RegisterContactNo, 50);
	   TestBase.clickonElement(SBV_Connect_PageObjects.SBV_RegisterContactNo, "ContactNumber textBox");
	   TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_RegisterContactNo, ContactNumber, "Name textBox");
	   
}

@When("User Clicks on Accept Terms and Conditions CheckBox")
public void user_Clicks_on_Accept_Terms_and_Conditions_CheckBox() throws Exception {
	   Thread.sleep(5000);
	   TestBase.waitForElement(SBV_Connect_PageObjects.SBV_RegisteraccepttermsCondition, 50);
	   TestBase.clickonElement(SBV_Connect_PageObjects.SBV_RegisteraccepttermsCondition, "CheckBox");
	
}

@When("User Clicks on VerifyEmail")
public void user_Clicks_on_VerifyEmail() throws Exception {
	   Thread.sleep(5000);
	   TestBase.waitForElement(SBV_Connect_PageObjects.SBV_RegisterVerifyMailbutton, 50);
	   TestBase.clickonElement(SBV_Connect_PageObjects.SBV_RegisterVerifyMailbutton, "Verify Mail Button");
	
}

@When("User Verify the Verification Email Sent to Respected Email")
public void user_Verify_the_Verification_Email_Sent_to_Respected_Email() throws Exception {
   
	  String EmailSentMsg = "Verification email sent!";
	  Thread.sleep(5000);
	  String Actualstatus= TestBase.getElementText(SBV_Connect_PageObjects.SBV_RegisterMailVarification, "EmailSentMsg");
      System.out.println(Actualstatus);
     if(EmailSentMsg==Actualstatus) {
    	 System.out.println("Verification Email is Successfuly sent ");
     }else {
    	 System.out.println("Verification Email is Successfuly sent");
     }
}

@When("User successfully navigate to UserAccountsDetails Page")
public void user_successfully_navigate_to_UserAccountsDetails_Page() throws Exception {
    Thread.sleep(3000);
    if(TestBase.isElementVisible(SBV_Connect_PageObjects.SBV_registerAccountpage, "Account Detail text")) {
    	System.out.println("User Successfully landed on the Account Registarion page");
    }else {
    	System.out.println("User Successfully not landed on the Account Registarion page");
    }
	
}

@When("User Select {string} as UserType in Registration Page")
public void user_Select_as_UserType_in_Registration_Page(String UserType) throws Exception {
	
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_registerUserTypeDropdown, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_registerUserTypeDropdown, "User Type dropdown");
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoptions(UserType), 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoptions(UserType), UserType+" to select "+UserType+"from User Type dropdown");

}

@When("User Select {string} as Role in Registration Page")
public void user_Select_as_Role_in_Registration_Page(String Role) throws Exception {

	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_registerUserRoledropdown, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_registerUserRoledropdown, "User Type dropdown");
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoptions(Role), 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoptions(Role), Role+" to select "+Role+"from Role dropdown");
}

@When("User Enter {string} as Organisation in Registration Page")
public void user_Enter_as_Organisation_in_Registration_Page(String OrganisationName) throws Exception {
    
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_registerUserOrganisation, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_registerUserOrganisation, "Name textBox");
	TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_registerUserOrganisation, OrganisationName, "OrganisationName textBox");
}

@When("User Enter {string} as JobTitle in Registration Page")
public void user_Enter_as_JobTitle_in_Registration_Page(String JobTitle) throws Exception {
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_registerUserJobTitle, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_registerUserJobTitle, "Name textBox");
	TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_registerUserJobTitle, JobTitle, "JobTytle textBox");
	
}

@When("User Enter {string} as Department in Registration Page")
public void user_Enter_as_Department_in_Registration_Page(String Department) throws Exception {
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_registerUserDepartment, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_registerUserDepartment, "Department textBox");
	TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_registerUserDepartment, Department, "Department textBox");
	
}

@When("User Enter {string} as LineManager Name in Registration Page")
public void user_Enter_as_LineManager_Name_in_Registration_Page(String LineManegerName) throws Exception {
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_registerUserLineManegerName, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_registerUserLineManegerName, "lineManeger Name textBox");
	TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_registerUserLineManegerName, LineManegerName, "lineManeger Name textBox");
}

@When("User Enter {string} as LineManager ContactNumber in Registration Page")
public void user_Enter_as_LineManager_ContactNumber_in_Registration_Page(String ContactNumber) throws Exception {
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_registerUserLineManegerContact, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_registerUserLineManegerContact, "lineManeger contact textbox");
	TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_registerUserLineManegerContact, ContactNumber, "lineManeger contact textbox");}

@When("User Click on next button")
public void user_Click_on_next_button() throws Exception {
    
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_registerUserpageNextbutton, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_registerUserpageNextbutton, "Next button");

}

@When("User Select {string} as CashCentres in Registration Page")
public void user_Select_as_CashCentres_in_Registration_Page(String CashCenter) throws Exception {
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_registerUserpageCashcenterdropdown, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_registerUserpageCashcenterdropdown, "Cashcenter dropdown");
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoptions(CashCenter), 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoptions(CashCenter), CashCenter+" to select "+CashCenter+"from Cashcenter dropdown");

	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_registerValue, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_registerValue, "Register value");
    
}

@When("User Click on Request Access button")
public void user_Click_on_Request_Access_button() throws Exception {
   
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_registerUserpageRequestAccessbutton, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_registerUserpageRequestAccessbutton, "Request Access button");
}

@Then("Verify the User Successfully Registered for SBV Connect")
public void verify_the_User_Successfully_Registered_for_SBV_Connect() throws Exception {
	
	Thread.sleep(3000);
	    if(TestBase.isElementVisible(SBV_Connect_PageObjects.SBV_UserRegisterSuccess, "User Registered Successfully")) {
	    	System.out.println("User is successfully register");
	    }else {
	    	System.out.println("User is not successfully register");
	    }
	
}


@Then("User Log in Connect System By Entering ConnectAdminUsername as {string} and ConnectAdminpassword as {string}")
public void user_Log_in_Connect_System_By_Entering_ConnectAdminUsername_as_and_ConnectAdminpassword_as(String UserName, String Password) throws Exception {
    
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_Login_pageObject.SBV_Login_Email_Input, 50);
	TestBase.typeinTextBox(SBV_Connect_Login_pageObject.SBV_Login_Email_Input, UserName, "Entered User Name");
	TestBase.waitForElement(SBV_Connect_Login_pageObject.SBV_Login_Password_Input, 50);
	TestBase.typeinTextBox(SBV_Connect_Login_pageObject.SBV_Login_Password_Input, Password, "Entered Password");
	TestBase.waitForElement(SBV_Connect_Login_pageObject.SBV_Login_Button, 50);
	TestBase.clickonElement(SBV_Connect_Login_pageObject.SBV_Login_Button, "Clicked on Login Button");
	
}

@Then("User click on Manage User Access Button")
public void user_click_on_Manage_User_Access_Button() throws Exception {
   
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_ManageUserAccessbutton, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_ManageUserAccessbutton, "User Access button");
	
}

@Then("AdminUser click on latest Registered User")
public void adminuser_click_on_latest_Registered_User() throws Exception {
	
	Thread.sleep(4000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_latestregisteruser, 60);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_latestregisteruser, "User Access button");
}
@Then("AdminUser click on latest selected Registered User")
public void adminuser_click_on_latest_selected_Registered_User() throws Exception {
	Thread.sleep(5000);
	if(TestBase.isElementVisible(SBV_Connect_PageObjects.SBV_latestregisteruserselect, "latestregisteruser")) {
	     Thread.sleep(8000);
	     TestBase.waitForElement(SBV_Connect_PageObjects.SBV_latestregisteruserselect, 70);
         TestBase.doubleClick(SBV_Connect_PageObjects.SBV_latestregisteruserselect, "latestregisteruser");
	}else {
		Thread.sleep(5000);
		TestBase.waitForElement(SBV_Connect_PageObjects.SBV_latestregisteruser, 70);
        TestBase.doubleClick(SBV_Connect_PageObjects.SBV_latestregisteruser, "latestregisteruser");

	}
}

@Then("AdminUser Verify the status of Registered User as {string}")
public void adminuser_Verify_the_status_of_Registered_User_as(String status) throws Exception {
    
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_latestregisteuserstatus, 60);
    String actauStatus = TestBase.getElementText(SBV_Connect_PageObjects.SBV_latestregisteuserstatus, "status column");
	System.out.println(actauStatus);
	Assert.assertEquals(status, actauStatus);
	String lastupdateTime = TestBase.getElementText(SBV_Connect_PageObjects.SBV_lastupdateTime, "last update tme");
    System.out.println("last updated time=" +lastupdateTime);
}

@Then("AdminUser select {string} as Customer in User approval page")
public void adminuser_select_as_Customer_in_User_approval_page(String Customer) throws Exception {
	
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_ApprovalCuctomer, 60);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_ApprovalCuctomer, "Customer dropdown");
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoptions(Customer), 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoptions(Customer), Customer+" to select "+Customer+"Customer dropdown");
	
}

@Then("AdminUser select {string} as Site Type in User approval page")
public void adminuser_select_as_Site_Type_in_User_approval_page(String siteType) throws Exception {
	
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_ApprovalSiteType, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_ApprovalSiteType, "siteType dropdown");
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoptions(siteType), 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoptions(siteType), siteType+" to select "+siteType+"siteType dropdown");
	
}
@Then("AdminUser select {string} as Site Type in User approval Page")
public void adminuser_select_as_Site_Type_in_User_approval_Page(String siteType) throws Exception {
	
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_ApprovalSiteTypeBankuser, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_ApprovalSiteTypeBankuser, "siteType dropdown");
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoptions(siteType), 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoptions(siteType), siteType+" to select "+siteType+"siteType dropdown");
	
}

@Then("AdminUser select {string} as Cash Center in User approval page")
public void adminuser_select_as_Cash_Center_in_User_approval_page(String CashCenter) throws Exception {
   
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_ApprovalCashCenter, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_ApprovalCashCenter, "CashCenter dropdown");
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoptions(CashCenter), 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoptions(CashCenter), CashCenter+" to select "+CashCenter+"CashCenter dropdown");
}
@Then("AdminUser select {string} as Cash Center in User approval Page")
public void adminuser_select_as_Cash_Center_in_User_approval_Page(String CashCenter) throws Exception {
   
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_ApprovalCashCenterBankuser, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_ApprovalCashCenterBankuser, "CashCenter dropdown");
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoptions(CashCenter), 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoptions(CashCenter), CashCenter+" to select "+CashCenter+"CashCenter dropdown");
}

@Then("AdminUser Enter {string} as Comments in User approval page")
public void adminuser_Enter_as_Comments_in_User_approval_page(String Comment) throws Exception {
   
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_ApprovalCommenttextbox, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_ApprovalCommenttextbox, "Comment textBox");
	TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_ApprovalCommenttextbox, Comment, "Comment textBox");
}

@Then("AdminUser Click on Approve button")
public void adminuser_Click_on_Approve_button() throws Exception {
   
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_ApprovalApprovebutton, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_ApprovalApprovebutton, "Approve button");
}

@Then("AdminUser Click on Add Button in User approval page")
public void adminuser_Click_on_Add_Button_in_User_approval_page() throws Exception {
    
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_ApprovalApproveAddbutton, 70);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_ApprovalApproveAddbutton, "Approve Addbutton");
	
}

@Then("AdminUser Select the Sites in User approval page")
public void adminuser_Select_the_Sites_in_User_approval_page() throws Exception {
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_ApprovalAddfirstsite, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_ApprovalAddfirstsite, "first Add site");
	
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_ApprovalAddsecondsite, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_ApprovalAddsecondsite, "second add site");
	
}

@Then("AdminUser Click on Add Selected site button in User approval page")
public void adminuser_Click_on_Add_Selected_site_button_in_User_approval_page() throws Exception {
   
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_ApprovalAddselectedsitebutton, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_ApprovalAddselectedsitebutton, "Add selected site");
	
}
@Given("Update the status as {string}")
public void update_the_status_as(String Status) throws Exception {
	
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Status, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Status, "Status dropdown");
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(Status), 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(Status), Status+" to select "+Status+"Status dropdown");
	
    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Add_Notes, 50);
	TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_Add_Notes, "Status is updated", "Enter Notes");
   
	Thread.sleep(6000);
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Update, 500);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Update, "Update button"); 
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

@Given("User Enters Contact Number in Registration Page by using Excelsheetdata {string} and row number \"{int}\"")
public void user_Enters_Contact_Number_in_Registration_Page_by_using_Excelsheetdata_and_row_number(String UserRegisterationData, Integer int1) throws Exception {
    
	Thread.sleep(5000);
	Excel_Utility.setExcelFile(filepath, UserRegisterationData);
    String ContactNumber = Excel_Utility.getCellData(int1, 3);
    
	Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_RegisterContactNo, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_RegisterContactNo, "Contact Number textBox");
	TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_RegisterContactNo, ContactNumber, "Contact Number textBox");
}

@Given("User Select UserType in Registration Page by using Excelsheetdata {string} and row number \"{int}\"")
public void user_Select_UserType_in_Registration_Page_by_using_Excelsheetdata_and_row_number(String UserRegisterationData, Integer int1) throws Exception {
    
	Thread.sleep(5000);
	Excel_Utility.setExcelFile(filepath, UserRegisterationData);
    String UserType = Excel_Utility.getCellData(int1, 4);
    
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_registerUserTypeDropdown, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_registerUserTypeDropdown, "User Type dropdown");
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoptions(UserType), 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoptions(UserType), UserType+" to select "+UserType+"from User Type dropdown");
}

@Given("User Select Role in Registration Page by using Excelsheetdata {string} and row number \"{int}\"")
public void user_Select_Role_in_Registration_Page_by_using_Excelsheetdata_and_row_number(String UserRegisterationData, Integer int1) throws Exception {
    
	Thread.sleep(5000);
	Excel_Utility.setExcelFile(filepath, UserRegisterationData);
    String Role = Excel_Utility.getCellData(int1, 5);
    
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_registerUserRoledropdown, 70);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_registerUserRoledropdown, "User Type dropdown");
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoptions(Role), 40);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoptions(Role), Role+" to select "+Role+"from Role dropdown");
}

@Given("User Enter Organisation in Registration Page by using Excelsheetdata {string} and row number \"{int}\"")
public void user_Enter_Organisation_in_Registration_Page_by_using_Excelsheetdata_and_row_number(String UserRegisterationData, Integer int1) throws Exception {

	Thread.sleep(5000);
	Excel_Utility.setExcelFile(filepath, UserRegisterationData);
    String OrganisationName = Excel_Utility.getCellData(int1, 6);

	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_registerUserOrganisation, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_registerUserOrganisation, "Name textBox");
	TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_registerUserOrganisation, OrganisationName, "OrganisationName textBox");
	
}

@Given("User Enter JobTitle in Registration Page by using Excelsheetdata {string} and row number \"{int}\"")
public void user_Enter_JobTitle_in_Registration_Page_by_using_Excelsheetdata_and_row_number(String UserRegisterationData, Integer int1) throws Exception {

	Thread.sleep(5000);
	Excel_Utility.setExcelFile(filepath, UserRegisterationData);
    String JobTitle = Excel_Utility.getCellData(int1, 7);
	
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_registerUserJobTitle, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_registerUserJobTitle, "Name textBox");
	TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_registerUserJobTitle, JobTitle, "JobTytle textBox");

}

@Given("User Enter Department in Registration Page by using Excelsheetdata {string} and row number \"{int}\"")
public void user_Enter_Department_in_Registration_Page_by_using_Excelsheetdata_and_row_number(String UserRegisterationData, Integer int1) throws Exception {
	
	Thread.sleep(5000);
	Excel_Utility.setExcelFile(filepath, UserRegisterationData);
    String Department = Excel_Utility.getCellData(int1, 8);

	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_registerUserDepartment, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_registerUserDepartment, "Department textBox");
	TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_registerUserDepartment, Department, "Department textBox");}

@Given("User Enter LineManager Name in Registration Page by using Excelsheetdata {string} and row number \"{int}\"")
public void user_Enter_LineManager_Name_in_Registration_Page_by_using_Excelsheetdata_and_row_number(String UserRegisterationData, Integer int1) throws Exception {
    
	Thread.sleep(5000);
	Excel_Utility.setExcelFile(filepath, UserRegisterationData);
    String LineManegerName = Excel_Utility.getCellData(int1, 9);

	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_registerUserLineManegerName, 40);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_registerUserLineManegerName, "lineManeger Name textBox");
	TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_registerUserLineManegerName, LineManegerName, "lineManeger Name textBox");
	
}

@Given("User Enter LineManager ContactNumber in Registration Page by using Excelsheetdata {string} and row number \"{int}\"")
public void user_Enter_LineManager_ContactNumber_in_Registration_Page_by_using_Excelsheetdata_and_row_number(String UserRegisterationData, Integer int1) throws Exception {
	
	Thread.sleep(5000);
	Excel_Utility.setExcelFile(filepath, UserRegisterationData);
    String LineManegerContactNumber = Excel_Utility.getCellData(int1, 50);
    
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_registerUserLineManegerContact, 40);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_registerUserLineManegerContact, "lineManeger contact textbox");
	TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_registerUserLineManegerContact, LineManegerContactNumber, "lineManeger contact textbox");
}

@Given("User Select CashCentres in Registration Page by using Excelsheetdata {string} and row number \"{int}\"")
public void user_Select_CashCentres_in_Registration_Page_by_using_Excelsheetdata_and_row_number(String UserRegisterationData, Integer int1) throws Exception {
    
	Thread.sleep(5000);
	Excel_Utility.setExcelFile(filepath, UserRegisterationData);
    String CashCenter = Excel_Utility.getCellData(int1, 11);
    
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_registerUserpageCashcenterdropdown, 40);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_registerUserpageCashcenterdropdown, "Cashcenter dropdown");
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoptions(CashCenter), 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoptions(CashCenter), CashCenter+" to select "+CashCenter+"from Cashcenter dropdown");

	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_registerValue, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_registerValue, "Register value");

	
}

@Then("AdminUser select Site Type in User approval page by using Excelsheetdata {string} and row number \"{int}\"")
public void adminuser_select_Site_Type_in_User_approval_page_by_using_Excelsheetdata_and_row_number(String UserRegisterationData, Integer int1) throws Exception {

	Thread.sleep(5000);
	Excel_Utility.setExcelFile(filepath, UserRegisterationData);
    String siteType = Excel_Utility.getCellData(int1, 12);
    
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_ApprovalSiteType, 40);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_ApprovalSiteType, "siteType dropdown");
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoptions(siteType), 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoptions(siteType), siteType+" to select "+siteType+"siteType dropdown");
	
}
@Then("AdminUser select Site Type in User approval Page by using Excelsheetdata {string} and row number \"{int}\"")
public void adminuser_select_Site_Type_in_User_approval_Page_by_using_Excelsheetdata_and_row_number(String UserRegisterationData, Integer int1) throws Exception {

	Thread.sleep(5000);
	Excel_Utility.setExcelFile(filepath, UserRegisterationData);
    String siteType = Excel_Utility.getCellData(int1, 12);
    
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_ApprovalSiteTypeBankuser, 40);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_ApprovalSiteTypeBankuser, "siteType dropdown");
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoptions(siteType), 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoptions(siteType), siteType+" to select "+siteType+"siteType dropdown");
	
}

@Then("AdminUser select Cash Center in User approval page by using Excelsheetdata {string} and row number \"{int}\"")
public void adminuser_select_Cash_Center_in_User_approval_page_by_using_Excelsheetdata_and_row_number(String UserRegisterationData, Integer int1) throws Exception {

	Thread.sleep(5000);
	Excel_Utility.setExcelFile(filepath, UserRegisterationData);
    String CashCenter = Excel_Utility.getCellData(int1, 13);
    
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_ApprovalCashCenter, 40);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_ApprovalCashCenter, "CashCenter dropdown");
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoptions(CashCenter), 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoptions(CashCenter), CashCenter+" to select "+CashCenter+"CashCenter dropdown");

}
@Then("AdminUser select Cash Center in User approval Page by using Excelsheetdata {string} and row number \"{int}\"")
public void adminuser_select_Cash_Center_in_User_approval_Page_by_using_Excelsheetdata_and_row_number(String UserRegisterationData, Integer int1) throws Exception {

	Thread.sleep(5000);
	Excel_Utility.setExcelFile(filepath, UserRegisterationData);
    String CashCenter = Excel_Utility.getCellData(int1, 13);
    
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_ApprovalCashCenterBankuser, 40);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_ApprovalCashCenterBankuser, "CashCenter dropdown");
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoptions(CashCenter), 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoptions(CashCenter), CashCenter+" to select "+CashCenter+"CashCenter dropdown");

}

@Then("AdminUser Enter Comments in User approval page by using Excelsheetdata {string} and row number \"{int}\"")
public void adminuser_Enter_Comments_in_User_approval_page_by_using_Excelsheetdata_and_row_number(String UserRegisterationData, Integer int1) throws Exception {

	Thread.sleep(5000);
	Excel_Utility.setExcelFile(filepath, UserRegisterationData);
    String Comment = Excel_Utility.getCellData(int1, 14);
	
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_ApprovalCommenttextbox, 40);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_ApprovalCommenttextbox, "Comment textBox");
	TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_ApprovalCommenttextbox, Comment, "Comment textBox");

}
@Given("AdminUser select Customer in User approval page by using Excelsheetdata {string} and row number \"{int}\"")
public void adminuser_select_Customer_in_User_approval_page_by_using_Excelsheetdata_and_row_number(String UserRegisterationData, Integer int1) throws Exception {
	Thread.sleep(5000);
	Excel_Utility.setExcelFile(filepath, UserRegisterationData);
    String Customer = Excel_Utility.getCellData(int1, 15);
    
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_ApprovalCuctomer, 40);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_ApprovalCuctomer, "Customer dropdown");
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoptions(Customer), 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoptions(Customer), Customer+" to select "+Customer+"Customer dropdown");
}

@Given("External User Navigates to TaskList,Search with Latest Case id,Click on FeedBackRequired")
public void external_User_Navigates_to_TaskList_Search_with_Latest_Case_id_Click_on_FeedBackRequired() throws Exception {
	
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_view_task_list, 40);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_view_task_list, "View task list");
	TestBase.driver.navigate().refresh();
	
	Thread.sleep(5000);
	TestBase.driver.switchTo().frame("myFrame");
	TestBase.driver.switchTo().frame("bonitaframe");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, 40);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, "new case button");
	Thread.sleep(4000);
	System.out.println(NewCase);
	TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_SearchByinput, NewCase, "Enter");

  for(int i=0;i<13;i++) {

	  TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.LEFT));
      }

  TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.BACK_SPACE));
  
  Thread.sleep(5000);
  TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_FeedbackRequired, 40);
  TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_FeedbackRequired, "FeedBack required link");

}

@Given("External User update the feedback of the Case")
public void external_User_update_the_feedback_of_the_Case() throws Exception {

	   Thread.sleep(5000);
	   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Add_Notes, 40);
	   TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_Add_Notes, "FeedBack is Given by External user", "Enter Notes");
	   
	   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Update, 40);
	   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Update, "Update button"); 
}

@Given("External User Navigates to TaskList,Search with Latest Case id,Click on Complete Survey")
public void external_User_Navigates_to_TaskList_Search_with_Latest_Case_id_Click_on_Complete_Survey() throws Exception {
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_view_task_list, 40);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_view_task_list, "View task list");
    TestBase.driver.navigate().refresh();
    
    Thread.sleep(25000);
    TestBase.driver.switchTo().frame("myFrame");
    TestBase.driver.switchTo().frame("bonitaframe");
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, 40);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, "new case button");
    Thread.sleep(4000);
    System.out.println(NewCase);
    TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_SearchByinput, NewCase, "Enter");

  for(int i=0;i<13;i++) {

      TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.LEFT));
      }
  TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.BACK_SPACE));
  Thread.sleep(5000);
  TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_CompleteSurvey, 40);
  TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_CompleteSurvey, "Complete Survey link");
}

@Given("User Select {string} as the Satisfication Review")
public void user_Select_as_the_Satisfication_Review(String Status) throws Exception {
    
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_SatisfyReviewDropdown, 40);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_SatisfyReviewDropdown, "Satisfication Review dropdown");
    Thread.sleep(3000);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(Status), 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(Status), Status+" to select "+Status+"from Satisfication Review dropdown");
}

@Given("User Select {string} as the rate of level of Service and Enter the Comment Submit the Case")
public void user_Select_as_the_rate_of_level_of_Service_and_Enter_the_Comment_Submit_the_Case(String Status) throws Exception {
    
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_RateLevelDropdown, 40);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_RateLevelDropdown, "Rate the Lvel Review dropdown");
    
    Thread.sleep(3000);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(Status), 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(Status), Status+" to select "+Status+"from Rate the Lvel dropdown");
    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_CustomerComment, 40);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_CustomerComment, "Rate the Lvel Review dropdown");
    TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_CustomerComment, "Everything is Fine", "Comment Box");
    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Submit, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Submit, "Rate the Lvel Review dropdown");
}

@When("User Click on Forgot Password in Connect Login Page")
public void user_Click_on_Forgot_Password_in_Connect_Login_Page() throws Exception {
	Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_ForgotPassword, 40);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_ForgotPassword, "Email textBox");
}

@When("User Click on Reset Password")
public void user_Click_on_Reset_Password() throws Exception {
	Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_ForgotPassword_ResetPassword, 40);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_ForgotPassword_ResetPassword, "Email textBox");
}

@When("User Enter Password in Finish Account SetUp Page by using Excelsheetdata {string} and row number \"{int}\"")
public void user_Enter_Password_in_Finish_Account_SetUp_Page_by_using_Excelsheetdata_and_row_number(String ForgotPasswordData, Integer int1) throws Exception {

	Thread.sleep(5000);
	Excel_Utility.setExcelFile(filepath, ForgotPasswordData);
    String Password = Excel_Utility.getCellData(int1, 1);
	
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_ForgotPassword_Password, 40);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_ForgotPassword_Password, "Password textBox");
	TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_ForgotPassword_Password, Password, "Password textBox");
}

@When("User Enter Re-Enter Password in Finish Account SetUp Page by using Excelsheetdata {string} and row number \"{int}\"")
public void user_Enter_Re_Enter_Password_in_Finish_Account_SetUp_Page_by_using_Excelsheetdata_and_row_number(String ForgotPasswordData, Integer int1) throws Exception {

	Thread.sleep(5000);
	Excel_Utility.setExcelFile(filepath, ForgotPasswordData);
    String Re_Enter_Password = Excel_Utility.getCellData(int1, 2);
	
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_ForgotPassword_Re_Enter_Password, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_ForgotPassword_Re_Enter_Password, "Re_Enter_Password textBox");
	TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_ForgotPassword_Re_Enter_Password, Re_Enter_Password, "Comment textBox");
}

@When("User Click on Set New Password in Finish Account SetUp Page")
public void user_Click_on_Set_New_Password_in_Finish_Account_SetUp_Page() throws Exception {
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_ForgotPassword_set_New_Password, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_ForgotPassword_set_New_Password, "Re_Enter_Password textBox");
}

@Then("Verify the User Successfully Changed Password for SBV Connect")
public void verify_the_User_Successfully_Changed_Password_for_SBV_Connect() throws Exception {
	 Thread.sleep(3000);
	    if(TestBase.isElementVisible(SBV_Connect_PageObjects.SBV_AccountSetCompleted, "Account Detail text")) {
	    	System.out.println("User Successfully landed on the AccountSetCompleted");
	    }else {
	    	System.out.println("User Successfully not landed on the AccountSetCompleted");
	    }
}

@Then("User Click on Return to Login Button")
public void user_Click_on_Return_to_Login_Button() throws Exception {
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Return_to_login, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Return_to_login, "Re_Enter_Password textBox");
}


@Then("Verify the User able to Login to SBV Connect Home Page")
public void verify_the_User_able_to_Login_to_SBV_Connect_Home_Page() throws Exception {
	Thread.sleep(3000);
    if(TestBase.isElementVisible(SBV_Connect_PageObjects.SBV_HomePage, "Account Detail text")) {
    	System.out.println("User Successfully landed on the HomePage");
    }else {
    	System.out.println("User Successfully not landed on the HomePage");
    }
}

@When("User Enter Invalid Password in Finish Account SetUp Page by using Excelsheetdata {string} and row number \"{int}\"")
public void user_Enter_Invalid_Password_in_Finish_Account_SetUp_Page_by_using_Excelsheetdata_and_row_number(String ForgotPasswordData, Integer int1) throws Exception {
	Thread.sleep(5000);
	Excel_Utility.setExcelFile(filepath, ForgotPasswordData);
    String Password = Excel_Utility.getCellData(int1, 5);
	
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_ForgotPassword_Password, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_ForgotPassword_Password, "Password textBox");
	TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_ForgotPassword_Password, Password, "Password textBox");
}

@When("User Verifies the Error Message is Displaying on Finish Account SetUp Page")
public void user_Verifies_the_Error_Message_is_Displaying_on_Finish_Account_SetUp_Page() throws Exception {
	Thread.sleep(3000);
    if(TestBase.isElementVisible(SBV_Connect_PageObjects.SBV_InvalidPassword_error_message, "Account Detail text")) {
    	System.out.println("User Successfully got error message");
    }else {
    	System.out.println("User Successfully not landed on the HomePage");
    }}

@Then("User able to Login into Connect System with SBVBank_Username as as {string} and SBVBank_Password as {string}")
public void user_able_to_Login_into_Connect_System_with_SBVBank_Username_as_as_and_SBVBank_Password_as(String UserName, String Password) throws Exception {
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_Login_pageObject.SBV_Login_Email_Input, 50);
	TestBase.typeinTextBox(SBV_Connect_Login_pageObject.SBV_Login_Email_Input, UserName, "Entered User Name");
	TestBase.waitForElement(SBV_Connect_Login_pageObject.SBV_Login_Password_Input, 50);
	TestBase.typeinTextBox(SBV_Connect_Login_pageObject.SBV_Login_Password_Input, Password, "Entered Password");
	TestBase.waitForElement(SBV_Connect_Login_pageObject.SBV_Login_Button, 50);
	TestBase.clickonElement(SBV_Connect_Login_pageObject.SBV_Login_Button, "Clicked on Login Button");
}

@Then("User able to Login into Connect System with Bank_Username as as {string} and Bank_Password as {string}")
public void user_able_to_Login_into_Connect_System_with_Bank_Username_as_as_and_Bank_Password_as(String UserName, String Password) throws Exception {
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_Login_pageObject.SBV_Login_Email_Input, 50);
	TestBase.typeinTextBox(SBV_Connect_Login_pageObject.SBV_Login_Email_Input, UserName, "Entered User Name");
	TestBase.waitForElement(SBV_Connect_Login_pageObject.SBV_Login_Password_Input, 50);
	TestBase.typeinTextBox(SBV_Connect_Login_pageObject.SBV_Login_Password_Input, Password, "Entered Password");
	TestBase.waitForElement(SBV_Connect_Login_pageObject.SBV_Login_Button, 50);
	TestBase.clickonElement(SBV_Connect_Login_pageObject.SBV_Login_Button, "Clicked on Login Button");
	
}

@Then("User click on Set New Password Button")
public void user_click_on_Set_New_Password_Button() throws Exception {

    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_SetNewpassButton, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_SetNewpassButton, "Set New Password button");
}


@Then("Verify the User Successfully Loged In the Connect System")

public void verify_the_User_Successfully_Loged_In_the_Connect_System() throws Exception {

    Thread.sleep(3000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_VerifyHomePage, 50);
    if(TestBase.isElementVisible(SBV_Connect_PageObjects.SBV_VerifyHomePage, "Home Text on home page")) {
        System.out.println("the User is Successfully loged in the Connect System");
    }else {
        System.out.println("the User is not loged in the Connect System");
    }
}

@Then("User Log in Connect System By Entering BankAdminUsername as {string} and BankAdminpassword as {string}")
public void user_Log_in_Connect_System_By_Entering_BankAdminUsername_as_and_BankAdminpassword_as(String UserName, String Password) throws Exception {

    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_Login_pageObject.SBV_Login_Email_Input, 50);
    TestBase.typeinTextBox(SBV_Connect_Login_pageObject.SBV_Login_Email_Input, UserName, "Entered User Name");
    TestBase.waitForElement(SBV_Connect_Login_pageObject.SBV_Login_Password_Input, 50);
    TestBase.typeinTextBox(SBV_Connect_Login_pageObject.SBV_Login_Password_Input, Password, "Entered Password");
    TestBase.waitForElement(SBV_Connect_Login_pageObject.SBV_Login_Button, 50);
    TestBase.clickonElement(SBV_Connect_Login_pageObject.SBV_Login_Button, "Clicked on Login Button");

}


@Then("BankAdminUser click on latest Registered User")
public void Bankadminuser_click_on_latest_Registered_User() throws Exception {

Thread.sleep(5000);
TestBase.waitForElement(SBV_Connect_PageObjects.SBV_latestregisteruser, 50);
TestBase.clickonElement(SBV_Connect_PageObjects.SBV_latestregisteruser, "User Access button");
}


@Then("BankAdminUser Verify the status of Registered User as {string}")
public void Bankadminuser_Verify_the_status_of_Registered_User_as(String status) throws Exception {

Thread.sleep(5000);
TestBase.waitForElement(SBV_Connect_PageObjects.SBV_latestregisteuserstatus, 50);
String actauStatus = TestBase.getElementText(SBV_Connect_PageObjects.SBV_latestregisteuserstatus, "status column");
System.out.println(actauStatus);
Assert.assertEquals(status, actauStatus);
}


@Then("BankAdminUser Enter Comments in User approval page by using Excelsheetdata {string} and row number \"{int}\"")
public void Bankadminuser_Enter_Comments_in_User_approval_page_by_using_Excelsheetdata_and_row_number(String UserRegisterationData, Integer int1) throws Exception {

Thread.sleep(5000);
Excel_Utility.setExcelFile(filepath, UserRegisterationData);
String Comment = Excel_Utility.getCellData(int1, 14);

Thread.sleep(5000);
TestBase.waitForElement(SBV_Connect_PageObjects.SBV_ApprovalCommenttextbox, 50);
TestBase.clickonElement(SBV_Connect_PageObjects.SBV_ApprovalCommenttextbox, "Comment textBox");
TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_ApprovalCommenttextbox, Comment, "Comment textBox");

}
@Then("BankAdminUser Click on Approve button")
public void Bankadminuser_Click_on_Approve_button() throws Exception {

Thread.sleep(5000);
TestBase.waitForElement(SBV_Connect_PageObjects.SBV_ApprovalApprovebutton, 50);
TestBase.clickonElement(SBV_Connect_PageObjects.SBV_ApprovalApprovebutton, "Approve button");
}
@Then("BankAdminUser click on latest selected Registered User")
public void Bankadminuser_click_on_latest_selected_Registered_User() throws Exception {

if(TestBase.isElementVisible(SBV_Connect_PageObjects.SBV_latestregisteruserselect, "latestregisteruser")) {
     Thread.sleep(8000);
     TestBase.waitForElement(SBV_Connect_PageObjects.SBV_latestregisteruserselect, 50);
     TestBase.doubleClick(SBV_Connect_PageObjects.SBV_latestregisteruserselect, "latestregisteruser");
}else {

    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_latestregisteruser, 50);
    TestBase.doubleClick(SBV_Connect_PageObjects.SBV_latestregisteruser, "latestregisteruser");
    }
}


@Given("Reginal User Navigates to Caselist,Search with Latest Case id and Click on AuditTrail")
public void reginal_User_Navigates_to_Caselist_Search_with_Latest_Case_id_and_Click_on_AuditTrail() throws Throwable {
	TestBase.RefreshPage();
	 Thread.sleep(5000);
	 TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_see_case_list, 50);
	 TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_see_case_list, "case list");
	 Thread.sleep(5000);
	 TestBase.RefreshPage();
	 Thread.sleep(15000);
	 TestBase.driver.switchTo().frame("myFrame");
	 TestBase.driver.switchTo().frame("bonitaframe");
	 TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_SearchByinput_olga, 50);
	 TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_SearchByinput_olga, "Latestcase Number");
	 System.out.println(NewCase);
	 TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_SearchByinput_olga, NewCase, "Enter");
	 Thread.sleep(5000);
	 TestBase.ScrollDownBottom();
	 TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_LatestCaseNumber, 50);
	 TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_LatestCaseNumber, "Latestcase Number");
	 Thread.sleep(5000);
	 TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AuditTrail, 50);
	 TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AuditTrail, "new case button");
	 TestBase.ScrollDownBottom();
	 Thread.sleep(5000);

}

@Given("Reginal User Enters Comment as {string} and Submit Comments")
public void reginal_User_Enters_Comment_as_and_Submit_Comments(String Comment) throws Exception {
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_EnterComment, 50);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_EnterComment, "Comment textBox");
	TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_EnterComment, Comment, "Comment textBox");
Thread.sleep(5000);
TestBase.waitForElement(SBV_Connect_PageObjects.SBV_SubmitComment, 50);
TestBase.clickonElement(SBV_Connect_PageObjects.SBV_SubmitComment, "User Access button");
}

@Given("Reginal User records all Date and Time Stamps in Connect System")
public void reginal_User_records_all_Date_and_Time_Stamps_in_Connect_System() throws Exception {
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Date_And_TimeStamp1, 50);
	String actauStatus = TestBase.getElementText(SBV_Connect_PageObjects.SBV_Date_And_TimeStamp1, "status column");
	System.out.println(actauStatus);
	
}


@When("Reginal User Navigates to TaskList,Search with Latest Case id")
public void reginal_User_Navigates_to_TaskList_Search_with_Latest_Case_id() throws Exception {
	Thread.sleep(6000);
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Task_list, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Task_list, "View task list");
	Thread.sleep(6000);
	TestBase.RefreshPage();
	Thread.sleep(25000);
	TestBase.driver.switchTo().frame("myFrame");
	TestBase.driver.switchTo().frame("bonitaframe");

	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, "new case button");
	Thread.sleep(5000);
	System.out.println("letestcaseno"+ NewCase);
	TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_SearchByinput, NewCase, "Enter");

  for(int i=0;i<13;i++) {

	  TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.LEFT));
      }

  TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.BACK_SPACE));
 
}

@When("Reginal User Click on RTL Review")
public void reginal_User_Click_on_RTL_Review() throws Exception {
	  Thread.sleep(5000);
	  TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_RTL_Review, 60);
	  TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_RTL_Review, "new case button");
}

@When("Reginal User Click on Update Button")
public void reginal_User_Click_on_Update_Button() throws Exception {
	 Thread.sleep(5000);
	   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Add_Notes, 50);
	   TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_Add_Notes, "FeedBack is Given by External user", "Enter Notes");
	   
	   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Update, 50);
	   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Update, "Update button"); 
}

@Given("AdminUser Cleck on Reject Button")
public void adminuser_Cleck_on_Reject_Button() throws Exception {
	
     TestBase.waitForElement(SBV_Connect_PageObjects.SBV_RejectButton, 50);
     TestBase.clickonElement(SBV_Connect_PageObjects.SBV_RejectButton, "Reject Button");

}

@Given("AdminUser Verify the Serch Result")
public void adminuser_Verify_the_Serch_Result() throws Exception {

    Thread.sleep(3000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_NoDatafound, 50);

    if(TestBase.isElementVisible(SBV_Connect_PageObjects.SBV_NoDatafound, "No Data Found row")) {
        System.out.println("The Register User Approval Pending Request is Rejected Before Approval so data is not Available");
    }

}

@Then("AdminUser Enters the Comment")
public void adminuser_Enters_the_Comment() throws Exception {

    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_ApprovalCommenttextbox, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_ApprovalCommenttextbox, "Comment textBox");
    TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_ApprovalCommenttextbox, "The User is Deactivated", "comment box");
}

@Then("AdminUser Click on Deactivate User Button")
public void AdminUser_click_on_Deactivate_User_Button() throws Exception {

    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_DeactivateButton, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_DeactivateButton, "Deactivate button");
}

@Then("AdminUser View the Existing User")
public void adminuser_View_the_Existing_User() throws Exception {

    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_ExistingUser, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_ExistingUser, "ExistingUser button");
    Thread.sleep(7000);
 
}
@Then("AdminUser View the Awaiting Approval user")
public void adminuser_View_the_Awaiting_Approval_user() throws Exception {

    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_AwaitingApproval, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_AwaitingApproval, "Awaiting Approval button");
    Thread.sleep(7000);

}
@Then("User Navigates to Dashboard and click on Log a New case in Connect System")
public void User_Navigates_to_Dashboard_and_click_on_Log_a_New_case_in_Connect_System() throws Exception {

    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Dashboard, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Dashboard, "dashboard");
    Thread.sleep(25000);
    TestBase.driver.switchTo().frame("myFrame");
    TestBase.driver.switchTo().frame("bonitaframe");
    Thread.sleep(3000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_New_Case, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_New_Case, "Log a new Case");
}

//////////////////////////////////////////////////Bank Views/////////////////////////////////////////


@Then("Branch Manager User Navigates to Caselist and Verify the Logged Case")
public void Bank_user_Navigates_to_Caselist_and_Verify_the_Logged_Case() throws Exception {


    Thread.sleep(6000);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_LatestCaseNumber, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_LatestCaseNumber, "Latestcase Number");

    Thread.sleep(5000);
    if(!(TestBase.waitForElementToBevisible(SBV_Connect_CommonPageObject.SBV_GetCaseid,500))) {

        TestBase.driver.navigate().refresh();
        BranchManagerCase1 = TestBase.getElementText(SBV_Connect_CommonPageObject.SBV_GetCaseid," Firstrow");

      }
    else if(TestBase.waitForElementToBevisible(SBV_Connect_CommonPageObject.SBV_GetCaseid,500) ){

          Thread.sleep(5000);
          BranchManagerCase1 = TestBase.getElementText(SBV_Connect_CommonPageObject.SBV_GetCaseid," Firstrow");    

      }else {

          ExceptionHandling.HandleAssertion("unable to copy Firstrow");
      }

    System.out.println(BranchManagerCase1);
}
@Then("Regional Manager User Navigates to Caselist and Verify the Logged Case")
public void Regional_Manager_user_Navigates_to_Caselist_and_Verify_the_Logged_Case() throws Exception {
    Thread.sleep(3000);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_LatestCaseNumber, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_LatestCaseNumber, "Latestcase Number");

    Thread.sleep(5000);
    if(!(TestBase.waitForElementToBevisible(SBV_Connect_CommonPageObject.SBV_GetCaseid,500))) {

        TestBase.driver.navigate().refresh();
        RegionalManagerCase1 = TestBase.getElementText(SBV_Connect_CommonPageObject.SBV_GetCaseid," Firstrow");
      }
    else if(TestBase.waitForElementToBevisible(SBV_Connect_CommonPageObject.SBV_GetCaseid,500) ){

          Thread.sleep(5000);
          RegionalManagerCase1 = TestBase.getElementText(SBV_Connect_CommonPageObject.SBV_GetCaseid," Firstrow");    

      }else {

          ExceptionHandling.HandleAssertion("unable to copy Firstrow");
      }

    System.out.println(RegionalManagerCase1);
    Assert.assertEquals(BranchManagerCase1, RegionalManagerCase1);
}
@Then("National Manager User Navigates to Caselist and Verify the Logged Case")
public void National_Manager_user_Navigates_to_Caselist_and_Verify_the_Logged_Case() throws Exception {
    Thread.sleep(3000);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_LatestCaseNumber, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_LatestCaseNumber, "Latestcase Number");

    Thread.sleep(5000);
    if(!(TestBase.waitForElementToBevisible(SBV_Connect_CommonPageObject.SBV_GetCaseid,500))) {
        TestBase.driver.navigate().refresh();
        NationalManagerCase1 = TestBase.getElementText(SBV_Connect_CommonPageObject.SBV_GetCaseid," Firstrow");

      }
    else if(TestBase.waitForElementToBevisible(SBV_Connect_CommonPageObject.SBV_GetCaseid,500) ){

          Thread.sleep(5000);
          NationalManagerCase1 = TestBase.getElementText(SBV_Connect_CommonPageObject.SBV_GetCaseid," Firstrow");    

      }else {

          ExceptionHandling.HandleAssertion("unable to copy Firstrow");
      }

    System.out.println(NationalManagerCase1);
    Assert.assertEquals(BranchManagerCase1, NationalManagerCase1);
}
@Then("Branch Maneger User Log a New Case by using town,Case_type,Case_Subtype By using SheetName {string} and row number \"{int}\" in Connect System")
public void Branch_Manager_User_Log_a_New_Case_by_using_town_Case_type_Case_Subtype_By_using_SheetName_and_row_number_in_Connect_System(String string, Integer int1) throws Throwable {
	 Thread.sleep(5000);
	 TestBase.RefreshPage();
    Thread.sleep(25000);
    TestBase.driver.switchTo().frame("myFrame");
    TestBase.driver.switchTo().frame("bonitaframe");
    TestBase.driver.switchTo().frame(TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_inner_frame));

    Thread.sleep(4000);
    Excel_Utility.setExcelFile(filepath, sheetName);
    String town = Excel_Utility.getCellData(int1, 8);
    String Case_type= Excel_Utility.getCellData(int1, 35);
    String CaseSubType = Excel_Utility.getCellData(int1, 36);
    Thread.sleep(4000);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_query_menu, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_query_menu, "CaseTypedropdown");
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(Case_type), 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(Case_type), Case_type+" to select "+Case_type+"from case type dropdown");

    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_query_menu, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_query_menu, "CaseSubTypedropdown");
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(CaseSubType), 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(CaseSubType), CaseSubType+" to select "+CaseSubType+"from case Sub type dropdown");

    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_click_next_button, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_next_button, "Next button");
    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_type_search_key, 50);
    TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_type_search_key, "Johannesburg", "enter data");
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_search_button, "search button");
    Thread.sleep(6000);

    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_type_search_key, 50);
    TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_type_search_key, town, "enter data");
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_search_button, "search button");

    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_type_search_key, 50);
    TestBase.getElements(SBV_Connect_CommonPageObject.SBV_Select_Cash_Center);
    TestBase.ClickViaMouse(SBV_Connect_CommonPageObject.SBV_Select_Cash_Center, "cash canter");

    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_CIT_Number, 50);
    if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_CIT_Number, "CIT Number"))) {


        ExceptionHandling.HandleAssertion("CIT_Number is not diaplayed");
    }

    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Region, 50);
    if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Region, "Region"))) {

        ExceptionHandling.HandleAssertion("Region is not diaplayed");
    }
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Cash_Center, 50);

    if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Cash_Center,  "Cash_Center"))) {

        ExceptionHandling.HandleAssertion("Cash_Center is not diaplayed");
    }

    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_click_next_button, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_next_button, "Next button");
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Select_Date, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Select_Date, "Select Date");
    Thread.sleep(5000);
     Excel_Utility.setExcelFile(filepath, sheetName);
       String StopLoss_Number = Excel_Utility.getCellData_Integer(int1,32);
       String BagSeal_Number= Excel_Utility.getCellData_Integer(int1, 33);
       String Container_Number = Excel_Utility.getCellData_Integer(int1, 34);
       Thread.sleep(5000);  
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Stoploss, 50);
    TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_Stoploss, StopLoss_Number, "Qusetionthree");
    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_BagSeal, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_BagSeal, "new case button");
    TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_BagSeal, BagSeal_Number, "Qusetionthree");
    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Container, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Container, "new case button");
    TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_Container, Container_Number, "Qusetionthree");
    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_click_next_button, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_next_button, "Next button");
}
 
@Given("User Navigates to Caselist and click on Select filter")
public void User_Navigates_to_Caselist_and_click_on_Apply_filter() throws Exception {

    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_see_case_list, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_see_case_list, "case list");
    Thread.sleep(5000);
    TestBase.RefreshPage();
    Thread.sleep(15000);
    TestBase.driver.switchTo().frame("myFrame");
    TestBase.driver.switchTo().frame("bonitaframe");

    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Selectfilters, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Selectfilters, "Select filters");

    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_MyWorkCheckbox, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_MyWorkCheckbox, "My Work CheckBox");

}

@Given("User Verify he is able to access the respective Region by searching with {string}")
public void User_Verify_he_is_able_to_access_the_respective_Region_by_searching_with(String RegionValue) throws Exception {

    Thread.sleep(3000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Search_field, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Search_field, "searchfield");
    TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_Search_field, RegionValue, "Seachfield");

    if(!TestBase.isElementVisible(SBV_Connect_PageObjects.SBV_searchResultatfilter, "Result")) {

        System.out.println("This User dont Have Access to see the other region Cases");
    }

    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Apply_Filters, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Apply_Filters, "Filterbutton");
}
@Given("User Verify he is able to access the respective Branch by searching with {string}")
public void User_Verify_he_is_able_to_access_the_respective_Branch_by_searching_with(String RegionValue) throws Exception {


    Thread.sleep(3000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Search_field, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Search_field, "searchfield");
    TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_Search_field, RegionValue, "Seachfield");

    if(!TestBase.isElementVisible(SBV_Connect_PageObjects.SBV_searchResultatfilter, "Result")) {

        System.out.println("This User dont Have Access to see the other region Cases");
    }

    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Apply_Filters, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Apply_Filters, "Filterbutton");
}
@Given("User Verify that he have Access of All CashCenter By serching with CashCenter {string}")
public void user_Verify_that_he_have_Access_of_All_CashCenter_By_serching_with_CashCenter(String CashcenterValue) throws Exception {

        Thread.sleep(3000);
        TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Search_field, 50);
        TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Search_field, "searchfield");
        TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_Search_field, CashcenterValue, "Seachfield");

         Excel_Utility.setExcelFile(filepath, BankDetasheet);
         String Cashcenter1 = Excel_Utility.getCellData(1, 18);
         String Cashcenter2 = Excel_Utility.getCellData(2, 18);
         String Cashcenter3 = Excel_Utility.getCellData(3, 18);
         String Cashcenter4 = Excel_Utility.getCellData(4, 18);
         String Cashcenter5 = Excel_Utility.getCellData(5, 18);
         String Cashcenter6 = Excel_Utility.getCellData(6, 18);
         String Cashcenter7 = Excel_Utility.getCellData(7, 18);
         String Cashcenter8 = Excel_Utility.getCellData(8, 18);

         TestBase.clearTextbox(SBV_Connect_PageObjects.SBV_Search_field, "SearchField");
         TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_Search_field, Cashcenter2, "Seachfield");
         Thread.sleep(5000);

         TestBase.clearTextbox(SBV_Connect_PageObjects.SBV_Search_field, "SearchField");
         TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_Search_field, Cashcenter3, "Seachfield");
         Thread.sleep(5000);

         TestBase.clearTextbox(SBV_Connect_PageObjects.SBV_Search_field, "SearchField");
         TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_Search_field, Cashcenter4, "Seachfield");
         Thread.sleep(5000);

        if(!TestBase.isElementVisible(SBV_Connect_PageObjects.SBV_searchResultatfilter, "Result")) {

            System.out.println("This User dont Have Access to see the other Cashcenter Cases");
        }

        Thread.sleep(5000);
        TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Apply_Filters, 50);
        TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Apply_Filters, "Filterbutton");
}
 
@Then("User add a file and Complete Updating Process")
public void User_add_a_file_and_Complete_Updating_Process() throws Exception {

    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AddFile, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AddFile, "AddFile button");
    Thread.sleep(3000);
    String PdfFile = "TestData/UploadFiles/dummy.pdf";
    TestBase.FileUpload(SBV_Connect_CommonPageObject.SBV_Uploadfile1, PdfFile);
    
    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Add_Notes, 50);
    TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_Add_Notes, "Testing", "Enter Notes");

    Thread.sleep(25000);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Submit_Button, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Submit_Button, "Submit button");

    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Logcase_Successful_Message, 50);
    if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Logcase_Successful_Message, "Succussufuly Log"))) {

        ExceptionHandling.HandleAssertion("Succesful Message is not diaplayed");
    }
}

@Given("Reginal User Navigates to CaseList,Search with Latest Case id")
public void reginal_User_Navigates_to_CaseList_Search_with_Latest_Case_id() throws Throwable {
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_see_case_list, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_see_case_list, "case list");
	 Thread.sleep(5000);
	  TestBase.RefreshPage();
	Thread.sleep(25000);
	TestBase.driver.switchTo().frame("myFrame");
	TestBase.driver.switchTo().frame("bonitaframe");
	
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, "SearchByfield");
	TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_SearchByinput, NewCase, "Enter");
    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_LatestCaseNumber, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_LatestCaseNumber, "Latestcase Number");

    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AuditTrail, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AuditTrail, "new case button");
    TestBase.ScrollDownBottom();
}


@Given("Reginal User Navigates to Caselist,Search with Latest Case id and Verify whether it is assigned to National Customer Liasion User by using Excelsheetdata {string} and row number {string}")
public void reginal_User_Navigates_to_Caselist_Search_with_Latest_Case_id_and_Verify_whether_it_is_assigned_to_National_Customer_Liasion_User_by_using_Excelsheetdata_and_row_number(String string, String string2) throws Throwable {
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_see_case_list, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_see_case_list, "case list");
	 Thread.sleep(5000);
	    TestBase.RefreshPage();
	Thread.sleep(25000);
	TestBase.driver.switchTo().frame("myFrame");
	TestBase.driver.switchTo().frame("bonitaframe");
	
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, "SearchByfield");
	TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_SearchByinput, NewCase, "Enter");
    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_LatestCaseNumber, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_LatestCaseNumber, "Latestcase Number");

    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AuditTrail, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AuditTrail, "new case button");
    TestBase.ScrollDownBottom();
    
    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Admin, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Admin, "new case button");
    
    Thread.sleep(5000);

	Excel_Utility.setExcelFile(filepath, sheetName);
    String User_level = Excel_Utility.getCellData(1, 28);
    
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_UserLevel, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_UserLevel, "new case button");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(User_level), 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(User_level), User_level+" to select "+User_level+"from User level dropdown");
	
	Thread.sleep(3000);
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Bonny, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Bonny, "new case button");
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Assign, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Assign, "new case button");

	String expectedassigstatus="Case successfully reassigned";
	TestBase.waitForElement(SBV_Connect_CommonPageObject.userassignstatus, 50);
	if(TestBase.isElementVisible(SBV_Connect_CommonPageObject.userassignstatus, "olgaassignstatus")) {
		actualassignstatus=TestBase.getElementText(SBV_Connect_CommonPageObject.userassignstatus, "olgastatus");
		
	}
	Assert.assertEquals(expectedassigstatus, actualassignstatus);
}

@Given("National Customer Liasion User able to Login into Connect System with National_Customer_Liasion_User_Username and National_Customer_Liasion_User_password")
public void national_Customer_Liasion_User_able_to_Login_into_Connect_System_with_National_Customer_Liasion_User_Username_and_National_Customer_Liasion_User_password() throws Exception {
	String url=Utils.getFileProperty("Application_SBV_ConnectURL");
	pageBase.driver.get(url);

	Excel_Utility.setExcelFile(filepath, sheetName);
    String Bonny_Username = Excel_Utility.getCellData(1, 40);
    String Bonny_Password = Excel_Utility.getCellData(1, 41);
	
	TestBase.waitForElement(SBV_Connect_Login_pageObject.SBV_Login_Email_Input, 50);
	TestBase.typeinTextBox(SBV_Connect_Login_pageObject.SBV_Login_Email_Input, Bonny_Username, "Entered User Name");
	TestBase.waitForElement(SBV_Connect_Login_pageObject.SBV_Login_Password_Input, 50);
	TestBase.typeinTextBox(SBV_Connect_Login_pageObject.SBV_Login_Password_Input, Bonny_Password, "Entered Password");
	TestBase.waitForElement(SBV_Connect_Login_pageObject.SBV_Login_Button, 50);
	TestBase.clickonElement(SBV_Connect_Login_pageObject.SBV_Login_Button, "Clicked on Login Button");
}


@Given("National Customer Liasion User Navigates to TaskList,Search with New Case Id and Update the Case by using Excelsheetdata {string} and row number \"{int}\" Logged by External User")
public void national_Customer_Liasion_User_Navigates_to_TaskList_Search_with_New_Case_Id_and_Update_the_Case_by_using_Excelsheetdata_and_row_number_Logged_by_External_User(String string, Integer int1) throws Exception {
	Thread.sleep(5000);
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_view_task_list, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_view_task_list, "View task list");
	TestBase.driver.navigate().refresh();
	
	Thread.sleep(25000);
	TestBase.driver.switchTo().frame("myFrame");
	TestBase.driver.switchTo().frame("bonitaframe");

	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, "new case button");
	Thread.sleep(5000);
	System.out.println("letestcaseno"+ NewCase);
	TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_SearchByinput, NewCase, "Enter");

  for(int i=0;i<13;i++) {

	  TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.LEFT));
      }

  TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.BACK_SPACE));
  
  Thread.sleep(5000);
  TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_update_Case, 50);
  TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_update_Case, "new case button");
  
  TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_CIT_Number, 50);
  if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_CIT_Number, "CIT Number"))) {

	  ExceptionHandling.HandleAssertion("CIT_Number is not diaplayed");

  }
  
  TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Region, 50);
  if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Region,  "Region"))) {

	  ExceptionHandling.HandleAssertion("Region is not diaplayed");

  }
  
  TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Cash_Center, 50);
   if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Cash_Center,   "Cash_Center"))) {

    	  ExceptionHandling.HandleAssertion("Cash_Center is not diaplayed");
      }

   Excel_Utility.setExcelFile(filepath, sheetName);
   String resolutionValue = Excel_Utility.getCellData(int1, 11);
   String BuisnessWorkflow= Excel_Utility.getCellData(int1, 12);
   String ResponsibleParty = Excel_Utility.getCellData(int1, 13);
   String statusResolved = Excel_Utility.getCellData(1, 38);

   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Status, 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Status, "Status");
   Thread.sleep(5000);
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Status, 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Status, "Status");
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(statusResolved), 40);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(statusResolved), statusResolved+" to select "+statusResolved+"from Status dropdown");

   Thread.sleep(3000);
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Resolution_Dropdown, 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Resolution_Dropdown, "ResolutionDropdown");
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(resolutionValue), 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(resolutionValue), resolutionValue+" to select "+resolutionValue+"from Resolution dropdown");
  
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Business_workflow_Dropdown, 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Business_workflow_Dropdown, "Buisness Work flow");
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(BuisnessWorkflow), 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(BuisnessWorkflow), BuisnessWorkflow+" to select "+BuisnessWorkflow+"from Buisness Work flow dropdown");

   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Responsible_party_Dropdown, 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Responsible_party_Dropdown, "Resonsible Party dropdown");
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(ResponsibleParty), 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(ResponsibleParty), ResponsibleParty+" to select "+ResponsibleParty+"from Responsible Party dropdown");

   String PdfFile = "TestData/UploadFiles/dummy.pdf";
   TestBase.FileUpload(SBV_Connect_CommonPageObject.SBV_Uploadfile1, PdfFile);

   Thread.sleep(5000);
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Add_Notes, 50);
   TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_Add_Notes, "Internal user updated the Case", "Enter Notes");
   
   Thread.sleep(8000);
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Update, 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Update, "Update button"); 

}

@Given("National Customer Liasion User User Navigates to TaskList,Search with Latest Case id,Click on RTL Intervention and Update the Case")
public void national_Customer_Liasion_User_User_Navigates_to_TaskList_Search_with_Latest_Case_id_Click_on_RTL_Intervention_and_Update_the_Case() throws Exception {
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_view_task_list, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_view_task_list, "View task list");
	TestBase.driver.navigate().refresh();
	
	Thread.sleep(5000);
	TestBase.driver.switchTo().frame("myFrame");
	TestBase.driver.switchTo().frame("bonitaframe");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, "new case button");
	Thread.sleep(4000);
	System.out.println(NewCase);
	TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_SearchByinput, NewCase, "Enter");

  for(int i=0;i<13;i++) {

	  TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.LEFT));
      }

  TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.BACK_SPACE));
  
  Thread.sleep(25000);
  TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_RTLIntervention, 50);
  TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_RTLIntervention, "update case");

   Thread.sleep(5000);
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Add_Notes, 50);
   TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_Add_Notes, "Testing", "Enter Notes");
   
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Update, 50);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Update, "Update button"); 
}

@Given("National Customer Liasion User User Navigates to TaskList,Search with Latest Case id,Click on NCSM Intervention and Update the Case")
public void national_Customer_Liasion_User_User_Navigates_to_TaskList_Search_with_Latest_Case_id_Click_on_NCSM_Intervention_and_Update_the_Case() throws Exception {
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_view_task_list, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_view_task_list, "View task list");
	TestBase.driver.navigate().refresh();
	
	Thread.sleep(5000);
	TestBase.driver.switchTo().frame("myFrame");
	TestBase.driver.switchTo().frame("bonitaframe");
	TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, 50);
	TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, "new case button");
	Thread.sleep(4000);
	System.out.println(NewCase);
	TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_SearchByinput, NewCase, "Enter");

  for(int i=0;i<13;i++) {

	  TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.LEFT));
      }

  TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.BACK_SPACE));
  
  Thread.sleep(5000);
  TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_NCSMIntervention, 50);
  TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_NCSMIntervention, "update case");

   Thread.sleep(5000);
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Add_Notes, 500);
   TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_Add_Notes, "Testing", "Enter Notes");
   
   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Update, 500);
   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Update, "Update button"); 
}


@Then("AdminUser Sort the Users by Name in Ascending and Decending order")
public void adminuser_Sort_the_Users_by_Name_in_Ascending_and_Decending_order() throws Exception {
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_NameColumn, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_NameColumn, "Name Column");
    Thread.sleep(7000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_NameColumn, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_NameColumn, "Name Column");

}

@Then("AdminUser Sort the Users by its profile type")
public void adminuser_Sort_the_Users_by_its_profile_type() throws Exception {

    Thread.sleep(7000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_profileTypeColumn, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_profileTypeColumn, "profile Type Column");
    Thread.sleep(4000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_profileTypeColumn, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_profileTypeColumn, "profile Type Column");

}

@Then("AdminUser Sort the Users by Created on and last updated basis")
public void adminuser_Sort_the_Users_by_Created_on_and_last_updated_basis() throws Exception {

    Thread.sleep(7000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_LastupdateColumn, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_LastupdateColumn, "Last update Column");
    Thread.sleep(3000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_CreatedOncolumn, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_CreatedOncolumn, "Created on Column");

}

@Then("AdminUser Sort the Users by its Status")
public void adminuser_Sort_the_Users_by_its_Status() throws Exception {

    Thread.sleep(7000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_UserStatusColumn, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_UserStatusColumn, "Created on Column");
    Thread.sleep(3000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_UserStatusColumn, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_UserStatusColumn, "Created on Column");

}

@Then("User Click on Profile setting")
public void user_Click_on_Profile_setting() throws Exception {

    Thread.sleep(3000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Profilesettingbuttion, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Profilesettingbuttion, "Profile setting button");
}

@Then("User edit the profile by clicking on edit button in profile setting")
public void user_edit_the_profile_by_clicking_on_edit_button_in_profile_setting() throws Exception {

    Thread.sleep(3000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Profilesettingeditbuttion, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Profilesettingeditbuttion, "Profile setting edit button");
    Thread.sleep(3000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_ProfilesettingCashcenterDropdown, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_ProfilesettingCashcenterDropdown, "Cash Center dropdown");
    Thread.sleep(3000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_ProfilesettingCashcenterValue, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_ProfilesettingCashcenterValue, "Cash Center Value");
    Thread.sleep(5000);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_ProfilesettingCashcenterper, "Cash Center permission text");

}

@Then("User Click on Save Changes button")
public void user_Click_on_Save_Changes_button() throws Exception {

    Thread.sleep(3000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_ProfilesettingSavechangesbutton, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_ProfilesettingSavechangesbutton, "Save Change button");
}

@Then("AdminUser Enters the coment once change request is Came to AdminUser")
public void adminuser_Enters_the_coment_once_change_request_is_Came_to_AdminUser() throws Exception {
	
    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_ApprovalCommenttextbox, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_ApprovalCommenttextbox, "Comment textBox");
    TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_ApprovalCommenttextbox, "The Change Request is Approved", "Comment textBox");

}

@Then("User Navigates to Caselist and Verify the Logged Case")
public void User_Navigates_to_Caselist_and_Verify_the_Logged_Case() throws Exception {
    Thread.sleep(3000);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_LatestCaseNumber, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_LatestCaseNumber, "Latestcase Number");
    Thread.sleep(5000);
    if(!(TestBase.waitForElementToBevisible(SBV_Connect_CommonPageObject.SBV_GetCaseid,500))) {
        TestBase.driver.navigate().refresh();
        NationalManagerCase1 = TestBase.getElementText(SBV_Connect_CommonPageObject.SBV_GetCaseid," Firstrow");
      }
    else if(TestBase.waitForElementToBevisible(SBV_Connect_CommonPageObject.SBV_GetCaseid,500) ){
          Thread.sleep(5000);
          NationalManagerCase1 = TestBase.getElementText(SBV_Connect_CommonPageObject.SBV_GetCaseid," Firstrow");    
      }else {

          ExceptionHandling.HandleAssertion("unable to copy Firstrow");
      }
    System.out.println(NationalManagerCase1);
    Assert.assertEquals(BranchManagerCase1, NationalManagerCase1);
}

@Then("Bank User Log a New Case by using town,Case_type,Case_Subtype By using SheetName {string} and row number \"{int}\" in Connect System")
public void Bank_User_Log_a_New_Case_by_using_town_Case_type_Case_Subtype_By_using_SheetName_and_row_number_in_Connect_System(String string, Integer int1) throws Throwable {
	Thread.sleep(5000);
	TestBase.RefreshPage();
    Thread.sleep(25000);
    TestBase.driver.switchTo().frame("myFrame");
    TestBase.driver.switchTo().frame("bonitaframe");
    TestBase.driver.switchTo().frame(TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_inner_frame));

    Thread.sleep(4000);
    Excel_Utility.setExcelFile(filepath, string);
    String town = Excel_Utility.getCellData(int1, 0);
    String Case_type= Excel_Utility.getCellData(int1, 1);
    String CaseSubType = Excel_Utility.getCellData(int1, 2);
    Thread.sleep(4000);
    System.out.println(Case_type);
    System.out.println(CaseSubType);

    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_query_menu, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_query_menu, "CaseTypedropdown");
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(Case_type), 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(Case_type), Case_type+" to select "+Case_type+"from case type dropdown");

    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_query_menu, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_query_menu, "CaseSubTypedropdown");
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(CaseSubType), 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(CaseSubType), CaseSubType+" to select "+CaseSubType+"from case Sub type dropdown");

    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_click_next_button, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_next_button, "Next button");

    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_type_search_key, 50);
    TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_type_search_key, "Johannesburg", "enter data");
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_search_button, "search button");
    Thread.sleep(5000);

    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_type_search_key, 50);
    TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_type_search_key, town, "enter data");
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_search_button, "search button");

    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_type_search_key, 50);
    TestBase.getElements(SBV_Connect_CommonPageObject.SBV_Select_Cash_Center);
    TestBase.ClickViaMouse(SBV_Connect_CommonPageObject.SBV_Select_Cash_Center, "cash canter");

    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_CIT_Number, 50);
    if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_CIT_Number, "CIT Number"))) {
        ExceptionHandling.HandleAssertion("CIT_Number is not diaplayed");
    }

    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Region, 50);
    if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Region, "Region"))) {
        ExceptionHandling.HandleAssertion("Region is not diaplayed");
    }
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Cash_Center, 50);

    if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Cash_Center,  "Cash_Center"))) {

        ExceptionHandling.HandleAssertion("Cash_Center is not diaplayed");
    }

    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_click_next_button, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_next_button, "Next button");
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Select_Date, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Select_Date, "Select Date");
    Thread.sleep(5000);
     Excel_Utility.setExcelFile(filepath, string);
       String StopLoss_Number = Excel_Utility.getCellData_Integer(int1,3);
       String BagSeal_Number= Excel_Utility.getCellData_Integer(int1, 4);
       String Container_Number = Excel_Utility.getCellData_Integer(int1, 5);
       Thread.sleep(5000);  
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Stoploss, 50);
    TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_Stoploss, StopLoss_Number, "Qusetionthree");
    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_BagSeal, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_BagSeal, "new case button");
    TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_BagSeal, BagSeal_Number, "Qusetionthree");
    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Container, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Container, "new case button");
    TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_Container, Container_Number, "Qusetionthree");
    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_click_next_button, 50);
    TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_next_button, "Next button");
}

@Then("User Navigate to dashboard click on select filter button")
public void user_Navigate_to_dashboard_click_on_select_filter_button() throws Exception {


    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Dashboard, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Dashboard, "dashboard");

    TestBase.RefreshPage();
    Thread.sleep(25000);
    TestBase.driver.switchTo().frame("myFrame");
    TestBase.driver.switchTo().frame("bonitaframe");
    Thread.sleep(3000);

    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Selectfilters, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Selectfilters, "Select filters");

}

@Then("User will filter the local loged Cases")
public void user_will_filter_the_local_loged_Cases() throws Exception {

    Thread.sleep(6000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Selectfilters, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Selectfilters, "Select filters");

    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_MyWorkCheckbox, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_MyWorkCheckbox, "My Work CheckBox");

    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Apply_Filters, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Apply_Filters, "Filterbutton");
}

@Then("User will filter the loged Cases By reigonaly selecting Region Value,Cash Center Value By using SheetName {string} and row number \"{int}\" in Connect System")
public void user_will_filter_the_loged_Cases_By_reigonaly_selecting_Region_Value_Cash_Center_Value_By_using_SheetName_and_row_number_in_Connect_System(String string, Integer int1) throws Exception {

    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Selectfilters, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Selectfilters, "Select filters");

     Excel_Utility.setExcelFile(filepath, string);
        String RegionValue = Excel_Utility.getCellData(int1, 6);
        String CashcenterValue = Excel_Utility.getCellData(int1, 7);

        Thread.sleep(3000);
        TestBase.waitForElement(SBV_Connect_PageObjects.SBV_RegionDropd, 50);
        TestBase.clickonElement(SBV_Connect_PageObjects.SBV_RegionDropd, "regin filter");
        TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(RegionValue), 50);
        TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(RegionValue), RegionValue+" to select "+RegionValue+"from Region dropdown");

        Thread.sleep(3000);
        TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Cashcentre, 50);
        TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Cashcentre, "cashcenterDropown");
        TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(CashcenterValue), 50);
        TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(CashcenterValue), CashcenterValue+" to select "+CashcenterValue+"from Cash Center dropdown");        

        Thread.sleep(5000);
        TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Apply_Filters, 50);
        TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Apply_Filters, "Filterbutton");
}


@Then("User will filter the loged Cases Nationally")
public void user_will_filter_the_loged_Cases_Nationally() throws Exception {

    Thread.sleep(5000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Apply_Filters, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Apply_Filters, "Filterbutton");
}



@Given("User Click on Dashboard and Verify the Cases by Type,")
public void user_Click_on_Dashboard_and_Verify_the_Cases_by_Type() throws Exception {

    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Dashboard, 50);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_Dashboard, "dashboard");

    Thread.sleep(5000);
    TestBase.driver.switchTo().frame("myFrame");
    TestBase.driver.switchTo().frame("bonitaframe");
    Thread.sleep(3000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Dashboard_CasesByType, 50);
    TestBase.ClickViaMouse(SBV_Connect_PageObjects.SBV_Dashboard_CasesByType, "dashboard");
    String CaseByType=TestBase.getElementText(SBV_Connect_PageObjects.SBV_Dashboard_CasesByType, "dashboard");
    System.out.println(CaseByType);
}

@Given("User Verify the Cases by Channel")
public void user_Verify_the_Cases_by_Channel() throws Exception {
    Thread.sleep(3000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Dashboard_CasesByChannel, 50);
    TestBase.ClickViaMouse(SBV_Connect_PageObjects.SBV_Dashboard_CasesByChannel, "dashboard");
}

@Given("User Verify the Cases by CashCentre")
public void user_Verify_the_Cases_by_CashCentre() throws Exception {
    Thread.sleep(3000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Dashboard_CasesByCashCentre, 50);
    TestBase.ClickViaMouse(SBV_Connect_PageObjects.SBV_Dashboard_CasesByCashCentre, "dashboard");
}

@Given("User Verify the Cases by Age in Days")
public void user_Verify_the_Cases_by_Age_in_Days() throws Exception {
    Thread.sleep(3000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_Dashboard_CasesByAge, 50);
    TestBase.ClickViaMouse(SBV_Connect_PageObjects.SBV_Dashboard_CasesByAge, "dashboard");
}

}

