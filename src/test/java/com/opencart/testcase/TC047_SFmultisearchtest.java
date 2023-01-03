package com.opencart.testcase;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Searchpage;
import com.opencart.utilities.MyXlsReader;
import com.opencart.utilities.ReadXlsxFile;

public class TC047_SFmultisearchtest extends BaseClass {

	@Test(dataProvider = "validserch")
	public void SearchMultipleProducts(HashMap<String, String> hMap) {

		log.info("***** TC047_SFmultisearchtest Started *****");

		if (!ReadXlsxFile.isRunnable(xlsreader, "Search", "Testcases") || hMap.get("Runmode").equals("N")) {

			throw new SkipException("Test Method Skipped Due To Run Mode Set To N");
		}

		Homepage hmpg = new Homepage(driver);
		hmpg.enterSearchTextField(hMap.get("Productname"));
		Searchpage srchpg = hmpg.clickOnSearchButton();
		Assert.assertTrue(srchpg.getSearchPageTitle().contains(config.getSearchPageTitle()));
		log.info("User Navigated To Search Page Title: " + srchpg.getSearchPageTitle());

		Assert.assertTrue(srchpg.isDispalyedProductMacThumb());
		Assert.assertTrue(srchpg.isDispalyedProductMacProThumb());
		log.info("Search Page Displayed Multiple Products After Searching For Mac: " + srchpg.getProductMacThumb()
				+ "    " + srchpg.getProductMacProThumb());

		log.info("***** TC047_SFmultisearchtest Completed *****");

	}

	@DataProvider(name = "validserch")
	public Object[][] dataSupplier() {

		Object[][] data = null;

		try {
			String filepath = System.getProperty("user.dir") + "//testdata//testdatafile.xlsx";
			xlsreader = new MyXlsReader(filepath);
			data = ReadXlsxFile.getTestData(xlsreader, "multisearch", "Data");

		} catch (Exception e) {

			e.printStackTrace();
		}

		return data;

	}

}
