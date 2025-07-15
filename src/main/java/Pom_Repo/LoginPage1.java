package Pom_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage1 {
	
	private WebDriver driver;
//locator
	public By userTextField =By.name("user_name");
	public By passwordTextField =By.name("user_password");
	public By loginButton =By.id("submitButton");
	
	public LoginPage1(WebDriver driver) {
		this.driver=driver;
	}
	
	public void enterUserName(String username) {
		WebElement userInput = driver.findElement(userTextField);
		userInput.sendKeys(username);
	}
	public void enterPassword(String password) {
		WebElement pass = driver.findElement(passwordTextField);
		pass.sendKeys(password);
	}
	public void clickToLogin() {
		WebElement logiButton = driver.findElement(loginButton);
		logiButton.click();	
	}
	
	
	public void loggInToAp(String name, String password) {
		
	enterUserName(name);
	enterPassword(password);
	clickToLogin();
		
	}

}
