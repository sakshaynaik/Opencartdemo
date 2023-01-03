package com.opencart.testcase;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Productcomparisionpage;
import com.opencart.pageobject.Productpage;
import com.opencart.pageobject.Searchpage;

public class TC059_PCfromdisplaypagetest extends BaseClass {

	@Test(dataProvider = "existdata")
	public void productCompareInDisplayPage(String fielddata) {

		log.info("***** TC059_PCfromdisplaypagetest Started *****");

		String[] data = fielddata.split(",");

		Homepage hmpg = new Homepage(driver);
		hmpg.enterSearchTextField(data[1]);
		Searchpage srchpg = hmpg.clickOnSearchButton();
		Assert.assertTrue(srchpg.getSearchPageTitle().contains(config.getSearchPageTitle()));
		log.info("User Navigated To Search Page Title: " + srchpg.getSearchPageTitle());

		Assert.assertTrue(srchpg.isDispalyediMacFromSearchCriteria());
		log.info("iMac Pro Was Displayed On Search Page: " + srchpg.getiMacFromSearchCriteria());

		Productpage prdtpg = srchpg.clickOniMacImg();
		log.info("User Navigated To iMac Product Page: " + prdtpg.getProductPageTitle());

		Assert.assertTrue(prdtpg.getAttributeCompareProductButton("data-original-title") != null);
		log.info("Tool Tip For The Compare Product Button: "
				+ prdtpg.getAttributeCompareProductButton("data-original-title"));

		prdtpg.clickOnCompareProductButton();
		Assert.assertTrue(prdtpg.isDisplayedComapreProductSuccessMessage());
		log.info("Test Message For Compare Products Dispalyed: " + prdtpg.getComapreProductSuccessMessage());
		
		Productcomparisionpage prdtcompare = prdtpg.clickOnProductComparsionLink();
		Assert.assertEquals(prdtcompare.getProductComparePageTitle(), config.getCompareProductPageTitle());
		log.info("User Navigated To Product Comparision Page: " + prdtcompare.getProductComparePageTitle());
		
		Assert.assertTrue(prdtcompare.isDisplayediMacLinkText());
		Assert.assertTrue(prdtcompare.isDisplayedAddToCartButton());
		Assert.assertTrue(prdtcompare.isDisplayedRemoveButton());
		log.info(
				"All The Details Of Product Were Displayed On ProductCompare Page: " + prdtcompare.getTextiMacLinkText()
						+ "  " + prdtcompare.getTextAddToCartButton() + "  " + prdtcompare.getTextRemoveButton());
		

		log.info("***** TC059_PCfromdisplaypagetest Completed *****");
	}

	@DataProvider(name = "existdata")
	public Object[] dataSupplier() {

		JSONParser jsonparser = new JSONParser();
		Object object = null;

		try {
			String filepath = System.getProperty("user.dir") + "//jsonfiles//productcompare.json";
			FileReader reader = new FileReader(filepath);
			object = jsonparser.parse(reader);

		} catch (Exception e) {
			e.printStackTrace();
		}

		JSONObject jsonobject = ((JSONObject) object);
		JSONArray jsonarray = (JSONArray) jsonobject.get("existingproduct");
		Object[] arr = new Object[jsonarray.size()];
		for (int i = 0; i < jsonarray.size(); i++) {

			JSONObject data = (JSONObject) jsonarray.get(i);
			Object browser = data.get("browser");
			Object product = data.get("product");

			arr[i] = browser + "," + product;
		}
		return arr;
	}
}
