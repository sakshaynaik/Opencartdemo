package com.opencart.testcase;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Loginpage;
import com.opencart.pageobject.Registerationpage;
import com.opencart.pageobject.Rewardspointpage;

public class TC126_RPrewardproductstest extends BaseClass {

	@Test(dataProvider = "validcredentials")
	public void rewardPointsOfPurchasedProducts(String validdata) {

		log.info("***** TC126_RPrewardproductstest Started *****");

		String[] data = validdata.split(",");

		Homepage hmpg = new Homepage(driver);
		hmpg.clickOnMyAccountDropMenu();
		Assert.assertTrue(hmpg.isDisplayedLoginOption());
		log.info("Login Option Displayed On MyAccount Drop Menu");

		Registerationpage regpg = hmpg.clickOnRegisterLink();
		Assert.assertEquals(regpg.getRegPageTitle(), config.getRegisterationPageTitle());
		log.info("Registration Page Title: " + regpg.getRegPageTitle());

		regpg.clickOnRewardPointsLink();
		Loginpage loginpg = new Loginpage(driver);
		Assert.assertEquals(loginpg.getLoginPageTitle(), config.getLoginPageTitle());
		log.info("Navigated To Login Page: " + loginpg.getLoginPageTitle());

		loginpg.enterRegisteredEmail(data[1]);
		loginpg.enterRegisteredPassword(data[2]);
		loginpg.clickLoginButton();

		Rewardspointpage rewrdpg = new Rewardspointpage(driver);
		Assert.assertEquals(rewrdpg.getRewardsPointPageTitle(), rewrdpg.getRewardsPointPageTitle());
		log.info("RewardsPoint Page Title: " + rewrdpg.getRewardsPointPageTitle());

		Assert.fail("Order Placed Are Not Getting Approved And Hence Not Able To Test");

		log.info("***** TC126_RPrewardproductstest Completed *****");
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
