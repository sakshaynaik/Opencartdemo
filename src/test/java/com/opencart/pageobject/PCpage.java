package com.opencart.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PCpage {

	WebDriver ldriver;

	public PCpage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[normalize-space()='Continue']")
	private WebElement contbttn;

	///////////////////////////////////////////////////////////////

	public Homepage clickOnContinueButton() {

		contbttn.click();
		return (new Homepage(ldriver));
	}

	public String getPCPageTitle() {

		return (ldriver.getTitle());
	}

}
