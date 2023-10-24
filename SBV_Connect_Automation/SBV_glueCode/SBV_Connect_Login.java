package SBV_glueCode;

import SBV_pageObjects.SBV_Connect_CommonPageObject;
import SBV_pageObjects.SBV_Connect_Login_pageObject;
import SBV_testBase.TestBase;
import SBV_testBase.pageBase;
import SBV_utility.Excel_Utility;
import SBV_utility.ExceptionHandling;
import SBV_utility.Utils;
import io.cucumber.java.en.*;

public class SBV_Connect_Login {
	public static String filepath = "./TestData/TestData_Excel/SBV_connectTestData.xlsx";
    public static String sheetName = "ConnectTestDeta";
	
	
@Given("User Click on Login button on Connect Login Page as ExternalUser")
public void user_Click_on_Login_button_on_Connect_Login_Page_as_ExternalUser() throws Exception {
	
    Thread.sleep(15000);

    if(TestBase.isElementVisible(SBV_Connect_Login_pageObject.SBV_OTP_Enter_Input, "Login Authentication")){
        Thread.sleep(2000);
        TestBase.NavigateToNewTab(0, "Navigate to new tab");
        Thread.sleep(2000);
        String otpurl=Utils.getFileProperty("OTPApplication_URL");
        pageBase.driver.get(otpurl);
        String Otp=TestBase.getElementText(SBV_Connect_Login_pageObject.SBV_OTP, "Get OTP");
        Thread.sleep(2000);
        TestBase.windowHandles(0, "Navigate to Login page");
        Thread.sleep(4000);
        TestBase.waitForElement(SBV_Connect_Login_pageObject.SBV_OTP_Enter_Input, 10);
        TestBase.typeinTextBox(SBV_Connect_Login_pageObject.SBV_OTP_Enter_Input, Otp, "Entered OTP");
        pageBase.driver.switchTo().defaultContent();
        Thread.sleep(5000);
        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_logout, 30); 
        TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_logout, "Logout ");

    }else if(TestBase.isElementVisible(SBV_Connect_Login_pageObject.SBV_AuthenticationFailed, "Authentication failed mesage")){

 

    System.out.println("Invalid Crendentials");
    }else
    {
        ExceptionHandling.HandleAssertion("Please Enter Login Credentials");
    }
}

@Given("External User able to Login into Connect System with External_Username and External_password")
public void external_User_able_to_Login_into_Connect_System_with_External_Username_and_External_password() throws Exception {
//	pageBase.OpenBrowser("Browser");
	String url=Utils.getFileProperty("Application_SBV_ConnectURL");
	pageBase.driver.get(url);
	
	Excel_Utility.setExcelFile(filepath, sheetName);
    String External_Username = Excel_Utility.getCellData(1, 0);
    String External_password = Excel_Utility.getCellData(1, 1);
    
    TestBase.waitForElement(SBV_Connect_Login_pageObject.SBV_Login_Email_Input, 10);
	TestBase.typeinTextBox(SBV_Connect_Login_pageObject.SBV_Login_Email_Input, External_Username, "Entered User Name");
	TestBase.waitForElement(SBV_Connect_Login_pageObject.SBV_Login_Password_Input, 10);
	TestBase.typeinTextBox(SBV_Connect_Login_pageObject.SBV_Login_Password_Input, External_password, "Entered Password");
	TestBase.waitForElement(SBV_Connect_Login_pageObject.SBV_Login_Button, 10);
	TestBase.clickonElement(SBV_Connect_Login_pageObject.SBV_Login_Button, "Clicked on Login Button");
	
}


@When("External User able to Login into Connect System with {string} and {string}")
public void external_User_able_to_Login_into_Connect_System_with_and(String ExternalUsername, String Externalpassword) throws Exception {

	String url=Utils.getFileProperty("Application_SBV_ConnectURL");
	pageBase.driver.get(url);
	TestBase.waitForElement(SBV_Connect_Login_pageObject.SBV_Login_Email_Input, 50);
	TestBase.typeinTextBox(SBV_Connect_Login_pageObject.SBV_Login_Email_Input, ExternalUsername, "Entered User Name");
	TestBase.waitForElement(SBV_Connect_Login_pageObject.SBV_Login_Password_Input, 50);
	TestBase.typeinTextBox(SBV_Connect_Login_pageObject.SBV_Login_Password_Input, Externalpassword, "Entered Password");
	TestBase.waitForElement(SBV_Connect_Login_pageObject.SBV_Login_Button, 50);
	TestBase.clickonElement(SBV_Connect_Login_pageObject.SBV_Login_Button, "Clicked on Login Button");
}
@When("Internal User able to Login into Connect System with {string} and {string}")
public void internal_User_able_to_Login_into_Connect_System_with_and(String InternalUsername, String Internalpassword) throws Exception {

String url=Utils.getFileProperty("Application_SBV_ConnectURL");
pageBase.driver.get(url);
TestBase.waitForElement(SBV_Connect_Login_pageObject.SBV_Login_Email_Input, 50);
TestBase.typeinTextBox(SBV_Connect_Login_pageObject.SBV_Login_Email_Input, InternalUsername, "Entered User Name");
TestBase.waitForElement(SBV_Connect_Login_pageObject.SBV_Login_Password_Input, 50);
TestBase.typeinTextBox(SBV_Connect_Login_pageObject.SBV_Login_Password_Input, Internalpassword, "Entered Password");
TestBase.waitForElement(SBV_Connect_Login_pageObject.SBV_Login_Button, 50);
TestBase.clickonElement(SBV_Connect_Login_pageObject.SBV_Login_Button, "Clicked on Login Button");
}


@Given("Internal User able to Login into Connect System with Internal_Username and Internal_password")
public void internal_User_able_to_Login_into_Connect_System_with_Internal_Username_and_Internal_password() throws Exception {
//	pageBase.OpenBrowser("Browser");
	
	String url=Utils.getFileProperty("Application_SBV_ConnectURL");
	pageBase.driver.get(url);
	
	Excel_Utility.setExcelFile(filepath, sheetName);
    String Internal_Username = Excel_Utility.getCellData(1, 2);
    String Internal_password = Excel_Utility.getCellData(1, 3);
    
	TestBase.waitForElement(SBV_Connect_Login_pageObject.SBV_Login_Email_Input, 50);
	TestBase.typeinTextBox(SBV_Connect_Login_pageObject.SBV_Login_Email_Input, Internal_Username, "Entered User Name");
	TestBase.waitForElement(SBV_Connect_Login_pageObject.SBV_Login_Password_Input, 50);
	TestBase.typeinTextBox(SBV_Connect_Login_pageObject.SBV_Login_Password_Input, Internal_password, "Entered Password");
	TestBase.waitForElement(SBV_Connect_Login_pageObject.SBV_Login_Button, 50);
	TestBase.clickonElement(SBV_Connect_Login_pageObject.SBV_Login_Button, "Clicked on Login Button");
	
}

      @Given("User Click on Login button on Connect Login Page as InternalUser")
       public void user_Click_on_Login_button_on_Connect_Login_Page_as_InternalUser() throws Exception {

    	  Thread.sleep(15000);

    	    if(TestBase.isElementVisible(SBV_Connect_Login_pageObject.SBV_OTP_Enter_Input, "Login Authentication")){
    	        Thread.sleep(2000);
    	        TestBase.NavigateToNewTab(0, "Navigate to new tab");
    	        Thread.sleep(2000);
    	        String otpurl=Utils.getFileProperty("OTPApplication_URL");
    	        pageBase.driver.get(otpurl);
    	        String Otp=TestBase.getElementText(SBV_Connect_Login_pageObject.SBV_OTP, "Get OTP");
    	        Thread.sleep(2000);
    	        TestBase.windowHandles(0, "Navigate to Login page");
    	        Thread.sleep(4000);
    	        TestBase.waitForElement(SBV_Connect_Login_pageObject.SBV_OTP_Enter_Input, 50);
    	        TestBase.typeinTextBox(SBV_Connect_Login_pageObject.SBV_OTP_Enter_Input, Otp, "Entered OTP");
    	        pageBase.driver.switchTo().defaultContent();
    	        Thread.sleep(5000);
    	        TestBase.waitForElement(SBV_Connect_CommonPageObject.SBV_logout, 50); 
    	        TestBase.clickonElement(SBV_Connect_CommonPageObject.SBV_logout, "Logout ");

    	    }else if(TestBase.isElementVisible(SBV_Connect_Login_pageObject.SBV_AuthenticationFailed, "Authentication failed mesage")){

    	 

    	    System.out.println("Invalid Crendentials");
    	    }else
    	    {
    	        ExceptionHandling.HandleAssertion("Please Enter Login Credentials");
    	    }
    	}
      @Given("User Click on Login button on Connect Login Page as Externaluser")
      public void user_Click_on_Login_button_on_Connect_Login_Page_as_Externaluser() throws Exception {

      TestBase.waitForElement(SBV_Connect_Login_pageObject.SBV_Login_Button, 10);
      TestBase.clickonElement(SBV_Connect_Login_pageObject.SBV_Login_Button, "Clicked on Login Button");
      Thread.sleep(2000);
     if((TestBase.isElementVisible(SBV_Connect_Login_pageObject.SBV_AuthenticationFailed, "AuthenticationFailed")))
     {
	    System.out.println("User not on SBV Connect page");
      }
 else {
	Thread.sleep(2000);
   TestBase.NavigateToNewTab(0, "Navigate to new tab");
   Thread.sleep(2000);
	String otpurl=Utils.getFileProperty("OTPApplication_URL");
	pageBase.driver.get(otpurl);
	String Otp=TestBase.getElementText(SBV_Connect_Login_pageObject.SBV_OTP, "Get OTP");
	Thread.sleep(2000);
	TestBase.windowHandles(0, "Navigate to Login page");
	Thread.sleep(1000);
	TestBase.waitForElement(SBV_Connect_Login_pageObject.SBV_OTP_Enter_Input, 10);
	TestBase.typeinTextBox(SBV_Connect_Login_pageObject.SBV_OTP_Enter_Input, Otp, "Entered OTP");
}
}
      
}

     

	
	
