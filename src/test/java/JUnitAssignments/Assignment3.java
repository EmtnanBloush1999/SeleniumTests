package JUnitAssignments;

import Junit.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class Assignment3 extends TestBase {

     /*
    Go to URL: http://demo.guru99.com/test/drag_drop.html
    Drag and drop the BANK button to the Account section in DEBIT SIDE
    Drag and drop the SALES button to the Account section in CREDIT SIDE
    Drag and drop the 5000 button to the Amount section in DEBIT SIDE
    Drag and drop the second 5000 button to the Amount section in CREDIT SIDE
    Verify the visibility of Perfect text.
    */

    @Test
    public void testDragAndDrop() {
        // Go to URL
        bot.navigate("http://demo.guru99.com/test/drag_drop.html");
        // Perform drag and drop actions
        Actions actions = new Actions(driver);
        //Drag and drop the BANK button to the Account section in DEBIT SID
        logger.info("Test Drag and drop the BANK button to the Account section in DEBIT SID");
        actions.dragAndDrop(driver.findElement(By.xpath("//a[contains(.,'BANK')]")), driver.findElement(By.id("bank"))).perform();
        //Drag and drop the SALES button to the Account section in CREDIT SIDE
        logger.info("Test Drag and drop the SALES button to the Account section in CREDIT SID");
        actions.dragAndDrop(driver.findElement(By.xpath("//a[contains(.,'SALES')]")), driver.findElement(By.id("loan"))).perform();
        //Drag and drop the 5000 button to the Amount section in DEBIT SIDE
        logger.info("Test Drag and drop the 5000 button to the Amount section in DEBIT SIDE");
        actions.dragAndDrop(driver.findElement(By.xpath("(//li[@id ='fourth'])[1]")), driver.findElement(By.id("amt7"))).perform();
        //Drag and drop the second 5000 button to the Amount section in CREDIT SIDE
        logger.info("Test Drag and drop the second 5000 button to the Amount section in CREDIT SIDE");
        actions.dragAndDrop(driver.findElement(By.xpath("(//li[@id ='fourth'])[2]")), driver.findElement(By.id("amt8"))).perform();
        // Verify the visibility of Perfect text
        logger.info("Verify the visibility of Perfect text");
        By perfectText = By.xpath("(//a[contains(@class,'button-green')])[1]");
        Assertions.assertEquals("Perfect!", driver.findElement(perfectText).getText());
    }
}
