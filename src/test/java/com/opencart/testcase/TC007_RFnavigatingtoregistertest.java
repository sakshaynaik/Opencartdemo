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

public class TC007_RFnavigatingtoregistertest extends BaseClass {

	@Test(dataProvider = "Navigatetest")
	public void registeringByNaviagting(String fieldata) {

		log.info("***** TC007_RFnavigationtoregistertest Started *****");

		String[] data = fieldata.split(",");

		Homepage hmpg = new Homepage(driver);
		hmpg.clickOnMyAccountDropMenu();
		Assert.assertTrue(hmpg.isDisplayedRegisterOption());
		log.info("Register Option Displayed In MyAccount Drop Menu");

		Registerationpage respg = hmpg.clickOnRegisterLink();
		Assert.assertEquals(respg.getRegPageTitle(), config.getRegisterationPageTitle());
		log.info("User Logged Into Registration Page: " + respg.getRegPageTitle());

		hmpg.clickOnMyAccountDropMenu();
		Loginpage loginpg = hmpg.clickOnLoginLink();
		Assert.assertEquals(loginpg.getLoginPageTitle(), config.getLoginPageTitle());
		log.info("User Navigated To Login Page :" + loginpg.getLoginPageTitle());

		loginpg.clickOnNewCustomerContinueButton();
		log.info("User Navigated To Registration Page :" + respg.getRegPageTitle());

		respg.enterFirstNameTextField(data[1]);
		respg.enterLastNameTextField(data[2]);
		respg.enterEmialTextField(getRandomStringValue(5) + "@gmail.com");
		respg.enterTelephoneTextField(data[4]);
		respg.enterPasswordTextField(data[5]);
		respg.enterConfirmPasswordTextField(data[6]);
		respg.clickOnPriveryPolicyField();

		respg.clickOnRightColumnRegisterOption();
		Assert.assertEquals(respg.getRegPageTitle(), config.getRegisterationPageTitle());

		log.info("***** TC007_RFnavigationtoregistertest Completed *****");
	}

	@DataProvider(name = "Navigatetest")
	public Object[] datasuppiler() {

		JSONParser parser = new JSONParser();
		Object object = null;

		try {
			String filepath = System.getProperty("user.dir") + "//jsonfiles//RegistrationTest.json";
			FileReader file = new FileReader(filepath);
			object = parser.parse(file);

		} catch (Exception e) {
			e.printStackTrace();
		}

		JSONObject jsonobject = (JSONObject) object;
		JSONArray jsonarray = (JSONArray) jsonobject.get("MandatoryFieldTest");
		Object[] arr = new Object[jsonarray.size()];

		for (int i = 0; i < jsonarray.size(); i++) {

			JSONObject data = (JSONObject) jsonarray.get(i);

			Object browser = data.get("Browser");
			Object firtnme = data.get("FirstName");
			Object lstname = data.get("LastName");
			Object emaill = data.get("E-Mail");
			Object telepho = data.get("Telephone");
			Object pasword = data.get("Password");
			Object conpass = data.get("ConPasword");

			arr[i] = browser + "," + firtnme + "," + lstname + "," + emaill + "," + telepho + "," + pasword + ","
					+ conpass;

		}

		return arr;

	}

}
