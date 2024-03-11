package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class GoogleTest extends TestBase{

    /**
     * Breakout task: 40 minutes
     * 1. recreate the base test class for junit with testng
     * 2. copy the actionsbot to your project under `src/main/java/engine`
     * 3. create a new tests.testng package
     * 4. create a new class
     * 5. do a quick google search and assert that result stats is not empty using testng
     */

    @Test
    public void GoogleSearchTest(){

        bot.navigate("https://www.google.com/");

        By SearchBar = By.id("APjFqb");
        bot.type(SearchBar,"SDA"+ Keys.RETURN);
        By result= By.id("result-stats");
        assert !"".equals(driver.findElement(result).getText()):"it is empty";
    }
}
