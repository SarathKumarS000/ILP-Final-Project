package com.eminence.chitty.jwt.helper;

import com.eminence.chitty.jwt.entity.Manager;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Helper {

    final static String defaultPassword = "$2a$10$z5gwKRfEH3nTy5kquLIdeelC6eGZvyQ4AlKufhbpFWZMCUnQ459.a";

    //check that file is of excel type or not
    public static boolean checkExcelFormat(MultipartFile file) {

        String contentType = file.getContentType();

        if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
            return true;
        } else {
            return false;
        }

    }


    //convert excel to list of products

    public static List<Manager> convertExcelToListOfManager(InputStream is) {
        List<Manager> list = new ArrayList<>();

        try {


            XSSFWorkbook workbook = new XSSFWorkbook(is);

            XSSFSheet sheet = workbook.getSheet("Sheet1");

            int rowNumber = 0;
            Iterator<Row> iterator = sheet.iterator();

            while (iterator.hasNext()) {
                Row row = iterator.next();

                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cells = row.iterator();

                int cid = 0;

                Manager p = new Manager();

                while (cells.hasNext()) {
                    Cell cell = cells.next();

                    switch (cid) {
                        case 0:
                            p.setEmp_id((long) cell.getNumericCellValue());
                            break;
                        case 1:
                            p.setFirstName(cell.getStringCellValue());
                            p.setPassWordStatus("default");
                            break;
                        case 2:
                            p.setEmp_lastname(cell.getStringCellValue());
                            break;
                        case 3:
                            p.setEmail(cell.getStringCellValue());
                            break;
                        case 4:
                            p.setMobileNumber((long)cell.getNumericCellValue());
                            break;
                        case 5:
                            p.setPassWord(defaultPassword);
                            break;
                        case 6:
                            p.setRoleId((long)cell.getNumericCellValue());
                        default:
                    }
                    cid++;

                }

                list.add(p);


            }


        } catch (Exception e) {

            e.printStackTrace();
        }
        return list;

    }


}
