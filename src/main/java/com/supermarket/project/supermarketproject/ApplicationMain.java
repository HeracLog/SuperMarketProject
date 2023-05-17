package com.supermarket.project.supermarketproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ApplicationMain extends Application {
    static ArrayList<RegularClient> regularClients;
    static ArrayList<Product> products;
    static ArrayList<Staff> staff;
    static ArrayList<GoldenClients> goldenClients;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ApplicationMain.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 450);
        stage.setTitle("supermarketName");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("OIP.jpeg")));
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
       launch();
    }
}