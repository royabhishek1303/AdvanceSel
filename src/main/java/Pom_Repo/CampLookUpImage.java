package Pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampLookUpImage {
	public CampLookUpImage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[title='Create Campaign...']")
	private WebElement ClickCampaingnsLookUpImage;
	
	@FindBy(xpath = "//img[@alt='Create Product...']")
	private WebElement productLookUp;
	
	public WebElement getProductLookUp() {
		return productLookUp;
	}

	public WebElement getClickCampaingnsLookUpImage() {
		return ClickCampaingnsLookUpImage;
	}
	
	public void clickCampLookUp() {
		ClickCampaingnsLookUpImage.click();
	}
	public void clickProdLookUp() {
		productLookUp.click();
	}
}
