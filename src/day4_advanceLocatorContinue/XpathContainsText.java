package day4_advanceLocatorContinue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathContainsText {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:/Work/seleniumTools/chromeDriver/chromedriver_win32 (2)/chromedriver.exe");
		XpathContainsText xMethods = new XpathContainsText();
		etsy();
	}
	
	public static void etsy() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://etsy.com");
		
//												****Diiferent xPath methods****
		
//		driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--small wt-btn--transparent wt-mr-xs-1 inline-overlay-trigger signin-header-action select-signin']")).click();
//		driver.findElement(By.xpath("//button[contains(@class,'wt-btn--transparent')]")).click();
//		driver.findElement(By.xpath("//button[text()='Sign in'")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();	
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(),'Register')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[contains(@id,'email_field')]")).sendKeys("jon.dow@gmail.com");
		driver.findElement(By.xpath("//input[contains(@id,'first_name_field')]")).sendKeys("jon");
		driver.findElement(By.xpath("//input[contains(@id,'password_field')]")).sendKeys("jondowthe2nd");
		driver.findElement(By.xpath("//button[contains(text(),'Register')]")).click();
		Thread.sleep(1000);
		String actual = driver.findElement(By.xpath("//div[contains(text(),'for assistance.')]")).getText();
		if(actual.equals("Sorry! There was a problem on our end. Please try registering again or email support@etsy.com for assistance.")) {
			System.out.println("test pass");
		}else {
			System.out.println("Test fail");
		}
	}
	
	
	
	
	
	
	
	
	
}
