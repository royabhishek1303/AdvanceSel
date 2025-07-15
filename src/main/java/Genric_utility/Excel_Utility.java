package Genric_utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
	
	public String readDataFromExcel(String sheetName, int rowNum, int cellNo) throws Throwable {
	FileInputStream fis = new FileInputStream("./src/test/resources/LoginTest.xlsx");
	Workbook book = WorkbookFactory.create(fis);
	Sheet sheet = book.getSheet(sheetName);
	
	Row row = sheet.getRow(rowNum);
	Cell cell = row.getCell(cellNo);
	String excelData = cell.getStringCellValue();
	return excelData;
	
	}
	public String readDataFromDataFormatter(String sheetName, int rowNum, int cellNo) throws Throwable {

		FileInputStream fis = new FileInputStream("./src/test/resources/LoginTest.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNo);
		
        DataFormatter format = new DataFormatter();
        
		
		String excelData = format.formatCellValue(cell);
		System.out.println(excelData);
		return excelData;
		
		}
	
	public  Object[][] readDataUsingDAtaProvider(String SheetName) throws Throwable
	{
		
		FileInputStream fes = new FileInputStream("./src/test/resources/LoginTest.xlsx");

		// step2:- keeps the workbook/Excel file in read mode
		Workbook book = WorkbookFactory.create(fes);

		// step3:- Navigates into mentioned sheetname
		Sheet sheet = book.getSheet(SheetName);
		
		int lastRow = sheet.getLastRowNum()+1;
		
		int lastCell = sheet.getRow(0).getLastCellNum();
		
		Object[][] objArr = new Object[lastRow][lastCell];
		
		for(int i=0;i<lastRow;i++)
		{
			for (int j = 0; j < lastCell; j++)
			{
				objArr[i][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
		
		return objArr;
		
	}
	
	public Object [][] readOrgDataDataProvider(String sheetName) throws Throwable {
		
		FileInputStream file = new FileInputStream("./src/test/resources/LoginTest.xlsx");
		Workbook book = WorkbookFactory.create(file);
		Sheet sheet = book.getSheet(sheetName);
		int lastRow = sheet.getLastRowNum()+1;
		int lastcell = sheet.getRow(0).getLastCellNum();
		Object[][] objArr = new Object[lastRow][lastcell];
		
		for(int i =0; i<lastRow; i++) {
			for(int j=0; j<lastcell; j++) {
				objArr[i][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
		return objArr;
		
	}
}
	

