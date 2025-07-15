package Pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement organizationLookUpImage;
	
	@FindBy(name ="accountname")
	private WebElement accountName;
	
	@FindBy(id = "phone")
	private WebElement phoneNumber;
	
	@FindBy(id="email1")
	private WebElement email;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement signOutButton;
	
	@FindBy(linkText = "Sign Out")
	private WebElement clickToSignOut;

	public WebElement getOrganizationLookUpImage() {
		return organizationLookUpImage;
	}

	public WebElement getAccountName() {
		return accountName;
	}

	public WebElement getPhoneNumber() {
		return phoneNumber;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getSignOutButton() {
		return signOutButton;
	}

	public WebElement getClickToSignOut() {
		return clickToSignOut;
	}

	/**
	 * 
	 */
	
	public void OrganiztionLookUpImage() {
		organizationLookUpImage.click();
		
	}
	public void organizationDetails(String orgName, String number, String emailId) {
		accountName.sendKeys(orgName);
		phoneNumber.sendKeys(number);
		email.sendKeys(emailId);
	}
	public void clickToSignOutButton() {
		signOutButton.click();
	}
	public void clickToSignOut() throws Throwable {
		
		clickToSignOut.click();
		
	}
	public void clickToSaveButton() {
		saveButton.click();
	}
}
