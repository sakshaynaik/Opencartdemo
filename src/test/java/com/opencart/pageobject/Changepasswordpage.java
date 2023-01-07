package com.opencart.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Changepasswordpage {

	WebDriver ldriver;

	public Changepasswordpage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "input-password")
	private WebElement oldpasswrd;

	@FindBy(id = "input-confirm")
	private WebElement newpasswrd;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement confrmbttn;

	@FindBy(xpath = "//div[@class='text-danger']")
	private WebElement passinvalidmsg;
	
	/////////////////////////////////////////////////////////////////////////
	
	public String getInvalidPassMsg() {

		return (passinvalidmsg.getText());
	}

	public boolean isDisplayedInvaildPassMsg() {

		return (passinvalidmsg.isDisplayed());
	}

	public void enterNewPasswordTextField(String oldpass) {

		oldpasswrd.sendKeys(oldpass);
	}

	public void enterNewConfirmPasswordTextField(String newpass) {

		newpasswrd.sendKeys(newpass);
	}

	public String getAttributeForNewPasswordTextField(String attribute) {

		return (newpasswrd.getAttribute(attribute));
	}

	public Accountpage clickOnConfirmButton() {

		confrmbttn.click();
		return (new Accountpage(ldriver));
	}

	public String getChangePasswordPageTitle() {

		return (ldriver.getTitle());
	}

}
