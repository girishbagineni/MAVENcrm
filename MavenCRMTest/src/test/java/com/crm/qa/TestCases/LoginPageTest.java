/* Here, LoginPageTest class extends TestBase class
 * create a constructor of loginpageTest and use super keyword as it will call super class constrtuctor in which property file is initialised and then @BeforeMethod will run
 * In @BeforeMethod amnnotation run initialization method , since LoginPageTest class is inheriting TestBase class methods it can access the methods
 * Then create the object of LoginPage class under the setup method so that when we are executing the cases in @Test , we can access all the methods of the class 
 * If you click on ctr+shift+o , then automatically all the imports will be added.
 */


package com.crm.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.Base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;  // I am declaring the variable as global so that i can use them in any class
	HomePage homepage;
	
	public LoginPageTest() {
		super();
		
	}
	
	@BeforeMethod
	public void setup() {
		Initialization();
		loginpage = new LoginPage(); // Create an object of loginPage class
		
		}
	
	@Test(priority=1)
	public void LoginPageTitle() {
		String Title = loginpage.ValidateLoginPageTitle(); // Since, the method ValidateLoginPageTitle() in LoginPage class returns a string instead of void we
		// can assign it to a string value for validating the case, hence we use return statement in LoginPage class , so that we can compare the actual with expected result
		Assert.assertEquals(Title, "Cogmento CRM");
		}
	
	@Test(priority=2)
	public void LoginTest() {
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password")); 
		// Its returning object of HomePage class which i am assigning it to Homepage variable of class HomePage , so the case is passed as when i pass the username password we are navigating to homepage	
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
		
	}
	

}
