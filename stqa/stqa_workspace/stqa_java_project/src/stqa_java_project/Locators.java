package stqa_java_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {
	
	public static void main(String[] args) {
		LaunchBrowsers browser = new LaunchBrowsers();
		String chromeDriverPath = "../../libs_and_drivers/chromedriver.exe";
		
		String url1 = "http://demo.guru99.com/test/facebook.html";
		
		WebDriver chrome = browser.initializeChrome(chromeDriverPath);
		chrome.get(url1);
		chrome.findElement(By.name("email")).sendKeys("Sandeep");
		chrome.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("Password"); 
		chrome.findElement(By.xpath("//*[@id=\"u_0_b\"]")).click();
	}

}
