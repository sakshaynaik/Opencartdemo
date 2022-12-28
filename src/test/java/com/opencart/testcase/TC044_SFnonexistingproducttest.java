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

public class TC044_SFnonexistingproducttest extends BaseClass {

	@Test(dataProvider = "nonexistproduct")
	public void seachForNonExistingProduct(String invalidserch) {

		log.info("***** TC044_SFnonexistingproducttest Started *****");

		String[] data = invalidserch.split(",");

		Homepage hmpg = new Homepage(driver);
		hmpg.enterSearchTextField(data[1]);
		Searchpage srchpg = hmpg.clickOnSearchButton();
		Assert.assertTrue(srchpg.getSearchPageTitle().contains(config.getSearchPageTitle()));
		log.info("User Navigated To Search Page Title: " + srchpg.getSearchPageTitle());

		Assert.assertTrue(srchpg.isDispalyedSearchNoProductMsg());
		log.info("User Searched Product Was Not Displayed On SearchPage: " + srchpg.getSearchNoProductMsg());

		log.info("***** TC044_SFnonexistingproducttest Completed *****");

	}

	@DataProvider(name = "nonexistproduct")
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
		JSONArray jsonarray = (JSONArray) jsonobject.get("invalidsearch");
		Object[] arr = new Object[jsonarray.size()];

		for (int i = 0; i < jsonarray.size(); i++) {

			JSONObject data = (JSONObject) jsonarray.get(i);
			Object browser = data.get("Browser");
			Object prdname = data.get("productname");

			arr[i] = browser + "," + prdname;

		}
		return arr;
	}

}
