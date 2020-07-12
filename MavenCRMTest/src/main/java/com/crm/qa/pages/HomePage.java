package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.Base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath = "//div[@class='right menu']//child::span[contains(text(),'Girish Bagineni')]")
	WebElement UserNameLable;
	
	@FindBy(xpath = "//div[@id='main-nav']//child::a[contains(@href,'/contacts')]")
	WebElement ContactsLink;
	
	@FindBy(xpath = "//div[@id='main-nav']//child::a[@href='/deals']")
	WebElement DealsLink;
	
	public HomePage() {
		
		PageFactory.initElements(driver, this);
		}
	
	public String VerifyHomepageTitle() {
	       return driver.getTitle();
	}
	
	public boolean VerifyUserName() {
		
		return UserNameLable.isDisplayed();
		
	}
	
	public ContactsPage ClickOnContactsLink() {
		ContactsLink.click();
		return new ContactsPage(); // When you click on ContactsLink it navigates to contacts page and hence it returns object of contacts Page
		
	}
	
	public DealsPage ClickOnDealsLink() {
		DealsLink.click();
		return new DealsPage();// When you click on DealsLink it navigates to Deals page so, we are returning Object of Deals page i.e. 'new DealsPage()'
		
	}
	
	

}
