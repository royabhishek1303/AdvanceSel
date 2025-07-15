package DDT_Practice;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

public class FetchDataFromJson {
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
		
		driver.get(URl);
	}

}
