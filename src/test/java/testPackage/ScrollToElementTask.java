package testPackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ScrollToElementTask extends TestBase {

    @Test
    public void scrollToElementTest(){

        driver.navigate().to("https://rangeslider.js.org/");

        By bar = By.xpath("//div[contains(@class,'rangeslider__handle')]");

        wait.until( d -> d.findElement(bar).isDisplayed() );

        Wait<WebDriver> wait =  new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class);

        WebElement clickable = driver.findElement(bar);
        new Actions(driver)
            .clickAndHold(clickable)
            .moveToElement(clickable,210,100)
            .perform();

        String text = driver.findElement(By.id("js-output")).getText();
        Assertions.assertEquals("700",text);
    }
}
