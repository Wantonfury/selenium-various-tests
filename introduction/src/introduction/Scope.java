package introduction;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Scope {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions().addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> anchors = driver.findElements(By.tagName("a"));
		System.out.println(anchors.size());
		
		//System.out.println(driver.findElements(By.cssSelector("#gf-BIG a")).size());
		WebElement footerDriver = driver.findElement(By.id("gf-BIG")); // limiting webdriver scope
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		
		WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		List<WebElement> links = columnDriver.findElements(By.tagName("a"));
		System.out.println(links.size());
		
		// click on each link in the column and check if the pages are opening

		String clickLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
		for (int i = 0; i < links.size(); i++) {
			links.get(i).sendKeys(clickLink);
		}
		
//		for (int i = 0; i < size; i++) {
//			List<WebElement> links = driver.findElements(By.xpath("//div[@id='gf-BIG']//td[1]//a"));
//			links.get(i).click();
//			driver.navigate().back();
//		}
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> windowIterator = windows.iterator();
		
		String parentWindow = windowIterator.next();
		
		for (String window = windowIterator.next(); windowIterator.hasNext(); window = windowIterator.next()) {
			driver.switchTo().window(window);
			System.out.println(driver.getTitle());
			driver.close();
		}
		driver.switchTo().window(parentWindow);
		
		
		driver.quit();
	}

}
