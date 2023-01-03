package com.opencart.testcase;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Productpage;
import com.opencart.pageobject.Searchpage;
import com.opencart.utilities.MyXlsReader;
import com.opencart.utilities.ReadXlsxFile;

public class TC072_PDproductdetailstest extends BaseClass {

	@Test(dataProvider = "existdata")
	public void productDisplayThumnail(HashMap<String, String> hMap) {

		log.info("***** TC072_PDproductdetailstest Started *****");

		if (!ReadXlsxFile.isRunnable(xlsreader, "Productdisplay", "Testcases") || hMap.get("Runmode").equals("N")) {

			throw new SkipException("Test Method Skipped Due To Run Mode Set To N");
		}

		Homepage hmpg = new Homepage(driver);
		hmpg.enterSearchTextField(hMap.get("product"));
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
		
		prdtpg.enterNumberOfProductInQtyTextField(hMap.get("qty"));
		prdtpg.clickOnAddToCartButton();
		Assert.assertTrue(prdtpg.isDispalyedOfWhishlistMsg());
		log.info("Added To WhishList Message Was Displayed On Product Page: " + prdtpg.getTexOfWhishlistMsg());
		

		Assert.assertTrue(prdtpg.isDisplayedNavigatonBar());
		log.info("Navigation Bar Displayed On WebPage");

		log.info("***** TC072_PDproductdetailstest Completed *****");

	}

	@DataProvider(name = "existdata")
	public Object[][] dataSupplier() {

		Object[][] data = null;
		try {
			String file = System.getProperty("user.dir") + "//testdata//testdatafile.xlsx";
			xlsreader = new MyXlsReader(file);
			data = ReadXlsxFile.getTestData(xlsreader, "prdtdisplaybyqty", "Data");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;

	}

}
