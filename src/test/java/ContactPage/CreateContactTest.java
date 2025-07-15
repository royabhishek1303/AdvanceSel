package ContactPage;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Genric_utility.Base_Class;
import Genric_utility.Excel_Utility;
import Genric_utility.File_Utility;
import Genric_utility.Web_Driver_Utility;
import Pom_Repo.ContactPage;
import Pom_Repo.ContactValidate;
import Pom_Repo.HomePage;
import Pom_Repo.LoginPage;
import Pom_Repo.ProductPage;


public class CreateContactTest extends Base_Class {
	
	
	//final code push
	@Test(groups = "regression")
	public void createContactTest() throws Throwable {
		

	
		HomePage home = new HomePage(driver);
		home.clickTOContactLink();
		
		
		ContactPage cont = new ContactPage(driver);
		cont.clickContactLook();
		cont.dropDown(driver);
		
		
		Random rand = new Random();
		int random = rand.nextInt();
		Excel_Utility eLib = new Excel_Utility();
		String firstame = eLib.readDataFromExcel("Contact", 0, 0)+random;
		ContactPage cPage = new ContactPage(driver);
		cPage.enterFName(firstame);
		//Assert.fail("-------failing------------");
		String lastNtame = eLib.readDataFromExcel("Contact", 0, 1)+random;
		cPage.enterLastname(lastNtame);
		//Assert.fail("-------failing------------");

		cPage.saveButton();
		
		ContactValidate validateCont = new ContactValidate(driver);
		validateCont.validateProductPage(driver, firstame, lastNtame);

		
		
		
		
	}

}
