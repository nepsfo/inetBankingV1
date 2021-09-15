package com.inetbanking.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;
import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{

	@Test
	public void loginTest() {
		driver.get(baseURL);
		LoginPage loginPage = new LoginPage(driver);
		logger.info("Entered user name");
		loginPage.setUserName(username);
		logger.info("Entered password");
		loginPage.setPasswrod(password);
		loginPage.clickSubmit();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		System.out.println(driver.getTitle());
		if(driver.getTitle().equals("GTPL Bank Manager HomePage")) {
			
			Assert.assertTrue(true);
		} else {
			
			try {
				// 2nd argument should be exactly like test case Name
				captureScreen(driver, "loginTest");
				System.out.println("Capture screenshot");
				Assert.assertTrue(false);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.error(e.getMessage());
			}
			logger.info("Login test failed");
		}
		
		
	}
}
