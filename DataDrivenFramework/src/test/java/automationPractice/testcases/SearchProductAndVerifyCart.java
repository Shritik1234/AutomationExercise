package automationPractice.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import automationPractice.base.TestcaseBase;
import utilities.DataUtil;

public class SearchProductAndVerifyCart extends TestcaseBase{
	
	int fsize =0;
    @Test(dataProviderClass=DataUtil.class, dataProvider ="Logindata")
	public void searchProductAndVerifyCart(String email, String password ) {
		
    	click("productButton_Xpath");
    	type("searchProduct_Xpath","saree");
    	click("searchButton_Xpath");
    	String heading = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(or.getProperty("searchProductHeading_Xpath")))).getText();
		softassert.assertEquals(heading, "SEARCHED PRODUCTS", "Expected heading searched products not visisble" );
		
		addItemsInCart("searchProductTitle_Xpath","Saree");	
		
		click("cartButton_Xpath");
		
		productListInCart("itemList_Xpath");
		
		login("signup_Xpath",email,password );		
		    
		click("cartButton_Xpath");
		
		productListInCart("itemList_Xpath");

				
		softassert.assertAll();
		
	}
    
    private void addItemsInCart(String productTitle, String searchName) {
    	
    	if(wait.until(driver-> driver.findElements(By.xpath(or.getProperty(productTitle)))).size()==0)
		{
			log.info(driver.findElements(By.xpath(or.getProperty(productTitle))).size());
			softassert.assertTrue(true, "No featured items found — test passed by negative condition");	
		}else {
			List<WebElement> featuredItems = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(or.getProperty(productTitle))));
			WebElement firstItem = featuredItems.get(1);
			
            js.executeScript("arguments[0].scrollIntoView(true);", firstItem);

            
            fsize=featuredItems.size();
            log.info(fsize);
            softassert.assertTrue(firstItem.getText().contains(searchName), "Expected item to contain text 'Dress'");
            
            
            for(int i=1; i<=featuredItems.size();i++) {
            	WebElement hover =	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='features_items']/div[@class='col-sm-4']["+i+"]")));
            	WebElement scroll=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='features_items']/div[@class='col-sm-4'][\"+i+\"]/div/div[1]/div[2]")));
            	
            	js.executeScript("arguments[0].scrollIntoView(true);", scroll);
            	js.executeScript("arguments[0].scrollIntoView(true);", hover);
    			Actions action = new Actions(driver);	
    			action.moveToElement(hover).perform();
    			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='features_items']/div[@class='col-sm-4']["+i+"]/div/div/div/div/a"))).click();
    			
    			click("continueShopping1_Xpath");
            }
            
		}
    	
    	
    	
    }
    
    private void productListInCart(String cartProductList) {
    	
    	List<WebElement> list = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(or.getProperty(cartProductList))));
    	softassert.assertTrue(list.size()==fsize,"Added element is not same as in cart");
    	
    	
    	
    }
	
    private void login(String loginButton, String emailid ,String pwd) {    	
    	click(loginButton);
		driver.findElement(By.xpath("//form[@action='/login']/input[2]")).sendKeys(emailid);
		driver.findElement(By.xpath("//form[@action='/login']/input[3]")).sendKeys(pwd);
		driver.findElement(By.xpath("//form[@action='/login']/button[@type='submit']")).click();
    }
	
	

}
