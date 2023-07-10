 package day10_FrameworkDesign;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day9_actionsClassHomework {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:/Work/seleniumTools/chromeDriver/chromedriver_win32 (2)/chromedriver.exe");
		
		actionsDemo();
	}
	public static void actionsDemo() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver,5);
		
		Actions letsDo = new Actions(driver);
		

//		go to "http://practice.primetech-apps.com/practice/drag-and-drop"
		driver .get("http://practice.primetech-apps.com/practice/drag-and-drop");
//		Verify drag and drop text is displayed
		if(driver.findElement(By.xpath("//h3[text()='Drag And Drop']")).isDisplayed()) {
			System.out.println("We are on Drag And Drop Page");
		}else {
			System.out.println("We are not on Drag And Drop Page");
		}
		
		WebElement textSource = driver.findElement(By.id("text"));
		WebElement textareaSource = driver.findElement(By.id("textarea"));
		WebElement numberSource = driver.findElement(By.id("Number"));

		WebElement target = driver.findElement(By.id("dropzone"));
		
//		drag the text element to target window
		letsDo.dragAndDrop(textSource, target).build().perform();
//		drag the Textarea element to target window
		letsDo.dragAndDrop(textareaSource, target).build().perform();

//		drag the NUmber element to the target window
		letsDo.dragAndDrop(numberSource, target).build().perform();

//		delete all those dragged items from target window
		List<WebElement> remove = driver.findElements(By.cssSelector(".remove"));
		
		for(WebElement webelement : remove) {
			webelement.click();
		}
	
//		driver.quit(); 
	}
}
