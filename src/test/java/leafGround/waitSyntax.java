package leafGround;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class waitSyntax {

	WebDriver driver;
	@SuppressWarnings("deprecation")
	@Test
	public void implicitlyWait()
	{
	System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chrome\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://www.leafground.com/pages/Window.html");
	driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
	}
	
}
