package com.my_first_projectv1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
WebDriver ldriver;
	
	public HomePage(WebDriver rdriver) 
	{
		
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//i[@class ='settings icon']")
	WebElement settingicn;
	
	
	@FindBy(xpath = "//i[@class ='power icon']")
	WebElement logout;
	
	public void ClickonSettings() {
		settingicn.click();
		
	}
	
	public void Clickonlogout() {
		logout.click();
		
	}
	
	@FindBy(linkText = "Calendar")
	WebElement clndr;
	
	@FindBy(linkText = "Contacts")
	WebElement Contacts;
	
	@FindBy(linkText = "Companies")
	WebElement Company;
	
	@FindBy(linkText = "Deals")
	WebElement Deals;
	
	@FindBy(linkText = "Tasks")
	WebElement Tasks;
	
	@FindBy(linkText = "Cases")
	WebElement Cases;
	
	@FindBy(linkText = "Documents")
	WebElement Documents;
	
	@FindBy(linkText = "Email")
	WebElement Emails;
	
	@FindBy(linkText = "Campaigns")
	WebElement Campaigns;
	
	@FindBy(linkText = "Forms")
	WebElement Forms;
	
	
	
	
        public void ClinkonContacts() {
		
        	Contacts.click();
        }
        public void ClinkonCalender() {
    		
        	clndr.click();
        }
        
        public void ClinkonCompany() {
    		
        	Company.click();
        }
        
        public void ClinkonDeals() {
    		
        	Deals.click();
        }
        
        public void ClinkonTasks() {
    		
        	Tasks.click();
        }
        
        public void ClinkonCases() {
    		
        	Cases.click();
        }
        
        public void ClinkonDocuments() {
    		
        	Documents.click();
        }
        
        public void ClinkonEmails() {
    		
        	Emails.click();
        }
        
        public void ClinkonCampaigns() {
    		
        	Campaigns.click();
        }
        
        
        public void ClinkonForms() {
    		
        	Forms.click();
        }
	
	
	
	
}
