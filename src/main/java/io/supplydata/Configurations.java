package io.supplydata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configurations {
	static InputStream src = null;
	static Properties properties = null;
	public static Properties ReadProperties()
	{
		String dir = System.getProperty("user.dir");
		
		try {
			src = new FileInputStream( new File(dir+"\\src\\main\\java\\io\\supplydata\\config.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 properties = new Properties();
		try {
			properties.load(src);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties;
	}

}
