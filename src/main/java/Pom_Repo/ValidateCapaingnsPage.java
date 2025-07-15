package Pom_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ValidateCapaingnsPage {
	
	public ValidateCapaingnsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void validationCampaingnsData(WebDriver driver, String exelData) {
		String cam = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
		
//		if(cam.equalsIgnoreCase(exelData)) {
//			System.out.println("campaign created");
//		}else {
//			System.out.println("campaign not created");
//		}
		Assert.assertEquals(cam,exelData,"Campaign not created");
		System.out.println("Campaingn created");
	}

}
