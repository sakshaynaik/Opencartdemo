package com.opencart.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Myaccountinfopage {

	WebDriver ldriver;

	public Myaccountinfopage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "input-firstname")
	private WebElement newfname;

	@FindBy(id = "input-lastname")
	private WebElement newlstname;

	@FindBy(id = "input-email")
	private WebElement newemail;

	@FindBy(id = "input-telephone")
	private WebElement newtelephone;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continuebttn;

	@FindBy(xpath = "//div[text()='E-Mail Address does not appear to be valid!']")
	private WebElement emailinvaildmsg;
	
	@FindBy(xpath = "//div[text()='First Name must be between 1 and 32 characters!']")
	private WebElement fnameinvaildmsg;
	
	@FindBy(xpath = "//div[text()='Last Name must be between 1 and 32 characters!']")
	private WebElement lnameinvaildmsg;
	
	///////////////////////////////////////////////////////////////////////////
	
	public boolean isDisplayedInvalidFirstNameMsg() {

		return (fnameinvaildmsg.isDisplayed());
	}

	public String getTextInvalidFirstNameMsg() {

		return (fnameinvaildmsg.getText());
	}
	
	public boolean isDisplayedInvalidLastNameMsg() {

		return (lnameinvaildmsg.isDisplayed());
	}

	public String getTextInvalidLastNameMsg() {

		return (lnameinvaildmsg.getText());
	}
	
	public boolean isDisplayedInvalidEmailMsg() {

		return (emailinvaildmsg.isDisplayed());
	}

	public String getTextInvalidEmailMsg() {

		return (emailinvaildmsg.getText());
	}

	public void enterNewFirstName(String fname) {

		newfname.clear();
		newfname.sendKeys(fname);
	}

	public void enterNewLastName(String lname) {

		newlstname.clear();
		newlstname.sendKeys(lname);
	}

	public void enterNewEmail(String email) {

		newemail.clear();
		newemail.sendKeys(email);
	}

	public void enterNewTelephoneNumber(String telephone) {

		newtelephone.clear();
		newtelephone.sendKeys(telephone);
	}

	public Accountpage clickOnContinueButton() {

		continuebttn.click();
		return (new Accountpage(ldriver));
	}

	public String getMyAccountInfoPageTitle() {

		return (ldriver.getTitle());
	}

}
