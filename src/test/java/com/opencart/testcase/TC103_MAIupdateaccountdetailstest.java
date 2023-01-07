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

public class TC103_MAIupdateaccountdetailstest extends BaseClass {

	@Test(dataProvider = "validcredentials")
	public void myAccountInfoEditAccountInfo(String validdata) {

		log.info("***** TC103_MAIupdateaccountdetailstest Started *****");

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
		log.info("User Updated His New Account Credentials In MyAccountInfo Page");

		accntpg.clickLogoutOption();
		log.info("User Logged Out From The Site");

		hmpg.clickOnMyAccountDropMenu();
		hmpg.clickOnLoginLink();
		Assert.assertEquals(loginpg.getLoginPageTitle(), config.getLoginPageTitle());
		log.info("Navigated To Login Page: " + loginpg.getLoginPageTitle());
		
		loginpg.enterRegisteredEmail(data[1]);
		loginpg.enterRegisteredPassword(data[2]);
		loginpg.clickLoginButton();
		log.info("User Logged Into Accounts Page ");

		Assert.assertEquals(loginpg.getLoginPageTitle(), config.getLoginPageTitle());
		log.info("Navigated To Login Page: " + loginpg.getLoginPageTitle());
		
		loginpg.enterRegisteredEmail(data[5]);
		loginpg.enterRegisteredPassword(data[2]);
		loginpg.clickLoginButton();
		log.info("User Logged Into Accounts Page ");
		
		accntpg.clickOnEditYourInfoLink();
		Assert.assertEquals(myacntinfopg.getMyAccountInfoPageTitle(), config.getMyAccountInfoPageTitle());
		log.info("MyAccontInfo Page Title: " + myacntinfopg.getMyAccountInfoPageTitle());

		myacntinfopg.enterNewFirstName(data[3]);
		myacntinfopg.enterNewLastName(data[4]);
		myacntinfopg.enterNewEmail(data[1]);
		myacntinfopg.enterNewTelephoneNumber(data[6]);
		myacntinfopg.clickOnContinueButton();
		log.info("User Updated His New Account Credentials In MyAccountInfo Page");

		Assert.assertEquals(accntpg.getAccountPageTitle(), config.getAccountPageTitle());
		log.info("Acconts Page Title: " + accntpg.getAccountPageTitle());

		Assert.assertTrue(accntpg.isDisplayedUpdatedSuccessMsg());
		log.info("Account Updated Success Message: " + accntpg.getUpdatedSuccessMsg());

		log.info("***** TC103_MAIupdateaccountdetailstest Completed *****");

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
		JSONArray jsonarray = (JSONArray) jsonobject.get("updtedetails");
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
