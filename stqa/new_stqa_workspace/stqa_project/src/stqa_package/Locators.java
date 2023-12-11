package stqa_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Locators {
	
	public static void main(String[] args) {
		
		String url1 = "http://demo.guru99.com/test/facebook.html";
		
		WebDriver chrome = LaunchBrowsers.initializeBrowser("firefox");
		chrome.get(url1);
		chrome.findElement(By.name("email")).sendKeys("Atman");
		chrome.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("Password"); 
		chrome.findElement(By.xpath("//*[@id=\"u_0_b\"]")).click();
	}

}
