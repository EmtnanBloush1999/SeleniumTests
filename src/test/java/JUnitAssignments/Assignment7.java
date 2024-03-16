package JUnitAssignments;

import Junit.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import com.google.common.io.Files;

import java.io.*;

public class Assignment7 extends TestBase {

    /**
     * Go to <a href="https://www.amazon.com/">Amazon</a>
     * Take Full Page Screenshot.
     * Take any specific WebElement ScreenShot
     * */
    @Test
    public void ScreenShotTest() throws IOException {
        logger.info("Go to amazon.com");
        bot.navigate("https://www.amazon.com");
        logger.info("Take Full Page Screenshot.");
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Files.copy(screenshot, new File("target/FullScreenshot_"+System.currentTimeMillis()+".png"));
        logger.info("Take any specific WebElement ScreenShot");
        By specificElementImage = By.id("nav-logo-sprites");
        File ElementScreenshot = driver.findElement(specificElementImage).getScreenshotAs(OutputType.FILE);
        Files.copy(ElementScreenshot, new File("target/SpecificElementScreenshot_"+System.currentTimeMillis()+".png"));
    }
}
