package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtils {
    

    public static Object[][] readExcel(String filePath, String nameSheet) throws IOException {
        List<Map<String, String>> dataList = new ArrayList<>();
        FileInputStream file = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheet(nameSheet);
        if(sheet == null){
            throw new IllegalArgumentException("the sheet doesn't exits " + nameSheet);
        }
        Row headerRow = sheet.getRow(0);
        if(headerRow == null){
            throw new IllegalArgumentException("the first row (header) is empty");
        }
        int numColumns = headerRow.getPhysicalNumberOfCells();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if(row == null) continue;
            Map<String, String> rowData = new HashMap<>();

            for (int j = 0; j < numColumns; j++) {
                Cell headercell = headerRow.getCell(j);
                Cell cell = row.getCell(j);

                if(headercell == null) continue;
                String key = headercell.getStringCellValue();
                String value = (cell == null) ? "" : getCellValueAsString(cell);

                rowData.put(key, value);
            }
            dataList.add(rowData);
        }

        Object[][] result = new Object[dataList.size()][1];
        for (int i = 0; i < dataList.size(); i++) {
            result[i][0] = dataList.get(i);
        }

        return result;
    }

    private static String getCellValueAsString(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue().trim();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    return NumberToTextConverter.toText(cell.getNumericCellValue());
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:
                return "";
            default:
                return "";
        }
    }
}
