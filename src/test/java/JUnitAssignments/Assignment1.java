package JUnitAssignments;

import Junit.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Assignment1 extends TestBase {

    //Go to URL: https://api.jquery.com/dblclick/
    //Double-click on the blue square at the bottom of the page and then write the changed color.
    //Go top of the page and sendKeys "Thanks to JavascriptExecutor"
    //Go to the bottom of the page and click the book, name"jQuery in Action"

    @Test
    public void testJQueryActions() {

        Actions actions = new Actions(driver);

        // Go to URL
        bot.navigate("https://api.jquery.com/dblclick/");

        // Double-click on the blue square at the bottom of the page
        WebElement doubleClickElementBox = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(doubleClickElementBox);

        WebElement blueSquare = driver.findElement(By.cssSelector("body>div"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", blueSquare);
        jsExecutor.executeScript("arguments[0].dispatchEvent(new MouseEvent('dblclick', { bubbles: true }));", blueSquare);

        // Write the changed color
        String beforeClickColor = blueSquare.getCssValue("background-color");
        logger.info("Current color is ( " + beforeClickColor+" )");

        actions.doubleClick(blueSquare).perform();

        String color = blueSquare.getCssValue("background-color");
        logger.info("The color after Double Click is ( " + color+" )");
        Assertions.assertNotEquals(beforeClickColor, color);

        driver.switchTo().defaultContent();

        // Go to the top of the page and sendKeys "Thanks to JavascriptExecutor"
        jsExecutor.executeScript("window.scrollTo(0, 0);");
        By searchBox = By.name("s");
        bot.type(searchBox,"Thanks to JavascriptExecutor" + Keys.RETURN);

        // Go to the bottom of the page and click the book named "jQuery in Action"
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        By bookLink = By.xpath("//img[contains(@alt,'jQuery in Action')]");
        bot.click(bookLink);
        Assertions.assertEquals("https://www.manning.com/books/jquery-in-action-third-edition", driver.getCurrentUrl());
    }
}
