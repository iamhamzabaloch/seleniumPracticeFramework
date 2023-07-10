package day2_seleniumFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookActivities {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Work\\\\seleniumTools\\\\chromeDriver\\\\chromedriver_win32 (2)\\\\chromedriver.exe");
	
		FacebookActivities fb = new FacebookActivities();
	
		fb.testcase1();
		fb.testcase2();
		fb.getText();
	}
		
		public void testcase1() {
			
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://facebook.com");
		driver.findElement(By.id("email")).sendKeys("its.hamza");
		driver.findElement(By.id("pass")).sendKeys("*******");
		driver.findElement(By.name("login")).click();
		driver.close();
	}
		
		public void testcase2() throws InterruptedException {
			
		WebDriver driver = new ChromeDriver();	
			
		driver.get("https://facebook.com");
		driver.findElement(By.linkText("Create new account")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("firstname")).sendKeys("automation");
		driver.findElement(By.name("lastname")).sendKeys("automation");
		driver.findElement(By.name("reg_email__")).sendKeys("automation");
		driver.findElement(By.name("reg_passwd__")).sendKeys("automation");
		driver.findElement(By.name("websubmit")).click();
		driver.close(); 
		}
		
		public void getText() {
			
			WebDriver driver = new ChromeDriver();
			driver.get("https://facebook.com");
			
			String loginText = driver.findElement(By.name("login")).getText();
			System.out.println("login button text is: "+ loginText);
			
			if(loginText.equals("Log in")) {
				System.out.println("Test Passed");
			}else {
				System.out.println("Test Failed");
			}
			driver.close();
		}
		
	
}