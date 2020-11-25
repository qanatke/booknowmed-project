package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindPage extends BasicPage {

	public FindPage(WebDriver driver, JavascriptExecutor js, WebDriverWait waiter) {
		super(driver, js, waiter);
	}

	public WebElement getTreatment() {
		return this.driver.findElement(By.xpath(
				//"/html/body/app-root/ng-component/section[1]/div/bnm-platform-search/div/bnm-custom-select/div[1]"
				"//section/div/bnm-platform-search/div/bnm-custom-select/div[1]"
				));
	}

	protected WebElement getHD() {
		//return this.driver.findElement(By.xpath("//div[@class='items']/div[1]"));
		return this.driver.findElement(By.xpath(
				"//section/div/bnm-platform-search/div/bnm-custom-select/div[2]/div/div[2]/div[1]"));
	}

	protected WebElement getHDF() {
		//return this.driver.findElement(By.xpath("//div[@class='items']/div[2]"));
		return this.driver.findElement(By.xpath(
				"//section/div/bnm-platform-search/div/bnm-custom-select/div[2]/div/div[2]/div[2]"));
	}

	public void setTreatment(String type) throws Exception {
		getTreatment().click();
		
//		WebElement list = this.driver.findElement(By.xpath("//section/div/bnm-platform-search/div/bnm-custom-select/div[2]"));
//		waiter.until(ExpectedConditions.visibilityOf(list));
		
		
		switch (type) {
		case "Dialysis HD":
			this.js.executeScript("arguments[0].click()", getHD());
			//getHD().click();
			break;
		case "Dialysis HDF":
			this.js.executeScript("arguments[0].click()", getHDF());
			//getHDF().click();
			break;

		}
	}
}
