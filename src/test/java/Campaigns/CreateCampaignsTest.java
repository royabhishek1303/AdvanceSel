package Campaigns;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import Genric_utility.Base_Class;
import Genric_utility.Excel_Utility;
import Genric_utility.File_Utility;
import Genric_utility.Java_Utility;
import Genric_utility.Web_Driver_Utility;
import Pom_Repo.CampLookUpImage;
import Pom_Repo.ContactPage;
import Pom_Repo.CreateCampPage;
import Pom_Repo.HomePage;
import Pom_Repo.LoginPage;
import Pom_Repo.ValidateCapaingnsPage;

//@Listeners(Genric_utility.ListnenerImp.class)
//@Listeners(Genric_utility.ExtentReportImp.class)
public class CreateCampaignsTest extends Base_Class {
	//@Test(retryAnalyzer = Genric_utility.RetryListenerImp.class)
	
	@Test
	
public void createCampaignsTest() throws Throwable {
	
//pulling------Pull1
		// push back
	//2ndPull
     HomePage homePage = new HomePage(driver);
    homePage.clickToMoreLink();
	
	
	
	
	CampLookUpImage campLook = new CampLookUpImage(driver);
	campLook.clickCampLookUp();
	CreateCampPage campPage = new CreateCampPage(driver);
	Java_Utility jlib = new Java_Utility();
	int rand = jlib.getRandom();
	
	Excel_Utility eutli = new Excel_Utility();
	String capName = eutli.readDataFromExcel("Sheet1", 0, 0)+rand;
	System.out.println(capName);
	campPage.enterCampName(capName);
	campPage.saveButton();
	//Assert.fail("failing the script ");
	
	ValidateCapaingnsPage validate = new ValidateCapaingnsPage(driver);
	validate.validationCampaingnsData(driver, capName);
	
	
	
}
	//---------------------------------------------------------------------------------------------------------------------------------------
	
	

}
