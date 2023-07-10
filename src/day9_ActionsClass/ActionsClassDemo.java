package day9_ActionsClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsClassDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:/Work/seleniumTools/chromeDriver/chromedriver_win32 (2)/chromedriver.exe");
//		actionsDemo();
		dragNdrop();
	}
	public static void actionsDemo() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver,5);
		
		Actions letsDo = new Actions(driver);
		
//		go to etsy.com
		driver.get("https://etsy.com");
//		hover over on jewelry & accessories
		WebElement jewelryTab = driver.findElement(By.xpath("//span[contains(text(),'Jewelry & Accessories')]"));
		letsDo.moveToElement(jewelryTab).build().perform();
		Thread.sleep(1000);
//		Mouseover on bags & purses
		WebElement bagsPurses = driver.findElement(By.xpath("(//span[contains(text(),'Bags & Purses')])[1]"));
		letsDo.moveToElement(bagsPurses).build().perform();
		Thread.sleep(1000);
//		Mouseover to shoulder Bags
		WebElement shoulderBags = driver.findElement(By.xpath("//a[contains(text(),'Shoulder Bags')]"));
		letsDo.moveToElement(shoulderBags).build().perform();
//		Click on the shoulder bags
		shoulderBags.click();
//		Verify you are on the shoulder bags page
		if(driver.findElement(By.xpath("//h1[contains(text(),'Shoulder Bags')]")).isDisplayed()) {
			System.out.println("Test pass");
		}else {
			System.out.println("FAil");
		}
		driver.quit();
		
		
	}
	public static void dragNdrop() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver,5);
		
		Actions letsDo = new Actions(driver);
		
		driver.get("http://practice.primetech-apps.com/practice/drag-and-drop");
		
		WebElement sourceElement = driver.findElement(By.id("text"));
		WebElement targetElement = driver.findElement(By.id("dropzone"));
		letsDo.dragAndDrop(sourceElement, targetElement).build().perform();
		driver.quit();
	
	
	
	
	
	}		
}
