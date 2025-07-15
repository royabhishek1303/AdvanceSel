package DDT_Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchLinkFromSheet {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/LoginTest.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("login");
		
		int count=0;
		int rowNumber = sheet.getLastRowNum();
		for(int i=0; i<rowNumber; i++) {
			Row row = sheet.getRow(i);
			Cell cell = row.getCell(0);
			String links = cell.getStringCellValue();
			
			System.out.println(links);
			count++;
		}
		System.out.println(count);
			}


}
