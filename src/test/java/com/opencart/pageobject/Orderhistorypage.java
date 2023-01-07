package com.opencart.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.utilities.ReadAction;

public class Orderhistorypage {

	WebDriver ldriver;

	public Orderhistorypage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//tbody/tr[1]/td[7]/a[1]")
	private WebElement vieworderinfo;
	
	@FindBy(xpath = "//a[normalize-space()='Continue']")
	private WebElement continuebttn;

	///////////////////////////////////////////////////////////////////////////////////////
	
	public Accountpage clickOnContinueButton() {

		ReadAction.JSClick(ldriver, continuebttn);
		return (new Accountpage(ldriver));
	}

	public Orderinformationpage clickOnViewOrderInfo() {

		ReadAction.JSClick(ldriver, vieworderinfo);
		return (new Orderinformationpage(ldriver));
	}

	public String getOrderHistoryPageTitle() {

		return (ReadAction.getTitle(ldriver));
	}
}
