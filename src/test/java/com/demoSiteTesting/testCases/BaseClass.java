package com.demoSiteTesting.testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import com.demoSiteTesting.utility.ReadConfig;

public class BaseClass {

	// write common methods which needs for every test cases like invoke & close
	// browser
	// read user name password base url etc

	ReadConfig config = new ReadConfig();

	public String baseurl = config.getBaseUrl();
	public String username = config.getUserName();
	public String password = config.getPassword();
	public String exppgtitle = config.getPageTitle();
	public String sucessmsg= config.custRegisterMsg();

	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {

		logger = Logger.getLogger("demoSiteTesting");
		PropertyConfigurator.configure("log4j.properties");

		if (br.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}

		else if (br.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		else if (br.equalsIgnoreCase("ie")) {
			driver = new InternetExplorerDriver();
		} else if (br.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		driver.get(baseurl);
		driver.manage().window().maximize();

	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

	public static void captureScreen() 
	{
		Date currentdate= new Date();
		String screenshottime= currentdate.toString().replace(" ", "-").replace(":", "-");
		
		TakesScreenshot screenshot = ((TakesScreenshot) driver);
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File target = new File(".//Screenshots//"+ screenshottime +".png");
		try {
			FileUtils.copyFile(source, target);
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		
	}

	public static void waitForCondition(WebDriver driver, Duration i, ExpectedCondition<?> condition) {
		WebDriverWait wait = new WebDriverWait(driver, i);
		wait.until(condition);
		
	}
	
	
	// if alert is present means test case failed so that to validate it we take alert into consideration
	// create a method to see whether the alert is present or not put this method into base class
	// if alert present it return true and not present it returns false
	
	public static boolean isAlertPresent(WebDriver driver)
	{
        try 
        {
            // Set a short implicit wait time to check if alert is present
        	BaseClass.waitForCondition(driver, Duration.ofSeconds(10), ExpectedConditions.alertIsPresent());
            return true;
        } catch (Exception e) 
        {
            return false;
        }
	
	}

}
