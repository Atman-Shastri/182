package data.driven;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import stqa_java_project.LaunchBrowsers;

public class DataProvider {
	static String excelFile = "../../credentials.xlsx";
	static String sheetName = "credentials";

	public static void main(String[] args) throws IOException {
		LaunchBrowsers browser = new LaunchBrowsers();
		String chromeDriverPath = "../../libs_and_drivers/chromedriver.exe";
		WebDriver chrome = browser.initializeChrome(chromeDriverPath);

		String url = "https://demo.guru99.com/test/newtours/";
		chrome.get(url);

		FileInputStream fileInputStream = new FileInputStream(excelFile);
		XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		int lastRow = sheet.getLastRowNum();
		for (int i = 0; i < lastRow; i++) {
			XSSFRow row = sheet.getRow(i);
			XSSFCell usernameCell = row.getCell(0);
			XSSFCell passwordCell = row.getCell(1);
			XSSFCell resultCell = row.createCell(2);
			chrome.findElement(By.name("userName")).sendKeys(usernameCell.toString());
			chrome.findElement(By.name("password")).sendKeys(passwordCell.toString());
			chrome.findElement(By.name("submit")).click();

			try {
				chrome.findElement(By.xpath("")).click();
				System.out.println("Valid Login");
				resultCell.setCellValue("Valid Login");
			} catch (Exception exception) {
				resultCell.setCellValue("Invalid Login");
			}
			fileInputStream.close();
			FileOutputStream fileOutputStream = new FileOutputStream(excelFile);
			workbook.write(fileOutputStream);
		}
	}

}
