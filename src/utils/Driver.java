package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
		public static WebDriver driver;
//		User define
		public static WebDriver getDriver() {
			
			System.setProperty("webdriver.chrome.driver","C:/Work/seleniumTools/chromeDriver/chromedriver_win32 (2)/chromedriver.exe");
			if(driver == null) {
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();	}
			
			return driver;
		}
		
		public static void quitDriver() {
			if(driver != null) {
				driver.quit();
				driver = null;
			}
		}

}
