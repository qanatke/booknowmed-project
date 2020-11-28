package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterFirstPage extends BasicPage {

	public RegisterFirstPage(WebDriver driver, JavascriptExecutor js, WebDriverWait waiter) {
		super(driver, js, waiter);
	}

	protected WebElement getTitle() {
		return this.driver.findElement(By.xpath("//bnm-select/select"));
	}

	protected WebElement getFirstNameInput() {
		return this.driver.findElement(By.xpath("//div[1]/label/input"));
	}

	protected WebElement getLastNameInput() {
		return this.driver.findElement(By.xpath("//div[2]/label/input"));
	}

	protected WebElement getBirthDateInput() {
		return this.driver.findElement(By.xpath("//div[3]/label/input"));
	}

	protected WebElement getEmailInput() {
		return this.driver.findElement(By.xpath("//div[4]/label/input"));
	}

	public WebElement getEmailValidation() {
		return this.driver.findElement(By.xpath("//bnm-account-info/div/div[4]/div/bnm-validation"));
	}

	protected WebElement getPasswordInput() {
		return this.driver.findElement(By.xpath("//bnm-password/bnm-padded-input/input"));
	}

	protected WebElement getCountryCodeInput() {
		return this.driver.findElement(By.xpath("//bnm-country-code-input/bnm-padded-input/input"));
	}

	protected WebElement getPhoneNumberInput() {
		return this.driver.findElement(By.xpath("//div[6]/div[2]/label/input"));
	}

	protected List<WebElement> getForWhom() {
		return this.driver.findElements(By.xpath("//div/label/bnm-radio"));
	}

	protected WebElement getNextButton() {
		return this.driver.findElement(By.xpath("//form/div/button"));
	}

	public void setRegistration(String title, String firstName, String lastName, String birthDate, String mail,
			String pass, String countryCode, String phoneNum, String forWhom) throws Exception {
		Select select = new Select(getTitle());
		select.selectByValue(title.toLowerCase());

		getFirstNameInput().sendKeys(firstName);
		getLastNameInput().sendKeys(lastName);
		getBirthDateInput().sendKeys(birthDate);
		getEmailInput().sendKeys(mail);
		getPasswordInput().sendKeys(pass);
		getCountryCodeInput().sendKeys(countryCode);
		getPhoneNumberInput().sendKeys(phoneNum);

		switch (forWhom.toLowerCase()) {
		case "myself":
			getForWhom().get(0).click();
			break;
		case "someone else":
			getForWhom().get(1).click();
			break;
		case "both":
			getForWhom().get(2).click();
			break;
		}

		js.executeScript("arguments[0].click()", getNextButton());
	}

	public WebElement getRegistrationValidation() {
		return this.driver.findElement(By.xpath("//bnm-registration-success/bnm-paper/h1"));
	}

}
