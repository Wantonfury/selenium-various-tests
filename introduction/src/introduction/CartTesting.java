package introduction;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CartTesting {
	
	private class Container {
		private WebElement incElement = null;
		private WebElement decElement = null;
		private WebElement addElement = null;
		private String productName = "";
		
		public void inc() {
			incElement.click();
		}
		
		public void dec() {
			decElement.click();
		}
		
		public void add() {
			addElement.click();
		}
		
		public String getProductName() {
			return productName;
		}
		
		public Container(WebDriver driver, String identifier) {
			this.productName = new String(identifier.split("-")[0].trim());
			String container = "//h4[text()='" + identifier + "']/parent::div";
			this.incElement = driver.findElement(By.xpath(container + "/div[@class='stepper-input']/a[@class='increment']"));
			this.decElement = driver.findElement(By.xpath(container + "/div[@class='stepper-input']/a[@class='decrement']"));
			this.addElement = driver.findElement(By.xpath(container + "/div[@class='product-action']/button"));
		}
	}

	public static void main(String[] args) {
		String[] productsSought = { "Cucumber", "Brocolli", "Beetroot", "Carrot" };
		CartTesting cart = new CartTesting();
		WebDriver driver = new ChromeDriver();
		//WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		Wait<WebDriver> w = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		List<WebElement> productNames = driver.findElements(By.cssSelector("h4.product-name"));
		ArrayList<Container> productContainers = new ArrayList<Container>();
		
		for (WebElement product : productNames) {
			productContainers.add(cart.new Container(driver, product.getText()));
		}
		
		List<String> productsWanted = Arrays.asList(productsSought);
		
		for (Container productContainer : productContainers) {
			if (!productsWanted.contains(productContainer.getProductName())) continue;
			
			for (int i = 1; i < 5; i++) productContainer.inc();
			productContainer.add();
		}
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		// explicit wait
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		Assert.assertTrue(driver.findElement(By.cssSelector("span.promoInfo")).getText().equals("Code applied ..!"));
	}
}
