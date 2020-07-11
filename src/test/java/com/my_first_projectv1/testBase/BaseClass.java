package com.my_first_projectv1.testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.text.DateFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestNGListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.my_first_projectv1.pageObjects.HomePage;
import com.my_first_projectv1.pageObjects.LoginPage;



public class BaseClass {
	
	
	public String BaseUrl = "https://ui.cogmento.com/home";
	public String Uname = "Surajsharmapatna@gmail.com";
	public String Pwd = "Sharma5134";
	
	public static WebDriver driver;

    public ExtentHtmlReporter htmlreporter;
    public ExtentReports extent;
    public ExtentTest test;
    
     	
	@BeforeMethod
	public void Setup() {
		System.setProperty("webdriver.gecko.driver", "C:\\selenuim_practice\\my_first_projectv1\\Drivers\\geckodriver.exe");
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	}
	
	@BeforeTest
    public void SetExtent() {
    	
    	htmlreporter= new ExtentHtmlReporter(System.getProperty("user.dir"+ "/test-output/Extenthtmlreport.html" ));
    	
    	htmlreporter.config().setDocumentTitle("CRM Automation Testing");
    	htmlreporter.config().setReportName("Functional Test");
    	htmlreporter.config().setTheme(Theme.DARK);
    	extent = new ExtentReports();
    	extent.attachReporter(htmlreporter);
    	
    	extent.setSystemInfo("HOSTNAME", "Localhost");
    	extent.setSystemInfo("OS", "Windows 10");
    	extent.setSystemInfo("Tester's Name", "Anshika");
    	extent.setSystemInfo("Browser", "Firefox");
    	
    }
	

	@AfterMethod
	public void Teardown() {
		
//		if (result.getStatus()==ITestResult.FAILURE) {
//			
//			test.log(Status.FAIL, result.getName()+" : Test case is FAILED");    //to add name in Extent report
//			test.log(Status.FAIL, result.getThrowable());     //to add Exception details in Extent report
//			
//			String ScreenshoPath = BaseClass.FailedTestScreenshot(result.getName());
//			test.addScreenCaptureFromPath(ScreenshoPath);   //Adding Screenshot to Extent Report.
//		}else if (result.getStatus() ==ITestResult.SKIP){
//			test.log(Status.SKIP, result.getName()+ " : Test case is SKIPPED");
//			test.log(Status.SKIP, result.getThrowable());
//		}else if (result.getStatus()==ITestResult.SUCCESS) {
//			test.log(Status.PASS, result.getName()+ " : Test Case PASSED.");
//		}
		
		driver.quit();
	}
	
	
	public void LoginToCRM() {
		LoginPage lp = new LoginPage(driver);
		lp.setuserName(Uname);
		lp.setPassword(Pwd);
		lp.clickSubmit();
	}
	
    public void Logout() {
    	HomePage hp = new HomePage(driver);
	    hp.ClickonSettings();
		hp.Clickonlogout();;
		
	}
    
    
    
//    @AfterClass
//    public void endExtentReport() {
//    	
//    	extent.flush();
//    	
//    }
	
	
	public static String FailedTestScreenshot(String Testmethodname) throws IOException {
		String DateName = new SimpleDateFormat("YYYYMMDDMMSS").format(new Date());
		
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    String Destination = System.getProperty("user.dir") + Testmethodname+DateName+".png";
		File DestinationFile = new File(Destination);
		FileUtils.copyFile(srcfile, DestinationFile);
	    return 	Destination; 
	
	}
	
	
	
}

