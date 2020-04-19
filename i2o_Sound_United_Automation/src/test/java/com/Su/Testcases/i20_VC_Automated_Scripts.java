package com.Su.Testcases;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.i2o.Testutil.ExceptionhadlingClass;
import com.i2o.base.TestBase;
import com.i2o.readExl.excellibrary;
import com.i2o.readExl.readWER;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class i20_VC_Automated_Scripts extends TestBase {
public WebElement element=null;
public excellibrary lib=new excellibrary();
public Select streamdropdown=null;
String streamm=null;
public String executionstatus=null;
public readWER wer=new readWER();
public static int teststep=0;
public ExceptionhadlingClass Setcounttoexcel=new ExceptionhadlingClass();
private String brandnameaa;

@BeforeMethod
public void go() throws InterruptedException{
	VCinitialization();
	
}

@AfterMethod
public void Closebrowser() throws InterruptedException{
	// executionstatus=readWER.getElementFromWER("Deployementtype", "config/config.properties");

	//if(executionstatus.equalsIgnoreCase("post")) {
		//SendEmail sendmail=new SendEmail();
		//sendmail.SendReportVIAemail();
	//Thread.sleep(10000);
	//closeDriver();
	closeDriver();
}


@Test(enabled=false)
public void testdata() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
/*
	public int countVC=0;
	public int countdashboard;
	public int countdifference=0;
	countdashboard=lib.getExcelValueInt("Sales Metrics", 1, 5);
	System.out.println("countdashboard"+countdashboard);
//	lib.setExcelValue("Sales Metrics", teststep, 6, totalcourcount);
	countVC=lib.getExcelValueInt("Sales Metrics", 1, 6);
	System.out.println("countVC"+countVC);
	    
   int countdifference=countdashboard-countVC;
 lib.setExcelValueInt("Sales Metrics", teststep, 7, countdifference);
 */
}

@Test(enabled=true,priority=1)
public void Validatesalesdata() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
	
	WebDriverWait wait=new WebDriverWait(driver, 60); 
	String screenname="Sales Metrics";
	 teststep=1;
	element=driver.findElement(By.xpath("//img[@id='logo_topNav']"));
	wait.until(ExpectedConditions.visibilityOf(element)); 
	//element=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/div[5]/div[2]/div/div[1]/span[3]/div/awsui-button-dropdown/div/button/span[1]/span/span/strong"));
	//wait.until(ExpectedConditions.visibilityOf(element));
	System.out.println("dashboard displayed");
	driver.navigate().to("https://vendorcentral.amazon.com/analytics/dashboard/salesDiagnostic");
	//element.click();
	Thread.sleep(10000);
	driver.findElement(By.xpath("//strong[text()='Manufacturing']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[@href='#'][contains(.,'Sourcing')]")).click();
	driver.findElement(By.xpath("//*[@id='dashboard-filter-viewFilter']/div/awsui-button-dropdown/div/button/span[1]/span/span/strong")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id='dashboard-filter-viewFilter']/div/awsui-button-dropdown/div/div/ul/li[2]/a")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id='dashboard-filter-applyCancel']/div/awsui-button[2]/button")).click();
	
	Thread.sleep(10000);

	String T1cogs="//*[@id='salesDiagnosticDetail']/div/div[5]/div/div[1]/div[3]/div[1]/div/div[1]/div[2]/div/div[24]/div/div/div/div";
	Setcounttoexcel.Setvaltoexcelwithexception(T1cogs, screenname, teststep++);
	 Thread.sleep(2000);
	
	String T2cogs="//*[@id='salesDiagnosticDetail']/div/div[5]/div/div[1]/div[3]/div[4]/div/div[1]/div[2]/div/div[24]/div/div/div/div";
      Setcounttoexcel.Setvaltoexcelwithexception(T2cogs, screenname, teststep++);
     
      String T3cogs="//*[@id='salesDiagnosticDetail']/div/div[5]/div/div[1]/div[3]/div[3]/div/div[1]/div[2]/div/div[24]/div/div/div/div";
      Setcounttoexcel.Setvaltoexcelwithexception(T3cogs, screenname, teststep++);
       
      
      String T4cogs="//*[@id='salesDiagnosticDetail']/div/div[5]/div/div[1]/div[3]/div[2]/div/div[1]/div[2]/div/div[24]/div/div/div/div";
      Setcounttoexcel.Setvaltoexcelwithexception(T4cogs, screenname, teststep++);
      
      String T5cogs="//*[@id='salesDiagnosticDetail']/div/div[5]/div/div[1]/div[3]/div[5]/div/div[1]/div[2]/div/div[24]/div/div/div/div";
      Setcounttoexcel.Setvaltoexcelwithexception(T5cogs, screenname, teststep++);
      
      
      
      
      
      
      
      /*
    	lib.setExcelValue(screenname, teststep++, 5, "16");

    	driver.navigate().to("https://vendorcentral.amazon.com/analytics/dashboard/salesDiagnostic");
    	Thread.sleep(10000);
      String T1BBW="//*[@id='salesDiagnosticDetail']/div/div[5]/div/div[1]/div[3]/div[1]/div/div/div[2]/div/div[49]/div/div/div/div";

      
  	Setcounttoexcel.Setvaltoexcelwithexception(T1BBW, screenname, teststep++);
  	
  	lib.setExcelValue(screenname, teststep++, 5, "46");
  	
    String T1REPOOS="//*[@id='salesDiagnosticDetail']/div/div[5]/div/div[1]/div[3]/div[1]/div/div/div[2]/div/div[46]/div/div/div/div";
  	Setcounttoexcel.Setvaltoexcelwithexception(T1REPOOS, screenname, teststep++);
  	*/
 
  	 Thread.sleep(2000);
  	

 
      
}





@SuppressWarnings({ "null", "unlikely-arg-type" })
@Test(enabled=false,priority=1)
public void switchtoeachAccounts() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
	System.out.println("logged-IN into the application");
	WebDriverWait wait=new WebDriverWait(driver, 60); 
	List<WebElement> brands=null;

	WebElement switchAccountbuttonout=null;
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(text(),'Switch accounts')]"))));
	switchAccountbuttonout=driver.findElement(By.xpath("//a[contains(text(),'Switch accounts')]"));

	switchAccountbuttonout.click();
	Thread.sleep(2000);
	
   brands=driver.findElements(By.xpath("//*[@id=\"vendor-group-switch-account-form\"]/div[1]/div/div/div/div"));
	//System.out.println("items"+brands.size());
	

 
   String brandname=null;
   
   ArrayList<String> brandnamesinStringArray=new ArrayList<String>();
	for(int brand=0;brand<brands.size();brand++) {
		 brandname=brands.get(brand).getText().trim();
		System.out.println("brandname="+brandname);
		brandnamesinStringArray.add(brandname);
	  }
	
	
	System.out.println("brandname in string list"+brandnamesinStringArray);
		WebElement switchAccountbuttonInside=driver.findElement(By.xpath("//*[@id='vendor-group-switch-confirm-button']"));
		switchAccountbuttonInside.click();
		
		//Do some activity here
		System.out.println("url"+driver.getCurrentUrl());
		Thread.sleep(8000);
		
		
		//switching to next account again
		//switchAccountbuttonout.click();
		driver.findElement(By.xpath("//a[contains(text(),'Switch accounts')]")).click();
		Thread.sleep(2000);
		if(brandnamesinStringArray.equals("US - Marantz (Sound United)")) {
			WebElement radiobutton=driver.findElement(By.xpath("(//input[@type='radio'])[4]"));
			radiobutton.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='vendor-group-switch-confirm-button']/span")).click();
		}
		


	
	
	
}


}
