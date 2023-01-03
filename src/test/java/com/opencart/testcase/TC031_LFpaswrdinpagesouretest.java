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

public class TC031_LFpaswrdinpagesouretest extends BaseClass {

	@Test(dataProvider = "passwordcredentials")
	public void loginForPasswordVisibiltyInPageSource(String passdata) {

		log.info("***** TC031_LFpaswrdinpagesouretest Started *****");

		String[] data = passdata.split(",");

		Homepage hmpg = new Homepage(driver);
		hmpg.clickOnMyAccountDropMenu();
		Assert.assertTrue(hmpg.isDisplayedLoginOption());
		log.info("Login Option Displayed On MyAccount Drop Menu");

		Loginpage loginpg = hmpg.clickOnLoginLink();
		log.info("Clicked On Login Option From MyAccount Drop Menu");

		Assert.assertEquals(loginpg.getLoginPageTitle(), config.getLoginPageTitle());
		log.info("Navigated To Login Page: " + loginpg.getLoginPageTitle());

		loginpg.enterRegisteredPassword(data[0]);
		loginpg.clickLoginButton();

		Assert.assertTrue(loginpg.getAttributeOfPasswordField("value") == null);
		log.info("Password Is Not Visible On Page Source And Test Passed");

		log.info("***** TC031_LFpaswrdinpagesouretest Completed *****");

	}

	@DataProvider(name = "passwordcredentials")
	public Object[] dataSupplier() {

		JSONParser parser = new JSONParser();
		Object object = null;

		try {
			String filepath = System.getProperty("user.dir") + "//jsonfiles//Login.json";
			FileReader reader = new FileReader(filepath);
			object = parser.parse(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject jsonobject = (JSONObject) object;
		JSONArray jsonarray = (JSONArray) jsonobject.get("passwordvisiblity");
		Object[] arr = new Object[jsonarray.size()];

		for (int i = 0; i < jsonarray.size(); i++) {

			JSONObject data = (JSONObject) jsonarray.get(i);
			Object passw = data.get("password");

			arr[i] = passw;
		}
		return arr;
	}
}
