package io.hardingadonis.saledock.utils;

import io.hardingadonis.saledock.model.Order;
import io.hardingadonis.saledock.model.OrderDetail;
import org.apache.poi.ss.formula.functions.Column;
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

    public static String generateOrderDetailExcel(String path, Integer ID) {
        final String pathSave = path + "order.xlsx";

        try (XSSFWorkbook workbook = new XSSFWorkbook()) {
            XSSFSheet sheet = workbook.createSheet("Đơn hàng");

            var orderBox = Singleton.orderDAO.getByID(ID);

            if (orderBox.isPresent()) {
                var order = orderBox.get();

                var row = sheet.createRow(0);
                row.createCell(0).setCellValue("Mã đơn hàng");
                row.createCell(1).setCellValue(order.getCode());

                row = sheet.createRow(1);
                row.createCell(0).setCellValue("Khách hàng");
                row.createCell(1).setCellValue(order.getCustomer().getName());

                row = sheet.createRow(2);
                row.createCell(0).setCellValue("Nhân viên");
                row.createCell(1).setCellValue(order.getEmployee().getFullName());

                row = sheet.createRow(3);
                row.createCell(0).setCellValue("Ngày tạo");
                row.createCell(1).setCellValue(order.getCreatedAt());

                row = sheet.createRow(4);
                row.createCell(0).setCellValue("Trạng thái");
                row.createCell(1).setCellValue(order.getStatus().toString());

                row = sheet.createRow(5);
                row.createCell(0).setCellValue("Tổng số tiền");
                row.createCell(1).setCellValue(order.getTotal());

                String[] header = {"Code", "Tên sản phẩm", "Đơn giá", "Số lượng", "Tổng tiền"};

                Row headerRow = sheet.createRow(7);
                for (int i = 0; i < header.length; i++) {
                    Cell cell = headerRow.createCell(i);
                    cell.setCellValue(header[i]);
                }

                var detail = order.getOrderDetails().toArray();

                for (int i = 0; i < detail.length; i++) {
                    row = sheet.createRow(i + 8);

                    var d = (OrderDetail) detail[i];

                    row.createCell(0).setCellValue(d.getID().getProductID());
                    row.createCell(1).setCellValue(d.getProduct().getName());
                    row.createCell(2).setCellValue(d.getProduct().getPrice());
                    row.createCell(3).setCellValue(d.getQuantity());
                    row.createCell(4).setCellValue(d.getQuantity() * d.getProduct().getPrice());
                }

                workbook.write(new FileOutputStream(pathSave));
            }

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        return pathSave;
    }
}
