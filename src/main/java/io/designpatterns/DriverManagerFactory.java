package io.designpatterns;

import io.base.DriverManager;
import io.driverclasses.ChromeDriverManager;
import io.driverclasses.FirefoxDriverManager;
import io.driverclasses.IEManager;

public class DriverManagerFactory {
	
	public enum DriverType{
		CHROME,
		FIREFOX,
		IE;
		
	}
	
	public static DriverManager getManager(DriverType type) {
		
		DriverManager dmanager = null;
		
		switch(type) {
		case CHROME:
			dmanager = new ChromeDriverManager();
			break;
		case FIREFOX:
			dmanager = new FirefoxDriverManager();
			break;
		case IE:
			dmanager = new IEManager();
			break;
		}
		return dmanager;
	}
	

}
