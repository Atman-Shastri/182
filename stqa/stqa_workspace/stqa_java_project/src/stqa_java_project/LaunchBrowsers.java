package stqa_java_project;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LaunchBrowsers {

	public static void main(String[] args) {
		System.out.println("Atman Shastri, 182");
		String chromeDriverPath = "../../libs_and_drivers/chromedriver.exe";
		String firefoxDriverPath = "../../libs_and_drivers/geckodriver.exe";
		String edgeDriverPath = "../../libs_and_drivers/IEDriverServer.exe";
		
		String url = "https://www.google.com";
		
		LaunchBrowsers browser = new LaunchBrowsers();
		
		// Run Chrome
//		WebDriver chrome = browser.initializeChrome(chromeDriverPath);
//		chrome.get(url);
		
		 //Run FireFox
//		WebDriver firefox = browser.initializeFirefox(firefoxDriverPath);
//		firefox.get(url);
		 
		
//		 Run Edge
		WebDriver edge = browser.initializeEdge(edgeDriverPath);
		edge.get(url);
		
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
