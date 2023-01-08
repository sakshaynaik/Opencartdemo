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

public class TC030_LFlogininvalidattempttest extends BaseClass {

	@Test(dataProvider = "attemptest")
	public void loginWithUnsucessfullAttemps(String validdata) {

		log.info("***** TC030_logininvalidattempttest Started *****");

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
		loginpg.clickLoginButton();

		String exptres = data[3];
		boolean convertexptres = false;

		if (exptres.equalsIgnoreCase("success")) {

			convertexptres = true;

		} else if (exptres.equalsIgnoreCase("Failure")) {

			convertexptres = false;
		}

		boolean actualexptres;

		try {
			
			Assert.assertEquals(loginpg.getLoginPageTitle(), config.getLoginPageTitle());
			log.info("User Still In Loginpage Due To Invalid Credentials: " + loginpg.getLoginPageTitle());

			Assert.assertTrue(loginpg.isDisplayedWarnInvalidLoginCredential());
			log.info("Warn Message Displayed For Invalid Credentials: " + loginpg.getWarnInvalidLoginCredential());

			actualexptres = loginpg.isDisplayedWarnInvalidLoginCredential();
			
		} catch (Throwable e) {
			
			Assert.assertTrue(loginpg.isDisplayedUnsuccessfulAttemptMsgForLogin());
			log.info(
					"Unsuccessful Attempt Message For Login Displayed: " + loginpg.getUnsuccessfulAttemptMsgForLogin());
			actualexptres = false;
		}

		Assert.assertEquals(convertexptres, actualexptres);

		log.info("***** TC030_logininvalidattempttest Completed *****");

	}

	@DataProvider(name = "attemptest")
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
		JSONArray jsonarray = (JSONArray) jsonobject.get("unsuccessfulatempt");
		Object[] arr = new Object[jsonarray.size()];

		for (int i = 0; i < jsonarray.size(); i++) {

			JSONObject data = (JSONObject) jsonarray.get(i);
			Object brows = data.get("Browser");
			Object email = data.get("email");
			Object passw = data.get("password");
			Object exptr = data.get("Expectres");

			arr[i] = brows + "," + email + "," + passw + "," + exptr;
		}
		return arr;

	}
}
