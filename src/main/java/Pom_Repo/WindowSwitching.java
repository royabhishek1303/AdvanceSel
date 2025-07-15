package Pom_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowSwitching {
	
	public WindowSwitching(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="search_text")
	private WebElement prodName;
	
	@FindBy(name="search")
	private WebElement searchBar;
	@FindBy(xpath = "//img[@alt='Select']")
	private WebElement prodLookUpImg;
	
	public WebElement getProdLookUpImg() {
		return prodLookUpImg;
	}

	public WebElement getProdName() {
		return prodName;
	}

	public WebElement getSearchBar() {
		return searchBar;
	}
	
	/**
	 * 
	 */
	
	public void clickProdlookImg() {
		prodLookUpImg.click();
	}
	public void enterProdDetails(String name) {
		prodName.sendKeys(name);
		searchBar.click();
	}
	public void enterProdNameCamp(WebDriver driver, String productName) {
		driver.findElement(By.xpath("//a[text()='"+productName+"']")).click();
	}

	
	
	
	
	
	
	

}
