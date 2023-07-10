package day3_advancedLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class xpathDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\\\\\\\Work\\\\\\\\seleniumTools\\\\\\\\chromeDriver\\\\\\\\chromedriver_win32 (2)\\\\\\\\chromedriver.exe");
		xpathDemo xpath = new xpathDemo();
//		xpath.amazonSearch();
		xpath.etsy();
	}
	
		public void amazonSearch() throws InterruptedException {
			WebDriver driver = new ChromeDriver();
			driver.get("https://amazon.com");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Coffee Mug");
			driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();	
			}

		public void etsy() throws InterruptedException {
			WebDriver driver = new ChromeDriver();
			driver.get("https://etsy.com");	
			driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--small wt-btn--transparent wt-mr-xs-1 inline-overlay-trigger signin-header-action select-signin']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--secondary wt-btn--small inline-overlay-trigger register-header-action select-register']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='join_neu_email_field']")).sendKeys("jon.dow@gmail.com");
			driver.findElement(By.xpath("//input[@id='join_neu_first_name_field']")).sendKeys("firstname");
			driver.findElement(By.xpath("//input[@id='join_neu_password_field']")).sendKeys("password");
			driver.findElement(By.xpath("//button[@value='register']")).click();
			String errorMessage = driver.findElement(By.xpath("//div[@id='aria-join_neu_password_field-error']")).getText();
			System.out.println(errorMessage);
			Thread.sleep(1000);
			driver.close();
		}





}
