package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyAgePage {
	public WebDriver driver;

	public VerifyAgePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "age-gate-d")
	WebElement date_box;
	@FindBy(id = "age-gate-m")
	WebElement month_box;
	@FindBy(id = "age-gate-y")
	WebElement year_box;
	@FindBy(name = "ag_settings[submit]")
	WebElement submit_button;

	public VerifyAgePage enterDate(String date) {
		date_box.sendKeys(date);
		return this;
	}

	public VerifyAgePage enterMonth(String month) {
		month_box.sendKeys(month);
		return this;
	}

	public VerifyAgePage enterYear(String year) {
		year_box.sendKeys(year);
		return this;
	}

	public HomeCanvasPage clickOnSubmitButton() {
		submit_button.click();
		return new HomeCanvasPage(driver);
	}

	public boolean verifyCanvasDisplayInHomePage() {
		return driver.findElement(By.xpath("//img[@class='fusion-standard-logo']")).isDisplayed();

	}

	public boolean verifyAgeInvalidError() {
		return driver.findElement(By.xpath("//h1[text()='YOU NEED TO BE 18+ TO PLAY OUR GAMES']")).isDisplayed();
	}

}
