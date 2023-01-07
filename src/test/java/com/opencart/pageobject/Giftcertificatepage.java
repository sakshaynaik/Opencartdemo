package com.opencart.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Giftcertificatepage {

	WebDriver ldriver;

	public Giftcertificatepage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "input-to-name")
	private WebElement recpntname;

	@FindBy(id = "input-to-email")
	private WebElement recpntemail;

	@FindBy(id = "input-from-name")
	private WebElement name;

	@FindBy(id = "input-from-email")
	private WebElement email;

	@FindBy(xpath = "//label[normalize-space()='Birthday']")
	private WebElement birthdayradiobttn;

	@FindBy(xpath = "//label[normalize-space()='Christmas']")
	private WebElement christmasradiobttn;

	@FindBy(xpath = "//label[normalize-space()='General']")
	private WebElement generalradiobttn;

	@FindBy(id = "input-message")
	private WebElement messagebox;

	@FindBy(id = "input-amount")
	private WebElement amount;
	
	@FindBy(name = "agree")
	private WebElement agreecheckbox;
	
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continuebttn;
	
	@FindBy(xpath = "//p[contains(text(),'Thank you for purchasing a gift certificate!')]")
	private WebElement purchasegiftmsg;
	
	@FindBy(xpath = "//a[normalize-space()='Continue']")
	private WebElement gftcertsuccmsgcontinuebttn;
	
	@FindBy(xpath = "//div[contains(text(),'Amount must be between $1.00 and $1,000.00!')]")
	private WebElement invalidamntmsg;

	//////////////////////////////////////////////////////////////////////////
	
	public String getInvalidAmountMsg() {

		return (invalidamntmsg.getText());
	}
	
	public boolean isDisplayedInvalidAmountMsg() {

		return (invalidamntmsg.isDisplayed());
	}
	
	public Shoppingcartpage clickOnGiftCertMsgPgContinueButton() {

		gftcertsuccmsgcontinuebttn.click();
		return (new Shoppingcartpage(ldriver));
	}
	
	public String getGiftCertificateMsg() {

		return (purchasegiftmsg.getText());
	}
	
	public boolean isDisplayedGiftCertificateMsg() {

		return (purchasegiftmsg.isDisplayed());
	}
	
	public Giftcertificatepage clickOnContinueButton() {

		continuebttn.click();
		return (new Giftcertificatepage(ldriver));
	}
	
	public void clickOnAgreeCheckBox() {

		agreecheckbox.click();
	}
	
	public void enterMessageTextField(String sndermssg) {

		messagebox.clear();
		messagebox.sendKeys(sndermssg);
	}
	
	public void enterAmountTextField(String amnt) {

		amount.clear();
		amount.sendKeys(amnt);
	}
	
	public void clickOnGiftCertifacteTheme(String themes) {

		if (birthdayradiobttn.getText().equals(themes)) {

			birthdayradiobttn.click();

		} else if (christmasradiobttn.getText().equals(themes)) {

			christmasradiobttn.click();

		} else if (generalradiobttn.getText().equals(themes)) {

			generalradiobttn.click();
		}
	}

	public void enterSenderEmailTextField(String snderemail) {

		email.clear();
		email.sendKeys(snderemail);
	}

	public void enterSenderNameTextField(String sndername) {

		name.clear();
		name.sendKeys(sndername);
	}

	public void enterRecipientsEmailTextField(String recemail) {

		recpntemail.clear();
		recpntemail.sendKeys(recemail);
	}

	public void enterRecipientsNameTextField(String recname) {

		recpntname.clear();
		recpntname.sendKeys(recname);
	}

	public String getGiftCertificatePageTitle() {

		return (ldriver.getTitle());
	}
}
