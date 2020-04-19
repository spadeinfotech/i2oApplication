package com.i2o.Testutil;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.i2o.readExl.excellibrary;
import com.i2o.readExl.readWER;

public class TeseExecutor {

	
	public excellibrary lib=new excellibrary();
	public static readWER wer=new readWER();
	public Double countVC=0.0;
	public Double countdashboard=0.0;
	public Double countdifference=0.0;
	
	public  String executionstatus=null;
public void SetCounttoExcel(int teststep,String screenname,String totalcourcount) throws IOException, EncryptedDocumentException, InvalidFormatException{
	
 executionstatus=readWER.getElementFromWER("Executiontype", ".\\src\\main\\java\\com\\i2o\\config\\config.properties");
	
	if(executionstatus.equalsIgnoreCase("VC")){
    lib.setExcelValue(screenname, teststep, 5, totalcourcount);
    teststep++;
//  lib.setExcelValue(screenname, teststep, 5, lib.getdateandtime());

	}
	else if(executionstatus.equalsIgnoreCase("App")){
	 //   lib.setExcelValue(screenname, teststep, 6, totalcourcount);
		
		countVC=lib.getExcelValueInt(screenname, teststep, 5);
		
		lib.setExcelValue(screenname, teststep, 6, totalcourcount);
		countdashboard=lib.getExcelValueInt(screenname, teststep, 6);    
       Double countdifference=countVC-countdashboard;
	 lib.setExcelValueInt(screenname, teststep, 7, countdifference);
	 
	 if(countdifference==0.0) {
		 System.out.println("matching loop");
		 lib.setExcelValue(screenname, teststep, 8, "Data Matched");
		 
	 }
	 else  if(Double.compare(countdifference, Double.valueOf(0.0)) > 0 || Double.compare(countdifference, Double.valueOf(0.0)) < 0 ) {
		 lib.setExcelValue(screenname, teststep, 8, "Data Mis-match");
		 System.out.println("not matching loop");
	 }
	  teststep++;
	 // lib.setExcelValue(screenname, teststep, 3, lib.getdateandtime());
}
	
}




	
	
	
	
}
