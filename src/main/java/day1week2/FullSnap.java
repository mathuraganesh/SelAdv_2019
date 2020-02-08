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

//import com.github.testleaf.devtools.protocol.types.page.LayoutMetrics;
import com.google.common.collect.ImmutableMap;

public class FullSnap {

	@Test
	public void runTest() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();

		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		DevTools devTools = driver.getDevTools();

		devTools.createSession();
		/*devTools.send(Log.enable());
		devTools.addListener(Log.entryAdded(), entry -> System.out.println(entry.asSeleniumLogEntry()));
		devTools.send(Console.enable());
		devTools.addListener(Console.messageAdded(), System.out::println);*/


		driver.get("http://www.naukri.com/");
		driver.manage().window().maximize();

		Object content = devTools.send(new Command(
				"Page.getLayoutMetrics",
				ImmutableMap.of(),
				ConverterFunctions.map("contentSize", Object.class)));

		System.out.println(content);

		HashMap<String,Long> contentMap = (HashMap<String, Long>)content;
		System.out.println(contentMap.get("width"));
		System.out.println(contentMap.get("height"));

		devTools.send(new Command(
				"Emulation.setDeviceMetricsOverride",
				ImmutableMap.of("deviceScaleFactor", 1,"mobile", false,"width",contentMap.get("width"),"height",contentMap.get("height"))));


		Object send = devTools.send(new Command(
				"Page.captureScreenshot",
				ImmutableMap.of("fromSurface", true),
				ConverterFunctions.map("data", String.class)));

		System.out.println("The output is " +send.toString());

		Base64 decoder = new Base64(); 
		byte[] imgBytes = decoder.decode(send.toString());
		FileOutputStream osf = new FileOutputStream(new File("./snap.png"));
		osf.write(imgBytes);
		osf.flush();
		osf.close();




	}

}
