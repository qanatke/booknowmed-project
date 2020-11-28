package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindPage extends BasicPage {

	public FindPage(WebDriver driver, JavascriptExecutor js, WebDriverWait waiter) {
		super(driver, js, waiter);
	}

	protected WebElement getTreatment() {
		return this.driver.findElement(By.xpath("//section/div/bnm-platform-search/div/bnm-custom-select/div[1]"));
	}

	protected WebElement getHD() {
		return this.driver.findElement(
				By.xpath("//section/div/bnm-platform-search/div/bnm-custom-select/div[2]/div/div[2]/div[1]"));
	}

	protected WebElement getHDF() {
		return this.driver.findElement(
				By.xpath("//section/div/bnm-platform-search/div/bnm-custom-select/div[2]/div/div[2]/div[2]"));
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
		return this.driver
				.findElement(By.xpath("//section/div/bnm-platform-search/div/div[1]/bnm-location-picker/div/input"));
	}

	protected void setLocation(String location) throws Exception {
		getLocation().sendKeys(location);
		Thread.sleep(1000);
		getLocation().sendKeys(Keys.ENTER);
	}

	protected WebElement getButton() {
		return this.driver.findElement(By.xpath("//section/div/bnm-platform-search/div/div[3]/button[1]"));
	}

	public void findNbookDialysis(String treatment, String location) throws Exception {
		setTreatment(treatment);
		setLocation(location);
		getButton().click();
	}

	public WebElement getLoginButton() {
		return this.driver.findElement(By.xpath(
				"//section/bnm-header/bnm-header-public/bnm-header-base/div[2]/bnm-header-navigation/nav/ul/li[4]/a"));
	}
}
