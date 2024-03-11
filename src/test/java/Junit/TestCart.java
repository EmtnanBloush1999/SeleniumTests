package Junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCart {

    /** 1. class level
     2. BeforeAll
     3. BeforeEach
     4. testMethod1
     5. AfterEach
     6. BeforeEach
     7. testMethod2
     8. AfterEach
     9. After All*/
    WebDriver driver;

    @Test
    public void addToCart(){

        // Add the first item you find to your cart
        WebElement firstItemAddToCartButton = driver.findElement(By.xpath("//button[@class='btn_primary btn_inventory'][1]"));
        firstItemAddToCartButton.click();

        // Open your cart
        WebElement cartIcon = driver.findElement(By.xpath("//a[@class='shopping_cart_link fa-layers fa-fw']"));
        cartIcon.click();
        //or
        //driver.navigate().to("https://www.saucedemo.com/v1/cart.html");

        // Get the item name inside the cart
        WebElement itemNameInCart = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));

        // Assert that the item name is correct inside the cart
        String actualItemNameInCart = itemNameInCart.getText();
        String expectedItemName = "Sauce Labs Backpack";
        System.out.println("Item name in cart: " + actualItemNameInCart);
        assertEquals(expectedItemName, actualItemNameInCart);

    }

    @BeforeEach
    public void beforeEach(){
        // initializing the session
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);

        // initial navigation
        driver.navigate().to("https://www.saucedemo.com/v1/inventory.html");

    }

    @AfterEach
    public void afterEach(){
        //terminating the session
        driver.quit();
    }
}
