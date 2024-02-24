package com.demoSiteTesting.utility;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

public class ReadConfig {

	Properties pro;

	
	public ReadConfig()
	{
		File src= new File("./Configuration/config.properties");
		
		try 
		{
			FileInputStream file= new FileInputStream(src);
			 pro = new Properties();
			 pro.load(file);
				
			
			 
		} 
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	public String getBaseUrl()
	{
		String baseUrl=pro.getProperty("baseurl");
		return baseUrl;
	}
	
	public String getUserName()
	{
		String userName=pro.getProperty("username");
		return userName;
	}
	
	public String getPassword()
	{
		String password=pro.getProperty("password");
		return password;
	}
	
	public String getPageTitle()
	{
		String expTitle=pro.getProperty("expectedpagetitle");
		return expTitle;
	}
	
	public String getBrowser()
	{
		String browsername=pro.getProperty("browser");
		return browsername;
	}
	
	public String custRegisterMsg()
	{
		String sucessmsg=pro.getProperty("userRegiteredSucessMsg");
		return sucessmsg; 
	}
	
}
