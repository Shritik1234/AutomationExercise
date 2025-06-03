package automationPractice.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import automationPractice.base.TestcaseBase;


public class ContactUs extends TestcaseBase{
		
	
	@Test
	public void contactUs() {
		log.info(or.getProperty("contactButton_Xpath"));
		click("contactButton_Xpath");
		
		String heading = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(or.getProperty("getInTouch_Xpath")))).getText();
		softassert.assertEquals(heading, "GET IN TOUCH");
		
		
		type("name_Xpath","swati");
		type("email_Xpath","test@gmail.com");
		type("subject_Xpath","test subject");
		type("message_Xpath","test message");
		
		WebElement input = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("uploadFile_Xpath"))));
		input.sendKeys("D:/workspace/DataDrivenFramework/src/test/resources/file/testfile.docx");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("submit_Xpath"))));
		js.executeScript("arguments[0].scrollIntoView(true);", submit); 
		submit.click();
		
		
		
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		
		String successMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(or.getProperty("sucessMessage_Xpath")))).getText();
		softassert.assertEquals(successMessage, "Success! Your details have been submitted successfully.");
		softassert.assertAll();
		
		click("home_Xpath");
		
	}

	
	
	
	
}
