package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import automationPractice.base.TestcaseBase;

public class TestUtil extends TestcaseBase{
	
	
	public static String screenshotPath;
	public static String screenshotName;
	public static Date d;
	public static void captureScreenshot() throws IOException {
		
		d = new Date();
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		screenshotName= d.toString().replace(":","_").replace(" ","_")+".jpg";
		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\"+screenshotName));
	}

}
