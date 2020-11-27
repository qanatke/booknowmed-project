package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage {

	public LoginPage(WebDriver driver, JavascriptExecutor js, WebDriverWait waiter) {
		super(driver, js, waiter);
	}
	
	protected WebElement getEmailInput() {
		return this.driver.findElement(By.xpath("//input[@type='email']"));
	}
	
	protected WebElement getPassInput() {
		return this.driver.findElement(By.xpath("//input[@type='password']"));
	}

	protected WebElement getRememberMe() {
		return this.driver.findElement(By.xpath("//label/bnm-checkbox/input"));
	}
	
	protected WebElement getForgotPassword() {
		return this.driver.findElement(By.xpath("//form/div[3]/div[2]/a"));
	}
	
	protected WebElement getLoginButton() {
		return this.driver.findElement(By.xpath("//button[@type='submit']"));
	}
	
	public WebElement getVerificationMsg() {
		return this.driver.findElement(By.xpath("//form/div[4]"));
	}
	
	public void setLogin(String mail, String pass, boolean rememberMe) {
		getEmailInput().sendKeys(mail);
		getPassInput().sendKeys(pass);
		
		if (rememberMe == false) {
			js.executeScript("arguments[0].click()", getRememberMe());
		}
		
		getLoginButton().click();
	}
	
}
