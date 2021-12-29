package com.crm.Autodesk.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	
	/**
	 * it is used to read the data from excel base on below argument
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @return
	 * @throws Throwable
	 */
	public String getDataFromExcel(String sheetName,int rowNum,int celNum ) throws Throwable {
	         FileInputStream fis =new FileInputStream("./data/testScriptData.xlsx");
	         Workbook wb = WorkbookFactory.create(fis);
	         Sheet sh = wb.getSheet(sheetName);
	         Row row = sh.getRow(rowNum);
	         String date = row.getCell(celNum).getStringCellValue();
	         wb.close();
			return date;
	          
}
	/**
	 * used to get the last used row number on specified Sheet
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @param data
	 * @return
	 * @throws Throwable 
	 */
	public int getRowCount(String sheetName,int rowNum,int celNum,String data) throws Throwable {
		FileInputStream fis =new FileInputStream("./data/testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
         wb.close();
         return sh.getLastRowNum();
	}

public void setDataExcel(String sheetName, int rowNum,int celNum,String data) throws Throwable {
	FileInputStream fis =new FileInputStream("./data/testScriptData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetName);
	Row row = sh.getRow(rowNum);
	Cell cell =row.createCell(celNum);
	cell.setCellValue(data);
	FileOutputStream fos = new FileOutputStream("./data/testScriptData.xlsx");
	wb.close();
}
}

