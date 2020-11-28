package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderNavigationPage extends BasicPage {

	public HeaderNavigationPage(WebDriver driver, JavascriptExecutor js, WebDriverWait waiter) {
		super(driver, js, waiter);
	}

	protected WebElement getTreatment() {
		return this.driver.findElement(By.xpath("//bnm-custom-select/div[1]"));
	}

	protected WebElement getHD() {
		return this.driver.findElement(By.xpath("//bnm-custom-select/div[2]/div/div[2]/div[1]"));
	}

	protected WebElement getHDF() {
		return this.driver.findElement(By.xpath("//bnm-custom-select/div[2]/div/div[2]/div[2]"));
	}

	protected void setTreatment(String type) {
		getTreatment().click();

		switch (type) {
		case "Dialysis HD":
			this.js.executeScript("arguments[0].click()", getHD());
			break;
		case "Dialysis HDF":
			this.js.executeScript("arguments[0].click()", getHDF());
			break;
		}
	}

	protected WebElement getLocation() {
		return this.driver.findElement(By.xpath("//bnm-location-picker/div/input"));
	}

	protected void setLocation(String location) throws Exception {
		getLocation().sendKeys(location);
		Thread.sleep(1000);
		getLocation().sendKeys(Keys.ENTER);
	}

	protected WebElement getSearchButton() {
		return this.driver.findElement(By.xpath("//bnm-patient-search-bar/bnm-platform-search/div/div[3]/button[1]"));
	}

	public void searchForDialysis(String treatment, String location) throws Exception {
		setTreatment(treatment);
		setLocation(location);
		getSearchButton().click();
	}

	public WebElement getProfile() {
		return this.driver.findElement(By.xpath("//span[@class='display-name']"));
	}

	public String getPatientName() {
		return getProfile().getText();
	}

	protected WebElement getReservations() {
		return this.driver.findElement(By.xpath("//bnm-dropdown-item[1]/a"));
	}

	protected WebElement getAccount() {
		return this.driver.findElement(By.xpath("//bnm-dropdown-item[2]/a"));
	}

	protected WebElement getLogout() {
		return this.driver.findElement(By.xpath("//bnm-dropdown-item[3]/button"));
	}

	public void logout() {
		getProfile().click();
		getLogout().click();
	}

	public void account() {
		getProfile().click();
		getAccount().click();
	}

}
