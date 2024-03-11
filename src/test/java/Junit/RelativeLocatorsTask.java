package Junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocatorsTask {
    /**
     * Navigate to <a href="https://www.w3schools.com/html/html_tables.asp">w3schools tables</a>
     * check that the Contact for "Alfreds Futterkiste" company is "Maria Anders"
     * check that the Contact for "Island Trading" company is "Helen Bennett"
     */
    WebDriver driver;

    @Test
    public void checkContact(){
        By indexText =By.xpath("//td[contains(.,'Island Trading')]");
        By cheackingText = RelativeLocator.with(By.tagName("td")).toRightOf(indexText);
        Assertions.assertEquals("Helen Bennett", driver.findElement(cheackingText).getText());
    }

    @BeforeEach
    public void beforeEach(){
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.navigate().to("https://www.w3schools.com/html/html_tables.asp");
    }
    @AfterEach
    public void afterEach(){
        driver.quit();
    }
}
