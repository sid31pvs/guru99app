package guru99.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import guru99.base.BaseTest;

public class Utilities extends BaseTest{

	public static int max_page_load_time = 40;
	public static int max_implicit_time = 30;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	// ****************switch to frame method********************************

	public void switchToFrame(String frameName) {
		driver.switchTo().frame(frameName);
	}
	
	

	// ***********method for taking screenshot for failing methods***************8

	public static String takeScreenShot(String Mname) {
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String filepath = System.getProperty("user.dir") + "\\screenshot\\guru99\\" + Mname + "-" + timeStamp+ ".png";
		
		// String filepath = System.getProperty("user.dir")+ "\\screenshot\\"+
		// System.currentTimeMillis() + ".png";
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(filepath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filepath;
	}

	
	
	// **********************method for data driven approach*****************************88888

	public static Object[][] getDataFromSheet(String sheetname) {
		FileInputStream fis;

		try {
			fis = new FileInputStream(
					"D:\\testing materials\\eclipse\\workspace-eclipse2\\guru99WebApplication\\src\\main\\java\\guru99\\configuration\\Credentials.xlsx");
			workbook = new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sheet = workbook.getSheet(sheetname);
		int rowcount = sheet.getLastRowNum();
		int cellcount = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[rowcount][cellcount];

		for (int i = 0; i < rowcount; i++) {
			for (int j = 0; j < cellcount; j++) {
				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
			}
		}
		return data;
	}
}
