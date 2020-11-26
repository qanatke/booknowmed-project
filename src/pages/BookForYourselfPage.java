package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookForYourselfPage extends BasicPage {

	public BookForYourselfPage(WebDriver driver, JavascriptExecutor js, WebDriverWait waiter) {
		super(driver, js, waiter);
	}

	protected List<WebElement> getRadioButtons() {
		return this.driver.findElements(By.xpath("//div/label/bnm-radio"));
	}

	protected WebElement getHomeClinicNameInput() {
		return this.driver.findElement(By.xpath("//bnm-booking-yourself/div/div[4]/div[1]/label/input"));
	}

	protected WebElement getHomeClinicCityInput() {
		return this.driver.findElement(By.xpath("//bnm-booking-yourself/div/div[4]/div[2]/label/input"));
	}

	protected WebElement getCountryCodeInput() {
		return this.driver.findElement(By.xpath(
				"//bnm-booking-yourself/div/div[4]/div[3]/div[1]/label/bnm-country-code-input/bnm-padded-input/input"));
	}

	protected WebElement getClinicPhoneInput() {
		return this.driver.findElement(By.xpath("//bnm-booking-yourself/div/div[4]/div[3]/div[2]/label/input"));
	}

	protected WebElement getToMailingList() {
		return this.driver.findElement(By.xpath("//bnm-booking-yourself/div/div[5]/label/bnm-checkbox"));
	}

	protected WebElement getTerms() {
		return this.driver.findElement(By.xpath("//bnm-booking-yourself/div/div[6]/label/bnm-checkbox"));
	}

	protected WebElement getRegisterButton() {
		return this.driver.findElement(By.xpath("//button[2]"));
	}

	public void setInfoForYourself(boolean ehic, boolean specRequirements, String homeClinicName, String homeClinicCity,
			String countryCode, String clinicNum, boolean mailingList) {
		if (ehic) {
			getRadioButtons().get(3).click();
		} else {
			getRadioButtons().get(4).click();
		}

		if (specRequirements) {
			getRadioButtons().get(5).click();
		} else {
			getRadioButtons().get(6).click();
		}

		getHomeClinicNameInput().sendKeys(homeClinicName);
		getHomeClinicCityInput().sendKeys(homeClinicCity);
		getCountryCodeInput().sendKeys(countryCode);
		getClinicPhoneInput().sendKeys(clinicNum);

		if (mailingList == false) {
			getToMailingList().click();
		}

		getTerms().click();

		js.executeScript("arguments[0].click()", getRegisterButton());

	}

}
