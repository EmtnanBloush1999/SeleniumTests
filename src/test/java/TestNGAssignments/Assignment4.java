package TestNGAssignments;

import TestNG.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Assignment4 extends TestBase {

    //Open the site: http://opencart.abstracta.us/index.php?route=account/login
    //Login with that credentials
    //Email: clarusway@gmail.com
    //Password: 123456789
    //Using the Search function do it with Data Provider for Mac, iPad and Samsung.

    @DataProvider(name = "searchItems")
    public Object[][] searchItemsProvider() {
        return new Object[][]{{"Mac"}, {"iPad"}, {"Samsung"}};
    }

    @Test(dataProvider = "searchItems")
    public void searchTest(String item){
        bot.navigate("http://opencart.abstracta.us/index.php?route=account/login");
        By emailInput = By.id("input-email");
        By passwordInput = By.id("input-password");
        By loginButton = By.xpath("//input[@value='Login']");

        bot.type(emailInput,"clarusway@gmail.com");
        bot.type(passwordInput,"123456789");
        bot.click(loginButton);

        By searchInput = By.name("search");
        bot.type(searchInput,item+ Keys.ENTER);

        logger.info("Using the Search function do it with Data Provider for Mac, iPad and Samsung");
        int searchResultsCount = driver.findElements(By.xpath("//div[contains(@class,'product-layout')]")).size();
        logger.info("Search results for " + item + ": " + searchResultsCount);
    }
}
