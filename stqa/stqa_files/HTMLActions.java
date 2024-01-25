package stqa_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HTMLActions {

	public static void main(String[] args) {

		String url1 = "https://demo.guru99.com/test/simple_context_menu.html";

		WebDriver browser = LaunchBrowsers.initializeBrowser("Firefox");
		browser.get(url1);
		browser.manage().window().maximize();

		Actions action = new Actions(browser);

		WebElement link = browser.findElement(By.xpath("//*[@id=\"authentication\"]/button"));
		WebElement rightClick = browser.findElement(By.xpath("//*[@id=\"authentication\"]/span"));
		WebElement quit = browser.findElement(By.xpath("//*[@id=\"authentication\"]/ul/li[7]"));
		WebElement clickEdit = browser.findElement(By.xpath("//*[@id=\"authentication\"]/ul/li[1]"));

		action.doubleClick(link).perform();
//		action.contextClick(rightClick).perform(); action.contextClick(clickEdit).perform();
//		action.contextClick(rightClick).perform(); action.contextClick(quit).perform();
	}

}
