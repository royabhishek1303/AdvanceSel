package Campaigns;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.math3.stat.descriptive.summary.Product;
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
import Pom_Repo.CreateCampPage;
import Pom_Repo.HomePage;
import Pom_Repo.LoginPage;
import Pom_Repo.ProductPage;
import Pom_Repo.WindowSwitching;

//@Listeners(Genric_utility.ListnenerImp.class)
public class CreateCapaingnsProductTest extends Base_Class {
	
	@Test
	public void createCapaingnsProductTest() throws Throwable {
	

	     HomePage home = new HomePage(driver);
	     home.clickToProdLink();
	
	     CampLookUpImage lookUp=new CampLookUpImage(driver);
	     lookUp.clickProdLookUp();
		Java_Utility jUtil=new Java_Utility();
		int rand = jUtil.getRandom();
		Excel_Utility eUtil=new Excel_Utility();
		String data = eUtil.readDataFromExcel("Product", 0, 0)+rand;
		String data1 = eUtil.readDataFromExcel("camp", 0, 0)+rand;
		ProductPage prodPage = new ProductPage(driver);
		prodPage.clickProductName(data);
		
		prodPage.saveButton();
		
		home.clickToMoreLink();
	
		lookUp.clickCampLookUp();
	
		CreateCampPage campPage = new CreateCampPage(driver);
		campPage.enterCampName(data1);
		
		
		WindowSwitching windowSwitch = new WindowSwitching(driver);
		windowSwitch.clickProdlookImg();
			
		Web_Driver_Utility webDriUtil = new Web_Driver_Utility();
		webDriUtil.windowSwitching(driver, "Products&action");
		windowSwitch.enterProdDetails(data);
		//Assert.fail("failing");

		windowSwitch.enterProdNameCamp(driver, data);
		
		webDriUtil.windowSwitching(driver, " Administrator - Campaigns - vtiger CRM 5 - Commercial Open Source CRM");
		
        prodPage.saveButton();
//      
		
	
	
	
	}

}
