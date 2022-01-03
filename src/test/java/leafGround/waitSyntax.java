package leafGround;

import org.testng.annotations.Test;


import CommonUtility.base;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class waitSyntax extends base{
	
	@Test
	public void implicitlyWait()
	{
	driver=initializeDriver(); 
	driver.manage().window().maximize();
	driver.get("http://www.leafground.com/pages/Window.html");
	driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
	//assertEquals(false, true);
	driver.close();
	}
	
	@Test
	public void SyncExplicitWaitCheck()
	{
		
		driver=initializeDriver(); 
		driver.get("https://www.phptravels.net/login");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[2]/div/form/div[1]/div/input[@name='email']")).sendKeys("user@phptravels.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("demouser");
		
		WebElement loginButton= driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/form/div[3]/button"));
		 WebDriverWait wait=new WebDriverWait(driver, 20);
		 wait.until(ExpectedConditions.elementToBeClickable(loginButton));  
		
		loginButton.submit();
		driver.findElement(By.xpath("//div[3]/ul/li[4]/a[contains(@href,'account/profile')]")).click();
		driver.close();
		
		
		

	}
	
}
