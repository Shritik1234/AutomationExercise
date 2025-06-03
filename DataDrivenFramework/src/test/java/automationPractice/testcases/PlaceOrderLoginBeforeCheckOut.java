package automationPractice.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import automationPractice.base.TestcaseBase;
import utilities.DataUtil;

public class PlaceOrderLoginBeforeCheckOut extends TestcaseBase {

	@Test(dataProviderClass=DataUtil.class, dataProvider ="Logindata")
	public void placeOrderLoginBeforeCheckOut(String email, String password) {
		
		click("signup_Xpath");
		driver.findElement(By.xpath("//form[@action='/login']/input[2]")).sendKeys(email);
		driver.findElement(By.xpath("//form[@action='/login']/input[3]")).sendKeys(password);
		driver.findElement(By.xpath("//form[@action='/login']/button[@type='submit']")).click();
		
		 String ownerName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//header[@id='header']/div/div/div/div[2]/div/ul/li[10]/a/b"))).getText();
		    if(ownerName.contains("Swati")) {
		    softassert.assertTrue(true);
		    	
		    }else {
		    	softassert.assertTrue(false);	
		    }
		
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
			
			WebElement elem = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("message_Xpath"))));
			js.executeScript("arguments[0].scrollIntoView(true);", elem);
			elem.sendKeys("Here is my message");
			
			click("placeOrder_Xpath");
			type("nameOfCard_Xpath","Shritik");
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
				softassert.assertTrue(true, "not deleted");	
			}else {
				softassert.assertTrue(false, "expected but not deleted");
			}
			
		  click("deleteContinue_Xpath");
			
		  softassert.assertAll();	
			
			
		
	}
	
	
	
}
