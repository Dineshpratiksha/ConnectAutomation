package SBV_pageObjects;

import org.openqa.selenium.By;

public class SBV_Connect_Login_pageObject {

	public static final By  SBV_Login_Email_Input=By.xpath("//input[@id='email']");
	public static final By SBV_Login_Password_Input=By.xpath("//input[@id='password']");
	public static final By SBV_Login_Button=By.xpath("//button[@id='loginButton']");
	public static final By SBV_OTP= By.xpath("//th[contains(text(),'OTT')]/following::tr/td[3]");
	public static final By SBV_OTPexternal= By.xpath("(//th[contains(text(),'OTT')]/following::tr/td[3])[2]");
	public static final By SBV_OTP_Enter_Input=By.cssSelector("input[id*='otp_0']");
	public static final By SBV_OTP_Login_Button=By.xpath("//button[contains(text(),' Login ')]");
	public static final By SBV_Verifyhomepage=By.xpath("//div[@class='container-fluid']/h1");
    public static final By SBV_AuthenticationFailed=By.xpath("(//div[@class='alert alert-danger alert-dismissable alert-style container mt-4'])[2]");
    public static final By SBV_logout = By.xpath("//*[contains(text(),' Logout ')]");
    public static final By SBV_OTPPage_Validation=By.xpath("//h5[contains(text(),'One Time Pin')]");


}
