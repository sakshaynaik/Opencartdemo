package com.opencart.zdatadriven;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.pageobject.Accountpage;
import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Loginpage;
import com.opencart.pageobject.Productpage;
import com.opencart.pageobject.Searchpage;
import com.opencart.pageobject.Shoppingcartpage;

public class TC07_DDJsonFileSearchTest extends Baseclassdatadriven {

	@Test(dataProvider = "validcredentials")
	public void searchForDynamicProduct(String validdata) {

		log.info("***** TC07_DDJsonFileSearchTest Started *****");

		String[] data = validdata.split(",");

		setBrowser(data[0]);
		Homepage hmpg = new Homepage(driver);
		hmpg.clickOnMyAccountDropMenu();
		Assert.assertTrue(hmpg.isDisplayedLoginOption());
		log.info("Login Option Displayed On MyAccount Drop Menu");

		Loginpage loginpg = hmpg.clickOnLoginLink();
		log.info("Clicked On Login Option From MyAccount Drop Menu");

		Assert.assertEquals(loginpg.getLoginPageTitle(), config.getLoginPageTitle());
		log.info("Navigated To Login Page: " + loginpg.getLoginPageTitle());

		loginpg.enterRegisteredEmail(data[1]);
		loginpg.enterRegisteredPassword(data[2]);
		Accountpage accntpg = loginpg.clickLoginButton();
		log.info("User Logged Into Accounts Page ");

		Assert.assertEquals(accntpg.getAccountPageTitle(), config.getAccountPageTitle());
		log.info("Acconts Page Title: " + accntpg.getAccountPageTitle());

		Assert.assertTrue(accntpg.isDisplayedEditInfoLink());
		log.info("Edit Info Link Displayed On Accounts Page");

		hmpg.enterSearchTextField(data[3]);
		Searchpage srchpg = hmpg.clickOnSearchButton();
		Assert.assertTrue(srchpg.getSearchPageTitle().contains(config.getSearchPageTitle()));
		log.info("User Navigated To Search Page Title: " + srchpg.getSearchPageTitle());

		Productpage prdtpg = srchpg.clickOnDynamicWebElement(data[4]);
		log.info("User Navigated To Product Page Title: " + prdtpg.getProductPageTitle());

		prdtpg.clickOnAddToCartButton();
		Assert.assertTrue(prdtpg.isDispalyedOfWhishlistMsg());
		log.info("Success Added To Wish-List Message Displayed: " + prdtpg.getTexOfWhishlistMsg());

		Shoppingcartpage shopcart = prdtpg.clickOnShopCartMsgLink();
		Assert.assertEquals(shopcart.getShoppingCartPageTitle(), config.getShoppingCartPageTitle());
		log.info("ShopCart Page Title: " + shopcart.getShoppingCartPageTitle());

		Assert.assertTrue(shopcart.isDisplayedDynamicWebElement(data[4]));
		log.info("Product Displayed On The Shopping Cart Page");
		
		shopcart.clickOnRemoveButtonFromCartPage();
		log.info("Product Successfully Removed From Shopping CartPage Table");

		log.info("***** TC07_DDJsonFileSearchTest Completed *****");

	}

	@DataProvider(name = "validcredentials")
	public Object[] dataSupplier() {

		JSONParser parser = new JSONParser();
		Object object = null;

		try {
			String filepath = System.getProperty("user.dir") + "//jsonfiles//dynamictest.json";
			FileReader reader = new FileReader(filepath);
			object = parser.parse(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject jsonobject = (JSONObject) object;
		JSONArray jsonarray = (JSONArray) jsonobject.get("dynamicprduct");
		Object[] arr = new Object[jsonarray.size()];

		for (int i = 0; i < jsonarray.size(); i++) {

			JSONObject data = (JSONObject) jsonarray.get(i);
			Object brows = data.get("Browser");
			Object email = data.get("email");
			Object password = data.get("password");
			Object muti = data.get("mutiprdt");
			Object singl = data.get("singleprdt");

			arr[i] = brows + "," + email + "," + password + "," + muti + "," + singl;
		}
		return arr;

	}

}