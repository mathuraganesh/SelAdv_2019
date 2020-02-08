package day4week2;

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


//Download the minikube and kubectl and placed in C:\Windows\System32
//open the powershell in admin
//run the minikube manually in Hyper-V Manager
//To Run the minikube cmd- minikube start --vm-driver=hyperv 
//To create a pod for selenium hub cmd- kubectl run hub --image selenium/hub --image-pull-policy='Always' --port 4444
//To expose the pod as a service. cmd- kubectl expose deployment hub --type=NodePort
//The exposed service url can be retrieved from cmd- minikube service hub --url
//once exposed will generate url paste in the script For Ex:http://172.17.255.229:30292
//Launch the grid url-http://172.17.255.229:30292 and see the status
//Create the pod for chrome node   cmd- kubectl run chrome-node --image selenium/node-chrome-debug --env="HUB_PORT_4444_TCP_ADDR=hub" --env="HUB_PORT_4444_TCP_PORT=4444"
//run the xml file i.e:kubectl.xml

public class Kubectl {
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
		RemoteWebDriver driver=new RemoteWebDriver(new URL("http://172.17.255.229:30292/wd/hub"),dc);
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCapabilities().getBrowserName());
		System.out.println(driver.getCapabilities().getPlatform());
	}
}
	
