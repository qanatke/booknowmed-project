package tests;

import org.testng.annotations.Test;

import pages.FindPage;

public class FindTest extends BasicTest {
	
	@Test
	public void FindAndBookTest() throws Exception {
		FindPage findPage = new FindPage(this.driver, this.js, this.waiter);
		
		this.driver.get(baseUrl + "/dialysis");
		
		
		//findPage.getTreatment().click();
		//this.js.executeScript("arguments[0].click()", findPage.getHDF());
		//findPage.getHDF().click();
		
		//findPage.getTreatment().click();
		findPage.setTreatment(hd);
		
		
	}

}
