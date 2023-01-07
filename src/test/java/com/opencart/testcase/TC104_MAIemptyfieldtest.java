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
import com.opencart.pageobject.Myaccountinfopage;

public class TC104_MAIemptyfieldtest extends BaseClass {

	@Test(dataProvider = "validcredentials")
	public void myAccountInfoEmptyFieldTest(String validdata) {

		log.info("***** TC104_MAIemptyfieldtest Started *****");

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

		Myaccountinfopage myacntinfopg = accntpg.clickOnEditYourInfoLink();
		Assert.assertEquals(myacntinfopg.getMyAccountInfoPageTitle(), config.getMyAccountInfoPageTitle());
		log.info("MyAccontInfo Page Title: " + myacntinfopg.getMyAccountInfoPageTitle());

		myacntinfopg.enterNewFirstName(data[3]);
		myacntinfopg.enterNewLastName(data[4]);
		myacntinfopg.enterNewEmail(data[5]);
		myacntinfopg.enterNewTelephoneNumber(data[6]);
		myacntinfopg.clickOnContinueButton();
		log.info("User Updated Empty Credentials In MyAccountInfo Page");

		Assert.assertEquals(myacntinfopg.getMyAccountInfoPageTitle(), config.getMyAccountInfoPageTitle());
		log.info("MyAccontInfo Page Title: " + myacntinfopg.getMyAccountInfoPageTitle());

		Assert.assertTrue(myacntinfopg.isDisplayedInvalidFirstNameMsg());
		Assert.assertTrue(myacntinfopg.isDisplayedInvalidLastNameMsg());
		Assert.assertTrue(myacntinfopg.isDisplayedInvalidEmailMsg());
		log.info("Invaild Message For Firstname, Lastname and For Email Was Displayed: "
				+ myacntinfopg.getTextInvalidEmailMsg() + " " + myacntinfopg.getTextInvalidLastNameMsg() + " "
				+ myacntinfopg.getTextInvalidFirstNameMsg());

		accntpg.clickLogoutOption();
		log.info("User Logged Out From The Site");

		hmpg.clickOnMyAccountDropMenu();
		hmpg.clickOnLoginLink();
		Assert.assertEquals(loginpg.getLoginPageTitle(), config.getLoginPageTitle());
		log.info("Navigated To Login Page: " + loginpg.getLoginPageTitle());

		loginpg.enterRegisteredEmail(data[5]);
		loginpg.enterRegisteredPassword(data[2]);
		loginpg.clickLoginButton();
		log.info("User Logged Into Accounts Page ");

		Assert.assertEquals(loginpg.getLoginPageTitle(), config.getLoginPageTitle());
		log.info("Navigated To Login Page: " + loginpg.getLoginPageTitle());

		loginpg.enterRegisteredEmail(data[1]);
		loginpg.enterRegisteredPassword(data[2]);
		loginpg.clickLoginButton();
		log.info("User Logged Into Accounts Page ");

		Assert.assertEquals(accntpg.getAccountPageTitle(), config.getAccountPageTitle());
		log.info("Acconts Page Title: " + accntpg.getAccountPageTitle());

		Assert.assertTrue(accntpg.isDisplayedEditInfoLink());
		log.info("Edit Info Link Displayed On Accounts Page");

		Assert.assertTrue(accntpg.isDisplayedAccountLinkOnBedcrum());
		log.info("Accont Link Displayed On BedCrum Of Accounts Page");

		log.info("***** TC104_MAIemptyfieldtest Started *****");

	}

	@DataProvider(name = "validcredentials")
	public Object[] dataSupplier() {

		JSONParser parser = new JSONParser();
		Object object = null;

		try {
			String filepath = System.getProperty("user.dir") + "//jsonfiles//myaccountinfo.json";
			FileReader reader = new FileReader(filepath);
			object = parser.parse(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject jsonobject = (JSONObject) object;
		JSONArray jsonarray = (JSONArray) jsonobject.get("emptydetails");
		Object[] arr = new Object[jsonarray.size()];

		for (int i = 0; i < jsonarray.size(); i++) {

			JSONObject data = (JSONObject) jsonarray.get(i);
			Object brows = data.get("Browser");
			Object email = data.get("email");
			Object passw = data.get("password");
			Object fnam = data.get("fname");
			Object lnam = data.get("lname");
			Object newem = data.get("newemail");
			Object newte = data.get("Telephone");

			arr[i] = brows + "," + email + "," + passw + "," + fnam + "," + lnam + "," + newem + "," + newte;
		}
		return arr;
	}
}
