package google.GenericUtility;
import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;


/**
 * This class contains basic configuration ann          otation for common 
 * functionalities like connection to database, launch the browser etc
 * @author Sandhya M
 *
 */
public class BaseClass {
	
	
	public JavaUtility jUtil = new JavaUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver;
	 LogUtilities logs=new LogUtilities();
	
	@BeforeSuite(groups = {"SmokeSuite","RegressionSuite"})
	public void bsConfig() throws SQLException
	{
		//dUtil.connectToDB();
		Reporter.log("--Database Connection successful--",true);
	}

@Parameters("BROWSER")
//@BeforeTest
	@BeforeClass
	public void bcConfig(@Optional("chrome")  String BROWSER) throws IOException
	{
		//String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("Url");
		
		if(BROWSER.equalsIgnoreCase("CHROME"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			Reporter.log("--Browser "+BROWSER+" launched successfully--",true);
		}
		else if(BROWSER.equalsIgnoreCase("FIREFOX"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			Reporter.log("--Browser "+BROWSER+" launched successfully--",true);
		}
		else
		{
			System.out.println("invalid browser");
		}
		logs.message("url is successfully launched");
		
		sdriver = driver;
		wUtil.maximiseWindow(driver);
		wUtil.waitForElementsToLoadInDOM(driver);
		driver.get(URL);
	
	}
	
	@BeforeMethod(groups = {"SmokeSuite","RegressionSuite"})
	public void bmConfig() throws IOException
	{

		Reporter.log("--Login Successful--", true);
	}
	
	@AfterMethod(groups = {"SmokeSuite","RegressionSuite"})
	public void amConfig()
	{

		Reporter.log("--Signout successfull--", true);
	}
	
	//@AfterTest
	@AfterClass(groups = {"SmokeSuite","RegressionSuite"})
	public void acConfig()
	{
		driver.close();
		Reporter.log("--browser closed successfull--", true);
	}
	
	@AfterSuite(groups = {"SmokeSuite","RegressionSuite"})
	public void asConfig() throws SQLException
	{
		//dUtil.closeDB();
		Reporter.log("--Database close successfull--", true);
	}
}



