package org.example;

import com.google.zxing.WriterException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    static ArrayList<GoldenClients> goldenClients;
    public static void main(String[] args) throws IOException, WriterException {
      //  goldenClients = new ArrayList<>();

//        ArrayList<Product> p = new ArrayList<>();
//        p.add(new Product(12,"","",1,1,null,12,12));
//        p.add(new Product(12,"","",1,1,null,12,122));
//        p.add(new Product(12,"","",1,1,null,12,1));
//        p.add(new Product(12,"","",1,1,null,12,112));
//        WeeklyCheck.mostSold(p);
        
            GenreateQR.generateQRCode("This is a test");

    }
}