package com.qa.automation.Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.automation.TestBase.TestBase;

public class ExcelHandler extends TestBase {
	FileInputStream file;
	XSSFWorkbook workbook;
	
	@DataProvider(name="logindata")
	public String[][] testData(){
		String path=System.getProperty("user.dir")+"/src/main/java/com/qa/automation/TestData/testdata.xlsx";
		try
		{FileInputStream file=new FileInputStream(path);
		workbook=new XSSFWorkbook(file);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int rowcount = sheet.getLastRowNum();
		int columncount = sheet.getRow(0).getLastCellNum();
		
		String[][] data =new String[rowcount][columncount];
		for(int i=0;i<rowcount;i++) {
			for(int j=0;j<columncount;j++) {
				DataFormatter df=new DataFormatter();
				data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
			}
		}
		return data;
	}
}
