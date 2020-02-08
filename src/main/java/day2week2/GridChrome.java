package day2week2;



//1. Implement Selenium Grid with following scenario.

//Standalone Server configuration
//1. Register a SessionMap
//2. Register the Distributed
//3. Register the Router
//4. Register 3 Nodes - > Chrome, Firefox and Edge


//Client Configuration
//1. Three test scripts with different desired capabilities say
//Test script 1- Chrome
//Test script 2- Firefox
//Test script 3- Edge

//Run the test cases sequentially and parallely and observe the behaviour.-Unable to execute parallely and sequencelly  via Grid 

//Try execute the scripts as standalone, classic as well.


import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GridChrome {

	public static void main(String[] args) throws MalformedURLException {
			
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.WINDOWS);
		RemoteWebDriver driver=new RemoteWebDriver(new URL("http://localhost:4444/"),dc);
		driver.get("http://leaftaps.com/opentaps/control/main");
	}


}
