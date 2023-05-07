package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.parsers.*;

public class DataStore {

    public static void store(Staff s)
    {
        String xmlData = "";
        xmlData += "<Staff>\n<Name>"+ s.getName()+"</Name>\n";
        xmlData += "<ID>"+ s.getId() + "</ID>\n";
        xmlData += "<Salary>" + s.getSalary()+ "</Salary>\n";
        xmlData += "<PhoneNumber>" + s.getPhoneNumber()+ "</PhoneNumber>\n";
        xmlData += "<Address>" + s.getAddress()+ "</Address>\n</Staff>";
        writeData("resources/Staff.xml", xmlData);
    }
    public static void store(RegularClient rc)
    {
        String xmlData = "";
        xmlData += "<Client>\n<Name>" + rc.getName()+ "</Name>\n";
        xmlData += "<Age>" + rc.getAge()+ "</Age>\n";
        xmlData += "<ID>" + rc.getId()+ "</ID>\n";
        xmlData += "<TelephoneNum>" + rc.getTelephoneNum()+ "</TelephoneNum>\n";
        xmlData += "<Street>"+ rc.getAddress()[0]+"</Street>\n";
        xmlData += "<Town>" + rc.getAddress()[1] + "</Town>\n";
        xmlData += "<HomeNumber>" + rc.getAddress()[2] + "</HomeNumber>\n</Client>";

        writeData("/resources/Clients.xml",xmlData);
    }
    public static void store(GoldenClients gc)
    {
        String xmlData = "";
        xmlData += "<Client>\n<Name>" + gc.getName()+ "</Name>\n";
        xmlData += "<Age>" + gc.getAge()+ "</Age>\n";
        xmlData += "<ID>" + gc.getId()+ "</ID>\n";
        xmlData += "<Birthday>" + gc.getBirthDay().toString() + "</Birthday>\n";
        xmlData += "<FavouriteProduct>" + gc.getFavoriteProduct().getName() + "</FavouriteProduct>\n";
        xmlData += "<TelephoneNum>" + gc.getTelephoneNum()+ "</TelephoneNum>\n";
        xmlData += "<Street>"+ gc.getAddress()[0]+"</Street>\n";
        xmlData += "<Town>" + gc.getAddress()[1] + "</Town>\n";
        xmlData += "<HomeNumber>" + gc.getAddress()[2] + "</HomeNumber>\n</Client>";

        writeData("/resources/GoldenClients.xml",xmlData);
    }
    public static void store(Product p)
    {
       String xmlData = "";

    }
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
