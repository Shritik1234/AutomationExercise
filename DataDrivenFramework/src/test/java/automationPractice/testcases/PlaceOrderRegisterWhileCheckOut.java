package automationPractice.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import automationPractice.base.TestcaseBase;
import automationPractice.utilities.Signup;

public class PlaceOrderRegisterWhileCheckOut  extends TestcaseBase{
	
	@Test
	public void placeOrderRegisterWhileCheckout() {
		click("productButton_Xpath");
		WebElement hover = driver.findElement(By.xpath("//div[@class='features_items']/div[@class='col-sm-4'][1]"));
		WebElement scroll=driver.findElement(By.xpath("//div[@class='features_items']/div[@class='col-sm-4'][1]/div/div[1]/div[2]"));
		
		js.executeScript("arguments[0].scrollIntoView(true);", scroll);
		Actions action = new Actions(driver);	
		action.moveToElement(hover).perform();
		
		
		click("addToCartLink1_Xpath");
		click("continueShopping1_Xpath");
		click("cartButton_Xpath");
		String cartUrl = driver.getCurrentUrl();
		if(cartUrl.contains("view_cart")) {
			softassert.assertTrue(true, "Url is not correct");
		}else {
			softassert.assertTrue(false, "Url is not correct");
		}
		
		
	click("proceedToCheckOut_Xpath");
	
	
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(or.getProperty("register_link_Xpath")))).click();
	
	Signup sign = new Signup();
	sign.signUp("Rahul", "qhgrtyuo@gmail.com");
	sign.fillForm("mr", "Swati@123", "4", "5", "2000");
	sign.addressForm("Rahul", "Sharma", "testcom", "testadd", "testadd", "India", "M.P", "Gwalior", "3456","987654321");
	
	 WebElement accountCreated = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//section[@id='form']/div/div/div/h2/b")));
    String header = accountCreated.getText();  
    
    softassert.assertEquals(header, "ACCOUNT CREATED!", "Account not created");
    driver.findElement(By.xpath("//section[@id='form']/div/div/div/div/a")).click();
    
    String ownerName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//header[@id='header']/div/div/div/div[2]/div/ul/li[10]/a/b"))).getText();
    if(ownerName.contains("Rahul")) {
    softassert.assertTrue(true);
    	
    }
    click("cartButton_Xpath");
    click("proceedToCheckOut_Xpath");
    
    WebElement elem = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("message_Xpath"))));
	js.executeScript("arguments[0].scrollIntoView(true);", elem);
	elem.sendKeys("Here is my message");
	
	click("placeOrder_Xpath");
	type("nameOfCard_Xpath","rahul");
	type("cardNumber_Xpath","1234");
	type("cvc_Xpath","123");
	type("expirationMon_Xpath","02");
	type("expirationYear_Xpath","2028");
	click("confirmOrder_Xpath");
	

	String message = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//section/div[@class='container']/div/div/p"))).getText();
	if(message.contains("Congratulations")) {
		softassert.assertTrue(true);	
	}else {
		softassert.assertTrue(false);
	}
    
   
	
   click("continue_Xpath"); 
   click("deleteAccount_Xpath");
   
   String message1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(or.getProperty("accountDeleted_Xpath")))).getText();
	if(message1.contains("DELETED")) {
		softassert.assertTrue(true);	
	}else {
		softassert.assertTrue(false);
	}
	
  click("deleteContinue_Xpath");
	
  softassert.assertAll();	
		
}}
