package com.hrms.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrms.pages.LoginPage;
import com.hrms.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;

public class LoginPageTest extends CommonMethods {
	// Test case to validate valid login
	@Test(groups="smoke")
	public void login() {
	
		LoginPageElements login1 = new LoginPageElements();
		sendText(login1.username, ConfigsReader.getProperty("username"));
		sendText(login1.password, ConfigsReader.getProperty("password"));
		click(login1.loginBtn);
		takeScreenshot("LoginPageTest1");
		
	}

	/*
	 * Navigate to HRMS Enter uid leave password field blank click login verify
	 * "Password cannot be empty" text close browser
	 */
	@Test(groups="regression")
	public void negativeLogin() throws InterruptedException {
		LoginPageElements login = new LoginPageElements();
		sendText(login.username, ConfigsReader.getProperty("username"));
		click(login.loginBtn);
		String expectedError = "Password cannot be empty";
		Assert.assertEquals(login.errorMsg.getText(), expectedError, "Error message text is not matched");
		Thread.sleep(5000);
	}
}