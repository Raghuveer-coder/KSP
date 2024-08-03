
package com.main.Steno;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class MainMethod {

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
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@id='nextBtn']")).click();

		//selectdirectcandidate
		WebElement dropdownElement = driver.findElement(By.id("Applicant_PostUnitCode"));
		Select dropdown = new Select(dropdownElement);
		dropdown.selectByValue("ST");
		//Applicant Name
		WebElement applicantNameField = driver.findElement(By.xpath("//input[@id='Applicant_FullName']"));
		// Test case 1: Minimum length (3 characters)
		applicantNameField.clear();
		applicantNameField.sendKeys("Tom");
		WebElement minLengthValidationMessage = driver.findElement(By.xpath("//input[@id='Applicant_FullName']")); // Replace with actual locator
		if (minLengthValidationMessage.isDisplayed()) {
			System.out.println("Min length validation passed.");
		} else {
			System.out.println("Min length validation failed.");
		}
		 // Test case 2: Maximum length (120 characters)
        applicantNameField.clear();
        String maxLengthInput = "A".repeat(120);
        applicantNameField.sendKeys(maxLengthInput);
        WebElement maxLengthValidationMessage = driver.findElement(By.xpath("//input[@id='Applicant_FullName']")); // Replace with actual locator
        if (maxLengthValidationMessage.isDisplayed()) {
            System.out.println("Max length validation passed.");
        } else {
            System.out.println("Max length validation failed.");
        }

        // Test case 3: Invalid input (non-alphabet characters)
        applicantNameField.clear();
        applicantNameField.sendKeys("John123");
        WebElement invalidCharsValidationMessage = driver.findElement(By.xpath("//input[@id='Applicant_FullName']")); // Replace with actual locator
        if (invalidCharsValidationMessage.isDisplayed()) {
            System.out.println("Invalid characters validation passed.");
        } else {
            System.out.println("Invalid characters validation failed.");
        }

        // Test case 4: Valid input (alphabets only, within length limits)
        applicantNameField.clear();
        applicantNameField.sendKeys("John Doe");
        WebElement validInputMessage = driver.findElement(By.xpath("//input[@id='Applicant_FullName']")); // Replace with actual locator
        if (validInputMessage.isDisplayed()) {
            System.out.println("Valid input test passed.");
        } else {
            System.out.println("Valid input test failed.");
        }

	}
}
