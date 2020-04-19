package com.Su.Testcases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.i2o.Testutil.ExceptionhadlingClass;
import com.i2o.Testutil.Testutil;
import com.i2o.base.TestBase;
import com.i2o.readExl.excellibrary;
import com.i2o.readExl.readWER;



public class i20ApplicationSanityTest extends TestBase {
	

	public ExceptionhadlingClass Setcounttoexcel=new ExceptionhadlingClass();
	
	public WebElement element=null;
	public excellibrary lib=new excellibrary();
	public Select streamdropdown=null;
	String streamm=null;
	public String executionstatus=null;
	public readWER wer=new readWER();
	public static int teststep=0;
	Testutil util=new Testutil();
	
	@BeforeTest
	public void go() throws InterruptedException{
		 
		System.out.println("insideeee");
		i20initialization();
		
	}
	
	@AfterTest
	public void closedriver() throws InterruptedException{
	closeDriver();
		
	}
	
  @Test(priority=1, enabled=true)
  public void ValidateHomepage() throws InterruptedException, IOException, AWTException, EncryptedDocumentException, InvalidFormatException {
	  Thread.sleep(15000);
		System.out.println("in home page");	
	  Testutil.takeScreenshotAtEndOfTest();
	  
	System.out.println( driver.getCurrentUrl());
	
String cogs=	driver.findElement(By.xpath("/html/body/app-root/app-home/div/div/div[2]/div[2]/dashboard/div/div/div[2]/div[2]/ag-grid-angular/div/div[2]/div[1]/div[3]/div[2]/div/div/div[1]/div[1]/app-multi-format-cell-renderer/div/div[2]")).getText();
	
System.out.println("cogs"+cogs);

	 List<WebElement> allcogs=  driver.findElements(By.xpath("/html/body/app-root/app-home/div/div/div[2]/div[2]/dashboard/div/div/div[2]/div[2]/ag-grid-angular/div/div[2]/div[1]/div[3]/div[2]/div/div/div[1]"));
	 System.out.println("cogs list"+allcogs.size());
		 
	 for(int val=0; val<allcogs.size(); val++) {
		 System.out.println("dashboard value"+allcogs.get(val).getText());
		 
		 
	 }
	 
	 JavascriptExecutor js = (JavascriptExecutor) driver; 
	// js.executeScript("document.getElementById('enter element id').checked=true;");
js.executeScript("document.querySelector(\"#raphael-paper-2127 > g > g.raphael-group-2132-plots > g.raphael-group-2164-line > g > g.raphael-group-2191-plot-group > path:nth-child(5)\")\n" + 
		"");

Thread.sleep(3000);
	 //js.executeScript(js,Arguments);
	  
		 /*
		
		String T3cogs="//*[@id='route-container']/dashboard/div[3]/div/div[2]/div[2]/ag-grid-angular/div/div[2]/div[1]/div[3]/div[2]/div/div/div[3]/div[2]/child-cell/div/span[1]/span[2]";

		
		String T4cogs="//*[@id='route-container']/dashboard/div[3]/div/div[2]/div[2]/ag-grid-angular/div/div[2]/div[1]/div[3]/div[2]/div/div/div[4]/div[2]/child-cell/div/span[1]/span[2]";
	


		String T2cogs="//*[@id='route-container']/dashboard/div[3]/div/div[2]/div[2]/ag-grid-angular/div/div[2]/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/child-cell/div/span[1]/span[2]";
		


		String T5cogs="//*[@id='route-container']/dashboard/div[3]/div/div[2]/div[2]/ag-grid-angular/div/div[2]/div[1]/div[3]/div[2]/div/div/div[5]/div[2]/child-cell/div/span[1]/span[2]";
		*/
	
	
	   
  }
  
  @Test(priority=2,enabled=true)
  public void ValidateSalesAnalysis() throws InterruptedException, IOException, AWTException, EncryptedDocumentException, InvalidFormatException {
	  driver.findElement(By.xpath("//div[@class='grid-shadow-box full-height-30']"));
	  System.out.println( "Inside sales module");
		  	
	  driver.findElement(By.id("salesanalysis")).click();
WebDriverWait wait=new WebDriverWait(driver, 60);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),' Brand Analysis')]")));
	 Thread.sleep(8000);
	  System.out.println( driver.getCurrentUrl());
	  Testutil.takeScreenshotAtEndOfTest();
	  

	   
  }
  
  @Test(priority=3, enabled=true)
  public void ValidateA$E() throws InterruptedException, IOException, AWTException, EncryptedDocumentException, InvalidFormatException {

	  
	  driver.findElement(By.id("alertsexceptions")).click();
	  System.out.println( "Inside alertsexceptions module");
	  WebDriverWait wait=new WebDriverWait(driver, 60);
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='route-container']/app-alerts/div/div[3]/div/div[3]/div/ag-grid-angular/div/div[4]/span[1]")));
	  System.out.println( driver.getCurrentUrl());
	  Testutil.takeScreenshotAtEndOfTest();
	  
	 	   
  }
  @Test(priority=4,enabled=true)
  public void ValidatepriceMonitor() throws InterruptedException, IOException, AWTException, EncryptedDocumentException, InvalidFormatException {

	  
	  driver.findElement(By.id("pricemonitoralerts")).click();
	  System.out.println( "Inside pricemonitoralerts module");
	  WebDriverWait wait=new WebDriverWait(driver, 60);
 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='route-container']/price-monitor-alerts/div/div[3]/app-price-summary/div/div[3]/div/div[3]/div/div/ag-grid-angular/div/div[4]/span[1]")));
 System.out.println( driver.getCurrentUrl());	
 Testutil.takeScreenshotAtEndOfTest();
	  
	 	   
  }
  
  
  @Test(priority=5,enabled=true)
  public void ValidateResellermgmt() throws InterruptedException, IOException, AWTException, EncryptedDocumentException, InvalidFormatException {

	  
	  driver.findElement(By.id("newresellermanagement")).click();
	  System.out.println( "Inside newresellermanagement module");
	  WebDriverWait wait=new WebDriverWait(driver, 60);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='summaryRect']/table[2]/tr[1]/td[4]")));
	 System.out.println( driver.getCurrentUrl()); 
	Testutil.takeScreenshotAtEndOfTest();
	  
	 	   
  }
  @Test(priority=6,enabled=true)
  public void ValidateBCM() throws InterruptedException, IOException, AWTException, EncryptedDocumentException, InvalidFormatException {

	  
	  driver.findElement(By.id("brandcontentmonitoring")).click();
	  System.out.println( "Inside brandcontentmonitoring module");
	  WebDriverWait wait=new WebDriverWait(driver, 60);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='route-container']/app-brand-content-monitoring/div/app-brand-summary/div/div[4]/div/div[2]/div[2]/div/ag-grid-angular/div/div[4]/span[1]")));
		 System.out.println( driver.getCurrentUrl()); 
	  Testutil.takeScreenshotAtEndOfTest();
	  
	 	   
  }
  @Test(priority=7,enabled=true)
  public void Validatedetailreports() throws InterruptedException, IOException, AWTException, EncryptedDocumentException, InvalidFormatException {

	  
	  driver.findElement(By.id("newdetailtables")).click();
	  System.out.println( "Inside detailtables module");
	  WebDriverWait wait=new WebDriverWait(driver, 60);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-home/div/div/div[2]/div[2]/app-new-detail-tables/div/div[3]/app-report-component/div/app-data-grid/div/div/ag-grid-angular/div/div[2]/div[1]/div[3]/div[2]/div/div/div[1]")));
		 System.out.println( driver.getCurrentUrl()); 
	  Testutil.takeScreenshotAtEndOfTest();
	//driver.findElement(By.xpath("/html/body/app-root/app-home/div/div/div[2]/div[2]/app-new-detail-tables/div/div[3]/app-report-component/div/app-data-grid/div/div/ag-grid-angular/div/div[2]/div[1]/div[3]/div[2]/div/div/div[1]")) ; 
	 	   
	 List<WebElement> allcogs=  driver.findElements(By.xpath("/html/body/app-root/app-home/div/div/div[2]/div[2]/app-new-detail-tables/div/div[3]/app-report-component/div/app-data-grid/div/div/ag-grid-angular/div/div[2]/div[1]/div[3]/div[2]/div/div/div[1]"));
	 System.out.println("detailreport list"+allcogs.size());
		 
	 for(int val=0; val<allcogs.size(); val++) {
		 System.out.println("detailreport value"+allcogs.get(val).getText());
		 
		 
	 }
  }  
		
		/*   THIS CODE IS WRITTEN TO WRITE VALUES IN XL
		String screenname="Sales Metrics";
		teststep=1;
	  WebDriverWait wait=new WebDriverWait(driver, 120) ;
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='route-container']/dashboard/div[3]/div/div[2]/div[2]/ag-grid-angular/div/div[2]/div[1]/div[1]/div[2]/div/div/div[2]/div[3]/div/span[1]")));

	
	/*
	String revenue=	driver.findElement(By.xpath("//div[contains(text(),'Last Week Revenue')]")).getText();
	System.out.println("revenue="+revenue);
	
String units=	driver.findElement(By.xpath("//div[contains(text(),'Last Week Units')]")).getText();
	System.out.println("units="+units);

String BB=	driver.findElement(By.xpath("//div[contains(text(),'Last Week Buy Box')]")).getText();
	System.out.println("BB="+BB);
	
	driver.findElement(By.xpath("//span[contains(text(),'Product Alerts & Exceptions')]")).click();
*/

	 /*
	
	element=driver.findElement(By.xpath("//*[@id='route-container']/dashboard/div[3]/div/div[2]/div[2]/ag-grid-angular/div/div[2]/div[1]/div[3]/div[2]/div/div/div[1]/div[2]/child-cell/div"));
	String title = element.getAttribute("title");
	System.out.println("textt="+title);
	
	String P1cogs="//*[@id='route-container']/dashboard/div[3]/div/div[2]/div[2]/ag-grid-angular/div/div[2]/div[1]/div[3]/div[2]/div/div/div[1]/div[2]/child-cell/div/span[1]/span[2]";
	Setcounttoexcel.Setvaltoexcelwithexception(P1cogs, screenname, teststep++);
	
	
	String T3cogs="//*[@id='route-container']/dashboard/div[3]/div/div[2]/div[2]/ag-grid-angular/div/div[2]/div[1]/div[3]/div[2]/div/div/div[3]/div[2]/child-cell/div/span[1]/span[2]";
	Setcounttoexcel.Setvaltoexcelwithexception(T3cogs, screenname, teststep++);
	
	String T4cogs="//*[@id='route-container']/dashboard/div[3]/div/div[2]/div[2]/ag-grid-angular/div/div[2]/div[1]/div[3]/div[2]/div/div/div[4]/div[2]/child-cell/div/span[1]/span[2]";
	Setcounttoexcel.Setvaltoexcelwithexception(T4cogs, screenname, teststep++);


	String T2cogs="//*[@id='route-container']/dashboard/div[3]/div/div[2]/div[2]/ag-grid-angular/div/div[2]/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/child-cell/div/span[1]/span[2]";
	Setcounttoexcel.Setvaltoexcelwithexception(T2cogs, screenname, teststep++);


	String T5cogs="//*[@id='route-container']/dashboard/div[3]/div/div[2]/div[2]/ag-grid-angular/div/div[2]/div[1]/div[3]/div[2]/div/div/div[5]/div[2]/child-cell/div/span[1]/span[2]";
	Setcounttoexcel.Setvaltoexcelwithexception(T5cogs, screenname, teststep++);

	
*/	





  
}
