package Pom_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProductValidation {
	public ProductValidation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void validationProductData(WebDriver driver, String exelData) {
		String act = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
		
//		if(act.equalsIgnoreCase(exelData)) {
//			System.out.println("Product created");
//		}else {
//			System.out.println("Product not created");
//		}
		
		Assert.assertEquals(act,exelData,"Product not create");
		System.out.println("Product is created.");
	}

}
