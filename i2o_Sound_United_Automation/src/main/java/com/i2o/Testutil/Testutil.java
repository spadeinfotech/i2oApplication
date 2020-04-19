package com.i2o.Testutil;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
import com.i2o.base.TestBase;

public class Testutil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 240;
	public static long IMPLICIT_WAIT = 30;

	public static String TESTDATA_SHEET_PATH = "C:\\Ankit-WorkArea\\Automation projects\\A3-Portal\\src\\main\\java\\com\\A3portal\\qa\\testdata\\TestData.xlsx";

	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js;
	

	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}
	
	

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}

	public static  void takeScreenshotAtEndOfTest() throws IOException {
		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		Files.copy(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));	

		//FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	
	}

	public static void runTimeInfo(String messageType, String message) throws InterruptedException {
		js = (JavascriptExecutor) driver;
		// Check for jQuery on the page, add it if need be
		js.executeScript("if (!window.jQuery) {"
				+ "var jquery = document.createElement('script'); jquery.type = 'text/javascript';"
				+ "jquery.src = 'https://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js';"
				+ "document.getElementsByTagName('head')[0].appendChild(jquery);" + "}");
		Thread.sleep(5000);

		// Use jQuery to add jquery-growl to the page
		js.executeScript("$.getScript('https://the-internet.herokuapp.com/js/vendor/jquery.growl.js')");

		// Use jQuery to add jquery-growl styles to the page
		js.executeScript("$('head').append('<link rel=\"stylesheet\" "
				+ "href=\"https://the-internet.herokuapp.com/css/jquery.growl.css\" " + "type=\"text/css\" />');");
		Thread.sleep(5000);

		// jquery-growl w/ no frills
		js.executeScript("$.growl({ title: 'GET', message: '/' });");
//'"+color+"'"
		if (messageType.equals("error")) {
			js.executeScript("$.growl.error({ title: 'ERROR', message: '"+message+"' });");
		}else if(messageType.equals("info")){
			js.executeScript("$.growl.notice({ title: 'Notice', message: 'your notice message goes here' });");
		}else if(messageType.equals("warning")){
			js.executeScript("$.growl.warning({ title: 'Warning!', message: 'your warning message goes here' });");
		}else
			System.out.println("no error message");
		// jquery-growl w/ colorized output
//		js.executeScript("$.growl.error({ title: 'ERROR', message: 'your error message goes here' });");
//		js.executeScript("$.growl.notice({ title: 'Notice', message: 'your notice message goes here' });");
//		js.executeScript("$.growl.warning({ title: 'Warning!', message: 'your warning message goes here' });");
		Thread.sleep(5000);
	}
	
	public static void getCookies() {
		//Cookie cook;
	
		try { // Delete if any old file exists
		file.delete();
		file.createNewFile();
		FileWriter fileWriter = new FileWriter(file);
		BufferedWriter bufferwrite = new BufferedWriter(fileWriter);
		
		for( Cookie cook : driver.manage().getCookies()){
		String writeup = cook.getName()+";"+cook.getValue()+";"+cook.getDomain()+";"+cook.getPath()+""
		+ ";"+cook.getExpiry()+";"+cook.isSecure();
		bufferwrite.write(writeup);
		//System.out.println(writeup);
		bufferwrite.newLine();
		}
		bufferwrite.flush();
		bufferwrite.close();
		fileWriter.close();
		}catch(Exception exp){
		exp.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public static void setCookies() {
		try{
			file = new File(".\\cookies.data");
			FileReader fileReader = new FileReader(file);
			BufferedReader Buffreader = new BufferedReader(fileReader);
			String strline;
			while((strline=Buffreader.readLine())!=null){
			StringTokenizer token = new StringTokenizer(strline,";");
			while(token.hasMoreTokens()){
			String name = token.nextToken();
			
			String value = token.nextToken();
			
			String domain = token.nextToken();
		
			String path = token.nextToken();
			
			Date date=null;
			String val;
			if(!(val=token.nextToken()).equals("null")){
			String dateStr = "Mon Jun 18 00:00:00 IST 2012";
			DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
			 date = (Date)formatter.parse(val);
			}
			
			
			
			/*
			Date expiry = null;
			
			String val;
			if(!(val=token.nextToken()).equals("null")){
		//	expiry = new Date(val);
			expiry=new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss").parse(val);  
		
			}
			*/
			Boolean isSecure = new Boolean(token.nextToken()).booleanValue();
			Cookie ck = new Cookie(name,value,domain,path,date,isSecure);
			//Cookie ck = new Cookie("session-token","ujbV0eHomkDm+KzXWnD9u379SbE7xYbxIJaeqv9MftHDYFXb507KMjueLMp3u4r9hxkWCq6USNyboun8Dqa8ewb/cNdE3B90RXFoDfmNLRSrVq/RoffdkdMDWVAsseI2ozJUb/ssyIdXI95szQdSBDAbb2Z4Te0v3ed6C5rLUO8tDp+gQvNzgEJMGUSXxVmsVpBmGKFZLGr6KY36uuqTiWCA1y7v+ywtWKXJ6j+9GOE=",
			//	"amazon.com","/",expiry,false);
			
			driver.manage().addCookie(ck); // This will add the stored cookie to our current session
			}
			}
			}catch(Exception ex){
			ex.printStackTrace();
			}
	}
	public static void explicitwait() { 
	 WebDriverWait wait=new WebDriverWait(driver, 20);
	}
}
