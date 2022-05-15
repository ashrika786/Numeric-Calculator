package calculator.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;


public class BasicCalculatorHome extends BaseTest{
	String expTitle = "Basic Calculator";
	
	public BasicCalculatorHome() {
		super();
	}
	
	@Test(description = "Open Basic Calculator Page")
	public void OpenHomePage(){
		Assert.assertEquals(driver.getTitle(), expTitle);
	}
	
	@Test(description = "Select build for calculation")
	public void SelectBuild() throws InterruptedException {
		Assert.assertEquals(driver.getTitle(), expTitle);
		calculatePage.scrollIntoView();
		calculatePage.selectBuild(prop.getProperty("build"));
	}
	
	  

}
