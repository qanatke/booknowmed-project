package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.BookForYourselfPage;
import pages.RegisterFirstPage;

public class RegistrationTest extends BasicTest {

	@Test(priority = 5, description = "Creating a profile for booking dialysis for yourself.")
	public void bookForYourselfTest() throws Exception {

		RegisterFirstPage register = new RegisterFirstPage(this.driver, this.js, this.waiter);
		BookForYourselfPage bookForYourself = new BookForYourselfPage(this.driver, this.js, this.waiter);

		this.driver.navigate().to(baseUrl + "/dialysis/register");
		Thread.sleep(1000);

		// data entry
		register.setRegistration(title, firstName, lastName, birthDate, mail, pass, countryCode, phoneNum, forMyself);
		bookForYourself.setInfoForYourself(false, true, "", homeClinicName, homeClinicCity, countryCode, clinicNum, false);
		
		waiter.until(ExpectedConditions.visibilityOf(register.getRegistrationValidation()));
		Assert.assertEquals(register.getRegistrationValidation().getText(), "Sucess");
	}

	@Test(priority = 0, description = "Creating a profile with taken email.")
	public void createWithTakenMail() throws Exception {

		RegisterFirstPage register = new RegisterFirstPage(this.driver, this.js, this.waiter);
		BookForYourselfPage bookForYourself = new BookForYourselfPage(this.driver, this.js, this.waiter);

		this.driver.navigate().to(baseUrl + "/dialysis/register");
		Thread.sleep(1000);

		// data entry
		register.setRegistration(title, firstName, lastName, birthDate, takenMail, pass, countryCode, phoneNum, forMyself);
		bookForYourself.setInfoForYourself(true, false, "", homeClinicName, homeClinicCity, countryCode, clinicNum, false);

		Assert.assertEquals(register.getEmailValidation().getText(), "The email has already been taken.");
	}

}
