package day8_popUps;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class two_windows {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:/Work/seleniumTools/chromeDriver/chromedriver_win32 (2)/chromedriver.exe");
		
//		alert();
		classActivity();
	}

//	public static void alert() {
//		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//		WebDriverWait wait = new WebDriverWait(driver,5);
//		driver.get("http://practice.primetech-apps.com/practice/browser-windows");
//		String mainWindowId = driver.getWindowHandle();
//		System.out.println(mainWindowId);// this will return main window's id
//		driver.findElement(By.id("newTab")).click();// now we are on a new tab and we have two tabs now
//		Set<String> windowIds = driver.getWindowHandles();
//		for(String windowId : windowIds) {
//			System.out.println(windowId);
//		}
//		
//		Iterator<String> ids = windowIds.iterator();
//		String firstId = ids.next();
//		String secondId = ids.next();
//		System.out.println("first id is "+firstId);
//		System.out.println("second id is "+secondId);
//		
//		driver.switchTo().window(secondId);
//		driver.close();
//		driver.switchTo().window(firstId);
//		
//	}
	public static void classActivity() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver,5);
//		Go to http://practice.primetech-apps.com/practice/browser-windows
		driver.get("http://practice.primetech-apps.com/practice/browser-windows");
//		Get the main window id and stored into the string called mainWindowId,
		String mainWindowID = driver.getWindowHandle();
		System.out.println(mainWindowID);
//		Click on the new tab button
		driver.findElement(By.id("newTab")).click();
//		Get window Ids and store it into a Set
		Set<String> windowIds = driver.getWindowHandles();
//		Get the first window ID from the Set and Verify it matches with the main window.
		Iterator<String> iterator = windowIds.iterator();
		String firstWindowId = iterator.next();
		if(firstWindowId.equals(mainWindowID)) {
		System.out.println("Ids matches");
		}else {
			System.out.println("Ids does not match");
		}
//		Get the second window id and store it in variable called secondWindowId.
		String secondWindowId = iterator.next();
		
//		Switch to the second window
		driver.switchTo().window(secondWindowId);
//		Verify that there is a button called 'New Tab'
		if(driver.findElement(By.id("newTab")).isDisplayed()) {
			System.out.println("New tab button is available on second window");
		}else {
			System.out.println("New tab button is not available on second window");
		}
//		Close the window,
		
		driver.close();//it only closes the second window if we put driver.quit(); then it close all the tabs

//		Switch back to the main window
		
		driver.switchTo().window(mainWindowID);
		
//		 verify you are on the main window
		if(driver.getWindowHandle().equals(mainWindowID)) {
			System.out.println("We are on the main window");
		}else {
			System.out.println("we lost");
		}
	
	
	
	
	
	
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
}

