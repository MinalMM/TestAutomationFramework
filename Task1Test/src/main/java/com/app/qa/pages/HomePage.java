package com.app.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.app.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//td[contains(text(),'User: M M')]")
	@CacheLookup
	WebElement userNameLabel;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	
	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink(){
		contactsLink.click();
		return new ContactsPage();
	}
	
	/*
	 * public DealsPage clickOnDealsLink(){ dealsLink.click(); return new
	 * DealsPage(); }
	 * 
	 * public TasksPage clickOnTasksLink(){ tasksLink.click(); return new
	 * TasksPage(); }
	 */
	
	public void clickOnNewContactLink(){
		Actions action = new Actions(driver);
		
		  action.moveToElement(contactsLink).build().perform(); 
		  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		  wait.until(ExpectedConditions.elementToBeClickable(newContactLink));
		  newContactLink.click();
	}
	
}
