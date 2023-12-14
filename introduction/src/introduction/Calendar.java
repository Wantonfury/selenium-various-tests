package introduction;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Calendar {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions().addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		String month = "December";
		int day = 23;
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.path2usa.com/travel-companion/");
		
		Thread.sleep(3000);
		
		Actions a = new Actions(driver);
		a.scrollByAmount(0, 1000).click(driver.findElement(By.id("form-field-travel_comp_date"))).build().perform();
		
		WebElement nextMonth = driver.findElement(By.className("flatpickr-next-month"));
		Wait<WebDriver> waitForMonthChange = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		WebElement curMonth = driver.findElement(By.cssSelector(".cur-month"));
		while (!curMonth.getText().trim().equals(month)) {
			nextMonth.click();
			waitForMonthChange.until(ExpectedConditions.stalenessOf(curMonth));
			
			curMonth = driver.findElement(By.cssSelector(".cur-month"));
			
		}
		
		List<WebElement> dates = driver.findElements(By.cssSelector(".flatpickr-day"));
		
		for (WebElement date : dates) {
			if (date.getAttribute("class").contains("disabled")) continue;
			
			if (Integer.parseInt(date.getText()) == day) {
				date.click();
				break;
			}
		}
	}

}
