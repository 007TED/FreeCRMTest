package com.crm.qa.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	
	public HomePageTest() {
		super(); // to inherit prop properties of base class
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	// test cases should be independent 
	// before each tc launch browser and login
	// execute tc 
	// after tc close the browser
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
	String homePageTitle =	homePage.verifyHomePageTitle();
	Assert.assertEquals(homePageTitle, "CRMPRO", "HOME PAGE TITLE NOT MATCHED");
	}

	@Test(priority=2)
	public void verifyCorrectUserNameTest() {
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest() {
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
