package com.demoSiteTesting.utility;

// Listener class used to generate report along with screenshot
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.configuration.Theme;


// write logging msg / screenshots etc


public class Reporting extends TestListenerAdapter{
	
	public ExtentSparkReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	
	public void onStart(ITestContext testContex)
	{
		String timeStamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());   // time stamp
		String repName="Test-Report-"+timeStamp+".html";
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"test-output/"+repName); // specify location
		try {
			htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		extent= new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name","LocalHost");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("user Name","sidhanath");

		htmlReporter.config().setDocumentTitle("demoSiteTesting project"); // title of the report
		htmlReporter.config().setReportName("Practice Automation test report "); // name of the report
		//htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); // location of the chart
		htmlReporter.config().setTheme(Theme.DARK);
		
	}
	
	// below are the methods from Listener class
	
	public void onTestSuccess(ITestResult tr) 
	{
		logger = extent.createTest(tr.getName()); // create new entry in report
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));  // send the passed information
		
	}

	public void onTestFailure1(ITestResult tr) 
	{
		logger.getExtent().createTest(tr.getName());  // create new entry in report
		logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));  // send the failed information 
		
		String screenshotpath= System.getProperty("user.dir")+"/Screenshots"+ tr.getTestName()+".png";
		
		File f= new File(screenshotpath);
		
		if(f.exists())
		{
			try 
			{
				logger.fail("Screenshot is below: "+logger.addScreenCaptureFromPath(screenshotpath));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	
	public void onTestSkipped(ITestResult tr) 
	{
		logger= extent.createTest(tr.getName()); // create new entry in the report
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	}

	

	public void onFinish(ITestResult tr) 
	{
		extent.flush();
	}

	

}
//If you also want to capture screenshots for failed cases and attach them to the extent report, please replace below method in your TestListener.
//We have using Selenium FileHandler class to capture the screenshot and the add the image location with Extent Report by using MediaEntityBuilder.
//createScreenCaptureFromPath(targetLocation)


