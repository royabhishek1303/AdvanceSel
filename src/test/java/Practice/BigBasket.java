package Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class BigBasket {
	public static void main(String[] args) {
		

		WebDriver driver = new EdgeDriver();
		driver.get("https://www.bigbasket.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//div[@class='Header___StyledQuickSearch2-sc-19kl9m3-0 gzbZOD']//input[@placeholder='Search for Products...']")).sendKeys("mango",Keys.ENTER);
//	    List<WebElement> mangoes = driver.findElements(By.xpath("//h3[contains(text(),'Mango ')]"));
//	    
//	    System.out.println("test");
//	    Actions actions = new Actions(driver);
//	    for (WebElement mango : mangoes) {
//	        actions.moveToElement(mango).perform();
//	        System.out.println(mango.getText().toString());
//	    }
		
		List<WebElement> blocks = driver.findElements(By.xpath("//a[contains(@href, '/pd/')]"));

		for (int i = 0; i < blocks.size(); i++) {
		    try {
		        // Re-locate the element in each iteration to avoid stale reference
		        WebElement block = driver.findElements(By.xpath("//a[contains(@href, '/pd/')]")).get(i);

		        WebElement nameElement = block.findElement(By.xpath(".//div[contains(@class,'break-words')]//h3"));
		        String name = nameElement.getText();

		        if (name.toLowerCase().contains("mango")) {
		            System.out.println(name);
		        }
		    } catch (Exception e) {
		        System.out.println("Skipped a block due to error: " + e.getMessage());
		    }
		}
	

}
}
