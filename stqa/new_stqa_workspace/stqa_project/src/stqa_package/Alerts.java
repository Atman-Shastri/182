package stqa_package;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Alerts {

	public static void main(String[] args) {

		WebDriver browser = LaunchBrowsers.initializeBrowser("Chrome");

		String url = "https://demo.guru99.com/test/delete_customer.php";
		browser.get(url);

		browser.findElement(By.name("cusid")).sendKeys("Atman");
		browser.findElement(By.name("submit")).click();

		Alert alert = browser.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("Alert is: " + alertText);
		alert.accept();
		String newAlertText = alert.getText();
		System.out.println("New Alert is: " + newAlertText);
		alert.accept();
	}
}
