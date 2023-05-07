package org.example;

import java.io.File;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStore {

    public static void store(Staff s)
    {
        HSSFWorkbook dataStored = new HSSFWorkbook();
        HSSFSheet sheet = dataStored.createSheet(s.getName() + s.getId());
        Row r = sheet.createRow(0);
        String[] arrNames = {"Name", "ID", "Salary","Phone Number","Address"};
        int i = 0;
        Cell c;
        for (String title: arrNames)
        {
            c = r.createCell(i);
            c.setCellValue(title);
            i++;
        }
        r = sheet.createRow(1);
        c = r.createCell(0);
        c.setCellValue(s.getName());
        c = r.createCell(1);
        c.setCellValue(s.getId());
        c = r.createCell(2);
        c.setCellValue(s.getSalary());
        c = r.createCell(3);
        c.setCellValue(s.getPhoneNumber());
        c = r.createCell(4);
        c.setCellValue(s.getAddress());

        try (FileOutputStream outputStream = new FileOutputStream("Staff"+s.getName() +".xlsx")) {
            dataStored.write(outputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void store(RegularClient rc)
    {
        HSSFWorkbook dataStored = new HSSFWorkbook();
        HSSFSheet sheet = dataStored.createSheet(rc.getName() + rc.getId());
        Row r = sheet.createRow(0);
        String[] arrNames = {"Name", "ID", "Age","Phone Number","Street","Town","Home Number"};
        int i = 0;
        Cell c;
        for (String title: arrNames)
        {
            c = r.createCell(i);
            c.setCellValue(title);
            i++;
        }
        r = sheet.createRow(1);
        c = r.createCell(0);
        c.setCellValue(rc.getName());
        c = r.createCell(1);
        c.setCellValue(rc.getId());
        c = r.createCell(2);
        c.setCellValue(rc.getAge());
        c = r.createCell(3);
        c.setCellValue(rc.getTelephoneNum());
        c = r.createCell(4);
        c.setCellValue(rc.getAddress()[0]);
        c = r.createCell(5);
        c.setCellValue(rc.getAddress()[1]);
        c= r.createCell(6);
        c.setCellValue(rc.getAddress()[2]);

        try (FileOutputStream outputStream = new FileOutputStream("Client"+rc.getName() +".xlsx")) {
            dataStored.write(outputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void store(GoldenClients gc)
    {
        HSSFWorkbook dataStored = new HSSFWorkbook();
        HSSFSheet sheet = dataStored.createSheet(gc.getName() + gc.getId());
        Row r = sheet.createRow(0);
        String[] arrNames = {"Name", "ID", "Age","Phone Number","Street","Town","Home Number","Birthday","Favourite Product"};
        int i = 0;
        Cell c;
        for (String title: arrNames)
        {
            c = r.createCell(i);
            c.setCellValue(title);
            i++;
        }
        r = sheet.createRow(1);
        c = r.createCell(0);
        c.setCellValue(gc.getName());
        c = r.createCell(1);
        c.setCellValue(gc.getId());
        c = r.createCell(2);
        c.setCellValue(gc.getAge());
        c = r.createCell(3);
        c.setCellValue(gc.getTelephoneNum());
        c = r.createCell(4);
        c.setCellValue(gc.getAddress()[0]);
        c = r.createCell(5);
        c.setCellValue(gc.getAddress()[1]);
        c = r.createCell(6);
        c.setCellValue(gc.getAddress()[2]);
        c = r.createCell(7);
        c.setCellValue(gc.getBirthDay());
        c = r.createCell(8);
        c.setCellValue(gc.getFavoriteProduct().getName());

        try (FileOutputStream outputStream = new FileOutputStream("GoldenClient"+gc.getName() +".xlsx")) {
            dataStored.write(outputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void store(Product p)
    {
        HSSFWorkbook dataStored = new HSSFWorkbook();
        HSSFSheet sheet = dataStored.createSheet(p.getName() + p.getID());
        Row r = sheet.createRow(0);
        String[] arrNames = {"Name", "ID", "Price","Expiry Date","Category","In stock"};
        int i = 0;
        Cell c;
        for (String title: arrNames)
        {
            c = r.createCell(i);
            c.setCellValue(title);
            i++;
        }
        r = sheet.createRow(1);
        c = r.createCell(0);
        c.setCellValue(p.getName());
        c = r.createCell(1);
        c.setCellValue(p.getID());
        c = r.createCell(2);
        c.setCellValue(p.getBuyPrice());
        c = r.createCell(3);
        c.setCellValue(p.getExpiryDate());
        c = r.createCell(4);
        c.setCellValue(p.getCategory());
        c = r.createCell(5);
        c.setCellValue(p.getNumInStock());

        try (FileOutputStream outputStream = new FileOutputStream("Product"+p.getName() +".xlsx")) {
            dataStored.write(outputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
