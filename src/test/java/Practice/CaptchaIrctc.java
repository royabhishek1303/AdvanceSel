package Practice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import net.sourceforge.tess4j.Tesseract;

public class CaptchaIrctc {
	public static void main(String[] args) throws Throwable {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(opt);
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.findElement(By.linkText("ok")).click();
		driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
		driver.findElement(By.xpath("//a[contains(text(),' LOGIN ')]")).click();
		WebElement captchaEle = driver.findElement(By.className("captcha-img"));
		TakesScreenshot tsc = (TakesScreenshot)captchaEle;
		File src = tsc.getScreenshotAs(OutputType.FILE);
		File dest = new File("./CatchaImag.png");
		FileUtils.copyFile(src, dest);
		Tesseract tess = new Tesseract();
		tess.setDatapath("C:\\Users\\HP\\Downloads\\Tess4J-3.4.8-src\\Tess4J\\tessdata");
		String tss = tess.doOCR(dest);
		String catchaImg = tss.replace(" ", "");
		System.out.println(catchaImg);
		driver.findElement(By.id("captcha")).sendKeys(catchaImg);
		
	}

}
