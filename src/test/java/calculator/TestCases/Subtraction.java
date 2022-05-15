package calculator.TestCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import calculator.utils.ExcelUtility;
import calculator.utils.InputCheck;


public class Subtraction extends BaseTest{
	
	InputCheck input = new InputCheck();
	public Subtraction() {
		super();
	}
	
	@Test(description = "Subtract 2 Values",dataProviderClass=ExcelUtility.class,dataProvider="testdata")
	public void SubtractionTwoNumber(String val1,String val2) throws IOException, InterruptedException{
		int caseValue = input.returnCase(val1, val2);
		System.out.println("Difference of "+val1+" & "+val2);
		calculatePage.scrollIntoView();
		calculatePage.selectBuild(prop.getProperty("build"));
		calculatePage.performOperation(val1,val2,"Subtract");
		switch(caseValue){
		case 1:
        	Assert.assertTrue((calculatePage.getErrorMessage().equals("Number 1 is not a number")));
            break;
        case 2: 
            Assert.assertTrue((calculatePage.getErrorMessage().equals("Number 2 is not a number")));
            break;
        default:
        	Double actualResult;
        	if(val1==null || val1 == "") {
        		actualResult = 0-Double.parseDouble(val2);
        	}
        	else if(val2==null || val2 == "") {
        		actualResult = Double.parseDouble(val1)-0;
        	}
        	else {
        		actualResult = Double.parseDouble(val1)-Double.parseDouble(val2);	
        	}
        	 Double displayedResult = Double.parseDouble(calculatePage.getResult());
             Assert.assertTrue(Double.compare(actualResult,displayedResult)==0);
            break;
		}
	} 
	
	@Test(description = "Subtract 2 Values and return only integer value",dataProviderClass=ExcelUtility.class,dataProvider="testdata")
	public void SubtractionIntegerOnly(String val1,String val2) throws IOException, InterruptedException{
		int caseValue = input.returnCase(val1, val2);
		System.out.println("Integer Difference of "+val1+" & "+val2);
		calculatePage.scrollIntoView();
		calculatePage.selectBuild(prop.getProperty("build"));
		calculatePage.performOperationInteger(val1,val2,"Subtract");
		switch(caseValue){
		case 1:
        	Assert.assertTrue((calculatePage.getErrorMessage().equals("Number 1 is not a number")));
            break;
        case 2: 
            Assert.assertTrue((calculatePage.getErrorMessage().equals("Number 2 is not a number")));
            break;
        default:
        	int  actualResult;
        	if(val1==null || val1 == "") {
        		actualResult = (int)(0-Double.parseDouble(val2));
        	}
        	else if(val2==null || val2 == "") {
        		actualResult = (int)(Double.parseDouble(val1)-0);
        	}
        	else {
        		actualResult = (int)(Double.parseDouble(val1)-Double.parseDouble(val2));	
        	}
        	int displayedResult = Integer.parseInt(calculatePage.getResult());
             Assert.assertTrue(actualResult==displayedResult);
            break;
		}
	} 
}
