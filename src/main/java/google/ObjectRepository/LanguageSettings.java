package google.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import google.GenericUtility.BaseClass;
import google.GenericUtility.PropertyFileUtility;

public class LanguageSettings extends BaseClass {
	PropertyFileUtility pUtil=new PropertyFileUtility();
	WebDriver driver;
	@FindBy(xpath = "//div[@class='ayzqOc pHiOh']")
	private WebElement  Settings;	
	@FindBy(xpath = "	//a[normalize-space()='Search settings']")
	private WebElement Searchsettings;
	@FindBy(xpath = "	//a[normalize-space()='Languages']")
	private WebElement Languages;
	@FindBy(xpath = "	//div[@class='jfk-radiobutton'][1]")
	private WebElement Preferredlang;
	@FindBy(xpath = "/html/body")
	private WebElement CurrentText;
//	@FindBy(xpath ="///span[text()='Deutsch'][2]")
//	private WebElement lang;
	@FindBy(xpath = "//div[text()='Save']	")
	private WebElement Savebtn;
	public  LanguageSettings(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getLanguages() {
		return Languages;
	}
	public WebElement getSavebtn() {
		return Savebtn;
	}
	public WebElement getPreferredlang() {
		return Preferredlang;
	}
	public WebElement getSettings() {
		return Settings;
	}
	public WebElement getSearchsettings() {
		return Searchsettings;
	}

	public void getCurrentText() {
WebElement ww=CurrentText;
System.out.println(ww.getText());
	}
//	public WebElement getlang() {
//		return lang ;
//	}
}
