package automationPractice.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import automationPractice.base.TestcaseBase;
import utilities.DataUtil;

public class LoginFailed extends TestcaseBase{
	
	@Test(dataProviderClass = DataUtil.class, dataProvider= "dp" )
	public void loginWithInCorrectEmailnPass(String emailId, String pwd) {
		log.info("Inside LoginFailed Test case!!!");	
		
		driver.findElement(By.xpath("//div[@class='shop-menu pull-right']/ul/li[4]/a")).click();
		driver.findElement(By.xpath("//form[@action='/login']/input[2]")).sendKeys(emailId);
		driver.findElement(By.xpath("//form[@action='/login']/input[3]")).sendKeys(pwd);
		driver.findElement(By.xpath("//form[@action='/login']/button[@type='submit']")).click();
		
		WebElement message = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@action='/login']/p[text() ='Your email or password is incorrect!']")));
		  
		String messageText = message.getText();
		 softassert.assertEquals(messageText, "Your email or password is incorrect!", "password is incorrect");
		    softassert.assertAll();
				
		
		
	}

}
