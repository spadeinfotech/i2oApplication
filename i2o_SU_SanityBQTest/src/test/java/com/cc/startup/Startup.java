package com.cc.startup;

import org.junit.runner.JUnitCore;
import org.testng.annotations.Test;

import com.cc.readexcel.ExcelLibrary;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class Startup {
  @Test
  public void RuntestSuite() throws EncryptedDocumentException, InvalidFormatException, IOException {
	  
	  ExcelLibrary lib=new ExcelLibrary();
	  int totaltests=lib.Getrowcount("scenarios");
	  System.out.println("totaltests"+totaltests);
	  for(int testscenario=1;testscenario<=totaltests;testscenario++) {
	  	
	  	String executionstatus=lib.getExcelValue("scenarios", testscenario, 1);
	  	System.out.println("executionstatus"+executionstatus);
//	  	System.out.println(executionstatus);
	  	if(executionstatus.equalsIgnoreCase("yes")) {
	  String scenarioname=lib.getExcelValue("scenarios", testscenario, 0);
	  System.out.println("********************scenario name******************************"+scenarioname);

	  JUnitCore runTest = new JUnitCore();
	  @SuppressWarnings("rawtypes")
	  Class c;
	  try {
	  	
	  	c = Class.forName("com.cc.testcases."+scenarioname);
	  	
	  	System.out.println(c);
	  	runTest.run(c);
	  	} catch (ClassNotFoundException e) {
	  	// TODO Auto-generated catch block
	  	e.printStackTrace();
	       }	

	  }
	  	
	  	}
  }
}
