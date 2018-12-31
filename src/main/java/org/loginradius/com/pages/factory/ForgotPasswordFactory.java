package org.loginradius.com.pages.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPasswordFactory extends BasePage{
	
	WebDriver driver;
	//This is a constructor, as every page need a base driver to find web elements
	public ForgotPasswordFactory(WebDriver driver){ 	 
		super(driver);	
	}
	
	@FindBy(how = How.XPATH, using = "//*[@class='lr-raas-forgot-password']")
	public WebElement lnk_ForgotPassword;

	@FindBy(how = How.ID, using = "loginradius-forgotpassword-emailid")
	public WebElement txt_EmailForForgetPassword;
	
	@FindBy(how = How.ID, using = "loginradius-submit-send")
	public WebElement  btn_SendForgetPassword;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"lr-raas-forgotpassword\"]/p")
	public WebElement txt_Confirmation;
	public WebElement getLnk_ForgotPassword() {
		return lnk_ForgotPassword;
	}

	public WebElement getTxt_EmailForForgetPassword() {
		return txt_EmailForForgetPassword;
	}

	public WebElement getBtn_SendForgetPassword() {
		return btn_SendForgetPassword;
	}

	public WebElement getTxt_Confirmation() {
		return txt_Confirmation;
	}


	

}
