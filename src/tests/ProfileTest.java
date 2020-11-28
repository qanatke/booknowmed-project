package tests;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.AccountPage;
import pages.FindPage;
import pages.HeaderNavigationPage;
import pages.LoginPage;
import pages.NotificationSistemPage;

public class ProfileTest extends BasicTest {

	@Test(description = "Contact info and password change test")
	public void accountSettingsTest() throws Exception {

		LoginPage loginpage = new LoginPage(this.driver, this.js, this.waiter);
		HeaderNavigationPage headerPage = new HeaderNavigationPage(this.driver, this.js, this.waiter);
		AccountPage accountPage = new AccountPage(this.driver, this.js, this.waiter);
		NotificationSistemPage notification = new NotificationSistemPage(this.driver, this.js, this.waiter);
		FindPage homePage = new FindPage(this.driver, this.js, this.waiter);
		SoftAssert softAssert = new SoftAssert();

		this.driver.navigate().to(baseUrl + "/dialysis/login");

		loginpage.setLogin(mail, pass, false);

		Thread.sleep(1500);
		// this.driver.navigate().to(baseUrl + "/profile/profile-and-account/account");
		headerPage.account();

		accountPage.getPhoneInput().sendKeys(Keys.chord(Keys.CONTROL + "a"));
		accountPage.getPhoneInput().sendKeys(phoneNum);
		accountPage.getSaveButton().click();

		softAssert.assertEquals(notification.getNotificationMessage(), "Contact info successfully updated.");
		notification.notificationDisappear();

		accountPage.setNewPassword(pass, pass);

		softAssert.assertEquals(notification.getNotificationMessage(), "Password successfully changed.");
		notification.notificationDisappear();

		headerPage.logout();
		softAssert.assertEquals(homePage.getLoginButton().getText(), "Log in");

		softAssert.assertAll();
	}

}