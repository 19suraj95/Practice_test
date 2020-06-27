package com.my_first_projectv1.testcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.testng.AssertJUnit;

import com.my_first_projectv1.Listeners.customListener;
import com.my_first_projectv1.pageObjects.HomePage;
import com.my_first_projectv1.testBase.BaseClass;

@Listeners(customListener.class)
public class TC_login_Testcase_001 extends BaseClass{

	@Test
	public void LoginTest() throws InterruptedException {
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(BaseUrl);
		
		
		LoginToCRM();
	    
		Thread.sleep(4000);
		
		if (driver.getTitle().equalsIgnoreCase("Cogmento CRM"))
		{
			AssertJUnit.assertTrue(true);
		}
		else {
			AssertJUnit.assertTrue(false);
			
		}
		
		Logout();
	}
	
	
	
}

