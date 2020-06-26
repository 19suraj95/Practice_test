package com.my_first_projectv1.testcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.testng.AssertJUnit;



import com.my_first_projectv1.pageObjects.LoginPage;

@Listeners(customListener.class)
public class TC_login_Testcase_001 extends BaseClass{

	@Test
	public void LoginTest() {
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get(BaseUrl);
		
		
		logger.info("URL is Opened");
		
		LoginPage lp = new LoginPage(driver);
		lp.setuserName(Uname);
		
		logger.info("User Name Entered Successfully");
		
		lp.setPassword(Pwd);
		logger.info("Password Entered Successfully");
		
		lp.clickSubmit();
		
		logger.info("Clicked on Submit Button");
		
		if (driver.getTitle().equals("GTPL Bank Manager HomePage"))
		{
			AssertJUnit.assertTrue(true);
		}
		else {
			AssertJUnit.assertTrue(false);
		}
	}
	
}

