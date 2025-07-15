package Pom_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ContactValidate {
	
	public  ContactValidate(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//;
	public void validateProductPage(WebDriver driver,String firstName, String lastName) {
		
		String fn = driver.findElement(By.id("dtlview_First Name")).getText();
		String ln = driver.findElement(By.id("dtlview_Last Name")).getText();
		
		Assert.assertEquals(fn, firstName, "first Name not validate");
		System.out.println("first Name validate");
		Assert.assertEquals(ln, lastName, "Last name not validate");
		System.out.println("Last name validate");
	}

}
