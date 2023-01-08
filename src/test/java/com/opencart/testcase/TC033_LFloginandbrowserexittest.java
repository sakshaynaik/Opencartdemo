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

public class TC033_LFloginandbrowserexittest extends BaseClass {

	@Test(dataProvider = "validcredentials", groups = "Smoke")
	public void loginAndExitBrowser(String validdata) {

		log.info("***** TC033_LFloginandbrowserexittest Started *****");

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

		accntpg.closeBrowser();
		log.info("Account Success Page Window Closed");

		setBrowser(data[0]);
		log.info("Reopened The Browser For Validating The Login Of User");

		Homepage hmpg2 = new Homepage(driver);
		hmpg2.clickOnMyAccountDropMenu();
		log.info("Clicked On MyAccount Drop Menu");

		try {
			Assert.assertTrue(hmpg2.isDisplayedLogoutOption());
			log.info("Logout Option Displayed On MyAccount Drop Menu");

		} catch (Throwable e) {

			hmpg2.highletLoginOptionDefect();
			Assert.fail("User Logged-Into Application And Closed Browser Without "
					+ "Logging-Out But User Was Logged-Out Of Application Once The User Re-Opened The Browser");
		}

		log.info("***** TC033_LFloginandbrowserexittest Completed *****");

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
