package com.my_first_projectv1.Listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.my_first_projectv1.testBase.BaseClass;

public class customListener extends BaseClass implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, result.getName()+ " : Test Case PASSED.");
		extent.flush();
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getName()+" : Test case is FAILED");    //to add name in Extent report
		test.log(Status.FAIL, result.getThrowable());     //to add Exception details in Extent report
		String ScreenshoPath = null;
		try {
			ScreenshoPath = BaseClass.FailedTestScreenshot(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			test.addScreenCaptureFromPath(ScreenshoPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   //Adding Screenshot to Extent Report.
		
		extent.flush();
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getName()+ " : Test case is SKIPPED");
		test.log(Status.SKIP, result.getThrowable());
		extent.flush();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	  
}
