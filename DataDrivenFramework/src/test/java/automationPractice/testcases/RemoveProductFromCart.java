package automationPractice.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import automationPractice.base.TestcaseBase;
import utilities.DataUtil;

public class RemoveProductFromCart extends TestcaseBase {
	
	@Test(dataProviderClass=DataUtil.class, dataProvider ="Logindata")
	public void removeProductFromCart(String email, String password) {
		
		click("signup_Xpath");
		driver.findElement(By.xpath("//form[@action='/login']/input[2]")).sendKeys(email);
		driver.findElement(By.xpath("//form[@action='/login']/input[3]")).sendKeys(password);
		driver.findElement(By.xpath("//form[@action='/login']/button[@type='submit']")).click();
		
		 String ownerName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//header[@id='header']/div/div/div/div[2]/div/ul/li[10]/a/b"))).getText();
		    if(ownerName.contains("swati")) {
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
			
		
		List<WebElement> deleteElement = driver.findElements(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[2]/table[1]/tbody[1]/tr"));
        
        if(deleteElement.size()>=1) {
        	       	
        	for(int i=1; i<=deleteElement.size();i++) {
        		driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[2]/table[1]/tbody[1]/tr["+i+"]/td[6]/a[1]")).click();	
        		
        	}
        	
        	
        }	
           
     
        WebElement emptyCartMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[2]/span[1]/p[1]/b[1]")));

        	String emptyCart = emptyCartMsg.getText();

        	if (emptyCart.contains("empty")) {
        	    softassert.assertTrue(true, emptyCart);
        	} else {
        	    softassert.assertTrue(false, emptyCart);
        	}

}}
