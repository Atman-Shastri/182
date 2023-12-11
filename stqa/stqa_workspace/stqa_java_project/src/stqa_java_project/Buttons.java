package stqa_java_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Buttons {
	
	public static void main(String[] args) {
		LaunchBrowsers browser = new LaunchBrowsers();
		String chromeDriverPath = "../../libs_and_drivers/chromedriver.exe";
		
		String url1 = "https://demo.guru99.com/test/radio.html";
		
		WebDriver chrome = browser.initializeChrome(chromeDriverPath);
		chrome.get(url1);
		chrome.findElement(By.id("vfb-7-3")).click(); // Radio Button (Option 2)
		chrome.findElement(By.id("vfb-6-2")).click(); // Checkbox 2
		chrome.findElement(By.id("vfb-6-1")).click(); // CheckBox 3
		
	}

}
