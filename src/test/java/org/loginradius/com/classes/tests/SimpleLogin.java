package org.loginradius.com.classes.tests;

import org.loginradius.com.commons.utils.Config;
import org.loginradius.com.extentReportFiles.ExtentTestManager;
import org.loginradius.com.pages.factory.SimpleLoginFactory;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleLogin extends  BaseTest {

	@Test(priority = 0)
	public  void simple_Login_With_BothValid_Credential() throws InterruptedException
	{
		
		//Below line will prnt the test case description on HTML report to identify what this method will do
		//Please commment below line to run this class independently for each test
		
		ExtentTestManager.getTest().setDescription("This is a valid Login Scenario with correct username and password");

		driver.get(Config.getServerURL());
		driver.manage().window().maximize();

		// Use PageFactory to init elements.
		SimpleLoginFactory login= PageFactory.initElements(driver, SimpleLoginFactory.class);

		Config.waitForElement(driver, login.getText_EmailId());
		login.getText_EmailId().sendKeys("johnsmith1@mailinator.com");

		Config.waitForElement(driver, login.getText_Password());
		login.getText_Password().sendKeys("test123*");
		login.getBtn_Login().click();
        
		Config.waitForTime();
		Config.waitForElement(driver, login.getInput_PhoneNumber());
		login.getInput_PhoneNumber().sendKeys("+919861642034"); 

		Config.waitForElement(driver, login.getBtn_Update());
		login.getBtn_Update().click();

		String title2= driver.getTitle();
		System.out.println(title2);

		String errormessage = login.getTxt_ErrorMessage().getText();
		System.out.println(errormessage);	
	}

	@Test(priority = 1)
	public  void simple_Login_WithBoth_Invalid_Credentials() throws InterruptedException
	{
		ExtentTestManager.getTest().setDescription("This is invalid Login Scenario with invalid username and invalid password");

		driver.navigate().to(Config.getServerURL());
		// Use PageFactory to init elements.
		SimpleLoginFactory login= PageFactory.initElements(driver, SimpleLoginFactory.class);

		Config.waitForElement(driver, login.getText_EmailId());
		login.getText_EmailId().sendKeys("johnsmith2@mailinator..com");

		Config.waitForElement(driver, login.getText_Password());
		login.getText_Password().sendKeys("test1235");
		login.getBtn_Login().click();
		
		Config.waitForElement(driver, login.getTxt_ErrorMessage());
		String errormessage = login.getTxt_ErrorMessage().getText();
		Assert.assertEquals(errormessage, "The provided email ID is invalid or not well-formatted, a valid email ID is required in order to process this request.");

	}

	@Test(priority = 2)
	public  void simple_Login_withInvalid_EmailId_And_Correct_Password() throws InterruptedException
	{
		ExtentTestManager.getTest().setDescription("This is invalid Login Scenario with invalid EmailId and Correct password");

		driver.navigate().to(Config.getServerURL());
		// Use PageFactory to init elements.
		SimpleLoginFactory login= PageFactory.initElements(driver, SimpleLoginFactory.class);

		Config.waitForElement(driver, login.getText_EmailId());
		login.getText_EmailId().sendKeys("vidyatest123");

		Config.waitForElement(driver, login.getText_Password());
		login.getText_Password().sendKeys("test123*");
		login.getBtn_Login().click();
		
		Config.waitForElement(driver, login.getTxt_ErrorMessage());
		String msgonntop = login.getTxt_ErrorMessage().getText();
		Assert.assertEquals(msgonntop, "The provided email ID is invalid or not well-formatted, a valid email ID is required in order to process this request.");

	}
	@Test(priority = 3)
	public  void simple_Login_withValid_EmailId_And_Invalid_Password() throws InterruptedException
	{
		ExtentTestManager.getTest().setDescription("This is invalid Login Scenario with valid EmailId and Invalid password");

		driver.navigate().to(Config.getServerURL());

		// Use PageFactory to init elements.
		SimpleLoginFactory login= PageFactory.initElements(driver, SimpleLoginFactory.class);

		Config.waitForElement(driver, login.getText_EmailId());
		login.getText_EmailId().sendKeys("johnsmith1@mailinator.com");

		Config.waitForElement(driver, login.getText_Password());
		login.getText_Password().sendKeys("test12345");
		login.getBtn_Login().click();

		

	}

	@Test(priority = 4)
	public  void simple_Login_withBlank_EmailId_And_valid_Password() throws InterruptedException
	{
		ExtentTestManager.getTest().setDescription("This is invalid Login Scenario with blank EmailId and valid password");

		driver.navigate().to(Config.getServerURL());

		// Use PageFactory to init elements.
		SimpleLoginFactory login= PageFactory.initElements(driver, SimpleLoginFactory.class);

		Config.waitForElement(driver, login.getText_EmailId());
		login.getText_EmailId().sendKeys("");

		Config.waitForElement(driver, login.getText_Password());
		login.getText_Password().sendKeys("test123*");
		login.getBtn_Login().click();
		
		
		Config.waitForElement(driver, login.getText_errorMsgOnMailId());
		String errorOnmail = login.getText_errorMsgOnMailId().getText();
        Assert.assertEquals(errorOnmail, "The Email Id/Phone field is required.");
		
	}

	@Test(priority = 5)
	public  void simple_Login_withValid_EmailId_And_blank_Password() throws InterruptedException
	{
		ExtentTestManager.getTest().setDescription("This is invalid Login Scenario with Valid EmailId and blank password");

		driver.navigate().to(Config.getServerURL());

		// Use PageFactory to init elements.
		SimpleLoginFactory login= PageFactory.initElements(driver, SimpleLoginFactory.class);

		Config.waitForElement(driver, login.getText_EmailId());
		login.getText_EmailId().sendKeys("johnsmith1@mailinator.com");

		Config.waitForElement(driver, login.getText_Password());
		login.getText_Password().sendKeys("");
		login.getBtn_Login().click();
		
		Config.waitForElement(driver, login.getText_errorMsgOnPassword());
		String errorOnpassword = login.getText_errorMsgOnPassword().getText();
        Assert.assertEquals(errorOnpassword, "The Password field is required.");
	
	}

	@Test(priority = 6)
	public  void simple_Login_withBlank_EmailId_And_blank_Password() throws InterruptedException
	{
		ExtentTestManager.getTest().setDescription("This is invalid Login Scenario with blank EmailId and blank password");

		driver.navigate().to(Config.getServerURL());

		// Use PageFactory to init elements.
		SimpleLoginFactory login= PageFactory.initElements(driver, SimpleLoginFactory.class);

		Config.waitForElement(driver, login.getText_EmailId());
		login.getText_EmailId().sendKeys("");

		Config.waitForElement(driver, login.getText_Password());
		login.getText_Password().sendKeys("");
		login.getBtn_Login().click();
		
		Config.waitForElement(driver, login.getText_errorMsgOnMailId());
		String errorOnmail = login.getText_errorMsgOnMailId().getText();
        Assert.assertEquals(errorOnmail, "The Email Id/Phone field is required.");
		
		Config.waitForElement(driver, login.getText_errorMsgOnPassword());
		String errorOnpassword = login.getText_errorMsgOnPassword().getText();
        Assert.assertEquals(errorOnpassword, "The Password field is required.");
		

	}

}
