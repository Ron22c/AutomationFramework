package com.automationFramework.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationFramework.pageObjects.LoginPage;

public class TC_loginTest_001 extends BaseClass{
	
	@Test
	public void loginTest() throws IOException {
		log.info("insode login test");
		LoginPage testPage = new LoginPage(driver);
		log.info("url loaded");
		driver.get(BASEURL);
		testPage.setUsername(USERNAME);
		testPage.setPassword(PASSWORD);
		testPage.submit();
		if (driver.getTitle()== "guru") {
			log.warn("Test Passed");
			Assert.assertTrue(true);
		}
		else {
			log.warn("Test Failed");
			takeScreenShot(driver, "loginTest");
			Assert.assertTrue(false);
		}
	}
}
