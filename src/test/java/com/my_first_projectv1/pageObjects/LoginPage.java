package com.my_first_projectv1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) 
	{
		
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
    
	@FindBy(name = "email")
	WebElement txtuserName;
	
	
	@FindBy(name = "password")
	WebElement txtPassword;
	
	@FindBy(xpath = "//div[@class ='ui fluid large blue submit button']")
	WebElement btnLogin;
	
	public void setuserName(String uName) {
		
		txtuserName.sendKeys(uName);
		
	}
	
    public void setPassword(String Passw) {
		
    	txtPassword.sendKeys(Passw);
		
	}
    
    public void clickSubmit() {
    	btnLogin.click();
    }
}

