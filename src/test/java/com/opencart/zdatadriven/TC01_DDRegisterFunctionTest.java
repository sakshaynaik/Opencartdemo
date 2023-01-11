package com.opencart.zdatadriven;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.pageobject.Accountpage;
import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Registerationpage;
import com.opencart.pageobject.Successpage;
import com.opencart.utilities.MyXlsReader;
import com.opencart.utilities.ReadXlsxFile;

public class TC01_DDRegisterFunctionTest extends Baseclassdatadriven {

	@Test(dataProvider = "AllFieldTest")
	public void registeringWithAllFileds(HashMap<String, String> hMap) {

		log.info("***** TC01_DDRegisterFunctionTest Started *****");

		if (!ReadXlsxFile.isRunnable(xlsreader, "RegisterTest", "Testcases") || hMap.get("Runmode").equals("N")) {

			throw new SkipException("Test Skipped Due To Runmode Set As N");
		}

		setBrowser(hMap.get("Browser"));

		Homepage hmpg = new Homepage(driver);
		hmpg.clickOnMyAccountDropMenu();
		Assert.assertTrue(hmpg.isDisplayedRegisterOption());
		log.info("Register Option Displayed In MyAccount Drop Menu");

		Registerationpage respg = hmpg.clickOnRegisterLink();
		Assert.assertEquals(respg.getRegPageTitle(), config.getRegisterationPageTitle());
		log.info("User Logged Into Registration Page");

		respg.enterFirstNameTextField(hMap.get("FirstName"));
		respg.enterLastNameTextField(hMap.get("LastName"));
		respg.enterEmialTextField(getRandomStringValue(4) + "@gmail.com");
		respg.enterTelephoneTextField(hMap.get("Telephone"));
		respg.enterPasswordTextField(hMap.get("Password"));
		respg.enterConfirmPasswordTextField(hMap.get("ConfirmPassword"));
		respg.clickOnNewsLetterRadioButton();
		respg.clickOnPriveryPolicyField();

		Successpage sucespg = respg.clickOnContinueButton();

		String expectedresult = hMap.get("ExpectedResult");

		boolean convertedexptres = false;

		if (expectedresult.equalsIgnoreCase("Success")) {
			convertedexptres = true;
		} else if (expectedresult.equalsIgnoreCase("Failure")) {
			convertedexptres = false;
		}

		boolean convertedactres = false;

		try {
			Assert.assertEquals(sucespg.getSuccessPageTitle(), config.getSuccessPageTitle());
			log.info("User Logged Into AccountSuccess Page");

			Assert.assertTrue(sucespg.isDisplayedLogoutOption());
			log.info("Logout Option Displayed On MyAccount Drop Menu");

			Assert.assertTrue(sucespg.isDisplayedSuccessOnBedcrum());
			log.info("Success Link Displayed On Bedcrum");

			Assert.assertTrue(sucespg.isDisplayedSubAccountSuccessMsg());
			log.info("Account Success Message Displayed: " + sucespg.getSubAccountSuccessMsg());

			Accountpage accpg = sucespg.clickOnContinueButton();
			convertedactres = accpg.isDisplayedEditInfoLink();
			Assert.assertTrue(convertedactres);
			log.info("Edit your account information Link Displayed On WebPage");

			Assert.assertEquals(accpg.getAccountPageTitle(), config.getAccountPageTitle());
			log.info("User Logged Into Account Page");

			Assert.assertTrue(accpg.isDisplayedAccountLinkOnBedcrum());
			log.info("Account Link Displayed On Bedcrum");
			
		} catch (Throwable e) {

			convertedactres = false;
			Assert.assertEquals(respg.getRegPageTitle(), config.getRegisterationPageTitle());

		}

		Assert.assertEquals(convertedexptres, convertedactres);

		log.info("***** TC01_DDRegisterFunctionTest Completed *****");

	}

	@DataProvider(name = "AllFieldTest")
	public Object[][] datasuppiler() {

		Object[][] data = null;

		try {
			String filepath = System.getProperty("user.dir") + "//testdata//datadrivenfile.xlsx";
			xlsreader = new MyXlsReader(filepath);
			data = ReadXlsxFile.getTestData(xlsreader, "registerdata", "Data");
		} catch (Exception e) {

			e.printStackTrace();
		}
		return data;
	}

}
