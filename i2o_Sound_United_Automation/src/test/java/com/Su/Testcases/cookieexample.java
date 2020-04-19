package com.Su.Testcases;


import org.testng.annotations.Test;

import com.i2o.Testutil.Testutil;
import com.i2o.base.TestBase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class cookieexample extends TestBase {
	

@Test
public static void initialization() throws InterruptedException{
		
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
		
		 file=new File(".\\GURUcookies.data");
		 
if (file.exists()==false)
		{
	
driver.get("http://demo.guru99.com/test/cookie/selenium_aut.php");

driver.findElement(By.name("username")).sendKeys("abc123");							
driver.findElement(By.name("password")).sendKeys("123xyz");							
driver.findElement(By.name("submit")).click();


Testutil.getCookies();

		}

else {
	
	driver.get("http://demo.guru99.com");
	cookieexample.setCookies();
	driver.get("http://demo.guru99.com/test/cookie/selenium_aut.php");
	
		
			
		Thread.sleep(30000);
		
		}
driver.quit();
}
@SuppressWarnings("deprecation")
public static void setCookies() {
	try{
		file = new File(".\\\\GURUcookies.data");
		FileReader fileReader = new FileReader(file);
		BufferedReader Buffreader = new BufferedReader(fileReader);
		String strline;
		while((strline=Buffreader.readLine())!=null){
		StringTokenizer token = new StringTokenizer(strline,";");
		while(token.hasMoreTokens()){
		String name = token.nextToken();
		System.out.println("name"+name);
		String value = token.nextToken();
		System.out.println("value"+value);
		String domain = token.nextToken();
		System.out.println("domain"+domain);
		String path = token.nextToken();
		System.out.println("path"+path);
		Date expiry = null;
		String val;
		if(!(val=token.nextToken()).equals("null")){
		//expiry = new Date(val);
		expiry=new Date();
		System.out.println("val"+val);
		}
		Boolean isSecure = new Boolean(token.nextToken()).booleanValue();
		 Cookie ck = new Cookie(name,value,domain,path,expiry,isSecure);
		
		
		driver.manage().addCookie(ck); // This will add the stored cookie to our current session
		}
		}
		}catch(Exception ex){
		ex.printStackTrace();
		}
}
} 
