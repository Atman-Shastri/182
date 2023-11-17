package testng;

import org.testng.annotations.Test;

import stqa_java_project.LaunchBrowsers;

import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;

public class NewTest2 {
	@Test(dataProvider = "dp")
	public void f(Integer n, String s) {
		LaunchBrowsers browser = new LaunchBrowsers();
		String chromeDriverPath = "../../libs_and_drivers/chromedriver.exe";

		String url1 = "https://opensource-demo.orangehrmlive.com/";

		WebDriver chrome = browser.initializeChrome(chromeDriverPath);
		chrome.get(url1);

		chrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		chrome.findElement(By.id("txtUsername")).sendKeys("u");// locator id
		chrome.findElement(By.name("txtPassword")).sendKeys("p");// locater name
		chrome.findElement(By.className("button")).click();// locator className
		try {
			chrome.findElement(By.partialLinkText("Welcome")).click();// locator partiallinkText

			chrome.findElement(By.linkText("Logout")).click();// locator linkText
			System.out.println("Pass");

		} catch (Exception e) {
			System.out.println("Fail");
		}

	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { 1, "a" }, new Object[] { 2, "b" }, };
	}
}
