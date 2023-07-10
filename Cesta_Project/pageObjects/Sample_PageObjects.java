package pageObjects;

import org.openqa.selenium.By;

public class Sample_PageObjects {

	public static final By UserName=By.id("inputUsername");
	public static final By Password=By.name("inputPassword");
	public static final By Sign_Button=By.className("signInBtn");
	public static final By VerifyHomePage=By.xpath("//p[text()='You are successfully logged in.']");
}
