package io.google.testcases;

import static org.testng.Assert.assertTrue;

import java.util.function.Predicate;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.base.BaseClass;
import io.base.DriverInit;
import io.google.pages.GoogleLinkPage;
import io.supplydata.Conditions;
import io.utility.Screenshot;

public class GoogleLinksTests extends BaseClass{
	
	Conditions conditions = new Conditions();
	WebDriver driver;
	
	
	@BeforeMethod
	public void BeforeTest()
	{
		
		DriverInit baseins= DriverInit.getinstance();
		driver = baseins.initDriver();
		driver.get(prop.getProperty("googleurl"));
	}
	
	
	@Test(dataProvider="condition", priority = 1)
	
	public void clickAllLinks(Predicate<String> condition)
	{
		System.out.println("Click All links executed");
		GoogleLinkPage.init().getTextOfLinks(condition);
	}
	
	
	@Test(priority=3)
	public void  Switch_Tabs() {
		
		System.out.println("Switch Tabs executed");
		GoogleLinkPage.init().SwitchandGetTitle(prop.getProperty("flipkarturl"));
	}
	
	@Test (priority=2)
	public void  getLinkCount() {
		System.out.println("Get Count executed");
		int count = GoogleLinkPage.init().getCountofLinks();
		assertTrue(count>0);
		

	}
	
	@Test(priority=4)
	public void Go_To_Gmail() {
//		GoogleLinkPage.init();
		
		wait= new WebDriverWait(driver, 20);
		js = (JavascriptExecutor) driver;
		GoogleLinkPage.init().checkGmailfromGoogle(wait).clickGmail().enterGmailID(js);
		System.out.println("Go to Gmail executed");
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		
		if(ITestResult.FAILURE == result.getStatus())
		{
			Screenshot.capture(result.getName(), driver);
		}

	}
	
	
	@DataProvider(name="condition")
	public Object[] getData() {
		
		
		return new Object[] {
				conditions.NOTCONTAINS, conditions.NOTEMPTY
		};
	}
	
	



}
