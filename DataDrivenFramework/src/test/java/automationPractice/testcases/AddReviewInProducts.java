package automationPractice.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import automationPractice.base.TestcaseBase;

public class AddReviewInProducts extends TestcaseBase{
	
	
	@Test
	public void addReviewInProduct() {
		
		
		 click("productButton_Xpath");
		
         softassert.assertTrue(driver.getCurrentUrl().contains("products"));//to verify product page launched
         
         verifyViewProduct(); 
         verifyReviewMessage("WRITE YOUR REVIEW", "Swati Sharma", "test@gmail.com","Test Records","Thank you for your review." );
		
		 
		
		softassert.assertAll();
	}
	
	
	private void verifyViewProduct() {
		
		WebElement viewProduct = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(or.getProperty("viewProduct_Xpath"))));
		
		 js.executeScript("arguments[0].scrollIntoView(true);", viewProduct); 
		 
		 viewProduct.click();
		
		
	}
	
	private void verifyReviewMessage(String expectedHeading, String name, String email, String message,String expectedAlertMessage) {
		 String heading = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(or.getProperty("writeYourReviewHeading_Xpath")))).getText();
		 softassert.assertEquals(heading.trim(), expectedHeading,"Heading is not as expected -> WRITE YOUR REVIEW ");
		 
		 type("yourName_Xpath",name);
		 type("yourEmailAddress_Xpath",email);
		 type("yourAddReviewHere_Xpath",message);
		 
		 
		 WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("addYourReviewButton_Xpath"))));
		 js.executeScript("arguments[0].scrollIntoView(true);", button);
		 button.click();
		 //click("addYourReviewButton_Xpath");
	
		 String alertMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(or.getProperty("thankYouForReviewAlertMessage_Xpath")))).getText();
		 
		softassert.assertEquals(alertMessage, expectedAlertMessage);
		
		
	}
	
	
	

}
