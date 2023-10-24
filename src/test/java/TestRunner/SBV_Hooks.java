package TestRunner;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import SBV_testBase.TestBase;
import SBV_testBase.pageBase;
import SBV_utility.ExceptionHandling;
import SBV_utility.Logs;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class SBV_Hooks extends pageBase{

	@Before
	public void BeforeScenario(Scenario scenario) throws Exception {
		try {
			TestBase.TestCaseName=scenario.getName();
			Logs.startTestCase(TestBase.TestCaseName);
			
		}catch(Exception e) {
			ExceptionHandling.HandleExecption(e, "Unable to run before scenario");
		}
	}
	
	@After
	public void AfterScenario(Scenario scenario) throws Exception {
		try {
			if(scenario.isFailed()) {
				final byte[] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshot, "image/png", "image");
				System.out.println("After Hook");
			}
			Logs.endTestCase();
			pageBase.tearDown();
			
		}catch(Exception e) {
			ExceptionHandling.HandleExecption(e, "Unable to run After scenario");
		}
	}
	
}
