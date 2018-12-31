package org.loginradius.com.pages.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SimpleLoginFactory extends BasePage{

	WebDriver driver;
	//This is a constructor, as every page need a base driver to find web elements
	 public SimpleLoginFactory(WebDriver driver) {
	        super(driver);
	    }

	@FindBy(how = How.ID, using = "loginradius-login-emailid")
	public WebElement text_EmailId;

	@FindBy(how = How.ID, using = "loginradius-login-password")
	public WebElement text_Password;	

	@FindBy(how = How.ID, using = "loginradius-submit-login")
	public WebElement btn_Login;

	@FindBy(how = How.ID, using = "loginradius-updatePhone-phoneNo2FA")
	public WebElement input_PhoneNumber;

	@FindBy(how = How.ID, using = "loginradius-submit-update")
	public WebElement btn_Update;

	@FindBy(how = How.XPATH, using = "//*[@id='lr-raas-message' and @class='loginradius-raas-error-message']")
	public WebElement txt_ErrorMessage;
	
	@FindBy(how = How.ID, using = "validation-loginradius-login-emailid")
	public WebElement text_errorMsgOnMailId;
	
	@FindBy(how = How.ID, using = "validation-loginradius-login-password")
	public WebElement text_errorMsgOnPassword;



	public WebElement getTxt_ErrorMessage() {
		return txt_ErrorMessage;
	}

	public WebElement getText_EmailId() {
		return text_EmailId;
	}

	public WebElement getText_Password() {
		return text_Password;
	}

	public WebElement getBtn_Login() {
		return btn_Login;
	}

	public WebElement getInput_PhoneNumber() {
		return input_PhoneNumber;
	}

	public WebElement getBtn_Update() {
		return btn_Update;
	}

	public WebElement getText_errorMsgOnMailId() {
		return text_errorMsgOnMailId;
	}

	public WebElement getText_errorMsgOnPassword() {
		return text_errorMsgOnPassword;
	}











}
