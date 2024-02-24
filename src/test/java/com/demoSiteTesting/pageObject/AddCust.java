package com.demoSiteTesting.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCust {
	
	WebDriver ldriver;
	
	public AddCust(WebDriver rdriver)
	{
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	



	@FindBy(xpath="//a[contains(text(),'New Customer')]")
	WebElement newcustLink;
	
	@FindBy(xpath="//tbody/tr[4]/td[2]/input[1]")
	WebElement custName;
	
	@FindBy(xpath="//tbody/tr[5]/td[2]/input[1]")
	WebElement maleRadiobtn;
	
	@FindBy(xpath="//tbody/tr[5]/td[2]/input[2]")
	WebElement FemaleRadiobtn;
	
	@FindBy(xpath="//input[@id='dob']")
	WebElement dob;
	
	@FindBy(xpath="//textarea[@name='addr']")
	WebElement txtaddress;
	
	@FindBy(xpath="//input[@name='city']")
	WebElement txtcity;
	
	
	@FindBy(xpath="//input[@name='state']")
	WebElement txtstate;
	
	@FindBy(xpath="//input[@name='pinno']")
	WebElement pin;
	
	@FindBy(xpath="//input[@name='telephoneno']")
	WebElement mobilenumber;
	
	@FindBy(xpath="//input[@name='emailid']")
	WebElement email;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@name='sub']")
	WebElement submitformbtn;
	
	// get the text from below element to validate the case
	
	@FindBy(xpath="//*[@id=\"customer\"]/tbody/tr[1]/td/p")
	WebElement successfullrgisteredmsg;
	
	
	@FindBy(xpath="//table[@id='customer']/tbody/tr[4]/td[2]")
	WebElement newCustId;
	
	@FindBy(xpath="//table[@id='customer']/tbody/tr[5]/td[2]")
	WebElement newCustName;
	// create required action methods
	
	
	public void clickNewCustLink()
	{
		newcustLink.click();
	}
	
	public void setCustName(String custname)
	{
		custName.sendKeys(custname);
	}
	
	public void clickMaleRadioBtn()
	{
		maleRadiobtn.click();
		
	}
	
	public void clickfemaleRadioBtn()
	{
		FemaleRadiobtn.click();
	}
	
	public void setDOB(int mm, int dd, int yyyy)
	{
		String month= String.valueOf(mm);
		String date= String.valueOf(dd);
		String year= String.valueOf(yyyy);
		dob.sendKeys(month,date,year);
	}
	
	public void setAddress(String address)
	{
		txtaddress.sendKeys(address);
	}
	
	public void setCity(String city)
	{
		txtcity.sendKeys(city);
	}
	
	public void setState(String state)
	{
		txtstate.sendKeys(state);
	}
	public void setPin(String pinnumber)
	{
		//String pinnum=String.valueOf(pinnumber);
		pin.sendKeys(pinnumber);
	}
	
	public void setMobileNumber(String mobilenum)
	{
		//String mobnum=String.valueOf(mobilenum);
		mobilenumber.sendKeys(mobilenum);
	}
	
	public void setEmail(String emailid)
	{
		email.sendKeys(emailid);
	}
	
	public void setPassword(String password)
	{
		//String pass= String.valueOf(password);
		this.password.sendKeys(password);
	}
	public void clickSubmit()
	{
		submitformbtn.click(); 
	}
	
	public String getSucessfullmsg()
	{
		String msg=successfullrgisteredmsg.getText();
		return msg;
	}
	
	public String getnewcustID()
	{
		String custID=newCustId.getText();
		return custID;
	}
	
	public String getnwecustName()
	{
		String custname=newCustName.getText();
		return custname;
	}
	
	
	
	
}
