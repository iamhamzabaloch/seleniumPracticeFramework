package day8_popUps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class day7_homeWork {
		public static void main(String[] args) {
			System.setProperty("webdriver.chrome.driver","C:/Work/seleniumTools/chromeDriver/chromedriver_win32 (2)/chromedriver.exe");
//			amazon();
			alert();
		}

		public static void amazon() {
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
//			Go to amazon
			driver.get("https://amazon.com");
//			verify that you are on amazon homepage(verify title)
			String expectedTitle = "Amazon.com. Spend less. Smile more.";
			if (driver.getTitle().equals(expectedTitle)) {
				System.out.println("We are on amazon homepage");
			}else {
				System.out.println("We are not on amazon homepage");
			}
					
//			verify dropdown value is by default "All departments"
			String defaultDropdownValue = "All Departments";
			WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
			
			Select letSelect = new Select(dropdown);
			String actualDropdownValue = letSelect.getFirstSelectedOption().getText();
			if(actualDropdownValue.equals(defaultDropdownValue)) {
				System.out.println("default dropdown value match");
			}else {
				System.out.println("default dropdown value does not match");
			}
//			select department Home&Kitchen, and search coffee mug
			String item = "Coffee Mug";
			letSelect.selectByVisibleText("Home & Kitchen");
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Coffee Mug");
			driver.findElement(By.id("nav-search-submit-button")).click();
//			verify you are on coffee mug search result page(use title)
			String itempageTitle = driver.getTitle();
			int beginningIndex = itempageTitle.length() - item.length();
			
			if(itempageTitle.substring(beginningIndex).equals(item)) {
				System.out.println("Search item title match");
			}else {
				System.out.println("Search item title do not match");
			}
//			verify you are on home&kitchen department
			WebElement dropdown2 = driver.findElement(By.id("searchDropdownBox"));
			Select letSelect2 = new Select(dropdown2);
			String selectedOption = letSelect2.getFirstSelectedOption().getText();
			if(selectedOption.equals("Home & Kitchen")) {
				System.out.println("test pass");
			}else {
				System.out.println("test fail");
			}
		}

		public static void alert() {
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			WebDriverWait wait = new WebDriverWait(driver,5);
			String txt = "PrimeTech";
			driver.get("https://");
//			a pop up alert is displayed at your screen which is not inspectable and ask for a txt which is primetech
			
			wait.until(ExpectedConditions.alertIsPresent());
			Alert handle = driver.switchTo().alert();
			handle.sendKeys(txt);
			handle.accept();// it will accept whatever we put in alert popup through send keys
//			then a greeting message displayed on the screen,we will find that element and store into webelement and ask selenium to w8 intil it is visible
			WebElement greetings = driver.findElement(By.id("greeting-txt"));
			wait.until(ExpectedConditions.visibilityOf(greetings));
			String greetingtxt = greetings.getText(); 
			
			
			
			
		}


}

