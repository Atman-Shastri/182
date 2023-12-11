package testNG;

import org.testng.annotations.Test;

import stqa_package.LaunchBrowsers;

import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;

public class Tests {
	@SuppressWarnings("deprecation")
	@Test(dataProvider = "dp")
	public void f(String userName, String password) {
		String url1 = "https://opensource-demo.orangehrmlive.com/";
		WebDriver browser = LaunchBrowsers.initializeBrowser("chrome");
		browser.get(url1);

		browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		browser.findElement(By.name("username")).sendKeys(userName);// locator id
		browser.findElement(By.name("password")).sendKeys(password);// locater name
		browser.findElement(By.tagName("button")).click();// locator className
		try {
			String dashboardXpath = "//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6";
			String dashboardText = browser.findElement(By.xpath(dashboardXpath)).getText(); // locator partiallinkText
			boolean isDashboard = (dashboardText.equalsIgnoreCase("dashboard")) ? true : false ;
			if(isDashboard)
				System.out.println("Pass");
			else
				throw new Exception();

		} catch (Exception e) {
			Assert.fail("Failed Login");
			System.out.println("Fail");
			
		}

	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { "admin", "admin123" }, new Object[] { "add", "b" }, };
	}
}
