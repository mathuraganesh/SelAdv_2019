package day2week2;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GridFireFox {

	public static void main(String[] args) throws MalformedURLException {
			
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setBrowserName("firefox");
		dc.setPlatform(Platform.WINDOWS);
		RemoteWebDriver driver=new RemoteWebDriver(new URL("http://localhost:4444/"),dc);
		driver.get("http://leaftaps.com/opentaps/control/main");
	}


}