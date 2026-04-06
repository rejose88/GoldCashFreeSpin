package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeCanvasPage {
	public WebDriver driver;
	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public HomeCanvasPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='ingg-canvas-div']")
	WebElement canvas;

	public HomeCanvasPage clickOnCanvas() throws InterruptedException {

//		Actions actions = new Actions(driver);
//		actions.moveToElement(canvas, 50, 50).click().perform();
//		actions.doubleClick(canvas).build().perform();
		//wait.until(ExpectedConditions.elementToBeClickable(canvas));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("var c=document.getElementsByTagName('canvas')[0];" + "if(c){"
				+ " var rect=c.getBoundingClientRect();" + " var x=rect.left+rect.width/2;"
				+ " var y=rect.top+rect.height-100;" + " var evt=new MouseEvent('click',{clientX:x,clientY:y});"
				+ " c.dispatchEvent(evt);" + "} else { console.log('Canvas not found'); }");

		//Thread.sleep(8000);

		return this;

	}

}
