package com.opencart.testcase;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.pageobject.Accountpage;
import com.opencart.pageobject.Checkoutpage;
import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Orderplacedpage;
import com.opencart.pageobject.Productpage;
import com.opencart.pageobject.Searchpage;
import com.opencart.pageobject.Shoppingcartpage;
import com.opencart.utilities.MyXlsReader;
import com.opencart.utilities.ReadXlsxFile;

public class TC101_MAnavigatefromordersuccesstest extends BaseClass{

	@Test(dataProvider = "existdata")
	public void myAccountNavigationFromOrderSuccessPage(HashMap<String, String> hMap) {
		
		log.info("***** TC101_MAnavigatefromordersuccesstest Started *****");

		if (!ReadXlsxFile.isRunnable(xlsreader, "Checkout", "Testcases") || hMap.get("Runmode").equals("N")) {

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

		Assert.assertTrue(prdtpg.isDispalyedOfProductAvailabity());
		log.info("Availabity Of iMac Was Displayed On Product Page: " + prdtpg.getTexOfProductAvailabity());

		prdtpg.clickOnAddToCartButton();
		Assert.assertTrue(prdtpg.isDispalyedOfWhishlistMsg());
		log.info("Success Added To Wish-List Message Displayed: " + prdtpg.getTexOfWhishlistMsg());

		Shoppingcartpage shopcart = prdtpg.clickOnShopCartMsgLink();
		Assert.assertEquals(shopcart.getShoppingCartPageTitle(), config.getShoppingCartPageTitle());
		log.info("ShopCart Page Title: " + shopcart.getShoppingCartPageTitle());

		Assert.assertTrue(shopcart.isDisplayediMacImg());
		log.info("Success Added Product To Shopping cart Page");

		Checkoutpage chckoutpg = shopcart.clickOnCheckOutButton();
		Assert.assertEquals(chckoutpg.getCheckoutPageTitle(), config.getCheckoutPageTitle());
		log.info("Check Out Page Title: " + chckoutpg.getCheckoutPageTitle());

		chckoutpg.clickOnRegisterCheckoutRadioButton();
		chckoutpg.clickOnGuestCheckoutContinueButton();

		String value = getRandomStringNumericValue(5);

		chckoutpg.enterFirstName(hMap.get("FirstName"));
		chckoutpg.enterLastName(hMap.get("LastName"));
		chckoutpg.enterCompanyName(hMap.get("Companyname"));
		chckoutpg.enterAddress1(hMap.get("Address1"));
		chckoutpg.enterAddress2(hMap.get("Address2"));
		chckoutpg.enterCityName(hMap.get("Cityname"));
		chckoutpg.enterPostalCode(hMap.get("Postcode"));
		chckoutpg.selectCountry(hMap.get("countryoption"));
		chckoutpg.selectZone(Integer.parseInt(hMap.get("Zoneoption")));
		chckoutpg.enterEmailForPayment(getRandomStringValue(4) + "@gmail.com");
		chckoutpg.enterTelephoneForPayment(hMap.get("Telephone"));
		chckoutpg.enterPasswordInTextField(value);
		chckoutpg.enteConfirmPasswordInTextField(value);
		chckoutpg.clickOnPrivercyPolicy();
		chckoutpg.clickOnRegisterContinueButton();
		log.info("User Has Successfully Updated As A New Registering Details");

		chckoutpg.clickOnShippingAddressContinueButton();
		chckoutpg.clickOnShippingMethodContinueButton();
		chckoutpg.clickOnAgreeCheckBox();
		chckoutpg.clickOnPaymentButtonContinueButton();
		Orderplacedpage orderconpg = chckoutpg.clickOnOrderConfirmButton();

		Assert.assertEquals(orderconpg.getOrderplacedPageTitle(), config.getOrderPlacedPageTitle());
		log.info("Order Confirmation Page Title: " + orderconpg.getOrderplacedPageTitle());

		Assert.assertTrue(orderconpg.isDisplayedSuccessOnBedcrum());
		Assert.assertTrue(orderconpg.isDisplayedOrderplacedMessage());
		log.info("Order Confirmation Success Message: " + orderconpg.getOrderplacedMessage());
		
		Accountpage accpg = orderconpg.clickOnMyAccountLink();
		Assert.assertEquals(accpg.getAccountPageTitle(), config.getAccountPageTitle());
		log.info("User Logged Into Account Page: " + accpg.getAccountPageTitle());

		log.info("***** TC101_MAnavigatefromordersuccesstest Completed *****");

	}
	
	@DataProvider(name = "existdata")
	public Object[][] dataSupplier() {

		Object[][] data = null;
		try {
			String file = System.getProperty("user.dir") + "//testdata//testdatafile.xlsx";
			xlsreader = new MyXlsReader(file);
			data = ReadXlsxFile.getTestData(xlsreader, "newreguser", "Checkout");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
}
