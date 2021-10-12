package com.yjw.power_distribution.controller;


import com.yjw.power_distribution.pojo.User;
import com.yjw.power_distribution.service.DeviceService;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.DecimalFormat;
import java.util.Objects;
import java.util.UUID;

@Controller
@RequestMapping("/test")
public class fileUpload {

    @Autowired
    DeviceService deviceService;

    @PostMapping("/fileload")
    @ResponseBody
    public String uploadPicture(MultipartFile datafile, String username) throws Exception{
        File toFile = null;
        if (datafile.equals("") || datafile.getSize() <= 0 || datafile.isEmpty()) {
            return "Upload failed! Network error.";
        } else {
            InputStream ins = null;
            ins = datafile.getInputStream();
            toFile = new File(datafile.getOriginalFilename());
            String resString = inputStreamToFile(ins, toFile);
            ins.close();
            if(resString != null){
                return resString;
            }
        }
        System.out.println(toFile.getClass());
        try{
            FileInputStream in = null;
            in = new FileInputStream(toFile); 					// 创建对Excel工作簿文件的引用
            Workbook book = new XSSFWorkbook(in);
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
        }catch (Exception e){
            return "Analysis file error!";
        }
        return "Upload Successful!";
    }

    //获取流文件
    private static String inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return "InputStreamToFile failed!";
        }
    }

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
}
