package day10_FrameworkDesign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.FacebookPage;
import utils.DataReader;
import utils.Driver;

public class ReuseableProMax {
	public static void main(String[] args) throws InterruptedException {
		ReuseableProMax fb = new ReuseableProMax();
		fb.testcase1();
//		fb.testcase2();
	}
	
	
	FacebookPage fbPage = new FacebookPage();
	
	public void testcase1() {
		
		Driver.getDriver().get(DataReader.getProperty("appUrl"));
		fbPage.FBemailField.sendKeys(DataReader.getProperty("userName"));
		fbPage.FBpassField.sendKeys(DataReader.getProperty("password"));
		fbPage.FBloginField.click();
		Driver.quitDriver();
	
	}
	public void testcase2() throws InterruptedException {
		
		
			
		Driver.getDriver().get(DataReader.getProperty("appUrl"));
		Driver.getDriver().findElement(By.linkText("Create new account")).click();
		Thread.sleep(1000);
		Driver.getDriver().findElement(By.name("firstname")).sendKeys("automation");
		Driver.getDriver().findElement(By.name("lastname")).sendKeys("automation");
		Driver.getDriver().findElement(By.name("reg_email__")).sendKeys("automation");
		Driver.getDriver().findElement(By.name("reg_passwd__")).sendKeys("automation");
		Driver.getDriver().findElement(By.name("websubmit")).click();
		Driver.quitDriver();
		}
	
}
