package org.loginradius.com.classes.tests;

import java.util.Iterator;
import java.util.Set;

import org.loginradius.com.commons.utils.Config;
import org.loginradius.com.extentReportFiles.ExtentTestManager;
import org.loginradius.com.pages.factory.LinkedinLoginFactory;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import org.testng.annotations.Test;

public class LinkedInLogin extends  BaseTest {

	@Test( priority = 0)
	public void linkedInLogin_withBothValid_credentials() throws InterruptedException {

		//Below line will prnt the test case description on HTML report to identify what this method will do
		//Please commment below line to run this class independently for each test
		ExtentTestManager.getTest().setDescription("LinkedIn loginwith valid username and password.");
		driver.get(Config.getServerURL());
		driver.manage().window().maximize();

		// Use PageFactory to init pagelements.
		LinkedinLoginFactory LinkedInLogin= PageFactory.initElements(driver, LinkedinLoginFactory.class);
		LinkedInLogin.getLnk_LoginwithLinkedIn().click();
		Config.waitForTime();
		//This script will switch the command from main(parent) to child window
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> iter = windowIds.iterator();
		String mainWindow = iter.next();
		String childWindow = iter.next();
		driver.switchTo().window(childWindow);
		driver.manage().window().maximize();
		System.out.println("title of the child window: " +driver.getTitle());

		Config.waitForElement(driver, LinkedInLogin.getTxt_LinkedinEmail());
		LinkedInLogin.getTxt_LinkedinEmail().sendKeys("truworthtest1@gmail.com");
		LinkedInLogin.getTxt_LinkedinPassword().sendKeys("test123*");
		Config.waitForTime();
		LinkedInLogin.getBtn_SignIn().click();

		// Return to parent window
		driver.switchTo().window(mainWindow);
		Config.waitForElement(driver, LinkedInLogin.getTxt_MsgOnlogin());
		String textmessage = LinkedInLogin.getTxt_MsgOnlogin().getText();

		Assert.assertEquals(textmessage, "You are not eligible for registration");

	}


}
