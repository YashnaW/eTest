package io.base;

import org.openqa.selenium.WebDriver;

import io.designpatterns.DriverManagerFactory;
import io.designpatterns.DriverManagerFactory.DriverType;

public class DriverInit {
	
	private static DriverInit init = null;
	private WebDriver driver;
	static DriverManager dmanager;
	
	
	private DriverInit()
	{
		
	}
	
	public  WebDriver initDriver()
	{
		if(driver==null)
		{
		dmanager = DriverManagerFactory.getManager(DriverType.CHROME);
		driver = dmanager.getDriver();
		}
		return driver;
	}
	
	
	public static DriverInit getinstance() {
		if(init==null)
		init = new DriverInit();
		
		return init;
		
		
	}
}



