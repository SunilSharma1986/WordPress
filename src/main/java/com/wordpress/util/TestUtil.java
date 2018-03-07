package com.wordpress.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestUtil {

	
	public static Workbook book;
	public static Sheet sheet;
	public static Hashtable<String, String> table;
	
	
	
	
	//Method to get data from the excel
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(DSConstants.TEST_DATA_SHEET_PATH);
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
	
	
	@DataProvider
	public Object[][] getRunMode()
	{
		Object[][] data = TestUtil.getTestData("TestCases");
		return data;
	}
	
	@Test(dataProvider="getRunMode")
	public static boolean isTestExecutable(String RunMode, String TestCase_Name)
	{
		String runMode="Y";
		if(RunMode.equals(runMode))
		
			return true;
		
		else
			return false;
	}
	
	
	//Function to select the Environment
	
	public static Hashtable<String, String> getEnv()
	{
		if(table==null)
		{
			table=new Hashtable<String, String>();
			if(DSConstants.ENV.equalsIgnoreCase("PROD"))
			{
				table.put("url", DSConstants.PROD_DS_URL);
				table.put("username", DSConstants.PROD_USERNAME);
				table.put("password", DSConstants.PROD_PASSWORD);
			}else
				if(DSConstants.ENV.equalsIgnoreCase("QA1"))
				{
					table.put("url", "");
					table.put("username", "");
					table.put("password", "");
				}
		}
		return table;
	}
	
}
