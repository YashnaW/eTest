package io.driverclasses;

import org.openqa.selenium.ie.InternetExplorerDriver;

import io.base.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class IEManager extends DriverManager {

	@Override
	protected void createDriver() {
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
		
	}

}
