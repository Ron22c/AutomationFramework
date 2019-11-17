package com.automationFramework.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties properties;
	
	public ReadConfig() {
		File src = new File("./configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			properties = new Properties();
			properties.load(fis);
		}catch (Exception e) {
			System.out.println("Read failed because of "+e.getMessage());
		}
	}
	public String getBaseUrl() {
		String url = properties.getProperty("BASEURL");
		return url;
	}
	
	public String getUserName() {
		return properties.getProperty("USERNAME");
	}
	
	public String getPassword() {
		return properties.getProperty("PASSWORD");
	}
	
	public String getChromeDriverPath() {
		return properties.getProperty("chromepath");
	}
	
	public String getFirefoxPath() {
		return properties.getProperty("firefoxpath");
	}
}
