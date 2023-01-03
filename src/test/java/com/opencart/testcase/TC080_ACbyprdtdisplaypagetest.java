package com.opencart.testcase;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Productpage;
import com.opencart.pageobject.Searchpage;
import com.opencart.pageobject.Shoppingcartpage;

public class TC080_ACbyprdtdisplaypagetest extends BaseClass {

	@Test(dataProvider = "addtocart")
	public void addToCartByProductDisplayPage(String fielddata) {

		log.info("***** TC080_ACbyprdtdisplaypagetest Started *****");

		String[] data = fielddata.split(",");

		Homepage hmpg = new Homepage(driver);
		hmpg.enterSearchTextField(data[1]);
		Searchpage srchpg = hmpg.clickOnSearchButton();
		Assert.assertTrue(srchpg.getSearchPageTitle().contains(config.getSearchPageTitle()));
		log.info("Search Page Title: " + srchpg.getSearchPageTitle());

		Productpage prdtpg = srchpg.clickOnAppleCinemaLink();
		Assert.assertTrue(prdtpg.isDisplayedImgOfAppleCinema30());
		log.info("Search Page Title: " + prdtpg.getProductPageTitle());

		prdtpg.clickOnAppleCinema30RadioButton();
		int num = getRandomIntValue(prdtpg.getSizeOfCheckBoxAppleCinema30());
		prdtpg.setCheckBoxAppleCinema30(num);
		prdtpg.enterTextFieldOfAppleCinema30(data[2]);
		prdtpg.selectColorOfAppleCinema30(Integer.parseInt(data[3]));
		prdtpg.enterTextBoxOfAppleCinema30(data[4]);
		prdtpg.clickOnUploadButton();
		prdtpg.uploadFile(data[5]);
		prdtpg.clickOnCalenderButton();
		prdtpg.setDeliveryDate(data[6]);
		prdtpg.enterTimeOfDelivery(data[7]);
		prdtpg.enterTheQtyOfApple30(data[8]);
		prdtpg.clickOnAddToCartButtonForApple30();
		Assert.assertTrue(prdtpg.isDispalyedOfWhishlistMsg());
		log.info("Success Added To Wish-List Message Displayed: " + prdtpg.getTexOfWhishlistMsg());

		Shoppingcartpage shopcart = prdtpg.clickOnAppleCinema30ShopcartMsgLink();
		Assert.assertEquals(shopcart.getShoppingCartPageTitle(), config.getShoppingCartPageTitle());
		log.info("ShopCart Page Title: " + shopcart.getShoppingCartPageTitle());

		Assert.assertTrue(shopcart.isDisplayedAppleCinema30Img());
		log.info("Apple Cinema 30inch Was Displayed On Shopping Cart Page");

		log.info("***** TC080_ACbyprdtdisplaypagetest Completed *****");
	}

	@DataProvider(name = "addtocart")
	public Object[] dataSupplier() {

		JSONParser jsonparser = new JSONParser();
		Object object = null;

		try {
			String filepath = System.getProperty("user.dir") + "//jsonfiles//addtocart.json";
			FileReader reader = new FileReader(filepath);
			object = jsonparser.parse(reader);

		} catch (Exception e) {
			e.printStackTrace();
		}

		JSONObject jsonobject = ((JSONObject) object);
		JSONArray jsonarray = (JSONArray) jsonobject.get("addapplecinema30");
		Object[] arr = new Object[jsonarray.size()];
		for (int i = 0; i < jsonarray.size(); i++) {

			JSONObject data = (JSONObject) jsonarray.get(i);
			Object browser = data.get("browser");
			Object prdt = data.get("product");
			Object txtfld = data.get("textfld");
			Object selclr = data.get("selectcolour");
			Object txtbox = data.get("textbox");
			Object dsktfle = data.get("deskktopfile");
			Object deldate = data.get("deliverydate");
			Object deltime = data.get("deliverytime");
			Object qtyno = data.get("Qty");

			arr[i] = browser + "," + prdt + "," + txtfld + "," + selclr + "," + txtbox + "," + dsktfle + "," + deldate
					+ "," + deltime + "," + qtyno;
		}
		return arr;
	}
}
