package com.opencart.testcase;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.pageobject.Accountpage;
import com.opencart.pageobject.Checkoutpage;
import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Loginpage;
import com.opencart.pageobject.Orderplacedpage;
import com.opencart.pageobject.Productpage;
import com.opencart.pageobject.Searchpage;
import com.opencart.pageobject.Shoppingcartpage;
import com.opencart.utilities.MyXlsReader;
import com.opencart.utilities.ReadXlsxFile;

public class TC096_COnavigtetocopgtest extends BaseClass {

	@Test(dataProvider = "existdata")
	public void checkOutNavigationFromHomePage(HashMap<String, String> hMap) {

		log.info("***** TC096_COnavigtetocopgtest Started *****");

		if (!ReadXlsxFile.isRunnable(xlsreader, "Checkout", "Testcases") || hMap.get("Runmode").equals("N")) {

			throw new SkipException("Test Method Skipped Due To Run Mode Set To N");
		}

		Homepage hmpg = new Homepage(driver);
		hmpg.clickOnMyAccountDropMenu();
		log.info("Clicked On MyAccount Drop Menu");

		Assert.assertTrue(hmpg.isDisplayedLoginOption());
		log.info("Login Option Displayed On MyAccount Drop Menu");

		Loginpage loginpg = hmpg.clickOnLoginLink();
		log.info("Clicked On Login Option From MyAccount Drop Menu");

		Assert.assertEquals(loginpg.getLoginPageTitle(), config.getLoginPageTitle());
		log.info("Navigated To Login Page: " + loginpg.getLoginPageTitle());

		loginpg.enterRegisteredEmail(hMap.get("Email"));
		loginpg.enterRegisteredPassword(hMap.get("Password"));
		Accountpage accntpg = loginpg.clickLoginButton();
		log.info("User Logged Into Accounts Page ");

		Assert.assertEquals(accntpg.getAccountPageTitle(), config.getAccountPageTitle());
		log.info("Acconts Page Title: " + accntpg.getAccountPageTitle());

		Assert.assertTrue(accntpg.isDisplayedEditInfoLink());
		log.info("Edit Info Link Displayed On Accounts Page");

		Assert.assertTrue(accntpg.isDisplayedAccountLinkOnBedcrum());
		log.info("Accont Link Displayed On BedCrum Of Accounts Page");

		hmpg.enterSearchTextField(hMap.get("Product"));
		Searchpage srchpg = hmpg.clickOnSearchButton();
		Assert.assertTrue(srchpg.getSearchPageTitle().contains(config.getSearchPageTitle()));
		log.info("User Navigated To Search Page Title: " + srchpg.getSearchPageTitle());

		Assert.assertTrue(srchpg.isDispalyediMacFromSearchCriteria());
		log.info("iMac Was Displayed On Search Page: " + srchpg.getiMacFromSearchCriteria());

		Productpage prdtpg = srchpg.clickOniMacImg();
		log.info("User Navigated To Product Page Title: " + prdtpg.getProductPageTitle());

		Assert.assertTrue(prdtpg.isDispalyedOfProductAvailabity());
		log.info("Availabity Of iMac Was Displayed On Product Page: " + prdtpg.getTexOfProductAvailabity());

		prdtpg.clickOnAddToCartButton();
		Assert.assertTrue(prdtpg.isDispalyedOfWhishlistMsg());
		log.info("Success Added To Wish-List Message Displayed: " + prdtpg.getTexOfWhishlistMsg());

		Shoppingcartpage shopcart = prdtpg.clickOnShopCartMsgLink();
		Assert.assertEquals(shopcart.getShoppingCartPageTitle(), config.getShoppingCartPageTitle());
		log.info("ShopCart Page Title: " + shopcart.getShoppingCartPageTitle());

		Assert.assertTrue(shopcart.isDisplayediMacImg());
		log.info("Success Added Product To Shopping cart Page");

		Checkoutpage chckoutpg = shopcart.clickOnCheckOutButton();
		Assert.assertEquals(chckoutpg.getCheckoutPageTitle(), config.getCheckoutPageTitle());
		log.info("Check Out Page Title: " + chckoutpg.getCheckoutPageTitle());

		chckoutpg.clickOnBillContinueButton();
		chckoutpg.clickOnShippingAddressContinueButton();
		chckoutpg.clickOnShippingMethodContinueButton();
		chckoutpg.clickOnAgreeCheckBox();
		chckoutpg.clickOnPaymentButtonContinueButton();
		Orderplacedpage orderconpg = chckoutpg.clickOnOrderConfirmButton();

		Assert.assertEquals(orderconpg.getOrderplacedPageTitle(), config.getOrderPlacedPageTitle());
		log.info("Order Confirmation Page Title: " + orderconpg.getOrderplacedPageTitle());

		Assert.assertTrue(orderconpg.isDisplayedSuccessOnBedcrum());
		Assert.assertTrue(orderconpg.isDisplayedOrderplacedMessage());
		log.info("Order Confirmation Success Message: " + orderconpg.getOrderplacedMessage());

		log.info("***** TC096_COnavigtetocopgtest Completed *****");

	}

	@DataProvider(name = "existdata")
	public Object[][] dataSupplier() {

		Object[][] data = null;
		try {
			String file = System.getProperty("user.dir") + "//testdata//testdatafile.xlsx";
			xlsreader = new MyXlsReader(file);
			data = ReadXlsxFile.getTestData(xlsreader, "newaccount", "Checkout");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
}
