package tests;

import org.testng.annotations.Test;

import pages.BookForYourselfPage;
import pages.RegisterFirstPage;

public class RegistrationTest extends BasicTest {
	
	@Test(priority = 5, description = "Creating a profile for booking dialysis for yourself")
	public void bookForYourselfTest() throws Exception {
		
		RegisterFirstPage register = new RegisterFirstPage(this.driver, this.js, this.waiter);
		BookForYourselfPage bookForYourself = new BookForYourselfPage(this.driver, this.js, this.waiter);
		
		this.driver.navigate().to(baseUrl + "/dialysis/register");
		Thread.sleep(1000);
		
		register.setRegistration(title, firstName, lastName, birthDate, mail, pass, countryCode, phoneNum, forMyself);
		
		bookForYourself.setInfoForYourself(false, false, homeClinicName, homeClinicCity, countryCode, clinicNum, false);
	}
	
}
