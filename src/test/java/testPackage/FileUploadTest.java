package testPackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class FileUploadTest extends TestBase{

    /**
     * Breakout Activity: 20 minute
     * navigate to <a href="https://the-internet.herokuapp.com/upload">Upload Test</a>
     * uploading any file from your machine (make it small please)
     * checking to see that the file was successfully uploaded
     */

    @Test
    public void fileUploadTest(){
        String url = "https://the-internet.herokuapp.com/upload";
        logger.info("Navigate to: "+url);
        driver.navigate().to(url);

        String fileUploadPath = System.getProperty("user.home") + "/OneDrive/Pictures/Screenshots/Screenshot 2024-02-15 123058.png";
        By filesUploadInput = By.xpath("(//input[@type='file'])[1]");
        logger.info("Uploading File: "+filesUploadInput);
        driver.findElement(filesUploadInput).sendKeys(fileUploadPath);
        driver.findElement(filesUploadInput).submit();

        By uploadSuccessfullyLabel = By.tagName("h3");
        logger.info("Confirming that the file has been uploaded successfully. " );
        Assertions.assertEquals("File Uploaded!",driver.findElement(uploadSuccessfullyLabel).getText());
    }
}
