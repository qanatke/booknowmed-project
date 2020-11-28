package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.FindPage;
import pages.HeaderNavigationPage;
import pages.LoginPage;
import pages.ResultsPage;

public class FindTest extends BasicTest {

	@Test(priority = 5, description = "Searching by dialysis type and city without login")
	public void FindByCity() throws Exception {

		FindPage homePage = new FindPage(this.driver, this.js, this.waiter);
		ResultsPage resultsPage = new ResultsPage(this.driver, this.js, this.waiter);
		SoftAssert softAssert = new SoftAssert();

		this.driver.get(baseUrl + "/dialysis");

		homePage.findNbookDialysis(hd, cityLocation);
		
		// assertion possible because addresses contain city names
		for (int i = 0; i < resultsPage.getDialysisAddress().size(); i++) {
			String expected = cityLocation;
			String actual = resultsPage.getDialysisAddress().get(i).toLowerCase();
			softAssert.assertTrue(actual.contains(expected), "[ERROR] Wrong city address");
		}

		for (int i = 0; i < resultsPage.getDialysisType().size(); i++) {
			String expected = hd;
			String actual = resultsPage.getDialysisType().get(i);
			softAssert.assertTrue(actual.contains(expected), "[ERROR] Wrong dialysis type");
		}

		softAssert.assertAll();
	}

	@Test(priority = 10, description = "Searching by dialysis type and country without login")
	public void FindByCountry() throws Exception {

		FindPage homePage = new FindPage(this.driver, this.js, this.waiter);
		ResultsPage resultsPage = new ResultsPage(this.driver, this.js, this.waiter);
		SoftAssert softAssert = new SoftAssert();

		this.driver.get(baseUrl + "/dialysis");

		homePage.findNbookDialysis(hdf, countryLocation);

		for (int i = 0; i < resultsPage.getDialysisType().size(); i++) {
			String expected = hdf;
			String actual = resultsPage.getDialysisType().get(i);
			softAssert.assertTrue(actual.contains(expected), "[ERROR] Wrong dialysis type");
		}

		softAssert.assertAll();
	}

	@Test(priority = 15, description = "Searching for dialysis with login")
	public void searchFromYourProfile() throws Exception {

		LoginPage loginPage = new LoginPage(this.driver, this.js, this.waiter);
		HeaderNavigationPage headerPage = new HeaderNavigationPage(this.driver, this.js, this.waiter);
		ResultsPage resultsPage = new ResultsPage(this.driver, this.js, this.waiter);
		FindPage homePage = new FindPage(this.driver, this.js, this.waiter);
		SoftAssert softAssert = new SoftAssert();

		this.driver.navigate().to(baseUrl + "/dialysis/login");

		loginPage.setLogin(mail, pass, false);
		Thread.sleep(1500);
		softAssert.assertEquals(headerPage.getPatientName(), firstName + " " + lastName);

		headerPage.searchForDialysis(hd, cityLocation);

		for (int i = 0; i < resultsPage.getDialysisAddress().size(); i++) {
			String expected = cityLocation;
			String actual = resultsPage.getDialysisAddress().get(i).toLowerCase();
			softAssert.assertTrue(actual.contains(expected), "[ERROR] Wrong city address");
		}

		for (int i = 0; i < resultsPage.getDialysisType().size(); i++) {
			String expected = hd;
			String actual = resultsPage.getDialysisType().get(i);
			softAssert.assertTrue(actual.contains(expected), "[ERROR] Wrong dialysis type");
		}

		headerPage.logout();
		softAssert.assertEquals(homePage.getLoginButton().getText(), "Log in");

		softAssert.assertAll();
	}
}
