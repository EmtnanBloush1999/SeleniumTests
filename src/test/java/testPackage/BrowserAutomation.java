package testPackage;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserAutomation {
    public static void main(String[] args) {

        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();

        // Navigate to website
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        // Click on Locators - Find By Playground Test Page
        WebElement locatorsLink = driver.findElement(By.linkText("Locators - Find By Playground Test Page"));
        locatorsLink.click();

        // Print the URL
        System.out.println("Current URL: " + driver.getCurrentUrl());

        // Navigate back
        driver.navigate().back();

        // Print the URL
        System.out.println("URL after navigating back: " + driver.getCurrentUrl());

        // Click on WebDriver Example Page
        WebElement webDriverExampleLink = driver.findElement(By.linkText("WebDriver Example Page"));
        webDriverExampleLink.click();

        // Print the URL
        System.out.println("Current URL: " + driver.getCurrentUrl());

        // Enter value -> 20 to "Enter Some Numbers inputBox"
        WebElement inputBox = driver.findElement(By.id("numentry"));
        inputBox.sendKeys("20");

        // Press Enter
        inputBox.submit();

        // Verify 'two, zero' message is displayed on page
        WebElement message = driver.findElement(By.id("message"));
        String actualMessage = message.getText();
        Assertions.assertEquals(actualMessage, "two, zero" , "Verification Failed");

        // Close driver
        driver.quit();
    }
}