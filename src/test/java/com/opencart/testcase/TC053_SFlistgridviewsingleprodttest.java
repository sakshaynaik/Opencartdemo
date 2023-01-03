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

public class TC053_SFlistgridviewsingleprodttest extends BaseClass {

	@Test(dataProvider = "validserch")
	public void searchSingleProductByListAndGridView(String fielddata) {

		log.info("***** TC053_listgridviewsingleprodttest Started *****");

		String[] data = fielddata.split(",");

		Homepage hmpg = new Homepage(driver);
		hmpg.enterSearchTextField(data[1]);
		Searchpage srchpg = hmpg.clickOnSearchButton();

		Assert.assertTrue(srchpg.isDispalyediMacFromSearchCriteria());
		log.info("iMac Pro Was Displayed On Search Page: " + srchpg.getiMacFromSearchCriteria());

		srchpg.clickOnListView();
		Productpage prdtpg = srchpg.clickOniMacImg();
		log.info("User Navigated To iMac Product Page: " + prdtpg.getProductPageTitle());
		
		prdtpg.navigateToBackPage();
		Assert.assertTrue(srchpg.getSearchPageTitle().contains(config.getSearchPageTitle()));
		log.info("User Navigated To Search Page Title: " + srchpg.getSearchPageTitle());
		
		srchpg.clickOniMacProLink();
		log.info("User Navigated To iMac Product Page: " + prdtpg.getProductPageTitle());
		
		prdtpg.navigateToBackPage();
		Assert.assertTrue(srchpg.getSearchPageTitle().contains(config.getSearchPageTitle()));
		log.info("User Navigated To Search Page Title: " + srchpg.getSearchPageTitle());
		
		srchpg.clickOnAddToCartButton();
		Assert.assertTrue(srchpg.isDispalyedAddToCartMsg());
		log.info("Add To Cart Message Was Displayed On Search Page: " + srchpg.getAddToCartMsg());
		
		srchpg.clickOnAddToWhishlistButton();
		Assert.assertTrue(srchpg.isDispalyedAddToWhishlistWarnLoginMsg());
		log.info("Add To Whishlist Warn Login Message Was Displayed On Search Page: " + srchpg.getAddToWhishlistWarnLoginMsg());
		
		srchpg.clickOnCompareListButton();
		Assert.assertTrue(srchpg.isDispalyedAddToCartMsg());
		log.info("Add To Cart Message Was Displayed On Search Page: " + srchpg.getAddToCartMsg());
		
		srchpg.navigateBackPage();
		Assert.assertEquals(hmpg.getHomePageTitle(), config.getHomePageTitle());
		log.info("User Navigated Back To Homepage: " + hmpg.getHomePageTitle());
			
	    hmpg.clearSearchTextField();
	    hmpg.enterSearchTextField(data[1]);
	    srchpg = hmpg.clickOnSearchButton();
		Assert.assertTrue(srchpg.isDispalyediMacFromSearchCriteria());
		log.info("iMac Pro Was Displayed On Search Page: " + srchpg.getiMacFromSearchCriteria());

		srchpg.clickOnGridView();
	    prdtpg = srchpg.clickOniMacImg();
		log.info("User Navigated To iMac Product Page: " + prdtpg.getProductPageTitle());
		
		prdtpg.navigateToBackPage();
		Assert.assertTrue(srchpg.getSearchPageTitle().contains(config.getSearchPageTitle()));
		log.info("User Navigated To Search Page Title: " + srchpg.getSearchPageTitle());
		
		srchpg.clickOniMacProLink();
		log.info("User Navigated To iMac Product Page: " + prdtpg.getProductPageTitle());
		
		prdtpg.navigateToBackPage();
		Assert.assertTrue(srchpg.getSearchPageTitle().contains(config.getSearchPageTitle()));
		log.info("User Navigated To Search Page Title: " + srchpg.getSearchPageTitle());
		
		srchpg.clickOnAddToCartButton();
		Assert.assertTrue(srchpg.isDispalyedAddToCartMsg());
		log.info("Add To Cart Message Was Displayed On Search Page: " + srchpg.getAddToCartMsg());
		
		srchpg.clickOnAddToWhishlistButton();
		Assert.assertTrue(srchpg.isDispalyedAddToWhishlistWarnLoginMsg());
		log.info("Add To Whishlist Warn Login Message Was Displayed On Search Page: " + srchpg.getAddToWhishlistWarnLoginMsg());
		
		srchpg.clickOnCompareListButton();
		Assert.assertTrue(srchpg.isDispalyedAddToCartMsg());
		log.info("Add To Cart Message Was Displayed On Search Page: " + srchpg.getAddToCartMsg());
		
		log.info("***** TC053_listgridviewsingleprodttest Completed *****");

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
		JSONArray jsonarray = (JSONArray) jsonobject.get("validsearch");
		Object[] arr = new Object[jsonarray.size()];

		for (int i = 0; i < jsonarray.size(); i++) {

			JSONObject data = (JSONObject) jsonarray.get(i);
			Object browser = data.get("Browser");
			Object prdtnam = data.get("productname");

			arr[i] = browser + "," + prdtnam;
		}
		return arr;

	}
}
