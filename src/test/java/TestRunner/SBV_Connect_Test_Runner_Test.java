package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="SBV_Connect_Automation/SBV_features",
//		tags= {"@DailyRegression"},
		tags= {"@DailyRegression or @WeeklyRegression"},
		glue={"SBV_glueCode", "TestRunner"},
		plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","progress","summary"},
		monochrome= true,
		strict=true
		)
public class SBV_Connect_Test_Runner_Test {

}
