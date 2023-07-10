package day1_seleniumLaunch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day1_selenium {
	
	public static void main(String[] args) {
		
			System.setProperty("webdriver.chrome.driver", "C:\\Work\\seleniumTools\\chromeDriver\\chromedriver_win32 (2)\\chromedriver.exe");
		
			WebDriver driver = new ChromeDriver();
			driver.get("https://amazon.com");
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("vibrator");
//			if the return type is void , we can not do any action or chaining because there is no data return.
			driver.findElement(By.id("nav-search-submit-button")).click();
			driver.findElement(By.linkText("Customer Service")).click();
		
		}
}
