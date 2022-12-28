package com.opencart.testcase;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Registerationpage;

public class TC009_RFexistingemailtest extends BaseClass {

	@Test(dataProvider = "DiffEmail", groups = "Smoke")
	public void registeringWithDifferentPassword(String fieldata) {

		log.info("***** TC009_RFexistingemailtest Started *****");

		String[] data = fieldata.split(",");

		Homepage hmpg = new Homepage(driver);
		hmpg.clickOnMyAccountDropMenu();
		Assert.assertTrue(hmpg.isDisplayedRegisterOption());
		log.info("Register Option Displayed In MyAccount Drop Menu");

		Registerationpage respg = hmpg.clickOnRegisterLink();
		Assert.assertEquals(respg.getRegPageTitle(), config.getRegisterationPageTitle());
		log.info("User Logged Into Registration Page :" + respg.getRegPageTitle());

		respg.enterFirstNameTextField(data[1]);
		respg.enterLastNameTextField(data[2]);
		respg.enterEmialTextField(data[3]);
		respg.enterTelephoneTextField(data[4]);
		respg.enterPasswordTextField(data[5]);
		respg.enterConfirmPasswordTextField(data[6]);
		respg.clickOnNewsLetterRadioButton();
		respg.clickOnPriveryPolicyField();
		respg.clickOnContinueButton();

		Assert.assertTrue(respg.isDisplayedWarnForAlredyRegisteredEmail());
		log.info("Warning Message Displayed For Email Already Registered: " + respg.getWarnForAlredyRegisteredEmail());

		Assert.assertEquals(respg.getRegPageTitle(), config.getRegisterationPageTitle());
		log.info("User Still In Registration Page Due To Email Already Registered: " + respg.getRegPageTitle());

		log.info("***** TC009_RFexistingemailtest Completed *****");
	}

	@DataProvider(name = "DiffEmail")
	public Object[] dataSupplier() {

		JSONParser parser = new JSONParser();
		Object object = null;

		try {
			String filepath = System.getProperty("user.dir") + "//jsonfiles//RegistrationTest.json";
			FileReader fileread = new FileReader(filepath);
			object = parser.parse(fileread);

		} catch (Exception e) {
			e.printStackTrace();
		}

		JSONObject jsonobject = (JSONObject) object;
		JSONArray jsonarray = (JSONArray) jsonobject.get("RegisteredEmail");
		Object[] arr = new Object[jsonarray.size()];

		for (int i = 0; i < jsonarray.size(); i++) {

			JSONObject data = (JSONObject) jsonarray.get(i);
			Object browser = data.get("Browser");
			Object firstname = data.get("FirstName");
			Object lastname = data.get("LastName");
			Object email = data.get("E-Mail");
			Object telephon = data.get("Telephone");
			Object password = data.get("Password");
			Object conpassw = data.get("ConPasword");

			arr[i] = browser + "," + firstname + "," + lastname + "," + email + "," + telephon + "," + password + ","
					+ conpassw;
		}
		return arr;
	}
}
