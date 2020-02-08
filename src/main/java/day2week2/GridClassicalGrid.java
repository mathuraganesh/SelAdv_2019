package day2week2;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;



	//Go to the Command prompt Enter the below cmd 
	//where selenium-server-4.0.0-alpha-3.jar exist folder For Ex:C:\Ganesh\SeleniumAdv2019\Grid
 
	//Classical Grid:- 
	//java -jar selenium-server-4.0.0-alpha-3.jar hub
	//local or same system   java -jar selenium-server-4.0.0-alpha-3.jar node --detect-drivers
	//Remote or different  system   java -jar selenium-server-4.0.0-alpha-3.jar node --detect-drivers --publish-events tcp://hub(ip Address):4442 --subscribe-events tcp://hub(ip Address):4443
	
	//and then run below script and it will run in Grid with same  or different machine
	//http://localhost:4444/status/--->to check the status of Grid launch the url in browser
   
public class GridClassicalGrid {

	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.WINDOWS);
		RemoteWebDriver driver=new RemoteWebDriver(new URL("http://localhost:4444/"),dc);
		driver.get("http://leaftaps.com/opentaps/control/main");
	}

}
