package JUnitAssignments;

import Junit.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.Set;

public class Assignment2 extends TestBase {

    //Go to URL: https://the-internet.herokuapp.com/windows
    //Verify the text: “Opening a new window”
    //Verify the title of the page is “The Internet”
    //Click on the “Click Here” button
    //Verify the new window title is “New Window”
    //Go back to the previous window and then verify the title: “The Internet”

    @Test
    public void testThePage(){
        //Go to URL: https://the-internet.herokuapp.com/windows
        bot.navigate("https://the-internet.herokuapp.com/windows");
        var MainWindowHandle = driver.getWindowHandle();

        //Verify the text: “Opening a new window”
        By HeaderLable = By.tagName("h3");
        logger.info("The text is: " +driver.findElement(HeaderLable).getText());
        Assertions.assertEquals("Opening a new window",driver.findElement(HeaderLable).getText());

        //Verify the title of the page is “The Internet”
        logger.info("The title now is: " +driver.getTitle());
        Assertions.assertEquals("The Internet",driver.getTitle());

        //Click on the “Click Here” button
        By clickHereButton = By.xpath("//a[@href='/windows/new']");
        bot.click(clickHereButton);

        // Verify the new window title is “New Window”
        Set<String> windowHandles = driver.getWindowHandles();
        windowHandles.remove(MainWindowHandle);
        String newWindowHandle = (String) windowHandles.toArray()[0];
        driver.switchTo().window(newWindowHandle);
        logger.info("The title now is: " +driver.getTitle());
        Assertions.assertEquals("New Window", driver.getTitle());

        //Go back to the previous window and then verify the title: “The Internet”
        driver.switchTo().window(MainWindowHandle);
        logger.info("The title now is: " +driver.getTitle());
        Assertions.assertEquals("The Internet",driver.getTitle());
    }
}
