package com.automationFramework.testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationFramework.pageObjects.LoginPage;
import com.automationFramework.utilities.XLUtils;

public class TC_loginTest_002 extends BaseClass{

	@Test(dataProvider="testdata")
	public void loginTest(String user, String Pass) {
		LoginPage page = new LoginPage(driver);
		driver.get(BASEURL);
		page.setUsername(user);
		page.setPassword(Pass);
		page.submit();
		
	}
	
	@DataProvider(name="testdata")
	public String[][]excelReader() throws IOException{
		String path = System.getProperty("user.dir")+"src/test/java/com/automationFramework/testData/LoginData.xlsx";
		int rowcount = XLUtils.getRowCount(path, "sheet1");
		int cellcount = XLUtils.getCellCount(path, "sheet1", rowcount);
		
		String data[][] = new String[rowcount][cellcount];
		for(int i=1; i<rowcount;i++) {
			for(int j=0; j<=cellcount;j++) {
				data[i-1][j]=XLUtils.getCellData(path, "sheet1", i, j);
			}
		}
	return data;
	}
}
