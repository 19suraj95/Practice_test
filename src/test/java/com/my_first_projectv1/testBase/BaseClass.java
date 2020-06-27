package com.my_first_projectv1.testBase;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.my_first_projectv1.pageObjects.LoginPage;

public class BaseClass {
	
	
	public String BaseUrl = "https://ui.cogmento.com/home";
	public String Uname = "Surajsharmapatna@gmail.com";
	public String Pwd = "Sharma5134";
	
	public static WebDriver driver;

	
	@BeforeClass
	public void Setup() {
		System.setProperty("webdriver.gecko.driver", "C:\\selenuim_practice\\my_first_projectv1\\Drivers\\geckodriver.exe");
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		
	}

	@AfterClass
	public void Teardown() {
		driver.quit();
	}
	
	
	public void LoginToCRM() {
		
		LoginPage lp = new LoginPage(driver);
		lp.setuserName(Uname);
		
		lp.setPassword(Pwd);
		
		lp.clickSubmit();
	}
	
	public void FailedTestScreenshot(String Testmethodname) throws IOException {
		
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile, new File("C:\\selenuim_practice\\my_first_projectv1\\Screenshots/"+Testmethodname+".png"));
	}
	
	
	
}

