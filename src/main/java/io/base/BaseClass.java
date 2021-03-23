package io.base;


import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.supplydata.Configurations;

public class BaseClass {
	
	protected static WebDriverWait wait;
	public static JavascriptExecutor js;
	static DriverManager dmanager;
	protected Properties prop;
	
	public  BaseClass() {
		prop =Configurations.ReadProperties();
	}
	
	
	
	
	

}
