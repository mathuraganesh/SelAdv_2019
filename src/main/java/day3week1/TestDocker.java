package day3week1;

//Install Docker exceute below cmd and then change hub port and exceute in testng.xml
//In Power Shell cmd to create Hub: 
//docker pull selenium/hub

//In Power Shell cmd to create node for Chrome: 
//docker pull selenium/node-chrome-debug

//In Power Shell cmd to create node for firefox:
//docker pull selenium/node-firefox-debug

//In Power Shell cmd to run Hub:
//docker run -d -p 3456:4444 --name selhub-hub selenium/hub

//In Power Shell cmd to run chrome with instance and sessions: 
//docker run -d -p 5911:5901 --link selhub-hub:hub -e NODE_MAX_INSTANCES=5 -e NODE_MAX_SESSION=5 -v/dev/shm:/dev/shm/ selenium/node-chrome-debug

//In Power Shell cmd to run chrome without instance and sessions: 
//docker run -d -p 5908:5901 --link selhub-hub:hub -v/dev/shm:/dev/shm/ selenium/node-chrome-debug

//In Power Shell cmd to run firefox without instance and sessions: 
//docker run -d -p 5909:5901 --link selhub-hub:hub -v/dev/shm:/dev/shm/ selenium/node-firefox-debug

//In Power Shell cmd to run chrome without instance and sessions:
//docker run -d -p 5912:5901 --link selhub-hub:hub -e NODE_MAX_INSTANCES=5 -e NODE_MAX_SESSION=5 -v/dev/shm:/dev/shm/ selenium/node-firefox-debug


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestDocker {
	
	public String browser;
	
	@Parameters({"browser"})
	@BeforeMethod
	public void setBrowser(String browsername) {
		browser=browsername;
	}
	
	@Test
	public void startApp()throws MalformedURLException {
		
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setBrowserName(browser);
		dc.setPlatform(Platform.LINUX);
		RemoteWebDriver driver=new RemoteWebDriver(new URL("http://localhost:3456/wd/hub"),dc);
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		File src = driver.getScreenshotAs(OutputType.FILE);
		File desc = new File("./snaps/"+browser+".png");
		try {
			FileUtils.copyFile(src, desc);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
