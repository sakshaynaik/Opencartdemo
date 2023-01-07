package com.opencart.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Downloadspage {

	WebDriver ldriver;

	public Downloadspage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	//////////////////////////////////////////////////////////////////

	public String getDownloadsPageTitle() {

		return (ldriver.getTitle());
	}

}
