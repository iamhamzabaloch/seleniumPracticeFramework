package day10_FrameworkDesign;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import pages.indeedPage;
import utils.BrowserUtils;
import utils.DataReader;
import utils.Driver;

public class BrowserUtilsDemo {

	public static void main(String[] args) {
		indeedTest();
	}
	
	static indeedPage indeed = new indeedPage();
	static BrowserUtils utils = new BrowserUtils();
	
	public static void indeedTest() {
//		go to indeed.com
		Driver.getDriver().get(DataReader.getProperty("indeedUrl"));

		utils.waitForElementVisible(indeed.whereField);
		
		indeed.whatField.sendKeys(DataReader.getProperty("whatField"));

//		find the where field and clear the text

//		indeed.whereField.sendKeys(Keys.CONTROL + "a" );
//		indeed.whereField.sendKeys(Keys.DELETE);
		utils.clearText(indeed.whereField);
		
		utils.highlightElement(indeed.search);
		indeed.search.click();
		
//							Scroll Down
		
//		JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
//		js.executeScript("arguments[0].scrollIntoView(true);", indeed.Resume);
		utils.scrollDownToElement(indeed.Resume);
		
		
		indeed.Resume.click();
		
		
	}
}
