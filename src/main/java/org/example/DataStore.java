package org.example;

import java.io.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

public class DataStore {

    public static void store(Staff s)
    {
        File f = new File("Staff.xlsx");
        HSSFWorkbook dataStored;
        if (!f.exists()) {
            dataStored = new HSSFWorkbook();
        }
        else{
            try {
                dataStored = new HSSFWorkbook(new FileInputStream("Staff.xlsx"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        HSSFSheet sheet;
        if (dataStored.getSheet(s.getName() +s.getId())==null){
        sheet = dataStored.createSheet(s.getName() + s.getId());
        }
        else {
            sheet = dataStored.getSheet(s.getName()+s.getId());
        }
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

        try (FileOutputStream outputStream = new FileOutputStream("Staff.xlsx")) {
            dataStored.write(outputStream);
            outputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void store(RegularClient rc)
    {
        File f = new File("Client.xlsx");
        HSSFWorkbook dataStored;
        if (!f.exists()) {
            dataStored = new HSSFWorkbook();
        }
        else{
            try {
                dataStored = new HSSFWorkbook(new FileInputStream("Client.xlsx"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        HSSFSheet sheet;
        if (dataStored.getSheet(rc.getName() +rc.getId())==null){
            sheet = dataStored.createSheet(rc.getName() + rc.getId());
        }
        else {
            sheet = dataStored.getSheet(rc.getName()+rc.getId());
        }
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

        try (FileOutputStream outputStream = new FileOutputStream("Client.xlsx")) {
            dataStored.write(outputStream);
            outputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void store(GoldenClients gc)
    {
        File f = new File("GoldenClient.xlsx");
        HSSFWorkbook dataStored;
        if (!f.exists()) {
            dataStored = new HSSFWorkbook();
        }
        else{
            try {
                dataStored = new HSSFWorkbook(new FileInputStream("GoldenClient.xlsx"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        HSSFSheet sheet;
        if (dataStored.getSheet(gc.getName() +gc.getId())==null){
            sheet = dataStored.createSheet(gc.getName() + gc.getId());
        }
        else {
            sheet = dataStored.getSheet(gc.getName()+gc.getId());
        }
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

        try (FileOutputStream outputStream = new FileOutputStream("GoldenClient.xlsx")) {
            dataStored.write(outputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void store(Product p)
    {
        File f = new File("Product.xlsx");
        HSSFWorkbook dataStored;
        if (!f.exists()) {
            dataStored = new HSSFWorkbook();
        }
        else{
            try {
                dataStored = new HSSFWorkbook(new FileInputStream("Product.xlsx"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        HSSFSheet sheet;
        if (dataStored.getSheet(p.getName() +p.getID())==null){
            sheet = dataStored.createSheet(p.getName() + p.getID());
        }
        else {
            sheet = dataStored.getSheet(p.getName()+p.getID());
        }
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

        try (FileOutputStream outputStream = new FileOutputStream("Product.xlsx")) {
            dataStored.write(outputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
