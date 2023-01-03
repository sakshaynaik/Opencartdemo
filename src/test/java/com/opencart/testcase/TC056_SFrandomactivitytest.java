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

public class TC056_SFrandomactivitytest extends BaseClass {

	@Test(dataProvider = "validserch")
	public void searchFeatureRandomActivity(String fielddata) {

		log.info("***** TC056_SFrandomactivitytest Started *****");

		String[] data = fielddata.split(",");

		Homepage hmpg = new Homepage(driver);
		Searchpage srchpg = hmpg.clickOnSearchButton();
		srchpg.enterSearchCriteriaField(data[1]);
		srchpg.clickOnSearchButtonOfSearchCriteria();
		Assert.assertTrue(srchpg.isDispalyedProductMacThumb());
		Assert.assertTrue(srchpg.isDispalyedProductMacProThumb());
		log.info("Search Page Displayed Multiple Products After Searching For Mac: " + srchpg.getProductMacThumb()
				+ "    " + srchpg.getProductMacProThumb());
		
		
		srchpg.selectSortByVisibleText(data[2]);
		srchpg.selectShowByVisibleText(Integer.parseInt(data[3]));
		int i= getRandomIntValue(srchpg.getSizeOfImg());
		Productpage prdtpg = srchpg.clickOnRandomImg(i);
		log.info("User Navigated To iMac Product Page: " + prdtpg.getProductPageTitle());
		
		log.info("***** TC056_SFrandomactivitytest Completed *****");

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
		JSONArray jsonarray = (JSONArray) jsonobject.get("randomactivty");
		Object[] arr = new Object[jsonarray.size()];

		for (int i = 0; i < jsonarray.size(); i++) {

			JSONObject data = (JSONObject) jsonarray.get(i);
			Object browser = data.get("Browser");
			Object prdtnam = data.get("productname");
			Object shortby = data.get("sortby");
			Object showby = data.get("showby");

			arr[i] = browser + "," + prdtnam + "," + shortby + "," + showby;
		}
		return arr;
	}
}
