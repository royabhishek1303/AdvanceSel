package Genric_utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Web_Driver_Utility {
	
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	public void waitElmentsToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
    public void windowSwitching(WebDriver driver, String partialTitle) {
    	Set<String> allWIndowIds = driver.getWindowHandles();
		Iterator<String> itr = allWIndowIds.iterator();
		
		while (itr.hasNext()) 
		{
			String win = itr.next();
			driver.switchTo().window(win);
			String title = driver.getTitle();
			if(title.contains("Products&action")) {
				System.out.println(title);
				break;
			}
			
		}
    }
    public void mouseHover(WebDriver driver, WebElement moreLink) {
		Actions act = new Actions(driver);

        
		
		act.moveToElement(moreLink).perform();
    }
    public void alertHandling(WebDriver driver) {
		Alert alt = driver.switchTo().alert();

    	alt.accept();
    }
    public static String takeScreenShot(WebDriver driver, String ScreenShotName) throws IOException {
    	
    	TakesScreenshot ts = (TakesScreenshot)driver;
    	File src = ts.getScreenshotAs(OutputType.FILE);
     	File dest = new File("./ScreenShots/"+ScreenShotName+".png");
     	FileUtils.copyFile(src, dest);
    	
    	
  return dest.getAbsolutePath();
    	
    }

}
