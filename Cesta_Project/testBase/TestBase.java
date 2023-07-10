package testBase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ExceptionHandling;
import utilities.Logs;

public class TestBase extends pageBase {
	
	public static String TestCaseName;
	
	public static void waitForElement(By locator, long ltime) throws Exception {
		try {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(ltime));
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			
		}catch(Exception e) {
			ExceptionHandling.HandleExecption(e, "Element not available");
		}
	}
	
	public static void typeinTextBox(By locator , String data,String elementName) throws Exception {
		try {
			if(driver.findElement(locator).isDisplayed()) {
				driver.findElement(locator).clear();
				driver.findElement(locator).sendKeys(data);
				Logs.info("Text Entered into "+elementName);
			}else {
				Logs.info("Unable to enter text into "+elementName);
			}
		}catch(Exception e) {
			ExceptionHandling.HandleExecption(e, "Unable to Identify text field ");
		}
	}
	
	public static void clickonElement(By locator, String elementName) throws Exception {
		boolean bflag=false;
		try {
			if(driver.findElement(locator).isDisplayed()) {
				driver.findElement(locator).click();
				bflag=true;
				Logs.info("Clicked on "+elementName);
			}
			else {
				Logs.info("Unable to click on  "+elementName);
			}
			
		}catch(Exception e) {
			ExceptionHandling.HandleExecption(e, "Unable to click on element "+elementName);
		}
	}
	public static void JsclickonElement(By locator, String elementName) throws Exception {
		boolean bflag=false;
		try {
			if(driver.findElement(locator).isDisplayed()) {
				bflag=true;
				JavascriptExecutor executor=(JavascriptExecutor) driver;
				executor.executeAsyncScript("arguments[0].click();", driver.findElement(locator));
				Logs.info("Click on  "+elementName);
			}
			else {
				Logs.info("Unable to click on  "+elementName);
			}
			
		}catch(Exception e) {
			ExceptionHandling.HandleExecption(e, "Unable to click on element "+elementName);
		}
	}
	public static String getElementText(By locator, String elementName) throws Exception {
		String sText="";
		try {
			if(driver.findElement(locator).isDisplayed()) {
				sText=driver.findElement(locator).getText();
				Logs.info("Text got from "+elementName);
			}else
			{
				Logs.info("Unable to get Text from "+elementName);
			}
			
		}catch(Exception e) {
			ExceptionHandling.HandleExecption(e, "Unable to get text from element"+elementName);
		}
		return sText;
	}
}
