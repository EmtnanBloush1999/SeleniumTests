package JUnitAssignments;

import Junit.TestBase;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

import java.io.*;

public class Assignment6 extends TestBase {

    /**
     * Store the path of the file as string and open the file.
     * Open the workbook.
     * Open the first worksheet.
     * Go to the first row.
     * Create a cell on the 3rd column (2nd index) on the first row.
     * Write “POPULATION” on that cell.
     * Create a cell on the 2nd row 3rd cell(index2), and write data.
     * Create a cell on the 3rd row 3rd cell(index2), and write data.
     * Create a cell on the 4th row 3rd cell(index2), and write data.
     * Write and save the workbook.
     * Close the file.
     * Close the workbook.
     * The 3rd column on Excel file must be empty before running.
     * Otherwise, new data will be written on the old data.
     * */

    private Sheet sheet;
    @Test
    public void excelTest() throws IOException {

        logger.info("Store the path of the file as string and open the file.");
        String path = System.getProperty("user.home")+"/IdeaProjects/firstSlum/src/test/resources/testData/Book1.xlsx";

        logger.info("Open the workbook.");
        Workbook workbook = new XSSFWorkbook(new FileInputStream(path));

        logger.info("Open the first worksheet.");
        sheet = workbook.getSheetAt(0);

        logger.info("The 3rd column on Excel file must be empty before running.\n" +
                "       Otherwise, new data will be written on the old data");
        reStart();

        logger.info("Go to the first row.\n" +
                "       Create a cell on the 3rd column (2nd index) on the first row.\n" +
                "       Write “POPULATION” on that cell.");
        writeInExcelFile(0,2,"POPULATION");

        logger.info("Create a cell on the 2nd row 3rd cell(index2), and write data.");
        writeInExcelFile(1,2,"data");

        logger.info("Create a cell on the 3rd row 3rd cell(index2), and write data.");
        writeInExcelFile(2,2,"data");

        logger.info("Create a cell on the 4th row 3rd cell(index2), and write data.");
        writeInExcelFile(3,2,"data");

        logger.info("Write and save the workbook.");
        FileOutputStream fos = new FileOutputStream(path);
        workbook.write(fos);

        logger.info("Close the file.");
        fos.close();
        logger.info("Close the workbook.");
        workbook.close();
    }


    private void reStart(){
        int lastRowIndex = sheet.getLastRowNum();
        for(int index=0; index<=lastRowIndex; index++){
            if (sheet.getRow(index) != null){
                Row row = sheet.getRow(index);
                logger.info("The row "+(row.getRowNum()+1)+" is clean now");
                System.out.println();
                sheet.removeRow(row);
            }
        }
    }

    private void writeInExcelFile(int rowIndex, int cellIndex, String value){
        if (sheet.getRow(rowIndex) == null) {
            sheet.createRow(rowIndex);
        }
        Row row = sheet.getRow(rowIndex);
        Cell cell = row.createCell(cellIndex);
        cell.setCellValue(value);
        logger.info("The value on Row "+(row.getRowNum()+1) +" and cell " + (cell.getColumnIndex()+1) +" is " +cell.getStringCellValue());
        System.out.println();
    }

}
