package streams;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LiveDemoFilter {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions().addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		
		List<WebElement> products = driver.findElements(By.xpath("//tr/td[1]"));
		
		List<WebElement> result = products.stream().filter(p -> p.getText().contains("Rice")).collect(Collectors.toList());
		Assert.assertTrue(result.size() == 1);
		
		driver.quit();
	}

}
