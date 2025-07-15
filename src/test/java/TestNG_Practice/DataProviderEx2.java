package TestNG_Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx2 {
	
	@Test(dataProvider = "createStudentData")
	public void createContact1(String firstname, String Lastname) {
		
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8888/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("firstname")).sendKeys(firstname);
		driver.findElement(By.name("lastname")).sendKeys(Lastname);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
		
	}
	
	@DataProvider
	public Object[] [] createStudentData() {
		
		Object[][] obj = new Object[3][2];
	    obj[0][0]="abhi";
	    obj[0][1]="shek";
	    
	    
	    obj[1][0]="sumi";
	    obj[1][1]="ram";
	   

	    
	    obj[2][0]="test";
	    obj[2][1]="data";
	   

		
		return obj;
		
		
	}}
