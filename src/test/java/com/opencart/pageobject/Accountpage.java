package com.opencart.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.utilities.ReadAction;
import com.opencart.utilities.ReadJavascriptExecutor;

public class Accountpage {

	WebDriver ldriver;

	public Accountpage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "Edit your account information")
	private WebElement editinfo;

	@FindBy(linkText = "Account")
	private WebElement accont;

	@FindBy(xpath = "//a[@title='My Account']")
	private WebElement myaccount;

	@FindBy(linkText = "Logout")
	private WebElement logoutoption;

	@FindBy(linkText = "Subscribe / unsubscribe to newsletter")
	private WebElement sub_unsublink;

	@FindBy(xpath = "//div[contains(text(),'Success: Your account has been successfully updated.')]")
	private WebElement updatesuccmsg;

	@FindBy(linkText = "Change your password")
	private WebElement editpasslink;

	@FindBy(linkText = "Password")
	private WebElement passwrdlink;

	@FindBy(xpath = "//div[contains(text(),'Success: Your password has been successfully updated.')]")
	private WebElement updatepasssuccmsg;

	@FindBy(linkText = "Order History")
	private WebElement orderhistrylink;

	@FindBy(linkText = "Downloads")
	private WebElement downloadlink;

	@FindBy(linkText = "Reward Points")
	private WebElement rewardpointlink;

	@FindBy(linkText = "View your return requests")
	private WebElement viewreturnreq;

	@FindBy(linkText = "Returns")
	private WebElement returns;

	@FindBy(linkText = "Transactions")
	private WebElement transactionlink;

	@FindBy(linkText = "Your Transactions")
	private WebElement yourtransactionlink;

	@FindBy(linkText = "Recurring payments")
	private WebElement recuringpay;

	@FindBy(xpath = "//*[@id='content']/ul[2]/li[6]/a")
	private WebElement recuringpaybylocation;

	@FindBy(linkText = "Newsletter")
	private WebElement newletterlink;
	
	@FindBy(xpath = "//div[contains(text(),'Success: Your newsletter subscription has been successfully updated!')]")
	private WebElement newlttersuccessmsg;

	///////////////////////////////////////////
	
	public NewsletterSubscriptionpage clickOnNewsLetterLinkRightOption() {

		newletterlink.click();
		return (new NewsletterSubscriptionpage(ldriver));
	}
	
	public String getNewsLetterSuccessMsg() {
		
		return (newlttersuccessmsg.getText());
	}

	public boolean isDisplayedNewsLetterSuccessMsg() {
		
		return (newlttersuccessmsg.isDisplayed());
	}
	
	
	public NewsletterSubscriptionpage clickOnSub_UnsubNewsLetterLink() {

		sub_unsublink.click();
		return (new NewsletterSubscriptionpage(ldriver));
	}

	public Recurringpaymentpage clickOnRecurringPaymentLinkOnLeftSide() {

		recuringpaybylocation.click();
		return (new Recurringpaymentpage(ldriver));
	}

	public Recurringpaymentpage clickOnRecurringPaymentLink() {

		recuringpay.click();
		return (new Recurringpaymentpage(ldriver));
	}

	public Transactionhistorypage clickOnYourTransactionLink() {

		yourtransactionlink.click();
		return (new Transactionhistorypage(ldriver));
	}

	public Transactionhistorypage clickOnTransactionLink() {

		transactionlink.click();
		return (new Transactionhistorypage(ldriver));
	}

	public Productreturnpage clickOnReturnsLink() {

		returns.click();
		return (new Productreturnpage(ldriver));
	}

	public Productreturnpage clickOnViewYourReturnRequestLink() {

		viewreturnreq.click();
		return (new Productreturnpage(ldriver));
	}

	public Rewardspointpage clickOnRewardPointsLink() {

		rewardpointlink.click();
		return (new Rewardspointpage(ldriver));
	}

	public Downloadspage clickOnDownloadsLink() {

		downloadlink.click();
		return (new Downloadspage(ldriver));
	}

	public Orderhistorypage clickOnOrderHistoryLink() {

		ReadAction.JSClick(ldriver, orderhistrylink);
		return (new Orderhistorypage(ldriver));

	}

	public String getUpdatedPasswordSuccessMsg() {

		return (updatepasssuccmsg.getText());
	}

	public boolean isDisplayedUpdatedPasswordSuccessMsg() {

		return (updatepasssuccmsg.isDisplayed());
	}

	public Changepasswordpage clickOnPasswordLink() {

		passwrdlink.click();
		return (new Changepasswordpage(ldriver));
	}

	public Changepasswordpage clickOnChangePasswordLink() {

		editpasslink.click();
		return (new Changepasswordpage(ldriver));
	}

	public String getUpdatedSuccessMsg() {

		return (updatesuccmsg.getText());
	}

	public boolean isDisplayedUpdatedSuccessMsg() {

		return (updatesuccmsg.isDisplayed());
	}

	public Myaccountinfopage clickOnEditYourInfoLink() {

		editinfo.click();
		return (new Myaccountinfopage(ldriver));
	}

	public void closeBrowser() {

		ldriver.close();
	}

	public void refreshByJavascript() {

		ReadJavascriptExecutor.refreshBrowserByJS(ldriver);
	}

	public void navigateForward() {

		ldriver.navigate().forward();
	}

	public void refreshWebPage() {

		ldriver.navigate().refresh();
	}

	public void naviagteBack() {

		ldriver.navigate().back();
	}

	public boolean isDisplayedLogoutOption() {

		return (logoutoption.isDisplayed());
	}

	public NewsletterSubscriptionpage clickOnNewsLetterLink() {

		sub_unsublink.click();
		return (new NewsletterSubscriptionpage(ldriver));
	}

	public boolean isDisplayedEditInfoLink() {

		return (editinfo.isDisplayed());
	}

	public boolean isDisplayedAccountLinkOnBedcrum() {

		return (accont.isDisplayed());
	}

	public String getAccountPageTitle() {

		return (ldriver.getTitle());
	}

	public void clickOnMyAccountDropMenu() {

		myaccount.click();
	}

	public Accountlogoutpage clickLogoutOption() {

		logoutoption.click();
		return (new Accountlogoutpage(ldriver));
	}
}
