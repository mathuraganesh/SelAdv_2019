package day1week2;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.Command;
import org.openqa.selenium.devtools.ConverterFunctions;
import org.openqa.selenium.devtools.DevTools;

import com.google.common.collect.ImmutableMap;

public class DomNodeID {

	public static void main(String[] args) {
		System.setProperty("Webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		
		DevTools devTools=driver.getDevTools();
				devTools.createSession();
		driver.get("http://leaftaps.com/opentaps/control/main");
		//send the request
		devTools.send(new Command<>("DOM.enable",ImmutableMap.of()));
		
		//Get the DOM document
		Object send=devTools.send(new Command<>("DOM.getDocument",ImmutableMap.of("depth",-1,"pierce",true),ConverterFunctions.map("root",Object.class)));
		System.out.println(send);
		
		int node=devTools.send(new Command<>("DOM.querySelector",ImmutableMap.of("nodeId",5,"selector","input[id='username']"),ConverterFunctions.map("nodeId",Integer.class)));
		System.out.println(node);
	}

}
