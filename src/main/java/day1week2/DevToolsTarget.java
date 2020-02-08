package day1week2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.Command;
import org.openqa.selenium.devtools.Connection;
import org.openqa.selenium.devtools.Console;
import org.openqa.selenium.devtools.ConverterFunctions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.Event;
import org.openqa.selenium.devtools.Log;
//import org.openqa.selenium.devtools.Target;
//import org.openqa.selenium.devtools.Target.SessionId;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

public class DevToolsTarget {

	@Test
	public void runTest() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();

		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		DevTools devTools = driver.getDevTools();

		devTools.createSession();
		driver.get("http://testleaf.com/");
		driver.manage().window().maximize();
		
		/*devTools.send(new Command<>(
				"Emulation.setPageScaleFactor",
				ImmutableMap.of("pageScaleFactor", 1)));*/
		
		
		Object send = devTools.send(new Command(
				"Performance.getMetrics",
				ImmutableMap.of(),
				ConverterFunctions.map("metrics", String.class)));
		
		System.out.println("The output is " +send.toString());

		devTools.send(new Command(
				"Emulation.setGeolocationOverride",
				ImmutableMap.of("latitude", 40.712776,"longitude", -74.005974,"accuracy", 30 )));
		
		
		



	}

}
