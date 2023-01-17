package com.opencart.zdatadriven;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.pageobject.Accountpage;
import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Loginpage;
import com.opencart.pageobject.Productpage;
import com.opencart.pageobject.Searchpage;
import com.opencart.pageobject.Shoppingcartpage;
import com.opencart.utilities.MyXlsReader;
import com.opencart.utilities.ReadXlsxFile;

public class TC06_DDSearchProductRandomTest extends Baseclassdatadriven {

	@Test(dataProvider = "validcredentials")
	public void searchAnyDynamicProduct(HashMap<String, String> hMap) {

		log.info("***** TC06_DDSearchProductRandomTest Started *****");

		if (!ReadXlsxFile.isRunnable(xlsreader, "searchproductTest", "Testcases") || hMap.get("Runmode").equals("N")) {

			throw new SkipException("Test Method Skipped Due To Run Mode Set To N");
		}

		setBrowser(hMap.get("Browser"));
		Homepage hmpg = new Homepage(driver);
		hmpg.clickOnMyAccountDropMenu();
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

		hmpg.enterSearchTextField(hMap.get("Brand"));
		Searchpage srchpg = hmpg.clickOnSearchButton();
		Assert.assertTrue(srchpg.getSearchPageTitle().contains(config.getSearchPageTitle()));
		log.info("User Navigated To Search Page Title: " + srchpg.getSearchPageTitle());
		
		String exceptresult = hMap.get("ExpectedResult");
		boolean convexpres = false;
		boolean convactres;
		
		if(exceptresult.equals("Success")) {
			
			convexpres = true;
			
		}else if(exceptresult.equals("Failure")) {
			
			convexpres = false;
		}
		
		try {
			
		Productpage prdtpg = srchpg.clickOnDynamicWebElement(hMap.get("Product"));
		log.info("User Navigated To Product Page Title: " + prdtpg.getProductPageTitle());

		prdtpg.clickOnAddToCartButton();
		Assert.assertTrue(prdtpg.isDispalyedOfWhishlistMsg());
		log.info("Success Added To Wish-List Message Displayed: " + prdtpg.getTexOfWhishlistMsg());

		Shoppingcartpage shopcart = prdtpg.clickOnShopCartMsgLink();
		Assert.assertEquals(shopcart.getShoppingCartPageTitle(), config.getShoppingCartPageTitle());
		log.info("ShopCart Page Title: " + shopcart.getShoppingCartPageTitle());

		convactres = shopcart.isDisplayedDynamicWebElement(hMap.get("Product"));
		Assert.assertTrue(shopcart.isDisplayedDynamicWebElement(hMap.get("Product")));
		log.info("Product Displayed On The Shopping Cart Page");
		
		shopcart.clickOnRemoveButtonFromCartPage();
		log.info("Product Successfully Removed From Shopping CartPage Table");
		
		}catch(Throwable e) {
			
			Assert.assertTrue(srchpg.getSearchPageTitle().contains(config.getSearchPageTitle()));
			log.info("User Navigated To Search Page Title: " + srchpg.getSearchPageTitle());
			
			convactres = false;
		}
		
		Assert.assertEquals(convexpres, convactres);

		log.info("***** TC06_DDSearchProductRandomTest Completed *****");

	}

	@DataProvider(name = "validcredentials")
	public Object[] dataSupplier() {

		Object[] data = null;
		try {
			String path = System.getProperty("user.dir") + "//testdata//datadrivenfile.xlsx";
			xlsreader = new MyXlsReader(path);
			data = ReadXlsxFile.getTestData(xlsreader, "searchproduct", "Data");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
}