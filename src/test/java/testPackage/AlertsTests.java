package testPackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlertsTests extends TestBase{

    //Go to URL: http://demo.automationtesting.in/Alerts.html
    //Click "Alert with OK" and click 'click the button to display an alert box:’
    //Accept Alert(I am an alert box!) and print alert on console.
    //Click "Alert with OK & Cancel" and click 'click the button to display a confirm box’
    //Cancel Alert (Press a Button !)
    //Click "Alert with Textbox" and click 'click the button to demonstrate the prompt box’
    //And then sendKeys «Bootcamp» (Please enter your name)
    //Finally print on console this message "Hello Bootcamp How are you today" assertion these message.

    @Test
    public void AlertsTest() {

        // Navigate to the website;
        driver.navigate().to("http://demo.automationtesting.in/Alerts.html");
        // Click "Alert with OK"
        By alertWithOkLink = By.xpath("//a[@href='#OKTab']");
        driver.findElement(alertWithOkLink).click();
        By alertWithOkButton = By.xpath("//button[@onclick='alertbox()']");
        driver.findElement(alertWithOkButton).click();
        // Accept Alert
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert Text: " + alertText);
        alert.accept();
        // Verify alert message
        Assertions.assertEquals("I am an alert box!", alertText);

        // Click "Alert with OK & Cancel"
        By alertWithOkAndCancelLink = By.xpath("//a[@href='#CancelTab']");
        driver.findElement(alertWithOkAndCancelLink).click();
        By alertWithOkCancelButton = By.xpath("//button[@onclick='confirmbox()']");
        driver.findElement(alertWithOkCancelButton).click();
        //Cancel Alert (Press a Button !)
        alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
        By cancelMessage = By.xpath("//p[@id='demo']");
        String actualMessage = driver.findElement(cancelMessage).getText();
        System.out.println(actualMessage);

        //Click "Alert with Textbox" and click 'click the button to demonstrate the prompt box
        By alertWithTextBoxLink = By.xpath("//a[@href='#Textbox']");
        driver.findElement(alertWithTextBoxLink).click();
        By alertWithTextBoxButton = By.xpath("//button[@onclick='promptbox()']");
        driver.findElement(alertWithTextBoxButton).click();

        //And then sendKeys «Bootcamp» (Please enter your name)
        alert.sendKeys("«Bootcamp» Emtnan Adel Bloush");
        alert.accept();

        //Finally print on console this message "Hello Bootcamp How are you today" assertion these message.
        By textboxMessage = By.xpath("//p[@id='demo1']");
        String actualMessage1 = driver.findElement(textboxMessage).getText();
        System.out.println(actualMessage1);
        Assertions.assertEquals("Hello «Bootcamp» Emtnan Adel Bloush How are you today",actualMessage1);
    }
}