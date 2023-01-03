package com.opencart.testcase;

import java.util.HashMap;

import org.junit.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.pageobject.Accountpage;
import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Loginpage;
import com.opencart.pageobject.Wishlistpage;
import com.opencart.utilities.MyXlsReader;
import com.opencart.utilities.ReadXlsxFile;

public class TC085_WLdefaultwishlstmsgtest extends BaseClass {

	@Test(dataProvider = "existdata")
	public void wishListPageIntialMsg(HashMap<String, String> hMap) {

		log.info("***** TC085_WLdefaultwishlstmsgtest Completed *****");

		if (!ReadXlsxFile.isRunnable(xlsreader, "Wishlist", "Testcases") || hMap.get("Runmode").equals("N")) {

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

		Wishlistpage wishlstpg = hmpg.clickOnWishlistHeaderLink();
		Assert.assertEquals(wishlstpg.getWishListPageTitle(), config.getWishlistPageTitle());
		log.info("WishList Page Title: " + wishlstpg.getWishListPageTitle());
		
		Assert.assertTrue(wishlstpg.isDisplayedEmptyTextOnWishListPage());
		log.info("Empty Text Present On WishList Page: " + wishlstpg.getEmptyTextOnWishListPage());
		
		accntpg = wishlstpg.clickOnContinueButton();
		Assert.assertEquals(accntpg.getAccountPageTitle(), config.getAccountPageTitle());
		log.info("Acconts Page Title: " + accntpg.getAccountPageTitle());
		
		log.info("***** TC085_WLdefaultwishlstmsgtest Completed *****");

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
