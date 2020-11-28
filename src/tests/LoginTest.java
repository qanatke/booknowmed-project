package tests;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.FindPage;
import pages.HeaderNavigationPage;
import pages.LoginPage;

public class LoginTest extends BasicTest {

	@Test(description = "Testing login to the accounts of registrated users from the database.")
	public void loginTest() throws Exception {

		LoginPage loginPage = new LoginPage(this.driver, this.js, this.waiter);
		HeaderNavigationPage headerPage = new HeaderNavigationPage(this.driver, this.js, this.waiter);
		FindPage homePage = new FindPage(this.driver, this.js, this.waiter);
		SoftAssert softAssert = new SoftAssert();

		File loginData = new File("data/data.xlsx");
		FileInputStream fis = new FileInputStream(loginData);

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Login Data");

		for (int i = 1; i <= sheet.getLastRowNum(); i++) {

			this.driver.navigate().to(baseUrl + "/dialysis/login");

			String mail = sheet.getRow(i).getCell(1).getStringCellValue();
			String pass = sheet.getRow(i).getCell(2).getStringCellValue();
			boolean mailVerification = sheet.getRow(i).getCell(3).getBooleanCellValue();

			Thread.sleep(1000);

			loginPage.setLogin(mail, pass, false);

			if (mailVerification) {
				Thread.sleep(2000);

				String expectedName = sheet.getRow(i).getCell(0).getStringCellValue();
				String displayName = headerPage.getPatientName();

				softAssert.assertEquals(displayName, expectedName);

				headerPage.logout();

				softAssert.assertEquals(homePage.getLoginButton().getText(), "Log in");
			} else {
				String actualString = loginPage.getVerificationMsg().getText();
				softAssert.assertTrue(
						actualString.contains("You are trying to log in with an email that hasn't been verified."));
			}

			softAssert.assertAll();

		}

		wb.close();
		fis.close();
	}

}
