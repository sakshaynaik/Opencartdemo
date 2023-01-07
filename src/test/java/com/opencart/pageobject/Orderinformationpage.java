package com.opencart.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.utilities.ReadAction;

public class Orderinformationpage {

	WebDriver ldriver;

	public Orderinformationpage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//*[@id='content']/table[1]/tbody/tr/td[1]")
	private WebElement orderdetailcont;

	@FindBy(xpath = "//*[@id='content']/table[1]/tbody/tr/td[2]")
	private WebElement orderdetailcont2;

	@FindBy(xpath = "//td[@class='text-right']//a[@class='btn btn-primary']")
	private WebElement reorderlink;

	@FindBy(xpath = "//div[contains(text(),'Success: You have added')]")
	private WebElement reordersuccessmsg;

	@FindBy(linkText = "shopping cart")
	private WebElement shopcartlink;

	@FindBy(xpath = "//a[@class='btn btn-danger']")
	private WebElement returnlink;

	@FindBy(xpath = "//a[normalize-space()='Continue']")
	private WebElement continuebttn;

	///////////////////////////////////////////////////////////////////////

	public Orderhistorypage clickOnContinueButton() {

		continuebttn.click();
		return (new Orderhistorypage(ldriver));
	}

	public Productreturnpage clickOnReturnOrderLink() {

		returnlink.click();
		return (new Productreturnpage(ldriver));
	}

	public Shoppingcartpage clickOnShoppingCartLink() {

		shopcartlink.click();
		return (new Shoppingcartpage(ldriver));
	}

	public String getReorderSuccessMsg() {

		return (reordersuccessmsg.getText());
	}

	public boolean isDisplayedReorderSuccessMsg() {

		return (reordersuccessmsg.isDisplayed());
	}

	public void clickOnReorderButton() {

		reorderlink.click();
	}

	public String getOrderDetailsContent2() {

		return (ReadAction.getText(ldriver, orderdetailcont2));
	}

	public boolean isDisplayedOrderDetailsContent2() {

		return (ReadAction.isDisplayed(ldriver, orderdetailcont2));
	}

	public String getOrderDetailsContent() {

		return (ReadAction.getText(ldriver, orderdetailcont));
	}

	public boolean isDisplayedOrderDetailsContent() {

		return (ReadAction.isDisplayed(ldriver, orderdetailcont));
	}

	public void navigateBackPage() {

		ldriver.navigate().back();
	}

	public String getOrderInfoPageTitle() {

		return (ReadAction.getTitle(ldriver));
	}
}
