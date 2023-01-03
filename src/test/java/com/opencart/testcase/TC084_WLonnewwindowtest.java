package com.opencart.testcase;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.pageobject.Accountpage;
import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Loginpage;
import com.opencart.pageobject.Wishlistpage;
import com.opencart.utilities.MyXlsReader;
import com.opencart.utilities.ReadXlsxFile;

public class TC084_WLonnewwindowtest extends BaseClass {

	@Test(dataProvider = "existdata")
	public void wishListAddProductFromNewWindow(HashMap<String, String> hMap) {

		log.info("***** TC084_WLonnewwindowtest Completed *****");

		if (!ReadXlsxFile.isRunnable(xlsreader, "Wishlist", "Testcases") || hMap.get("Runmode").equals("N")) {

			throw new SkipException("Test Method Skipped Due To Run Mode Set To N");
		}

		String windowid = driver.getWindowHandle();

		Homepage hmpg = new Homepage(driver);
		hmpg.switchToWindowForWishlistaction();
		log.info("User Clicked On Wishlist Header Link And Diverted To A New Tab");

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

		hmpg.clickOnYourStoreLogo();
		hmpg.clickOnWishlistButton();
		Assert.assertTrue(hmpg.isDisplayedMessageForCompareProduct());
		log.info("Success Message Of Wishlist added Displayed :" + hmpg.isDisplayedMessageForCompareProduct());

		Wishlistpage wishlstpg = hmpg.clickOnWishlistLink();
		Assert.assertEquals(wishlstpg.getWishListPageTitle(), config.getWishlistPageTitle());
		log.info("WishList Page Title: " + wishlstpg.getWishListPageTitle());

		Assert.assertTrue(wishlstpg.isDisplayedOniPhoneImg());
		log.info("IPhone Image Displayed On Wishlist Page");

		driver.switchTo().window(windowid);

		hmpg.clickOnYourStoreLogo();
		hmpg.clickOnWishlistButton();
		Assert.assertTrue(hmpg.isDisplayedMessageForCompareProduct());
		log.info("Success Message Of Wishlist added Displayed :" + hmpg.isDisplayedMessageForCompareProduct());

		wishlstpg = hmpg.clickOnWishlistLink();
		Assert.assertEquals(wishlstpg.getWishListPageTitle(), config.getWishlistPageTitle());
		log.info("WishList Page Title: " + wishlstpg.getWishListPageTitle());

		Assert.assertTrue(wishlstpg.isDisplayedOniPhoneImg());
		log.info("IPhone Image Displayed On Wishlist Page");

		log.info("***** TC084_WLonnewwindowtest Completed *****");
	}

	@DataProvider(name = "existdata")
	public Object[][] dataSupplier() {

		Object[][] data = null;
		try {
			String file = System.getProperty("user.dir") + "//testdata//testdatafile.xlsx";
			xlsreader = new MyXlsReader(file);
			data = ReadXlsxFile.getTestData(xlsreader, "loginaddwishlist", "Data");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

}
