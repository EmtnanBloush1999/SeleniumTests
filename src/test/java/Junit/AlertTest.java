package Junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlertTest extends TestBase {

     /**
     * Navigate to <a href="https://the-internet.herokuapp.com/javascript_alerts">Alerts</a>
     * click on "Click for JS Confirm"
     * Press OK
     * Check that "You clicked: Ok" is displayed
     */

     @Test
     public void alertTest(){
         //navigate to the URL
         driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
         //the selector
         By button = By.cssSelector("button[onclick='jsConfirm()']");
         driver.findElement(button).click();
         //Wait for the alert to be displayed and store it in a variable
         Alert alert = wait.until(ExpectedConditions.alertIsPresent());
         //Press the OK button
         alert.accept();
         //Store the alert text in a variable
         By text= By.id("result");
         var actualText= driver.findElement(text).getText();
         //conform the text
         Assertions.assertEquals("You clicked: Ok",actualText);
     }
}