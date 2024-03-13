package JUnitAssignments;

import Junit.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class Assignment4 extends TestBase {

    // go to https://www.google.com/
    // search for "Scroll Methods" by using an Actions object
    @Test
    public void scrollMethodsTest(){

        // go to https://www.google.com/
        bot.navigate("https://www.google.com/");

        // search for "Scroll Methods" by using an Actions object
        logger.info("Searching for \"Scroll Methods\" by using an Actions object");
        By searchInput = By.id("APjFqb");
        new Actions(driver)
                .scrollToElement(driver.findElement(searchInput))
                .click(driver.findElement(searchInput))
                .keyDown(Keys.SHIFT)
                .sendKeys("s")
                .keyUp(Keys.SHIFT)
                .sendKeys("croll")
                .keyDown(Keys.SPACE)
                .keyUp(Keys.SPACE)
                .keyDown(Keys.SHIFT)
                .sendKeys("m")
                .keyUp(Keys.SHIFT)
                .sendKeys("ethods")
                .sendKeys(Keys.ENTER)
                .perform();
        By resultStatsLabel = By.id("result-stats");
        wait.until(
                d -> {
                    driver.findElement(resultStatsLabel).getText();
                    return true;
                });
        Assertions.assertNotEquals("",driver.findElement(resultStatsLabel).getText());
    }
}
