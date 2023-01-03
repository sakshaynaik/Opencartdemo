package com.opencart.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.utilities.ReadJavascriptExecutor;

public class Desktoppage {

	WebDriver ldriver;

	public Desktoppage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "list-view")
	private WebElement listview;

	@FindBy(id = "grid-view")
	private WebElement gridview;

	@FindBy(xpath = "//*[@id='content']/div[4]/div[3]/div/div[2]/div[2]/button[3]")
	private WebElement comparelistbutton;

	@FindBy(xpath = "//div[contains(text(), 'Success: You have added')]")
	private WebElement compareprdtmsg;

	@FindBy(linkText = "product comparison")
	private WebElement productcomparelink;

	@FindBy(linkText = "Product Compare (0)")
	private WebElement productlink;

	@FindBy(css = "a:nth-child(3)")
	private WebElement subimac;

	///////////////////////////////////////////////////////////////////

	public Productpage clickOnSubiMacLink() {

		subimac.click();
		return (new Productpage(ldriver));
	}

	public Productcomparisionpage clickOnProductCompareLink_0() {

		productlink.click();
		return (new Productcomparisionpage(ldriver));
	}

	public boolean isDisplayedMessageForCompareProduct() {

		return (compareprdtmsg.isDisplayed());
	}

	public String getTextMessageForCompareProduct() {

		return (compareprdtmsg.getText());
	}

	public String getAttributeForCompareListButton(String txt) {

		return (comparelistbutton.getAttribute(txt));
	}

	public String getDeskTopPageTitle() {

		return (ldriver.getTitle());
	}

	public Productcomparisionpage clickOnProductComapreLink() {

		ReadJavascriptExecutor.clickElementByJavaScript(productcomparelink, ldriver);
		return (new Productcomparisionpage(ldriver));
	}

	public String getCompareProductMsg() {

		return (compareprdtmsg.getText());
	}

	public boolean isDispalyedCompareProductMsg() {

		return (compareprdtmsg.isDisplayed());
	}

	public void clickOnGridView() {

		gridview.click();
	}

	public void clickOnListView() {

		listview.click();
	}

	public void clickOnCompareListButton() {

		comparelistbutton.click();
	}

}
