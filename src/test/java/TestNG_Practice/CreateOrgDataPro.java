package TestNG_Practice;

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
import Pom_Repo.HomePage;
import Pom_Repo.LoginPage;
import Pom_Repo.OrganizationPage;

public class CreateOrgDataPro {
	
	@Test(dataProvider = "getOrgData")
	public void createOrg(String orgName, String number, String emailId ) throws Throwable {
		
		
		File_Utility fUtil = new File_Utility();
		String BROWSER = fUtil.getKeyAndValue("Browser");
		String URL1 = fUtil.getKeyAndValue("url");
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
		driver.get(URL1);
		 LoginPage login = new LoginPage(driver);
	     login.loginToApp(Username, Password);
	     
	     HomePage home = new HomePage(driver);
	     home.clickToOrgLink();
	     
	     OrganizationPage org = new OrganizationPage(driver);
	     org.OrganiztionLookUpImage();
	     org.organizationDetails(orgName, number, emailId);
	     org.clickToSaveButton();
	     Thread.sleep(2000);
	     driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
			driver.findElement(By.linkText("Sign Out")).click();
			driver.quit();
	     
	}
	@DataProvider
	public Object[][] getOrgData() throws Throwable {
		
		Excel_Utility eLib = new Excel_Utility();
		Object[][] data = eLib.readOrgDataDataProvider("orgData");
		
		
		
		return data;
		
	}

}
