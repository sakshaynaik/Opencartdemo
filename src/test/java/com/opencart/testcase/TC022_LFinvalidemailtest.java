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

public class TC022_LFinvalidemailtest extends BaseClass {

	@Test(dataProvider = "invalidemail", groups = "Smoke")
	public void loginInvalidEmailID(String invemaildata) {

		log.info("***** TC022_LFinvalidemailtest Started *****");

		String[] data = invemaildata.split(",");

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
		loginpg.clickLoginButton();

		Assert.assertEquals(loginpg.getLoginPageTitle(), config.getLoginPageTitle());
		log.info("User Still In Loginpage Due To Invalid Credentials: " + loginpg.getLoginPageTitle());

		Assert.assertTrue(loginpg.isDisplayedWarnInvalidLoginCredential());
		log.info("Warn Message Displayed For Invalid Credentials: " + loginpg.getWarnInvalidLoginCredential());

		log.info("***** TC022_LFinvalidemailtest Completed *****");
	}

	@DataProvider(name = "invalidemail")
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
		JSONArray jsonarray = (JSONArray) jsonobject.get("invaidemailvalidpassword");
		Object[] arr = new Object[jsonarray.size()];

		for (int i = 0; i < jsonarray.size(); i++) {

			JSONObject data = (JSONObject) jsonarray.get(i);
			Object brows = data.get("Browser");
			Object email = data.get("email");
			Object passw = data.get("password");

			arr[i] = brows + "," + email + "," + passw;
		}
		return arr;
	}

}
