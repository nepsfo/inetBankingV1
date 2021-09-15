package com.inetbanking.testCases;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass{

	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String pwd) throws IOException, InterruptedException, HeadlessException, AWTException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		logger.info("user name provided");
		lp.setPasswrod(pwd);
		logger.info("password provided");
		lp.clickSubmit();
		logger.info("click on submit button");
		if( isAlertPresent()==true) {
			
			System.out.println("Im inside if isAlertPresent Check");
			System.out.println("After isAlretPresent: "+driver.switchTo().alert().getText());
			Thread.sleep(3000);
			driver.switchTo().alert();
			BufferedImage image = new Robot().createScreenCapture(new Rectangle(
			        Toolkit.getDefaultToolkit().getScreenSize()));
			File target = new File(System.getProperty("user.dir")+"/Screenshots/"+"loginDDT"+".png");
			//captureScreen(driver, "loginDDT");
			ImageIO.write(image, "png", target);
			driver.switchTo().defaultContent();
			System.out.println("Capture screenshot Robot loginDDT");
			driver.switchTo().alert().accept();
			
			 
			Assert.assertTrue(false);
			logger.warn("Login Failed");
			Thread.sleep(3000);

		} else {
			Assert.assertTrue(true);
			logger.info("Login passed");
			Thread.sleep(2000);
			lp.clickLogout();
			driver.switchTo().alert().accept(); // close logoout alert
			driver.switchTo().defaultContent();
			Thread.sleep(3000);
			
		}
		
	}
	
	public boolean isAlertPresent() throws InterruptedException {
		try {
			Thread.sleep(2000);
			driver.switchTo().alert();
			System.out.println("From inside isAlretPresent: "+driver.switchTo().alert().getText());
			return true;
		} catch(NoAlertPresentException e) {
			return false;
		}
		
	}
	
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException{
		String path=System.getProperty("user.dir")+"/src/test//java/com/inetbanking/testData/LoginData.xlsx";
		int rownum=XLUtils.getRowCount(path, "sheet1");
		int colcount=XLUtils.getCellCount(path, "sheet1", rownum);
		
		String logindata[][]=new String[rownum][colcount];
		for(int i=1; i <rownum; i++) {
			for (int j=0; j<colcount; j++) {
				logindata[i-1][j] = XLUtils.getCellData(path, "sheet1", i, j);
			}
		}
		return logindata;
	}
}
