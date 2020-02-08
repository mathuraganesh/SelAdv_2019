package day1week2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
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

//import com.github.testleaf.devtools.protocol.types.dom.RGBA;
//import com.github.testleaf.devtools.protocol.types.overlay.HighlightConfig;
import com.google.common.collect.ImmutableMap;

public class GetNodes {

	@Test
	public void runTest() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();

		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		DevTools devTools = driver.getDevTools();

		devTools.createSession();

		driver.get("http://leafground.com/");
		driver.manage().window().maximize();

		devTools.send(new Command<>(
				"DOM.enable",
				ImmutableMap.of()));
		
		Object send = devTools.send(new Command<>(
				"DOM.getDocument",
				ImmutableMap.of("depth", -1),
				ConverterFunctions.map("root", Object.class)));

		System.out.println(send);

		Integer snap = devTools.send(new Command<>("DOM.querySelector",
				ImmutableMap.of("nodeId", 3, "selector", "h5[class='wp-categories-title']"), ConverterFunctions.map("nodeId", Integer.class)));


		System.out.println(snap);
		
		Integer newNode = devTools.send(new Command<>("DOM.pushNodeByPathToFrontend",
				ImmutableMap.of("path", "//h5[text()='Edit']"), 
				ConverterFunctions.map("nodeId", Integer.class)));
		
		System.out.println(newNode);

		/*devTools.send(new Command<>(
				"Overlay.enable",
				ImmutableMap.of()));
		*/
	}

	/*private static RGBA rgba(int r, int g, int b, double a) {
		RGBA result = new RGBA();
		result.setR(r);
		result.setG(g);
		result.setB(b);
		result.setA(a);
		return result;
	}

	private static RGBA rgb(int r, int g, int b) {
		RGBA result = new RGBA();
		result.setR(r);
		result.setG(g);
		result.setB(b);
		return result;
	}  */
}
