package com.opencart.testcase;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Myaccountinfopage;
import com.opencart.pageobject.Registerationpage;
import com.opencart.pageobject.Successpage;
import com.opencart.utilities.MyXlsReader;
import com.opencart.utilities.ReadXlsxFile;

public class TC011_RFinvalidphonenumtest extends BaseClass {

	@Test(dataProvider = "invalidPhNo")
	public void registeringWithInvalidPhoneNumber(HashMap<String, String> hMap) {

		log.info("***** TC011_RFinvalidphonenumtest Started *****");

		if (!ReadXlsxFile.isRunnable(xlsreader, "Register", "Testcases") || hMap.get("Runmode").equals("N")) {

			throw new SkipException("Test Method Skipped Due to Run Mode Set To N");
		}

		Homepage hmpg = new Homepage(driver);
		hmpg.clickOnMyAccountDropMenu();
		Assert.assertTrue(hmpg.isDisplayedRegisterOption());
		log.info("Register Option Displayed In MyAccount Drop Menu");

		Registerationpage respg = hmpg.clickOnRegisterLink();
		Assert.assertEquals(respg.getRegPageTitle(), config.getRegisterationPageTitle());
		log.info("User Logged Into Registration Page: " + respg.getRegPageTitle());

		respg.enterFirstNameTextField(hMap.get("FirstName"));
		respg.enterLastNameTextField(hMap.get("LastName"));
		respg.enterEmialTextField(getRandomStringValue(4) + "@gmail.com");
		respg.enterTelephoneTextField(hMap.get("Telephone"));
		respg.enterPasswordTextField(hMap.get("Password"));
		respg.enterConfirmPasswordTextField(hMap.get("ConfirmPassword"));
		respg.clickOnNewsLetterRadioButton();
		respg.clickOnPriveryPolicyField();
		Successpage succpg = respg.clickOnContinueButton();

		try {
		Assert.assertEquals(respg.getRegPageTitle(), config.getRegisterationPageTitle());
		Assert.assertTrue(respg.isDisplayedWarnTelephonemsg());
		log.info("User Still In Registration Page Due To Invaild Telephone Number :" + respg.getWarnTelephonemsg());
		
		}catch(Throwable e ) {
	
			Myaccountinfopage editinfopg = succpg.clickOnEditAccountLink();
			Assert.assertEquals(editinfopg.getMyAccountInfoPageTitle(), config.getMyAccountInfoPageTitle());
			log.info("My Account Info Page Title " + editinfopg.getMyAccountInfoPageTitle());
			
			editinfopg.drawBorderForTelephoneTextField();
			Assert.fail("User Was Able To Register With The Application With Invalid TelephoneNumber");
		}

		log.info("***** TC011_RFinvalidphonenumtest Completed *****");
	}

	@DataProvider(name = "invalidPhNo")
	public Object[][] dataSupplier() {

		Object[][] data = null;
		try {

			String path = System.getProperty("user.dir") + "//testdata//testdatafile.xlsx";
			xlsreader = new MyXlsReader(path);
			data = ReadXlsxFile.getTestData(xlsreader, "RegisterInvalidPhone", "Data");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;

	}

}
