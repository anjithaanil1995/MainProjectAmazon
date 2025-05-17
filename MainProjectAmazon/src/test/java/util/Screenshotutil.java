package util;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import bases.AmazonBase;

public class Screenshotutil extends AmazonBase {
	public static String takeScreenshot(String testName) {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(0));
		String screenshotPath = "screenshots/" + testName + "_" + timestamp + ".png";
		try {
		FileUtils.copyFile(srcFile, new File(screenshotPath));
		} catch (IOException e) {
		e.printStackTrace();
		}
		return screenshotPath;
		}

}
