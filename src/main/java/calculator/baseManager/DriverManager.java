package calculator.baseManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverManager {
	public static WebDriver driver;
	public static Properties prop;
	public DriverManager() {
		try {
			prop = new Properties();
			prop.setProperty("log4j.rootLogger", "WARN");
			PropertyConfigurator.configure(prop);
			FileInputStream in = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/calculator/config/Configuration.properties");
			prop.load(in);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void DriverInitialization() {
		String OsName = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
		System.out.println("OsName: "+OsName);
		
		String browserName = prop.getProperty("browser");
		
		if(OsName.startsWith("mac")) {
			if(browserName.equalsIgnoreCase("Chrome")) {
				driver = new ChromeDriver();
			}
			if(browserName.equalsIgnoreCase("Safari")) {
				System.setProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
				driver = new SafariDriver();
			}
		}
	   
		if(OsName.startsWith("win")) {
			if(browserName.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriverWindows.exe");
				driver = new ChromeDriver();
			}
		}
		

		else if(browserName.equalsIgnoreCase("InternetExplorer")) {
			System.setProperty("webdriver.IEDriverServer.driver", System.getProperty("user.dir") + "/Drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else {
			System.out.println("Driver "+ browserName + " not supported/Invalid");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}

}
