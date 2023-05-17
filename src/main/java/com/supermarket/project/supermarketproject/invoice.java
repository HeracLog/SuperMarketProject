/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.supermarket.project.supermarketproject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author LENOVO
 */
public class invoice {
    public static void x(String message , String name,String id){
        long num=System.nanoTime();
        int rand=(int) num%101;
        try {
        File z = new File(name+id+rand+".txt");
        z.createNewFile();
        FileWriter f = new FileWriter(z);
        f.write(message);
        f.close();
         } catch (IOException ex) {
                ex.printStackTrace();
            }
    }
}
