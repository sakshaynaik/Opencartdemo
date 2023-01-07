package com.opencart.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsletterSubscriptionpage {

	WebDriver ldriver;

	public NewsletterSubscriptionpage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//input[@value='1']")
	private WebElement newsletterradio;
	
	@FindBy(xpath = "//input[@value='0']")
	private WebElement newsletterradiono;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continuebttn;
	
	//////////////////////////////////////////////////
	
	public Accountpage clickOnContinueButton() {

		continuebttn.click();
		return (new Accountpage(ldriver));
	}
	
	public boolean isSelectedNewsletterRadioOptionForNo() {

		return (newsletterradiono.isSelected());
	}

	public boolean isSelectedNewsletterRadioOption() {

		return (newsletterradio.isSelected());
	}

	public String getNewsletterPageTitle() {

		return (ldriver.getTitle());
	}

}
