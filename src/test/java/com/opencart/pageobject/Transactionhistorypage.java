package com.opencart.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Transactionhistorypage {

	WebDriver ldriver;

	public Transactionhistorypage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "Continue")
	private WebElement continuebttn;

	@FindBy(xpath = "//div[@id='account-transaction']//p[1]")
	private WebElement tansacmsg;

	////////////////////////////////////////////////////////////////////////////////////////////////

	public String getBalanceInTHpage() {

		return (tansacmsg.getText());
	}

	public boolean isDisplayedBalanceInTHpage() {

		return (tansacmsg.isDisplayed());
	}

	public Accountpage clickOnContinueButton() {

		continuebttn.click();
		return (new Accountpage(ldriver));
	}

	public String getTransactionHistoryPageTitle() {

		return (ldriver.getTitle());
	}
}
