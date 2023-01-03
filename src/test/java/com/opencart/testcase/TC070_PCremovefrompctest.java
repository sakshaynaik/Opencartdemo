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

public class TC070_PCremovefrompctest extends BaseClass {

	@Test(dataProvider = "existdata")
	public void productCompareRemovingFromComparePage(String fielddata) {

		log.info("***** TC070_PCremovefrompctest Started *****");

		String[] data = fielddata.split(",");

		Homepage hmpg = new Homepage(driver);
		hmpg.enterSearchTextField(data[1]);
		Searchpage srchpg = hmpg.clickOnSearchButton();
		Assert.assertTrue(srchpg.getSearchPageTitle().contains(config.getSearchPageTitle()));
		log.info("User Navigated To Search Page Title: " + srchpg.getSearchPageTitle());

		Assert.assertTrue(srchpg.isDispalyediMacFromSearchCriteria());
		log.info("iMac Pro Was Displayed On Search Page: " + srchpg.getiMacFromSearchCriteria());

		srchpg.hoverMouseOnCompareListButton();
		Assert.assertTrue(srchpg.getAttributeOfCompareListButton("data-original-title") != null);
		log.info("Tool Tip For The Compare Product Button: "
				+ srchpg.getAttributeOfCompareListButton("data-original-title"));

		srchpg.clickOnCompareListButton();
		Assert.assertTrue(srchpg.isDispalyedAddToCartMsg());
		log.info("Test Message For Compare Products Dispalyed: " + srchpg.getAddToCartMsg());

		Productcomparisionpage prdtcompare = srchpg.clickOnCompareProductLink_1();
		Assert.assertEquals(prdtcompare.getProductComparePageTitle(), config.getCompareProductPageTitle());
		log.info("User Navigated To Product Comparision Page: " + prdtcompare.getProductComparePageTitle());

		Assert.assertTrue(prdtcompare.isDisplayediMacLinkText());
		Assert.assertTrue(prdtcompare.isDisplayedAddToCartButton());
		Assert.assertTrue(prdtcompare.isDisplayedRemoveButton());
		log.info("All The Details Of Product Were Displayed On ProductCompare Page: "
				+ prdtcompare.getTextiMacLinkText());

		prdtcompare.clickOnRemoveButton();
		Assert.assertTrue(prdtcompare.isDisplyedMsgForProductCompareModified());
		log.info("Test Message For Compare Products Modified: " + prdtcompare.getMsgForProductCompareModified());

		Assert.assertTrue(prdtcompare.isDisplyedMsgProductNotChoosen());
		log.info("Test Message For Compare Products Modified: " + prdtcompare.getMsgProductNotChoosen());

		prdtcompare.clickOnContinueButton();
		Assert.assertEquals(hmpg.getHomePageTitle(), config.getHomePageTitle());
		log.info("User Navigated Back To Home Page: " + hmpg.getHomePageTitle());

		log.info("***** TC070_PCremovefrompctest Completed *****");
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
		JSONArray jsonarray = (JSONArray) jsonobject.get("twoproduct");
		Object[] arr = new Object[jsonarray.size()];
		for (int i = 0; i < jsonarray.size(); i++) {

			JSONObject data = (JSONObject) jsonarray.get(i);
			Object browser = data.get("browser");
			Object firprdt = data.get("firstproduct");
			Object secprdt = data.get("secondproduct");

			arr[i] = browser + "," + firprdt + "," + secprdt;
		}
		return arr;
	}
}
