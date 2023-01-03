package com.opencart.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Productcomparisionpage {

	WebDriver ldriver;

	public Productcomparisionpage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "iMac")
	private WebElement imaclink;

	@FindBy(linkText = "Remove")
	private WebElement remove;

	@FindBy(xpath = "//*[@id='content']/table/tbody[2]/tr/td[2]/input")
	private WebElement addtocart;

	@FindBy(xpath = "//input[@value='Add to Cart']")
	private WebElement addtocarthplp;

	@FindBy(linkText = "HP LP3065")
	private WebElement hplp3065;

	@FindBy(linkText = "Canon EOS 5D")
	private WebElement prdtimg;

	@FindBy(xpath = "//*[@id='content']/table/tbody[2]/tr/td[2]/input")
	private WebElement whishlistbttn;

	@FindBy(linkText = "Remove")
	private WebElement removelink;

	@FindBy(linkText = "Continue")
	private WebElement continuebttn;

	@FindBy(linkText = "iPhone")
	private WebElement ipadimg;

	@FindBy(xpath = "//*[@id='content']/table/tbody[2]/tr/td[3]/input")
	private WebElement ipadaddtocart;

	@FindBy(xpath = "//div[contains(text(),'Success: You have modified')]")
	private WebElement modifiedmsg;

	@FindBy(xpath = "//*[@id='content']/p")
	private WebElement nonchosemsg;

	///////////////////////////////////////////////////////////////////////////

	public String getMsgProductNotChoosen() {

		return (nonchosemsg.getText());
	}

	public boolean isDisplyedMsgProductNotChoosen() {

		return (nonchosemsg.isDisplayed());
	}

	public String getMsgForProductCompareModified() {

		return (modifiedmsg.getText());
	}

	public boolean isDisplyedMsgForProductCompareModified() {

		return (modifiedmsg.isDisplayed());
	}

	public void clickOnRemoveButton() {

		remove.click();
	}

	public boolean isDisplayediPhoneAddToCart() {

		return (ipadaddtocart.isDisplayed());
	}

	public String getTextiPhoneLinkText() {

		return (ipadimg.getText());
	}

	public boolean isDisplayediPhoneLinkText() {

		return (ipadimg.isDisplayed());
	}

	public Homepage clickOnContinueButton() {

		continuebttn.click();
		return (new Homepage(ldriver));
	}

	public String getTextRemoveButtonProductComaprePage() {

		return (removelink.getText());
	}

	public boolean isDisplayedRemoveButtonInProductComaprePage() {

		return (removelink.isDisplayed());
	}

	public String getTextWhishlistButtonProductComaprePage() {

		return (whishlistbttn.getText());
	}

	public boolean isDisplayedWhishlistButtonInProductComaprePage() {

		return (whishlistbttn.isDisplayed());
	}

	public String getTextForProductInProductComaprePage() {

		return (prdtimg.getText());
	}

	public boolean isDisplayedLinkForProductInProductComaprePage() {

		return (prdtimg.isDisplayed());
	}

	public String getTextHpLp3065() {

		return (hplp3065.getText());
	}

	public boolean isDisplayedHpLp3065() {

		return (hplp3065.isDisplayed());
	}

	public String getTextAddToCartHpLp() {

		return (addtocarthplp.getText());
	}

	public boolean isDisplayedAddToCartHpLp() {

		return (addtocarthplp.isDisplayed());
	}

	public String getProductComparePageTitle() {

		return (ldriver.getTitle());
	}

	public Productpage clickOniMacLinkText() {

		imaclink.click();
		return (new Productpage(ldriver));
	}

	public String getTextiMacLinkText() {

		return (imaclink.getText());
	}

	public boolean isDisplayediMacLinkText() {

		return (imaclink.isDisplayed());
	}

	public String getTextAddToCartButton() {

		return (addtocart.getText());
	}

	public boolean isDisplayedAddToCartButton() {

		return (addtocart.isDisplayed());
	}

	public void clickAddToCartButton() {

		addtocart.click();
	}

	public String getTextRemoveButton() {

		return (remove.getText());
	}

	public boolean isDisplayedRemoveButton() {

		return (remove.isDisplayed());
	}

	public void clickRemoveButton() {

		remove.click();
	}

}
