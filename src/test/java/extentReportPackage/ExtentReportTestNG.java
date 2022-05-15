package extentReportPackage;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import calculator.TestCases.BaseTest;
import calculator.utils.TestUtil;

public class ExtentReportTestNG implements ITestListener {
	ExtentReports extent;
	ExtentTest logger ;
	BaseTest baseTest = new BaseTest();
	
	public void onStart(ITestContext context) {
		extent = new ExtentReports(System.getProperty("user.dir") + "//Report//extentReport.html");
	}
	
	public void onTestStart(ITestResult result) {
		logger = extent.startTest(result.getMethod().getMethodName());
		logger.log(LogStatus.INFO, result.getMethod().getMethodName() + " test is started");
	}
	
	public void onFinish(ITestContext iTestContext) {
	        extent.endTest(logger);
	        extent.flush();
	       
	 }
	 
	 public void onTestSuccess(ITestResult result) {
	    	//ExtentReports log operation for passed tests.
	       logger.log(LogStatus.PASS, result.getMethod().getMethodName() + " test is passed");
	    }
	 
	 public void onTestFailure(ITestResult result) {
	    	//ExtentReports log operation for failed tests.
	        logger.log(LogStatus.FAIL, result.getMethod().getMethodName() + " test is failed");
	        try {
				logger.log(LogStatus.FAIL, result.getMethod().getMethodName() + " test is failed", logger.addScreenCapture(takeScreenshotForFailure(result)));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        logger.log(LogStatus.FAIL, result.getMethod().getMethodName() + " error ", result.getThrowable().getMessage());
	        
	    }
	  
	 public void onTestSkipped(ITestResult result) {
	        //ExtentReports log operation for skipped tests.
	        logger.log(LogStatus.SKIP, result.getMethod().getMethodName() + " test is skipped");
	        logger.log(LogStatus.SKIP, result.getThrowable().getMessage());
	    }
	    
	 public String takeScreenshotForFailure(ITestResult result) throws IOException {
	    	TestUtil util = new TestUtil();
	    	String screenshotPath = null;
	    	if(result.getStatus()==ITestResult.FAILURE) {
				screenshotPath = util.TakeScreenshotAfterTest(result.getName());	
				
			}
	    	return screenshotPath;
	    }
	
}