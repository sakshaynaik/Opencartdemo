package com.opencart.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.opencart.utilities.ReadAction;
import com.opencart.utilities.ReadJavascriptExecutor;

public class Searchpage {

	WebDriver ldriver;

	public Searchpage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "input-search")
	private WebElement searchcrteria;

	@FindBy(xpath = "//*[@id='content']/div[3]/div/div")
	private WebElement imacprod;

	@FindBy(id = "button-search")
	private WebElement srchcriterabttn;

	@FindBy(id = "description")
	private WebElement checkbox;

	@FindBy(name = "category_id")
	private WebElement serchcategory;

	@FindBy(name = "sub_category")
	private WebElement serchbysubcategory;

	@FindBy(id = "list-view")
	private WebElement listview;

	@FindBy(id = "grid-view")
	private WebElement gridview;

	@FindBy(xpath = "//*[@id='content']/div[3]/div/div/div[1]/a/img")
	private WebElement clickOnImg;

	@FindBy(linkText = "iMac")
	private WebElement clickOnImacLinkText;

	@FindBy(css = "div[class='caption'] h4 a")
	private WebElement applecinema30link;

	@FindBy(xpath = "//*[@id='content']/div[3]/div/div/div[2]/div[2]/button[1]")
	private WebElement clickOnaddcart;

	@FindBy(xpath = "//div[contains(text(), 'Success: You have added')]")
	private WebElement addtocartmsg;

	@FindBy(xpath = "//*[@id='content']/div[3]/div/div/div[2]/div[2]/button[2]")
	private WebElement clickwishlist;

	@FindBy(xpath = "//div[contains(text(),'You must')]")
	private WebElement addtowishwithoutloginlistmsg;

	@FindBy(xpath = "//*[@id='content']/div[3]/div/div/div[2]/div[2]/button[3]")
	private WebElement comparelist;

	@FindBy(id = "compare-total")
	private WebElement compareprdlink;

	@FindBy(id = "input-sort")
	private WebElement sortby;

	@FindBy(id = "input-limit")
	private WebElement showby;

	@FindBy(xpath = "//div[@class='row']/div[contains(@class,'product-layout product-grid col-lg-3')]//div[@class='image']")
	private List<WebElement> randomimg;

	@FindBy(linkText = "Product Compare (0)")
	private WebElement prdlinktext;

	@FindBy(xpath = "//*[@id='content']/div[3]/div/div/div[1]/a/img")
	private WebElement iphoneImg;

	@FindBy(linkText = "product comparison")
	private WebElement compareprdlink_1;

	@FindBy(xpath = "//*[@id='content']/div[3]/div/div")
	private WebElement imacprodt;

	@FindBy(xpath = "//*[@id='content']/p[2]")
	private WebElement serchwarnmsg;

	@FindBy(xpath = "//*[@id='content']/div[3]/div[1]/div")
	private WebElement prdthumb;

	@FindBy(xpath = "//*[@id='content']/div[3]/div[4]/div")
	private WebElement prdmacpro;
	
	@FindBy(xpath = "//div[@class='row']/div/div[@class='product-thumb']//h4/a")
	private List<WebElement> elements;

/////////////////////////////////////////////////////////////////////////////////
	
	public Productpage clickOnDynamicWebElement(String text) {

		ReadAction.clickOnDynamicElement(elements , text);
        return (new Productpage(ldriver));
	}

	public Productpage clickOnAppleCinemaLink() {

		applecinema30link.click();
		return (new Productpage(ldriver));

	}

	public Productcomparisionpage clickOnCompareProductLink_1() {

		ReadJavascriptExecutor.clickElementByJavaScript(compareprdlink_1, ldriver);
		return (new Productcomparisionpage(ldriver));
	}

	public String getTextiPhoneImg() {

		return (iphoneImg.getText());

	}

	public boolean isDisplayediPhoneImg() {

		return (iphoneImg.isDisplayed());

	}

	public Productcomparisionpage clickOnProductCompareLink_0() {

		prdlinktext.click();
		return (new Productcomparisionpage(ldriver));
	}

	public void keyBoardActionForSelecting(String txt) {

		Actions action = new Actions(ldriver);
		action.click(searchcrteria).sendKeys(txt).sendKeys(Keys.TAB).sendKeys(Keys.SPACE).sendKeys(Keys.TAB, Keys.TAB)
				.sendKeys(Keys.TAB, Keys.TAB).sendKeys(Keys.ENTER).build().perform();
	}

	public Productpage clickOnRandomImg(int num) {

		WebElement img = ldriver
				.findElement(By.xpath("//div[@class='row']/div[contains(@class,'product-layout product-grid col-lg-3')]"
						+ "[" + (num + 1) + "]//div[@class='image']"));
		img.click();
		return (new Productpage(ldriver));
	}

	public int getSizeOfImg() {

		return (randomimg.size());
	}

	public void selectShowByVisibleText(int num) {

		Select select = new Select(showby);
		select.selectByIndex(num);
	}

	public void selectSortByVisibleText(String txt) {

		Select select = new Select(sortby);
		select.selectByVisibleText(txt);
	}

	public Productcomparisionpage clickOnCompareProductLink() {

		ReadJavascriptExecutor.clickElementByJavaScript(compareprdlink, ldriver);
		return (new Productcomparisionpage(ldriver));
	}

	public void navigateBackPage() {

		ldriver.navigate().back();
	}

	public String getAttributeOfCompareListButton(String att) {

		return (comparelist.getAttribute(att));

	}

	public void hoverMouseOnCompareListButton() {

		Actions action = new Actions(ldriver);
		action.moveToElement(comparelist).build().perform();

	}

	public void clickOnCompareListButton() {

		ReadJavascriptExecutor.clickElementByJavaScript(comparelist, ldriver);

	}

	public String getAddToWhishlistWarnLoginMsg() {

		return (addtowishwithoutloginlistmsg.getText());
	}

	public boolean isDispalyedAddToWhishlistWarnLoginMsg() {

		return (addtowishwithoutloginlistmsg.isDisplayed());
	}

	public void clickOnAddToWhishlistButton() {

		ReadJavascriptExecutor.clickElementByJavaScript(clickwishlist, ldriver);
	}

	public String getAddToCartMsg() {

		return (addtocartmsg.getText());
	}

	public boolean isDispalyedAddToCartMsg() {

		return (addtocartmsg.isDisplayed());
	}

	public void clickOnAddToCartButton() {

		clickOnaddcart.click();
	}

	public Productpage clickOniMacProLink() {

		clickOnImacLinkText.click();
		return (new Productpage(ldriver));
	}

	public Productpage clickOniMacImg() {

		clickOnImg.click();
		return (new Productpage(ldriver));
	}

	public void clickOnGridView() {

		gridview.click();
	}

	public void clickOnListView() {

		listview.click();
	}

	public void selectSearchMainCategoryByText(String txt) {

		Select select = new Select(serchcategory);
		select.selectByVisibleText(txt);
	}

	public void selectSearchSubCategoryByIndex(int num) {

		Select select = new Select(serchcategory);
		select.selectByIndex(num);
	}

	public void clickSearchSubcategoryCheckBox() {

		serchbysubcategory.click();
	}

	public void clickPorductDescriptionCheckBox() {

		checkbox.click();
	}

	public void clickOnSearchButtonOfSearchCriteria() {

		srchcriterabttn.click();
	}

	public String getiMacFromSearchCriteria() {

		return (imacprod.getText());
	}

	public boolean isDispalyediMacFromSearchCriteria() {

		return (imacprod.isDisplayed());
	}

	public void enterSearchCriteriaField(String data) {

		searchcrteria.sendKeys(data);
	}

	public String getAttributeOfSearchCriteria(String attribute) {

		return (searchcrteria.getAttribute(attribute));
	}

	public String getProductMacProThumb() {

		return (prdmacpro.getText());
	}

	public boolean isDispalyedProductMacProThumb() {

		return (prdmacpro.isDisplayed());
	}

	public String getProductMacThumb() {

		return (prdthumb.getText());
	}

	public boolean isDispalyedProductMacThumb() {

		return (prdthumb.isDisplayed());
	}

	public String getSearchNoProductMsg() {

		return (serchwarnmsg.getText());
	}

	public boolean isDispalyedSearchNoProductMsg() {

		return (serchwarnmsg.isDisplayed());
	}

	public String getIMacProductThumb() {

		return (imacprodt.getText());
	}

	public boolean isDispalyedIMacProductThumb() {

		return (imacprodt.isDisplayed());
	}

	public String getSearchPageTitle() {

		return (ldriver.getTitle());
	}

}