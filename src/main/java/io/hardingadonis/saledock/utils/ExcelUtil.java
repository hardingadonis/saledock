package io.hardingadonis.saledock.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;

public class ExcelUtil {

    public static String generateCustomersExcel(String path) {
        String[] header = {"ID", "Mã khách hàng", "Tên khách hàng", "Email", "Địa chỉ"};

        final String pathSave = path + "customers.xlsx";

        try (XSSFWorkbook workbook = new XSSFWorkbook()) {
            XSSFSheet sheet = workbook.createSheet("Khách hàng");

            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < header.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(header[i]);
            }

            var list = Singleton.customerDAO.getAll();

            for (int i = 0; i < list.size(); i++) {
                Row row = sheet.createRow(i + 1);
                row.createCell(0).setCellValue(list.get(i).getID());
                row.createCell(1).setCellValue(list.get(i).getCode());
                row.createCell(2).setCellValue(list.get(i).getName());
                row.createCell(3).setCellValue(list.get(i).getEmail());
                row.createCell(4).setCellValue(list.get(i).getAddress());
            }

            workbook.write(new FileOutputStream(pathSave));
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        return pathSave;
    }

    public static String generateProductsExcel(String path) {
        String[] header = {"ID", "Code", "Tên sản phẩm", "Mô tả", "Giá", "Phân loại"};

        final String pathSave = path + "products.xlsx";

        try (XSSFWorkbook workbook = new XSSFWorkbook()) {
            XSSFSheet sheet = workbook.createSheet("Sản phẩm");

            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < header.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(header[i]);
            }

            var list = Singleton.productDAO.getAll();

            for (int i = 0; i < list.size(); i++) {
                Row row = sheet.createRow(i + 1);
                row.createCell(0).setCellValue(list.get(i).getID());
                row.createCell(1).setCellValue(list.get(i).getCode());
                row.createCell(2).setCellValue(list.get(i).getName());
                row.createCell(3).setCellValue(list.get(i).getDescription());
                row.createCell(4).setCellValue(list.get(i).getPrice());
                row.createCell(5).setCellValue(list.get(i).getCategory().getName());
            }

            workbook.write(new FileOutputStream(pathSave));
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        return pathSave;
    }
}
