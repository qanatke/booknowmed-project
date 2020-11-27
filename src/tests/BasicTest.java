package tests;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class BasicTest {

	protected WebDriver driver;
	protected WebDriverWait waiter;
	protected JavascriptExecutor js;

	protected String baseUrl = "https://bnm.neopixdev.com";
	protected String hd = "Dialysis HD";
	protected String hdf = "Dialysis HDF";
	protected String cityLocation = "valencia";
	protected String countryLocation = "morocco";
	
	protected String title = "Mr";
	protected String firstName = "John";
	protected String lastName = "Doe";
	protected String birthDate = "12/03/2012";
	protected String mail = "riseh55082@58as.com";
	protected String takenMail = "natkebatke@gmail.com";
	protected String pass = "abcd1234";
	protected String countryCode = "381";
	protected String phoneNum = "123456789";
	protected String forMyself = "Myself";
	protected String forSOelse = "Someone else";
	protected String forBoth = "Both";
	
	protected String homeClinicName = "Radon";
	protected String homeClinicCity = "Niska Banja";
	protected String clinicNum = "987654321";

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();

		this.waiter = new WebDriverWait(driver, 10);
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.js = (JavascriptExecutor) this.driver;
	}

	@AfterMethod
	public void afterTest(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			File ss = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE);
			String fileName = new SimpleDateFormat("yyyyMMddHHmmss'.png'").format(new Date());
			File save = new File("screenshots/" + fileName);
			FileHandler.copy(ss, save);
		}
	}

//	@AfterClass
//	public void afterClass() {
//		this.driver.quit();
//	}

}
