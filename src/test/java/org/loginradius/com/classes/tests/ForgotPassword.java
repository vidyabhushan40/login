package org.loginradius.com.classes.tests;

import org.loginradius.com.commons.utils.Config;
import org.loginradius.com.extentReportFiles.ExtentTestManager;
import org.loginradius.com.pages.factory.ForgotPasswordFactory;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgotPassword extends BaseTest{

	
	@Test()
	public  void forgotPassword() throws InterruptedException
	{
		
		//Below line will prnt the test case description on HTML report to identify what this method will do
		//Please commment below line to run this class independently for each test
		
		ExtentTestManager.getTest().setDescription("This link will help to retrive forgot password");

		driver.get(Config.getServerURL());
		driver.manage().window().maximize();

		// Use PageFactory to init elements.
		ForgotPasswordFactory forgotPswd= PageFactory.initElements(driver, ForgotPasswordFactory.class);
        
		Config.waitForElement(driver, forgotPswd.getLnk_ForgotPassword());
		forgotPswd.getLnk_ForgotPassword().click();
		forgotPswd.getTxt_EmailForForgetPassword().sendKeys("johnsmith1@mailinator.com");
		forgotPswd.getBtn_SendForgetPassword().click();
		Config.waitForTime();
		String confrmMsg  = forgotPswd.getTxt_Confirmation().getText();
		
		Assert.assertEquals(confrmMsg, "We'll email you an instruction on how to reset your password.");
	
	
	
	
	}
	
}
