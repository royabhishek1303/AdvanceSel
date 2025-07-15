package DDT_Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchFromPropertiesFile {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("F:\\javaLecture\\JavaProgram\\Browserchrome.properties");
	    //Workbook book = WorkbookFactory.create(fis);
		
		Properties pro = new Properties();
		pro.load(fis);
		String browser = pro.getProperty("Browser");
	    //System.out.println(browser);
		String url = pro.getProperty("url");
		String un = pro.getProperty("username");
		String pw = pro.getProperty("password");
	    
	   
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
