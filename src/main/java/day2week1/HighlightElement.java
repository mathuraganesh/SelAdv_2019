package day2week1;

import static org.openqa.selenium.devtools.ConverterFunctions.map;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
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
import org.openqa.selenium.devtools.Console.ConsoleMessage;
//import org.openqa.selenium.devtools.Target.SessionId;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

public class HighlightElement {

	@Test
	@SuppressWarnings({"unchecked","rawtypes"})
	public void runTest() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();

		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		DevTools devTools = driver.getDevTools();

		devTools.createSession();

		// Load the URL now
		driver.get("http://leaftaps.com/opentaps");
		
		// Enable DOM
		devTools.send(new Command("DOM.enable",
				ImmutableMap.of()));

		// Get the root node
		Object root = devTools.send(new Command("DOM.getDocument",
				ImmutableMap.of("depth", -1, "pierce", true), 
				ConverterFunctions.map("root", Object.class)));

		HashMap<String,Object> allProperties = (HashMap<String,Object>)root;
		long rootNode = (long) allProperties.get("nodeId");		
		System.out.println(rootNode);
		
		// Find the element to be highlighted
		Integer username = devTools.send(new Command<>("DOM.querySelector", 
				ImmutableMap.of("nodeId", rootNode, "selector", "input[name='USERNAME']"), 
				ConverterFunctions.map("nodeId", Integer.class)));
		
		// Enable Overlay
		devTools.send(new Command("Overlay.enable",
				ImmutableMap.of()));
		
		//Overlay.highlightNode
		Map<String, Object> borderColor = new HashMap<String, Object>();
		borderColor.put("r", 65);
		borderColor.put("g", 248);
		borderColor.put("b", 64);
		
		Map<String, Object> highlightConfig = new HashMap<String, Object>();
		highlightConfig.put("borderColor",borderColor);
 		
		devTools.send(new Command("Overlay.highlightNode",
				ImmutableMap.of("highlightConfig", highlightConfig,"nodeId",username)));
		
	}

	
}