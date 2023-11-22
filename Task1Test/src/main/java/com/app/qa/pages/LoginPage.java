package com.app.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.app.qa.base.TestBase;

import io.qameta.allure.Step;


public class LoginPage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(xpath="//*[@name='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//a[@Class='navbar-brand']//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	@Step("Getting login page title step....")
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	@Step("Getting application logo step....")
	public boolean validateCRMImage(){
		return crmLogo.isDisplayed();
	}
	
	@Step("Login with username: {0} and password: {1} step...")
	public HomePage login(String un, String pwd) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("preloader")));
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
	
}
