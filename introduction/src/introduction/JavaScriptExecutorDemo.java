package introduction;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaScriptExecutorDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		js.executeScript("window.scrollBy(0, 500)");
		js.executeScript("document.querySelector('.tableFixHead').scrollTop = 5000");
		
		List<WebElement> values = driver.findElements(By.cssSelector("#product td:nth-of-type(4)"));
		
		int sumValues = 0;
		for (WebElement value : values) {
			sumValues += Integer.parseInt(value.getText());
		}
		
		System.out.println(sumValues);
		
		int sumDisplayed = Integer.parseInt(driver.findElement(By.className("totalAmount")).getText().split(": ")[1].trim());
		System.out.println(sumDisplayed);
		
		Assert.assertEquals(sumValues, sumDisplayed);
		
		List<WebElement> products = driver.findElements(By.cssSelector("[name='courses'] td:nth-child(3)"));
		
		int sumProducts = 0;
		for (int i = 0; i < products.size(); i++) {
			sumProducts += Integer.parseInt(products.get(i).getText().trim());
		}
		
		System.out.println(sumProducts);
	}

}
