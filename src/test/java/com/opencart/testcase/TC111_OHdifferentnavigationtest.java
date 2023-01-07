package com.opencart.testcase;

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
import com.opencart.pageobject.Orderhistorypage;
import com.opencart.pageobject.Orderinformationpage;
import com.opencart.pageobject.Sitemappage;

public class TC111_OHdifferentnavigationtest extends BaseClass {

	@Test(dataProvider = "validcredentials")
	public void orderHistoryNavigationTest(String validdata) {

		log.info("***** TC105_CPupdatepasswordtest Started *****");

		String[] data = validdata.split(",");

		Homepage hmpg = new Homepage(driver);
		hmpg.clickOnMyAccountDropMenu();
		log.info("Clicked On MyAccount Drop Menu");

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

		Orderhistorypage orderpg = accntpg.clickOnOrderHistoryLink();
		Assert.assertEquals(orderpg.getOrderHistoryPageTitle(), config.getOrderHistoryPageTitle());
		log.info("Order History Page Title: " + orderpg.getOrderHistoryPageTitle());

		Orderinformationpage orderinfopg = orderpg.clickOnViewOrderInfo();
		Assert.assertEquals(orderinfopg.getOrderInfoPageTitle(), config.getOrderInfoPageTitle());
		log.info("Order Information Page Title: " + orderinfopg.getOrderInfoPageTitle());

		hmpg.clickOnYourStoreLogo();
		Assert.assertEquals(hmpg.getHomePageTitle(), config.getHomePageTitle());
		log.info("Navigated To Back Home Page: " + hmpg.getHomePageTitle());

		Sitemappage sitepg = hmpg.clickOnSiteMap();
		Assert.assertEquals(sitepg.getSiteMapPageTitle(), config.getSiteMapPageTitle());
		log.info("Site Map Page Title: " + sitepg.getSiteMapPageTitle());

		sitepg.clickOnOrderHistoryLink();
		Assert.assertEquals(orderpg.getOrderHistoryPageTitle(), config.getOrderHistoryPageTitle());
		log.info("Order History Page Title: " + orderpg.getOrderHistoryPageTitle());

	}

	@DataProvider(name = "validcredentials")
	public Object[] dataSupplier() {

		JSONParser parser = new JSONParser();
		Object object = null;

		try {
			String filepath = System.getProperty("user.dir") + "//jsonfiles//orderhistory.json";
			FileReader reader = new FileReader(filepath);
			object = parser.parse(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject jsonobject = (JSONObject) object;
		JSONArray jsonarray = (JSONArray) jsonobject.get("loginsearch");
		Object[] arr = new Object[jsonarray.size()];

		for (int i = 0; i < jsonarray.size(); i++) {

			JSONObject data = (JSONObject) jsonarray.get(i);
			Object brows = data.get("Browser");
			Object email = data.get("email");
			Object passw = data.get("password");
			Object prdna = data.get("productname");

			arr[i] = brows + "," + email + "," + passw + "," + prdna;
		}
		return arr;
	}
}
