package Junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickElementTest extends TestBase {

    @Test
    public void doubleClickElementCheck() {

        Actions actions = new Actions(driver);

        driver.navigate().to("https://api.jquery.com/dblclick/");

        WebElement doubleClickElementBox = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(doubleClickElementBox);

        WebElement blueColouredButton = driver.findElement(By.cssSelector("body>div"));
        JavascriptExecutor jsexecutor1 = (JavascriptExecutor) driver;
        jsexecutor1.executeScript("arguments[0].scrollIntoView();", blueColouredButton);

        String beforeClickColor = blueColouredButton.getCssValue("background-color");
        System.out.println("color = " + beforeClickColor);

        actions.doubleClick(blueColouredButton).perform();

        String color = blueColouredButton.getCssValue("background-color");
        System.out.println("color = " + color);

        Assertions.assertNotEquals(beforeClickColor, color);

        driver.switchTo().defaultContent();

        JavascriptExecutor js = (JavascriptExecutor) driver;


        WebElement searchBar = driver.findElement(By.name("s"));
        //js.executeScript("arguments[0].scrollIntoView();", searchBar); --> that would work fine

        js.executeScript("window.scrollTo(0,0)");
        searchBar.sendKeys(color);

        //a[@href="https://www.manning.com/books/jquery-in-action-third-edition"]

        WebElement jsInActionImg = driver.findElement(By.xpath("//a[@href='https://www.manning.com/books/jquery-in-action-third-edition']"));

        js.executeScript("arguments[0].scrollIntoView();", jsInActionImg);
        jsInActionImg.click();

        String currentURL = driver.getCurrentUrl();
        Assertions.assertEquals("https://www.manning.com/books/jquery-in-action-third-edition", currentURL);

    }
}
