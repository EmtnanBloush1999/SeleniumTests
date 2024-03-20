package TestNGAssignments;

import TestNG.TestBase;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class Assignment2 extends TestBase {
    /*
    Go to https://testpages.eviltester.com/styled/apps/notes/simplenotes.html
    Add 10 notes using data provider with excel
    Run it with 3 different browsers using XML file
    Run it parallel with 3 threads
     */

    @DataProvider(name = "getData")
    public Object[][] getData() throws IOException {
        String path = System.getProperty("user.home") + "\\IdeaProjects\\firstSlum\\src\\test\\resources\\testData\\";
        FileInputStream fileData = new FileInputStream(path + "Assignment2.xlsx");
        Workbook workbook = WorkbookFactory.create(fileData);
        Sheet sheet = workbook.getSheetAt(0);

        int rows = sheet.getPhysicalNumberOfRows();
        Object[][] data = new Object[rows][2];

        for (int index = 0; index < rows; index++) {
            Row row = sheet.getRow(index);
            data[index][0] = row.getCell(0).getStringCellValue(); // Note Title
            data[index][1] = row.getCell(1).getStringCellValue(); // Note Content
        }
        workbook.close();
        fileData.close();
        return data;
    }

    @Test(dataProvider = "getData")
    public void addNoteTest(String noteTitle, String noteContent) {
        bot.navigate("https://testpages.eviltester.com/styled/apps/notes/simplenotes.html");

        By titleInput = By.id("note-title-input");
        By contentInput = By.id("note-details-input");
        By addButton = By.id("add-note");

        bot.type(titleInput, noteTitle);
        bot.type(contentInput, noteContent);
        bot.click(addButton);
    }
}