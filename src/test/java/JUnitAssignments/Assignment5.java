package JUnitAssignments;

import Junit.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;


public class Assignment5 extends TestBase {
    /*   Go to URL: http://facebook.com
     getCookies,
     addCookie,
     deleteCookieNamed,
     deleteAllCookies
*/
    @Test
    public void testCookieActions() {
        // Go to URL
        bot.navigate("http://facebook.com");
        // Get all cookies
        var cookies = driver.manage().getCookies();
        logger.info("Cookies before adding: " + cookies);
        // Add a cookie
        logger.info("Add a cookie");
        driver.manage().addCookie(new Cookie("example_cookie", "example_value"));
        // Get all cookies after adding
        cookies = driver.manage().getCookies();
        logger.info("Cookies after adding: " + cookies);
        // Delete a specific cookie by name
        driver.manage().deleteCookieNamed("example_cookie");
        // Get all cookies after deleting the specific cookie
        cookies = driver.manage().getCookies();
        logger.info("Cookies after deleting 'example_cookie': " + cookies);
        // Delete all cookies
        driver.manage().deleteAllCookies();
        // Get all cookies after deleting all cookies
        cookies = driver.manage().getCookies();
        logger.info("Cookies after deleting all: " + cookies);
    }
}
