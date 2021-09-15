package com.inetbanking.testCases;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.microsoft.edge.seleniumtools.EdgeDriver;

public class Log4jDemo {
	private static Logger logger = LogManager.getLogger(Log4jDemo.class);
	static WebDriver driver;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception{
		System.out.println("\n Hello World! \n");
		logger.info("This is info message");
		logger.error("Error message");
		logger.warn("Warning message");
		logger.fatal("Fatal Message");
		
//		System.setProperty("webdriver.ie.driver", "Drivers\\IEDriverServer.exe");
		System.setProperty("webdriver.edge.driver", "Drivers\\msedgedriver.exe");
		
		EdgeDriver driver = new EdgeDriver();
		driver.get("http://demo.guru99.com/V1/index.php");
			
		try {
			// custom stuff IE needs in order to work (some only needed for Win10+)
//			DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
//			ieCapabilities.setCapability("nativeEvents", false);
//			ieCapabilities.setCapability("unexpectedAlertBehaviour", "accept");
//			ieCapabilities.setCapability("ignoreProtectedModeSettings", true);
//			ieCapabilities.setCapability("disable-popup-blocking", true);
//			ieCapabilities.setCapability("enablePersistentHover", true);
//			ieCapabilities.setCapability("ignoreZoomSetting", true);

			// deprecated but working
//			driver = new InternetExplorerDriver(ieCapabilities);


			// Set browser defaults (maximize, clear cookies, set timeouts)
			
//			driver.manage().window().maximize();
//			driver.manage().deleteAllCookies();
//			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
//			driver.navigate().to("http://demo.guru99.com/V1/index.php");
			Thread.sleep(5000);
		} catch(InterruptedException e) {
			System.out.println("Exceptions: "+e.getMessage());
		}
		
		driver.quit();;
				
	}
}
