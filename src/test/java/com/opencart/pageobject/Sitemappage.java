package com.opencart.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sitemappage {

	WebDriver ldriver;

	public Sitemappage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "Search")
	private WebElement searchlink;

	///////////////////////////////////////////////////////

	public Searchpage clickOnSearchLink() {

		searchlink.click();
		return (new Searchpage(ldriver));
	}

	public void navigateToBackPage() {

		ldriver.navigate().back();
	}

	public String getSiteMapPageTitle() {

		return (ldriver.getTitle());
	}

}
