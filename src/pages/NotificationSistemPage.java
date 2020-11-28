package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationSistemPage extends BasicPage {

	public NotificationSistemPage(WebDriver driver, JavascriptExecutor js, WebDriverWait waiter) {
		super(driver, js, waiter);
	}

	protected WebElement getNotificationBar() {
		return this.driver.findElement(By.xpath("//ng-component/div/p"));
	}

	public String getNotificationMessage() {
		return getNotificationBar().getText();
	}

	public void notificationDisappear() {
		this.waiter.until(ExpectedConditions.invisibilityOf(getNotificationBar()));
	}

}