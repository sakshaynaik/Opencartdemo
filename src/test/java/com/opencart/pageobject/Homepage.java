package com.opencart.pageobject;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.utilities.ReadJavascriptExecutor;

public class Homepage {

	WebDriver ldriver;

	public Homepage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "wishlist-total")
	private WebElement wishlistlink;

	@FindBy(xpath = "//a[@title='My Account']")
	private WebElement myaccount;

	@FindBy(linkText = "Register")
	private WebElement register;

	@FindBy(linkText = "Login")
	private WebElement login;

	@FindBy(linkText = "Your Store")
	private WebElement yourstorelogo;

	@FindBy(linkText = "Logout")
	private WebElement logoutoption;

	@FindBy(name = "search")
	private WebElement searchtxtfld;

	@FindBy(xpath = "//*[@id='search']/span/button")
	private WebElement searchbttn;

	@FindBy(xpath = "//ul[@class='nav navbar-nav']/li")
	private List<WebElement> navigbaroption;

	@FindBy(xpath = "//ul[@class='list-inline']/li")
	private List<WebElement> navigpulright;

	@FindBy(xpath = "//div[@class='row']//div[@class='col-sm-3']//li[1]")
	private List<WebElement> allfooteroption;

	@FindBy(linkText = "Site Map")
	private WebElement sitemap;

	@FindBy(linkText = "Desktops")
	private WebElement desktop;

	@FindBy(linkText = "Show All Desktops")
	private WebElement showalloptiontext;

	@FindBy(xpath = "//div[4]//div[1]//div[3]//button[3]")
	private WebElement compareprdtbttn;

	@FindBy(xpath = "//div[contains(text(), 'Success: You have added')]")
	private WebElement compareprdtmsg;

	@FindBy(linkText = "product comparison")
	private WebElement prdtcomplink;

	@FindBy(xpath = "//*[@id='top-links']/ul/li[4]/a")
	private WebElement clickonshopcart;

	@FindBy(xpath = "//*[@id='content']/div[2]/div[2]/div/div[3]/button[2]")
	private WebElement clickonwishlistbutton;

	@FindBy(linkText = "wish list")
	private WebElement wishlislink;

	@FindBy(linkText = "Wish List (0)")
	private WebElement wishlisheaderlink;

	@FindBy(xpath = "//a[@title='Shopping Cart']")
	private WebElement shopcartheaderlink;

	@FindBy(xpath = "//a[normalize-space()='PC (0)']")
	private WebElement pc0link;
	
	@FindBy(xpath = "//a[@title='Checkout']")
	private WebElement chckoption;
	
	//////////////////////////////////////////////////////////////////
	
	public Shoppingcartpage clickOnCheckoutHeaderOption() {

		chckoption.click();
		return (new Shoppingcartpage(ldriver));
	}
	
	public PCpage clickOnPCLink() {

		pc0link.click();
		return (new PCpage(ldriver));
	}

	public Shoppingcartpage clickOnShopCartHeaderLink() {

		shopcartheaderlink.click();
		return (new Shoppingcartpage(ldriver));
	}

	public void switchToWindowForWishlistaction() {

		Actions action = new Actions(ldriver);
		action.keyDown(Keys.CONTROL).click(wishlisheaderlink).keyUp(Keys.CONTROL).build().perform();
		Set<String> twowindow = ldriver.getWindowHandles();

		for (String windowid : twowindow) {

			ldriver.switchTo().window(windowid);

			if (ldriver.getTitle().equalsIgnoreCase("Account Login")) {

				break;
			}
		}
	}

	public Wishlistpage clickOnWishlistHeaderLink() {

		wishlisheaderlink.click();
		return (new Wishlistpage(ldriver));
	}

	public void closeWindow() {

		ldriver.close();
	}

	public void clickOnWishlistButton() {

		clickonwishlistbutton.click();
	}

	public Homepage clickOnYourStoreLogo() {

		yourstorelogo.click();
		return (new Homepage(ldriver));

	}

	public Wishlistpage clickOnWishlistLink() {

		ReadJavascriptExecutor.clickElementByJavaScript(wishlistlink, ldriver);
		return (new Wishlistpage(ldriver));

	}

	public Shoppingcartpage clickOnShopCartLink() {

		clickonshopcart.click();
		return (new Shoppingcartpage(ldriver));

	}

	public Productcomparisionpage clickOnProductCompareLink() {

		prdtcomplink.click();
		return (new Productcomparisionpage(ldriver));
	}

	public boolean isDisplayedMessageForCompareProduct() {

		return (compareprdtmsg.isDisplayed());
	}

	public String getTextMessageForCompareProduct() {

		return (compareprdtmsg.getText());
	}

	public String getAttributeCompareProductButton(String txt) {

		return (compareprdtbttn.getAttribute(txt));
	}

	public void clickOnCompareProductButton() {

		compareprdtbttn.click();
	}

	public Desktoppage clickOnShowAllOptions() {

		showalloptiontext.click();
		return (new Desktoppage(ldriver));
	}

	public void hoverMouseOnDesktop() {

		Actions action = new Actions(ldriver);
		action.moveToElement(desktop).build().perform();

	}

	public Searchpage keyBoardActionForSearchField() {

		Actions action = new Actions(ldriver);
		action.click(searchtxtfld).sendKeys(Keys.TAB, Keys.ENTER).build().perform();
		return (new Searchpage(ldriver));
	}

	public Sitemappage clickOnSiteMap() {

		sitemap.click();
		return (new Sitemappage(ldriver));
	}

	public void clickOnRandomFooterOption(int randopt) {

		WebElement option = ldriver.findElement(By.xpath(
				"//div[@class='row']//div[@class='col-sm-3'][" + (randopt + 1) + "]//li[" + (randopt + 1) + "]"));
		option.click();
	}

	public int getSizeOfFooterOption() {

		return (allfooteroption.size());
	}

	public void clickOnRandomNavPulRight(int randopt) {

		WebElement option = ldriver.findElement(By.xpath("//ul[@class='list-inline']/li[" + (randopt + 1) + "]"));
		option.click();
	}

	public int getSizeOfNavPulRight() {

		return (navigpulright.size());
	}

	public void clickOnRandomNavigationOption(int randopt) {

		ldriver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[" + (randopt + 1) + "]"));
	}

	public int getSizeOfNavigationBarOption() {

		return (navigbaroption.size());
	}

	public String getAttributeForSearchField(String attribute) {

		return (searchbttn.getAttribute(attribute));

	}

	public Searchpage clickOnSearchButton() {

		searchbttn.click();
		return (new Searchpage(ldriver));
	}

	public void clearSearchTextField() {

		searchtxtfld.clear();
	}

	public void enterSearchTextField(String seachfld) {

		searchtxtfld.clear();
		searchtxtfld.sendKeys(seachfld);
	}

	public void monkeytest() {

		ReadJavascriptExecutor.attack(ldriver);
	}

	public void highletLoginOptionDefect() {

		ReadJavascriptExecutor.drawBorder(login, ldriver);
		ReadJavascriptExecutor.scrollIntoView(login, ldriver);

	}

	public boolean isDisplayedLogoutOption() {

		return (logoutoption.isDisplayed());
	}

	public boolean isDisplayedLoginOption() {

		return (login.isDisplayed());
	}

	public Loginpage clickOnLoginLink() {

		login.click();
		return (new Loginpage(ldriver));
	}

	public void clickOnMyAccountDropMenu() {

		myaccount.click();
	}

	public Registerationpage clickOnRegisterLink() {

		register.click();
		return (new Registerationpage(ldriver));
	}

	public boolean isDisplayedRegisterOption() {

		return (register.isDisplayed());
	}

	public String getHomePageTitle() {

		return (ldriver.getTitle());
	}

}
