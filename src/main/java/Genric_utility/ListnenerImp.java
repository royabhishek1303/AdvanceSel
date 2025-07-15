package Genric_utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnenerImp implements ITestListener {

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		TakesScreenshot ts = (TakesScreenshot)Base_Class.sdriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./FailedScript.png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
