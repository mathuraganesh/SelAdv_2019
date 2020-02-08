package day2week1;


//Use selenium 4.0.0-alpha-2 for DOM.attributeModified

//For Example
//<artifactId>selenium-java</artifactId>
//<version>4.0.0-alpha-2</version> 

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.Command;
import org.openqa.selenium.devtools.ConverterFunctions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.Event;

import com.google.common.collect.ImmutableMap;

public class ListenDOMChange {

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
		System.out.println(title);
		
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		devTools.send(new Command<>("DOM.enable",ImmutableMap.of()));
		
		Object send = devTools.send(new Command<>(
				"DOM.getDocument",
				ImmutableMap.of("depth", -1),
				ConverterFunctions.map("root", Object.class)));

		
		devTools.addListener(new Event<>("DOM.attributeModified",ConverterFunctions.map("nodeId",Integer.class)),
				 handler ->{
					System.out.println(handler);
				 });
		
		//devTools.addListener(new Event<>("DOM."), handler);

	}

}
