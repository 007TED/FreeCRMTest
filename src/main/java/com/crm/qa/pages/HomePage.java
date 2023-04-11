package com.crm.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	
	@FindBy(xpath = "//td[contains(text(),'User: GAVISH SETHI')]")
	@CacheLookup
	WebElement userNameLabel;
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(xpath = "//a[(@title='Contacts')]")
	WebElement contactsLinkOnContactsPage;
	
	@FindBy(xpath = "//a[(@title='New Contact')]")
	WebElement newContactsLinkOnContactsPage;

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;


	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
//initializing the page objects
	
	public HomePage() {
		PageFactory.initElements(driver ,  this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	public DealsPage clickOnDealsLink(){
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink(){
		tasksLink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactLink(){
	//	driver.switchTo().frame("mainpanel");
		System.out.println(" action start ");
		Actions action = new Actions(driver);

		//action.moveToElement(contactsLink).build().perform();
		
		action.moveToElement(contactsLinkOnContactsPage).build().perform();

		newContactsLinkOnContactsPage.click();
		System.out.println(" clicked on new contact ");
	}
	


}