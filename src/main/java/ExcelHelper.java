import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.xpath.operations.String;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelHelper {

    private static FileInputStream inputFile;
    private static HSSFWorkbook wbIn;
    private static Sheet sheetIn1;


    public static void mainMethodOverWrite() throws IOException, InterruptedException {
        inputFile = new FileInputStream("!Embassy of the Republic of Lithuania to Ukraine.xls");
        wbIn = new HSSFWorkbook(inputFile);
        sheetIn1 = wbIn.getSheetAt(0);

    }
}
