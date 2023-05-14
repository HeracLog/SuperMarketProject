/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.supermarket.project.supermarketproject;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

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
        if(!z.exists()){
                z.createNewFile();
               PrintWriter output=new PrintWriter(z);
               output.print(message);
            
        }
         } catch (IOException ex) {
                ex.printStackTrace();
            }
    }
}
