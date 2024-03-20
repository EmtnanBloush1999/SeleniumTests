package TestNGAssignments;

import TestNG.TestBase;
import org.testng.annotations.Test;

public class DependsOnTest extends TestBase {

    /*
    Create tests that depend on each other
    Create beforeClass and set up settings.
    By creating interdependent tests;
    First go to Facebook.
    Then go to Google depending on Facebook,
    Then go to Amazon depending on Google
    Close the driver.
     */
    
    @Test
    public void testNavigateToFacebook() {
       bot.navigate("https://www.facebook.com");
        // Add assertions or actions specific to Facebook page
    }

    @Test(dependsOnMethods = {"testNavigateToFacebook"})
    public void testNavigateToGoogle() {
        bot.navigate("https://www.google.com");
        // Add assertions or actions specific to Google page
    }

    @Test(dependsOnMethods = {"testNavigateToGoogle"})
    public void testNavigateToAmazon() {
        bot.navigate("https://www.amazon.com");
        // Add assertions or actions specific to Amazon page
    }
}
