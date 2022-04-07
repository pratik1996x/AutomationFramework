package com.qa.automation.TestCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.automation.Pages.HomePage;
import com.qa.automation.Pages.MyAccount;
import com.qa.automation.TestBase.TestBase;
import com.qa.automation.Util.ExcelHandler;

public class Login extends TestBase {

	HomePage home;
	MyAccount myaccount;
	
	@BeforeMethod
	public void setup() {
		intialization();
		home=new HomePage();
		myaccount=new MyAccount();
	}
	
	@Test(priority=1,dataProvider="logindata",dataProviderClass=ExcelHandler.class)
	public void loginTest(String usr,String pwd) {

		home.clickOnMyAccount();
		myaccount.enterUsername(usr);
		myaccount.enterPassword(pwd);
		myaccount.clickOnLogin();
	}

}
