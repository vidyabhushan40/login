package org.loginradius.com.classes.tests;

import java.util.Iterator;
import java.util.Set;

import org.loginradius.com.commons.utils.Config;
import org.loginradius.com.extentReportFiles.ExtentTestManager;
import org.loginradius.com.pages.factory.TwitterLoginFactory;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import org.testng.annotations.Test;

public class TwitterLogin extends BaseTest{

	@Test(priority = 0)
	public void twitterLogin_withBoth_validCredentials() throws InterruptedException {
		//Below line will prnt the test case description on HTML report to identify what this method will do
		//Please commment below line to run this class independently for each test
		ExtentTestManager.getTest().setDescription("Twitter login with valid username and password.");

		driver.get(Config.getServerURL());
		driver.manage().window().maximize();

		// Use PageFactory to init pagelements.
		TwitterLoginFactory twiterLogin= PageFactory.initElements(driver, TwitterLoginFactory.class);

		Config.waitForElement(driver, twiterLogin.getLnk_LoginwithTwitter());
		twiterLogin.getLnk_LoginwithTwitter().click();
		Config.waitForTime();

		//This script will switch the command from main(parent) to child window
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> iter = windowIds.iterator();
		String mainWindow = iter.next();
		String childWindow = iter.next();
		driver.switchTo().window(childWindow);

		driver.manage().window().maximize();
		System.out.println("title of the child window: " +driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Twitter");
	

		// Return to parent window
		driver.switchTo().window(mainWindow);

	}
}









