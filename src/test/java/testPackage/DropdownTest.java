package testPackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownTest extends TestBase {

    @Test
    public void testDropdown() {
        driver.navigate().to("https://demoqa.com/select-menu");
        // Find the dropdown element
        By dropdown = By.id("oldSelectMenu");
        // Create Select object
        Select select = new Select(driver.findElement(dropdown));

        // Get all options
        List<WebElement> options = select.getOptions();

        // Options size
        System.out.println("Options size: " + options.size());

        // Print all options
        System.out.println("Options:");
        for (WebElement option : options) {
            System.out.println(option.getText());
        }

        // Verify the dropdown has option "Black"
        boolean blackOptionPresent = false;
        for (WebElement option : options) {
            if (option.getText().equals("Black")) {
                blackOptionPresent = true;
                break;
            }
        }
        Assertions.assertTrue(blackOptionPresent, "Dropdown does not have option 'Black'");

        // Print FirstSelectedOptionTest
        System.out.println("First selected option: " + select.getFirstSelectedOption().getText());

        // Select option "Yellow"
        select.selectByVisibleText("Yellow");

        // Verify option "Yellow" is selected
        Assertions.assertEquals("Yellow", select.getFirstSelectedOption().getText());
    }

}