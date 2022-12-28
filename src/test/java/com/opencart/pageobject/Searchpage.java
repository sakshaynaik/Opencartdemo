package com.opencart.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Searchpage {

	WebDriver ldriver;

	public Searchpage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//*[@id='content']/div[3]/div/div")
	private WebElement imacprodt;

	@FindBy(xpath = "//*[@id='content']/p[2]")
	private WebElement serchwarnmsg;

/////////////////////////////////////////////////////////////////////////////////

	public String getSearchNoProductMsg() {

		return (serchwarnmsg.getText());
	}

	public boolean isDispalyedSearchNoProductMsg() {

		return (serchwarnmsg.isDisplayed());
	}

	public boolean isDispalyedIMacProductThumb() {

		return (imacprodt.isDisplayed());
	}

	public String getSearchPageTitle() {

		return (ldriver.getTitle());
	}

}