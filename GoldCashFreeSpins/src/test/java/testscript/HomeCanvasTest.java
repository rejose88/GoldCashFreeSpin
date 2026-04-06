package testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import core.GameLaunch;
import pages.HomeCanvasPage;
import pages.VerifyAgePage;
import utilities.ExcelUtility;

public class HomeCanvasTest extends GameLaunch {
	HomeCanvasPage homecanvaspage;

	@Test(description = "Validating whether user is able to click on Canvas", groups = { "smoke" })
	public void verifyCanvasClick() throws IOException, InterruptedException {
		int date = ExcelUtility.getIntegerData(0, 0, "Age");
		int month = ExcelUtility.getIntegerData(0, 1, "Age");
		int year = ExcelUtility.getIntegerData(0, 2, "Age");
		VerifyAgePage verifyage = new VerifyAgePage(driver);
		verifyage.enterDate(String.valueOf(date)).enterMonth(String.valueOf(month)).enterYear(String.valueOf(year));
		homecanvaspage = verifyage.clickOnSubmitButton();
		homecanvaspage.clickOnCanvas();
	}

}
