package com.nopcommerce.testCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.nopcommerce.pageObjects.LoginPage;


public class TC_LoginTest extends BaseClass {
	
	
		
	@Test
	public void loginTest() throws InterruptedException, IOException
	{
		
		driver.get(baseURL);
		
		logger.info("URL is opened....");
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("user provided");
		
		lp.setPassword(password); 
		logger.info("password provided");
		
		
		lp.clickLogin();
		
		logger.info("Login is clicked...");
		
		
		Thread.sleep(5000);
		
		if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			Assert.assertTrue(true);
			lp.clickLogout();
			logger.info("login passed");
			
		}else
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			
			logger.info("login failed");
			
			
		}
			
	}
	
	
	
	

}
