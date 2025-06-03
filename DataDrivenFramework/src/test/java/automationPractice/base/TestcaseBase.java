package automationPractice.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utilities.DataUtil;
import utilities.ExcelReader;


public class TestcaseBase {
   
	public static WebDriver driver;
	public static FileInputStream file;
	public static FileInputStream files;
	public static Properties config;
	public static Properties or;
	public static SoftAssert softassert;
	public static WebDriverWait wait;
	public ExcelReader excel = new ExcelReader("D:/workspace/DataDrivenFramework/src/test/resources/excel/testData.xlsx");
	//Logger logs = Logger.getLogger("");
	 public static Logger log = LogManager.getLogger(TestcaseBase.class);
	public static ExtentTest test;
	public static JavascriptExecutor js;
	public static String browser;
	
		
	
	
	@BeforeClass
	public void setUp() {
		
		ChromeOptions options = new ChromeOptions();
    	//options.addArguments("--disable-notifications");
		
		//to remove adds
	    //options.addArguments("user-data-dir=C:/Users/rahul/AppData/Local/Google/Chrome/User Data");
	    //options.addArguments("profile-directory=default"); 
		log.info("execution started !!!");
		System.getProperty("user.dir");
		config = new Properties();
		or = new Properties();
		try {
			file = new FileInputStream (System.getProperty("user.dir")+"/src/test/resources/properties/Config.properties");
			config.load(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			files = new FileInputStream (System.getProperty("user.dir")+"/src/test/resources/properties/OR.properties");
			or.load(files);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*if(System.getenv("browser")!=null && !System.getenv("browser").isEmpty()) {
			
			browser= System.getenv("browser");
			
		}else {
			
			browser = System.getProperty("browser");
		}
		
		config.setProperty("browser", browser);*/
		
		
		if(config.getProperty("browser").equalsIgnoreCase("chrome")) {
			
			driver= new ChromeDriver();
		}else if(config.getProperty("browser").equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}else if(config.getProperty("browser").equalsIgnoreCase("fireFox")) {
			driver = new FirefoxDriver();
		}
		
		driver.get("https://automationexercise.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		softassert = new SoftAssert();
		//config.getProperty("browser");
		//System.out.println(config.getProperty("browser"));
		String va = or.getProperty("login_Xpath");
		 js = (JavascriptExecutor) driver;
		System.out.print(va);
	}
	@AfterClass
	public void tearDown() {
     //this will quit only when driver is not empty
		if(driver!=null) {
        driver.quit();}
	
	
	
}
	
	

	
	
	
public void click(String locators) {
	
	if(locators.endsWith("Xpath")){		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty(locators)))).click();
		test.log(Status.INFO, "clicking on locator: "+locators);
	}else if (locators.endsWith("CSS")) {
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(or.getProperty(locators)))).click();
	}else if (locators.endsWith("ID")) {
		wait.until(ExpectedConditions.elementToBeClickable(By.id(or.getProperty(locators)))).click();
	}
	
	
}

public void type(String locators, String value) {
	
	if(locators.endsWith("Xpath")){		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty(locators)))).sendKeys(value);
		test.log(Status.INFO, "typing on locator: "+locators+ " Value is: "+value);
	}else if (locators.endsWith("CSS")) {
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(or.getProperty(locators)))).sendKeys(value);
	}else if (locators.endsWith("ID")) {
		wait.until(ExpectedConditions.elementToBeClickable(By.id(or.getProperty(locators)))).sendKeys(value);
	}
	
	
}





}
