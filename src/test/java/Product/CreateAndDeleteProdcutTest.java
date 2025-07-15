package Product;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import javax.xml.xpath.XPath;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import Genric_utility.Base_Class;
import Genric_utility.Excel_Utility;
import Genric_utility.File_Utility;
import Genric_utility.Java_Utility;
import Genric_utility.Web_Driver_Utility;
import Pom_Repo.CampLookUpImage;
import Pom_Repo.DeleteProduct;
import Pom_Repo.HomePage;
import Pom_Repo.LoginPage;
import Pom_Repo.ProductPage;


public class CreateAndDeleteProdcutTest extends Base_Class{
	
	@Test
	public void createAndDeleteProdcutTest() throws Throwable {

	
	     
	     HomePage home = new HomePage(driver);
	     home.clickToProdLink();
	     
	     CampLookUpImage lookUp=new CampLookUpImage(driver);
	     lookUp.clickProdLookUp();
			ProductPage prodPage= new ProductPage(driver);
		

	     
		
	     Java_Utility jUtil=new Java_Utility();
			int rand = jUtil.getRandom();
			Excel_Utility eUtil=new Excel_Utility();
			String data = eUtil.readDataFromExcel("Product", 0, 0)+rand;
			
			prodPage.clickProductName(data);
			  prodPage.saveButton();

		home.clickToProdLink();
		Thread.sleep(2000);
		
		DeleteProduct deleteProduct = new DeleteProduct(driver);
		deleteProduct.deleteProduct(driver, data);

		 Web_Driver_Utility wdu = new Web_Driver_Utility();
		  wdu.alertHandling(driver);
		//wdu.alertHandling(driver);
		
		deleteProduct.validateDeleteProduct(driver, data);
		
		//deleteProduct.signOut();
		
		

	


}
	@Test
	public void m2() {
		System.out.println("m2 executed");
	}
}
