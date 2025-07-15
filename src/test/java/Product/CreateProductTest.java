package Product;

import java.io.File;
import java.time.Duration;

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
import Pom_Repo.HomePage;
import Pom_Repo.LoginPage;
import Pom_Repo.ProductPage;
import Pom_Repo.ProductValidation;


public class CreateProductTest extends Base_Class {

	@Test
	public void createProductTest() throws Throwable {

		

		     
		     HomePage home = new HomePage(driver);
		     home.clickToProdLink();

		     
		     CampLookUpImage lookUp=new CampLookUpImage(driver);
		     lookUp.clickProdLookUp();

		     Java_Utility jUtil=new Java_Utility();
				int rand = jUtil.getRandom();
				Excel_Utility eUtil=new Excel_Utility();
				String data = eUtil.readDataFromExcel("Product", 0, 0)+rand;
				
				ProductPage prodPage= new ProductPage(driver);
				prodPage.clickProductName(data);
				  prodPage.saveButton();


		
		ProductValidation validateProduct = new ProductValidation(driver);
		validateProduct.validationProductData(driver, data);
		
	       // prodPage.signOut();

	}

}

