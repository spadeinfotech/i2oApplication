package com.cc.utils;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.cc.readexcel.ExcelLibrary;

public class UtilServices {

	public void getPreAndMartDiff(String scenarioname, ExcelLibrary lib) throws EncryptedDocumentException, InvalidFormatException, IOException {
		Double PrestageVal = 0.0;
		Double Martval = 0.0;
		Double countdifference = 0.0;
		int Totalteststeps = lib.Getrowcount(scenarioname);
	for (int teststep = 1; teststep <= Totalteststeps; teststep++) {	
		PrestageVal = lib.getExcelValueInt(scenarioname, teststep, 5);
		Martval = lib.getExcelValueInt(scenarioname, teststep, 6);
		countdifference = PrestageVal - Martval;
		lib.setExcelValueInt(scenarioname, teststep, 7, countdifference);

		if (countdifference == 0.0) {
			System.out.println("matching condition");
			lib.setExcelValue(scenarioname, teststep, 8, "Pass");

		} else if (Double.compare(countdifference, Double.valueOf(0.0)) > 0
				|| Double.compare(countdifference, Double.valueOf(0.0)) < 0) {
			lib.setExcelValue(scenarioname, teststep, 8, "Fail");
			System.out.println("not matching condition");
		}
		}
	}

}
