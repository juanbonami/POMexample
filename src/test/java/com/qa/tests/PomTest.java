package com.qa.tests;
import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.repo.AddUser;
import com.qa.repo.HomePage;
import com.qa.repo.Login;


public class PomTest {
	
	String driverPath = "src/test/resources/chromedriver.exe";
	String url = "https://www.google.com";
	
	static WebDriver driver;
	
	@BeforeClass
	public static void init() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();
	}
	
	@Before
	public void setup() {
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get(HomePage.getUrl());
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
	
	@Test
	public void test() throws InterruptedException {
		HomePage nav = PageFactory.initElements(driver, HomePage.class);
		AddUser add = PageFactory.initElements(driver, AddUser.class);
		Login login = PageFactory.initElements(driver, Login.class);
		
		nav.navAddUser();
		Thread.sleep(2000);
		add.signUp("test", "test1");
		Thread.sleep(2000);
		
		nav.navLogin();
		Thread.sleep(2000);
		login.signIn("test", "test1");
		assertEquals("**Successful Login**", driver.findElement(By.xpath("//b[contains(text(),'**Successful Login**')]")).getText());
		Thread.sleep(2000);
	}

}
