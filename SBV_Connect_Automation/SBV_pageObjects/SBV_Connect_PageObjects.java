package SBV_pageObjects;

import org.openqa.selenium.By;

public class SBV_Connect_PageObjects {
	
	public static final By SBV_Stoploss=By.xpath("//input[@name='pbInput5']");
    public static final By SBV_BagSeal=By.xpath("//input[@name='pbInput6']");
    public static final By SBV_Container=By.xpath("//input[@name='pbInput8']");
    public static final By SBV_Value=By.xpath("//input[@name='pbInput7']");
    public static final By SBV_EnterComment=By.xpath("//div//textarea[@name='pbTextArea0']");
    public static final By SBV_SubmitComment=By.xpath("//button[text()='Submit Comment']");

    
    public static final By SBV_Stoploss_errorMessage=By.xpath("//input[@name='pbInput5']/following::div");
    public static final By SBV_BagSeal_errorMessage=By.xpath("//input[@name='pbInput6']/following::div");
    public static final By SBV_Container_errorMessage=By.xpath("//input[@name='pbInput8']/following::div");
    public static final By SBV_Value_errorMessage=By.xpath("(//input[@name='pbInput7']/following::p)[3]");
    public static final By SBV_Date_And_TimeStamp1=By.xpath("(//h5[text()='Case Audit Trail']//following::div)[3]");

    
    
    public static final By CaseIDDesc=By.xpath("//*[contains(text(),'Case ID')]");
    public static final By AllCases=By.xpath("//*[contains(text(),'All Cases')]");

    //external dashbord
    public static final By SBV_Dashboard = By.xpath("//*[contains(text(),' Dashboard ')]");
    public static final By SBV_Dashboard_CasesByType = By.xpath("(//div[@class='chart-container']/following::canvas)[2]");
    public static final By SBV_Dashboard_CasesByChannel = By.xpath("(//div[@class='chart-container']/following::canvas)[3]");
    public static final By SBV_Dashboard_CasesByCashCentre = By.xpath("(//div[@class='chart-container']/following::canvas)[4]");
    public static final By SBV_Dashboard_CasesByAge = By.xpath("(//div[@class='chart-container']/following::canvas)[5]");
    public static final By SBV_New_Case=By.xpath("//a[contains(text(),'New Case')]");
    public static final By SBV_Log_New_Case=By.xpath("//*[contains(text(),'Log a new case') or contains(text(),'New Case ')] ");
    public static final By SBV_ViewDashboard = By.xpath("//button[contains(text(),'View Dashboard')]");
    public static final By SBV_CaseNumber=By.xpath("(//p[@class='text-left'])[31]");
    public static final By SBV_TotalCasesLogged=By.xpath("(//p[@class='text-left'])[6]");
    public static final By SBV_TotalCasesOpen=By.xpath("(//p[@class='text-left'])[7]");
    public static final By SBV_TotalCasesCompleted=By.xpath("(//p[@class='text-left'])[8]");
    public static final By SBV_Selectfilters = By.xpath("//button[@class='ng-binding btn btn-primary']/span");
    public static final By SBV_StartDate=By.xpath("//input[@name='pbDatepicker0']");
    public static final By SBV_Region_Filters=By.xpath("//select[@name='pbSelect0' or @name='pbSelect16']");
    public static final By SBV_ExternalCashcentre=By.xpath("//select[@name='pbSelect2']");    
    public static final By SBV_CaseType=By.xpath("//select[@name='pbSelect1' or @name='pbSelect17']");
    public static final By SBV_External_CaseSubType=By.xpath("//select[@name='pbSelect3' or @name='pbSelect19']");
    public static final By SBV_ConsumerType=By.xpath("//select[@name='pbSelect2']");
    public static final By SBV_TranscatingBank=By.xpath("//select[@name='pbSelect3']");
    public static final By SBV_CITCarrier=By.xpath("//select[@name='pbSelect3']");
    public static final By SBV_Search_field=By.xpath("(//input[@type='text'])[3]");
    public static final By SBV_Apply_Filters=By.xpath("//button[contains(text(),'Apply Filters')]");
    public static final By SBV_See_All=By.xpath("(//a[contains(text(),'See all')])[1]");
    public static final By SBV_SortBy=By.xpath("//select[@name='pbSelect0']");
    public static final By CaseList=By.xpath("//*[contains(text(),' Case List ')]");
    public static final By SBV_YesButton=By.xpath("(//input[@name='pbRadioBox0'])[1]");
	public static final By SBV_24=By.xpath("//select[@name='pbSelect4']");
	public static final By SBV_AcceptResolution=By.xpath("(//input[@name='pbRadioBox0'])[1]");
	public static final By SBV_RejectResolution=By.xpath("(//input[@name='pbRadioBox0'])[2]");
	public static final By SBV_UserLevel=By.xpath("//select[@name='pbSelect0']");
	public static final By SBV_Lauren_Lau=By.xpath("//div[text()='Laureen Lau']");
	public static final By SBV_Complete_Survey = By.linkText("Complete Survey");
	public static final By SBV_Questionone=By.xpath("//select[@name='pbSelect0']");
	public static final By SBV_QuestionTwo=By.xpath("//select[@name='pbSelect1']");
	public static final By SBV_QuestionThree=By.xpath("//textarea[@name='pbTextArea0']");
	public static final By SBV_Submit = By.xpath("//button[contains(text(),'Submit')]");
    //internal dashbord
    public static final By internalLognewcasebutton =By.xpath("//a[contains(text(),'New Case ')]");
    public static final By mytaskCase1=By.xpath("(//b[text()='Case ID']/following::p)[5]");
    public static final By mytaskCase2=By.xpath("(//b[text()='Case ID']/following::p)[9]");
    public static final By mytaskCase3=By.xpath("(//b[text()='Case ID']/following::p)[13]");
    public static final By mytaskCase4=By.xpath("(//b[text()='Case ID']/following::p)[17]");
    public static final By mytaskCase5=By.xpath("(//b[text()='Case ID']/following::p)[21]");
    public static final By Resolved_CaseNumber=By.xpath("(//td[@class='ng-scope']/div)[204]");
    public static final By Closed_CaseNumber=By.xpath("(//td[@class='ng-scope']/div)[224]");
    public static final By SBV_FileUpload1=By.xpath("//input[@name='pbUpload0' and @type='file']");
    public static final By SBV_FileUpload2=By.xpath("//input[@name='pbUpload1' and @type='file']");
    public static final By SBV_FileUpload3=By.xpath("//input[@name='pbUpload2' and @type='file']");
    public static final By SBV_FileUpload4=By.xpath("//input[@name='pbUpload3' and @type='file']");
    public static final By SBV_FileUpload5=By.xpath("//input[@name='pbUpload4' and @type='file']");
    public static final By SBV_FileUpload6=By.xpath("//input[@name='pbUpload5' and @type='file']");
    public static final By SBV_FileUpload7=By.xpath("//input[@name='pbUpload6' and @type='file']");
    public static final By SBV_FileUpload8=By.xpath("//input[@name='pbUpload7' and @type='file']");
    public static final By SBV_FileUpload9=By.xpath("//input[@name='pbUpload8' and @type='file']");
    public static final By SBV_FileUpload10=By.xpath("//input[@name='pbUpload9' and @type='file']");
    public static final By Allowedtimedropdown=By.xpath("(//select[@name='pbSelect5']/option)[2]");
    public static final By Allowedtime24=By.xpath("(//select[@name='pbSelect4']/option)[2]");
    public static final By Allowedtime48=By.xpath("(//select[@name='pbSelect4']/option)[3]");
    public static final By SBV_DownloadedFile1 = By.xpath("//a[contains(text(),'CSVFile.csv')]");
    public static final By SBV_DownloadedFile2 = By.xpath("//a[contains(text(),'pptxfile.pptx')]");
    public static final By SBV_DownloadedFile3 = By.xpath("//a[contains(text(),'Excelfile.xlsx')]");
    public static final By SBV_DownloadedFile4 = By.xpath("//a[contains(text(),'wordfile.docx')]");
    public static final By SBV_DownloadedFile5 = By.xpath("//a[contains(text(),'pptxfile.pptx')]");
    public static final By SBV_DownloadedFile6 = By.xpath("//a[contains(text(),'TextFileUpload.txt')]");
    public static final By SBV_DownloadedFile7 = By.xpath("//a[contains(text(),'Excelfile.xlsx')]");
    public static final By SBV_DownloadedFile8 = By.xpath("//a[contains(text(),'pptxfile.pptx')]");
    public static final By SBV_DownloadedFile9 = By.xpath("//a[contains(text(),'wordfile.docx')]");
    public static final By SBV_DownloadedFile10 = By.xpath("//a[contains(text(),'TextFileUpload.txt')]");

////////////////////////////////Register user pageobject////////////////////////////////
    public static final By SBV_RegisterNow = By.xpath("//div//a[text()='Register Now']");
    public static final By SBV_RegisterName = By.xpath("//label[text()='Name']/following::input");
    public static final By SBV_registerSurname = By.xpath("//label[text()='Surname']/following::input");
    public static final By SBV_RegisterEmail = By.xpath("//label[text()='Email']/following::input");
    public static final By SBV_RegisterContactNo = By.xpath("//label[text()='Contact Number']/following::input");
    public static final By SBV_RegisteraccepttermsCondition = By.xpath("//label//input[@id='tandc']");
    public static final By SBV_RegisterVerifyMailbutton = By.xpath("//div//button[text()=' Verify Email ']");
    public static final By SBV_RegisterMailVarification = By.xpath("//div[@class='d-flex justify-content-between align-items-end']");
    public static final By SBV_registerAccountpage = By.xpath("//h4[contains(text(),'User Account Details')]");
    public static final By SBV_registerUserTypeDropdown = By.xpath("//span[@class='dropdown-multiselect__caret']");
    public static final By SBV_registerUserSbvuser = By.xpath("//li//div[text()='SBV User']");
    public static final By SBV_registerUserRoledropdown = By.xpath("(//span[@class='dropdown-multiselect__caret'])[2]");
    public static final By SBV_registerUserNationalManeger = By.xpath("//li//div[text()='National Manager']");
  
    public static final By SBV_registerUserOrganisation = By.xpath("//label[text()='Organisation']/following::input");
    public static final By SBV_registerUserJobTitle = By.xpath("//label[text()='Job Title']/following::input");
    public static final By SBV_registerUserDepartment = By.xpath("//label[text()='Department']/following::input");
    public static final By SBV_registerUserLineManegerName = By.xpath("//label[text()='Line Manager Name']/following::input");
    public static final By SBV_registerUserLineManegerContact = By.xpath("//label[text()='Line Manager Contact Number']/following::input");
    public static final By SBV_registerUserpageNextbutton = By.xpath("//button[text()=' Next ']");
    public static final By SBV_registerUserpageCashcenterdropdown = By.xpath("(//span[@class='dropdown-multiselect__caret'])[2]");
    public static final By SBV_registerUserpageRequestAccessbutton = By.xpath("//*[contains(text(),' Request Access ')]");
    public static final By SBV_registerValue = By.xpath("//*[contains(text(),'Register')]");
    public static final By SBV_UserRegisterSuccess = By.xpath("//h5[text()='Thank you for registering with SBV Connect!']");
    
    public static final By SBV_ManageUserAccessbutton = By.xpath("(//div[@class='c-m'])[3]/button[1]");
    public static final By SBV_AdminSearchBox = By.xpath("(//label[text()='Search:']/child::input)[2]");
    public static final By SBV_latestregisteruser = By.xpath("(//tbody//tr[@class='odd'])[4]");
    public static final By SBV_latestregisteruserselect = By.xpath("(//tbody//tr[@class='odd selected'])");
   
    public static final By SBV_latestregisteuserstatus = By.xpath("//th[contains(text(),'User Status')]/following::tbody/tr/td[8]/span");
    public static final By SBV_ApprovalCuctomer = By.xpath("(//span[@class='dropdown-multiselect__caret'])[1]");
    public static final By SBV_ApprovalSiteType = By.xpath("(//span[@class='dropdown-multiselect__caret'])[2]");
    public static final By SBV_ApprovalSiteTypeBankuser = By.xpath("(//span[@class='dropdown-multiselect__caret'])[3]");
    public static final By SBV_ApprovalCashCenterBankuser = By.xpath("(//span[@class='dropdown-multiselect__caret'])[4]");
    public static final By SBV_ApprovalCashCenter = By.xpath("(//span[@class='dropdown-multiselect__caret'])[3]");
    public static final By SBV_ApprovalCommenttextbox = By.xpath("//div//label[text()='Comments']/following::input");
    public static final By SBV_ApprovalApprovebutton = By.xpath("//*[contains(text(),' Approve ')]");
    public static final By SBV_ApprovalApproveAddbutton = By.xpath("//button[text()='Add']");
    public static final By SBV_ApprovalAddfirstsite = By.xpath("(//tbody//tr[@class='odd'])[1]");
    public static final By SBV_ApprovalAddsecondsite = By.xpath("(//tbody//tr[@class='even'])[1]");
    public static final By SBV_ApprovalAddselectedsitebutton = By.xpath("//button[text()='Add Selected Sites']");
    
    public static final By SBV_SatisfyReviewDropdown = By.xpath("//select[@name='pbSelect0']");
    public static final By SBV_RateLevelDropdown = By.xpath("//select[@name='pbSelect1']");
    
    public static final By SBV_ForgotPassword_Email = By.xpath("//input[@id='inputDefault']");
    public static final By SBV_ForgotPassword_ResetPassword = By.xpath("//button[text()=' Reset Password ']");
    public static final By SBV_ForgotPassword= By.xpath("//*[contains(text(),'Forgot password')]");
    public static final By SBV_ForgotPassword_Password = By.xpath("//input[@id='inputPassword']");
    public static final By SBV_ForgotPassword_Re_Enter_Password = By.xpath("//input[@id='inputPasswordConfirm']");
    public static final By SBV_ForgotPassword_set_New_Password= By.xpath("//*[contains(text(),' Set New Password ')]");
    public static final By SBV_AccountSetCompleted = By.xpath("//h3[contains(text(),'Account Setup Completed')]");
    public static final By SBV_Return_to_login = By.xpath("//button[contains(text(),' Return To Login ')]");
    public static final By SBV_HomePage = By.xpath("//app-home[@class='ng-star-inserted']");
    public static final By SBV_InvalidPassword_error_message = By.xpath("//div[text()=' Your password must have one lower case, one upper case and one special character. ']");

      public static final By SBV_newPasswordinput = By.xpath("(//input[@type='password'])[1]");
      public static final By SBV_ReeneterPasswordinput = By.xpath("(//input[@type='password'])[2]");
      public static final By SBV_SetNewpassButton = By.xpath("//*[contains(text(),' Set New Password ') or contains(text(),' Finish Account Setup ')]");
      public static final By SBV_VerifyHomePage = By.xpath("//div/h1[contains(text(),'Home')]");


      public static final By SBV_CustomerReview1 = By.xpath("(//*[contains(text(),'Very satisfied')])[1]");
      public static final By SBV_CustomerReview2 = By.xpath("(//*[contains(text(),'Satisfied')])[1]");
      public static final By SBV_CustomerReview3 = By.xpath("(//*[contains(text(),'Not satisfied')])[1]");
      
      public static final By SBV_CustomerRateofReview1 = By.xpath("(//*[contains(text(),'Excellent')])[1]");
      public static final By SBV_CustomerRateofReview2 = By.xpath("(//*[contains(text(),'Good')])[1]");
      public static final By SBV_CustomerRateofReview3 = By.xpath("(//*[contains(text(),'Average')])[1]");
      public static final By SBV_CustomerRateofReview4 = By.xpath("(//*[contains(text(),'Bad')])[1]");
      public static final By SBV_CustomerRateofReview5 = By.xpath("(//*[contains(text(),'Unsatisfactory')])[1]");
      public static final By SBV_CustomerComment = By.xpath("//div[@class='col-xs-12']/textarea");
    
      public static final By SBV_NameTextfield = By.xpath("(//input[@type='text'])[1]");
      public static final By SBV_SurnameTextfield = By.xpath("(//div[@class='form-group']/input)[2]");
      public static final By SBV_EmailTextfield = By.xpath("(//div[@class='form-group']/input)[3]");
      public static final By SBV_RejectButton = By.xpath("//*[contains(text(),' Reject ')]");
      public static final By SBV_NoDatafound = By.xpath("//table[@id='userTable']/tbody/tr/td");
      public static final By SBV_DeactivateButton = By.xpath("//*[contains(text(),' Deactivate User ')]");
      public static final By SBV_ExistingUser = By.xpath("//*[contains(text(),'Existing Users')]");
      public static final By SBV_AwaitingApproval = By.xpath("//*[contains(text(),'Awaiting Approval')]");
      public static final By SBV_MyWorkCheckbox = By.xpath("//input[@type='checkbox']");
      public static final By SBV_searchResultatfilter = By.xpath("//tbody[@class='ng-scope']/tr[1]");
      public static final By SBV_NameColumn = By.xpath("//table[@id='userTable']/thead/tr/th[1]");
      public static final By SBV_profileTypeColumn = By.xpath("//table[@id='userTable']/thead/tr/th[4]");
      public static final By SBV_LastupdateColumn = By.xpath("//table[@id='userTable']/thead/tr/th[6]");
      public static final By SBV_CreatedOncolumn = By.xpath("//table[@id='userTable']/thead/tr/th[7]");
      public static final By SBV_UserStatusColumn = By.xpath("//table[@id='userTable']/thead/tr/th[8]");
      public static final By SBV_Profilesettingbuttion = By.xpath("//div[@class='mat-list-item-content']/div[3]");
      public static final By SBV_Profilesettingeditbuttion = By.xpath("(//*[contains(text(),'Edit')])[1]");
      public static final By SBV_ProfilesettingCashcenterDropdown = By.xpath("(//span[@class='dropdown-btn'])[4]");
      public static final By SBV_ProfilesettingCashcenterValue = By.xpath("//*[contains(text(),'Cape Town')]");
      public static final By SBV_ProfilesettingCashcenterper = By.xpath("//*[contains(text(),'Cash Centres Permission')]");
      public static final By SBV_ProfilesettingSavechangesbutton = By.xpath("(//*[contains(text(),' Save Changes ')])[3]");

      public static final By SBV_RegionDropd= By.xpath("//select[@name='pbSelect4']");
      public static final By SBV_Cashcentre= By.xpath("//select[@name='pbSelect6']");

      public static final By SBV_lastupdateTime = By.xpath("(//th[contains(text(),'User Status')]/following::tbody/tr/td[6])[1]");
}
