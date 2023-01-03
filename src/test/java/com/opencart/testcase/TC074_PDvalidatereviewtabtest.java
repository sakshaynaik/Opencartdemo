package com.opencart.testcase;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Productpage;
import com.opencart.pageobject.Searchpage;

public class TC074_PDvalidatereviewtabtest extends BaseClass {

	@Test(dataProvider = "writingrevie")
	public void productDisplayWriteReview(String fielddata) {

		log.info("***** TC074_PDvalidatereviewtabtest Started *****");

		String[] data = fielddata.split(",");

		Homepage hmpg = new Homepage(driver);
		hmpg.enterSearchTextField(data[1]);
		Searchpage srchpg = hmpg.clickOnSearchButton();
		Assert.assertTrue(srchpg.getSearchPageTitle().contains(config.getSearchPageTitle()));
		log.info("User Navigated To Search Page Title: " + srchpg.getSearchPageTitle());

		Assert.assertTrue(srchpg.isDispalyediMacFromSearchCriteria());
		log.info("iMac Was Displayed On Search Page: " + srchpg.getiMacFromSearchCriteria());

		Productpage prdtpg = srchpg.clickOniMacImg();
		log.info("User Navigated To Product Page Title: " + prdtpg.getProductPageTitle());

		Assert.assertTrue(prdtpg.isDispalyedOfProductAvailabity());
		log.info("Availabity Of iMac Was Displayed On Product Page: " + prdtpg.getTexOfProductAvailabity());

		Assert.assertTrue(prdtpg.isDispalyedOfProductCode());
		log.info("Product Code Of iMac Was Displayed On Product Page: " + prdtpg.getTexOfProductCode());

		prdtpg.clickOnWriteReviewLinkTest();
		log.info("User Clicked On Write Review Link");

		String expectedres = data[2];
		boolean convertReslt = false;

		if (expectedres.equalsIgnoreCase("success")) {

			convertReslt = true;
		} else if (expectedres.equalsIgnoreCase("failure")) {

			convertReslt = false;
		}

		prdtpg.enterReviewNameField(data[3]);
		prdtpg.enterReviewBoxField(data[4]);
		prdtpg.clickOnRadioButton();
		prdtpg.clickOnReviewContinueButton();
		log.info("User Review Entered Into Review Text Box Field");

		boolean actualReslt;

		try {

			Assert.assertTrue(prdtpg.isDisplayedReviewMsg());
			log.info("Sucessfull Review Submitted Message Displayed On webpage " + prdtpg.getTextReviewMsg());
			actualReslt = prdtpg.isDisplayedReviewMsg();

		} catch (Throwable e) {

			actualReslt = false;
		}

		Assert.assertEquals(convertReslt, actualReslt);

		log.info("***** TC074_PDvalidatereviewtabtest Completed *****");
	}

	@DataProvider(name = "writingrevie")
	public Object[] dataSupplier() {

		JSONParser jsonparser = new JSONParser();
		Object object = null;

		try {
			String filepath = System.getProperty("user.dir") + "//jsonfiles//Productdisplay.json";
			FileReader reader = new FileReader(filepath);
			object = jsonparser.parse(reader);

		} catch (Exception e) {
			e.printStackTrace();
		}

		JSONObject jsonobject = ((JSONObject) object);
		JSONArray jsonarray = (JSONArray) jsonobject.get("reviewtest");
		Object[] arr = new Object[jsonarray.size()];
		for (int i = 0; i < jsonarray.size(); i++) {

			JSONObject data = (JSONObject) jsonarray.get(i);
			Object browser = data.get("browser");
			Object prdt = data.get("product");
			Object expres = data.get("expres");
			Object name = data.get("name");
			Object review = data.get("review");

			arr[i] = browser + "," + prdt + "," + expres + "," + name + "," + review;
		}
		return arr;
	}
}
