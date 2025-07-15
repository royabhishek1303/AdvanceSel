package Pom_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrgValidation {
	public OrgValidation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void validateOrgPage(WebDriver driver, String OrgName) {
String act = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
		
//		if(act.equals(OrgName)) {
//			System.out.println("Organization link is create");
//		}else {
//			System.out.println("Organization link is not created");
//		}

        Assert.assertEquals(act, OrgName,"Organization link not created");
        System.out.println("Orgaization link creatged");
	}
	

}
