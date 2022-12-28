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

public class TC015_RFemptyspacejsontest extends BaseClass {

	@Test(dataProvider = "emptybyjson", groups = "Smoke")
	public void registartionWithEmptySpaceByJSON(String spacedata) {

		log.info("***** TC015_RFemptyspacejsontest Started *****");

		String[] data = spacedata.split(",");

		Homepage hmpg = new Homepage(driver);
		hmpg.clickOnMyAccountDropMenu();
		Assert.assertTrue(hmpg.isDisplayedRegisterOption());
		log.info("Register Option Displayed In MyAccount Drop Menu");

		Registerationpage respg = hmpg.clickOnRegisterLink();
		Assert.assertEquals(respg.getRegPageTitle(), config.getRegisterationPageTitle());
		log.info("User Logged Into Registration Page: " + respg.getRegPageTitle());

		respg.enterFirstNameTextField(data[1]);
		respg.enterLastNameTextField(data[2]);
		respg.enterEmialTextField(data[3]);
		respg.enterTelephoneTextField(data[4]);
		respg.enterPasswordTextField(data[5]);
		respg.enterConfirmPasswordTextField(data[6]);
		respg.clickOnNewsLetterRadioButton();
		respg.clickOnPriveryPolicyField();
		respg.clickOnContinueButton();

		Assert.assertEquals(respg.getRegPageTitle(), config.getRegisterationPageTitle());
		log.info("User Still In Registration Page Due To Empty Text Fields :" + respg.getRegPageTitle());

		Assert.assertTrue(respg.isDisplayedWarnFirstNameMsg());
		log.info("First Name Warning Message Displayed: " + respg.getWarnFirstNameMsg());

		Assert.assertTrue(respg.isDisplayedWarnLastNameMsg());
		log.info("Last Name Warning Message Displayed: " + respg.getWarnLastNameMsg());

		Assert.assertTrue(respg.isDisplayedWarnEmailMsg());
		log.info("Email Warning Message Displayed: " + respg.getWarnEmailMsg());
		
        respg.highletTelephonTextField();
		Assert.assertTrue(respg.isDisplayedWarnTelephonemsg());
		log.info("Telephone Warning Message Displayed: " + respg.getWarnTelephonemsg());

		Assert.assertTrue(respg.isDisplayedWarnPasswordMsg());
		log.info("Password Warning Message Displayed: " + respg.getWarnPasswordMsg());

		log.info("***** TC015_RFemptyspacejsontest Completed *****");

	}

	@DataProvider(name = "emptybyjson")
	public Object[] dataSupplier() {

		JSONParser parser = new JSONParser();
		Object object = null;

		try {
			String filepath = System.getProperty("user.dir") + "//jsonfiles//RegistrationTest.json";
			FileReader reader = new FileReader(filepath);
			object = parser.parse(reader);

		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject jsonobject = (JSONObject) object;
		JSONArray jsonarray = (JSONArray) jsonobject.get("Emptyspace");
		Object[] arr = new Object[jsonarray.size()];

		for (int i = 0; i < jsonarray.size(); i++) {

			JSONObject data = (JSONObject) jsonarray.get(i);
			Object brows = data.get("Browser");
			Object fname = data.get("FirstName");
			Object lname = data.get("LastName");
			Object email = data.get("E-Mail");
			Object telep = data.get("Telephone");
			Object passw = data.get("Password");
			Object conpas = data.get("ConPasword");

			arr[i] = brows + "," + fname + "," + lname + "," + email + "," + telep + "," + passw + "," + conpas;
		}
		return arr;

	}
}
