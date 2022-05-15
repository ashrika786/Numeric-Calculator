package calculator.TestCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import calculator.utils.ExcelUtility;
import calculator.utils.InputCheck;


public class Concatenate extends BaseTest{
	
	InputCheck input = new InputCheck();
	public Concatenate() {
		super();
	}
	
	@Test(description = "Concatenate 2 Values",dataProviderClass=ExcelUtility.class,dataProvider="testdata")
	public void ConcatenateTwoValues(String val1,String val2) throws IOException, InterruptedException{
		System.out.println("Concatenation of "+val1+" & "+val2);
		calculatePage.scrollIntoView();
		calculatePage.selectBuild(prop.getProperty("build"));
		calculatePage.performOperation(val1,val2,"Concatenate");
        String actualResult = val1+val2;
        String displayedResult = calculatePage.getResult();
        Assert.assertTrue(actualResult.equals(displayedResult));
	} 
}
