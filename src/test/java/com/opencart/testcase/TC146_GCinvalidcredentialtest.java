package com.opencart.testcase;

import java.util.HashMap;

import org.junit.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.pageobject.Giftcertificatepage;
import com.opencart.pageobject.Homepage;
import com.opencart.utilities.MyXlsReader;
import com.opencart.utilities.ReadXlsxFile;

public class TC146_GCinvalidcredentialtest extends BaseClass{

	@Test(dataProvider = "gftcertifate")
	public void giftCertificateTestWithInValidData(HashMap<String, String> hMap) {

		log.info("***** TC146_GCinvalidcredentialtest Started *****");

		if (!ReadXlsxFile.isRunnable(xlsreader, "Giftcertificate", "Testcases") || hMap.get("Runmode").equals("N")) {

			throw new SkipException("Test Skipped Due To Runmode Set As N");
		}

		Homepage hmpg = new Homepage(driver);
		Giftcertificatepage gftpg = hmpg.clickOnGiftCertificateLink();
		Assert.assertEquals(gftpg.getGiftCertificatePageTitle(), config.getGiftCertificatePageTitle());
		log.info("Gift Certificate Page Title: " + gftpg.getGiftCertificatePageTitle());

		gftpg.enterRecipientsNameTextField(hMap.get("RecipitName"));
		gftpg.enterRecipientsEmailTextField(hMap.get("RecipitEmail"));
		gftpg.enterSenderNameTextField(hMap.get("ename"));
		gftpg.enterSenderEmailTextField(hMap.get("email"));
		gftpg.clickOnGiftCertifacteTheme(hMap.get("GiftCertTheme"));
		gftpg.enterAmountTextField(hMap.get("Amount"));
		gftpg.clickOnAgreeCheckBox();
		gftpg.clickOnContinueButton();

		Assert.assertTrue(gftpg.isDisplayedInvalidAmountMsg());
		log.info("Invalid Amount Added Message Displayed: " + gftpg.getInvalidAmountMsg());

		log.info("***** TC146_GCinvalidcredentialtest Completed *****");
	}

	@DataProvider(name = "gftcertifate")
	public Object[][] datasuppiler() {

		Object[][] data = null;

		try {
			String filepath = System.getProperty("user.dir") + "//testdata//testdatafile.xlsx";
			xlsreader = new MyXlsReader(filepath);
			data = ReadXlsxFile.getTestData(xlsreader, "invaliddata", "giftcertificate");
		} catch (Exception e) {

			e.printStackTrace();
		}
		return data;
	}

}
