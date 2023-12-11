package stqa_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Buttons {

	public static void main(String[] args) {

		String url1 = "https://demo.guru99.com/test/radio.html";

		WebDriver browser = LaunchBrowsers.initializeBrowser("chrome");
		browser.get(url1);
		browser.findElement(By.id("vfb-7-3")).click(); // Radio Button (Option 2)
		browser.findElement(By.id("vfb-6-2")).click(); // Checkbox 2
		browser.findElement(By.id("vfb-6-1")).click(); // CheckBox 3

	}

}
