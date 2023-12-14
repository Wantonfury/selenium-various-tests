package streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LiveDemo {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions().addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		// click on column
		// capture all webelements into list
		// capture text of all webelements into new (original) list
		// sort on the orginal list of step 3 -> sorted list
		// compare original list vs sorted list
		
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		do {
			List<WebElement> products = driver.findElements(By.xpath("//tr/td[1]"));
			List<String> productNames = products.stream().map(p -> p.getText()).collect(Collectors.toList());
			List<String> productNamesSorted = productNames.stream().sorted().collect(Collectors.toList());
			
			Assert.assertEquals(productNames, productNamesSorted);
			
			// scan the name column with getText -> Rice -> print the price of the Rice
			List<String> price = products.stream().filter(p -> p.getText().equalsIgnoreCase("Rice")).map(p -> getPriceVeggie(p)).collect(Collectors.toList());
			price.forEach(p -> System.out.println(p));
			
			if (price.size() < 1) {
				WebElement next = driver.findElement(By.cssSelector("[aria-label='Next']"));
				if (!next.findElement(By.xpath("parent::li")).getAttribute("class").contains("disabled")) next.click();
				else break;
			} else break;
		} while(true);
		
		driver.quit();
		
	}

	private static String getPriceVeggie(WebElement p) {
		return p.findElement(By.xpath("following-sibling::td[1]")).getText();
	}

}
