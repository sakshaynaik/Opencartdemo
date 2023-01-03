package com.opencart.pageobject;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.opencart.utilities.ReadJavascriptExecutor;

public class Shoppingcartpage {

	WebDriver ldriver;

	public Shoppingcartpage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "iMac")
	private WebElement imaclink;

	@FindBy(xpath = "//*[@id='content']/form/div/table/tbody/tr/td[1]/a/img")
	private WebElement applecinema30img;

	@FindBy(xpath = "//*[@id='cart']/button")
	private WebElement blackcartbutton;

	@FindBy(xpath = "//button[@title='Remove']")
	private WebElement remveXbutton;

	@FindBy(xpath = "//ul[@class='dropdown-menu pull-right']")
	private WebElement emptycartmsg;

	@FindBy(xpath = "//*[@id='content']/form/div/table/tbody/tr/td[4]/div/input")
	private WebElement qtyfld;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement updatebutton;

	@FindBy(xpath = "//div[contains(text(),'Success: You have modified your shopping cart!')]")
	private WebElement modifiedmsg;

	@FindBy(xpath = "//*[@id='content']/p")
	private WebElement noproductmsg;

	@FindBy(xpath = "//button[@class='btn btn-danger']")
	private WebElement removebuttn;

	@FindBy(xpath = "//a[normalize-space()='Use Coupon Code']")
	private WebElement cupencodelink;

	@FindBy(id = "input-coupon")
	private WebElement coupentxtfld;

	@FindBy(id = "button-coupon")
	private WebElement coupenbutton;

	@FindBy(xpath = "//div[contains(text(),'Warning: Coupon is either invalid, expired or reached its usage limit!')]")
	private WebElement coupeninvaidmsg;

	@FindBy(xpath = "//a[@class='btn btn-primary']")
	private WebElement checkoutbttn;

	@FindBy(xpath = "//button[normalize-space()='×']")
	private WebElement closewarnmsgofcoupen;

	@FindBy(xpath = "//div[contains(text(),'Warning: Please enter a coupon code!')]")
	private WebElement coupenemptymsc;

	@FindBy(xpath = "//*[@id='content']/form/div/table/tbody/tr/td[1]/a/img")
	private WebElement iMacimg;

	@FindBy(xpath = "//a[normalize-space()='Estimate Shipping & Taxes']")
	private WebElement shiptax;

	@FindBy(id = "input-country")
	private WebElement shiptaxcountry;

	@FindBy(id = "input-zone")
	private WebElement shiptaxstate;

	@FindBy(id = "input-postcode")
	private WebElement shiptaxpostalcode;

	@FindBy(id = "button-quote")
	private WebElement getquotebttn;

	@FindBy(name = "shipping_method")
	private WebElement radiolightbox;

	@FindBy(id = "button-shipping")
	private WebElement applshippbutton;

	@FindBy(xpath = "//div[contains(text(),'Success: Your shipping estimate has been applied!')]")
	private WebElement shippingmsg;

	@FindBy(xpath = "//*[@id='accordion']/div[3]/div[1]/h4/a")
	private WebElement giftcert;

	@FindBy(id = "input-voucher")
	private WebElement giftcrname;

	@FindBy(id = "button-voucher")
	private WebElement giftcrapplybttn;

	@FindBy(xpath = "//div[contains(text(),'Warning: Gift Certificate is either invalid or the balance has been used up!')]")
	private WebElement giftinvalidmsg;

	@FindBy(xpath = "//a[normalize-space()='Continue Shopping']")
	private WebElement continueshop;

	@FindBy(css = "div[id='content'] p")
	private WebElement shopcartpageemptymsg;
	
	@FindBy(xpath = "//a[normalize-space()='Continue']")
	private WebElement continuebttn;
	
	
	///////////////////////////////////////////////////////////////////////////////
	
	public Homepage clickOnContinueButton() {

		continuebttn.click();
		return (new Homepage(ldriver));
	}
	
	public String getShopcartEmptyMsg() {

		return (shopcartpageemptymsg.getText());
	}

	public boolean isDisplayedShopcartEmptyMsg() {

		return (shopcartpageemptymsg.isDisplayed());
	}

	public Homepage clickOnContinueShopping() {

		continueshop.click();
		return (new Homepage(ldriver));
	}

	public String getGiftCertificateWarnMsg() {

		return (giftinvalidmsg.getText());
	}

	public boolean isDisplayedGiftCertificateWarnMsg() {

		return (giftinvalidmsg.isDisplayed());
	}

	public void clickOnGiftCertificateApplyButton() {

		giftcrapplybttn.click();
	}

	public void enterGiftCertificateTextField(String txt) {

		giftcrname.sendKeys(txt);
	}

	public void clickOnGiftCertificateOption() {

		giftcert.click();
	}

	public String getCoupenShippingSussessMsg() {

		return (shippingmsg.getText());
	}

	public boolean isDisplayedCoupenShippingSussessMsg() {

		return (shippingmsg.isDisplayed());
	}

	public void clickOnApplyShippingButton() {

		applshippbutton.click();
	}

	public void clickOnRadioButtonLightBox() {

		radiolightbox.click();
	}

	public void clickOnGetQuoteButton() {

		getquotebttn.click();
	}

	public void enterPostalCodeTextField(String txt) {

		shiptaxpostalcode.sendKeys(txt);
	}

	public void selectByTextState(int num) {

		Select select = new Select(shiptaxstate);
		select.selectByIndex(num);
	}

	public void selectByTextCountry(String county) {

		Select select = new Select(shiptaxcountry);
		select.selectByVisibleText(county);
	}

	public void clickOnShipAndTaxOption() {

		shiptax.click();
	}

	public boolean isDisplayediMacImg() {

		return (iMacimg.isDisplayed());
	}

	public String getCoupenEmptyMsg() {

		return (coupenemptymsc.getText());
	}

	public boolean isDisplayedCoupeEmptyMsg() {

		return (coupenemptymsc.isDisplayed());
	}

	public void clickOnCloseWarnMsg() {

		closewarnmsgofcoupen.click();
	}

	public Checkoutpage clickOnCheckOutButton() {

		checkoutbttn.click();
		return (new Checkoutpage(ldriver));
	}

	public String getCoupenInvalidMsg() {

		return (coupeninvaidmsg.getText());
	}

	public boolean isDisplayedCoupenInvalidMsg() {

		return (coupeninvaidmsg.isDisplayed());
	}

	public void clickOnCoupenContinueButton() {

		coupenbutton.click();
	}

	public void enterCoupenTextField(String txt) {

		coupentxtfld.sendKeys(txt);
	}

	public void clickOnCoupenCodeLink() {

		cupencodelink.click();
	}

	public void clickOnRemoveButtonFromCartPage() {

		removebuttn.click();
	}

	public void getBorderNoProductAddedMsgFromShopCartPage() {

		ReadJavascriptExecutor.drawBorder(noproductmsg, ldriver);
	}

	public String getNoProductAddedMsgFromShopCartPage() {

		String flag;
		try {

			flag = noproductmsg.getText();

		} catch (StaleElementReferenceException e) {

			flag = noproductmsg.getText();
		}
		return flag;
	}

	public boolean isDisplayedNoProductAddedMsgFromShopCartPage() {

		boolean flag = false;
		try {

			flag = noproductmsg.isDisplayed();

		} catch (StaleElementReferenceException e) {

			flag = noproductmsg.isDisplayed();
		}
		return flag;
	}

	public String getQtyModifiedMsg() {

		return (modifiedmsg.getText());
	}

	public boolean isDisplayedQtyModifiedMsg() {

		return (modifiedmsg.isDisplayed());
	}

	public void clickOnQtyUpdateButton() {

		updatebutton.click();
	}

	public void enterQtyField(String num) {

		qtyfld.clear();
		qtyfld.sendKeys(num);
	}

	public String getCartBoxEmptyMsg() {

		return (emptycartmsg.getText());
	}

	public boolean isDisplayedCartBoxEmptyMsg() {

		return (emptycartmsg.isDisplayed());
	}

	public void clickOnRemoveXButton() {

		remveXbutton.click();
	}

	public void clickOnCartBlackBoxButton() {

		blackcartbutton.click();
	}

	public boolean isDisplayedAppleCinema30Img() {

		return (applecinema30img.isDisplayed());

	}

	public boolean isDisplayediMacLink() {

		return (imaclink.isDisplayed());

	}

	public Productpage clickOniMacLink() {

		imaclink.click();
		return (new Productpage(ldriver));
	}

	public String getShoppingCartPageTitle() {

		return (ldriver.getTitle());
	}

}
