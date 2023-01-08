package com.opencart.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.utilities.ReadAction;

public class Addressbookpage {

	WebDriver ldriver;

	public Addressbookpage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//*[@id='content']/div[1]/table/tbody/tr[1]/td[2]/a[2]")
	private WebElement deletebttn;

	@FindBy(linkText = "Edit")
	private WebElement editbttn;

	@FindBy(linkText = "New Address")
	private WebElement newadresbtn;

	@FindBy(linkText = "Back")
	private WebElement backbttn;

	@FindBy(xpath = "//div[contains(text(),'Warning: You can not delete your default address!')]")
	private WebElement deletwarnmsg;

	@FindBy(id = "input-firstname")
	private WebElement fname;

	@FindBy(id = "input-lastname")
	private WebElement lname;

	@FindBy(id = "input-company")
	private WebElement comname;

	@FindBy(id = "input-address-1")
	private WebElement address1;

	@FindBy(id = "input-address-2")
	private WebElement address2;

	@FindBy(id = "input-city")
	private WebElement cityname;

	@FindBy(id = "input-postcode")
	private WebElement pstcode;

	@FindBy(id = "input-country")
	private WebElement selectcontry;

	@FindBy(id = "input-zone")
	private WebElement selectzone;

	@FindBy(xpath = "//input[@value='1']")
	private WebElement defaltaddrssradiobttn;
	
	@FindBy(xpath = "input[value='0']")
	private WebElement defaltaddrssradiobttnNo;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continuebttn;

	@FindBy(xpath = "//div[text()=' Your address has been successfully updated']")
	private WebElement addressupdtesuccmsg;
	
	@FindBy(xpath = "//div[text()=' Your address has been successfully deleted']")
	private WebElement deletesuccmsg;
	
	@FindBy(xpath = "//div[text()=' Your address has been successfully added']")
	private WebElement newaddresupdtemsg;
	
	////////////////////////////////////////////////////////////////////////////
	
	public void clickOnDefaltAddressRadioButtonNo() {

		ReadAction.JSClick(ldriver, defaltaddrssradiobttnNo);
	}
	
	public String getNewAddressBookSuccessMsg() {

		return (ReadAction.getText(ldriver, newaddresupdtemsg));
	}

	public boolean isDisplayedNewAddressBookSuccessMsg() {

		return (ReadAction.isDisplayed(ldriver, newaddresupdtemsg));
	}
	
	public String getUpdateAddressDeleteSuccessMsg() {

		return (ReadAction.getText(ldriver, deletesuccmsg));
	}

	public boolean isDisplayedUpdateAddressDeleteSuccessMsg() {

		return (ReadAction.isDisplayed(ldriver, deletesuccmsg));
	}
	

	public String getUpdateAddressBookSuccessMsg() {

		return (ReadAction.getText(ldriver, addressupdtesuccmsg));
	}

	public boolean isDisplayedUpdateAddressBookSuccessMsg() {

		return (ReadAction.isDisplayed(ldriver, addressupdtesuccmsg));
	}
	
	public void clickOnContinueButton() {

		ReadAction.actionClick(ldriver, continuebttn);
	}

	public void clickOnDefaltAddressRadioButton() {

		ReadAction.actionClick(ldriver, defaltaddrssradiobttn);
	}

	public void selectByIndexZone(int num) {

		ReadAction.selectByIndex(selectzone, num);
	}

	public void selectByTextCountry(String contry) {

		ReadAction.selectByVisibleText(contry, selectcontry);
	}

	public void enterPostalCode(String ptlcode) {

		ReadAction.sendKeys(pstcode, ptlcode);
	}

	public void entercityName(String cname) {

		ReadAction.sendKeys(cityname, cname);
	}

	public void enterAddress2(String adress2) {

		ReadAction.sendKeys(address2, adress2);
	}

	public void enterAddress1(String adress1) {

		ReadAction.sendKeys(address1, adress1);
	}

	public void enterCompanyName(String compname) {

		ReadAction.sendKeys(comname, compname);
	}

	public void enterLastName(String lstname) {

		ReadAction.sendKeys(lname, lstname);
	}

	public void enterFirstName(String frstname) {

		ReadAction.sendKeys(fname, frstname);
	}

	public String getDeleteWarnMsg() {

		return (ReadAction.getText(ldriver, deletwarnmsg));
	}

	public boolean isDisplayedDeleteWarnMsg() {

		return (ReadAction.isDisplayed(ldriver, deletwarnmsg));
	}

	public void clickOnBackButton() {

		backbttn.click();
	}

	public void clickOnNewAddressButton() {

		newadresbtn.click();
	}

	public void clickOnDeleteButton() {

		ReadAction.JSClick(ldriver, deletebttn);
	}

	public void clickOnEditButton() {

		ReadAction.actionClick(ldriver, editbttn);
	}

	public String getAddressBookPageTitle() {

		return (ReadAction.getTitle(ldriver));
	}
}
