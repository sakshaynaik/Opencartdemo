package com.opencart.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.utilities.ReadAction;

public class Productreturnpage {

	WebDriver ldriver;

	public Productreturnpage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//p[contains(text(),'Please complete the form below to request an RMA')]")
	private WebElement prdreturnmag;

	@FindBy(xpath = "//label[normalize-space()='Dead On Arrival']")
	private WebElement delayonarrival;

	@FindBy(xpath = "//label[normalize-space()='Faulty, please supply details']")
	private WebElement faltysupply;

	@FindBy(xpath = "//label[normalize-space()='Order Error']")
	private WebElement othererror;

	@FindBy(xpath = "//label[normalize-space()='Other, please supply details']")
	private WebElement othersuppydetail;

	@FindBy(xpath = "//label[normalize-space()='Received Wrong Item']")
	private WebElement receivdwrngitm;

	@FindBy(xpath = "//input[@value='Submit']")
	private WebElement submitbttn;

	@FindBy(xpath = "//a[normalize-space()='Back']")
	private WebElement backbttn;

	@FindBy(xpath = "//p[contains(text(),'Thank you for submitting your return request.')]")
	private WebElement returnsuccessmsg;

	@FindBy(xpath = "//a[normalize-space()='Continue']")
	private WebElement clickoncontine;

	@FindBy(id = "input-email")
	private WebElement emailfld;

	@FindBy(xpath = "//div[.='E-Mail Address does not appear to be valid!']")
	private WebElement invalidemailmsg;

	@FindBy(id = "input-firstname")
	private WebElement fname;

	@FindBy(id = "input-lastname")
	private WebElement lname;

	@FindBy(id = "input-telephone")
	private WebElement telephone;

	@FindBy(id = "input-date-ordered")
	private WebElement calenderfld;

	@FindBy(xpath = "//div[@class='table-responsive']//tbody/tr/td[6]/a")
	private List<WebElement> returnprdt;

	@FindBy(css = "div[id='content'] p")
	private WebElement emptyreturnmsg;

	@FindBy(xpath = "//tbody/tr[1]/td[6]/a[1]")
	private WebElement viewfirstreturnprdt;

	//////////////////////////////////////////////////////////////////////////////////

	public Returninformationpage clickOnFirstViewReturnProduct() {

		viewfirstreturnprdt.click();
		return (new Returninformationpage(ldriver));
	}

	public String getEmptyReturnsMessage() {

		return (emptyreturnmsg.getText());
	}

	public boolean isDisplayedEmptyReturnsMessage() {

		return (emptyreturnmsg.isDisplayed());
	}

	public Returninformationpage clickOnRandomReturnProducts(int num) {

		WebElement rtpdt = ldriver
				.findElement(By.xpath("//div[@class='table-responsive']//tbody/tr[" + (num + 1) + "]/td[6]/a"));
		rtpdt.click();
		return (new Returninformationpage(ldriver));
	}

	public int getSizeOfReturnProducts() {

		return (returnprdt.size());
	}

	public void enterFirstNameTextField(String firname) {

		ReadAction.sendKeys(fname, firname);
	}

	public void enterLastTextField(String lastname) {

		lname.clear();
		lname.sendKeys(lastname);
	}

	public void enterTelephoneTextField(String telephne) {

		telephone.clear();
		telephone.sendKeys(telephne);
	}

	public void enterCalenderTextField(String clnderfld) {

		ReadAction.sendKeys(calenderfld, clnderfld);
	}

	public String getInvalidMsgForEmail() {

		return (invalidemailmsg.getText());
	}

	public boolean isDisplayedInvalidMsgForEmail() {

		return (invalidemailmsg.isDisplayed());
	}

	public void enterEmailTextField(String email) {

		ReadAction.sendKeys(emailfld, email);
	}

	public Homepage clickOnContinueButton() {

		clickoncontine.click();
		return (new Homepage(ldriver));
	}

	public Accountpage clickOnBackButton() {

		backbttn.click();
		return (new Accountpage(ldriver));
	}

	public String getProductReturnSuccessMsg() {

		try {
			return (returnsuccessmsg.getText());

		} catch (StaleElementReferenceException e) {

			return (returnsuccessmsg.getText());
		}
	}

	public boolean isDisplayedProductReturnSuccessMsg() {
		try {
			return (returnsuccessmsg.isDisplayed());

		} catch (StaleElementReferenceException e) {

			return (returnsuccessmsg.isDisplayed());
		}
	}

	public void clickOnSubmittbutton() {

		submitbttn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickResonOfReturnRadioButton(String reason) {

		if (delayonarrival.getText().equals(reason)) {

			delayonarrival.click();

		} else if (faltysupply.getText().equals(reason)) {

			faltysupply.click();

		} else if (othersuppydetail.getText().equals(reason)) {

			othersuppydetail.click();

		} else if (receivdwrngitm.getText().equals(reason)) {

			receivdwrngitm.click();

		} else if (othererror.getText().equals(reason)) {

			othererror.click();
		}
	}

	public String getProductReturnMsg() {

		return (prdreturnmag.getText());
	}

	public boolean isDisplayedProductReturnMsg() {

		return (prdreturnmag.isDisplayed());
	}

	public String getProductReturnPageTitle() {

		return (ldriver.getTitle());
	}
}
