package com.opencart.zdatadriven;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.pageobject.Accountpage;
import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Loginpage;
import com.opencart.utilities.MyXlsReader;
import com.opencart.utilities.ReadXlsxFile;

public class TC02_DDLoginFunctionTest extends Baseclassdatadriven {

	@Test(dataProvider = "AllFieldTest")
	public void loginWithValidCredentials(HashMap<String, String> hMap) {

		log.info("***** TC02_DDLoginFunctionTest Started *****");

		if (!ReadXlsxFile.isRunnable(xlsreader, "LoginTest", "Testcases") || hMap.get("Runmode").equals("N")) {

			throw new SkipException("Test Skipped Due To Runmode Set As N");
		}

		setBrowser(hMap.get("Browser"));

		Homepage hmpg = new Homepage(driver);
		hmpg.clickOnMyAccountDropMenu();
		log.info("Clicked On MyAccount Drop Menu");

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

		String expresult = hMap.get("ExpectedResult");
		boolean convexpresult = false;

		if (expresult.equals("Success")) {
			convexpresult = true;
		} else if (expresult.equals("Failure")) {
			convexpresult = false;
		}

		boolean convactualresult;

		try {

			Assert.assertEquals(accntpg.getAccountPageTitle(), config.getAccountPageTitle());
			log.info("Acconts Page Title: " + accntpg.getAccountPageTitle());

			Assert.assertTrue(accntpg.isDisplayedEditInfoLink());
			log.info("Edit Info Link Displayed On Accounts Page");

			Assert.assertTrue(accntpg.isDisplayedAccountLinkOnBedcrum());
			log.info("Accont Link Displayed On BedCrum Of Accounts Page");

			accntpg.clickOnMyAccountDropMenu();
			convactualresult = accntpg.isDisplayedLogoutOption();
			Assert.assertTrue(convactualresult);
			log.info("Logout Option Displayed On MyAccount Drop Menu");

			accntpg.clickLogoutOption();
			log.info("User Logged Out From MyAccounts Page");

		} catch (Throwable e) {

			convactualresult = false;
			log.info("User Login Failed Due To Invalid Credentials");
		}

		Assert.assertEquals(convactualresult, convexpresult);

		log.info("***** TC02_DDLoginFunctionTest Completed *****");

	}

	@DataProvider(name = "AllFieldTest")
	public Object[][] datasuppiler() {

		Object[][] data = null;

		try {
			String filepath = System.getProperty("user.dir") + "//testdata//datadrivenfile.xlsx";
			xlsreader = new MyXlsReader(filepath);
			data = ReadXlsxFile.getTestData(xlsreader, "logindata", "Data");
		} catch (Exception e) {

			e.printStackTrace();
		}
		return data;
	}
}