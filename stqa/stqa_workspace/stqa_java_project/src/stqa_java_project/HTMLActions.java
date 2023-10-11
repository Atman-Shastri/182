package stqa_java_project;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class HTMLActions {
	
	public static void main(String[] args) {
		LaunchBrowsers browser = new LaunchBrowsers();
		String chromeDriverPath = "../../libs_and_drivers/chromedriver.exe";
		
		String url1 = "https://demo.guru99.com/test/simple_context_menu.html";
		
		WebDriver chrome = browser.initializeChrome(chromeDriverPath);
		chrome.get(url1);
		chrome.manage().window().maximize();
		Actions action = new Actions(chrome);
		
		WebElement link = chrome.findElement(By.xpath("//*[@id=\"authentication\"]/button"));
		
		action.doubleClick(link).perform();
		
	}

}
