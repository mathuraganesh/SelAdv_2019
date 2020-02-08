package day3week2;


//After Intall docker instead of excecute each command put all cmd in docker-compose.yml file in desktop
//Open powershell in desktop and exceute below cmds and then change hub port and execute in testng.xml

//cmd to exceute hub and all node :
//Docker-compose up -d

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

public class DockerSwan {
	
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
