package leafGround;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowHandles {
	WebDriver driver;

	@Test
	public void OpenWindow() {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.findElement(By.id("home")).click();

		String parent = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();

		Iterator<String> I1 = s.iterator();

		while (I1.hasNext()) {
			String child_window = I1.next();

			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);
				System.out.println(driver.switchTo().window(child_window).getTitle());
				driver.close();
			}

			driver.switchTo().window(parent);
		}

	}

	@Test
	public void openMultipleWindow() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.findElement(By.xpath("//button[contains(text(),'Open Multiple')]")).click();

		//String parent = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		//System.out.println(driver.getTitle());
	    //System.out.println(parent);
		System.out.println(windows);

		for (String moveChild : windows) {
			driver.switchTo().window(moveChild);

			if (driver.getTitle().contains("Interact with HyperLinks")) {
				driver.manage().window().maximize();
				driver.findElement(By.xpath("//section/div[1]/div/div/a[contains(@href,'../home.html')]"));
				Thread.sleep(2000);
				//System.out.println(driver.getTitle());
				driver.close();
			}
			
		}
		
		Set<String> windows1 = driver.getWindowHandles();
		for (String parent : windows1) {
			driver.switchTo().window(parent);
			driver.manage().window().minimize();
			System.out.println(driver.getTitle());
			if (driver.getTitle().contains("Interact with Windows")) {
			
				System.out.println(driver.getTitle());
				driver.close();
			}
		}

	}

}
