package Genric_utility;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import Pom_Repo.HomePage;
import Pom_Repo.*;


public class Base_Class {
	
	public WebDriver driver;
	public static WebDriver sdriver;
	
	
	@BeforeSuite(groups = {"smoke", "regression"})
	public void BS() {
		System.out.println("Databases connection");
	}
	@BeforeTest(groups = {"smoke", "regression"})
	public void BT() {
		System.out.println("Parell execution");
	}
	
//	@Parameters("BROWSER")
	
//	public void BC(String BROWSER) throws Throwable {
	@BeforeClass
	(groups = {"smoke", "regression"})
	public void BC() throws Throwable {
		
		File_Utility fUtil = new File_Utility();
		
			//reading keys from properties file
//			//File_Uitility flib = new File_Uitility();
//			String BROWSER = fUtil.getKeyAndValue("browser");
//		
//			//reading keys from cmd prompt
////			String BROWSER = System.getProperty("browser");
//			
//			if (BROWSER.equalsIgnoreCase("chrome")) {
//				driver = new ChromeDriver();
//			} else if (BROWSER.equalsIgnoreCase("firefox")) {
//				driver = new FirefoxDriver();
//			} else if (BROWSER.equalsIgnoreCase("edge")) {
//				driver = new EdgeDriver();
//			} else {
//				driver = new FirefoxDriver();
//			}
//			System.out.println("Browser Launching");
//			
//			sdriver=driver;
//		}
		String BROWSER = fUtil.getKeyAndValue("Browser");

		//String BROWSER = System.getProperty("Browser");
		if (BROWSER.equalsIgnoreCase("edge")) {
		    // ✅ Set the absolute path to your downloaded Edge driver
		    System.setProperty("webdriver.edge.driver", "C:\\Users\\HP\\Downloads\\edgedriver_win64 (4)\\msedgedriver.exe");

		    // 💡 Optional: Check if the file exists before launching
		    File edgeDriverFile = new File("C:\\Users\\HP\\Downloads\\edgedriver_win64 (4)\\msedgedriver.exe");
		    if (!edgeDriverFile.exists()) {
		        throw new RuntimeException("EdgeDriver not found at specified path.");
		    }

		    driver = new EdgeDriver();
		}
		
//		if(BROWSER.equalsIgnoreCase("chrome")) {
//			driver=new ChromeDriver();
//		}else if(BROWSER.equalsIgnoreCase("edge")) {
//		driver=new EdgeDriver();
//			
//		}else {
//			driver=new FirefoxDriver();
//		}
	    Web_Driver_Utility wdu = new Web_Driver_Utility();
	    wdu.maximizeWindow(driver);
	    wdu.waitElmentsToLoad(driver);
		System.out.println("Launching the Browser");
		sdriver=driver;
//	}
//	@Parameters({"URL","Username","Password"})
	
	
//	public void BM(String URL, String Username, String Password) throws Throwable {
	}
	@BeforeMethod
	(groups = {"smoke", "regression"})
	public void BM() throws Throwable {
		File_Utility fUtil = new File_Utility();
		String BROWSER = fUtil.getKeyAndValue("Browser");
		String URL = fUtil.getKeyAndValue("url");
		String Username = fUtil.getKeyAndValue("username");
	String Password = fUtil.getKeyAndValue("password");
//		String BROWSER = System.getProperty("Browser");
//		String URL = System.getProperty("url");
//		String Username = System.getProperty("username");
//		String Password = System.getProperty("password");
		

	    Web_Driver_Utility wdu = new Web_Driver_Utility();
	    wdu.maximizeWindow(driver);
	    wdu.waitElmentsToLoad(driver);
	    driver.get(URL);
	    
	    	
   LoginPage login = new LoginPage(driver);
	         login.loginToApp(Username, Password);


		System.out.println("Login to Application");
	}
	@AfterMethod(groups = {"smoke", "regression"})
	
	public void AM() {
		  HomePage homePage = new HomePage(driver);
		 // homePage.signoutButton();
		  homePage.logoutButton();
		
		 
		System.out.println("Logout to Application");
	}
	@AfterClass(groups = {"smoke", "regression"})
	public void AC() {
		  driver.quit();
		System.out.println("Close the Browser");
	}
	@AfterTest(groups = {"smoke", "regression"})
	public void AT() {
		System.out.println("Parallel execution close");
	}
	@AfterSuite(groups = {"smoke", "regression"})
	public void AS() {
		System.out.println("DataBase connection close");
	}

}
