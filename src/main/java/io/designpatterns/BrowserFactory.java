package io.designpatterns;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	private static Map<String, WebDriver> drivers = new HashMap<String,WebDriver>();
	
	private BrowserFactory() {}
	
	
	public static WebDriver getBrowser(String browser)
	{
		
		WebDriver driver = null;
		switch (browser) {
		case "Firefox":
			driver = drivers.get("Firefox");
			if (driver == null) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				drivers.put("Firefox", driver);
			}
			break;
		case "IE":
			driver = drivers.get("IE");
			if (driver == null) {
			WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				drivers.put("IE", driver);
			}
			break;
		case "Chrome":
			driver = drivers.get("Chrome");
			if (driver == null) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				drivers.put("Chrome", driver);
			}
			break;
		}
		
		
		
		return driver;
		
		
	}
	
}

