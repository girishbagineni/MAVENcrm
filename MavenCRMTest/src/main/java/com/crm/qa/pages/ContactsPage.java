/* Here, I want to verify clicking on check boxes in contacts page , so suppose if there exist many contacts you cannot ceate multiple @FindBy for each contacts
 * 
 * 
 * 
 */

package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.Base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//div[contains(@class,'ui fluid')]//descendant::div[contains(@class,'ui header')]")
	WebElement ContactsLabel;
	
	
	@FindBy(xpath = "//a[contains(@href,'/contacts/new')]//child::button")
	WebElement NewLink;
	
	@FindBy(xpath = "//input[@name='first_name']")
	WebElement FirstName;
	
	@FindBy(xpath = "//input[@name='last_name']")
	WebElement LastName;
	
	@FindBy(xpath = "//input[@name='middle_name']")
	WebElement MiddleName;
	
	@FindBy(xpath = "//div[contains(@class,'item')]//child::button[@class='ui linkedin button']")
	WebElement SaveBtn;
	
	public ContactsPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactLable() { // To verify if the contacts label is present
		return ContactsLabel.isDisplayed();
		
	}
// This is the method created to identify the element i.e. checkbox with different names and perform some action on it.
	public void SelectContactsByName(String name) throws InterruptedException { // This method is for finding any available contacts checkbox element and performing action on it
	   WebElement check = driver.findElement(By.xpath("//td[text()='"+name+"']//preceding-sibling::td[@class='']//descendant::div[contains(@class,'ui fitted')]"));
		Thread.sleep(2000);
		check.click();
	}
	
	public void CreateNewContact(String Fname, String Lname, String Mname) {
		NewLink.click();
		FirstName.sendKeys(Fname);
		LastName.sendKeys(Lname);
		MiddleName.sendKeys(Mname);
		SaveBtn.click();
		
		}
	
	
		
}
	
	


