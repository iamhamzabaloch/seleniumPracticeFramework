package day7_ElementStatus;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day_homeorkReview {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:/Work/seleniumTools/chromeDriver/chromedriver_win32 (2)/chromedriver.exe");

//		radioButtonHomeWork();
//		checkBoxHomework();
//		amazon();
//		dropdownDemo();
//		nonSelectDropdown();
		alert();
	}
	public static void radioButtonHomeWork() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://artoftesting.com/samplesiteforselenium");
//		find radio buttons
		List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@type='radio']"));
//		check if it is displayed and enabled,
		for(WebElement singleRadio : radioButtons) {
			if(singleRadio.isDisplayed() && singleRadio.isEnabled()) {
//				if false select the Button
				if(singleRadio.isSelected()) {
					System.out.println("Radio button is selected");
				}else {
					System.out.println("Radio button is selected");
					singleRadio.click();
				}
			}else {
				System.out.println("nOT displayed or enabled");
			}
		System.out.println("is radio button is seected? "+ singleRadio.isSelected());
		}
		
	}
	public static void checkBoxHomework() {
		 WebDriver driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		 driver.get("https://artoftesting.com/samplesiteforselenium");
		 List<WebElement> checkBox = driver.findElements(By.xpath("//input[@type='checkbox']"));
		 
		 for(WebElement singleCheckbox : checkBox) {
			 if(singleCheckbox.isDisplayed()) {
				 System.out.println("Displayd");
				 if(singleCheckbox.isEnabled()) {
					 System.out.println("Enabled");
					 if(singleCheckbox.isSelected()) {
						 System.out.println("Selected");
						 
					 }else {
						 System.out.println("Not Selected,,,going to select it");
						 singleCheckbox.click();
					 }
					 
				 }else {
					 System.out.println("Not Enabled.");
				 }
					 
			 }else {
				 System.out.println("Not Displayed.");
			 }
				 System.out.println("is checkbox now selected "+ singleCheckbox.isSelected());
		 }//loop scope
		 
		}//method scope
	
	 public static void amazon() throws InterruptedException {
		 WebDriver driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		 driver.get("https://amazon.com");
		 driver.findElement(By.id("nav-link-accountList")).click();
		 Thread.sleep(1000);
		 if(driver.findElement(By.xpath("//h1[contains(text(),'Sign in')]")).isDisplayed()) {
			 System.out.println("We are on Sign-in page");
		 }else {
			 System.out.println("We are not on sign-in page");
		 }
		 driver.navigate().back();
		 driver.navigate().forward();
		 if(driver.findElement(By.xpath("//h1[contains(text(),'Sign in')]")).isDisplayed()) {
			 System.out.println("We are on Sign-in page again");
		 }else {
			 System.out.println("We are not on sign-in page again");
		 }
		 driver.findElement(By.id("createAccountSubmit")).click();
		 if(driver.findElement(By.xpath("//h1[contains(text(),'Create account')]")).isDisplayed()) {
			 System.out.println("We are on create account page");
		 }else {
			 System.out.println("We are not on create account page");
		 }
		 driver.navigate().back();
		 if(driver.findElement(By.xpath("//h1[contains(text(),'Sign in')]")).isDisplayed()) {
			 System.out.println("We are on Sign-in page 3rd time");
		 }else {
			 System.out.println("We are not on sign-in page 3rd time");
		 }
		 driver.navigate().forward();
		 if(driver.findElement(By.xpath("//h1[contains(text(),'Create account')]")).isDisplayed()) {
			 System.out.println("We are on create account page again");
		 }else {
			 System.out.println("We are not on create account page again");
		 }
		 driver.findElement(By.id("continue")).click();
		 WebElement errorName = driver.findElement(By.xpath("//div[contains(text(),'Enter your name')]"));
		 if(errorName.isDisplayed()) {
			 if(errorName.getText().equals("Enter your name")) {
				 System.out.println("Same error message");
			 }else {
				 System.out.println("Mis-match error message.");
			 }
		 }else {
			 System.out.println("Error message not Displayed");
		 }
		 
	 }
	
	 public static void dropdownDemo() throws InterruptedException {
		 
		 WebDriver driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		 driver.get("https://amazon.com");
		 WebElement selectElement = driver.findElement(By.id("searchDropdownBox"));
		 Select choose = new Select(selectElement);
		 WebElement firstSelectedOption = choose.getFirstSelectedOption();
		 System.out.println(firstSelectedOption.getText());
		 
		 choose.selectByVisibleText("Home & Kitchen");
		 Thread.sleep(1000);
		 choose.selectByIndex(14);
		 Thread.sleep(1000);
		 choose.selectByValue("search-alias=stripbooks-intl-ship");
		 System.out.println(choose.getFirstSelectedOption().getText());
		 
		 List<WebElement> allOptions = choose.getOptions();
		 System.out.println(allOptions.size());
		 for(WebElement element : allOptions ) {
			 System.out.println(element.getText());
		 }
	 }
	  public static void nonSelectDropdown() throws InterruptedException {
	 		 WebDriver driver = new ChromeDriver();
	 		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 		 driver.manage().window().maximize();
	 		 
	 		 WebDriverWait wait = new WebDriverWait(driver,5);// to wait until it shows the element
	 		 
	 		 driver.get("https://semantic-ui.com/modules/dropdown.html");
	 		 
	 		 
	 		 WebElement dropDown = driver.findElement(By.xpath("(//div[@class = 'ui fluid selection dropdown'])[1]"));
	 		 wait.until(ExpectedConditions.visibilityOf(dropDown));
	 		 dropDown.click();// NOw we use this rather than thread.sleep

	 		 driver.findElement(By.xpath("//div[@data-value = 'matt']")).click();
	 	 }
	  public static void alert() {
		  WebDriver driver = new ChromeDriver();
	 		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 		 driver.manage().window().maximize();
	 		 
	 		 WebDriverWait wait = new WebDriverWait(driver,5);// to wait until it shows the element
	 		 driver.get("https://practice.primetech-apps.com/practice/alerts");
	 		 driver.findElement(By.id("confirm")).click();
	 		 wait.until(ExpectedConditions.alertIsPresent());
	 		 Alert handle = driver.switchTo().alert();
	 		 handle.accept();
	 		 handle.getText();
	 		 handle.dismiss();
	 		 handle.sendKeys("BlOch");
	  }
	 	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
