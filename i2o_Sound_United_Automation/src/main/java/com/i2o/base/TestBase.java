package com.i2o.base;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.tools.ant.types.selectors.TypeSelector.FileType;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.i2o.Testutil.Testutil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static File file;
	public static WebElement element=null;
	public static int teststep=0;
	//public  static EventFiringWebDriver e_driver;
	//public static WebEventListener eventListener;
	
	public TestBase(){
		try {
			prop = new Properties();
			//FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\com\\i2o\\config\\config.properties");
			FileInputStream configfis=new FileInputStream(".\\src\\main\\java\\com\\i2o\\config\\config.properties");
			
			prop.load(configfis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public static void i20initialization() throws InterruptedException{
		
		String browserName = prop.getProperty("browser");
	//	String browserName ="chrome";
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", ".\\geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}
		driver.manage().window().maximize();
		
		//driver.manage().timeouts().pageLoadTimeout(Testutil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Testutil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("URL"));
		Thread.sleep(6000);
		driver.findElement(By.xpath("//span[text()='Sign In']")).click();
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(prop.getProperty("i20username"));
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(prop.getProperty("i20password"));
		driver.findElement(By.xpath("//span[text()='Next']")).click();
	}
	
	
	@SuppressWarnings("unlikely-arg-type") 
	public static void VCinitialization() throws InterruptedException{
		
		String browserName = prop.getProperty("browser");
	//	String browserName ="chrome";
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", ".\\geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}
	
		
	//	e_driver = new EventFiringWebDriver(driver);https://datastudio.google.com/open/147DXJyvJBUPTacNlk6z829SPL3yZUoRI
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
	//	eventListener = new WebEventListener();
	//	e_driver.register(eventListener);
		//driver = e_driver;
		
		driver.manage().window().maximize();
	
		driver.manage().timeouts().pageLoadTimeout(Testutil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Testutil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
	
		
		file=new File(".\\cookies.data");
		 
if (file.exists()==false)
		{
	
driver.get(prop.getProperty("url1"));
Thread.sleep(2000);
driver.findElement(By.id("login-button-container")).click();
driver.findElement(By.id("ap_email")).sendKeys(prop.getProperty("username"));
driver.findElement(By.id("ap_password")).sendKeys(prop.getProperty("password"));
driver.findElement(By.name("rememberMe")).click();
driver.findElement(By.id("signInSubmit")).click();	


String actualtitle=driver.getTitle();
String expectedtitle="Two-Step Verification";

if(actualtitle.equals(expectedtitle)) {
	//wait to enter the OTP
	Thread.sleep(60000);
	driver.findElement(By.id("auth-signin-button")).click();
	Thread.sleep(4000);
}
else {
	driver.findElement(By.id("ap_password")).sendKeys(prop.getProperty("password")); 
	//wait to enter the CAPCTHA
	Thread.sleep(60000);
	driver.findElement(By.id("signInSubmit")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("auth-mfa-remember-device")).click();
	//wait to enter the OTP
		Thread.sleep(60000);
		driver.findElement(By.id("auth-signin-button")).click();
		Thread.sleep(60000);
		driver.findElement(By.id("auth-signin-button")).click();
}

Testutil.getCookies();
}

else {
	driver.get(prop.getProperty("url1"));
	driver.manage().deleteAllCookies();
	Testutil.setCookies();
	Thread.sleep(2000);
	//driver.navigate().to(prop.getProperty("url2"));
	driver.findElement(By.id("login-button-container")).click();
	driver.findElement(By.id("ap_email")).sendKeys(prop.getProperty("username"));	
	driver.findElement(By.id("ap_password")).sendKeys(prop.getProperty("password"));
	driver.findElement(By.name("rememberMe")).click();
	driver.findElement(By.id("signInSubmit")).click();
	Thread.sleep(2000);
	

 // Enable this Code when there is no captcha
 driver.findElement(By.id("login-button-container")).click();
//	driver.findElement(By.id("ap_email")).sendKeys(prop.getProperty("username"));	
	driver.findElement(By.id("ap_password")).sendKeys(prop.getProperty("password"));
	driver.findElement(By.name("rememberMe")).click();
	driver.findElement(By.id("signInSubmit")).click();	
	Thread.sleep(2000);


	 // Enable this Code when Captach is enabled by Amazon due to automated control
/*	
	element=driver.findElement(By.xpath("//h4[text()='Important Message!']"));
System.out.println(driver.findElement(By.xpath("//h4[text()='Important Message!']")).getText());
if(element.isDisplayed()==true) {
	driver.findElement(By.id("ap_password")).sendKeys(prop.getProperty("password")); 
	//wait to enter the CAPCTHA
	Thread.sleep(10000);
	//driver.findElement(By.id("signInSubmit")).click();
	 * */
	




}
	
	}
	
	

public static void closeDriver() throws InterruptedException{
		driver.quit();
	
	}
	
}
