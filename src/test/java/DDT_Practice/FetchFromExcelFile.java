package DDT_Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchFromExcelFile {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/LoginTest.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("login");
		
		
//		FileInputStream fis = new FileInputStream("C:\\Users\\HP\\Desktop\\LoginTest.xlsx");
//		Workbook wb = WorkbookFactory.create(fis);
//		Sheet sheet = wb.getSheet("login");
//		//Row r = sh.getRow(1);
		
		Row row = sheet.getRow(1);
		String cell = row.getCell(0).getStringCellValue();
		System.out.println(cell);
	}

}
