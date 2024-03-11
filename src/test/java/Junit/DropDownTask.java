package Junit;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class DropDownTask extends TestBase {

    Select select;

    @Test
    public void dropDown1(){
        driver.navigate().to("https://the-internet.herokuapp.com/dropdown");
        By dr1 = By.id("dropdown");
        select = new Select(driver.findElement(dr1));
        select.selectByValue("1");
        boolean isSelected = driver.findElement(dr1).isDisplayed();
        select.selectByValue("2");
        isSelected = select.getFirstSelectedOption().isSelected();
        System.out.println(select.getFirstSelectedOption().getText());


    }
}
