package Organization;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Genric_utility.Base_Class;
import Genric_utility.Excel_Utility;
import Genric_utility.File_Utility;
import Genric_utility.Java_Utility;
import Genric_utility.Web_Driver_Utility;
import Pom_Repo.CampLookUpImage;
import Pom_Repo.HomePage;
import Pom_Repo.LoginPage;
import Pom_Repo.OrgValidation;
import Pom_Repo.OrganizationPage;
import Pom_Repo.ProductPage;
import Pom_Repo.ProductValidation;

public class CreateOrganizationLinkTest extends Base_Class {
	
    @Test
	public void createOrganizationLinkTest() throws Throwable {

		
      //branch1--smokeTest
    	//checking git bash
    	//Test
	     HomePage homePage = new HomePage(driver);
	     homePage.clickToOrgLink();
	 	OrganizationPage org = new OrganizationPage(driver);
	 	org.OrganiztionLookUpImage();
		

		
		
		Java_Utility jlib = new Java_Utility();
		int rand = jlib.getRandom();
		Excel_Utility eutli = new Excel_Utility();
		String orgName = eutli.readDataFromExcel("Sheet1", 2, 0)+rand;
		System.out.println(orgName);

	//	-----------------------------------------------------------------------------------

		
		String phoneNo = eutli.readDataFromDataFormatter("Sheet1", 3, 0)+rand;
		System.out.println(phoneNo);

	//---------------------------------------------------------------------------------------

		String emailId = eutli.readDataFromExcel("Sheet1", 4, 0)+rand;
		System.out.println(emailId);
		
	
		org.organizationDetails(orgName, phoneNo, emailId);
		org.clickToSaveButton();
		//Assert.fail("failing the script");
		OrgValidation orgVali = new OrgValidation(driver);
		orgVali.validateOrgPage(driver, orgName);



}
    //------------------------------------------------------------------------------------------------------------------------
    
   
}
