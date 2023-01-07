package com.opencart.pageobject;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.opencart.utilities.ReadJavascriptExecutor;

public class Productpage {

	WebDriver ldriver;

	public Productpage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(name = "option[218]")
	private WebElement sizeradiobttn;

	@FindBy(xpath = "//div[@id='input-option223']//div[@class='checkbox']//input")
	private List<WebElement> checkboxbttn;

	@FindBy(css = "input[value='9']")
	private WebElement checkbttn1;

	@FindBy(xpath = "//*[@id='content']/div[1]/div[1]/ul[1]/li[1]/a/img")
	private WebElement applecinema60;

	@FindBy(css = "input[value='10']")
	private WebElement checkbttn2;

	@FindBy(css = "input[value='11']")
	private WebElement checkbttn3;

	@FindBy(id = "input-option208")
	private WebElement text;

	@FindBy(id = "input-option217")
	private WebElement slect;

	@FindBy(id = "input-option209")
	private WebElement txtbox;

	@FindBy(xpath = "//button[normalize-space()='Upload File']")
	private WebElement uploadbutton;

	@FindBy(css = "div[class='input-group date'] button[type='button']")
	private WebElement calenderbutton;

	@FindBy(css = "div[class='input-group time'] button[type='button']")
	private WebElement timebutton;

	@FindBy(id = "input-option221")
	private WebElement timefield;

	@FindBy(css = "div[class='input-group datetime'] button[type='button']")
	private WebElement datetimebutton;

	@FindBy(id = "input-quantity")
	private WebElement qtyshouldmorethan2;

	@FindBy(xpath = "//button[@id='button-cart']")
	private WebElement addtocartbttn;

	@FindBy(xpath = "/html/body/div[4]/div/div[1]/table/thead/tr[1]/th[3]")
	private WebElement nextkey;

	@FindBy(xpath = "/html/body/div[4]/div/div[1]/table/thead/tr[1]/th[2]")
	private WebElement pickerswitch;

	@FindBy(xpath = "//table[@class='table-condensed']/tbody/tr/td")
	private List<WebElement> tabledata;

	@FindBy(linkText = "shopping cart")
	private WebElement shopcartmsglink;

	@FindBy(linkText = "product comparison")
	private WebElement prdtcomparrisonlink;

	@FindBy(xpath = "//*[@id='content']/div[1]/div[1]/ul[1]/li[1]/a")
	private WebElement impaclink;

	@FindBy(xpath = "//button[@title='Previous (Left arrow key)']")
	private WebElement lftarrowkey;

	@FindBy(xpath = "//button[@title='Next (Right arrow key)']")
	private WebElement rgtarrowkey;

	@FindBy(xpath = "//button[normalize-space()='×']")
	private WebElement xbttn;

	@FindBy(xpath = "//img[@class='mfp-img']")
	private WebElement lightboximg;

	@FindBy(xpath = "//*[@id='content']/div[1]/div[1]/ul[1]/li[2]/a/img")
	private WebElement subimg_1;

	@FindBy(xpath = "//*[@id='content']/div[1]/div[1]/ul[1]/li[3]/a/img")
	private WebElement subimg_2;

	@FindBy(xpath = "//nav[@id='menu']")
	private WebElement navibar;

	@FindBy(xpath = "//li[normalize-space()='Product Code: Product 14']")
	private WebElement prdtcode;

	@FindBy(xpath = "//*[@id='content']/div[1]/div[2]/ul[1]/li[3]")
	private WebElement prdtavalbty;

	@FindBy(id = "input-quantity")
	private WebElement qtybox;

	@FindBy(xpath = "//*[@id='button-cart']")
	private WebElement addtocart;

	@FindBy(xpath = "//div[contains(text(),'Success: You have added')]")
	private WebElement whishlistmsg;

	@FindBy(linkText = "Write a review")
	private WebElement writereview;

	@FindBy(id = "input-name")
	private WebElement reviewnameboxfield;

	@FindBy(id = "input-review")
	private WebElement reviewboxfield;

	@FindBy(xpath = "//*[@id='form-review']/div[4]/div/input[5]")
	private WebElement radiobttn;

	@FindBy(id = "button-review")
	private WebElement reviewbuttonfield;

	@FindBy(xpath = "//div[contains(text(),'Thank you for your review. It has been submitted')]")
	private WebElement reviewmsg;

	@FindBy(xpath = "//div[contains(text(),'Warning: Please select a review rating!')]")
	private WebElement emptyreviewmsg;

	@FindBy(xpath = "//div[contains(text(),'Warning: Review Text must be between 25 and 1000 characters!')]")
	private WebElement unfilledreviewmsg;

	@FindBy(linkText = "wish list")
	private WebElement wishlistlink;

	@FindBy(linkText = "shopping cart")
	private WebElement shopcart;

	@FindBy(xpath = "//*[@id='content']/div[1]/div[2]/div[1]/button[1]")
	private WebElement wishlistbutton;

	@FindBy(xpath = "//*[@id='cart']/button")
	private WebElement cartbutton;

	@FindBy(xpath = "//body//header//div[@id='cart']//div//a[1]")
	private WebElement viewcart;

	@FindBy(xpath = "//*[@id='content']/div[1]/div[2]/div[1]/button[2]")
	private WebElement compareprdt;

	@FindBy(xpath = "//div[contains(text(),' Success: You have added')]")
	private WebElement comparesuccmsg;

	@FindBy(xpath = "//img[@title='iMac']")
	private WebElement imacimg;

	@FindBy(xpath = "//ul[@class='dropdown-menu pull-right']")
	private WebElement cartemptymsg;

	@FindBy(css = "div[class='input-group date'] button[type='button']")
	private WebElement hplpcalenderbttn;

	@FindBy(id = "input-quantity")
	private WebElement qtyfield;

	@FindBy(css = "div[class='datepicker-days'] th[class='picker-switch']")
	private WebElement monthyrs;

	@FindBy(xpath = "//tbody//td[@class='day old' or @class = 'day']")
	private List<WebElement> dates;

	@FindBy(css = "div[class='datepicker-days'] th[class='next']")
	private WebElement nextarrow;

	@FindBy(xpath = "//strong[normalize-space()='Checkout']")
	private WebElement checkoutlink;

//////////////////////////////////////////////////////////////////////////////////

	public Checkoutpage clickOnCheckoutLinkFromCartBox() {

		checkoutlink.click();
		return (new Checkoutpage(ldriver));
	}

	public void enterQtyForHPLP(String num) {

		qtyfield.clear();
		qtyfield.sendKeys(num);
	}

	public void enterDeliveryDateHPLP(String date) {

		hplpcalenderbttn.click();

		String[] data = date.split("-");

		while (true) {

			if (monthyrs.getText().equals(data[1])) {

				for (WebElement ref : dates) {

					if (ref.getText().equals(data[0])) {

						ref.click();
						break;
					}
				}
				break;
			} else {

				nextarrow.click();

			}
		}

	}

	public String getEmptyCartMsg() {

		return (cartemptymsg.getText());
	}

	public boolean isDisplayedEmptyCartMsg() {

		return (cartemptymsg.isDisplayed());
	}

	public void clickOnImgInMacPage() {

		imacimg.click();
	}

	public boolean isDisplayedImgInMacPage() {

		return (imacimg.isDisplayed());
	}

	public Shoppingcartpage clickOnAppleCinema30ShopcartMsgLink() {

		ReadJavascriptExecutor.clickElementByJavaScript(shopcart, ldriver);
		return (new Shoppingcartpage(ldriver));
	}

	public boolean isDisplayedImgOfAppleCinema30() {

		return (applecinema60.isDisplayed());
	}

	public void clickOnAppleCinema30RadioButton() {

		sizeradiobttn.click();
	}

	public int getSizeOfCheckBoxAppleCinema30() {

		return (checkboxbttn.size());
	}

	public void setCheckBoxAppleCinema30(int num) {

		WebElement checkbox = ldriver.findElement(
				By.xpath("//div[@id='input-option223']//div[@class='checkbox'][" + (num + 1) + "]//input"));
		checkbox.click();
	}

	public void clickOnCheckBoxAppleCinema30(String checkboxdata) {

		if (checkboxdata.contains("(+$20.00)")) {

			checkbttn1.click();

		} else if (checkboxdata.contains("(+$30.00)")) {

			checkbttn2.click();

		} else if (checkboxdata.contains("(+$40.00)")) {

			checkbttn3.click();
		}
	}

	public void enterTextFieldOfAppleCinema30(String txt) {

		text.clear();
		text.sendKeys(txt);
	}

	public void selectColorOfAppleCinema30(int num) {

		Select select = new Select(slect);
		select.selectByIndex(num);
	}

	public void enterTextBoxOfAppleCinema30(String txt) {

		txtbox.clear();
		txtbox.sendKeys(txt);
	}

	public void clickOnUploadButton() {

		uploadbutton.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void uploadFile(String path) {

		Screen screen = new Screen();

		String filenamepath = System.getProperty("user.dir") + "//sikuliximg//filenametxtfiled.png";
		String openbuttonpath = System.getProperty("user.dir") + "//sikuliximg//openbutton.png";

		Pattern filenamefield = new Pattern(filenamepath);
		Pattern openbutton = new Pattern(openbuttonpath);

		try {
			screen.wait(filenamefield, 20);
			screen.type(filenamepath, path);
			screen.click(openbutton);
			Thread.sleep(6000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Alert alert = ldriver.switchTo().alert();
		alert.accept();
	}

	public void clickOnCalenderButton() {

		calenderbutton.click();
	}

	public void setDeliveryDate(String datemonthyrs) {

		String[] data = datemonthyrs.split("-");

		while (true) {

			if (pickerswitch.getText().equals(data[1])) {

				for (WebElement date : tabledata) {

					if (date.getText().equals(data[0])) {

						date.click();
						break;
					}
				}
				break;
			} else {

				nextkey.click();
			}
		}
	}

	public void enterTimeOfDelivery(String time) {

		timefield.clear();
		timefield.sendKeys(time);
	}

	public void enterTheQtyOfApple30(String qty) {

		qtyshouldmorethan2.clear();
		qtyshouldmorethan2.sendKeys(qty);
	}

	public void clickOnAddToCartButtonForApple30() {

		addtocartbttn.click();
	}

	public Shoppingcartpage clickOnViewCartLink() {

		viewcart.click();
		return (new Shoppingcartpage(ldriver));
	}

	public void clickOnCartButton() {

		cartbutton.click();
	}

	public Shoppingcartpage clickOnShopCartMsgLink() {

		try {
			ReadJavascriptExecutor.clickElementByJavaScript(shopcartmsglink, ldriver);
		} catch (StaleElementReferenceException e) {
			ReadJavascriptExecutor.clickElementByJavaScript(shopcartmsglink, ldriver);
		}
		return (new Shoppingcartpage(ldriver));
	}

	public void clickOnAddToWishlistButton() {

		wishlistbutton.click();
	}

	public Wishlistpage clickOnWishListLink() {

		wishlistlink.click();
		return (new Wishlistpage(ldriver));
	}

	public boolean isDisplayedUnfilledRevieMsg() {

		return (unfilledreviewmsg.isDisplayed());
	}

	public String getTextUnfilledRevieMsg() {

		return (unfilledreviewmsg.getText());
	}

	public boolean isDisplayedEmptyFieldRevieMsg() {

		return (emptyreviewmsg.isDisplayed());
	}

	public String getEmptyFieldRevieMsg() {

		return (emptyreviewmsg.getText());
	}

	public boolean isDisplayedReviewMsg() {

		return (reviewmsg.isDisplayed());
	}

	public String getTextReviewMsg() {

		return (reviewmsg.getText());
	}

	public void clickOnReviewContinueButton() {

		reviewbuttonfield.click();
	}

	public void clickOnRadioButton() {

		radiobttn.click();
	}

	public void enterReviewBoxField(String name) {

		reviewboxfield.clear();
		reviewboxfield.sendKeys(name);
	}

	public void enterReviewNameField(String name) {

		reviewnameboxfield.clear();
		reviewnameboxfield.sendKeys(name);
	}

	public void clickOnWriteReviewLinkTest() {

		writereview.click();
	}

	public boolean isDispalyedOfWhishlistMsg() {

		return (whishlistmsg.isDisplayed());
	}

	public String getTexOfWhishlistMsg() {

		return (whishlistmsg.getText());
	}

	public void clickOnAddToCartButton() {

		addtocart.click();
	}

	public void enterNumberOfProductInQtyTextField(String txt) {

		qtybox.clear();
		qtybox.sendKeys(txt);
	}

	public boolean isDispalyedOfProductAvailabity() {

		return (prdtavalbty.isDisplayed());
	}

	public String getTexOfProductAvailabity() {

		return (prdtavalbty.getText());
	}

	public boolean isDispalyedOfProductCode() {

		return (prdtcode.isDisplayed());
	}

	public String getTexOfProductCode() {

		return (prdtcode.getText());
	}

	public boolean isDisplayedNavigatonBar() {

		return (navibar.isDisplayed());
	}

	public void clickOnSubiMacImg_2() {

		subimg_2.click();
	}

	public void clickOnSubiMacImg_1() {

		subimg_1.click();
	}

	public void keyBoardActionsForTumbnail_2() {

		Actions action = new Actions(ldriver);
		action.click(subimg_2).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT)
				.sendKeys(Keys.ESCAPE).build().perform();
	}

	public void keyBoardActionsForTumbnail_1() {

		Actions action = new Actions(ldriver);
		action.click(subimg_1).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT)
				.sendKeys(Keys.ESCAPE).build().perform();
	}

	public void clickOnLightBoxImg() {

		lightboximg.click();
	}

	public void clickOnLeftArrowKey() {

		lftarrowkey.click();
	}

	public void clickOnRightArrowKey() {

		rgtarrowkey.click();
	}

	public void clickOnXCloseButton() {

		xbttn.click();

	}

	public void clickOniMacImg() {

		impaclink.click();
	}

	public Productcomparisionpage clickOnProductComparsionLink() {

		prdtcomparrisonlink.click();
		return (new Productcomparisionpage(ldriver));
	}

	public String getAttributeCompareProductButton(String title) {

		return (compareprdt.getAttribute(title));
	}

	public boolean isDisplayedComapreProductSuccessMessage() {

		return (comparesuccmsg.isDisplayed());
	}

	public String getComapreProductSuccessMessage() {

		return (comparesuccmsg.getText());
	}

	public void clickOnCompareProductButton() {

		compareprdt.click();
	}

	public void navigateToBackPage() {

		ldriver.navigate().back();
	}

	public String getProductPageTitle() {

		return (ldriver.getTitle());
	}

}
