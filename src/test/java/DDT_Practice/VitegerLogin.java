package DDT_Practice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class VitegerLogin {
	
	public static void main(String[] args) throws Throwable {
		File file = new File("./src/test/resources/JsonData.json");
		ObjectMapper obj = new ObjectMapper();
		JsonNode data = obj.readTree(file);
		String BROWSER = data.get("Browser").asText();
		String URl = data.get("url").asText();
		String username = data.get("username").asText();
		String password= data.get("password").asText();
		
		WebDriver driver;
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
			
		}else {
			driver=new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URl);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		String name ="product1";
		WebElement product = driver.findElement(By.xpath("//input[@name='productname']"));
		product.sendKeys(name);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String act = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
		
		if(act.equals(name)) {
			System.out.println("Product name is create");
		}else {
			System.out.println("prodcut name is not created");
		}
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
	}

}
