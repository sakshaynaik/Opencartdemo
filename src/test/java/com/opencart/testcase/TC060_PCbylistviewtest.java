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

public class TC060_PCbylistviewtest extends BaseClass {

	@Test(dataProvider = "existdata")
	public void productCompareByListView(HashMap<String, String> hMap) {

		log.info("***** TC060_PCbylistviewtest Started *****");

		if (!ReadXlsxFile.isRunnable(xlsreader, "Productcompare", "Testcases") || hMap.get("Runmode").equals("N")) {

			throw new SkipException("Test Method Skipped Due To Run Mode Set To N");
		}

		Homepage hmpg = new Homepage(driver);
		hmpg.enterSearchTextField(hMap.get("Product"));
		Searchpage srchpg = hmpg.clickOnSearchButton();
		Assert.assertTrue(srchpg.getSearchPageTitle().contains(config.getSearchPageTitle()));
		log.info("User Navigated To Search Page Title: " + srchpg.getSearchPageTitle());

		Assert.assertTrue(srchpg.isDispalyediMacFromSearchCriteria());
		log.info("iMac Pro Was Displayed On Search Page: " + srchpg.getiMacFromSearchCriteria());

		srchpg.clickOnListView();
		log.info("User Clicked List View For Viewing The Product In List View Formatt");

		srchpg.hoverMouseOnCompareListButton();
		Assert.assertTrue(srchpg.getAttributeOfCompareListButton("data-original-title") != null);
		log.info("Tool Tip For The Compare Product Button: "
				+ srchpg.getAttributeOfCompareListButton("data-original-title"));

		srchpg.clickOnCompareListButton();
		Assert.assertTrue(srchpg.isDispalyedAddToCartMsg());
		log.info("Test Message For Compare Products Dispalyed: " + srchpg.getAddToCartMsg());
		
		Productcomparisionpage prdtcompare = srchpg.clickOnCompareProductLink();
		Assert.assertEquals(prdtcompare.getProductComparePageTitle(), config.getCompareProductPageTitle());
		log.info("User Navigated To Product Comparision Page: " + prdtcompare.getProductComparePageTitle());

		Assert.assertTrue(prdtcompare.isDisplayediMacLinkText());
		Assert.assertTrue(prdtcompare.isDisplayedAddToCartButton());
		Assert.assertTrue(prdtcompare.isDisplayedRemoveButton());
		log.info(
				"All The Details Of Product Were Displayed On ProductCompare Page: " + prdtcompare.getTextiMacLinkText()
						+ "  " + prdtcompare.getTextAddToCartButton() + "  " + prdtcompare.getTextRemoveButton());

		log.info("***** TC060_PCbylistviewtest Completed *****");
	}

	@DataProvider(name = "existdata")
	public Object[][] dataSupplier() {

		Object[][] data = null;
		try {
			String file = System.getProperty("user.dir") + "//testdata//testdatafile.xlsx";
			xlsreader = new MyXlsReader(file);
			data = ReadXlsxFile.getTestData(xlsreader, "existingproduct", "Data");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;

	}
}
