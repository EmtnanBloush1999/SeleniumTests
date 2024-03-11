package Junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class DragNDropTask extends TestBase{
    @Test
    public void dragNDropTest(){
        driver.navigate().to("https://www.selenium.dev/selenium/web/droppableItems.html");
        By draggable = By.id("draggable");
        By droppable = By.id("droppable");
        new Actions(driver)
            .dragAndDrop(driver.findElement(draggable), driver.findElement(droppable))
            .perform();
        String text = driver.findElement(By.xpath("//p[text()='Dropped!']")).getText();
        Assertions.assertEquals("Dropped!",text);
    }
}
