package Pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public HomePage(WebDriver driver)
	{
	 PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Contacts")
	private WebElement contactLink;
	
	public WebElement getContactLink() {
		return contactLink;
	}

	@FindBy(linkText ="Organizations")
	private WebElement orgName;
	
	@FindBy(linkText = "Products")
	private WebElement prodLink;
	
	@FindBy(linkText = "More")
	private WebElement moreLink;
	
	@FindBy(name = "Campaigns")
	private WebElement campaignsLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement signouButton;
	
	public WebElement getSignouButton() {
		return signouButton;
	}

	@FindBy(linkText = "Sign Out")
	private WebElement logout;



	public WebElement getLogout() {
		return logout;
	}

	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getProdLink() {
		return prodLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampaignsLink() {
		return campaignsLink;
	}
	
	/**
	 * This method to click moreLInk
	 */
	
	public void clickTOContactLink(){
		contactLink.click();
	}
	
	public void clickToMoreLink(){
		moreLink.click();
		campaignsLink.click();
	}
	
	/**
	 * This method to click organization link
	 */
	public void clickToOrgLink(){
		orgName.click();
	}
	/**
	 * This method to click to capaingnsLink
	 */
	public void clickToCapaingnsLink(){
	
		campaignsLink.click();
	}
	
	public void clickToProdLink() {
		prodLink.click();
	}
	
	
	public void logoutButton() {
		signouButton.click();
		logout.click();
	}
}
