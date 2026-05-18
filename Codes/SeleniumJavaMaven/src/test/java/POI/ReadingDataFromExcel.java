package POI;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadingDataFromExcel {
    public static void main(String[] args) throws IOException {
        //1) Get File
        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\TestData\\dataRead.xlsx");
        //2) Get the workbook
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        //3) Get the sheet using name or index
        XSSFSheet sheet = workbook.getSheet("Users");
            // OR XSSFSheet sheet = workbook.getSheetAt(0);

        //4) Get no. of rows
        int totalRows = sheet.getLastRowNum();
        //5) Get no. of cells
        int totalCells = sheet.getRow(1).getLastCellNum();

        //loop through the cells
        for (int r = 0; r <= totalRows ; r++) {

            XSSFRow curr = sheet.getRow(r);

            for (int c = 0; c < totalCells; c++) {      //as column no. starts from 1 in excel
                XSSFCell cell = curr.getCell(c);
                System.out.print(cell.toString() + " ");
            }
            System.out.println();
        }

        workbook.close();
        file.close();


    }
}
