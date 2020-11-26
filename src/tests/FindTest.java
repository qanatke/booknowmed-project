package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.FindPage;
import pages.ResultsPage;

public class FindTest extends BasicTest {

	@Test(priority = 5, description = "Searching by dialysis type and city")
	public void FindByCity() throws Exception {
		
		FindPage findPage = new FindPage(this.driver, this.js, this.waiter);
		ResultsPage resultsPage = new ResultsPage(this.driver, this.js, this.waiter);
		SoftAssert softAssert = new SoftAssert();

		this.driver.get(baseUrl + "/dialysis");

		findPage.findNbookDialysis(hd, cityLocation);

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

	@Test(priority = 10, description = "Searching by dialysis type and country")
	public void FindByCountry() throws Exception {
		
		FindPage findPage = new FindPage(this.driver, this.js, this.waiter);
		ResultsPage resultsPage = new ResultsPage(this.driver, this.js, this.waiter);
		SoftAssert softAssert = new SoftAssert();

		this.driver.get(baseUrl + "/dialysis");

		findPage.findNbookDialysis(hdf, countryLocation);

		for (int i = 0; i < resultsPage.getDialysisType().size(); i++) {
			String expected = hdf;
			String actual = resultsPage.getDialysisType().get(i);
			softAssert.assertTrue(actual.contains(expected), "[ERROR] Wrong dialysis type");
		}

		softAssert.assertAll();
	}
}
