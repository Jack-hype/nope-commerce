package BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserInitialise {
	
	public static WebDriver ChromeBrowserLuanch()
	{
		System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		return driver;
	}

	public static WebDriver EdgeBrowserLuanch()
	{
		System.setProperty("webdriver.edge.driver", "src/main/resources/Drivers/msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		return driver;
	}

}
