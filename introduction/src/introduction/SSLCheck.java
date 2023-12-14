package introduction;

import java.util.Arrays;
import java.util.HashMap;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCheck {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		//FirefoxOptions optionsFirefox = new FirefoxOptions();
		//optionsFirefox.setAcceptInsecureCerts(true);
		//EdgeOptions optionsEdge = new EdgeOptions();
		//SafariOptions optionsSafari = new SafariOptions();
		options.setAcceptInsecureCerts(true);
		
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("ipaddress:4444");
		options.setCapability("proxy", proxy);
		options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		
		HashMap<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "/directory/path");
		options.setExperimentalOption("prefs", prefs);
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://expired.badssl.com/");
		
		System.out.println(driver.getTitle());
	}

}
