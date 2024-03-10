package testPackage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class Tasks1RadioButton {
    /*
    //Task 1:
    Go to URL: https://demoqa.com/radio-button
    Verify whether all 3 options given to the question can be selected.
    When each option is selected, print the following texts on the console.
     */

    WebDriver driver;
    boolean raidoButtonIsSelected;
    String actualMessage;

    @Test
    public void radioButton1Test(){
        By radioButton = By.xpath("//label[@class='custom-control-label' and @for='yesRadio']");
        driver.findElement(radioButton).click();

        By radioInput = By.id("yesRadio");
        raidoButtonIsSelected = driver.findElement(radioInput).isSelected();
        Assertions.assertTrue(raidoButtonIsSelected);

        actualMessage = driver.findElement(By.xpath("//p[@class='mt-3']")).getText();
        Assertions.assertEquals( "You have selected Yes", actualMessage);

        System.out.println(actualMessage);
    }

    @Test
    public void radioButton2Test(){
        By radioButton = By.xpath("//label[@class='custom-control-label' and @for='impressiveRadio']");
        driver.findElement(radioButton).click();

        By radioInput = By.id("impressiveRadio");
        raidoButtonIsSelected = driver.findElement(radioInput).isSelected();
        Assertions.assertTrue(raidoButtonIsSelected);

        actualMessage = driver.findElement(By.xpath("//p[@class='mt-3']")).getText();
        Assertions.assertEquals( "You have selected Impressive", actualMessage);

        System.out.println(actualMessage);
    }

    @Test
    public void radioButton3Test(){
        By radioButton = By.id("noRadio");
        boolean isOption1Enabled = driver.findElement(radioButton).isEnabled();
        Assertions.assertFalse(isOption1Enabled);
        System.out.println("The radio Button is not selectable");
    }


    @BeforeEach
    public void beforeEach(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.navigate().to("https://demoqa.com/radio-button");
    }
    @AfterEach
    public void afterEach(){
        driver.quit();
    }
}
