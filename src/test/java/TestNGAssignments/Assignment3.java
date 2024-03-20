package TestNGAssignments;

import TestNG.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assignment3 extends TestBase {

    /* go to "https://practicetestautomation.com/practice-test-login/"
    enter username - "student"
    enter password - "incorrectPassword"
    and login
    SOFT ASSERT the error message shown
    SOFT ASSERT the error message is "Your password is invalid!"
    */

    @Test
    public void softAssertTest() {
        bot.navigate("https://practicetestautomation.com/practice-test-login/");

        By usernameInput = By.id("username");
        By passwordInput = By.id("password");
        By loginButton = By.id("submit");

        bot.type(usernameInput, "student");
        bot.type(passwordInput, "incorrectPassword");
        bot.click(loginButton);

        By errorMessage = By.id("error");
        wait.until(f -> driver.findElement(errorMessage).isDisplayed());

        logger.info("Assert login Message");
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(driver.findElement(errorMessage).isDisplayed());
        softAssert.assertEquals(driver.findElement(errorMessage).getText(), "Your password is invalid!");

        softAssert.assertAll();
    }
}
