package com.opencart.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.utilities.ReadAction;

public class Contactuspage {

	WebDriver ldriver;

	public Contactuspage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//div[@class='panel-body']//div[@class='row']")
	private WebElement contactuspanelbody;

	@FindBy(id = "input-name")
	private WebElement name;

	@FindBy(id = "input-email")
	private WebElement email;

	@FindBy(id = "input-enquiry")
	private WebElement enquiry;

	@FindBy(xpath = "//input[@value='Submit']")
	private WebElement submittbttn;

	@FindBy(xpath = "//div[contains(text(),'E-Mail Address does not appear to be valid!')]")
	private WebElement invalidemailmsg;

	///////////////////////////////////////////////////////////////////////

	public String getInvalidEmailMsg() {

		return (invalidemailmsg.getText());
	}

	public boolean isDisplayedInvalidEmailMsg() {

		return (invalidemailmsg.isDisplayed());
	}

	public Contactuspage clickOnSubmittButton() {

		submittbttn.click();
		return (new Contactuspage(ldriver));
	}

	public void enterEnquiryTextField(String enquiryfld) {

		ReadAction.sendKeys(enquiry, enquiryfld);
	}

	public void enterEmailAddressTextField(String emailaddress) {

		email.sendKeys(emailaddress);
	}

	public void enterYourNameTextField(String yourname) {

		name.sendKeys(yourname);
	}

	public String getContactUsPanelBody() {

		return (contactuspanelbody.getText());
	}

	public boolean isDisplayedContactUsPanelBody() {

		return (contactuspanelbody.isDisplayed());
	}

	public String getContactUsPageTitle() {

		return (ldriver.getTitle());
	}

	public void navigateToBackPage() {

		ldriver.navigate().back();
	}
}
