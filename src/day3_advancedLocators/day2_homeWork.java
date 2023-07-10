package day3_advancedLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class day2_homeWork {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Work\\seleniumTools\\chromeDriver\\chromedriver_win32 (2)\\chromedriver.exe");
		
		day2_homeWork Hw = new day2_homeWork();
//		Hw.EtsyHw();
		Hw.indeedHw();
	}
	
	
		public void EtsyHw() throws InterruptedException {
			WebDriver driver = new ChromeDriver();
			
			driver.get("https://etsy.com");
			Thread.sleep(1000);
			driver.findElement(By.className("select-signin")).click();
			driver.findElement(By.id("join_neu_email_field")).sendKeys("automation");
			driver.findElement(By.name("password")).sendKeys("automation");
			driver.findElement(By.name("submit_attempt")).click();
		
		}
		
		public void indeedHw() throws InterruptedException {
			WebDriver driver = new ChromeDriver();
			String searchCriteria = "SDET";
			
			driver.get("https://indeed.com");
			Thread.sleep(1000);
//			get the current url and store in the variable home url.
			String homeURL = driver.getCurrentUrl();
//			get the title and store it in variable called homeTitle
			String homeTitle = driver.getTitle();
//			find the input field for what and type SDET
			driver.findElement(By.id("text-input-what")).sendKeys("SDET");
//			find the input feild for wehere, clear the feild and type washington DC
//			driver.findElement(By.name("text-input-where")).sendKeys("wash")
//			find the Find jobs Button and click on it
			driver.findElement(By.className("yosegi-InlineWhatWhere-primaryButton")).click();
			Thread.sleep(1000);
//			get the current url and store it in variable searchURL
			String searchURL = driver.getCurrentUrl();
//			get the website title and store it in a variable searchTitle
			String searchTitle = driver.getTitle().toUpperCase();
//			verify that searchURL is not equal to homeURL and contains the search criteria
			if(!searchURL.equals(homeURL) && searchURL.contains(searchCriteria)) {
				System.out.println("searchURL is not equal to homeURL and contains search criteria");
			}else {
				System.out.println("searchURL is equal to homeURL OR does not contains search criteria ");
			}
//			verify the searchTitle is not equal to homeTitle and has the search criteria
			if(!searchTitle.equals(homeTitle) && searchTitle.contains(searchCriteria)) {
				System.out.println("searchTitle is not equal to homeTitle and contains search criteria");
			}else {
				System.out.println("searchTitle is equal to homeTitle OR does not contains search criteria ");
			}
//			Get text of the jobsInlocation field,store it in a variable, then verify if its equal to search criteria
			String TXT = driver.findElement(By.className("css-b3a57i")).getText();
			if(TXT.contains(searchCriteria)) {
				System.out.println("TRUE");
			}else {
				System.out.println("FALSE");
			}
			searchCriteria.substring(0,searchCriteria.length());
		}

}
