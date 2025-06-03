package automationPractice.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import automationPractice.base.TestcaseBase;

public class Subscription extends TestcaseBase {

@Test(priority='1')	
public void subscriptionHomePage() {
	
	WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(or.getProperty("subscriptionText_Xpath"))));
	js.executeScript("arguments[0].scrollIntoView(true);", element);
		
	softassert.assertEquals(element.getText(), "SUBSCRIPTION", "Expected text Subscription is not showing");
	
	type("emailAddress_Xpath","text@gmail.com");
	click("emailSubmit_Xpath");
	
	String alertMessage=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='alert-success alert']"))).getText();
	softassert.assertEquals(alertMessage, "You have been successfully subscribed!", "Not sucessfully subscribed");
	softassert.assertAll();
		             
    }

@Test(priority='2')
public void cartHomePage() {	
	
	click("cartButton_Xpath");
	WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(or.getProperty("subscriptionText_Xpath"))));
	js.executeScript("arguments[0].scrollIntoView(true);", element);
		
	softassert.assertEquals(element.getText(), "SUBSCRIPTION", "Expected text Subscription is not showing");
	
	type("emailAddress_Xpath","text@gmail.com");
	click("emailSubmit_Xpath");
		
	String alertMessage=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='alert-success alert']"))).getText();
	softassert.assertEquals(alertMessage, "You have been successfully subscribed!", "Not sucessfully subscribed");
	softassert.assertAll();
	
	
	
	
	
}
	
}
