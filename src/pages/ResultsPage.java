package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultsPage extends BasicPage {

	public ResultsPage(WebDriver driver, JavascriptExecutor js, WebDriverWait waiter) {
		super(driver, js, waiter);
	}

	protected List<WebElement> getSearchResults() {
		return this.driver.findElements(By.xpath("//bnm-search-result-card/bnm-paper/div[2]/div[1]/span"));
	}

	public List<String> getDialysisType() {
		List<String> dialysisFound = new ArrayList<>();
		for (int i = 0; i < getSearchResults().size(); i++) {
			dialysisFound.add(getSearchResults().get(i).getText());
		}
		return dialysisFound;
	}

	protected List<WebElement> getAddressResults() {
		return this.driver.findElements(By.xpath("//bnm-search-result-card/bnm-paper/div[1]/div/div[1]/dl/div[1]/dd"));
	}

	public List<String> getDialysisAddress() {
		List<String> addressFound = new ArrayList<>();
		for (int i = 0; i < getAddressResults().size(); i++) {
			addressFound.add(getAddressResults().get(i).getText());
		}
		return addressFound;
	}

}
