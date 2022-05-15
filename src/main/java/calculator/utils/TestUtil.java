package calculator.utils;

import java.io.File;
import java.io.IOException;
import org.apache.maven.surefire.shared.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import calculator.baseManager.DriverManager;

/**
 * Handle test data sheet and capture screenshot
 * @author Ashrika Agarwal
 *
 */
public class TestUtil extends DriverManager{
	
	/**
	 * take screenshot and save it in given path
	 * @param TestCaseName
	 * @return file path
	 * @throws IOException
	 */
	public String TakeScreenshotAfterTest(String TestCaseName) throws IOException {
		File sc = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String curdir = System.getProperty("user.dir");
		String destination = curdir + "/screenshots/" + TestCaseName + System.currentTimeMillis() + ".png";
		
		FileUtils.copyFile(sc, new File(destination));
		return destination;
	}
	
	
}
