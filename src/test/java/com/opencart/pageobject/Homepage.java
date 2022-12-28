package com.opencart.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.utilities.ReadJavascriptExecutor;

public class Homepage {

	WebDriver ldriver;

	public Homepage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[@title='My Account']")
	private WebElement myaccount;

	@FindBy(linkText = "Register")
	private WebElement register;

	@FindBy(linkText = "Login")
	private WebElement login;

	@FindBy(linkText = "Logout")
	private WebElement logoutoption;

	@FindBy(name = "search")
	private WebElement searchtxtfld;

	@FindBy(xpath = "//*[@id='search']/span/button")
	private WebElement searchbttn;

	//////////////////////////////////////////////////////////////////

	public Searchpage clickOnSearchButton() {

		searchbttn.click();
		return (new Searchpage(ldriver));
	}

	public void enterSearchTextField(String seachfld) {

		searchtxtfld.sendKeys(seachfld);
	}

	public void monkeytest() {

		ReadJavascriptExecutor.attack(ldriver);
	}

	public void highletLoginOptionDefect() {

		ReadJavascriptExecutor.drawBorder(login, ldriver);
		ReadJavascriptExecutor.scrollIntoView(login, ldriver);

	}

	public boolean isDisplayedLogoutOption() {

		return (logoutoption.isDisplayed());
	}

	public boolean isDisplayedLoginOption() {

		return (login.isDisplayed());
	}

	public Loginpage clickOnLoginLink() {

		login.click();
		return (new Loginpage(ldriver));
	}

	public void clickOnMyAccountDropMenu() {

		myaccount.click();
	}

	public Registerationpage clickOnRegisterLink() {

		register.click();
		return (new Registerationpage(ldriver));
	}

	public boolean isDisplayedRegisterOption() {

		return (register.isDisplayed());
	}

	public String getHomePageTitle() {

		return (ldriver.getTitle());
	}

}
