package day6_workingWithWebElements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class KeysEventPractice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:/Work/seleniumTools/chromeDriver/chromedriver_win32 (2)/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
/*		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//wait the page to be loaded
		driver.manage().window().maximize();
		driver.get("https://google.com");
		driver.navigate().refresh();
		driver.findElement(By.name("q")).sendKeys("coffee Mug" + Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.name("q")).clear();
		Thread.sleep(1000);
		driver.findElement(By.name("q")).sendKeys("GT-R"+ Keys.ENTER);			*/
		
/*		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://amazon.com");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Coffee Mug" + Keys.ENTER);
		driver.navigate().back();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Pretty Coffee Mug" + Keys.ENTER);
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();				*/

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://saucedemo.com");
		driver.findElement(By.id("user-name")).sendKeys("standard_user" + Keys.TAB +"secret_sauce" + Keys.TAB + Keys.ENTER);
		List<WebElement> items = driver.findElements(By.cssSelector(".inventory_item_description"));
		int listSize = items.size();
		System.out.println(listSize);
		List<WebElement> itemsPrice = driver.findElements(By.cssSelector(".inventory_item_price"));
		for(int i = 0;i<itemsPrice.size();i++) {
			System.out.println(itemsPrice.get(i).getText());	}
		
		
	
	
	
	
	
	
	
	
	
	}
	
}
