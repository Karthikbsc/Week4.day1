package week4.classroom;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver =new ChromeDriver();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement Frame1 = driver.findElement(By.xpath("//iframe[@id=\"iframeResult\"]"));
		driver.switchTo().frame(Frame1);
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		WebElement outPut = driver.findElement(By.id("demo"));
		String string = outPut.getText();
		driver.switchTo().defaultContent();
		if (string.equals("You pressed OK!")) {
			System.out.println("Selected Try It Button");
		}
		else 
		System.out.println("Press Cancell");
		}
		
	}


