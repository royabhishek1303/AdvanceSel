package Pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampPage {

	public CreateCampPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	
	@FindBy(name = "campaignname")
	private WebElement campaignName;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement signOut;

	public WebElement getSignOut() {
		return signOut;
	}

	

	

	public WebElement getCampaignName() {
		return campaignName;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	/**
	 * 
	 */
	
	
	public void enterCampName(String name) {
		
		campaignName.sendKeys(name);
		
	}
	
	public void saveButton() {
		saveButton.click();
	}
	public void signOut() {
		signOut.click();
	}
}
