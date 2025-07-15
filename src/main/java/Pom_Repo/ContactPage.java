package Pom_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactPage {
	
	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement contactLookUp;
	
	@FindBy(name = "firstname")
	private WebElement Fname;
	
	@FindBy(name="lastname")
	private WebElement lastname;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	

	

	
	
	public WebElement getContactLookUp() {
		return contactLookUp;
	}

	public WebElement getFname() {
		return Fname;
	}

	public WebElement getLastname() {
		return lastname;
	}
	public WebElement getSaveButton() {
		return saveButton;
		
	}

	/**
	 * 
	 * @param driver
	 */

	public void clickContactLook() {
		contactLookUp.click();
	}
	
	public void dropDown(WebDriver driver) {
		WebElement pref = driver.findElement(By.name("salutationtype"));
		Select select = new Select(pref);
		select.selectByVisibleText("Mr.");
		
	}
	public void enterFName(String firstName) {
		Fname.sendKeys(firstName);
	}
	public void enterLastname(String lName) {
		lastname.sendKeys(lName);
		
	}
	public void saveButton() {
		saveButton.click();
	}
	

}
