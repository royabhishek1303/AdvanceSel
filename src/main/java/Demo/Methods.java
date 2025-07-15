package Demo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class Methods {

	
	public void maximizeWindow(WebDriver driver) {
		
		driver.manage().window().maximize();
		
		
	}
	public void wait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

}

