package calculator.TestCases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import calculator.baseManager.DriverManager;
import calculator.pages.BasicCalculatorPage;
import calculator.utils.TestUtil;

public class BaseTest extends DriverManager{
	
	TestUtil util;
	BasicCalculatorPage calculatePage;

	String screenshotPath;
	
	@BeforeClass
	public void setUp() {
		DriverInitialization();	
		calculatePage = new BasicCalculatorPage(driver);
		util = new TestUtil();		
	}
	
	@AfterClass
	public void tearDown() throws IOException {
		driver.close();
	}
	
}
