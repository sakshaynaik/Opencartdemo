package com.opencart.testcase;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.pageobject.Addressbookpage;
import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Loginpage;
import com.opencart.pageobject.Registerationpage;
import com.opencart.utilities.MyXlsReader;
import com.opencart.utilities.ReadXlsxFile;

public class TC109_ABcreatenewaddresstest extends BaseClass{

	@Test(dataProvider = "existdata")
	public void addressBookDeleteAddress(HashMap<String, String> hMap) {

		log.info("***** TC109_ABcreatenewaddresstest Started *****");

		if (!ReadXlsxFile.isRunnable(xlsreader, "Addressbook", "Testcases") || hMap.get("Runmode").equals("N")) {

			throw new SkipException("Test Method Skipped Due To Run Mode Set To N");
		}

		Homepage hmpg = new Homepage(driver);
		hmpg.clickOnMyAccountDropMenu();
		log.info("Clicked On MyAccount Drop Menu");

		Assert.assertTrue(hmpg.isDisplayedRegisterOption());
		log.info("Register Option Displayed On MyAccount Drop Menu");

		Registerationpage regpg = hmpg.clickOnRegisterLink();
		Assert.assertEquals(regpg.getRegPageTitle(), config.getRegisterationPageTitle());
		log.info("Registration Page Title: " + regpg.getRegPageTitle());

		regpg.clickOnAddressBookLink();
		Loginpage loginpg = new Loginpage(driver);
		Assert.assertEquals(loginpg.getLoginPageTitle(), config.getLoginPageTitle());
		log.info("Login Page Title: " + loginpg.getLoginPageTitle());

		loginpg.enterRegisteredEmail(hMap.get("Email"));
		loginpg.enterRegisteredPassword(hMap.get("Password"));
		loginpg.clickLoginButton();

		Addressbookpage addresspg = new Addressbookpage(driver);
		Assert.assertEquals(addresspg.getAddressBookPageTitle(), config.getAddressBookPageTitle());
		log.info("AddressBook Page Title: " + addresspg.getAddressBookPageTitle());

		addresspg.clickOnDeleteButton();
		Assert.assertTrue(addresspg.isDisplayedDeleteWarnMsg());
		log.info("Warn Message Default Address Cannot Be Deleted: " + addresspg.getDeleteWarnMsg());
		
		addresspg.clickOnNewAddressButton();
		addresspg.enterFirstName(hMap.get("FirstName"));
		addresspg.enterLastName(hMap.get("LastName"));
		addresspg.enterCompanyName(hMap.get("Companyname"));
		addresspg.enterAddress1(hMap.get("Address1"));
		addresspg.enterAddress2(hMap.get("Address2"));
		addresspg.entercityName(hMap.get("Cityname"));
		addresspg.enterPostalCode(hMap.get("Postcode"));
		addresspg.selectByTextCountry(hMap.get("countryoption"));
		addresspg.selectByIndexZone(Integer.parseInt(hMap.get("Zoneoption")));
		addresspg.clickOnContinueButton();
		Assert.assertTrue(addresspg.isDisplayedNewAddressBookSuccessMsg());
		log.info("Address Success Update Message: " + addresspg.getNewAddressBookSuccessMsg());
		
		addresspg.clickOnDeleteButton();
		Assert.assertTrue(addresspg.isDisplayedUpdateAddressDeleteSuccessMsg());
		log.info("Address Success Delete Message: " + addresspg.getUpdateAddressDeleteSuccessMsg());

		log.info("***** TC109_ABcreatenewaddresstest Started *****");
	}

	@DataProvider(name = "existdata")
	public Object[][] dataSupplier() {

		Object[][] data = null;
		try {
			String file = System.getProperty("user.dir") + "//testdata//testdatafile.xlsx";
			xlsreader = new MyXlsReader(file);
			data = ReadXlsxFile.getTestData(xlsreader, "newaccount", "addresbook");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
}
