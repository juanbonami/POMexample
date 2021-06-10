package com.qa.repo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	private static final String url = "http://thedemosite.co.uk/";
	
	// navigation - add user
	@FindBy(xpath = "//a[contains(text(),'3. Add a User')]")
		private WebElement addUser;
	
	// navigation - login
	@FindBy(xpath = "//a[contains(text(),'4. Login')]")
		private WebElement login;

	public static String getUrl() {
		return url;
	}
	
	public void navAddUser() {
		addUser.click();
	}
	
	public void navLogin() {
		login.click();
	}
	
	

}
