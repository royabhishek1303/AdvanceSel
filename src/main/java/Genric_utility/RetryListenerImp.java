package Genric_utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class RetryListenerImp implements IRetryAnalyzer{

	int count =0;
	int retryCount=3;
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(count<retryCount) {
			count++;
			return true;
		}
		return false;
	}

}
