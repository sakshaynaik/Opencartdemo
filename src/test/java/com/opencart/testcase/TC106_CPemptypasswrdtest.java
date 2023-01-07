package com.opencart.testcase;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.pageobject.Accountpage;
import com.opencart.pageobject.Changepasswordpage;
import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Loginpage;
import com.opencart.utilities.MyXlsReader;
import com.opencart.utilities.ReadXlsxFile;

public class TC106_CPemptypasswrdtest extends BaseClass {

	@Test(dataProvider = "existdata")
	public void changePasswordWithEmptyData(HashMap<String, String> hMap) {

		log.info("***** TC106_CPemptypasswrdtest Started *****");

		if (!ReadXlsxFile.isRunnable(xlsreader, "Changepassword", "Testcases") || hMap.get("Runmode").equals("N")) {

			throw new SkipException("Test Method Skipped Due To Run Mode Set To N");
		}

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

		Assert.assertEquals(accntpg.getAccountPageTitle(), config.getAccountPageTitle());
		log.info("Acconts Page Title: " + accntpg.getAccountPageTitle());

		Assert.assertTrue(accntpg.isDisplayedEditInfoLink());
		log.info("Edit Info Link Displayed On Accounts Page");

		Assert.assertTrue(accntpg.isDisplayedAccountLinkOnBedcrum());
		log.info("Accont Link Displayed On BedCrum Of Accounts Page");

		Changepasswordpage changepasspg = accntpg.clickOnChangePasswordLink();
		Assert.assertEquals(changepasspg.getChangePasswordPageTitle(), config.getChangePasswordPageTitle());
		log.info("Change Password Page Title: " + changepasspg.getChangePasswordPageTitle());

		Assert.assertTrue(changepasspg.getAttributeForNewPasswordTextField("placeholder") != null);
		log.info("PlaceHolderFor Confirm Password: " + changepasspg.getAttributeForNewPasswordTextField("placeholder"));

		changepasspg.enterNewPasswordTextField(hMap.get("newpass"));
		changepasspg.enterNewConfirmPasswordTextField(hMap.get("confrmnewpass"));
		changepasspg.clickOnConfirmButton();

		Assert.assertEquals(changepasspg.getChangePasswordPageTitle(), config.getChangePasswordPageTitle());
		log.info("User Still In Change Password Page Due To Empty Password Text Field");

		Assert.assertTrue(changepasspg.isDisplayedInvaildPassMsg());
		log.info("Empty New Password Text Field: " + changepasspg.getInvalidPassMsg());

		accntpg.clickLogoutOption();
		log.info("User Logged Out From The Site");

		hmpg.clickOnMyAccountDropMenu();
		hmpg.clickOnLoginLink();
		Assert.assertEquals(loginpg.getLoginPageTitle(), config.getLoginPageTitle());
		log.info("Navigated To Login Page: " + loginpg.getLoginPageTitle());

		loginpg.enterRegisteredEmail(hMap.get("Email"));
		loginpg.enterRegisteredPassword(hMap.get("Password"));
		loginpg.clickLoginButton();
		log.info("User In Navigated To Accounts Page");
		
		Assert.assertEquals(accntpg.getAccountPageTitle(), config.getAccountPageTitle());
		log.info("Acconts Page Title: " + accntpg.getAccountPageTitle());

		log.info("***** TC106_CPemptypasswrdtest Started *****");

	}

	@DataProvider(name = "existdata")
	public Object[][] dataSupplier() {

		Object[][] data = null;
		try {
			String file = System.getProperty("user.dir") + "//testdata//testdatafile.xlsx";
			xlsreader = new MyXlsReader(file);
			data = ReadXlsxFile.getTestData(xlsreader, "emptydetails", "changepass");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
}
