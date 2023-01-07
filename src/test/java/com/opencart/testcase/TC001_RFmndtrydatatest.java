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
import com.opencart.pageobject.Registerationpage;
import com.opencart.pageobject.Successpage;

public class TC001_RFmndtrydatatest extends BaseClass {

	@Test(dataProvider = "mandatoryfielddata", groups = "Smoke")
	public void registeringWithMandatoryField(String textfielddata) {

		log.info("***** TC001_RFmndtrydatatest Started *****");

		String[] data = textfielddata.split(",");

		Homepage hmpg = new Homepage(driver);
		hmpg.clickOnMyAccountDropMenu();
		Assert.assertTrue(hmpg.isDisplayedRegisterOption());
		log.info("Register Option Displayed In MyAccount Drop Menu");

		Registerationpage respg = hmpg.clickOnRegisterLink();
		Assert.assertEquals(respg.getRegPageTitle(), config.getRegisterationPageTitle());
		log.info("User Logged Into Registration Page: " + respg.getRegPageTitle());

		respg.enterFirstNameTextField(data[1]);
		respg.enterLastNameTextField(data[2]);
		respg.enterEmialTextField(getRandomStringValue(5) + "@gmail.com");
		respg.enterTelephoneTextField(data[4]);
		respg.enterPasswordTextField(data[5]);
		respg.enterConfirmPasswordTextField(data[6]);
		respg.clickOnPriveryPolicyField();
		Successpage sucespg = respg.clickOnContinueButton();
		Assert.assertEquals(sucespg.getSuccessPageTitle(), config.getSuccessPageTitle());
		log.info("User Logged Into AccountSuccess Page: " + sucespg.getSuccessPageTitle());

		hmpg.clickOnMyAccountDropMenu();
		Assert.assertTrue(sucespg.isDisplayedLogoutOption());
		log.info("Logout Option Displayed On MyAccount Drop Menu");

		Assert.assertTrue(sucespg.isDisplayedSuccessOnBedcrum());
		log.info("Success Link Displayed On Bedcrum");

		Assert.assertTrue(sucespg.isDisplayedSubAccountSuccessMsg());
		log.info("Account Success Message Displayed: " + sucespg.getSubAccountSuccessMsg());

		Accountpage accpg = sucespg.clickOnContinueButton();
		Assert.assertTrue(accpg.isDisplayedEditInfoLink());
		log.info("Edit your account information Link Displayed On WebPage");

		Assert.assertEquals(accpg.getAccountPageTitle(), config.getAccountPageTitle());
		log.info("User Logged Into Account Page: " + accpg.getAccountPageTitle());

		Assert.assertTrue(accpg.isDisplayedAccountLinkOnBedcrum());
		log.info("Account Link Displayed On Bedcrum");

		log.info("***** TC001_RFmndtrydatatest Completed *****");

	}

	@DataProvider(name = "mandatoryfielddata")
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
		JSONArray jsonarray = (JSONArray) jsonobject.get("MandatoryFieldTest");
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
