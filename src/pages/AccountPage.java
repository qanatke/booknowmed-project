package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage extends BasicPage {

	public AccountPage(WebDriver driver, JavascriptExecutor js, WebDriverWait waiter) {
		super(driver, js, waiter);
	}

	public WebElement getTitle() {
		return this.driver.findElement(By.xpath("//bnm-select/select"));
	}

	public WebElement getFirstNameInput() {
		return this.driver.findElement(By.xpath("//input[@name='firstName']"));
	}

	public WebElement getLastNameInput() {
		return this.driver.findElement(By.xpath("//input[@name='lastName']"));
	}

	public WebElement getCountryCodeInput() {
		return this.driver.findElement(By.xpath("//bnm-country-code-input/bnm-padded-input/input"));
	}

	public WebElement getPhoneInput() {
		return this.driver.findElement(By.xpath("//input[@name='phoneNumber']"));
	}

	public WebElement getSaveButton() {
		return this.driver.findElement(By.xpath("//form/button"));
	}

	protected WebElement getCurrentPasswordInput() {
		return this.driver.findElement(By.xpath("//form[2]/div[1]/label/bnm-password/bnm-padded-input/input"));
	}

	protected WebElement getNewPasswordInput() {
		return this.driver.findElement(By.xpath("//form[2]/div[2]/label/bnm-password/bnm-padded-input/input"));
	}

	protected WebElement getChangeButton() {
		return this.driver.findElement(By.xpath("//form[2]/button"));
	}

	public void setNewPassword(String oldPass, String newPass) {
		getCurrentPasswordInput().sendKeys(oldPass);
		getNewPasswordInput().sendKeys(newPass);
		getChangeButton().click();
	}
}
