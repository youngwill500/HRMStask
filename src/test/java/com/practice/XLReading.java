package com.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class XLReading {
	
	@Test
	public void read() throws IOException {
		String filePath = System.getProperty("user.dir")+"Users/12406/Desktop/Hello";
		FileInputStream fis = new FileInputStream(filePath);
		//to read excel we need to use different classes
		//Workbook wbook = HSSFWorkbook() --> 2003 xfiles
		Workbook wbook = new XSSFWorkbook(fis); //2007 files
		Sheet xlsheet = wbook.getSheet("Sheet 1");
		Row row = xlsheet.getRow(0);
		Cell cell = row.getCell(0);
		String value = cell.toString();
		
		System.out.println(value);
	}
	

}
