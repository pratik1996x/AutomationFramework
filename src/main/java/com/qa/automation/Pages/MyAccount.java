package com.qa.automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.automation.TestBase.TestBase;

public class MyAccount extends TestBase{

	@FindBy(xpath="//input[@id='username']")
	private WebElement username;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement login;
	
	public MyAccount() {
		PageFactory.initElements(driver, this);
	}
	
	public void enterUsername(String usr) {
		username.sendKeys(usr);
	}
	
	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void clickOnLogin() {
		login.click();
	}
}
