package com.supermarket.project.supermarketproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class ApplicationMain extends Application {
    static ArrayList<RegularClient> regularClients;
    static ArrayList<Product> products;
    static ArrayList<Staff> staff;
    static ArrayList<GoldenClients> goldenClients;
    static String[] currentSession;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ApplicationMain.class.getResource("login.fxml"));
        Scene scene = new Scene((Parent) fxmlLoader.load(), 800, 450);
        stage.setTitle("supermarketName");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("OIP.jpeg")));
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException {
        currentSession = new String[2];
        regularClients = new ArrayList<>();
        products = new ArrayList<>();
        goldenClients = new ArrayList<>();
        staff = new ArrayList<>();
        if (!hasRan())
        {
            serial(regularClients,"Clients.ser");
            serial(staff,"Staff.ser");
            serial(products,"Products.ser");
            serial(goldenClients,"GoldenClients.ser");
        }
        else{
         regularClients = deserial("Clients.ser");
         staff = deserial("Staff.ser");
         products = deserial("Products.ser");
         goldenClients = deserial("GoldenClients.ser");
        }
       launch();
    }

    static void serial(ArrayList al,String filename)
    {
        try (FileOutputStream fos = new FileOutputStream(filename);
             ObjectOutputStream oos = new ObjectOutputStream(fos);) {

            oos.writeObject(al);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    static ArrayList deserial(String filename)
    {
        try (FileInputStream fis = new FileInputStream(filename);
             ObjectInputStream ois = new ObjectInputStream(fis);) {

             return  (ArrayList) ois.readObject();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
        return null;
    }
    static boolean hasRan() throws IOException {
        File n = new File("hasran.txt");
        if(!n.exists())
        {
            n.createNewFile();
            return false;
        }
        else{
            return true;
        }
    }
}