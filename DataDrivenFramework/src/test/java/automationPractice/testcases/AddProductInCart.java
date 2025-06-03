package automationPractice.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import automationPractice.base.TestcaseBase;

public class AddProductInCart extends TestcaseBase {
	
	
@Test	
public void addProductInCart() {

	click("productButton_Xpath");
	
		
	WebElement hover = driver.findElement(By.xpath("//div[@class='features_items']/div[@class='col-sm-4'][1]"));
	WebElement scroll=driver.findElement(By.xpath("//div[@class='features_items']/div[@class='col-sm-4'][1]/div/div[1]/div[2]"));
	//div[@class='features_items']/div[@class='col-sm-4'][1]/div/div[1]/div[1]/p
	js.executeScript("arguments[0].scrollIntoView(true);", scroll);
	Actions action = new Actions(driver);	
	action.moveToElement(hover).perform();
	
	
	click("addToCartLink1_Xpath");
	click("continueShopping1_Xpath");
	WebElement hover2 = driver.findElement(By.xpath("//div[@class='features_items']/div[@class='col-sm-4'][2]"));
	action.moveToElement(hover2).perform();
	click("addToCartLink2_Xpath");
	click("viewCart_Xpath");
	
	List<WebElement> list = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(or.getProperty("itemList_Xpath"))));
	list.size();
	if(list.size()==2) {
		softassert.assertTrue(true,"elemnts are not 2");
		
	}else {
		softassert.assertTrue(false,"elemnts are not 2");
	}
	
	
		
	 String  cartPrice=driver.findElement(By.xpath("//div[@class='table-responsive cart_info']/table/tbody/tr[1]/td[@class='cart_price']/p")).getText();
	 String  cartQuantity=driver.findElement(By.xpath("//div[@class='table-responsive cart_info']/table/tbody/tr[1]/td[@class='cart_quantity']/button")).getText();
	 String  cartTotal=driver.findElement(By.xpath("//div[@class='table-responsive cart_info']/table/tbody/tr[1]/td[@class='cart_total']/p")).getText();
	
    if(cartPrice.contains("500")&&cartQuantity.equals("1")&&cartTotal.contains("500")) {
    	softassert.assertTrue(true,"prices and quantity is not correct");	
    	
    }else {
    	softassert.assertTrue(false,"prices and quantity is not correct");
    }
    
    
    String  cartPrice2=driver.findElement(By.xpath("//div[@class='table-responsive cart_info']/table/tbody/tr[2]/td[@class='cart_price']/p")).getText();
	 String  cartQuantity2=driver.findElement(By.xpath("//div[@class='table-responsive cart_info']/table/tbody/tr[2]/td[@class='cart_quantity']/button")).getText();
	 String  cartTotal2=driver.findElement(By.xpath("//div[@class='table-responsive cart_info']/table/tbody/tr[2]/td[@class='cart_total']/p")).getText();
	 if(cartPrice2.contains("400")&&cartQuantity2.equals("1")&&cartTotal2.contains("400")) {
	    	softassert.assertTrue(true,"prices and quantity of men's tshirt is not correct");	
	    	
	    }else {
	    	softassert.assertTrue(false,"prices and quantity of men's tshirt is not correct");
	    }
    softassert.assertAll();
}
	
	
	
	

}
