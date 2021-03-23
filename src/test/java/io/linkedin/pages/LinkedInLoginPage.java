package io.linkedin.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.base.DriverInit;

public class LinkedInLoginPage {
	static WebDriver driver;
	
	@FindBy(id="username")
	WebElement email;
	
	
	public LinkedInLoginPage setemail(Object user)
	{
		email.sendKeys((String) user);
		return this;
	}
	
	@FindBy(id="password")
	WebElement pswd;
	
	public LinkedInLoginPage setpaswrd(Object pwd)
	{
		pswd.sendKeys((String) pwd);
		return this;
	}
	
	@FindBy(xpath  = "//button[@type='submit']")
	WebElement submit;
	
	public LinkedInLoginPage clickSubmit()
	{
		submit.click();
		return this;
	}
	
	
	public static LinkedInLoginPage init() {
		 DriverInit init= DriverInit.getinstance();
		  driver = init.initDriver();
		
		return  PageFactory.initElements(driver, LinkedInLoginPage.class);
	}

}
