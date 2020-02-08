package day1week1;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class LaunchApp {
	
	@Test
	public void startApplication() {
		
		// Set the ChromeDriver Exe Path
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		//System.setProperty("webdriver.firefox.driver", "./drivers/geckodriver.exe");
		//System.setProperty("webdriver.edge.driver", "./drivers/MicrosoftWebDriver.exe");
		 
		// Launch your browser
		ChromeDriver driver = new ChromeDriver();
		//FirefoxDriver driver = new FirefoxDriver();
		//EdgeDriver driver = new EdgeDriver();
		
		
		// Load the URL
	    driver.get("http://google.com");
		
		
	}

}
