package org.loginradius.com.classes.tests;
import java.util.Iterator;
import java.util.Set;

import org.loginradius.com.commons.utils.Config;
import org.loginradius.com.extentReportFiles.ExtentTestManager;
import org.loginradius.com.pages.factory.GoogleLoginFactory;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleLogin extends  BaseTest{

	@Test(priority = 0)
	public void google_loginWith_bothValid_credentials() throws InterruptedException {

		//Below line will prnt the test case description on HTML report to identify what this method will do
		//Please commment below line  for each test to run this class independently
		
		ExtentTestManager.getTest().setDescription("This is test scenario to login with google account using valid username and password.");

		driver.get(Config.getServerURL());
		driver.manage().window().maximize();
		// Use PageFactory to init pagelements.
		GoogleLoginFactory gmailLogin= PageFactory.initElements(driver, GoogleLoginFactory.class);
		Config.waitForElement(driver, gmailLogin.getLnk_LoginWithGoogle());
		gmailLogin.getLnk_LoginWithGoogle().click();
		Config.waitForTime();

		//This script will switch the command from main(parent) to child window
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> iter = windowIds.iterator();
		String mainWindow = iter.next();
		String childWindow = iter.next();
		driver.switchTo().window(childWindow);
		driver.manage().window().maximize();
		System.out.println("title of the child window: " +driver.getTitle());

		Config.waitForElement(driver, gmailLogin.getInput_GmailId());
		gmailLogin.getInput_GmailId().sendKeys("truworthtest1@gmail.com");

		Config.waitForElement(driver, gmailLogin.getBtn_Nextonemail());
		gmailLogin.getBtn_Nextonemail().click();

		Config.waitForElement(driver, gmailLogin.getInput_GmailPassword());
		gmailLogin.getInput_GmailPassword().sendKeys("test123*");

		Config.waitForElement(driver, gmailLogin.getBtn_Nextonpassword());
		gmailLogin.getBtn_Nextonpassword().click();

		
		// Return to parent window
		driver.switchTo().window(mainWindow);
		Config.waitForElement(driver, gmailLogin.getTxt_MsgOnlogin());
		String textmessage = gmailLogin.getTxt_MsgOnlogin().getText();
		Assert.assertEquals(textmessage, "You are not eligible for registration");

	}

	@Test(priority =1)
	public void google_loginWith_bothInvalid_credentials() throws InterruptedException {

		ExtentTestManager.getTest().setDescription("This is test scenario to login with google account using Invalid username and password.");

		driver.navigate().to(Config.getServerURL());
		// Use PageFactory to init pagelements.
		GoogleLoginFactory gmailLogin= PageFactory.initElements(driver, GoogleLoginFactory.class);
		Config.waitForElement(driver, gmailLogin.getLnk_LoginWithGoogle());
		gmailLogin.getLnk_LoginWithGoogle().click();
		Config.waitForTime();

		//This script will switch the command from main(parent) to child window
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> iter = windowIds.iterator();
		String mainWindow = iter.next();
		String childWindow = iter.next();
		driver.switchTo().window(childWindow);
		driver.manage().window().maximize();
		System.out.println("title of the child window: " +driver.getTitle());

		Config.waitForElement(driver, gmailLogin.getLnk_useAnotherAccount());
		gmailLogin.getLnk_useAnotherAccount().click();
		
		Config.waitForElement(driver, gmailLogin.getInput_GmailId());
		gmailLogin.getInput_GmailId().sendKeys("truworthtest0@gmail.com");

		Config.waitForElement(driver, gmailLogin.getBtn_Nextonemail());
		gmailLogin.getBtn_Nextonemail().click();
		
		Config.waitForElement(driver, gmailLogin.getError_InvalidEmailId());
		String ErrorMsg = gmailLogin.getError_InvalidEmailId().getText();
		Assert.assertEquals(ErrorMsg, "Couldn't find your Google Account");
		
		
		// Return to parent window
		driver.switchTo().window(mainWindow);
		
	}
	@Test(priority =2)
	public void google_loginWith_validUsername_and_invalidPassword() throws InterruptedException {

		ExtentTestManager.getTest().setDescription("This is test scenario to login with google account using valid username and invalid password.");

		driver.navigate().to(Config.getServerURL());
		// Use PageFactory to init pagelements.
		GoogleLoginFactory gmailLogin= PageFactory.initElements(driver, GoogleLoginFactory.class);
		Config.waitForElement(driver, gmailLogin.getLnk_LoginWithGoogle());
		gmailLogin.getLnk_LoginWithGoogle().click();
		Config.waitForTime();

		//This script will switch the command from main(parent) to child window
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> iter = windowIds.iterator();
		String mainWindow = iter.next();
		String childWindow = iter.next();
		driver.switchTo().window(childWindow);
		driver.manage().window().maximize();
		System.out.println("title of the child window: " +driver.getTitle());

		Config.waitForElement(driver, gmailLogin.getLnk_useAnotherAccount());
		gmailLogin.getLnk_useAnotherAccount().click();
		
		Config.waitForElement(driver, gmailLogin.getInput_GmailId());
		gmailLogin.getInput_GmailId().sendKeys("truworthtest1@gmail.com");

		Config.waitForElement(driver, gmailLogin.getBtn_Nextonemail());
		gmailLogin.getBtn_Nextonemail().click();

		Config.waitForElement(driver, gmailLogin.getInput_GmailPassword());
		gmailLogin.getInput_GmailPassword().sendKeys("test1234*");

		Config.waitForElement(driver, gmailLogin.getBtn_Nextonpassword());
		gmailLogin.getBtn_Nextonpassword().click();

		Config.waitForElement(driver, gmailLogin.getError_InvalidPassword());
		String ErrorMsg2 = gmailLogin.getError_InvalidPassword().getText();
		Assert.assertEquals(ErrorMsg2, "Wrong password. Try again or click Forgot password to reset it.");
		
		// Return to parent window
		driver.switchTo().window(mainWindow);

	}
	@Test(priority =3)
	public void google_loginWith_invalidUsername_and_validPassword() throws InterruptedException {

		ExtentTestManager.getTest().setDescription("This is test scenario to login with google account using Invalid username and password.");

		driver.navigate().to(Config.getServerURL());
		// Use PageFactory to init pagelements.
		GoogleLoginFactory gmailLogin= PageFactory.initElements(driver, GoogleLoginFactory.class);
		Config.waitForElement(driver, gmailLogin.getLnk_LoginWithGoogle());
		gmailLogin.getLnk_LoginWithGoogle().click();
		Config.waitForTime();

		//This script will switch the command from main(parent) to child window
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> iter = windowIds.iterator();
		String mainWindow = iter.next();
		String childWindow = iter.next();
		driver.switchTo().window(childWindow);
		driver.manage().window().maximize();
		System.out.println("title of the child window: " +driver.getTitle());

		Config.waitForElement(driver, gmailLogin.getLnk_useAnotherAccount());
		gmailLogin.getLnk_useAnotherAccount().click();
		
		Config.waitForElement(driver, gmailLogin.getInput_GmailId());
		gmailLogin.getInput_GmailId().sendKeys("truworthtest123@gmail.com");

		Config.waitForElement(driver, gmailLogin.getBtn_Nextonemail());
		gmailLogin.getBtn_Nextonemail().click();

		Config.waitForElement(driver, gmailLogin.getError_InvalidEmailId());
		String ErrorMsg = gmailLogin.getError_InvalidEmailId().getText();
		Assert.assertEquals(ErrorMsg, "Couldn't find your Google Account");
		
		
		// Return to parent window
		driver.switchTo().window(mainWindow);	
		
	}
	@Test(priority =4)
	public void google_loginWith_blankEmailId_and_validPassword() throws InterruptedException {

		ExtentTestManager.getTest().setDescription("This is test scenario to login with google account using blank username and valid password.");

		driver.navigate().to(Config.getServerURL());
		// Use PageFactory to init pagelements.
		GoogleLoginFactory gmailLogin= PageFactory.initElements(driver, GoogleLoginFactory.class);
		Config.waitForElement(driver, gmailLogin.getLnk_LoginWithGoogle());
		gmailLogin.getLnk_LoginWithGoogle().click();
		Config.waitForTime();

		//This script will switch the command from main(parent) to child window
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> iter = windowIds.iterator();
		String mainWindow = iter.next();
		String childWindow = iter.next();
		driver.switchTo().window(childWindow);
		driver.manage().window().maximize();
		System.out.println("title of the child window: " +driver.getTitle());
		
		Config.waitForElement(driver, gmailLogin.getLnk_useAnotherAccount());
		gmailLogin.getLnk_useAnotherAccount().click();
		
		Config.waitForElement(driver, gmailLogin.getInput_GmailId());
		gmailLogin.getInput_GmailId().sendKeys("");

		Config.waitForElement(driver, gmailLogin.getBtn_Nextonemail());
		gmailLogin.getBtn_Nextonemail().click();

		Config.waitForElement(driver, gmailLogin.getError_blankEmail());
		String ErrorMsg = gmailLogin.getError_blankEmail().getText();
		Assert.assertEquals(ErrorMsg, "Enter an email or phone number");
		
		
		// Return to parent window
		driver.switchTo().window(mainWindow);
	
	}
	@Test(priority =5)
	public void google_loginWith_validEmailId_and_blankPassword() throws InterruptedException {

		ExtentTestManager.getTest().setDescription("This is test scenario to login with google account using valid username and blank password.");

		driver.navigate().to(Config.getServerURL());
		// Use PageFactory to init pagelements.
		GoogleLoginFactory gmailLogin= PageFactory.initElements(driver, GoogleLoginFactory.class);
		Config.waitForElement(driver, gmailLogin.getLnk_LoginWithGoogle());
		gmailLogin.getLnk_LoginWithGoogle().click();
		Config.waitForTime();

		//This script will switch the command from main(parent) to child window
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> iter = windowIds.iterator();
		String mainWindow = iter.next();
		String childWindow = iter.next();
		driver.switchTo().window(childWindow);
		driver.manage().window().maximize();
		System.out.println("title of the child window: " +driver.getTitle());

		Config.waitForElement(driver, gmailLogin.getLnk_useAnotherAccount());
		gmailLogin.getLnk_useAnotherAccount().click();
		
		Config.waitForElement(driver, gmailLogin.getInput_GmailId());
		gmailLogin.getInput_GmailId().sendKeys("truworthtest1@gmail.com");

		Config.waitForElement(driver, gmailLogin.getBtn_Nextonemail());
		gmailLogin.getBtn_Nextonemail().click();

		Config.waitForElement(driver, gmailLogin.getInput_GmailPassword());
		gmailLogin.getInput_GmailPassword().sendKeys("");

		Config.waitForElement(driver, gmailLogin.getBtn_Nextonpassword());
		gmailLogin.getBtn_Nextonpassword().click();

		Config.waitForElement(driver, gmailLogin.getError_blankPassword());
		String ErrorMsg = gmailLogin.getError_blankPassword().getText();
		Assert.assertEquals(ErrorMsg, "Enter a password");
	
		
		// Return to parent window
		driver.switchTo().window(mainWindow);
	
	}

}
