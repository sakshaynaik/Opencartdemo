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
import com.opencart.pageobject.Searchpage;

public class TC066_PCproductcomparetest extends BaseClass {

	@Test(dataProvider = "existdata")
	public void productCompareWithCampareLink(String fielddata) {
		
		log.info("***** TC066_PCproductcomparetest Started *****");

		String[] data = fielddata.split(",");

		Homepage hmpg = new Homepage(driver);
		hmpg.enterSearchTextField(data[1]);
		Searchpage srchpg = hmpg.clickOnSearchButton();
		Assert.assertTrue(srchpg.getSearchPageTitle().contains(config.getSearchPageTitle()));
		log.info("User Navigated To Search Page Title: " + srchpg.getSearchPageTitle());

		Assert.assertTrue(srchpg.isDispalyediMacFromSearchCriteria());
		log.info("iMac Pro Was Displayed On Search Page: " + srchpg.getiMacFromSearchCriteria());
		
		Productcomparisionpage prdtcompage = srchpg.clickOnProductCompareLink_0();
		Assert.assertEquals(prdtcompage.getProductComparePageTitle(), config.getCompareProductPageTitle());
		log.info("User Navigated To Product Compare Page: " + prdtcompage.getProductComparePageTitle());
		
		log.info("***** TC066_PCproductcomparetest Completed *****");

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
