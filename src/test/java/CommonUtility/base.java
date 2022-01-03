package CommonUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class base {

	public static WebDriver driver;
	

	public WebDriver initializeDriver() 
	{

		Properties prop = new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream("C:\\Users\\Deepa\\git\\AutomationTestNGPractice\\automation\\CommonFiles\\data.properties");
		    prop.load(fis);
		} catch (IOException e) {
			System.out.println("file not reading properly. Please check the path");
		}
		
		String browser = prop.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome"))
		{
			
			System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chrome\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
		
	}
	public void getScreenShot(String result) throws IOException {
		
		File sourceFile	= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("C:\\Users\\Deepa\\git\\AutomationTestNGPractice\\automation\\screenShots\\Failureshot_"+result+".png");
		FileUtils.copyFile(sourceFile, destinationFile);
		
		
	}
	
	
}
