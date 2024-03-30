package FluentPageObject;

import TestNG.TestBase;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import LambAssignment.Register;


public class RegisterTests extends TestBase {

       /*
            go to url : https://ecommerce-playground.lambdatest.io/index.php?route=account/register
            register account test with fluent page object approach
         */

    @Test(description = "Successful Register")
    public void testRegistration() throws Exception {

        JSONObject registerData = (JSONObject) testData.get("RegisterPage");

        logger.info("Filling Register Form");
        String firstname = (String) registerData.get("firstName");
        String lastname = (String) registerData.get("lastName");
        String email = (String) registerData.get("email");
        String phoneNumber = (String) registerData.get("phoneNumber");
        String password = (String) registerData.get("password");
        String passwordConfirm = (String) registerData.get("PasswordConfirm");


        Register registerPage = new Register(driver, bot, logger);
        registerPage.goTo()
                .RegisterPage(firstname, lastname, email, phoneNumber, password, passwordConfirm)
                .VerifyAccountCreationMessage();

        logger.info("The Account Has Been Created");
        String actualMessage = registerPage.VerifyAccountCreationMessage();
        Assert.assertEquals(actualMessage, "Your Account Has Been Created!");
    }
}