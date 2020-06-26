package com.my_first_projectv1.testcases;

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

public class BaseClass {
	
	
	public String BaseUrl = "http://demo.guru99.com/V1/index.php";
	public String Uname = "mngr257081";
	public String Pwd = "unUpyra";
	
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeClass
	public void Setup() {
		System.setProperty("webdriver.gecko.driver", "C:\\selenuim_practice\\my_first_projectv1\\Drivers\\geckodriver.exe");
		driver= new FirefoxDriver();
		
		logger=Logger.getLogger("My First Banking Project");
		PropertyConfigurator.configure("Log4j.properties");
		
	}

	@AfterClass
	public void Teardown() {
		driver.quit();
	}
	
	public void FailedTestScreenshot(String Testmethodname) throws IOException {
		
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile, new File("C:\\selenuim_practice\\my_first_projectv1\\Screenshots/"+Testmethodname+".png"));
	}
	
	
	
}

