package com.supermarket.project.supermarketproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ApplicationMain extends Application {
    static ArrayList<GoldenClients> goldenClients;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ApplicationMain.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        //  goldenClients = new ArrayList<>();

//        ArrayList<Product> p = new ArrayList<>();
//        p.add(new Product(12,"","",1,1,null,12,12));
//        p.add(new Product(12,"","",1,1,null,12,122));
//        p.add(new Product(12,"","",1,1,null,12,1));
//        p.add(new Product(12,"","",1,1,null,12,112));
//        WeeklyCheck.mostSold(p);

//            GenreateQR.generateQRCode("Good morning");
//            Product p = new Product(12,"Apple","Fruit",122,new Date(),23,412);
//        DataStore.store(new Staff(14,"Cristiano",12.3,"12433","Street 5"));
//        DataStore.store(new Staff(14,"Barahoom",12.3,"12433","Street 5"));
//
//
//        DataStore.store(new Product(13,"Biscuits","Sweets",1.5,new Date(),7,32));
        launch();
    }
}