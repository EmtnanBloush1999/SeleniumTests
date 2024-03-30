package LambAssignment;

import engine.ActionsBot;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public abstract class Pages {
    final WebDriver driver;

    final ActionsBot bot;

    final Logger logger;

    public Pages(WebDriver driver, ActionsBot bot, Logger logger) {
        this.driver = driver;
        this.bot = bot;
        this.logger = logger;
    }
}