package org.loginradius.com.classes.tests;


import java.util.Iterator;
import java.util.Set;

import org.loginradius.com.commons.utils.Config;
import org.loginradius.com.extentReportFiles.ExtentTestManager;
import org.loginradius.com.pages.factory.FacebookLoginFactory;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FacebookLogin extends BaseTest {

	
	@Test(priority = 0)
	public void facebookLogin_with_bothValid_credentials() throws InterruptedException {
		//This line will prnt the test case description on HTML report to identify what this method will do
		//Please commment below line to run this class independently for each test
		
		ExtentTestManager.getTest().setDescription("This is Facebook login with valid username and valid password.");
		
		driver.get(Config.getServerURL());
		driver.manage().window().maximize();
		
		// Use PageFactory to init pagelements.
		FacebookLoginFactory facebookLogin= PageFactory.initElements(driver, FacebookLoginFactory.class);

		Config.waitForElement(driver, facebookLogin.getLnk_LoginWithFcaebook());
		facebookLogin.getLnk_LoginWithFcaebook().click();
		Config.waitForTime();

		//This script will switch the command from main(parent) to child window
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> iter = windowIds.iterator();
		String mainWindow = iter.next();
		String childWindow = iter.next();
		driver.switchTo().window(childWindow);
		driver.manage().window().maximize();
	
		facebookLogin.getTxt_FacebookUserName().sendKeys("truworthtest1@gmail.com");
		Config.waitForElement(driver, facebookLogin.getTxt_FacebookPassword());
		facebookLogin.getTxt_FacebookPassword().sendKeys("test123*");
		Config.waitForElement(driver, facebookLogin.getBtn_FacebookLogin());
		facebookLogin.getBtn_FacebookLogin().click();
		
		// Return to parent window
		driver.switchTo().window(mainWindow);
		Config.waitForElement(driver, facebookLogin.getTxt_MsgOnlogin());
		String textmessage = facebookLogin.getTxt_MsgOnlogin().getText();
		Assert.assertEquals(textmessage, "You are not eligible for registration");
		
	}

	@Test(priority = 1)
	public void facebookLogin_with_bothInValid_credentials() throws InterruptedException {
		
		ExtentTestManager.getTest().setDescription("This is Facebook login with invalid username and invalid password.");
		
		driver.get(Config.getServerURL());
		driver.manage().window().maximize();
		// Use PageFactory to init pagelements.
		FacebookLoginFactory facebookLogin= PageFactory.initElements(driver, FacebookLoginFactory.class);

		Config.waitForElement(driver, facebookLogin.getLnk_LoginWithFcaebook());
		facebookLogin.getLnk_LoginWithFcaebook().click();
		Config.waitForTime();
	

		//This script will switch the command from main(parent) to child window
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> iter = windowIds.iterator();
		String mainWindow = iter.next();
		String childWindow = iter.next();
		driver.switchTo().window(childWindow);
		driver.manage().window().maximize();
		
		facebookLogin.getTxt_FacebookUserName().sendKeys("truworthtest0reddii@.com");
		Config.waitForElement(driver, facebookLogin.getTxt_FacebookPassword());
		facebookLogin.getTxt_FacebookPassword().sendKeys("test123**");
		Config.waitForElement(driver, facebookLogin.getBtn_FacebookLogin());
		facebookLogin.getBtn_FacebookLogin().click();
		
		Config.waitForTime();
		Config.waitForElement(driver, facebookLogin.getErrorOn_invalidcredential());
		String errorText = facebookLogin.getErrorOn_invalidcredential().getText();
		Assert.assertEquals(errorText, "Incorrect email address or phone number");
		
		// Return to parent window
		driver.switchTo().window(mainWindow);
		
		
	}
	@Test(priority = 1)
	public void facebookLogin_with_ValidEmail_and_invalidPassword() throws InterruptedException {
		
		ExtentTestManager.getTest().setDescription("This is Facebook login with valid username and invalid password.");
		
		driver.get(Config.getServerURL());
		driver.manage().window().maximize();
		
		// Use PageFactory to init pagelements.
		FacebookLoginFactory facebookLogin= PageFactory.initElements(driver, FacebookLoginFactory.class);

		Config.waitForElement(driver, facebookLogin.getLnk_LoginWithFcaebook());
		facebookLogin.getLnk_LoginWithFcaebook().click();
		Config.waitForTime();
		
		//This script will switch the command from main(parent) to child window
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> iter = windowIds.iterator();
		String mainWindow = iter.next();
		String childWindow = iter.next();
		driver.switchTo().window(childWindow);
		driver.manage().window().maximize();
		
		facebookLogin.getTxt_FacebookUserName().sendKeys("truworthtest1@gmail.com");
		Config.waitForElement(driver, facebookLogin.getTxt_FacebookPassword());
		facebookLogin.getTxt_FacebookPassword().sendKeys("test123@**");
		Config.waitForElement(driver, facebookLogin.getBtn_FacebookLogin());
		facebookLogin.getBtn_FacebookLogin().click();
		
		Config.waitForTime();
		Config.waitForElement(driver, facebookLogin.getErrorOn_invalidcredential());
		String errorText = facebookLogin.getErrorOn_invalidcredential().getText();
		Assert.assertEquals(errorText, "Please re-enter your password");
		
		// Return to parent window
		driver.switchTo().window(mainWindow);
		
	}
	@Test(priority = 2)
	public void facebookLogin_with_inValidEmail_and_validPassword() throws InterruptedException {
		
		ExtentTestManager.getTest().setDescription("This is Facebook login with invalid username and valid password.");
		
		driver.get(Config.getServerURL());
		driver.manage().window().maximize();
		
		// Use PageFactory to init pagelements.
		FacebookLoginFactory facebookLogin= PageFactory.initElements(driver, FacebookLoginFactory.class);

		Config.waitForElement(driver, facebookLogin.getLnk_LoginWithFcaebook());
		facebookLogin.getLnk_LoginWithFcaebook().click();
		Config.waitForTime();

		//This script will switch the command from main(parent) to child window
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> iter = windowIds.iterator();
		String mainWindow = iter.next();
		String childWindow = iter.next();
		driver.switchTo().window(childWindow);
		driver.manage().window().maximize();
		
		Config.waitForTime();
		Config.waitForElement(driver, facebookLogin.getTxt_FacebookUserName());
		facebookLogin.getTxt_FacebookUserName().clear();
		facebookLogin.getTxt_FacebookUserName().sendKeys("truworthtest0@gmail.com");
		Config.waitForElement(driver, facebookLogin.getTxt_FacebookPassword());
		facebookLogin.getTxt_FacebookPassword().sendKeys("test123*");
		Config.waitForElement(driver, facebookLogin.getBtn_FacebookLogin());
		facebookLogin.getBtn_FacebookLogin().click();
		
		// Return to parent window
		driver.switchTo().window(mainWindow);
		
	}
	@Test(priority = 3)
	public void facebookLogin_with_blankEmailId_and_ValidPassword() throws InterruptedException {
		
		ExtentTestManager.getTest().setDescription("This is Facebook login with blank username and valid password.");

		driver.get(Config.getServerURL());
		driver.manage().window().maximize();
		// Use PageFactory to init pagelements.
		FacebookLoginFactory facebookLogin= PageFactory.initElements(driver, FacebookLoginFactory.class);

		Config.waitForElement(driver, facebookLogin.getLnk_LoginWithFcaebook());
		facebookLogin.getLnk_LoginWithFcaebook().click();
		Config.waitForTime();
		
		//This script will switch the command from main(parent) to child window
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> iter = windowIds.iterator();
		String mainWindow = iter.next();
		String childWindow = iter.next();
		driver.switchTo().window(childWindow);
		driver.manage().window().maximize();
	
		facebookLogin.getTxt_FacebookUserName().sendKeys("");
		Config.waitForElement(driver, facebookLogin.getTxt_FacebookPassword());
		facebookLogin.getTxt_FacebookPassword().sendKeys("test123*");
		Config.waitForElement(driver, facebookLogin.getBtn_FacebookLogin());
		facebookLogin.getBtn_FacebookLogin().click();
		
		// Return to parent window
		driver.switchTo().window(mainWindow);
		
	}

	@Test(priority = 4)
	public void facebookLogin_with_blankEmailId_and_blankPassword() throws InterruptedException {
		
		ExtentTestManager.getTest().setDescription("This is Facebook login with blank username and blank password.");

		driver.get(Config.getServerURL());
		driver.manage().window().maximize();
		// Use PageFactory to init pagelements.
		FacebookLoginFactory facebookLogin= PageFactory.initElements(driver, FacebookLoginFactory.class);

		Config.waitForElement(driver, facebookLogin.getLnk_LoginWithFcaebook());
		facebookLogin.getLnk_LoginWithFcaebook().click();
		Config.waitForTime();

		//This script will switch the command from main(parent) to child window
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> iter = windowIds.iterator();
		String mainWindow = iter.next();
		String childWindow = iter.next();
		driver.switchTo().window(childWindow);
		driver.manage().window().maximize();
		
		facebookLogin.getTxt_FacebookUserName().sendKeys("");
		Config.waitForElement(driver, facebookLogin.getTxt_FacebookPassword());
		facebookLogin.getTxt_FacebookPassword().sendKeys("");
		Config.waitForElement(driver, facebookLogin.getBtn_FacebookLogin());
		facebookLogin.getBtn_FacebookLogin().click();
		
		// Return to parent window
		driver.switchTo().window(mainWindow);
		
	}

}
