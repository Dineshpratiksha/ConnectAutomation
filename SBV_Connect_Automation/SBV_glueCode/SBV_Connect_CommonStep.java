package SBV_glueCode;

import org.openqa.selenium.Keys;

import SBV_pageObjects.SBV_Connect_CommonPageObject;
import SBV_pageObjects.SBV_Connect_Login_pageObject;
import SBV_pageObjects.SBV_Connect_PageObjects;
import SBV_testBase.TestBase;
import SBV_testBase.pageBase;
import SBV_utility.Excel_Utility;
import SBV_utility.ExceptionHandling;
import SBV_utility.Utils;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class SBV_Connect_CommonStep {

	public static String ExistingCase;
	public static String NewCase;
	public static String actualassignstatus;
	public static String filepath = "./TestData/TestData_Excel/SBV_connectTestData.xlsx";
    public static String sheetName = "ConnectTestDeta";
    public static String Otp;
    public static String Password;
	public static String EmailID;
	public static String Name;
	public static String SurName;

	public static String ForgotPassword_Email;
	public static String ForgotPassword_SBVEmail;
public static String ForgotPassword_MerchantEmail;


    @Given("External User Verifies the Login into Connect System")
    public void external_User_Verifies_the_Login_into_Connect_System() throws Exception {
    	String otpurl=Utils.getFileProperty("OTPApplication_URL");
		pageBase.driver.get(otpurl);
		TestBase.waitForElement(SBV_Connect_Login_pageObject.SBV_OTP, 60);
		Otp=TestBase.getElementText(SBV_Connect_Login_pageObject.SBV_OTP, "Get OTP");
		
    	
    	
    }

    @Given("Internal User Verifies the Login into Connect System")
    public void internal_User_Verifies_the_Login_into_Connect_System() throws Exception {
		String otpurl=Utils.getFileProperty("Internal_OTP_URL");
		pageBase.driver.get(otpurl);
		TestBase.waitForElement(SBV_Connect_Login_pageObject.SBV_OTP, 60);
		Otp=TestBase.getElementText(SBV_Connect_Login_pageObject.SBV_OTP, "Get OTP");
		Thread.sleep(2000);
		
    }
    
    @Given("National Customer Liasion User Verifies the Login into Connect System")
    public void national_Customer_Liasion_User_Verifies_the_Login_into_Connect_System() throws Exception {
    	String otpurl=Utils.getFileProperty("National_bonny_OTP_URL");
    	pageBase.driver.get(otpurl);
    	TestBase.waitForElement(SBV_Connect_Login_pageObject.SBV_OTP, 60);
    	Otp=TestBase.getElementText(SBV_Connect_Login_pageObject.SBV_OTP, "Get OTP");
    	Thread.sleep(2000);
    }

	@Then("External User Navigates to Caselist and Verify Existing case displayed")
	public void external_User_Navigates_to_Caselist_and_Verify_Existing_case_displayed() throws Throwable {
		
		TestBase.waitForElement(SBV_Connect_CommonPageObject.CaseList, 60);
        TestBase.clickonElement(SBV_Connect_CommonPageObject.CaseList, "Caselist");
        Thread.sleep(2000);
        TestBase.RefreshPage();
        Thread.sleep(15000);
        TestBase.driver.switchTo().frame("myFrame");
        TestBase.driver.switchTo().frame("bonitaframe");
        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_LatestCaseNumber, 20);
        TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_LatestCaseNumber, "Latestcase Number");
        Thread.sleep(5000);
        if(!(TestBase.waitForElementToBevisible(SBV_Connect_CommonPageObject.SBV_GetCaseid,100))) {
            TestBase.driver.navigate().refresh();
              ExistingCase = TestBase.getElementText(SBV_Connect_CommonPageObject.SBV_GetCaseid," Firstrow");
          }else if(TestBase.waitForElementToBevisible(SBV_Connect_CommonPageObject.SBV_GetCaseid,100) ){
              Thread.sleep(1000);
              ExistingCase = TestBase.getElementText(SBV_Connect_CommonPageObject.SBV_GetCaseid," Firstrow");    
          }else {
              ExceptionHandling.HandleAssertion("unable to copy Firstrow");
              System.out.println(ExistingCase);
          }
    }
	
	@Then("External User Navigates to Caselist and Verify Existing Reporting case id displayed")
	public void external_User_Navigates_to_Caselist_and_Verify_Existing_Reporting_case_id_displayed() throws InterruptedException, Exception {
		TestBase.waitForElement(SBV_Connect_CommonPageObject.CaseList, 10);
        TestBase.clickonElement(SBV_Connect_CommonPageObject.CaseList, "Caselist");
        Thread.sleep(2000);
    	TestBase.RefreshPage();
        Thread.sleep(30000);
        TestBase.driver.switchTo().frame("myFrame");
        TestBase.driver.switchTo().frame("bonitaframe");
        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_LatestCaseNumber_Reporting, 20);
        TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_LatestCaseNumber_Reporting, "Latestcase Number");
        Thread.sleep(5000);

        if(!(TestBase.waitForElementToBevisible(SBV_Connect_CommonPageObject.SBV_GetCaseid,100))) {
            TestBase.driver.navigate().refresh();
             ExistingCase = TestBase.getElementText(SBV_Connect_CommonPageObject.SBV_GetCaseid," Firstrow");

          }else if(TestBase.waitForElementToBevisible(SBV_Connect_CommonPageObject.SBV_GetCaseid,100) ){
              Thread.sleep(1000);
              ExistingCase = TestBase.getElementText(SBV_Connect_CommonPageObject.SBV_GetCaseid," Firstrow");    
          }else {
              ExceptionHandling.HandleAssertion("unable to copy Firstrow");
          }

        System.out.println(ExistingCase);
    }

	@Given("Reginal User able to Login into Connect system With olga_Username and Olga_Password")
	public void reginal_User_able_to_Login_into_Connect_system_With_olga_Username_and_Olga_Password() throws Exception {
//		pageBase.OpenBrowser("Browser");
		String url=Utils.getFileProperty("Application_SBV_ConnectURL");
		pageBase.driver.get(url);

		Excel_Utility.setExcelFile(filepath, sheetName);
        String olga_Username = Excel_Utility.getCellData(1, 4);
        String Olga_Password = Excel_Utility.getCellData(1, 5);
        
		TestBase.waitForElement(SBV_Connect_Login_pageObject.SBV_Login_Email_Input, 10);
		TestBase.typeinTextBox(SBV_Connect_Login_pageObject.SBV_Login_Email_Input, olga_Username, "Entered User Name");
		TestBase.waitForElement(SBV_Connect_Login_pageObject.SBV_Login_Password_Input, 10);
		TestBase.typeinTextBox(SBV_Connect_Login_pageObject.SBV_Login_Password_Input, Olga_Password, "Entered Password");
		TestBase.waitForElement(SBV_Connect_Login_pageObject.SBV_Login_Button, 10);
		TestBase.clickonElement(SBV_Connect_Login_pageObject.SBV_Login_Button, "Clicked on Login Button");
		
	}
	
	@Given("Reginal User Verifies the Login into Connect System")
	public void reginal_User_Verifies_the_Login_into_Connect_System() throws Exception {
		String otpurl=Utils.getFileProperty("Regional_OTP_URL");
		pageBase.driver.get(otpurl);
		Otp=TestBase.getElementText(SBV_Connect_Login_pageObject.SBV_OTP, "Get OTP");
		Thread.sleep(2000);
	}
	
	
	@Given("ConnectAdmin User Verifies the Login into Connect System")
	public void ConnectAdmin_User_Verifies_the_Login_into_Connect_System() throws Exception {
		String otpurl=Utils.getFileProperty("ConnectAdminOTP_URL");
		pageBase.driver.get(otpurl);
		Otp=TestBase.getElementText(SBV_Connect_Login_pageObject.SBV_OTP, "Get OTP");
		Thread.sleep(2000);
	}


	@Given("Reginal User Navigates to Caselist,Search with Latest Case id and Verify whether it is assigned to Regional User by selecting the {string},{string},{string} Values")
	public void reginal_User_Navigates_to_Caselist_Search_with_Latest_Case_id_and_Verify_whether_it_is_assigned_to_Regional_User_by_selecting_the_Values(String User_level, String Cash_center, String CLO) throws Throwable {
	    
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_see_case_list, 10);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_see_case_list, "case list");
		 Thread.sleep(2000);
		 TestBase.RefreshPage();
		Thread.sleep(10000);
		TestBase.driver.switchTo().frame("myFrame");
		TestBase.driver.switchTo().frame("bonitaframe");
		
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, 20);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, "SearchByfield");
		TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_SearchByinput, NewCase, "Enter");
        Thread.sleep(2000);
        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_LatestCaseNumber, 20);
        TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_LatestCaseNumber, "Latestcase Number");

        Thread.sleep(2000);
        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AuditTrail, 10);
        TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AuditTrail, "new case button");
        TestBase.ScrollDownBottom();
        
        Thread.sleep(2000);
        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Admin, 10);
        TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Admin, "new case button");
        
        Thread.sleep(2000);

		TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_UserLevel, 10);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_UserLevel, "new case button");
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(User_level), 10);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(User_level), User_level+" to select "+User_level+"from User level dropdown");
		
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_CashCenter, 10);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_CashCenter, "new case button");
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(Cash_center), 10);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(Cash_center), Cash_center+" to select "+Cash_center+"from Cash center dropdown");  
	
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Tholana, 10);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Tholana, "new case button");
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(CLO), 10);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(CLO), CLO+" to select "+CLO+"from CLO dropdown");		
		
		Thread.sleep(2000);
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Assign, 10);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Assign, "new case button");

		String expectedassigstatus="Case successfully reassigned";
		TestBase.waitForElement(SBV_Connect_CommonPageObject.userassignstatus, 10);
		if(TestBase.isElementVisible(SBV_Connect_CommonPageObject.userassignstatus, "userassignstatus")) {
			actualassignstatus=TestBase.getElementText(SBV_Connect_CommonPageObject.userassignstatus, "userassignstatus");
			
		}
	Assert.assertEquals(expectedassigstatus, actualassignstatus);
	}


	@Given("National User able to Login into Connect system with lauren_Username and lauren_password")
	public void national_User_able_to_Login_into_Connect_system_with_lauren_Username_and_lauren_password() throws Exception {
		String url=Utils.getFileProperty("Application_SBV_ConnectURL");
		pageBase.driver.get(url);
		

		Excel_Utility.setExcelFile(filepath, sheetName);
        String Lauren_Username = Excel_Utility.getCellData(1, 6);
        String Lauren_Password = Excel_Utility.getCellData(1, 7);
		
		TestBase.waitForElement(SBV_Connect_Login_pageObject.SBV_Login_Email_Input, 10);
		TestBase.typeinTextBox(SBV_Connect_Login_pageObject.SBV_Login_Email_Input, Lauren_Username, "Entered User Name");
		TestBase.waitForElement(SBV_Connect_Login_pageObject.SBV_Login_Password_Input, 10);
		TestBase.typeinTextBox(SBV_Connect_Login_pageObject.SBV_Login_Password_Input, Lauren_Password, "Entered Password");
		TestBase.waitForElement(SBV_Connect_Login_pageObject.SBV_Login_Button, 10);
		TestBase.clickonElement(SBV_Connect_Login_pageObject.SBV_Login_Button, "Clicked on Login Button");
		Thread.sleep(2000);
		
	}

	@Then("National User Logout into Connect System")
	public void national_User_Logout_into_Connect_System() throws Exception {
		pageBase.driver.switchTo().defaultContent();
		Thread.sleep(5000);
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_logout, 30); 
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_logout, "Logout ");
		
	}
	@Given("External User Logs a case for {string} using {string},{string}")
	public void external_User_Logs_a_case_for_using(String town, String Case_type, String CaseSubType) throws Throwable {
	    
		Thread.sleep(2000);
		TestBase.driver.switchTo().defaultContent();
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Log_New_Case_Button,30);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Log_New_Case_Button, "Log new case button");
		TestBase.RefreshPage();
		Thread.sleep(10000);
		TestBase.driver.switchTo().frame("myFrame");
	    TestBase.driver.switchTo().frame("bonitaframe");
		TestBase.driver.switchTo().frame(TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_inner_frame));
		
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_query_menu, 20);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_query_menu, "CaseTypedropdown");
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(Case_type), 10);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(Case_type), Case_type+" to select "+Case_type+"from case type dropdown");
		
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_query_menu, 20);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_query_menu, "CaseSubTypedropdown");
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(CaseSubType), 10);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(CaseSubType), CaseSubType+" to select "+CaseSubType+"from case Sub type dropdown");
		
        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_click_next_button, 10);
        TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_next_button, "Next button");

        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_type_search_key, 10);
        TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_type_search_key, town, "enter data");
        TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_search_button, "search button");
        
        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_type_search_key, 10);
        TestBase.getElements(SBV_Connect_CommonPageObject.SBV_Select_Cash_Center);
        TestBase.ClickViaMouse(SBV_Connect_CommonPageObject.SBV_Select_Cash_Center, "cash canter");
        
        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_CIT_Number, 10);
        if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_CIT_Number, "CIT Number"))) {

            ExceptionHandling.HandleAssertion("CIT_Number is not diaplayed");
        }
        
        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Region, 10);
        if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Region, "Region"))) {

        	ExceptionHandling.HandleAssertion("Region is not diaplayed");
        }
        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Cash_Center, 10);

        if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Cash_Center,  "Cash_Center"))) {

        	ExceptionHandling.HandleAssertion("Cash_Center is not diaplayed");
        }
        
        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_click_next_button, 10);
        TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_next_button, "Next button");
        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Select_Date, 10);
        TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Select_Date, "Select Date");
        
        Thread.sleep(5000);
//        TestBase.waitForElement(SBV_CommonPageObject.SBV_Bank, 20);
//        if (!(TestBase.isElementVisible(SBV_CommonPageObject.SBV_Bank, "Bank"))) {
//
//        	ExceptionHandling.HandleAssertion("Bank is not diaplayed");
//        }
//          BankName = TestBase.getTextFromPropertis(SBV_CommonPageObject.SBV_Bank);
//          System.out.println(BankName);
//        if(TestBase.getElementAttribute(SBV_CommonPageObject.SBV_Bank, "bankfield", "Bank").isEmpty()){
//        	ExceptionHandling.HandleAssertion("Bank Name is not Auto populated");
//        }
        
        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_click_next_button, 10);
        TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_click_next_button, "Next button");
        
        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AddFile, 10);
        TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AddFile, "AddFile button");
        Thread.sleep(3000);

        TestBase.waitForElement(SBV_Connect_PageObjects.SBV_FileUpload1, 20);
        TestBase.clickonElement(SBV_Connect_PageObjects.SBV_FileUpload1, "upload button");
        Thread.sleep(3000);

        Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\TestData\\AutoIT\\fileupload.exe");
    
        Thread.sleep(2000);
        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Add_Notes, 10);
        TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_Add_Notes, "Testing", "Enter Notes");
        
        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Submit_Button, 10);
        TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Submit_Button, "Submit button");
        
        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Logcase_Successful_Message, 10);
        if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Logcase_Successful_Message, "Succussufuly Log"))) {

        	ExceptionHandling.HandleAssertion("Succesful Message is not diaplayed");
        }
    }
	@Then("User able to Logout into Connect System")
	public void user_able_to_Logout_into_Connect_System() throws Exception {
		pageBase.driver.switchTo().defaultContent();
		Thread.sleep(5000);
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_logout, 30); 
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_logout, "Logout ");
		
	}

	@Given("Internal User Navigates to TaskList,Search with New Case Id and Update the With {string},{string},{string} Case Logged by External User")
	public void internal_User_Navigates_to_TaskList_Search_with_New_Case_Id_and_Update_the_With_Case_Logged_by_External_User(String resolutionValue, String BuisnessWorkflow, String ResponsibleParty) throws Exception {
		
		TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_view_task_list, 20);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_view_task_list, "View task list");
		TestBase.driver.navigate().refresh();
		
		Thread.sleep(5000);
		TestBase.driver.switchTo().frame("myFrame");
		TestBase.driver.switchTo().frame("bonitaframe");

		TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, 20);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, "new case button");
		Thread.sleep(2000);
		TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_SearchByinput, NewCase, "Enter");

      for(int i=0;i<13;i++) {

    	  TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.LEFT));
          }

      TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.BACK_SPACE));
      
      Thread.sleep(2000);
      TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_New_Case, 10);
      TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_New_Case, "new case button");
      
      TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_CIT_Number, 10);
      if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_CIT_Number, "CIT Number"))) {

    	  ExceptionHandling.HandleAssertion("CIT_Number is not diaplayed");

      }
      
      TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Region, 10);
      if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Region,  "Region"))) {

    	  ExceptionHandling.HandleAssertion("Region is not diaplayed");

      }
      
      TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Cash_Center, 10);
       if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Cash_Center,   "Cash_Center"))) {

        	  ExceptionHandling.HandleAssertion("Cash_Center is not diaplayed");
          }

       TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Resolution_Dropdown, 10);
       TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Resolution_Dropdown, "ResolutionDropdown");
	   TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(resolutionValue), 10);
	   TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(resolutionValue), resolutionValue+" to select "+resolutionValue+"from Resolution dropdown");
	  
	   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Business_workflow_Dropdown, 10);
       TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Business_workflow_Dropdown, "Buisness Work flow");
	   TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(BuisnessWorkflow), 10);
	   TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(BuisnessWorkflow), BuisnessWorkflow+" to select "+BuisnessWorkflow+"from Buisness Work flow dropdown");

	   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Responsible_party_Dropdown, 10);
       TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Responsible_party_Dropdown, "Resonsible Party dropdown");
	   TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(ResponsibleParty), 10);
	   TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(ResponsibleParty), ResponsibleParty+" to select "+ResponsibleParty+"from Responsible Party dropdown");

       TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AddFile, 10);
       TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AddFile, "AddFile button");
       Thread.sleep(3000);

       TestBase.waitForElement(SBV_Connect_PageObjects.SBV_FileUpload1, 20);
       TestBase.clickonElement(SBV_Connect_PageObjects.SBV_FileUpload1, "upload button");
       Thread.sleep(3000);

       Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\TestData\\AutoIT\\fileupload.exe");
   
	   Thread.sleep(2000);
	   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Add_Notes, 10);
	   TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_Add_Notes, "Testing", "Enter Notes");
	   
	   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Update, 10);
	   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Update, "Update button");      
      
     }
	
	@Given("Internal User Search with New Case Id and Update the With {string},{string},{string} Case Logged by External User")
	public void internal_User_Search_with_New_Case_Id_and_Update_the_With_Case_Logged_by_External_User(String resolutionValue, String BuisnessWorkflow, String ResponsibleParty) throws Exception {
	    	

		TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, 20);
		TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_SearchByinput, "new case button");
		TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_SearchByinput, NewCase, "Enter");

        for(int i=0;i<13;i++) {

        	TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.LEFT));

        }

        TestBase.driver.findElement(SBV_Connect_CommonPageObject.SBV_SearchByinput).sendKeys(Keys.chord(Keys.BACK_SPACE));

      Thread.sleep(2000);
      TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_New_Case, 10);
      TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_New_Case, "new case button");
      
      TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_CIT_Number, 10);
      if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_CIT_Number, "CIT Number"))) {

    	  ExceptionHandling.HandleAssertion("CIT_Number is not diaplayed");

      }
      
      TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Region, 10);
      if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Region,  "Region"))) {

    	  ExceptionHandling.HandleAssertion("Region is not diaplayed");

      }
      
      TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Cash_Center, 10);
       if (!(TestBase.isElementVisible(SBV_Connect_CommonPageObject.SBV_Cash_Center,   "Cash_Center"))) {

        	  ExceptionHandling.HandleAssertion("Cash_Center is not diaplayed");

          }

       TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Resolution_Dropdown, 10);
       TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Resolution_Dropdown, "ResolutionDropdown");
	   TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(resolutionValue), 10);
	   TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(resolutionValue), resolutionValue+" to select "+resolutionValue+"from Resolution dropdown");
	  
	   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Business_workflow_Dropdown, 10);
       TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Business_workflow_Dropdown, "Buisness Work flow");
	   TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(BuisnessWorkflow), 10);
	   TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(BuisnessWorkflow), BuisnessWorkflow+" to select "+BuisnessWorkflow+"from Buisness Work flow dropdown");

	   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Responsible_party_Dropdown, 10);
       TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Responsible_party_Dropdown, "Resonsible Party dropdown");
	   TestBase.waitForElement(SBV_Connect_CommonPageObject.SelectWithoption(ResponsibleParty), 10);
	   TestBase.clickonElement(SBV_Connect_CommonPageObject.SelectWithoption(ResponsibleParty), ResponsibleParty+" to select "+ResponsibleParty+"from Responsible Party dropdown");

       TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_AddFile, 10);
       TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_AddFile, "AddFile button");
       Thread.sleep(3000);

       TestBase.waitForElement(SBV_Connect_PageObjects.SBV_FileUpload1, 20);
       TestBase.clickonElement(SBV_Connect_PageObjects.SBV_FileUpload1, "upload button");
       Thread.sleep(3000);

       Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\TestData\\AutoIT\\fileupload.exe");
   
	   Thread.sleep(2000);
	   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Add_Notes, 10);
	   TestBase.typeinTextBox(SBV_Connect_CommonPageObject.SBV_Add_Notes, "Testing", "Enter Notes");
	   
	   TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_Update, 10);
	   TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_Update, "Update button");  
        
	}
	@And("User opens the Browser")
	public void user_opens_the_Browser() throws Exception {
		pageBase.OpenBrowser("Browser"); 
	}

	@And("User opens new Browser Tab")
	public void user_opens_new_Browser_Tab() throws Exception {
		Thread.sleep(2000);
    	TestBase.NavigateToNewTab(0, "Navigate to new tab");
        Thread.sleep(2000);
	}
	@And("User switch to Tab {string}")
	public void user_switch_to_Tab(String TabNumber) throws Exception {
		int tabnumber=Integer.parseInt(TabNumber);
		TestBase.windowHandles(tabnumber, "Navigate to Login page");
		Thread.sleep(2000);
		pageBase.driver.navigate().refresh();
		Thread.sleep(2000);
	}
	@And("User enters OTP")
	public void user_enters_OTP() throws Exception {
	 	Thread.sleep(5000);
    	TestBase.waitForElement(SBV_Connect_Login_pageObject.SBV_OTP_Enter_Input, 10);
    	TestBase.typeinTextBox(SBV_Connect_Login_pageObject.SBV_OTP_Enter_Input, Otp, "Entered OTP");
    	Thread.sleep(2000);
	}
	@When("User Enters {string} as Email in Registration Page")
	public void user_Enters_as_Email_in_Registration_Page(String emailid) throws Exception {
	   
		   EmailID = emailid;
		   TestBase.waitForElement(SBV_Connect_PageObjects.SBV_RegisterEmail, 20);
		   TestBase.clickonElement(SBV_Connect_PageObjects.SBV_RegisterEmail, "Email textBox");
		   TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_RegisterEmail, EmailID, "Name textBox");
		
	}
	@Given("User Enters Email in Registration Page by using Excelsheetdata {string} and row number \"{int}\"")
	public void user_Enters_Email_in_Registration_Page_by_using_Excelsheetdata_and_row_number(String UserRegisterationData, Integer int1) throws Exception {
	    EmailID = Name + SurName +"@connect.com";
		Thread.sleep(2000);
	    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_RegisterEmail, 20);
		TestBase.clickonElement(SBV_Connect_PageObjects.SBV_RegisterEmail, "Email textBox");
		TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_RegisterEmail, EmailID, "Email textBox");
	}

	@When("User Verifies and Copy the OTT URL")
	public void user_Verifies_and_Copy_the_OTT_URL() throws Exception {
		Thread.sleep(5000);
		Otp=TestBase.getElementText(SBV_Connect_Login_pageObject.SBV_OTP, "Get OTP");
		Thread.sleep(2000);
	}


	@When("User Verifies the Login into Connect System")
	public void user_Verifies_the_Login_into_Connect_System() throws Exception {
		String otpurl=Utils.getFileProperty("OTTRegisterVerification_URL");
		pageBase.driver.get(otpurl+EmailID);
		
	}
	@When("User Paste the OTT URL and Click on Enter")
	public void user_Paste_the_OTT_URL_and_Click_on_Enter() throws Exception {
		Thread.sleep(5000);
		pageBase.driver.get(Otp);

	}
	
	@When("User Enter Valid Email Address in Connect Login Page by using Excelsheetdata {string} and row number \"{int}\"")
	public void user_Enter_Valid_Email_Address_in_Connect_Login_Page_by_using_Excelsheetdata_and_row_number(String ForgotPasswordData, Integer int1) throws Exception {
		Thread.sleep(2000);
		Excel_Utility.setExcelFile(filepath, ForgotPasswordData);
		String Email = Excel_Utility.getCellData(int1, 0);
		ForgotPassword_Email=Email;
		Thread.sleep(2000);
		TestBase.waitForElement(SBV_Connect_PageObjects.SBV_ForgotPassword_Email, 20);
		TestBase.clickonElement(SBV_Connect_PageObjects.SBV_ForgotPassword_Email, "Email textBox");
		TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_ForgotPassword_Email, ForgotPassword_Email, "Email textBox");
	}

	@When("User Enter Valid SBVEmail Address in Connect Login Page by using Excelsheetdata {string} and row number \"{int}\"")
	public void user_Enter_Valid_SBVEmail_Address_in_Connect_Login_Page_by_using_Excelsheetdata_and_row_number(String ForgotPasswordData, Integer int1) throws Exception {
		Thread.sleep(2000);
		Excel_Utility.setExcelFile(filepath, ForgotPasswordData);
		String Email = Excel_Utility.getCellData(int1, 3);
		ForgotPassword_SBVEmail=Email;
		Thread.sleep(2000);
		TestBase.waitForElement(SBV_Connect_PageObjects.SBV_ForgotPassword_Email, 20);
		TestBase.clickonElement(SBV_Connect_PageObjects.SBV_ForgotPassword_Email, "Email textBox");
		TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_ForgotPassword_Email, ForgotPassword_SBVEmail, "Email textBox");
	}


	@Then("AdminUser search the RegisteUser by EmailID")
	public void adminuser_search_the_RegisteUser_by_EmailID() throws Exception {
	   
		Thread.sleep(4000);
		TestBase.waitForElement(SBV_Connect_PageObjects.SBV_AdminSearchBox, 20);
		TestBase.clickonElement(SBV_Connect_PageObjects.SBV_AdminSearchBox, "Search field textBox");
		TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_AdminSearchBox, EmailID, "Search field textBox");
	}

	@When("User Verifies the ForgotPassword into Connect System")
	public void user_Verifies_the_ForgotPassword_into_Connect_System() throws Exception {
		Thread.sleep(5000);
		String otpurl=Utils.getFileProperty("OTTRegisterVerification_URL");
		pageBase.driver.get(otpurl+ForgotPassword_Email);
		Thread.sleep(2000);
		Otp=TestBase.getElementText(SBV_Connect_Login_pageObject.SBV_OTP, "Get OTP");
		Thread.sleep(2000);
	}

	@When("User Verifies the SBVUserForgotPassword into Connect System")
	public void user_Verifies_the_SBV_User_ForgotPassword_into_Connect_System() throws Exception {
		Thread.sleep(5000);
		String otpurl=Utils.getFileProperty("OTTRegisterVerification_URL");
		pageBase.driver.get(otpurl+ForgotPassword_SBVEmail);
		Thread.sleep(2000);
		Otp=TestBase.getElementText(SBV_Connect_Login_pageObject.SBV_OTP, "Get OTP");
		Thread.sleep(2000);
	}
	
	@When("User Verifies the MerchantUserForgotPassword into Connect System")
	public void user_Verifies_the_Merchant_User_ForgotPassword_into_Connect_System() throws Exception {
		Thread.sleep(5000);
		String otpurl=Utils.getFileProperty("OTTRegisterVerification_URL");
		pageBase.driver.get(otpurl+ForgotPassword_MerchantEmail);
		Thread.sleep(2000);
		Otp=TestBase.getElementText(SBV_Connect_Login_pageObject.SBV_OTP, "Get OTP");
		Thread.sleep(2000);
	}


	@When("User Enter Valid MerchantEmail Address in Connect Login Page by using Excelsheetdata {string} and row number \"{int}\"")
	public void user_Enter_Valid_MerchantEmail_Address_in_Connect_Login_Page_by_using_Excelsheetdata_and_row_number(String ForgotPasswordData, Integer int1) throws Exception {
		Thread.sleep(2000);
		Excel_Utility.setExcelFile(filepath, ForgotPasswordData);
		String Email = Excel_Utility.getCellData(int1, 4);
		ForgotPassword_MerchantEmail=Email;
		Thread.sleep(2000);
		TestBase.waitForElement(SBV_Connect_PageObjects.SBV_ForgotPassword_Email, 20);
		TestBase.clickonElement(SBV_Connect_PageObjects.SBV_ForgotPassword_Email, "Email textBox");
		TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_ForgotPassword_Email, ForgotPassword_MerchantEmail, "Email textBox");
	}

	@Then("User able to Login into Connect System with Merchant_Username as as {string} and Merchant_Password as {string}")
	public void user_able_to_Login_into_Connect_System_with_Merchant_Username_as_as_and_Merchant_Password_as(String UserName, String Password) throws Exception {
		Thread.sleep(2000);
		TestBase.waitForElement(SBV_Connect_Login_pageObject.SBV_Login_Email_Input, 10);
		TestBase.typeinTextBox(SBV_Connect_Login_pageObject.SBV_Login_Email_Input, UserName, "Entered User Name");
		TestBase.waitForElement(SBV_Connect_Login_pageObject.SBV_Login_Password_Input, 10);
		TestBase.typeinTextBox(SBV_Connect_Login_pageObject.SBV_Login_Password_Input, Password, "Entered Password");
		TestBase.waitForElement(SBV_Connect_Login_pageObject.SBV_Login_Button, 10);
		TestBase.clickonElement(SBV_Connect_Login_pageObject.SBV_Login_Button, "Clicked on Login Button");
	}


	@Given("User Enters Password in SetUp Password Page by using Excelsheetdata {string} and row number \"{int}\"")

	     public void user_Enters_Password_in_SetUp_Password_Page_by_using_Excelsheetdata_and_row_number(String UserRegisterationData, Integer int1) throws Exception {
	      Thread.sleep(2000);
	      Excel_Utility.setExcelFile(filepath, UserRegisterationData);
	      String password = Excel_Utility.getCellData(int1, 16);
	      Password = password;
	      Thread.sleep(2000);
	      TestBase.waitForElement(SBV_Connect_PageObjects.SBV_newPasswordinput, 20);
	      TestBase.clickonElement(SBV_Connect_PageObjects.SBV_newPasswordinput, "Password textBox");
	      TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_newPasswordinput, Password, "Password textBox");
	}


	@Given("User Enters Re-Enter Password in SetUp Password Page by using Excelsheetdata {string} and row number \"{int}\"")
    public void user_Enters_Re_Enter_Password_in_SetUp_Password_Page_by_using_Excelsheetdata_and_row_number(String UserRegisterationData, Integer int1) throws Exception {

    Thread.sleep(2000);
    Excel_Utility.setExcelFile(filepath, UserRegisterationData);
    String RenterPassword = Excel_Utility.getCellData(int1, 16);
    Thread.sleep(2000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_ReeneterPasswordinput, 20);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_ReeneterPasswordinput, "Password textBox");
    TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_ReeneterPasswordinput, Password, "Password textBox");

}
	
	@Then("User Log in Connect System By Entering RegisteredUserName & Password")
    public void user_Log_in_Connect_System_By_Entering_RegisteredUserName_Password() throws Exception {

    Thread.sleep(2000);
    TestBase.waitForElement(SBV_Connect_Login_pageObject.SBV_Login_Email_Input, 10);
    TestBase.typeinTextBox(SBV_Connect_Login_pageObject.SBV_Login_Email_Input, EmailID, "Entered User Name");
    TestBase.waitForElement(SBV_Connect_Login_pageObject.SBV_Login_Password_Input, 10);
    TestBase.typeinTextBox(SBV_Connect_Login_pageObject.SBV_Login_Password_Input, Password, "Entered Password");
    TestBase.waitForElement(SBV_Connect_Login_pageObject.SBV_Login_Button, 10);
    TestBase.clickonElement(SBV_Connect_Login_pageObject.SBV_Login_Button, "Clicked on Login Button");

    }
	

@Given("BankAdmin User Verifies the Login into Connect System")
public void BankAdmin_User_Verifies_the_Login_into_Connect_System() throws Exception {

    String otpurl=Utils.getFileProperty("BanktAdminOTP_URL");
    pageBase.driver.get(otpurl);
    Otp=TestBase.getElementText(SBV_Connect_Login_pageObject.SBV_OTP, "Get OTP");
    Thread.sleep(2000);

}
@Then("BankAdminUser search the RegisteUser by EmailID")
public void Bankadminuser_search_the_RegisteUser_by_EmailID() throws Exception {

    Thread.sleep(2000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_AdminSearchBox, 20);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_AdminSearchBox, "Search field textBox");
    TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_AdminSearchBox, EmailID, "Search field textBox");
}

@Given("User Enters Name in Registration Page by using Excelsheetdata {string} and row number \"{int}\"")
public void user_Enters_Name_in_Registration_Page_by_using_Excelsheetdata_and_row_number(String UserRegisterationData, Integer int1) throws Exception {
   
    Name = TestBase.getFakeName();
	Thread.sleep(2000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_RegisterName, 20);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_RegisterName, "Name textBox");
	TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_RegisterName, Name, "Name textBox");
	
}

@Given("User Enters SurName in Registration Page by using Excelsheetdata {string} and row number \"{int}\"")
public void user_Enters_SurName_in_Registration_Page_by_using_Excelsheetdata_and_row_number(String UserRegisterationData, Integer int1) throws Exception {
    
	SurName = TestBase.getFakeLastname();
	Thread.sleep(2000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_registerSurname, 20);
	TestBase.clickonElement(SBV_Connect_PageObjects.SBV_registerSurname, "SurName textBox");
	TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_registerSurname, SurName, "SurName textBox");
}

@Given("AdminUser able to Review the user Details")
public void adminuser_able_to_Review_the_user_Details() throws Exception {

    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_NameTextfield, 20);
    String NamefieldValue = TestBase.getTextFromPropertis(SBV_Connect_PageObjects.SBV_NameTextfield);
    System.out.println(NamefieldValue);
    Assert.assertEquals(NamefieldValue, Name);

    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_SurnameTextfield, 20);
    String SurNameNamefieldValue = TestBase.getTextFromPropertis(SBV_Connect_PageObjects.SBV_SurnameTextfield);
    System.out.println(SurNameNamefieldValue);
    Assert.assertEquals(SurNameNamefieldValue, SurName);

    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_EmailTextfield, 20);
    String EmailfieldValue = TestBase.getTextFromPropertis(SBV_Connect_PageObjects.SBV_EmailTextfield);
    System.out.println(EmailfieldValue);
    Assert.assertEquals(EmailfieldValue, EmailID);
}
@When("User Log in Connect System By Entering UserName as {string} and password as {string}")
public void user_Log_in_Connect_System_By_Entering_UserName_as_and_password_as(String NationalMG_Username, String NationalMG_password) throws Exception {

    TestBase.waitForElement(SBV_Connect_Login_pageObject.SBV_Login_Email_Input, 10);
    TestBase.typeinTextBox(SBV_Connect_Login_pageObject.SBV_Login_Email_Input, NationalMG_Username, "Entered User Name");
    TestBase.waitForElement(SBV_Connect_Login_pageObject.SBV_Login_Password_Input, 10);
    TestBase.typeinTextBox(SBV_Connect_Login_pageObject.SBV_Login_Password_Input, NationalMG_password, "Entered Password");
    TestBase.waitForElement(SBV_Connect_Login_pageObject.SBV_Login_Button, 10);
    TestBase.clickonElement(SBV_Connect_Login_pageObject.SBV_Login_Button, "Clicked on Login Button");
}

@When("National Maneger User Verifies the Login into Connect System")
public void national_Maneger_User_Verifies_the_Login_into_Connect_System() throws Exception {

    String otpurl=Utils.getFileProperty("NationalManegerOTP_URL");
    pageBase.driver.get(otpurl);
    Otp=TestBase.getElementText(SBV_Connect_Login_pageObject.SBV_OTP, "Get OTP");
    Thread.sleep(2000);
}
@When("Branch Manager User Verifies the Login into Connect System")
public void Branch_Manager_User_Verifies_the_Login_into_Connect_System() throws Exception {

    String otpurl=Utils.getFileProperty("RegionalBranchManegerOTP_URL");
    pageBase.driver.get(otpurl);
    Otp=TestBase.getElementText(SBV_Connect_Login_pageObject.SBV_OTP, "Get OTP");
    Thread.sleep(2000);
}
@When("Regional Manager User Verifies the Login into Connect System")
public void Regional_Manager_User_Verifies_the_Login_into_Connect_System() throws Exception {

    String otpurl=Utils.getFileProperty("RegionalManager_URL");
    pageBase.driver.get(otpurl);
    Otp=TestBase.getElementText(SBV_Connect_Login_pageObject.SBV_OTP, "Get OTP");
    Thread.sleep(2000);
}

@And("User Close the Tab {string}")
public void user_Close_the_Tab(String TabNumber) throws Exception {
    int tabnumber=Integer.parseInt(TabNumber);
    TestBase.windowHandle(tabnumber, "Navigate to Login page");
    Thread.sleep(2000);
}

@Given("User Enters Name in Registration Page")
public void user_Enters_Name_in_Registration_Page() throws Exception {

    Thread.sleep(2000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_RegisterName, 20);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_RegisterName, "Name textBox");
    TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_RegisterName, Name, "Name textBox");
}

@Given("User Enters SurName in Registration Page")
public void user_Enters_SurName_in_Registration_Page() throws Exception {

    Thread.sleep(2000);
    TestBase.waitForElement(SBV_Connect_PageObjects.SBV_registerSurname, 20);
    TestBase.clickonElement(SBV_Connect_PageObjects.SBV_registerSurname, "SurName textBox");
    TestBase.typeinTextBox(SBV_Connect_PageObjects.SBV_registerSurname, SurName, "SurName textBox");
}

@When("Call Center Agent User Verifies the Login into Connect System")
public void Call_Center_Agent_User_Verifies_the_Login_into_Connect_System() throws Exception {

    String otpurl=Utils.getFileProperty("CallCenterAgentOTP_URL");
    pageBase.driver.get(otpurl);
    Otp=TestBase.getElementText(SBV_Connect_Login_pageObject.SBV_OTP, "Get OTP");
    Thread.sleep(2000);
}
@When("Call Center Manager User Verifies the Login into Connect System")
public void Call_Center_Manager_User_Verifies_the_Login_into_Connect_System() throws Exception {

    String otpurl=Utils.getFileProperty("CallCenterManegerOTP_URL");
    pageBase.driver.get(otpurl);
    Otp=TestBase.getElementText(SBV_Connect_Login_pageObject.SBV_OTP, "Get OTP");
    Thread.sleep(2000);
}

@Then("Bank Executive User Verifies the Login into Connect System")
public void bank_Executive_User_Verifies_the_Login_into_Connect_System() throws Exception {

    String otpurl=Utils.getFileProperty("BankExecutiveOTP_URL");
    pageBase.driver.get(otpurl);
    Otp=TestBase.getElementText(SBV_Connect_Login_pageObject.SBV_OTP, "Get OTP");
    Thread.sleep(2000);
}

@Given("National User Verifies the Login into Connect System")
public void National_User_Verifies_the_Login_into_Connect_System() throws Exception {
	String otpurl=Utils.getFileProperty("National_OTP_URL");
	pageBase.driver.get(otpurl);
	Otp=TestBase.getElementText(SBV_Connect_Login_pageObject.SBV_OTP, "Get OTP");
	Thread.sleep(2000);
}
}

