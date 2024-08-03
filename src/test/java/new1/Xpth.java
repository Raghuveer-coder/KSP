
package new1;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Xpth {

    public static void main(String[] args) throws InterruptedException {
        // Initialize the WebDriver (Chrome in this example)
        ChromeDriver driver = new ChromeDriver();

        try {
            // Open the specified URL
            driver.get("http://202.83.17.50:9010/");
            driver.manage().window().maximize();

            // Click the 'New Application' link which opens a new window
            driver.findElement(By.xpath("//a[contains(.,'New Application')]")).click();

            // Wait for the new window to open
            Thread.sleep(5000);

            // Get the current window handle (main window)
            String mainWindowHandle = driver.getWindowHandle();

            // Get all window handles
            Set<String> allWindowHandles = driver.getWindowHandles();

            // Switch to the new window
            for (String windowHandle : allWindowHandles) {
                if (!windowHandle.equals(mainWindowHandle)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }

            // Wait for the checkbox to be present
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement checkbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("agreeCheckbox")));

            // Scroll the checkbox into view
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox);

            // Ensure the checkbox is visible and clickable
            wait.until(ExpectedConditions.visibilityOf(checkbox));
            wait.until(ExpectedConditions.elementToBeClickable(checkbox));

            // Use JavaScript to click the checkbox
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);

            // Perform further actions or assertions
            System.out.println("Checkbox clicked successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            //driver.quit();
        }
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='nextBtn']")).click();
    }
}
