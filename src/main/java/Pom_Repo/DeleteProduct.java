package Pom_Repo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteProduct {
	
	
	
	
	public WebElement getSignOut() {
		return signOut;
	}
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement signOut;
	
	@FindBy(linkText = "Sign Out")
	private WebElement clickSignOut;
	
	public DeleteProduct(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void deleteProduct(WebDriver driver, String prodName) throws Throwable {
		Thread.sleep(2000);
driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='"+prodName+"']/../preceding-sibling::td[2]//input[@type='checkbox']")).click();
		
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
	}
	
	public void validateDeleteProduct(WebDriver driver, String prodName) {
	List<WebElement> list = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]"));
		
		boolean flag=false;
		for(WebElement value:list) {
			String prdV = value.getText();
			if(prdV.contains(prodName)) {
				flag=true;
				break;
		}
		}
			if(flag) {
				System.out.println("Product name is deleted");
			}
			else {
				System.out.println("Prodcut name is not deleted");
			}
//			driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//			driver.findElement(By.linkText("Sign Out")).click();
			
		
			}
//  public void signOut() {
//	  signOut.click();
//	  clickSignOut.click();
			
	}


