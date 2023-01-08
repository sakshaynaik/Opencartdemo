package com.opencart.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Successpage {

	WebDriver ldriver;

	public Successpage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "Logout")
	private WebElement logoutoption;

	@FindBy(xpath = "//div[@id='content']/h1")
	private WebElement accountsccessmsg;

	@FindBy(xpath = "//div[@id='content']/p[1]")
	private WebElement congmsg;

	@FindBy(linkText = "Continue")
	private WebElement continuebttn;

	@FindBy(linkText = "Success")
	private WebElement successonbedcrum;
	
	@FindBy(linkText = "Edit Account")
	private WebElement editaccntlink;

	////////////////////////////////////////
	
	public Myaccountinfopage clickOnEditAccountLink() {

		editaccntlink.click();
		return (new Myaccountinfopage(ldriver));
	}

	public boolean isDisplayedLogoutOption() {

		return (logoutoption.isDisplayed());
	}

	public String getHeadingAccountSuccessMsg() {

		return (accountsccessmsg.getText());
	}

	public String getSubAccountSuccessMsg() {

		return (congmsg.getText());
	}

	public boolean isDisplayedSubAccountSuccessMsg() {

		return (congmsg.isDisplayed());
	}

	public boolean isDisplayedSuccessOnBedcrum() {

		return (successonbedcrum.isDisplayed());
	}

	public Accountpage clickOnContinueButton() {

		continuebttn.click();
		return (new Accountpage(ldriver));

	}

	public String getSuccessPageTitle() {

		return (ldriver.getTitle());
	}

}
