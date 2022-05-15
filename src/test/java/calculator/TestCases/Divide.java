package calculator.TestCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import calculator.utils.ExcelUtility;
import calculator.utils.InputCheck;


public class Divide extends BaseTest{
	
	InputCheck input = new InputCheck();
	public Divide() {
		super();
	}
	
	@Test(description = "Divide 2 Values",dataProviderClass=ExcelUtility.class,dataProvider="testdata")
	public void DivideTwoNumber(String val1,String val2) throws IOException, InterruptedException{
		int caseValue = input.returnCaseDivide(val1, val2);
		System.out.println("Division of "+val1+" & "+val2);
		driver.get(prop.getProperty("url"));
		calculatePage.scrollIntoView();
		calculatePage.selectBuild(prop.getProperty("build"));
		calculatePage.performOperation(val1,val2,"Divide");
		switch(caseValue){
        case 1:
        	Assert.assertTrue((calculatePage.getErrorMessage().equals("Number 1 is not a number")));
            break;
        case 2: 
            Assert.assertTrue((calculatePage.getErrorMessage().equals("Number 2 is not a number")));
            break;
        case 3:  
        	Assert.assertTrue((calculatePage.getErrorMessage().equals("Divide by zero error!")));
            break;
        default:
        	Double actualResult;
        	if(val1==null || val1 == "") {
        		actualResult = 0/Double.parseDouble(val2);
        	}
        	else {
        		actualResult = Double.parseDouble(val1)/Double.parseDouble(val2);	
        	}
        	 Double displayedResult = Double.parseDouble(calculatePage.getResult());
             Assert.assertTrue(Double.compare(actualResult,displayedResult)==0);
            break;
		}
	} 
	
	@Test(description = "Divide 2 Values and return only integer value",dataProviderClass=ExcelUtility.class,dataProvider="testdata")
	public void DivideIntegerOnly(String val1,String val2) throws IOException, InterruptedException{
		int caseValue = input.returnCaseDivide(val1, val2);
		System.out.println("Division of "+val1+" & "+val2);
		calculatePage.scrollIntoView();
		calculatePage.selectBuild(prop.getProperty("build"));
		calculatePage.performOperationInteger(val1,val2,"Divide");
		switch(caseValue){
        case 1:
        	Assert.assertTrue((calculatePage.getErrorMessage().equals("Number 1 is not a number")));
            break;
        case 2: 
            Assert.assertTrue((calculatePage.getErrorMessage().equals("Number 2 is not a number")));
            break;
        case 3:  
        	Assert.assertTrue((calculatePage.getErrorMessage().equals("Divide by zero error!")));
        	driver.get(prop.getProperty("url"));
        	break;
        default:
        	int  actualResult;
        	if(val1==null || val1 == "") {
        		actualResult = (int)(0/Double.parseDouble(val2));
        	}
        	else {
        		actualResult = (int)(Double.parseDouble(val1)/Double.parseDouble(val2));	
        	}
        	int displayedResult = Integer.parseInt(calculatePage.getResult());
             Assert.assertTrue(actualResult==displayedResult);
            break;
		}
	} 
}
