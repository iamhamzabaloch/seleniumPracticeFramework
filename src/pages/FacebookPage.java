package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;
//  page object model
public class FacebookPage {
	
	public FacebookPage(){
		PageFactory.initElements(Driver.getDriver(), this);
	}
	@FindBy(name = "email")
	public WebElement FBemailField;
	
	@FindBy(name = "pass")
	public WebElement FBpassField;
	
	@FindBy(name = "login")
	public WebElement FBloginField;
}
