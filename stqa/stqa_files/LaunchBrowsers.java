package stqa_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LaunchBrowsers {

	public static WebDriver initializeBrowser(String browserName) {
		browserName = browserName.toLowerCase();
		switch (browserName) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "libs_and_drivers/chromedriver.exe");
			WebDriver chrome = new ChromeDriver();
			return chrome;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "libs_and_drivers/geckodriver.exe");
			WebDriver firefox = new FirefoxDriver();
			return firefox;
		case "edge":
			System.setProperty("webdriver.ie.driver", "libs_and_drivers/IEDriverServer.exe");
			WebDriver edge = new InternetExplorerDriver();
			return edge;
		default:
			System.setProperty("webdriver.gecko.driver", "libs_and_drivers/geckodriver.exe");
			WebDriver defaultFirefox = new FirefoxDriver();
			return defaultFirefox;
		}
	}
}
