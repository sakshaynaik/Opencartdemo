package com.opencart.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

	public WebDriver ldriver;
	public long Explicit_Wait = 30;

	public ElementUtils(WebDriver rdriver) {

		this.ldriver = rdriver;
	}

	public WebElement waitForElement(WebElement element, long durationInSeconds) {

		WebElement webElement = null;

		try {
			WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Throwable e) {
			e.printStackTrace();
		}

		return webElement;

	}

	public Alert waitForAlert(long durationInSeconds) {

		Alert alert = null;

		try {
			WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(durationInSeconds));
			alert = wait.until(ExpectedConditions.alertIsPresent());
		} catch (Throwable e) {
			e.printStackTrace();
		}

		return alert;

	}

	public WebElement waitForVisibilityOfElement(WebElement element, long durationInSeconds) {

		WebElement webElement = null;

		try {
			WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Throwable e) {
			e.printStackTrace();
		}

		return webElement;

	}

	public void click(WebElement element, long durationInSeconds) {

		WebElement webelement = waitForElement(element, durationInSeconds);
		try {
			webelement.click();
		} catch (WebDriverException e) {
			JavascriptExecutor js = ((JavascriptExecutor) ldriver);
			js.executeScript("arguments[0].click();", element);
		}
	}

	public void sendKeys(WebElement element, String value, long durationInSeconds) {

		WebElement webelement = waitForElement(element, durationInSeconds);
		webelement.click();
		webelement.clear();
		webelement.sendKeys(value);
	}

	public String getText(WebElement element, long durationInSeconds) {

		WebElement webelement = waitForElement(element, durationInSeconds);
		return (webelement.getText());
	}

	public boolean isDisplayed(WebElement element, long durationInSeconds) {
		try {
			WebElement webelement = waitForVisibilityOfElement(element, durationInSeconds);
			return (webelement.isDisplayed());
		} catch (Throwable e) {
			return false;
		}
	}

	public boolean isSelected(WebElement element, long durationInSeconds) {
		try {
			WebElement webelement = waitForVisibilityOfElement(element, durationInSeconds);
			return (webelement.isSelected());
		} catch (Throwable e) {
			return false;
		}
	}

	public boolean isEnabled(WebElement element, long durationInSeconds) {
		try {
			WebElement webelement = waitForVisibilityOfElement(element, durationInSeconds);
			return (webelement.isEnabled());
		} catch (Throwable e) {
			return false;
		}
	}

	public void selectByVisibleText(WebElement element, String dropDownOption, long durationInSeconds) {

		WebElement webelement = waitForElement(element, durationInSeconds);
		Select select = new Select(webelement);
		select.selectByVisibleText(dropDownOption);
	}

	public void selectByIndex(WebElement element, int index, long durationInSeconds) {

		WebElement webelement = waitForElement(element, durationInSeconds);
		Select select = new Select(webelement);
		select.selectByIndex(index);
	}

	public void selectByValue(WebElement element, String value, long durationInSeconds) {

		WebElement webelement = waitForElement(element, durationInSeconds);
		Select select = new Select(webelement);
		select.selectByValue(value);
	}

	public void deselectAll(WebElement element, long durationInSeconds) {

		WebElement webelement = waitForElement(element, durationInSeconds);
		Select select = new Select(webelement);
		select.deselectAll();
	}

	public void deselectByVisibleText(WebElement element, String dropDownOption, long durationInSeconds) {

		WebElement webelement = waitForElement(element, durationInSeconds);
		Select select = new Select(webelement);
		select.deselectByVisibleText(dropDownOption);
	}

	public void deselectByIndex(WebElement element, int index, long durationInSeconds) {

		WebElement webelement = waitForElement(element, durationInSeconds);
		Select select = new Select(webelement);
		select.deselectByIndex(index);
	}

	public void deselectByValue(WebElement element, String value, long durationInSeconds) {

		WebElement webelement = waitForElement(element, durationInSeconds);
		Select select = new Select(webelement);
		select.deselectByValue(value);
	}

	public boolean isMultiple(WebElement element, long durationInSeconds) {

		try {
			WebElement webelement = waitForVisibilityOfElement(element, durationInSeconds);
			Select select = new Select(webelement);
			return (select.isMultiple());
		} catch (Throwable e) {
			return false;
		}
	}

	public void mouseHoverAndClick(WebElement element, long durationInSeconds) {

		WebElement webelement = waitForVisibilityOfElement(element, durationInSeconds);
		Actions actions = new Actions(ldriver);
		actions.moveToElement(webelement).click().build().perform();
	}

	public void actionsClick(WebElement element, long durationInSeconds) {

		WebElement webelement = waitForVisibilityOfElement(element, durationInSeconds);
		Actions actions = new Actions(ldriver);
		actions.click(webelement).build().perform();
	}

	public void actionsMouseHover(WebElement element, long durationInSeconds) {

		WebElement webelement = waitForVisibilityOfElement(element, durationInSeconds);
		Actions actions = new Actions(ldriver);
		actions.moveToElement(webelement).build().perform();
	}

	public void actionsContextClick(WebElement element, long durationInSeconds) {

		WebElement webelement = waitForVisibilityOfElement(element, durationInSeconds);
		Actions actions = new Actions(ldriver);
		actions.contextClick(webelement).build().perform();
	}

	public void actionsDoubleClick(WebElement element, long durationInSeconds) {

		WebElement webelement = waitForVisibilityOfElement(element, durationInSeconds);
		Actions actions = new Actions(ldriver);
		actions.doubleClick(webelement).build().perform();
	}

	public void actionsDragAndDrop(WebElement source, WebElement target) {

		Actions actions = new Actions(ldriver);
		actions.dragAndDrop(source, target).build().perform();
	}

	public void actionsDragAndDropBy(WebElement element, int x, int y) {

		Actions actions = new Actions(ldriver);
		actions.dragAndDropBy(element, x, y).build().perform();
	}

	public void actionsKeyUpAndKeyDown(WebElement element, long durationInSeconds) {

		WebElement webelement = waitForVisibilityOfElement(element, durationInSeconds);
		Actions actions = new Actions(ldriver);
		actions.keyDown(Keys.CONTROL).click(webelement).keyUp(Keys.CONTROL).build().perform();
	}

	public void actionsTargetSendKeys(WebElement element, String value, long durationInSeconds) {

		WebElement webelement = waitForVisibilityOfElement(element, durationInSeconds);
		Actions actions = new Actions(ldriver);
		actions.sendKeys(webelement, value).build().perform();
	}

	public void alertAccept(long durationInSeconds) {

		Alert alert = waitForAlert(durationInSeconds);
		alert.accept();

	}

	public void alertDismiss(long durationInSeconds) {

		Alert alert = waitForAlert(durationInSeconds);
		alert.dismiss();

	}

	public String alertGetText(long durationInSeconds) {

		Alert alert = waitForAlert(durationInSeconds);
		return alert.getText();
	}

	public void alertSendKeys(String value, long durationInSeconds) {

		Alert alert = waitForAlert(durationInSeconds);
		alert.sendKeys(value);
	}

	public void switchToFrameByIndex(int index, long durationInSeconds) {

		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(durationInSeconds));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
	}

	public void switchToFrameById(String id_name, long durationInSeconds) {

		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(durationInSeconds));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(id_name));
	}

	public void switchToFrameByWebElement(WebElement element, long durationInSeconds) {

		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(durationInSeconds));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	}

	public void switchToDefaultFrame() {

		ldriver.switchTo().defaultContent();
	}

	public void switchWindowByTitle(String windowTitle, int count) {

		Set<String> windowList = ldriver.getWindowHandles();

		String[] array = windowList.toArray(new String[0]);

		ldriver.switchTo().window(array[count - 1]);
	}

	public void switchToNewWindow() {

		Set<String> s = ldriver.getWindowHandles();
		Object popup[] = s.toArray();
		ldriver.switchTo().window(popup[1].toString());
	}

	public void switchToOldWindow() {

		Set<String> s = ldriver.getWindowHandles();
		Object popup[] = s.toArray();
		ldriver.switchTo().window(popup[0].toString());
	}

	public int getColumncount(WebElement table) {

		List<WebElement> columns = table.findElements(By.tagName("td"));
		int a = columns.size();
		return a;
	}

	public int getRowCount(WebElement table) {

		List<WebElement> rows = table.findElements(By.tagName("tr"));
		int a = rows.size() - 1;
		return a;
	}

	public boolean isAlertPresent() {
		try {
			ldriver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException Ex) {
			return false;
		}
	}

	public String getTitle() {

		return (ldriver.getTitle());
	}

	public String getCurrentURL() {

		return (ldriver.getCurrentUrl());
	}

	public void fluentWait(WebElement element, int timeOut) {
		Wait<WebDriver> wait = null;
		try {
			wait = new FluentWait<WebDriver>((WebDriver) ldriver).withTimeout(Duration.ofSeconds(20))
					.pollingEvery(Duration.ofSeconds(2)).ignoring(Exception.class);
			wait.until(ExpectedConditions.visibilityOf(element));
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String screenShot(String filename) {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) ldriver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\ScreenShots\\" + filename + "_" + dateName + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		String newImageString = "http://localhost:8082/job/MyStoreProject/ws/MyStoreProject/ScreenShots/" + filename
				+ "_" + dateName + ".png";
		return newImageString;
	}

	public void attack(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String gramlinscript = "    javascript: (function() {\r\n" + "    function callback() {\r\n"
				+ "        gremlins.createHorde({\r\n"
				+ "            species: [gremlins.species.clicker(),gremlins.species.toucher(),gremlins.species.formFiller(),gremlins.species.scroller(),gremlins.species.typer()],\r\n"
				+ "            mogwais: [gremlins.mogwais.alert(),gremlins.mogwais.fps(),gremlins.mogwais.gizmo()],\r\n"
				+ "            strategies: [gremlins.strategies.distribution(),gremlins.strategies.allTogether(),gremlins.strategies.bySpecies()]\r\n"
				+ "        }).unleash();\r\n" + "    }\r\n" + "    var s = document.createElement(\"script\");\r\n"
				+ "    s.src = \"https://unpkg.com/gremlins.js\";\r\n" + "    if (s.addEventListener) {\r\n"
				+ "        s.addEventListener(\"load\", callback, false);\r\n" + "    } else if (s.readyState) {\r\n"
				+ "        s.onreadystatechange = callback;\r\n" + "    }\r\n" + "    document.body.appendChild(s);\r\n"
				+ "    })()";
		js.executeAsyncScript(gramlinscript);
	}

	public void drawBorder(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}

	public void generateAlert(WebDriver driver, String alertMessage) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('" + alertMessage + "')");

	}

	public void refreshBrowserByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("history.go(0)");
	}

	public void flash(WebElement element, WebDriver driver) {
		String backcolor = element.getCssValue("backgroundColor");

		for (int i = 0; i < 300; i++) {
			changeColor("#000000", element, driver);
			changeColor(backcolor, element, driver);
		}
	}

	public void changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);

		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
		}
	}

	public void scrollPgDown(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	public void ScrollVerticallyPgUp(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");

	}

	public void scrollIntoView(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public String getDomainByJavaScript(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String domain = js.executeScript("return document.domain;").toString();
		return domain;
	}

	public String getTitleByJavaScript(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String title = js.executeScript("return document.title;").toString();
		return title;
	}

	public String getURLByJavaScript(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String url = js.executeScript("return document.URL;").toString();
		return url;
	}

	public void clickElementByJavaScript(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);

	}

	public void typeElementByJavaScript(WebElement element, WebDriver driver, String textToBeTyped) {
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("arguments[0].value='" + textToBeTyped + "'", element);

	}

	public static void clickOnDynamicElement(List<WebElement> elements, String text) {

		for (WebElement element : elements) {

			if (element.getText().equals(text)) {
				element.click();
				break;
			}
		}
	}

	public static boolean isDisplayedDynamicElement(List<WebElement> elements, String text) {

		boolean flag = false;

		for (WebElement element : elements) {

			if (element.getText().equals(text)) {
				flag = true;
				break;
			}
		}
		return flag;
	}
}
