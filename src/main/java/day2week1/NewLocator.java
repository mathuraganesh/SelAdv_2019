package day2week1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;

//Use selenium 4.0.0-alpha-3

//For Example
//<artifactId>selenium-java</artifactId>
//<version>4.0.0-alpha-3</version> 

public class NewLocator {

	public static void main(String[] args) throws IOException {
		
		//  Write to a property file
		InputStream input = new FileInputStream("./config.properties");
		Properties prop = new Properties();
		prop.load(input);

		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("debuggerAddress", prop.getProperty("debugger"));

		ChromeDriver driver = new ChromeDriver(options);
		String title = driver.getTitle();
		//System.out.println(title);
		
		String test=driver.findElement(RelativeLocator.withTagName("input").below(By.className("username"))).getText();
		System.out.println(test);

	}

}
