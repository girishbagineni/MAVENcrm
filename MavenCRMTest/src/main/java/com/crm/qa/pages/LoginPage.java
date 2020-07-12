/* In this class i will find all the webElements and the actions performed on those webElements
 * Loginpage.java is inheriting the properies of TestBase.java class , as it belongs to the 'com.crm.qa.base.TestBase' package , just import it as page class is extending base class
 * In Login class : We have to define the object repository/ Page factory of login page, we have to use @findBy() annotation.
 * 
 * We are not writing the test cases in LoginPage.java class, we are just defining the page libraries
 * 
 * With the help of @findBy we have created around  5 to 6 web Elements of that particular page , now we have to initialise all these object repositories ,
 * How to initialise element with the help of page factory : We have one method Pagefactory.initElements(driver,this); 
 * 
 * After clicking on login button its moving to Homepage , so , this Login page method should return Homepage class object
 * 
 * Note : To get all the imports automatically , click on ctrl+shift+o
 */
 

package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.Base.TestBase;

public class LoginPage extends TestBase{
	
	
	
	@FindBy(xpath = "//div[@class='field']//following-sibling::div[starts-with(@class,'ui fluid')]")
	WebElement LoginBtn;
	
	@FindBy(xpath = "//form[contains(@class,'ui')]//following-sibling::div//child::a[text()='Sign Up']")
	WebElement SignUpBtn;
	
	@FindBy(name = "email")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	public String ValidateLoginPageTitle() {
		return driver.getTitle();
		
		}
	
	public HomePage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		LoginBtn.click();
		return new HomePage();
		    	
	}    	
		
}	
	
	
	
	
	
	
	
	


