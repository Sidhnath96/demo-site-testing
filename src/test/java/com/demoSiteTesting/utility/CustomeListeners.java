package com.demoSiteTesting.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.demoSiteTesting.testCases.BaseClass;

public class CustomeListeners extends BaseClass implements ITestListener {

	@Override
    public void onTestStart(ITestResult result) {
       
    }

    @Override
    public void onTestSuccess(ITestResult result) {
       
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	
       captureScreen();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // This method is called when a test fails but is within the success percentage.
        // You can implement custom behavior here if needed.
    }

    @Override
    public void onStart(ITestContext context) {
       
    }

    @Override
    public void onFinish(ITestContext context) {
        
    }
}
