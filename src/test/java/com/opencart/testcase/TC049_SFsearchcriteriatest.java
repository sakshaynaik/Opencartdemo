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

public class TC049_SFsearchcriteriatest extends BaseClass {

	@Test(dataProvider = "validserch")
	public void seachBySearchCriteria(HashMap<String, String> hMap) {

		log.info("***** TC043_SFexistingproducttest Started *****");

		if (!ReadXlsxFile.isRunnable(xlsreader, "Search", "Testcases") || hMap.get("Runmode").equals("N")) {

			throw new SkipException("Test Method Skipped Due To Run Mode Set To N");
		}

		Homepage hmpg = new Homepage(driver);
		Searchpage srchpg = hmpg.clickOnSearchButton();

		srchpg.enterSearchCriteriaField(hMap.get("Productname"));
		srchpg.clickOnSearchButtonOfSearchCriteria();
		Assert.assertTrue(srchpg.isDispalyediMacFromSearchCriteria());
		log.info("After Searching Product From Search Criteria The Product Was Displayed: "
				+ srchpg.getiMacFromSearchCriteria());

		log.info("***** TC043_SFexistingproducttest Completed *****");

	}

	@DataProvider(name = "validserch")
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
