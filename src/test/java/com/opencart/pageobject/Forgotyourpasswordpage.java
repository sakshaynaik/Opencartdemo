package com.opencart.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Forgotyourpasswordpage {

	WebDriver ldriver;

	public Forgotyourpasswordpage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//*[@id='content']/p")
	private WebElement forgetcontent;

	@FindBy(linkText = "Forgotten Password")
	private WebElement forgtpass;

	@FindBy(id = "input-email")
	private WebElement forgotpgemail;

	@FindBy(xpath = "//*[@id='content']/form/div/div[2]/input")
	private WebElement continuebtn;

	@FindBy(xpath = "//div[contains(text(),' Warning: The E-Mail Address was not found in our records')]")
	private WebElement registedemailwarnmsg;

	///////////////////////////////////////////////////////////////////
	
	public String getAttributeForEmailTextField(String data) {

		return (forgotpgemail.getAttribute(data));
	}

	public String getWarnForUnregisteredEmail() {

		return (registedemailwarnmsg.getText());
	}

	public boolean isDisplayedWarnForUnregisteredEmail() {

		return (registedemailwarnmsg.isDisplayed());
	}

	public void clickOnContinueButton() {

		continuebtn.click();
	}

	public void enterEmailOfForgotenPassword(String email) {

		forgotpgemail.sendKeys(email);
	}

	public boolean isDisplayedForgottenPassOnBedcrum() {

		return (forgtpass.isDisplayed());
	}

	public String getForgetMsgContent() {

		return (forgetcontent.getText());
	}

	public boolean isDisplayedForgetMsgContent() {

		return (forgetcontent.isDisplayed());
	}

	public String getForgotPasswordPageTitle() {

		return (ldriver.getTitle());
	}
}
