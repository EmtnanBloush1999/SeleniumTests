package testPackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class TestForm extends TestBase {
    /**
     * initialize the browser in maximized mode (using options)
     * navigate to <a href="https://www.selenium.dev/selenium/web/web-form.html">web form test page</a>
     * check the box and validate that it is checked
     * select the radio and validate that it is selected
     * choose an item (by value) from the select dropdown menu and validate that it is selected (by text)
     */

    @Test
    public void checkBoxTest(){
        driver.navigate().to("https://www.selenium.dev/selenium/web/web-form.html");
        By checkBox = By.id("my-check-2");
        driver.findElement(checkBox).click();
        boolean isSelected = driver.findElement(checkBox).isSelected();
        Assertions.assertTrue(isSelected);
    }

    @Test
    public void radioButtonTest(){
        driver.navigate().to("https://www.selenium.dev/selenium/web/web-form.html");
        By radioButton = By.id("my-radio-2");
        driver.findElement(radioButton).click();
        boolean isSelected = driver.findElement(radioButton).isSelected();
        Assertions.assertTrue(isSelected);
    }

    @Test
    public void dropDownMenuTest(){
        driver.navigate().to("https://www.selenium.dev/selenium/web/web-form.html");
        By selectItem = By.name("my-select");
        Select select = new Select(driver.findElement(selectItem));
        select.selectByValue("3");
        String actualText = select.getAllSelectedOptions().getFirst().getText();
        Assertions.assertEquals("Three",actualText);
    }
}
