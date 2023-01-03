package com.opencart.testcase;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Productcomparisionpage;
import com.opencart.pageobject.Searchpage;
import com.opencart.utilities.MyXlsReader;
import com.opencart.utilities.ReadXlsxFile;

public class TC055_SFproductcomparetest extends BaseClass {

	@Test(dataProvider = "validdata")
	public void SearchWithNavigatingToProductCompare(HashMap<String, String> hMap) {

		log.info("***** TC055_SFproductcomparetest Started *****");

		if (!ReadXlsxFile.isRunnable(xlsreader, "Search", "Testcases") || hMap.get("Runmode").equals("N")) {

			throw new SkipException("Test Method Skipped Due To Run Mode set To N");
		}

		Homepage hmpg = new Homepage(driver);
		hmpg.enterSearchTextField(hMap.get("Productname"));
		Searchpage srchpg = hmpg.clickOnSearchButton();
		Assert.assertTrue(srchpg.getSearchPageTitle().contains(config.getSearchPageTitle()));
		log.info("User Navigated To Search Page Title: " + srchpg.getSearchPageTitle());

		Assert.assertTrue(srchpg.isDispalyedIMacProductThumb());
		log.info("User Searched Product Was Displayed On Search Page: " + srchpg.getIMacProductThumb());

		Productcomparisionpage prdcompg = srchpg.clickOnCompareProductLink();
		Assert.assertEquals(prdcompg.getProductComparePageTitle(), config.getCompareProductPageTitle());
		log.info("User Navigated To Productcompare Page: " + prdcompg.getProductComparePageTitle());

		log.info("***** TC055_SFproductcomparetest Completed *****");

	}

	@DataProvider(name = "validdata")
	public Object[][] dataSupplier() {

		Object[][] data = null;

		try {
			String filepath = System.getProperty("user.dir") + "//testdata//testdatafile.xlsx";
			xlsreader = new MyXlsReader(filepath);
			data = ReadXlsxFile.getTestData(xlsreader, "validsearch", "Data");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

}
