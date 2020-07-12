/*
 * test cases should be separated -- independent with each other
	before each test case -- launch the browser and login
	@test -- execute test case
	after each test case -- close the browser

 */



package com.crm.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.Base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	DealsPage dealspage;
	ContactsPage contactpage;
	
	public HomePageTest() {
		super();
		
	}

	@BeforeMethod
	public void SetUp() {
	Initialization();
	loginpage = new LoginPage(); // inorder to access loginpage methods you need to create an object of LoginPage
	homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password")); 
	}
	
	@Test(priority=1)
	public void TestHomePageTitle() {
		String title =  homepage.VerifyHomepageTitle();
		Assert.assertEquals(title, "Cogmento CRM", "Homepage title not matched");
		}
	
	@Test(priority=2)
	public void TestHomePageUserName() {
		homepage.VerifyUserName();
		Assert.assertTrue(homepage.VerifyUserName());
		
	}
	
	@Test(priority=3)
	public void TestClickonContactsLink() {
		contactpage = homepage.ClickOnContactsLink();
		
	}
	
	@Test(priority=4)
	public void TestClickonDealsLink() {
		dealspage = homepage.ClickOnDealsLink();
		
	}
	
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
		
	}
	
	
}
