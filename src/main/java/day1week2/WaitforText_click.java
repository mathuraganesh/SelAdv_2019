package day1week2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitforText_click {

	public static void main(String[] args) {
		System.setProperty("Webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http:\\leafground.com");
		driver.findElementByXPath("//*[@id=\"post-153\"]/div[2]/div/ul/li[23]/a/img").click();
		//WebElement sButton=
		WebDriverWait wait= new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.textToBePresentInElement(driver.findElementByXPath("//*[@id=\"btn\"]"),"Click ME"));
				//visibilityOfElementLocated(By.xpath("//*[@id=\"btn\"]")));
		driver.findElementByXPath("//*[@id=\"btn\"]").click();
			}
	

}
