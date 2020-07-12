/* All the Test classes are independent to each other, rememeber that in hybrid framework all the test cases should be independent and all the test classes should be independent 
 * there should be no link in between one test class to other test class
 * 
 * Note : Instead of running each test case one by one we create one runner class i.e. testNg.xml inside src/main/resources folder and then we run all the test cases in "com.crm.qa.TestCases" in a single shot
 * All the cases will run in a sequential order as mentioned in TestNG.xml file
 * You can comment any line in testng.xml file by right click -> source -> add block comment and also you can create template files like one for running sanity and the other for running regression.
 * Under sanity template file if you want to check only 10 test cases, then you can run only "TestNG_Sanity.xml" file. 
 * After the test cases are executed , right click on project and click on refresh -> test-output folder is generated , in which you can verify testng default report (index.html report) and emailable-report.html which
 * we can mail it to the manager.
 */



package com.crm.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.Base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	DealsPage dealspage;
	ContactsPage contactpage;
	String SheetName = "Contacts";
	TestUtil testUtil;
	
	public ContactsPageTest() {
		super();
		}
	
	@BeforeMethod
	public void SetUp() {
		Initialization();
		testUtil = new TestUtil();
		loginpage = new LoginPage(); // inorder to access loginpage methods you need to create an object of LoginPage
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactpage = homepage.ClickOnContactsLink();
		
	}
	
	@Test(priority = 1)
	public void VerifyContactsPageLableTest() {
		Assert.assertTrue(contactpage.verifyContactLable(),"Incorrect Label");
		}
	
    @Test(priority = 2)
	public void SelectSingleContactTest() throws InterruptedException {
    	driver.navigate().refresh();
    	driver.navigate().refresh();
    	Thread.sleep(2000);
		contactpage.SelectContactsByName("girish B B");
		Thread.sleep(3000);
	}
	
	@Test(priority = 3)
     public void SelectMultipleContactTest() throws InterruptedException{
		driver.navigate().refresh();
		Thread.sleep(2000);
		contactpage.SelectContactsByName("girish B B");
		contactpage.SelectContactsByName("suresh B");
		Thread.sleep(2000);
	}
	
	
/*  The problem here is we are passing hard coded values as parameters , so , if we want to 100 contacts with different set of data , for doing negative testing like
 * 	passing blank values or special  character values we have to pass , for that we are not going to change the values again and again so, we have to use data-driven 
 *  approach here with the help of data-provider, for that we will provide the data in excel sheet .
 *  
 *  Note : If the data provider is fetching the data from excel sheet then the  number of local variables in the method must be same as number of columns in the excel sheet.
 */
	
	@DataProvider
	public Object[][] GetCRMTestData() {
		Object data[][] = TestUtil.getTestData(SheetName);// Since TestUtil is a public class , you can access its method as classname.methodName
		return data;
	}
	
	
	// Page Object Model with data driven approach = Hybrid Framework
	@Test(priority = 4, dataProvider = "GetCRMTestData")
	public void validateCreateNewContact(String firstName, String LastName, String MiddleName) throws InterruptedException {// when u are fetching the data from excel file
		// as the excel file has 3 columns , 3 columns need to declared in the method as well 
		driver.navigate().refresh();
		driver.navigate().refresh();
		// contactpage.CreateNewContact("babu","jada","joseph");
		contactpage.CreateNewContact(firstName, LastName, MiddleName);
		Thread.sleep(2000);
		}
	
	
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
		
	}
	
	
}
