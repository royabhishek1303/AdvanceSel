package DDT_Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class InsertLinkIntoExcelFIle {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/LoginTest.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("login");
		
		
		
		
		
		
		
		
		WebDriver driver=new ChromeDriver();	
		driver.get("https://www.flipkart.com/");
		
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		for(int i = 0 ; i<links.size(); i++) {
			Row row = sheet.createRow(i);
			Cell cell = row.createCell(0);
			cell.setCellValue(links.get(i).getAttribute("href"));
		}
		
		FileOutputStream fos = new FileOutputStream("./src/test/resources/LoginTest.xlsx");
		book.write(fos);
		System.out.println("file created");
		book.close();
	}

}
