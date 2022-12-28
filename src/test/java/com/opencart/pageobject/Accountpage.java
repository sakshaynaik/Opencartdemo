package com.opencart.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.utilities.ReadJavascriptExecutor;

public class Accountpage {

	WebDriver ldriver;

	public Accountpage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "Edit your account information")
	private WebElement editinfo;

	@FindBy(linkText = "Account")
	private WebElement accont;

	@FindBy(xpath = "//a[@title='My Account']")
	private WebElement myaccount;

	@FindBy(linkText = "Logout")
	private WebElement logoutoption;

	@FindBy(linkText = "Subscribe / unsubscribe to newsletter")
	private WebElement newletterlink;

	///////////////////////////////////////////
	
	public void closeBrowser() {

		ldriver.close();
	}

	public void refreshByJavascript() {

		ReadJavascriptExecutor.refreshBrowserByJS(ldriver);
	}

	public void navigateForward() {

		ldriver.navigate().forward();
	}

	public void refreshWebPage() {

		ldriver.navigate().refresh();
	}

	public void naviagteBack() {

		ldriver.navigate().back();
	}

	public boolean isDisplayedLogoutOption() {

		return (logoutoption.isDisplayed());
	}

	public NewsletterSubscriptionpage clickOnNewsLetterLink() {

		newletterlink.click();
		return (new NewsletterSubscriptionpage(ldriver));
	}

	public boolean isDisplayedEditInfoLink() {

		return (editinfo.isDisplayed());
	}

	public boolean isDisplayedAccountLinkOnBedcrum() {

		return (accont.isDisplayed());
	}

	public String getAccountPageTitle() {

		return (ldriver.getTitle());
	}

	public void clickOnMyAccountDropMenu() {

		myaccount.click();
	}

	public Accountlogoutpage clickLogoutOption() {

		logoutoption.click();
		return (new Accountlogoutpage(ldriver));
	}
}
