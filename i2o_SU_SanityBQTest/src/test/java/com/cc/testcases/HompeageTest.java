package com.cc.testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Test;

import com.cc.ExecuteBQ.Testexecutor;
import com.cc.filereader.ReadWER;
import com.cc.readexcel.ExcelLibrary;
import com.cc.utils.UtilServices;

public class HompeageTest {
	 ExcelLibrary lib=new ExcelLibrary();
	ReadWER wer=new ReadWER();
	public UtilServices utilServices = new UtilServices();
	@Test
	public void test() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		 System.out.println("under  Homepage test");
	Testexecutor Te=new Testexecutor();
	Te.GetDatafromPrestageBQ(this.getClass().getSimpleName());
	System.out.println("after prestage");
	Te.GetDatafromDataMartBQ(this.getClass().getSimpleName());
	
	this.utilServices.getPreAndMartDiff(this.getClass().getSimpleName(), lib);
	
	}

	
}
