package POI;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class WritingDataToExcel {
    public static void main(String[] args) throws IOException {
        FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\TestData\\dataWrite.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook();

        XSSFSheet sheet = workbook.createSheet("data");

        int count = 1;

        //Create 5 rows and 5 cells
        for (int i = 0; i <= 4; i++) {
            XSSFRow currRow = sheet.createRow(i);
            for (int j = 0; j < 5; j++) {
                currRow.createCell(j).setCellValue(count);
                count++;
            }
        }

        workbook.write(file);
        workbook.close();
        file.close();
    }
}
