package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UpdatedDropDown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		Assert.assertEquals(driver.findElements(By.cssSelector("input[type='checkbox']")).size(), 6);
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		
		int defaultAdults = Integer.parseInt(driver.findElement(By.id("spanAudlt")).getText());
		WebElement plusAdults = driver.findElement(By.id("hrefIncAdt"));
		
		int numAdults = defaultAdults;
		while (numAdults++ < 5) plusAdults.click();
		
		Assert.assertEquals(Integer.parseInt(driver.findElement(By.id("spanAudlt")).getText()), numAdults - 1);
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		
		
		driver.close();
	}

}
