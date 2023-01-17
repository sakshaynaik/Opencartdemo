package com.opencart.zdatadriven;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.pageobject.Checkoutpage;
import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Loginpage;
import com.opencart.pageobject.Orderplacedpage;
import com.opencart.pageobject.Productpage;
import com.opencart.pageobject.Searchpage;
import com.opencart.utilities.MyXlsReader;
import com.opencart.utilities.ReadXlsxFile;

public class TC03_DDCheckoutFunctionTest extends Baseclassdatadriven {

	@Test(dataProvider = "existdata")
	public void checkOutWithNewRegistration(HashMap<String, String> hMap) {

		log.info("***** TC03_DDCheckoutFunctionTest Started *****");

		if (!ReadXlsxFile.isRunnable(xlsreader, "CheckoutTest", "Testcases") || hMap.get("Runmode").equals("N")) {

			throw new SkipException("Test Method Skipped Due To Run Mode Set To N");
		}

		setBrowser(hMap.get("Browser"));
		Homepage hmpg = new Homepage(driver);
		hmpg.clickOnMyAccountDropMenu();
		Loginpage loginpg = hmpg.clickOnLoginLink();
		Assert.assertEquals(loginpg.getLoginPageTitle(), config.getLoginPageTitle());
		log.info("Navigated To Login Page: " + loginpg.getLoginPageTitle());

		hmpg.enterSearchTextField(hMap.get("Brand"));
		Searchpage srchpg = hmpg.clickOnSearchButton();
		Assert.assertTrue(srchpg.getSearchPageTitle().contains(config.getSearchPageTitle()));
		log.info("User Navigated To Search Page Title: " + srchpg.getSearchPageTitle());

		Assert.assertTrue(srchpg.isDisplayedDynamicWebElement(hMap.get("Product")));
		log.info("Product Was Displayed On Search Page: " + srchpg.isDisplayedDynamicWebElement("Product"));

		Productpage prdtpg = srchpg.clickOnDynamicWebElement(hMap.get("Product"));
		log.info("User Navigated To Product Page Title: " + prdtpg.getProductPageTitle());

		Assert.assertTrue(prdtpg.isDispalyedOfProductAvailabity());
		log.info("Availabity Of iMac Was Displayed On Product Page: " + prdtpg.getTexOfProductAvailabity());

		prdtpg.clickOnAddToCartButton();
		Assert.assertTrue(prdtpg.isDispalyedOfWhishlistMsg());
		log.info("Success Added To Wish-List Message Displayed: " + prdtpg.getTexOfWhishlistMsg());

		prdtpg.clickOnCartButton();
		Checkoutpage chckoutpg = prdtpg.clickOnCheckoutLinkFromCartBox();
		Assert.assertEquals(chckoutpg.getCheckoutPageTitle(), config.getCheckoutPageTitle());
		log.info("User Navigated To Checkout Page Title: " + chckoutpg.getCheckoutPageTitle());

		String expectedresult = hMap.get("ExpectedResult");
		boolean convexperes = false;
		if (expectedresult.equals("Success")) {
			convexperes = true;
		} else if (expectedresult.equals("Failure")) {
			convexperes = false;
		}
		boolean convactualres = false;

		loginpg.enterRegisteredEmail(hMap.get("Email"));
		loginpg.enterRegisteredPassword(hMap.get("Password"));
		chckoutpg.clickOnLoginButton();
		log.info("User Logged In CheckOut Page ");

		try {
			chckoutpg.clickOnBillContinueButton();
			chckoutpg.clickOnShippingAddressContinueButton();
			chckoutpg.clickOnShippingMethodContinueButton();
			chckoutpg.clickOnAgreeCheckBox();
			chckoutpg.clickOnPaymentButtonContinueButton();
			Orderplacedpage orderconpg = chckoutpg.clickOnOrderConfirmButton();

			Assert.assertEquals(orderconpg.getOrderplacedPageTitle(), config.getOrderPlacedPageTitle());
			log.info("Order Confirmation Page Title: " + orderconpg.getOrderplacedPageTitle());

			convactualres = orderconpg.isDisplayedSuccessOnBedcrum();
			Assert.assertTrue(orderconpg.isDisplayedSuccessOnBedcrum());
			Assert.assertTrue(orderconpg.isDisplayedOrderplacedMessage());
			log.info("Order Confirmation Success Message: " + orderconpg.getOrderplacedMessage());

		} catch (Exception e) {

			convactualres = false;
		}

		Assert.assertEquals(convactualres, convexperes);

		log.info("***** TC03_DDCheckoutFunctionTest Completed *****");

	}

	@DataProvider(name = "existdata")
	public Object[][] dataSupplier() {

		Object[][] data = null;
		try {
			String file = System.getProperty("user.dir") + "//testdata//datadrivenfile.xlsx";
			xlsreader = new MyXlsReader(file);
			data = ReadXlsxFile.getTestData(xlsreader, "checkoutdata", "Data");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
}
