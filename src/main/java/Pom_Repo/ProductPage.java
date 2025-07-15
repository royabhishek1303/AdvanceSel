package Pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fasterxml.jackson.core.sym.Name;

public class ProductPage {
	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="productname")
	private WebElement productName;
	
	@FindBy(linkText = "Sign Out")
	private WebElement clickSignOut;
	
	public WebElement getClickSignOut() {
		return clickSignOut;
	}

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement signOut;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	public WebElement getProductName() {
		return productName;
	}
	public WebElement getSaveButton() {
		return saveButton;
		
	}
	public WebElement getSignOut() {
		return signOut;
	}
	/**
	 * 
	 */
	public void clickProductName(String name) {
		productName.sendKeys(name);
	}
	public void saveButton() {
		saveButton.click();
	}
	public void signOut() {
		signOut.click();
		clickSignOut.click();
	}
	

}
