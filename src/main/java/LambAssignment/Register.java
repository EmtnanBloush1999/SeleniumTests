package LambAssignment;

import engine.ActionsBot;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;


public class Register extends Pages {

    public Register(WebDriver driver, ActionsBot bot, Logger logger) {
        super(driver, bot, logger);
    }

    private final String url = "https://ecommerce-playground.lambdatest.io/index.php?route=account/register";
    private final By firstName = By.name("firstname");
    private final By lastName = By.name("lastname");
    private final By email = By.id("input-email");
    private final By phoneNumber = By.id("input-telephone");
    private final By password = By.id("input-password");
    private final By PasswordConfirm = By.id("input-confirm");
    private final By checkBox = By.id("input-agree");
    private final By submitButton = By.xpath("//input[@type ='submit']");
    private final By CreatedAccount  = By.className("my-3");

    @Step("Given I am on the Register page")
    public Register goTo() {
        bot.navigate(url);
        return this;
    }

    @Step("Filling the form to register a new user")
    public Register RegisterPage(String firstname, String lastname, String email, String phoneNumber, String password, String PasswordConfirm) {
        bot.type(firstName, firstname);
        bot.type(lastName, lastname);
        bot.type(this.email, email);
        bot.type(this.phoneNumber, phoneNumber);
        bot.type(this.password, password);
        bot.type(this.PasswordConfirm, PasswordConfirm);
        bot.click(checkBox);
        bot.click(submitButton);
        return this;
    }

    @Step("Verifying account creation success message")
    public String VerifyAccountCreationMessage() {
        return driver.findElement(CreatedAccount).getText();

    }

}