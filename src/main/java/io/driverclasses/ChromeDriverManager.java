package io.driverclasses;

import org.openqa.selenium.chrome.ChromeDriver;

import io.base.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriverManager extends DriverManager{

	@Override
	protected void createDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	}

}
