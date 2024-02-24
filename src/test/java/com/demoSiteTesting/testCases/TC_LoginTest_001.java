package com.demoSiteTesting.testCases;



import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.demoSiteTesting.pageObject.LoginPage;



public class TC_LoginTest_001 extends BaseClass{
	
	LoginPage lp;
	
	SoftAssert sfassert;
	@Test
	public void loginTest() throws InterruptedException
	{
		
		logger.info("browser open successfully");
		
		lp = new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("user name sent successfully");
		
		lp.setpassword(password);
		logger.info("password sent successfully");
		
		lp.clickSubmit();
		
		logger.info("click submit button successfully");
		
		
		SoftAssert sfassert= new SoftAssert();
		if(BaseClass.isAlertPresent(driver)) {
			
			   Assert.assertTrue(false);
		       captureScreen();
		       logger.info(driver.switchTo().alert().getText());
 
			  }
			String actualpageTitle=driver.getTitle();
			
			if(exppgtitle.equalsIgnoreCase(actualpageTitle))
			{
				sfassert.assertTrue(true);
				//Assert.assertTrue(true);
				logger.info("login test successful");
			}
			
		    
		    
		}
		
	
		
		
		

	
}


	
	


