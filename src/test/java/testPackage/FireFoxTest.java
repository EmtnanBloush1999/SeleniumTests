package testPackage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FireFoxTest {

    WebDriver driver;

    @Test
    public void SearchBar(){
        driver.navigate().to("https://www.google.com");
        By searchBoxTextArea = By.id("APjFqb");

        driver.findElement(searchBoxTextArea).sendKeys("selenium"+ Keys.ENTER);

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        By resultStats = By.id("result-stats");
        wait.until(d -> driver.findElement(resultStats).isDisplayed());

        String actualText = driver.findElement(resultStats).getText();
        Assertions.assertNotEquals("", actualText);
    }


    @BeforeEach
    public void beforeEach(){
        driver= new FirefoxDriver();
        driver.manage().window().maximize();
    }
    @AfterEach
    public void afterEach(){
        driver.quit();
    }
}
