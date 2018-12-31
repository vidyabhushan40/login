package org.loginradius.com.pages.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GoogleLoginFactory extends BasePage {
	
	WebDriver driver;
	//This is a constructor, as every page need a base driver to find web elements
	public GoogleLoginFactory(WebDriver driver){ 	 
		super(driver);	
	}

	@FindBy(how = How.XPATH, using = ".//*[contains(@title, 'Sign up with Google')]")
	public WebElement lnk_LoginWithGoogle;

	@FindBy(how = How.XPATH, using = ".//*[@class='M8HEDc eARute cd29Sd bxPAYd W7Aapd znIWoc']")
	public WebElement lnk_SelectOtherAccountType;	

	@FindBy(how = How.ID, using = "identifierNext")
	public WebElement btn_Nextonemail;

	@FindBy(how = How.ID, using = "identifierId")
	public WebElement input_GmailId;

	@FindBy(how = How.XPATH, using = ".//*[contains(@name, 'password')]")
	public WebElement input_GmailPassword;

	@FindBy(how = How.ID, using = "passwordNext")
	public WebElement btn_Nextonpassword;

	@FindBy(how = How.XPATH, using = "//*[@id='lr-raas-message' and @class='loginradius-raas-error-message']")
	public WebElement txt_MsgOnlogin;
	
	@FindBy(how = How.XPATH, using = "//*[@class='UXurCe']")
	public WebElement lnk_useAnotherAccount;
	
	@FindBy(how = How.XPATH, using = "//*[@class='GQ8Pzc']")
	public WebElement error_InvalidEmailId;
	
	@FindBy(how = How.XPATH, using = "//*[@class='GQ8Pzc']")
	public WebElement error_InvalidPassword;
	
	@FindBy(how = How.XPATH, using = "//*[@class='GQ8Pzc']")
	public WebElement error_blankEmail;
	
	@FindBy(how = How.XPATH, using = "//*[@class='GQ8Pzc']")
	public WebElement error_blankPassword;
	
	public WebElement getLnk_LoginWithGoogle() {
		return lnk_LoginWithGoogle;
	}

	public WebElement getLnk_SelectOtherAccountType() {
		return lnk_SelectOtherAccountType;
	}
	
	public WebElement getInput_GmailId() {
		return input_GmailId;
	}

	public WebElement getInput_GmailPassword() {
		return input_GmailPassword;
	}

	public WebElement getBtn_Nextonemail() {
		return btn_Nextonemail;
	}

	public WebElement getTxt_MsgOnlogin() {
		return txt_MsgOnlogin;
	}

	public WebElement getBtn_Nextonpassword() {
		return btn_Nextonpassword;
	}


	public WebElement getLnk_useAnotherAccount() {
		return lnk_useAnotherAccount;
	}

	public WebElement getError_InvalidEmailId() {
		return error_InvalidEmailId;
	}

	public WebElement getError_InvalidPassword() {
		return error_InvalidPassword;
	}

	public WebElement getError_blankEmail() {
		return error_blankEmail;
	}

	public WebElement getError_blankPassword() {
		return error_blankPassword;
	}

	
}
