package week4.classroom;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> wHandles = new ArrayList<String>(windowHandles);
		driver.switchTo().window(wHandles.get(1));
		
		driver.findElement(By.xpath("//a[contains(@href,'javascript:set_value')]")).click();
		driver.switchTo().window(wHandles.get(0));
		
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Thread.sleep(3000);
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> wHandles2 = new ArrayList<String>(windowHandles2);
		
		driver.switchTo().window(wHandles2.get(1));
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a)[2]")).click();
		
		driver.switchTo().window(wHandles.get(0));
		
		
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		System.out.println(driver.getTitle());
		
	}

}
