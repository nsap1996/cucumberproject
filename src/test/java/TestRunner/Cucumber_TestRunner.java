package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="Cesta_Project/features/Sample.feature",
		glue={"gluecode", "TestRunner"},
		plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","progress","summary"},
		monochrome= true
		)


public class Cucumber_TestRunner {

}
