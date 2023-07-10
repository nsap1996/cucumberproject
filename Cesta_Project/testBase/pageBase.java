package testBase;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

import utilities.ExceptionHandling;
import utilities.Utils;

public class pageBase {

	public static WebDriver driver;
	public static String sBrowserName;
	public static WiniumDriver winDriver;
	public static String Windows;
	
	public static WebDriver OpenBrowser(String BrowserType) {
		sBrowserName= Utils.getFileProperty(BrowserType);
		try {
			if(sBrowserName.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				driver = new ChromeDriver(options);
				driver.manage().window().maximize();
				
			}
		}catch(Exception e) {
			
				System.out.println("Error in Launching Browser"+e.toString());
				ExceptionHandling.HandleAssertion("Failed to Launch Browser"+e.toString());
			}
		
		
		
		return driver;
		
	}
	
	public static WebDriver tearDown() {
		
		try {
			driver.quit();
		}catch(Exception e) {
			ExceptionHandling.HandleAssertion("Failed to Close Browser "+e.toString());
		}
		return driver;
		
	}
}
