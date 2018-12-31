package org.loginradius.com.classes.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
public class BaseTest {
	public WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	@BeforeClass
	public void setup () {
		System.setProperty("webdriver.chrome.driver", "C:/Users/vidya/Desktop/ExtentReportsExample-master/Drivers/chromedriver.exe");	
		driver = new ChromeDriver(); 
		//driver.manage().deleteAllCookies();
		/*System.setProperty("webdriver.gecko.driver", "C:/Users/vidya/Desktop/ExtentReportsExample-master/Drivers/geckodriver.exe");	
		driver = new FirefoxDriver();*/   
	}

	@AfterClass
	public void teardown () {
		driver.quit();
	}

}
