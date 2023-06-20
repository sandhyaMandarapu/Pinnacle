package google.ObjectRepository;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import google.GenericUtility.BaseClass;
import google.GenericUtility.PropertyFileUtility;

public class HomePage extends BaseClass {
	PropertyFileUtility pUtil=new PropertyFileUtility();
	WebDriver driver;

	@FindBy(xpath = "//a[text()='Gmail']")
	private WebElement Gmail;
  
   @FindBy(xpath = "//a[normalize-space()='Sign in']")
	private WebElement Signin; 
   @FindBy(xpath = "//a[@aria-label='Google apps']")
  	private WebElement icon;
	@FindBy(xpath = "//li[@class=\"j1ei8c\"][3]//span[text()='Maps']")
	private WebElement Maps;
	@FindBy(xpath = "//li[@class='j1ei8c'][4]//span[text()='YouTube']")
	private WebElement  Youtube;
	
	
	public  HomePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public WebElement getGmail() {
		return Gmail;
	}
	public WebElement getSignin() {
		return Signin;
	}
	public WebElement getIcon() {
		return icon;
	}
	public WebElement getMaps() {
		return Maps;
	}
	public WebElement getYoutube() {
		return Youtube;
	}
	

public void maps() throws InterruptedException
{
//	driver.findElement(By.xpath(null))
//	WebElement map=Maps;
//	wUtil.mouseHoverOn(driver, map);
////	wUtil.mouseHoverOn(driver, 96, 96);
	Thread.sleep(2000);
	Maps.click();
}

}
	

