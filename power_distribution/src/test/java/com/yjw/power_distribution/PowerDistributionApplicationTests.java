package com.yjw.power_distribution;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootTest
class PowerDistributionApplicationTests {

    /**
     * 拿到不同类型单元格中的值
     * 1. 字符串: 字符串
     * 2. 布尔: toString
     * 3. 数值(double): 格式化后的字符串
     * @param cell 获取的单元格
     * @return 单元格中的值
     */
    private static String getCellValue(Cell cell) {
        String resultValue = "";
        // 判空
        if (Objects.isNull(cell)) {
            return resultValue;
        }

        // 拿到单元格类型
        int cellType = cell.getCellType();
        switch (cellType) {
            // 字符串类型
            case Cell.CELL_TYPE_STRING:
                resultValue = StringUtils.isEmpty(cell.getStringCellValue()) ? "" : cell.getStringCellValue().trim();
                break;
            // 布尔类型
            case Cell.CELL_TYPE_BOOLEAN:
                resultValue = String.valueOf(cell.getBooleanCellValue());
                break;
            // 数值类型
            case Cell.CELL_TYPE_NUMERIC:
                resultValue = new DecimalFormat("#.######").format(cell.getNumericCellValue());
                break;
            // 取空串
            default:
                break;
        }
        return resultValue;
    }


    @Test
    void contextLoads() {
        System.out.println(123);
        try {
            Workbook book = new XSSFWorkbook(new FileInputStream("C:/Users/Admin/Desktop/data.xlsx"));
            for (int t = 0; t < book.getNumberOfSheets(); t++){
                Sheet sheet = book.getSheetAt(t);
                Row row = null;
                int lastRowNum = sheet.getLastRowNum();

                for (int i = 0; i <= lastRowNum; i++){
                    row = sheet.getRow(i);
                    if (row != null){
                        for (int j = 0; j < row.getLastCellNum(); j++){
                            Cell cell = row.getCell(j);
                            String value = getCellValue(cell);
                            if (!value.equals("")){
                                System.out.print(value + "\t");
                            }
                        }
                    }
                    System.out.println();
                }
            }

        } catch (IOException e){
            System.out.println("读取文件异常");
        }
    }
}
