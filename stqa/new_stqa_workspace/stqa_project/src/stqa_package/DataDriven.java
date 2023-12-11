package stqa_package;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DataDriven {
	static String excelFile = "credentials.xlsx";
	static String sheetName = "credentials";

	public static void main(String[] args) throws IOException {
		WebDriver browser = LaunchBrowsers.initializeBrowser("firefox");

		String url = "https://demo.guru99.com/test/newtours/";
		browser.get(url);

		FileInputStream fileInputStream = new FileInputStream(excelFile);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		int lastRow = sheet.getLastRowNum();
		for (int i = 1; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);
			XSSFCell usernameCell = row.getCell(0);
			XSSFCell passwordCell = row.getCell(1);
			XSSFCell resultCell = row.createCell(2);
			browser.findElement(By.name("userName")).sendKeys(usernameCell.toString());
			browser.findElement(By.name("password")).sendKeys(passwordCell.toString());
			browser.findElement(By.name("submit")).click();

			try {
				String statusButtonXpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]";
				String assertion = browser.findElement(By.xpath(statusButtonXpath)).getText();
				boolean buttonIsNotSignOff = assertion.equalsIgnoreCase("sign-off") ? false : true;
				if (buttonIsNotSignOff)
					throw new Exception("Fail");
				resultCell.setCellValue("Pass");
				browser.findElement(By.xpath(statusButtonXpath)).click();
				System.out.println("Pass");
			} catch (Exception exception) {
				resultCell.setCellValue(exception.getMessage());
				System.out.println(exception.getMessage());
			}
			fileInputStream.close();
			FileOutputStream fileOutputStream = new FileOutputStream(excelFile);
			workbook.write(fileOutputStream);
		}
		browser.quit();
	}

}
