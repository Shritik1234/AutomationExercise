package automationPractice.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import automationPractice.base.TestcaseBase;

import utilities.DataUtil;

public class LoginTestCase extends TestcaseBase {
	
	
	@Test(priority ='1')
	public void RegisterUser() {
		log.info("Inside Login Test case!!!");		
		WebElement element = driver.findElement(By.xpath("//img[@alt='Website for automation practice']"));		
		String imageAlt= element.getDomAttribute("alt");	
		//Assertion for loading a home page
		softassert.assertEquals(imageAlt, "Website for automation practice", "Expected Automation Practice image");
		
		driver.findElement(By.xpath("//div[@class='shop-menu pull-right']/ul/li[4]/a")).click();
				
		WebElement heading = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//section[@id='form']/div/div/div/div[@class='signup-form']/h2")));
		String signup= heading.getText();
		//System.out.println(signup);
		log.info(signup);
		//Assertion for Signup Page is visible
		softassert.assertEquals(signup, "New User Signup!", "New User Signup Expected");
		softassert.assertAll();
			
	}
	
	


	@Test(priority='3', enabled =false)
	public void createAccountForm() {		
		
		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@action='/signup']/div/div/label[@for='id_gender2']/div"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@action='/signup']/div[4]/input"))).sendKeys("Swati@123");
		
		
		selectDropDownByValue("//form[@action='/signup']/div[5]/div/div[1]/div/select","3");
		
		selectDropDownByValue("//form[@action='/signup']/div[5]/div/div[2]/div/select","5");
		
		selectDropDownByValue("//form[@action='/signup']/div[5]/div/div[3]/div/select","1993");
	       
	    
	   WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@action='/signup']/div[6]")));
	   js.executeScript("arguments[0].scrollIntoView(true);", checkbox);
	   checkbox.click();
	   WebElement checkbox2 =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@action='/signup']/div[7]")));
	   js.executeScript("arguments[0].scrollIntoView(true);", checkbox2); 
	   checkbox.click();
	    /*...Address information...*/
	 
	    fillInputValues("//form[@action='/signup']/p[1]/input","Swati");
	    fillInputValues("//form[@action='/signup']/p[2]/input","Sharma");
	    fillInputValues("//form[@action='/signup']/p[3]/input","Test");
	    fillInputValues("//form[@action='/signup']/p[4]/input","Address1");
	    fillInputValues("//form[@action='/signup']/p[5]/input","Address2");
	    selectDropDownByValue("//form[@action='/signup']/p[6]/select","India");
	  
	    fillInputValues("//form[@action='/signup']/p[7]/input","Madhya Pradesh");
	    fillInputValues("//form[@action='/signup']/p[8]/input","Gwalior");
	    fillInputValues("//form[@action='/signup']/p[9]/input","1234");
	    fillInputValues("//form[@action='/signup']/p[10]/input","9876543210");
	    
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@action='/signup']/button[@type='submit']"))).click();
	    
	    WebElement accountCreated = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//section[@id='form']/div/div/div/h2/b")));
	    String header = accountCreated.getText();  
	    
	    softassert.assertEquals(header, "ACCOUNT CREATED!", "Account not created");
	   
	    
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='pull-right']/a"))).click();
	    
	    WebElement CustomerName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='header-middle']/div/div/div[2]/div/ul/li[10]/a/b")));
	  
	    softassert.assertEquals(CustomerName.getText(), "Shritik Sharma", "Customer Name not appeared");
	    softassert.assertAll();
	}
	
	
	@Test(dataProviderClass = DataUtil.class, dataProvider="data", priority='4')
	public void RegisterUserWithExistingEmail(String UserName, String Email) {
		
		log.info("Inside RegisterUserWithExistingEmail");
		driver.findElement(By.xpath("//div[@class='shop-menu pull-right']/ul/li[4]/a")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@action='/signup']/input[2]"))).sendKeys(UserName);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@action='/signup']/input[3]"))).sendKeys(Email);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@action='/signup']/button[@type='submit']"))).click();
		
		WebElement errorMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@action='/signup']/p")));
		String Message= errorMessage.getText();
		//Assertion for Enter account information page is visible
		softassert.assertEquals(Message, "Email Address already exist!", "Error Message not showing!!");
		softassert.assertAll();
		
		
	}
	
	
	
	private void selectDropDownByValue(String Xpath, String value) {
		WebElement daysSelect = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Xpath)));
		js.executeScript("arguments[0].scrollIntoView(true);", daysSelect);
	    new Select(daysSelect).selectByValue(value);
		
	}
    private void fillInputValues(String Xpath, String value) {
    	
    	 WebElement fill = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Xpath)));
    	 js.executeScript("arguments[0].scrollIntoView(true);", fill);
    	 fill.sendKeys(value);
	}
}
