package com.app.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.app.qa.base.TestBase;

import io.qameta.allure.Step;

public class LogoutPage extends TestBase{
	LoginPage loginPage;
	
	@FindBy(xpath="(//a[@Class='topnavlink'])[3]")
	WebElement logoutBtn;
	
	public LogoutPage() {
		PageFactory.initElements(driver, this);
	}
	
	@Step("Checking Logout button availability....")
	public boolean validateLogoutBtn(){
		return logoutBtn.isDisplayed();
	}
	
	@Step("Clicking on Logout button and returing to login page....")
	public LoginPage clickOnLogoutBtn() {
		logoutBtn.click();
		return new LoginPage();
	}

}
