package gluecode;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Sample_PageObjects;
import testBase.TestBase;
import testBase.pageBase;
import utilities.ExceptionHandling;
import utilities.Utils;

public class Sample {

	@Given("Enter the Url")
	public void enter_the_Url() {
	  pageBase.OpenBrowser("Browser");
	  String url=Utils.getFileProperty("URL");
	  pageBase.driver.get(url);
	  
	}

	@And("Enter User Name")
	public void enter_User_Name() throws Exception {
	    String UserName=Utils.getFileProperty("Username");
	    TestBase.waitForElement(Sample_PageObjects.UserName, 20);
	    TestBase.typeinTextBox(Sample_PageObjects.UserName, UserName, "UserName");
	}

	@And("Enter Password")
	public void enter_Password() throws Exception {
		String Password=Utils.getFileProperty("password");
	    TestBase.waitForElement(Sample_PageObjects.Password, 20);
	    TestBase.typeinTextBox(Sample_PageObjects.Password, Password, "Password");
	}

	@When("Click on Login Button")
	public void click_on_Login_Button() throws Exception {
		TestBase.waitForElement(Sample_PageObjects.Sign_Button, 20);
	   TestBase.clickonElement(Sample_PageObjects.Sign_Button, "Sign In Button");
	   
	}

	@Then("Verify Home Page")
	public void verify_Home_Page() throws Exception {
	   String verifyHomePage="You are successfully logged in.";
	   TestBase.waitForElement(Sample_PageObjects.VerifyHomePage, 20);
	String verify=   TestBase.getElementText(Sample_PageObjects.VerifyHomePage, "verifyHomePage");
	   if(verify.contentEquals(verifyHomePage)) {
		   System.out.println("Successfully verified Home Page");
		   
	   }else {
		   ExceptionHandling.HandleAssertion("Unable to navigate Home Page");
	   }
	}
}
