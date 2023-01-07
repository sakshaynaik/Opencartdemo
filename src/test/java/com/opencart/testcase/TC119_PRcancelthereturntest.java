package com.opencart.testcase;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.pageobject.Accountpage;
import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Loginpage;
import com.opencart.pageobject.Orderhistorypage;
import com.opencart.pageobject.Orderinformationpage;
import com.opencart.pageobject.Productreturnpage;
import com.opencart.utilities.MyXlsReader;
import com.opencart.utilities.ReadXlsxFile;

public class TC119_PRcancelthereturntest extends BaseClass {

	@Test(dataProvider = "existdata")
	public void productReturnForReturnPage(HashMap<String, String> hMap) {

		log.info("***** TC119_PRcancelthereturntest Completed *****");

		if (!ReadXlsxFile.isRunnable(xlsreader, "Returnorder", "Testcases") || hMap.get("Runmode").equals("N")) {

			throw new SkipException("Test Method Skipped Due To Run Mode Set To N");
		}

		Homepage hmpg = new Homepage(driver);
		hmpg.clickOnMyAccountDropMenu();
		Assert.assertTrue(hmpg.isDisplayedLoginOption());
		log.info("Login Option Displayed On MyAccount Drop Menu");

		Loginpage loginpg = hmpg.clickOnLoginLink();
		log.info("Clicked On Login Option From MyAccount Drop Menu");

		Assert.assertEquals(loginpg.getLoginPageTitle(), config.getLoginPageTitle());
		log.info("Navigated To Login Page: " + loginpg.getLoginPageTitle());

		loginpg.enterRegisteredEmail(hMap.get("Email"));
		loginpg.enterRegisteredPassword(hMap.get("Password"));
		Accountpage accntpg = loginpg.clickLoginButton();
		log.info("User Logged Into Accounts Page ");

		Assert.assertEquals(accntpg.getAccountPageTitle(), config.getAccountPageTitle());
		log.info("Acconts Page Title: " + accntpg.getAccountPageTitle());

		Assert.assertTrue(accntpg.isDisplayedEditInfoLink());
		log.info("Edit Info Link Displayed On Accounts Page");

		Orderhistorypage orderpg = accntpg.clickOnOrderHistoryLink();
		Assert.assertEquals(orderpg.getOrderHistoryPageTitle(), config.getOrderHistoryPageTitle());
		log.info("Order History Page Title: " + orderpg.getOrderHistoryPageTitle());

		Orderinformationpage orderinfopg = orderpg.clickOnViewOrderInfo();
		Assert.assertEquals(orderinfopg.getOrderInfoPageTitle(), config.getOrderInfoPageTitle());
		log.info("Order Information Page Title: " + orderinfopg.getOrderInfoPageTitle());

		Assert.assertTrue(orderinfopg.isDisplayedOrderDetailsContent());
		log.info("Order Info Content: " + orderinfopg.getOrderDetailsContent());

		Assert.assertTrue(orderinfopg.isDisplayedOrderDetailsContent2());
		log.info("Order Info Content Two: " + orderinfopg.getOrderDetailsContent2());

		Productreturnpage prdtretnpg = orderinfopg.clickOnReturnOrderLink();
		Assert.assertEquals(prdtretnpg.getProductReturnPageTitle(), prdtretnpg.getProductReturnPageTitle());
		log.info("Product Return Page Title: " + prdtretnpg.getProductReturnPageTitle());

		Assert.assertTrue(prdtretnpg.isDisplayedProductReturnMsg());
		log.info("Product Added To Return Table: " + prdtretnpg.getProductReturnMsg());

		prdtretnpg.clickResonOfReturnRadioButton(hMap.get("returnreason"));
		prdtretnpg.clickOnBackButton();

		Assert.assertEquals(accntpg.getAccountPageTitle(), config.getAccountPageTitle());
		log.info("Acconts Page Title: " + accntpg.getAccountPageTitle());

		log.info("***** TC119_PRcancelthereturntest Completed *****");
	}

	@DataProvider(name = "existdata")
	public Object[][] dataSupplier() {

		Object[][] data = null;
		try {
			String file = System.getProperty("user.dir") + "//testdata//testdatafile.xlsx";
			xlsreader = new MyXlsReader(file);
			data = ReadXlsxFile.getTestData(xlsreader, "returnproduct", "returnorder");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
}
