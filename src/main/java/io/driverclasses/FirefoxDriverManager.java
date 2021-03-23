package io.driverclasses;

import org.openqa.selenium.firefox.FirefoxDriver;

import io.base.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxDriverManager extends DriverManager{

	@Override
	protected void createDriver() {
		
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}

}
