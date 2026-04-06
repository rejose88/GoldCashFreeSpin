package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import core.GameLaunch;
import pages.HomeCanvasPage;
import pages.VerifyAgePage;
import utilities.ExcelUtility;

public class VerifyAgeTest extends GameLaunch {
	HomeCanvasPage homecanvaspage;

	@Test(description = "Validating whether user is able to login with valid age", groups = { "smoke" },retryAnalyzer = retry.RetryMechanism.class)
	public void verifyAgewithValidAge() throws IOException {
		int date = ExcelUtility.getIntegerData(0, 0, "Age");
		int month = ExcelUtility.getIntegerData(0, 1, "Age");
		int year = ExcelUtility.getIntegerData(0, 2, "Age");
		VerifyAgePage verifyage = new VerifyAgePage(driver);
		verifyage.enterDate(String.valueOf(date)).enterMonth(String.valueOf(month)).enterYear(String.valueOf(year));
		homecanvaspage = verifyage.clickOnSubmitButton();
		boolean canvas_display = verifyage.verifyCanvasDisplayInHomePage();
		Assert.assertTrue(canvas_display, Constant.VALIDCREDENTIALERROR);
	}

	@Test(description = "Validating whether user log in failed for invalid age", groups = { "smoke" })
	public void verifyAgeWithInvalidAge() throws IOException {
		int date = ExcelUtility.getIntegerData(1, 0, "Age");
		int month = ExcelUtility.getIntegerData(1, 1, "Age");
		int year = ExcelUtility.getIntegerData(1, 2, "Age");
		VerifyAgePage verifyage = new VerifyAgePage(driver);
		verifyage.enterDate(String.valueOf(date)).enterMonth(String.valueOf(month)).enterYear(String.valueOf(year));
		homecanvaspage = verifyage.clickOnSubmitButton();
		boolean age_validation_display = verifyage.verifyAgeInvalidError();
		Assert.assertTrue(age_validation_display, Constant.INVALIDAGEERROR);
	}

}
