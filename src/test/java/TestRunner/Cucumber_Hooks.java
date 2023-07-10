package TestRunner;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import testBase.TestBase;
import testBase.pageBase;
import utilities.ExceptionHandling;
import utilities.Logs;

public class Cucumber_Hooks extends pageBase{

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
