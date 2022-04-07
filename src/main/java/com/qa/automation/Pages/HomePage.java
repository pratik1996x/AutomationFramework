package com.qa.automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.automation.TestBase.TestBase;
import com.qa.automation.Util.Utilities;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//li[@id='menu-item-40']")
	private WebElement  shop;

	@FindBy(xpath="//li[@id='menu-item-50']")
	private WebElement  myaccount;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnMyAccount() {
		WebElement myacc = Utilities.explicitWait(myaccount, 5);
		myacc.click();
	}
	
	public void clickOnShop() {
		WebElement sh=Utilities.explicitWait(shop, 5);
		sh.click();
	}
}
