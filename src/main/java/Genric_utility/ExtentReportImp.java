package Genric_utility;

import java.io.IOException;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportImp implements ITestListener {
	
	ExtentReports reports;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		test=reports.createTest(result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName());
		test.log(Status.PASS, result.getThrowable());
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());
		
		String screenShot = null;
		
		try {
			 screenShot = Web_Driver_Utility.takeScreenShot(Base_Class.sdriver, result.getMethod().getMethodName());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(screenShot);
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
	}

	public void onStart(ITestContext context) {
		
			String dateANdTime = new Date().toString().replace(" ", "_").replace(":", "_");
			ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport/report.html"+ dateANdTime);
			spark.config().setTheme(Theme.DARK);
			spark.config().setDocumentTitle("VitigerRport");
			spark.config().setReportName("Abhishek");
			
			//system config
			reports=new  ExtentReports();
			reports.attachReporter(spark);
			reports.setSystemInfo("platform", "windows");
			reports.setSystemInfo("executedBy", "Abhishek Rajput");
			reports.setSystemInfo("reviewed by", "Sobha rani");
		
	}

	public void onFinish(ITestContext context) {
		reports.flush();
		
	}
	

}
