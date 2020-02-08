
/*
 https://raphaelfabeni.com/css-loader/
click on of the button
click another one with no delay
find out what is the exception you get?- Answer:org.openqa.selenium.ElementClickInterceptedException
 */
package day1week2;

import org.openqa.selenium.chrome.ChromeDriver;

public class ClickException {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://raphaelfabeni.com/css-loader/");
		driver.findElementByXPath("//*[@id='loader-default']").click();
		driver.findElementById("loader-default-half").click();

	}

}
