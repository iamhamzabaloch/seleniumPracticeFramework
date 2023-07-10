package day4_advanceLocatorContinue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day3_homeworkRecap {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:/Work/seleniumTools/chromeDriver/chromedriver_win32 (2)/chromedriver.exe");
		
//		Day3_homeworkRecap.indeed();
		Day3_homeworkRecap.fb();
	}
	
	public static void indeed() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://indeed.com");
		Thread.sleep(1000);
		String homeURL = driver.getCurrentUrl();
		String homeTitle = driver.getTitle();
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("SDET");

		//		find the input field for where, clear the field first and type washington DC
//									xpath simple
		WebElement whereField = driver.findElement(By.xpath("//input[@name='l']"));
//		whereField.sendKeys(Keys.CONTROL + "a");
//		whereField.sendKeys(Keys.DELETE);
//		
//		another way of deleting text by looping
//		loop tab tak ititerate kre ga jab tak i value ki length se chota hai or condition true ha,
//		
		String value = whereField.getAttribute("value");
		for(int i = 0; i < value.length(); i++) {
			whereField.sendKeys(Keys.BACK_SPACE);
		}
		whereField.sendKeys("washington, DC");
//												xpath contains(when the vakue of the attribute is too much long
//		
		driver.findElement(By.xpath("//button[contains(@class,'yosegi')]")).click(); //very very important method
		Thread.sleep(1000);
		
//												xpath text(to find element by xpath text)when theere is no attribute
		driver.findElement(By.xpath("//a[text()='Upload your resume']")).click();
		
//												xpath contains + text(//button[contains(text(),'Sign in')]
		
	}
		public static void fb() throws InterruptedException {
			
			WebDriver driver = new ChromeDriver();
			String firstName = "iTs.HaMzA";
			int phNum = 01234;
			int password = 01234;
			String expErrorMsg = "The password that you've entered is incorrect. Forgotten password?";
			driver.get("https://facebook.com");
			driver.findElement(By.xpath("//input[@name='email']")).sendKeys(firstName);
			driver.findElement(By.xpath("//input[@name='pass']")).sendKeys(String.valueOf(password));
			driver.findElement(By.xpath("//Button[@name='login']")).click();
			Thread.sleep(1000);
			String errorMsg = driver.findElement(By.xpath("//div[contains(text(),'is incorrect')]")).getText();
			System.out.println("error Msg is  "+ errorMsg );
				if(errorMsg.equals(expErrorMsg)) {
				System.out.println("Test Pass");
			}else {
				System.out.println("Test Fail");
			}
						if(Integer.parseInt(errorMsg)== phNum) {
				System.out.println("Test fail");
		}else{
				System.out.println("Test pass");
			}
			
			
			
			
			
			
			
			
		}

}
