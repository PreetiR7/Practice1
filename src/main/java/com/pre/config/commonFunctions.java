package com.pre.config;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class commonFunctions {
	public WebDriver driver;
	
	//public commonFunctions() {
		//System.setProperty("webdriver.chrome.driver", "D:\\ThirdParty\\chromedriver.exe");
		//driver = new ChromeDriver();
		//driver.manage().window().maximize();
		//driver.get("https://www.amazon.com");
		//driver.manage().timeouts().implicitlyWait(11, TimeUnit.SECONDS);
	//}
	
	public commonFunctions(WebDriver d)
	{
		this.driver = d;		
	}
	/**
	 * Buttons, check box, links, radio buttons
	 * Locator - From OR
	 * @param locator
	 * @param ename
	 */
	public void click(By locator) {
		driver.findElement(locator).click();
	}
	
	public void type(By locator, String testData) {
		driver.findElement(locator).sendKeys(testData);
	}
	
	public void moveElement(By locator) {
		Actions a = new Actions(driver);
		WebElement elem = driver.findElement(locator);
		a.moveToElement(elem).click().build().perform();
	}
}
