package SBV_pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SBV_Connect_CommonPageObject {

	    public static final By SBV_Log_New_Case_Button = By.xpath("//button[contains(text(),'Log a new case')]");
	    public static final By SBV_query_menu = By.xpath("//select[@name='pbSelect0']");
//	    public static final By SBV_inner_frame = By.xpath("//iframe[@src='https://connect-uat.sbv.co.za/bonita/portal/form/process/Log%20a%20Query/5.6?app=SBVConnect']");
	    public static final By SBV_inner_frame = By.xpath("//iframe[contains(@src,'https://connect-uat.sbv.co.za/bonita/portal/form/process/Log%20a%20Query/')]");
	    public static final By SBV_query_option = By.xpath("//option[contains(text(),'STATIONERY')]");
	    public static final By SBV_query_sub_menu = By.name("pbSelect1");
	    public static final By SBV_Query_Sub_Type = By.xpath("//option[contains(text(),'REQUEST STATIONERY ORDER')]");
	    public static final By SBV_click_next_button = By.xpath("//button[contains(text(),'Next')]");
	    public static final By SBV_type_search_key = By.xpath("//input[@name='pbInput0']");
	    public static final By SBV_click_search_button = By.xpath("//button[contains(text(),'Search')]");
	    public static final By SBV_Select_Cash_Center=By.xpath("//div[contains(text(),'ABAFOKAZANE DAIRY DI')]");
	    public static final By SBV_Select_Cash_Center_Internal=By.xpath("//div[contains(text(),'TIGRAROX-GLOBAL MOLOANTOA-VAAL')]");
	    public static final By SBV_CIT_Number=By.xpath("//input[@name='pbInput1']");
	    public static final By SBV_Region=By.xpath("//input[@name='pbInput2']");
	    public static final By SBV_Cash_Center=By.xpath("//input[@name='pbInput3']");
	    public static final By SBV_Cash_Center_Internal=By.xpath("//select[@name='pbSelect4' or @name='pbSelect2']");
	    public static final By SBV_Bank=By.xpath("//select[@name='pbSelect2']");
	    public static final By SBV_Select_Date = By.xpath("//span[contains(text(),'Today')]");
	    public static final By SBV_AddFile = By.xpath("//button[contains(text(),'Add File')]");
	    public static final By SBV_Submit_Button = By.xpath("//button[contains(text(),'Submit')]");
	    public static final By SBV_Logcase_Successful_Message=By.xpath("//iframe[@id='bonitaframe'][1]");
	    public static final By SBV_logout = By.xpath("//*[contains(text(),' Logout ')]");
	    public static final By SBV_Add_Notes = By.xpath("//textarea[@name='pbTextArea0']");
	    public static final By CaseList=By.xpath("//*[contains(text(),' Case List ')]");
		public static final By SBV_LatestCaseNumber = By.xpath("(//span[contains(text(),'Case ID')]/following::tbody/tr/td[1]/child::div)[1]");
		public static final By SBV_LatestCasenumber = By.xpath("(//span[contains(text(),'Case ID')]/following::tbody/tr/td[4])[1]");
		
		public static final By SBV_LatestCaseNumber_Reporting = By.xpath("(//div[text()='REPORTING']/parent::td/parent::tr)[1]");
	    public static final By SBV_Select_CashcenterRegional=By.xpath("(//div[@class='ng-binding ng-scope'])[11]");

		public static final By SBV_GetCaseid = By.xpath("(//div[@class='ng-binding ng-scope'])[1]");
	    public static final By SBV_see_case_list = By.xpath("//*[contains(text(),' Case List ')]");
	    public static final By SBV_view_task_list = By.xpath("//button[contains(text(),'View Task List')]");
	    public static final By SBV_Task_list = By.xpath("//*[contains(text(),' Task List ')]");
	    public static final By SBV_SearchByinput = By.xpath("(//div//input[@type='text'])[1]");
	    public static final By SBV_SearchByinput_olga = By.xpath("//div//input[@name='pbInput0']");
	    public static final By SBV_New_Case = By.linkText("New Case");
	    public static final By SBV_RTL_Review = By.linkText("RTL Review");
	    public static final By SBV_update_Case = By.linkText("Update Case");

	    public static final By userassignstatus=By.xpath("//*[contains(text(),'Case successfully reassigned')]");
	    public static final By SBV_Reginaluser=By.xpath("//div[text()='Olgar']");
	    public static final By SBV_selectlocationDopdown=By.xpath("(//div[@class='col-xs-12']/select)[2]");
        public static final By SBV_sortdatewiseDesc=By.xpath("(//span[text()='Log Date'])[1]");
	    public static final By SBV_openCasestatus= By.xpath("(//*[contains(text(),'In Progress')])[10]");
	    public static final By ResolvedCasestatus= By.xpath("(//*[contains(text(),'Resolved')])[2]");
	    public static final By SBV_ClosedCasestatus= By.xpath("(//*[contains(text(),'Closed')])[2]");
	    public static final By OpenCasebutton=By.xpath("//*[contains(text(),'Open Cases')]");
	    public static final By ResolvedCasebutton=By.xpath("//*[contains(text(),'Resolved Cases')]");
	    public static final By ClosedCasebutton=By.xpath("//*[contains(text(),'Closed Cases')]");
        public static final By NoDatastatus = By.xpath("(//*[contains(text(),'No data available, kindly choose a new selection criteria')])[1]");
	    public static final By InProgressStatus=By.xpath("//span[contains(text(),'In Progress')]");
	    public static final By AwaitingFeedbackStatus=By.xpath("//span[contains(text(),'Awaiting Feedback')]");

	    public static final By SBV_Resolution_Dropdown=By.xpath("//select[@name='pbSelect2']");
	    public static final By SBV_Business_workflow_Dropdown=By.xpath("//select[@name='pbSelect3']");
	    public static final By SBV_Responsible_party_Dropdown=By.xpath("//select[@name='pbSelect4']");
	    public static final By SBV_Status=By.xpath("//select[@name='pbSelect5']");
	    public static final By SBV_Update = By.xpath("//button[contains(text(),'Update')]");
	    
	    public static final By SBV_UpdateCase = By.linkText("Update Case");
	    public static final By SBV_FeedbackRequired = By.linkText("Feedback Required");
	    public static final By SBV_PauseApporval = By.linkText("Pause Approval");
	    public static final By SBV_ReviewCompletion = By.linkText("Review Completion");
	    public static final By SBV_CompleteSurvey = By.linkText("Complete Survey");
	    public static final By SBV_RTLIntervention = By.linkText("RTL Intervention");
	    public static final By SBV_NCSIntervention = By.linkText("NCS Intervention");
	    public static final By SBV_NCSMIntervention = By.linkText("NCSM Intervention");

	    public static final By SBV_AuditTrail = By.xpath("//a//tab-heading[contains(text(),'Audit Trail')]");
	    public static final By SBV_Admin = By.xpath("//a//tab-heading[contains(text(),'Admin')]");
	    public static final By SBV_UserLevel=By.xpath("//select[@name='pbSelect0']");
	    public static final By SBV_CashCenter=By.xpath("//select[@name='pbSelect1']");
	    public static final By SBV_Tholana=By.xpath("//div[text()='Tholoana']");
		public static final By SBV_OLga=By.xpath("//div[text()='Olgar']");
	    public static final By SBV_Assign = By.xpath("//button[contains(text(),'Assign')]");
		public static final By SBV_Lauren_Lau=By.xpath("//div[text()='Laureen Lau']");
        public static final By SBV_Bonny=By.xpath("//div[text()='Bonny']");
        public static final By SBV_Uploadfile1=By.xpath("//input[@name='pbUpload0' and @type='file']");
        public static final By SBV_Uploadfile2=By.xpath("//input[@name='pbUpload1' and @type='file']");
        public static final By SBV_Uploadfile3=By.xpath("//input[@name='pbUpload2' and @type='file']");
        public static final By SBV_Uploadfile4=By.xpath("//input[@name='pbUpload3' and @type='file']");
        public static final By SBV_Uploadfile5=By.xpath("//input[@name='pbUpload4' and @type='file']");
        public static final By SBV_Uploadfile6=By.xpath("//input[@name='pbUpload5' and @type='file']");
        public static final By SBV_Uploadfile7=By.xpath("//input[@name='pbUpload6' and @type='file']");
        public static final By SBV_Uploadfile8=By.xpath("//input[@name='pbUpload7' and @type='file']");
        public static final By SBV_Uploadfile9=By.xpath("//input[@name='pbUpload8' and @type='file']");
        public static final By SBV_Uploadfile10=By.xpath("//input[@name='pbUpload9' and @type='file']");
	    public static final String SBV_MyFrame="myFrame";
	    		
	    public static By SelectWithoption(String text) {
	
	  final By textXpath = By.xpath("//option[text()='"+text+"']");
	  return textXpath;
	
     }
     public static By SelectWithoptions(String text) {
    		
   	  final By textXpath = By.xpath("//li//div[text()='"+text+"']");
   	  return textXpath;
   	
        }
}