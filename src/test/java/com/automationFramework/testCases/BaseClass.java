package com.automationFramework.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.automationFramework.utilities.ReadConfig;


public class BaseClass {
	public ReadConfig config = new ReadConfig();
	public String BASEURL = config.getBaseUrl();
	public String USERNAME = config.getUserName();
	public String PASSWORD = config.getPassword();
	public static WebDriver driver;
	public static Logger log; 
	
	@BeforeClass
	@Parameters("browser")
	public void setup(String browser) {
		Logger log = Logger.getLogger("automationFrameworkNetbanking");
		PropertyConfigurator.configure("log4j.properties");
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.Driver", config.getChromeDriverPath());
			log.info("Launching Chrome Browser");
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.Driver", config.getFirefoxPath());
			log.info("Launching firefox Browser");
			driver = new FirefoxDriver();
		}
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void takeScreenShot(WebDriver driver, String tName) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tName+".png");
		FileUtils.copyFile(source, target);
		
	}
}
