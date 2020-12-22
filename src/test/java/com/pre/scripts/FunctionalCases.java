package com.pre.scripts;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.pre.config.commonFunctions;
import ObjectReposit.AmazonHomePage;
import ObjectReposit.LoginPage;

public class FunctionalCases {
	
	public WebDriver driver;
	commonFunctions cFunction;
	
	@Parameters("Browser")	
	@BeforeTest(groups="sanity")
	public void Setup(String B) {
		if(B.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "D:\\ThirdParty\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(B.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\ThirdParty\\Firef\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
			driver.manage().window().maximize();
			driver.get("https://www.amazon.com");
			cFunction = new commonFunctions(driver);
		}
	
	@Test(groups= "sanity")
	public void search() {
		//cFunction.moveElement(AmazonHomePage.txtSearch);
		cFunction.type(AmazonHomePage.txtSearch, "Phone");	
		cFunction.click(AmazonHomePage.goClick);
	}
		
	@Test
	public void login() {
		 cFunction.click(LoginPage.btnInitialSignIn);
		 cFunction.type(LoginPage.txtEmail, "7986523921");
		 cFunction.click(LoginPage.btnContinue);
		 cFunction.type(LoginPage.txtPass, "OmSaiRam786#");
		 cFunction.click(LoginPage.btnSignIn);
	}
	//enabled = false to skip test cases
	//if two or more methods have the same priorities in TestNG, then their running test sequence is alphabetic
	
	//@Test (priority=1)
	
}
