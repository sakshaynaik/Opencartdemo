package com.opencart.testcase;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.pageobject.Contactuspage;
import com.opencart.pageobject.Homepage;

public class TC143_CUmandtryfieldtest extends BaseClass {

	@Test(dataProvider = "validcredentials")
	public void contactUsMandatoryFieldTest(String validdata) {

		log.info("***** TC143_CUmandtryfieldtest Started *****");

		String[] data = validdata.split(",");

		Homepage hmpg = new Homepage(driver);
		Contactuspage contactpg = hmpg.clickOnTelephoneOption();
		Assert.assertEquals(contactpg.getContactUsPageTitle(), config.getContactUsPageTitle());
		log.info("Contact Us Page Title: " + contactpg.getContactUsPageTitle());

		Assert.assertTrue(contactpg.isDisplayedContactUsPanelBody());
		log.info("Content Present In ContactUs Pannel Body: " + contactpg.getContactUsPanelBody());

		contactpg.enterYourNameTextField(data[1]);
		contactpg.enterEmailAddressTextField(data[2]);
		contactpg.enterEnquiryTextField(data[3]);
		contactpg.clickOnSubmittButton();

		Assert.fail("Blank 'Contact Us' Page  Displayed On Submitting Form In 'Contact Us' Page");

		log.info("***** TC143_CUmandtryfieldtest Completed *****");

	}

	@DataProvider(name = "validcredentials")
	public Object[] dataSupplier() {

		JSONParser parser = new JSONParser();
		Object object = null;

		try {
			String filepath = System.getProperty("user.dir") + "//jsonfiles//contactus.json";
			FileReader reader = new FileReader(filepath);
			object = parser.parse(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject jsonobject = (JSONObject) object;
		JSONArray jsonarray = (JSONArray) jsonobject.get("enquirycredentials");
		Object[] arr = new Object[jsonarray.size()];

		for (int i = 0; i < jsonarray.size(); i++) {

			JSONObject data = (JSONObject) jsonarray.get(i);
			Object brows = data.get("Browser");
			Object nme = data.get("name");
			Object emil = data.get("email");
			Object enquiry = data.get("Enquiry");
			Object prdna = data.get("productname");

			arr[i] = brows + "," + nme + "," + emil + "," + enquiry + "," + prdna;
		}
		return arr;

	}
}
