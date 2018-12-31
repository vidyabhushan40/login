package org.loginradius.com.pages.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LinkedinLoginFactory extends BasePage {

	WebDriver driver;
	//This is a constructor, as every page need a base driver to find web elements
	public LinkedinLoginFactory(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.XPATH, using = ".//*[contains(@title, 'Sign up with LinkedIn')]")
	public WebElement lnk_LoginwithLinkedIn;

	@FindBy(how = How.ID, using = "session_key-login")
	public WebElement txt_LinkedinEmail;	

	@FindBy(how = How.ID, using = "session_password-login")
	public WebElement txt_LinkedinPassword;

	@FindBy(how = How.ID, using = "btn-primary")
	public WebElement btn_SignIn;

	@FindBy(how = How.XPATH, using = "//*[@id='lr-raas-message' and @class='loginradius-raas-error-message']")
	public WebElement txt_MsgOnlogin;

	public WebElement getLnk_LoginwithLinkedIn() {
		return lnk_LoginwithLinkedIn;
	}

	public WebElement getTxt_LinkedinEmail() {
		return txt_LinkedinEmail;
	}

	public WebElement getTxt_LinkedinPassword() {
		return txt_LinkedinPassword;
	}


	public WebElement getBtn_SignIn() {
		return btn_SignIn;
	}


	public WebElement getTxt_MsgOnlogin() {
		return txt_MsgOnlogin;
	}






}

