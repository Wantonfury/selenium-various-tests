package introduction;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-blink-features");
		options.addArguments("--disable-blink-features=AutomationControlled");
		WebDriver driver = new ChromeDriver(options);
		SoftAssert a = new SoftAssert();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/#");
		
		// broken url
		// java methods will call the urls and get you the status code
		// if status code > 400 then url is not working -> link is broken
		
		List<WebElement> links = driver.findElements(By.cssSelector("li.gf-li a"));
		
		for (WebElement link : links) {
			String url = link.getAttribute("href");
			HttpURLConnection connection = (HttpURLConnection)new URL(url).openConnection();
			connection.setRequestMethod("HEAD");
			connection.connect();
			
			a.assertTrue(connection.getResponseCode() < 400, "The link with text " + link.getText() + " is broken with code " + connection.getResponseCode());
		}
		
		driver.quit();
		
		a.assertAll();
	}

}
