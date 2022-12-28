package com.opencart.testcase;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.pageobject.Accountlogoutpage;
import com.opencart.pageobject.Accountpage;
import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Loginpage;

public class TC034_LOloggingouttest extends BaseClass {

	@Test(dataProvider = "validcredentials", groups = "Smoke")
	public void loginAndLogout(String validdata) {

		log.info("***** TC034_LOloggingouttest Started *****");

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

		Assert.assertTrue(accntpg.isDisplayedAccountLinkOnBedcrum());
		log.info("Accont Link Displayed On BedCrum Of Accounts Page");

		accntpg.clickOnMyAccountDropMenu();
		Assert.assertTrue(accntpg.isDisplayedLogoutOption());
		log.info("Logout Option Displayed On MyAccount Drop Menu");

		Accountlogoutpage acclogoutpg = accntpg.clickLogoutOption();
		Assert.assertEquals(acclogoutpg.getAccountLogoutPageTitle(), config.getAccountLogoutPageTitle());
		log.info("User Logged Out From MyAccounts Page And Navigated To Account Logout Page: "
				+ acclogoutpg.getAccountLogoutPageTitle());

		acclogoutpg.clickOnContinueButton();
		Assert.assertEquals(hmpg.getHomePageTitle(), config.getHomePageTitle());
		log.info("User Navigated To Home Page After Clicking On Continue Button From AccountLogout Page: "
				+ hmpg.getHomePageTitle());

		log.info("***** TC034_LOloggingouttest Completed *****");

	}

	@DataProvider(name = "validcredentials")
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
		JSONArray jsonarray = (JSONArray) jsonobject.get("validcredentials");
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
