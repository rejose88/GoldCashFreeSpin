package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PageUtility {

	public void doubleClick(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).build().perform();
	}

	public void rightClick(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).build().perform();
	}

	public void javaScriptClick(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.click(element).build().perform();
	}

	public void javaScriptMoveToElement(WebDriver driver, int x, int y) {
		Actions actions = new Actions(driver);
		actions.scrollByAmount(x, y).build().perform();
	}

	public void javaScriptScrollBy(WebDriver driver, int x, int y) {
		Actions actions = new Actions(driver);
		actions.scrollByAmount(x, y).build().perform();
	}

	public void javaScriptScrollToTop(WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.scrollToElement(null).build().perform();
	}

	public void javaScriptScrollToBottom(WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.scrollToElement(null).build().perform();
	}
}
