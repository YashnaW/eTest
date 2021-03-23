package io.utility;

import java.io.File;
import java.io.FileOutputStream;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Screenshot {
	
	
//	public Screenshot(WebDriver driver)
//	{
//	this.driver = driver;	
//	}

	
	public static void capture(String name, WebDriver driver)
	{
		try {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("src/screenshots/"+name+".png"));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
