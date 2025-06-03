package automationPractice.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import utilities.DataUtil;
import automationPractice.base.TestcaseBase;

public class RegisterUser extends TestcaseBase{
	
	
	@Test(dataProviderClass = DataUtil.class, dataProvider= "dp")
	public void loginWithCorrectEmailnPass(String emailId, String pwd) {
		log.info("Inside Register User Test case!!!");	
		click("login_Xpath");
		type("email_Xpath",emailId);
		type("password_Xpath",pwd);
		click("submit_Xpath");
				
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='header-middle']/div/div/div[2]/div/ul/li[10]/a/b")));
		  
	    softassert.assertEquals(element.getText(), "Swati Sharma", "Customer Name not appeared");
	    softassert.assertAll();
		
	    
		
	}
	@Test(dependsOnMethods = "loginWithCorrectEmailnPass")
	public void logout() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//header[@id='header']/div/div/div/div[2]/div/ul/li[4]/a"))).click();
		
		String value = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//section[@id='form']/div/div/div[1]/div/h2"))).getText();
		softassert.assertEquals(value, "Login to your account", "Customer has not logged out");
		//Login to your account
	    softassert.assertAll();
	    
	   // string str ="swati";
	   // str.cha
	    
	}

	

}
