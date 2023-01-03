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

public class TC071_PDimagethumnailtest extends BaseClass {

	@Test(dataProvider = "existdata")
	public void productDisplayThumnail(HashMap<String, String> hMap) {

		log.info("***** TC071_PDthumnailtest Started *****");

		if (!ReadXlsxFile.isRunnable(xlsreader, "Productcompare", "Testcases") || hMap.get("Runmode").equals("N")) {

			throw new SkipException("Test Method Skipped Due To Run Mode Set To N");
		}

		Homepage hmpg = new Homepage(driver);
		hmpg.enterSearchTextField(hMap.get("Product"));
		Searchpage srchpg = hmpg.clickOnSearchButton();
		Assert.assertTrue(srchpg.getSearchPageTitle().contains(config.getSearchPageTitle()));
		log.info("User Navigated To Search Page Title: " + srchpg.getSearchPageTitle());

		Assert.assertTrue(srchpg.isDispalyediMacFromSearchCriteria());
		log.info("iMac Was Displayed On Search Page: " + srchpg.getiMacFromSearchCriteria());

		Productpage prdtpg = srchpg.clickOniMacImg();
		log.info("User Navigated To Product Page Title: " + prdtpg.getProductPageTitle());

		prdtpg.clickOniMacImg();
		prdtpg.clickOnRightArrowKey();
		prdtpg.clickOnLeftArrowKey();
		prdtpg.clickOnLeftArrowKey();
		prdtpg.clickOnLightBoxImg();
		prdtpg.clickOnXCloseButton();
		log.info("Image On Light Box Found And Testing Performed On Right, Left and Close Arrow Keys");

		prdtpg.keyBoardActionsForTumbnail_1();
		prdtpg.keyBoardActionsForTumbnail_2();
		log.info("Key Board Actions Performed On Sub Image Light Box");

		Assert.assertTrue(prdtpg.isDisplayedNavigatonBar());
		log.info("Navigation Bar Displayed On WebPage");

		log.info("***** TC071_PDthumnailtest Completed *****");

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
