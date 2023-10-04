package stqa_java_project;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LaunchBrowsers {

	LaunchBrowsers(){
		

		
	}

	public WebDriver initializeChrome(String chromeDriverPath) {
		System.setProperty("webdriver.chrome.driver",chromeDriverPath);
		WebDriver chrome = new ChromeDriver();
		return chrome;
	}
	
	public WebDriver initializeFirefox(String firefoxDriverPath) {
		System.setProperty("webdriver.gecko.driver",firefoxDriverPath);
		WebDriver firefox = new FirefoxDriver();
		return firefox;
	}
	
	public WebDriver initializeEdge(String edgeDriverPath) {
		System.setProperty("webdriver.ie.driver",edgeDriverPath);
		WebDriver edge = new InternetExplorerDriver();
		return edge;
	}
}

