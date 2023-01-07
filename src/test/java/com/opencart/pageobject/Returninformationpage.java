package com.opencart.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Returninformationpage {

	WebDriver ldriver;

	public Returninformationpage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//*[@id='content']/table/tbody/tr")
	private WebElement returndetails;

	@FindBy(xpath = "//*[@id='content']/div[1]/table/tbody/tr")
	private WebElement prdtinfo;

	@FindBy(xpath = "//*[@id='content']/div[2]/table/tbody/tr")
	private WebElement returnreson;

	@FindBy(xpath = "//*[@id='content']/div[3]/table/tbody/tr")
	private WebElement returnhistry;

	//////////////////////////////////////////////////////////////////////////////
	
	public boolean isDisplayedReturnHistoryForProduct() {

		return (returnhistry.isDisplayed());
	}

	public String getReturnHistoryForProduct() {

		return (returnhistry.getText());
	}
	
	public boolean isDisplayedReturnReasonForProduct() {

		return (returnreson.isDisplayed());
	}

	public String getReturnReasonForProduct() {

		return (returnreson.getText());
	}
	
	public boolean isDisplayedProductInfoOfReturn() {

		return (prdtinfo.isDisplayed());
	}

	public String getProductInfoOfReturn() {

		return (prdtinfo.getText());
	}
	
	public boolean isDisplayedReturnDetailsForProduct() {

		return (returndetails.isDisplayed());
	}

	public String getReturnDetailsForProduct() {

		return (returndetails.getText());
	}

	public String getReturnInformationPageTitle() {

		return (ldriver.getTitle());
	}
}
