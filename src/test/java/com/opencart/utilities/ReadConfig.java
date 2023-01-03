package com.opencart.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties prop;
	String filepath = System.getProperty("user.dir") + "//configration//config.properties";

	public ReadConfig() {

		prop = new Properties();
		File file = new File(filepath);

		try {
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getBrowser() {

		String browser = prop.getProperty("Browser");
		if (browser != null)
			return browser;
		else
			throw new RuntimeException("Browser Name Not Found In Properties File");
	}

	public String getURL() {

		String url = prop.getProperty("URL");
		if (url != null)
			return url;
		else
			throw new RuntimeException("URL Not Found In Properties File");
	}

	public String getHomePageTitle() {

		String hmpg = prop.getProperty("HomePageTitle");
		if (hmpg != null)
			return hmpg;
		else
			throw new RuntimeException("HomePageTitle Not Found In Properties File");
	}

	public String getRegisterationPageTitle() {

		String repg = prop.getProperty("RegisterPageTitle");
		if (repg != null)
			return repg;
		else
			throw new RuntimeException("RegisterPageTitle Not Found In Properties File");
	}

	public String getSuccessPageTitle() {

		String scpg = prop.getProperty("SuccessPageTitle");
		if (scpg != null)
			return scpg;
		else
			throw new RuntimeException("SuccessPageTitle Not Found In Properties File");
	}

	public String getAccountPageTitle() {

		String acpg = prop.getProperty("AccountPageTitle");
		if (acpg != null)
			return acpg;
		else
			throw new RuntimeException("AccountPageTitle Not Found In Properties File");
	}

	public String getNewsletterPageTitle() {

		String nwpg = prop.getProperty("NewletterPageTitle");
		if (nwpg != null)
			return nwpg;
		else
			throw new RuntimeException("NewletterPageTitle Not Found In Properties File");
	}

	public String getLoginPageTitle() {

		String lgpg = prop.getProperty("loginPageTitle");
		if (lgpg != null)
			return lgpg;
		else
			throw new RuntimeException("LoginPageTitle Not Found In Properties File");
	}

	public String getForgotPasswrdPageTitle() {

		String fgpg = prop.getProperty("forgotpasswrdTitle");
		if (fgpg != null)
			return fgpg;
		else
			throw new RuntimeException("ForgotpasswrdTitle Not Found In Properties File");
	}

	public String getAccountLogoutPageTitle() {

		String aclogt = prop.getProperty("AccountlogoutTitle");
		if (aclogt != null)
			return aclogt;
		else
			throw new RuntimeException("AccountlogoutTitle Not Found In Properties File");
	}

	public String getSearchPageTitle() {

		String srcgpg = prop.getProperty("SearchPageTitle");
		if (srcgpg != null)
			return srcgpg;
		else
			throw new RuntimeException("SearchPageTitle Not Found In Properties File");
	}

	public String getCompareProductPageTitle() {

		String comprd = prop.getProperty("ComapreProdutTitle");
		if (comprd != null)
			return comprd;
		else
			throw new RuntimeException("ComapreProdutPageTitle Not Found In Properties File");
	}

	public String getSiteMapPageTitle() {

		String sitemap = prop.getProperty("siteMapTitle");
		if (sitemap != null)
			return sitemap;
		else
			throw new RuntimeException("siteMapPageTitle Not Found In Properties File");
	}

	public String getDesktopsPageTitle() {

		String desktop = prop.getProperty("DesktopsPageTitle");
		if (desktop != null)
			return desktop;
		else
			throw new RuntimeException("DesktopsPageTitle Not Found In Properties File");
	}

	public String getWishlistPageTitle() {

		String wshlst = prop.getProperty("WishlistPageTitle");
		if (wshlst != null)
			return wshlst;
		else
			throw new RuntimeException("WishlistPageTitle Not Found In Properties File");
	}

	public String getShoppingCartPageTitle() {

		String scpg = prop.getProperty("ShoppingCartPagTitle");
		if (scpg != null)
			return scpg;
		else
			throw new RuntimeException("ShoppingCartPageTitle Not Found In Properties File");
	}
	
	public String getPCPageTitle() {

		String pcpg = prop.getProperty("PCPageTitle");
		if (pcpg != null)
			return pcpg;
		else
			throw new RuntimeException("PCPageTitle Not Found In Properties File");
	}

	public String getCheckoutPageTitle() {

		String ckpg = prop.getProperty("CheckoutpPageTitle");
		if (ckpg != null)
			return ckpg;
		else
			throw new RuntimeException("CheckoutPageTitle Not Found In Properties File");
	}
	
	public String getOrderPlacedPageTitle() {

		String odrpg = prop.getProperty("OrderPlacedPageTitle");
		if (odrpg != null)
			return odrpg;
		else
			throw new RuntimeException("OrderPlacedPageTitle Not Found In Properties File");
	}
}
