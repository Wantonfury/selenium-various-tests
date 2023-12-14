package introduction;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		
		driver.findElement(By.className("blinkingText")).click();
		
		Set<String> windows = driver.getWindowHandles(); // [parentId, childId]
		Iterator<String> it = windows.iterator(); // -1 index default
		String parentId = it.next(); // index 0
		String childId = it.next(); // index 1
		
		driver.switchTo().window(childId);
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		String email = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].split("with")[0].trim();
		
		//driver.close();
		driver.switchTo().window(parentId);
		
		driver.findElement(By.id("username")).sendKeys(email);
		//driver.findElement(By.id("signInBtn")).click();
		
		//driver.quit();
	}

}
