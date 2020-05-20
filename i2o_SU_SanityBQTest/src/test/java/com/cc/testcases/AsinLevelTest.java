package com.cc.testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Test;

import com.cc.ExecuteBQ.Testexecutor;
import com.cc.filereader.ReadWER;
import com.cc.readexcel.ExcelLibrary;
import com.cc.utils.UtilServices;

public class AsinLevelTest {
	  ExcelLibrary lib=new ExcelLibrary();
		public UtilServices utilServices = new UtilServices();
	ReadWER wer=new ReadWER();
	@Test
	public void test() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		 System.out.println("under  Asin Level test");
	Testexecutor Te=new Testexecutor();
	Te.getAllcolumnsPrestage(this.getClass().getSimpleName());
	 System.out.println("after prestgae");
	Te.getAllcolumnsDataMart(this.getClass().getSimpleName());
	 System.out.println("after datamart");
	this.utilServices.getPreAndMartDiff(this.getClass().getSimpleName(), lib);
	}
	

	
}
