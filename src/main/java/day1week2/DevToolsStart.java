package day1week2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.Command;
import org.openqa.selenium.devtools.ConverterFunctions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.Event;
import org.openqa.selenium.devtools.Log;
//import org.openqa.selenium.devtools.Target;
//import org.openqa.selenium.devtools.Target.SessionId;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

public class DevToolsStart {

	@Test
	public void runTest() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();

		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		DevTools devTools = driver.getDevTools();
		devTools.createSession();

		driver.get("https://naukri.com");
		driver.manage().window().maximize();
		
		devTools.send(new Command<>(
				"Emulation.setDeviceMetricsOverride",
				ImmutableMap.of("deviceScaleFactor", 1,"mobile", false,"width",1400,"height",2000)));



		String snap = devTools.send(new Command<>("Page.captureScreenshot",
				ImmutableMap.of("fromSurface", true), ConverterFunctions.map("data", String.class)));

		System.out.println(snap);

		Base64 decoder = new Base64();
		byte[] imgBytes = decoder.decode(snap.toString());
		FileOutputStream osf = new FileOutputStream(new File("./Snap/snap1.png"));
		osf.write(imgBytes);
		osf.flush();
		osf.close();

	}

}
