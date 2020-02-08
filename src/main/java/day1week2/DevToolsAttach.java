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

public class DevToolsAttach {

	@Test
	public void runTest() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();

		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		DevTools devTools = driver.getDevTools();

		devTools.createSession();

		/*devTools.send(new Command<>(
				"Network.enable",
				ImmutableMap.of()
				));	*/

		String[] data = {"**/*.css", "**/*.png", "**/*.svg"};

		/*		devTools.send(new Command<>(
				"Network.setBlockedURLs",
				ImmutableMap.of("urls",data )
				));
		 */

		driver.get("http://leafground.com/");
		driver.manage().window().maximize();

		devTools.send(new Command<>("DOM.enable",ImmutableMap.of()));



		Object send = devTools.send(new Command<>(
				"DOM.getDocument",
				ImmutableMap.of("depth", -1),
				ConverterFunctions.map("nodes", Object.class)));

		System.out.println(send);

		/*	Integer node = devTools.send(new Command<>(
				"DOM.querySelector",
				ImmutableMap.of("NodeId", 12, "selector", "h5"),
				ConverterFunctions.map("nodeId", Integer.class)));*/

		Integer snap = devTools.send(new Command<>("DOM.querySelector",
				ImmutableMap.of("nodeId", 35, "selector", "div"), ConverterFunctions.map("nodeId", Integer.class)));


		System.out.println(snap);

		devTools.send(new Command(
				"Overlay.enable",
				ImmutableMap.of()));

		/*HighlightConfig highlightConfig = new HighlightConfig();

		highlightConfig.setBorderColor(rgba(255, 229, 153, 0.66));
		highlightConfig.setContentColor(rgba(111, 168, 220, 0.66));
		highlightConfig.setCssGridColor(rgb(75, 0, 130));
		highlightConfig.setEventTargetColor(rgba(255, 196, 196, 0.66));
		highlightConfig.setMarginColor(rgba(246, 178, 107, 0.66));
		highlightConfig.setPaddingColor(rgba(147, 196, 125, 0.55));
		highlightConfig.setShapeColor(rgba(96, 82, 117, 0.8));
		highlightConfig.setShapeMarginColor(rgba(96, 82, 127, 0.6)); 

		highlightConfig.setShowExtensionLines(true);
		highlightConfig.setShowInfo(true);
		highlightConfig.setShowRulers(true);
		highlightConfig.setShowStyles(false);  

		devTools.send(new Command<>(
				"Overlay.highlightNode",
				ImmutableMap.of("highlightConfig", highlightConfig, "nodeId",56))); */

		/*devTools.send(new Command<>(
				"Emulation.setPageScaleFactor",
				ImmutableMap.of("pageScaleFactor", 1)));*/


		/*Object send = devTools.send(new Command<>(
				"Performance.getMetrics",
				ImmutableMap.of(),
				ConverterFunctions.map("metrics", Arrays.class)));
		System.out.println("The output is " +send);*/

		/*		devTools.send(new Command<>(
				"Emulation.setGeolocationOverride",
				ImmutableMap.of("latitude", 40.712776,"longitude", -74.005974,"accuracy", 30 )));*/








		/*Object send = devTools.send(new Command<>(
				"DOM.getAttributes",
				ImmutableMap.of("nodeId", 30),
				ConverterFunctions.map("attributes", Object.class)));*/




		/*devTools.send(new Command<>(
				"DOM.hideHighlight",
				ImmutableMap.of()));*/

		//Target.getTargets





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
		return result;  */
	}
//}
