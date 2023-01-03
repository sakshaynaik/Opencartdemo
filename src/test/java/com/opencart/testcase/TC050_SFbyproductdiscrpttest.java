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

public class TC050_SFbyproductdiscrpttest extends BaseClass {

	@Test(dataProvider = "existproduct")
	public void seachForNonExistingProduct(String invalidserch) {

		log.info("***** TC050_SFbyproductdiscrpttest Started *****");

		String[] data = invalidserch.split(",");

		Homepage hmpg = new Homepage(driver);
		Searchpage srchpg = hmpg.clickOnSearchButton();

		srchpg.enterSearchCriteriaField(data[1]);
		srchpg.clickPorductDescriptionCheckBox();
		srchpg.clickOnSearchButtonOfSearchCriteria();
		Assert.assertTrue(srchpg.isDispalyediMacFromSearchCriteria());
		log.info("After Searching Product By Description The Product Was Displayed: "
				+ srchpg.getiMacFromSearchCriteria());

		log.info("***** TC050_SFbyproductdiscrpttest Completed *****");

	}

	@DataProvider(name = "existproduct")
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
		JSONArray jsonarray = (JSONArray) jsonobject.get("descriptionsearch");
		Object[] arr = new Object[jsonarray.size()];

		for (int i = 0; i < jsonarray.size(); i++) {

			JSONObject data = (JSONObject) jsonarray.get(i);
			Object browser = data.get("Browser");
			Object prdname = data.get("Productdescription");

			arr[i] = browser + "," + prdname;

		}
		return arr;
	}
}
