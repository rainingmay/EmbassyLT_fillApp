import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.xpath.operations.String;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelHelper {

    private static FileInputStream inputFile;
    private static HSSFWorkbook wbIn;
    private static Sheet sheetIn1;
    private static Row row1;
    private static Cell cell1name, cell2surname, cell3phone, cell4email, cell5passport;
    private static java.lang.String name, surname, phone, email, passport;

    @FindBy(className = "firstname form-control")
    static WebElement nameField;

    @FindBy(className = "lastname  form-control")
    static WebElement surnameField;

    @FindBy(className = "phone  form-control")
    static WebElement phoneField;
    @FindBy(className = "email form-control")
    static WebElement emailField;
    @FindBy(className = "document  form-control")
    static WebElement passportField;

    public static void methodFillApp() throws IOException, InterruptedException {
        inputFile = new FileInputStream("!Embassy of the Republic of Lithuania to Ukraine.xls");
        wbIn = new HSSFWorkbook(inputFile);
        sheetIn1 = wbIn.getSheetAt(0);

        for (int i = 0; i < sheetIn1.getPhysicalNumberOfRows(); i++) {
            row1 = sheetIn1.getRow(i);
            if (row1 != null) {
//                for (int j = 0; i < 5; i++) {
                // it will be good to use a list of weblements
                WebDriverHelper.fillTheField(nameField, sheetIn1.getRow(i).getCell(0).getStringCellValue());
                WebDriverHelper.fillTheField(surnameField, sheetIn1.getRow(i).getCell(1).getStringCellValue());
                WebDriverHelper.fillTheField(phoneField, sheetIn1.getRow(i).getCell(2).getStringCellValue());
                WebDriverHelper.fillTheField(emailField, sheetIn1.getRow(i).getCell(3).getStringCellValue());
                WebDriverHelper.fillTheField(passportField, sheetIn1.getRow(i).getCell(4).getStringCellValue());
WebDriverHelper.waitForPage(5L);
//WebElement class=" ui-datepicker-unselectable ui-state-disabled" or class=" ui-datepicker-selectable ui-state-unabled" or consist of unabled
//            }
            }
            wbIn.close();
        }
    }
}
