package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DataStore {

    public static void store(Staff s)
    {
        String xmlData = "";
        xmlData += "<Staff><Name>"+ s.getName()+"</Name>\n";
        xmlData += "<ID>"+ s.getId() + "</ID>\n";
        xmlData += "<Salary>" + s.getSalary()+ "</Salary>\n";
        xmlData += "<PhoneNumber>" + s.getPhoneNumber()+ "</PhoneNumber>\n";
        xmlData += "<Address>" + s.getAddress()+ "</Address>\n</Staff>";
        writeData("resources/Staff.xml", xmlData);
    }
    public static void store(RegularClient rc)
    {}
    public static void store(GoldenClients gc)
    {}
    public static void store(Product p)
    {}
    private static void writeData(String path,String xmlData)
    {
        try {
            File xmlFile = new File(path);
            if(!xmlFile.exists()) {
                xmlFile.createNewFile();
            }

            FileWriter fileWritter = new FileWriter(xmlFile.getName(),true);
            BufferedWriter bw = new BufferedWriter(fileWritter);
            bw.write(xmlData);
            bw.close();
            System.out.println("Done");
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
