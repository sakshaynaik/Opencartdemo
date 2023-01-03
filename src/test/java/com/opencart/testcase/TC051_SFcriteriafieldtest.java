package com.opencart.testcase;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Searchpage;

public class TC051_SFcriteriafieldtest extends BaseClass {

	@Test(dataProvider = "validserch")
	public void searchByCriteriaOfProduct(String fielddata) {

		log.info("***** TC051_SFcriteriafieldtest Started *****");

		String[] data = fielddata.split(",");

		Homepage hmpg = new Homepage(driver);
		Searchpage srchpg = hmpg.clickOnSearchButton();
		srchpg.enterSearchCriteriaField(data[1]);
		srchpg.selectSearchSubCategoryByIndex(Integer.parseInt(data[2]));
		srchpg.clickOnSearchButtonOfSearchCriteria();
		Assert.assertTrue(srchpg.isDispalyediMacFromSearchCriteria());
		log.info("iMac Pro Was Displayed On Search Page: " + srchpg.getiMacFromSearchCriteria());

		srchpg.selectSearchSubCategoryByIndex(Integer.parseInt(data[3]));
		srchpg.clickOnSearchButtonOfSearchCriteria();
		Assert.assertTrue(srchpg.isDispalyedSearchNoProductMsg());
		log.info("Search Warn Message Dispalyed On Search Page: " + srchpg.getSearchNoProductMsg());

		log.info("***** TC051_SFcriteriafieldtest Completed *****");

	}

	@DataProvider(name = "validserch")
	public Object[] dataSupplier() {

		JSONParser jsonparser = new JSONParser();
		Object object = null;

		try {
			String filepath = System.getProperty("user.dir") + "//jsonfiles//Search.json";
			FileReader reader = new FileReader(filepath);
			object = jsonparser.parse(reader);

		} catch (Exception e) {
			e.printStackTrace();
		}

		JSONObject jsonobject = ((JSONObject) object);
		JSONArray jsonarray = (JSONArray) jsonobject.get("searchbycategory");
		Object[] arr = new Object[jsonarray.size()];

		for (int i = 0; i < jsonarray.size(); i++) {

			JSONObject data = (JSONObject) jsonarray.get(i);
			Object browser = data.get("Browser");
			Object prdtnam = data.get("productname");
			Object corrtna = data.get("correctCategryName");
			Object worgnam = data.get("wrongCategryName");

			arr[i] = browser + "," + prdtnam + "," + corrtna + "," + worgnam;
		}
		return arr;

	}
}
