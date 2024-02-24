package com.demoSiteTesting.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	 WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver= rdriver;
		
		PageFactory.initElements(rdriver,this);
	}
	

	
	@FindBy(name="uid")
	WebElement usernameinputbox;
	
	@FindBy(name="password")
	WebElement passwordinputbox;
	
	@FindBy(name="btnLogin")
	WebElement loginbtn;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	WebElement logoutlink;
	
	
	
	// write the method for actions 
	
	public void setUserName(String username)
	{
		usernameinputbox.sendKeys(username);
	}
	
	public void setpassword(String password)
	{
		passwordinputbox.sendKeys(password);
		
	}

	public void clickSubmit()
	{
		loginbtn.click();
	}
	public void clicklogout()
	{
		logoutlink.click();
	}
	
	
}
