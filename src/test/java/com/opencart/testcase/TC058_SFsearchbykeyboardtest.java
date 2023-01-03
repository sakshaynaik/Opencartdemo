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

public class TC058_SFsearchbykeyboardtest extends BaseClass {

	@Test(dataProvider = "validserch")
	public void searchByKeyboardActions(HashMap<String, String> hMap) {

		if (!ReadXlsxFile.isRunnable(xlsreader, "Search", "Testcases") || hMap.get("Runmode").equals("N")) {

			throw new SkipException("Test Method Skipped Due To Run Mode Set To N");
		}

		Homepage hmpg = new Homepage(driver);
		Searchpage serchpg = hmpg.keyBoardActionForSearchField();
		serchpg.keyBoardActionForSelecting(hMap.get("Productname"));
		log.info("KeyBoard Actions Performed By The User To Search Product");
		
		Assert.assertTrue(serchpg.isDispalyedIMacProductThumb());
		log.info("User Searched Product Was Displayed On Search Page: " + serchpg.getIMacProductThumb());

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
