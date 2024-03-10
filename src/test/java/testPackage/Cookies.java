package testPackage;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

public class Cookies extends TestBase{

    /**
     * Breakout task: 15 minutes
     * Navigate to <a href="https://kitchen.applitools.com/ingredients/cookie">Cookies</a>
     * print the total number of cookies
     * add a new "fruit=apple" cookie
     * edit the "protein" cookie to have the value "meat"
     * delete the "veggie" cookie
     * print all cookies
     * delete all cookies
     */

    @Test
    public void CookiesTest(){
        //Navigate to <a href="https://kitchen.applitools.com/ingredients/cookie">Cookies</a>
        driver.navigate().to("https://kitchen.applitools.com/ingredients/cookie");
        var cookies = driver.manage().getCookies();
        System.out.println(cookies.size());
        //print the total number of cookies
        System.out.println("before");
        cookies.forEach(System.out::println);
        //add a new "fruit=apple" cookie
        driver.manage().addCookie(new Cookie("fruit","apple"));
        //edit the "protein" cookie to have the value "meat"
        driver.manage().addCookie(new Cookie("protein","meat"));
        //delete the "veggie" cookie
        driver.manage().deleteCookieNamed("veggie");
        //print all cookies
        cookies = driver.manage().getCookies();
        System.out.println("After");
        cookies.forEach(System.out::println);
        //delete all cookies
        driver.manage().deleteAllCookies();
    }
}
