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

public class TC052_SFmaincategorysearchtest extends BaseClass {

	@Test(dataProvider = "validdata")
	public void searchByMainCatergory(HashMap<String, String> hMap) {

		log.info("***** TC052_SFmaincategorysearchtest Started *****");

		if (!ReadXlsxFile.isRunnable(xlsreader, "Search", "Testcases") || hMap.get("Runmode").equals("N")) {

			throw new SkipException("Test Method Skipped Due To Run Mode set To N");
		}

		Homepage hmpg = new Homepage(driver);
		Searchpage srchpg = hmpg.clickOnSearchButton();
		srchpg.enterSearchCriteriaField(hMap.get("Productname"));
		srchpg.selectSearchMainCategoryByText(hMap.get("ParentCategryName"));
		srchpg.clickOnSearchButtonOfSearchCriteria();
		Assert.assertTrue(srchpg.isDispalyedSearchNoProductMsg());
		log.info("Search Warn Message Dispalyed On Search Page: " + srchpg.getSearchNoProductMsg());

		srchpg.clickSearchSubcategoryCheckBox();
		srchpg.clickOnSearchButtonOfSearchCriteria();
		Assert.assertTrue(srchpg.isDispalyediMacFromSearchCriteria());
		log.info("iMac Pro Was Displayed On Search Page: " + srchpg.getiMacFromSearchCriteria());

		log.info("***** TC052_SFmaincategorysearchtest Completed *****");

	}

	@DataProvider(name = "validdata")
	public Object[][] dataSupplier() {

		Object[][] data = null;

		try {
			String filepath = System.getProperty("user.dir") + "//testdata//testdatafile.xlsx";
			xlsreader = new MyXlsReader(filepath);
			data = ReadXlsxFile.getTestData(xlsreader, "searchbymaincategory", "Data");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
}
