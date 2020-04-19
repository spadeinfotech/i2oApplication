package com.i2o.Testutil;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.i2o.base.TestBase;

public class ExceptionhadlingClass extends TestBase {

	public static TeseExecutor te=new TeseExecutor();
	
	public void Setvaltoexcelwithexception(String element,String screenname,int teststep) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		String str=null;
		
		try {
			Thread.sleep(2000);
			System.out.println("element"+element);
			str=driver.findElement(By.xpath(element)).getText();
			
			
			
			System.out.println("str="+str);
		String strval = str.replaceAll("[$-+^:,]","");
			
		//int result = Integer.parseInt(strval);	
		
		  String strval2= strval.replaceAll("[^0-9]", "");
		  
				System.out.println("strval="+strval2);
		if(str!=null) {
			System.out.println("not null");
				te.SetCounttoExcel(teststep,screenname,strval2);
			}
		}catch(NoSuchElementException e) {
			System.out.println(" null");
			te.SetCounttoExcel(teststep,screenname,"0");
		}
		
	}







}
