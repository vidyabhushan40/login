package org.loginradius.com.pages.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FacebookLoginFactory extends BasePage{

	WebDriver driver;
	//This is a constructor, as every page need a base driver to find web elements
	public FacebookLoginFactory(WebDriver driver){ 	 
		super(driver);	
	}
	
	@FindBy(how = How.XPATH, using = ".//*[contains(@title, 'Sign up with Facebook')]")
	public WebElement lnk_LoginWithFcaebook;

	@FindBy(how = How.ID, using = "email")
	public WebElement txt_FacebookUserName;	

	@FindBy(how = How.ID, using = "pass")
	public WebElement txt_FacebookPassword;

	@FindBy(how = How.ID, using = "loginbutton")
	public WebElement btn_FacebookLogin;

	@FindBy(how = How.XPATH, using = "//*[@id='lr-raas-message' and @class='loginradius-raas-error-message']")
	public WebElement txt_MsgOnlogin;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"error_box\"]/div[1]")
	public WebElement errorOn_invalidcredential;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"error_box\"]/div[1]")
	public WebElement errorOn_blankcredential;

	public WebElement getLnk_LoginWithFcaebook() {
		return lnk_LoginWithFcaebook;
	}

	public WebElement getTxt_FacebookUserName() {
		return txt_FacebookUserName;
	}

	public WebElement getTxt_FacebookPassword() {
		return txt_FacebookPassword;
	}

	public WebElement getBtn_FacebookLogin() {
		return btn_FacebookLogin;
	}

	public WebElement getTxt_MsgOnlogin() {
		return txt_MsgOnlogin;
	}

	public WebElement getErrorOn_invalidcredential() {
		return errorOn_invalidcredential;
	}

	public WebElement getErrorOn_blankcredential() {
		return errorOn_blankcredential;
	}

	

}

