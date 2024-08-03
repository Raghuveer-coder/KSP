package new1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class One {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Puma shoes for men");
		driver.findElement(By.xpath("//span[contains(text(),'shoes for men')]")).click();
		
		
	}

}
