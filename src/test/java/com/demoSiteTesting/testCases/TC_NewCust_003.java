package com.demoSiteTesting.testCases;




import java.util.HashMap;

import org.openqa.selenium.Alert;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.demoSiteTesting.pageObject.AddCust;
import com.demoSiteTesting.pageObject.LoginPage;
import com.github.javafaker.Faker;


public class TC_NewCust_003 extends BaseClass
{
	
	
	
	LoginPage lp;
	AddCust cust;  
	SoftAssert sfassert;
	HashMap<String, String> hm = new HashMap<>();
	
	@Test(priority=0)
	public void login() throws InterruptedException 
	{
		lp = new LoginPage(driver);
		
		lp.setUserName(username);
		lp.setpassword(password);
		
		try
		{
			lp.clickSubmit();
			Thread.sleep(3000);
			
			if(BaseClass.isAlertPresent(driver))
			{
				sfassert.assertTrue(false);
				captureScreen();
				
			}
		}
		catch(Exception e)
		{
			Alert alert=driver.switchTo().alert();
			String alertText=alert.getText();
			logger.info(alertText);
			alert.accept();
			e.printStackTrace();
		}
		logger.info("loged in sucessfully");
		
		//cust= new AddCust(driver);
		//cust.clickNewCustLink();
		//logger.info("clicking on new cust link sucessfully");
	}
	
	
	
	
	@Test(dataProvider="getdata")
	public void newCustomer(HashMap<String, String> testData) throws InterruptedException 
	{
		
		
		
		cust.setCustName(testData.get("fname"));
		logger.info("new cust name set ok");
		
		
		cust.clickfemaleRadioBtn();
		logger.info("female radio button selected");
		
		cust.setDOB(10,5,1995);
		logger.info("dob set ok");
		
		
		cust.setAddress(testData.get("address"));
		logger.info("address set ok");
		
		
		cust.setCity(testData.get("city"));
		logger.info("city set ok");
		
		
		cust.setState(testData.get("state"));
		logger.info("state set ok");
		
		cust.setPin(testData.get("pin"));
		logger.info("pin set ok");
		
		cust.setMobileNumber(testData.get("mobile_number"));
		logger.info("mobile set ok");
		
		
		cust.setEmail(testData.get("email"));
		logger.info("email set ok");
		
		
		cust.setPassword(testData.get("password"));
		logger.info("passowrd set ok");
		
		cust.clickSubmit();
		logger.info("clicked on submit");
		
		
		if(BaseClass.isAlertPresent(driver))
		{
			captureScreen();
			
			Alert alert=driver.switchTo().alert();
		
			String alertText= alert.getText();
			
			alert.accept();
			logger.info(alertText);
		}
		
		
		sfassert = new SoftAssert();
			
		Thread.sleep(2000);
		
		if(cust.getSucessfullmsg().equalsIgnoreCase("Customer Registered Successfully!!!"))
		{
			logger.info("new cust registered sucessfully");

			String custID= cust.getnewcustID();
			String custName= cust.getnwecustName();
			hm.put(custID, custName);
			
			
		}
		
		
		Thread.sleep(2000);
		driver.navigate().refresh();
		logger.info("page refreshed");
		
		cust.clickNewCustLink();
		logger.info("again clicked on new cust link");
		System.out.println(hm);
	}
	
	@DataProvider(name="getdata")
	public  Object[][] generateRandData()
	{
		// iterations= number testcase data
		int interations = 5;
		
		Faker faker = new Faker();
		
		 // Create an array to store test data
        Object[][] testData = new Object[interations][1];
        
        
     // Generate random data for each test case and store it in a HashMap
        for (int i = 0; i < interations; i++) {
        	
            HashMap<String, String> data = new HashMap<>();
            
            data.put("fname", faker.name().fullName());
            data.put("address", faker.address().streetAddress());
            data.put("city", faker.address().cityName());
            data.put("state", faker.address().state());
            data.put("pin", faker.numerify("######"));
            data.put("mobile_number", faker.phoneNumber().subscriberNumber(10));
            data.put("email", faker.internet().emailAddress());
            data.put("password", faker.internet().password(3, 5, false));
            
            

            // Store the HashMap in the test data array
            testData[i][0] = data;
        }

        return testData;
		 
		
	}
	
	

	
}