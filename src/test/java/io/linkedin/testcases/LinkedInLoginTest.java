package io.linkedin.testcases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.base.BaseClass;
import io.base.DriverInit;
import io.database.DataBaseConnection;
import io.linkedin.pages.LinkedInLoginPage;
import io.supplydata.LoginDetails;
import io.utility.ReadExcel;



public class LinkedInLoginTest extends BaseClass{
	WebDriver driver;
	LoginDetails logindetails = new LoginDetails();
	
	@BeforeTest
	public void  readConfig() {
		wait = new WebDriverWait(driver, 10);
//		prop = Configurations.ReadProperties();
		DriverInit baseins= DriverInit.getinstance();
		driver = baseins.initDriver();
		driver.get(prop.getProperty("linkedinurl"));

	}
	
	@Test(dataProvider = "login")
	public void Linked_In_Login_Test(Object USERNAME, Object pwd)
	{
		
		LinkedInLoginPage.init()
		.setemail(USERNAME)
		.setpaswrd(pwd)
		.clickSubmit();
	}
	
	
	@Test(dataProvider = "databasedata")
	public void  Login_using_DbData(Object dbuser, Object dbpswd) {
		LinkedInLoginPage.init()
		.setemail(dbuser)
		.setpaswrd(dbpswd)
		.clickSubmit();
		

	}
	

	@DataProvider(name = "login")
	public  Object[][] loginspecs()
	{
		return new Object[][] {
				{logindetails.USERNAME,logindetails.PASSWORD}
		};
	}
	
	@DataProvider(name = "logindata")
	public  Object[][] getLoginData()
	{
		Object[][] data= ReadExcel.getExcelValues("LoginCredentials");
		return data;
				
		
	}
	
	@DataProvider(name="databasedata")
	public Object[][] getdatafromdb()
	{
		  Object[][] dbdata = DataBaseConnection.createConnection();
		  return dbdata;
	}
}
