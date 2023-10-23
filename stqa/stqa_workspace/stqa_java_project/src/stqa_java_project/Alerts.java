package stqa_java_project;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Alerts {

	public static void main(String[] args) {
		LaunchBrowsers browser = new LaunchBrowsers();
		String chromeDriverPath = "../../libs_and_drivers/chromedriver.exe";
		WebDriver chrome = browser.initializeChrome(chromeDriverPath);
		
		String url = "https://demo.guru99.com/test/delete_customer.php";
		chrome.get(url);
		
		chrome.findElement(By.name("cusid")).sendKeys("Atman");
		chrome.findElement(By.name("submit")).click();
		
		Alert alert = chrome.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("Alert is: " + alertText);
		
		alert.accept();
		String newAlertText = alert.getText();
		System.out.println("New Alert is: " + newAlertText);
		alert.accept();
	}

}
