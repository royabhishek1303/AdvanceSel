package TestNG_Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Genric_utility.Excel_Utility;
import Genric_utility.File_Utility;
import Genric_utility.Web_Driver_Utility;
import Pom_Repo.LoginPage;

public class DataProviderExcelEx3 {

	@Test(dataProvider = "readContactData")
	public void createContact(String firstname, String Lastname) throws Throwable {
		
		File_Utility fUtil = new File_Utility();
		String BROWSER = fUtil.getKeyAndValue("Browser");
		String URL = fUtil.getKeyAndValue("url");
		String Password = fUtil.getKeyAndValue("password");
		String Username = fUtil.getKeyAndValue("username");
		
		WebDriver driver;
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
			
		}else {
			driver=new FirefoxDriver();
		}
	    Web_Driver_Utility wdu = new Web_Driver_Utility();
	    wdu.maximizeWindow(driver);
	    wdu.waitElmentsToLoad(driver);
		driver.get(URL);
		 LoginPage login = new LoginPage(driver);
	     login.loginToApp(Username, Password);
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("firstname")).sendKeys(firstname);
		driver.findElement(By.name("lastname")).sendKeys(Lastname);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
		
	}
	
//	@DataProvider
//	public Object[] [] readContactData() throws Throwable {
//		
//		Excel_Utility exUtil = new Excel_Utility();		
//		Object[][] Data = exUtil.readDataUsingDAtaProvider("Contact");
//		return Data;
//		
//	}
//}
	@DataProvider
	public Object[][] readContactData() throws Throwable
	{
		
	Excel_Utility elib = new Excel_Utility();
		
	Object[][] data = elib.readDataUsingDAtaProvider("Contact");
	return data;	
		
		
		
	}
}
