package day9_ActionsClass;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class day8_homeworkReview {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:/Work/seleniumTools/chromeDriver/chromedriver_win32 (2)/chromedriver.exe");
//		guru99Homework();
		iframeHomework();
	}
	public static void guru99Homework() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver,5);
		
//		go to http://demo.guru99/popup.php
		driver.get("http://demo.guru99.com/popup.php");
//		get title and store it in a variable
		String title =driver.getTitle();
//		Get the main page window id
		String mainWindowid = driver.getWindowHandle();
//		Click on click here button and switch over to next window, provide an email click submit.
		driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
		Set <String> windowIds = driver.getWindowHandles();
		
/*		Iterator<String> iterator = windowIds.iterator();
		String firstWindow = iterator.next();
		String secondWindow = iterator.next();		
		driver.switchTo().window(secondWindow);		*/
		
		
		for(String secondWindow : windowIds) {
			if(!secondWindow.equals(mainWindowid)) {
				driver.switchTo().window(secondWindow);
			}
		}
		
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("its.hamza@outlook.com");
		driver.findElement(By.name("btnLogin")).click();
//		Get text of the user id and password and store them in variables, print them out.
		String userId = driver.findElement(By.xpath("//td[text()='User ID :']//following-sibling::td")).getText().trim();
//		String userId = driver.findElement(By.xpath("//td[contains(text(),'mngr')])).getText();
		
		System.out.println("user id is " + userId);
		String password = driver.findElement(By.xpath("//td[text()='Password :']//following-sibling::td")).getText().trim();
		System.out.println("password is "+ password);
//		then verify the text "This access is valid only for 20 days."
		String text = driver.findElement(By.xpath("//h3[contains(text(),'This access')]")).getText();
		if(text.equals("This access is valid only for 20 days.")) {
			System.out.println("verified");
		}else {
			System.out.println("Not verified");
		}
//		close the window
		driver.close();
//		go back to main window, and get title then verify it equals to your stored title.
		driver.switchTo().window(mainWindowid);
		if(driver.getTitle().equals(title)) {
			System.out.println("Test Pass");
		}else {
			System.out.println("Test fail");
		}
//		Quit driver.
		driver.quit();
		
	}
	public static void iframeHomework() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver,5);
//		go to http://practice.primetech-apps.com/practice/frames
		driver.get("http://practice.primetech-apps.com/practice/frames");
//		Verify that there is a page header text as "Frames"
		boolean frameIsDisplayed = driver.findElement(By.xpath("//h3[text()='Frames']")).isDisplayed();
		if(frameIsDisplayed) {
			System.out.println("Frame is displayed");
		}else {
			System.out.println("Frame is not displayed");
		}
//		Find the iFrame element and switch into it.
		driver.switchTo().frame("iframe1");
//		driver.switchTo().frame(driver.find(By.id("iframe1")));
		
//		Find the firstname, lastname, address, city, state, and zipcode, and type relative information.
		driver.findElement(By.id("firstName")).sendKeys("john");
		driver.findElement(By.id("lastName")).sendKeys("smith");
		driver.findElement(By.id("address")).sendKeys("123 main st");
		driver.findElement(By.id("city")).sendKeys("fairfex");
		driver.findElement(By.id("zipCode")).sendKeys("1234");
		
		Select letsSelect = new Select(driver.findElement(By.id("state")));
		letsSelect.selectByVisibleText("Virginia");
		Thread.sleep(1000);
//		click on submit button
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
//		Verify you see "You have submitted below information:" message.
		boolean infoText = driver.findElement(By.xpath("//h3[text()='you have submited below information:']")).isDisplayed();
		if(infoText) {
			System.out.println("Verified");
		}else {
			System.out.println("Not Verified");
		}
//		Switch to back to main frame
		driver.switchTo().parentFrame();
//		driver.switchTo().defaultContent();
//		Verify that there is a page header text as "Frames".
		boolean framesIsDisplayed = driver.findElement(By.xpath("//h3[text()='Frames']")).isDisplayed();
		if(frameIsDisplayed) {
			System.out.println("Frame is displayed");
		}else {
			System.out.println("Frame is not displayed");
		}
	driver.quit();
	
	}
}
