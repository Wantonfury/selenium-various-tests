package introduction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelIntroduction {

	public static void main(String[] args) {
		// Invoking Browser
		// Chrome -> ChromeDriver -> Methods: close get
		// Firefox -> FirefoxDriver -> Methods: close get
		// Safari: SafariDriver -> Methods: close get
		// WebDriver close get
		// WebDriver methods + class methods
		
		
		// WebDriver type - only webdriver methods, ChromeDriver - webdriver methods + chrome specific methods
		// chromedriver.exe -> Chrome browser
		// webdriver.chrome.driver -> value of path
		System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver-win64\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		
		// Firefox launch
		System.setProperty("webdrive.gecko.driver", "C:\\Tools\\geckodriver-win64\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		
		// Edge
		System.setProperty("webdriver.edge.driver", "C:\\Tools\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();
		driver.quit();
	}

}
