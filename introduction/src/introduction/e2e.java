package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class e2e {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//a[@value='DEL']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click(); // //div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		Assert.assertTrue(driver.findElement(By.id("Div1")).getAttribute("style").contains("opacity: 0.5"));
		
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);
		
		int adults = Integer.parseInt(driver.findElement(By.id("spanAudlt")).getText());
		WebElement incAdults = driver.findElement(By.id("hrefIncAdt"));
		while (adults++ < 5) incAdults.click();
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		Select options = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		options.selectByIndex(3);
		
		driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click();
	}

}
