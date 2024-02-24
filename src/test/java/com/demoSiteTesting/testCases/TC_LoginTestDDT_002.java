package com.demoSiteTesting.testCases;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demoSiteTesting.pageObject.LoginPage;
import com.demoSiteTesting.utility.XLUtils;

public class TC_LoginTestDDT_002 extends BaseClass
{
	// we need to get data from XLUtils class and store it into 2D array (@DataProvider) 
	// then send this data to the actual test (@Test)
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String uname, String pass)
	{
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(uname);
		logger.info("user name sent");
		
		lp.setpassword(pass);
		logger.info("password sent");
		
		lp.clickSubmit();
		logger.info("clcked on submit button");
		
		
		
		if(isAlertPresent(driver)==true)
		{
			
			driver.switchTo().alert().accept();// close the alert 
			driver.switchTo().defaultContent();// focus on main page
			
			Assert.assertTrue(false);
			logger.warn("wrong user name and password");
		}
		
		else
		{
			Assert.assertTrue(true);
			lp.clicklogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info("log in successfully");
			
		}
		
	}
	

	
	
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
		 File src= new File(System.getProperty("user.dir")+"/src/test/java/com/demoSiteTesting/testData/LoginTestData.xlsx");
		 
		 int rownum= XLUtils.getRowCount(src, "test data");
		
		 int colcount= XLUtils.getCellCount(src,  "test data", rownum);
		 
		 String logindata [][]=new String [rownum][colcount];
		 
		 
		 for(int i=1;i<=rownum;i++)
		 {
			 for(int j=0;j<colcount;j++)
			 {
				 logindata [i-1][j]=XLUtils.getCellData(src, "test data", i, j);
			 }
		 }
		 return logindata;
	}
	 
}
