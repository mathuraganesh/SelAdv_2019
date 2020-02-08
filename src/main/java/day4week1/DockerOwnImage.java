package day4week1;

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


//all the below file must be create under maven project folder(C:\Ganesh\SeleniumAdv2019\Selenium\MavenProject)
//Create the docker file with no file extension- To copy the maven set up to the http:\\hub.docker.com
//set up the pom.xml along with the plug in to run testnddocker.xml via docker
//create the dockercompose.yml file to create the script,selenium-hub,firefox-node,chrome-node

//Power Shell cmd to create the own image and upload into docker and execute
//cmd- docker login(enter username and password for http:\\hub.docker.com)
//cmd- docker build -t leafbot:1.2 .(to create the image in local)
//cmd- docker  tag leafbot:1.2  mathuraganeshm/leafbot:1.2(once created local same way create tag image in docker website)
//cmd- docker push mathuraganeshm/leafbot:1.2(push the image into docker website)
//cmd- docker-compose up -d(create script,hub,node from docker website)
//cmd- docker pull mathuraganeshm/leafbot:1.2(pull the script from docker website)
//cmd- docker ps -a(to see the created one to get the container of script)
//cmd- docker logs leafbot:1.2ContainerID(48843332d250) -f  (to execute script from docker into power shell)

public class DockerOwnImage {
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
		dc.setPlatform(Platform.ANY);
		RemoteWebDriver driver=new RemoteWebDriver(new URL("http://hub:4444/wd/hub"),dc);
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCapabilities().getBrowserName());
		System.out.println(driver.getCapabilities().getPlatform());
	}
}
	
