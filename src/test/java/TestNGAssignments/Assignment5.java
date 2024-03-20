package TestNGAssignments;

import TestNG.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assignment5 extends TestBase {

    //Go to URL: http://crossbrowsertesting.github.io/
    //Click to To-Do App
    //Checking Box to do-4 and Checking Box to do-5
    //If both clicks worked, then the following List should be have length 2.
    //Assert that this is correct
    //Assert that the to do we added is present in the list
    //Archiving old todos
    //If our archive link worked, then the following list should have length 4.
    //Assert that this is true as well
    //Doing Cross Browser Testing.


    @Test
    public void task5Test() {
        bot.navigate("http://crossbrowsertesting.github.io/");

        logger.info("Click to To-Do App");
        By link = By.xpath("//a[@href='todo-app.html']");
        bot.click(link);

        logger.info("Checking Box to do-4 and Checking Box to do-5");
        By fourthCheckBox = By.xpath("//input[@name='todo-4']");
        By fifthCheckBox = By.xpath("//input[@name='todo-5']");
        bot.click(fourthCheckBox);
        bot.click(fifthCheckBox);

        logger.info("If both clicks worked, then the following List should be have length 2.");
        By numberOfSelectedCheckbox = By.xpath("//span[@class='done-true']");
        int count = driver.findElements(numberOfSelectedCheckbox).size();
        SoftAssert softAssert = new SoftAssert();

        logger.info("Assert that this is correct");
        softAssert.assertEquals(count, 2);

        By textInput = By.id("todotext");
        By addButton = By.id("addbutton");
        bot.type(textInput, "test");
        bot.click(addButton);
        By test = By.xpath("//span[@class='done-false' and text()='test']");

        logger.info("Assert that the to do we added is present in the list");
        softAssert.assertTrue(driver.findElement(test).isDisplayed());

        logger.info("Archiving old todos");
        By archive = By.xpath("//a[text()='archive']");
        bot.click(archive);

        logger.info("If our archive link worked, then the following list should have length 4.");
        By numberOfUnSelectedCheckbox = By.xpath("//span[@class='done-false']");
        int count1 = driver.findElements(numberOfUnSelectedCheckbox).size();

        logger.info("Assert that this is true as well");
        softAssert.assertEquals(count1, 4);

        softAssert.assertAll();
    }
}