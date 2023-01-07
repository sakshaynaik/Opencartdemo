package com.opencart.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.utilities.ReadJavascriptExecutor;

public class Specialofferspage {

	WebDriver ldriver;

	public Specialofferspage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id = "grid-view")
	private WebElement gridview;
	
	@FindBy(id = "list-view")
	private WebElement listview;
	
    @FindBy(xpath = "//div[@class='button-group']/button[1]")
    private WebElement addtocartbutton;
    
    @FindBy(xpath = "//div[@class='button-group']/button[2]")
    private WebElement addtowishlistbuton;
    
    @FindBy(xpath = "//div[@class='button-group']/button[3]")
    private WebElement compareprdtbutton;
    
    @FindBy(xpath = "//div[contains(text(), 'You must')]")
    private WebElement wishlstmsg;
    
    @FindBy(xpath = "//div[contains(text(),'Success: You have added')]")
    private WebElement compareprdtmsg;
  
	///////////////////////////////////////////////////////////////////////////////////
    
    public String getCompareProductMessage() {

    	return (compareprdtmsg.getText());
	}
    
    public boolean isDisplayedCompareProductMessage() {

    	return (compareprdtmsg.isDisplayed());
	}
    
    public String getWishListMessage() {

    	return (wishlstmsg.getText());
	}
    
    public boolean isDisplayedWishListMessage() {

    	return (wishlstmsg.isDisplayed());
	}
    
    public void clickOnCompareThisProductButton() {

    	ReadJavascriptExecutor.clickElementByJavaScript(compareprdtbutton, ldriver);
	}
    
    public void clickOnAddToWishListButton() {

    	ReadJavascriptExecutor.clickElementByJavaScript(addtowishlistbuton, ldriver);
	}
    
	public Productpage clickOnAddToCartButton() {

		addtocartbutton.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return (new Productpage(ldriver));
	}
	
	public void clickOnListView() {

		listview.click();
	}
	
	public void clickOnGridView() {

		gridview.click();
	}

	public String getSpecialOffersPageTitle() {

		return (ldriver.getTitle());
	}
}
