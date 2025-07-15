package DDT_Practice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Practice {
	public static void main(String[] args) throws Throwable {
		File file = new File("./src/test/resources/JsonData.json");
		ObjectMapper obj = new ObjectMapper();
		JsonNode data = obj.readTree(file);
		String BROWSER = data.get("Browser").asText();
		String URl = data.get("url").asText();
		
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
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("iphone");
		List<WebElement> iphone = driver.findElements(By.xpath("//ul[@class='_1sFryS _2x2Mmc _3ofZy1']/li"));
		
		for(WebElement allPHones: iphone) {
			if(allPHones.getText().contains("iphone")) {
				System.out.println(allPHones.getText());
				
			}
			
//			List<WebElement> listIph = driver.findElements(By.xpath("//div[@class='cPHDOP col-12-12']/div"));
//			
//			
//			for(WebElement allPHoneslist: listIph) {
//				if(allPHones.getText().contains("iphone")) {
//					System.out.println(allPHoneslist.getText());
//				}
//				
//				
//		}
//			
//			
//	}
	}
	}
}
		
		
		
		
	


