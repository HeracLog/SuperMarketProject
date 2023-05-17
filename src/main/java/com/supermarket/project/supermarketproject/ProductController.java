package com.supermarket.project.supermarketproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ProductController {
    @FXML
    TextField name,category,stock,Price,ID,expiryDate;
    @FXML
    Button generate,Store,Cancel;
    Parent root;


    @FXML
    public void IdGenerator(ActionEvent event) {
        long num = System.nanoTime();
        String id = String.valueOf(num%10000);
        ID.setText(id);
    }
    @FXML
    public void Store() throws IOException {
        Product p = new Product(Integer.parseInt(ID.getText()),name.getText(),category.getText(),Double.parseDouble(Price.getText()),expiryDate.getText(),Integer.parseInt(stock.getText()),0);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StaffHome.fxml"));
        root = fxmlLoader.load();
        Stage stage = (Stage) name.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
    @FXML
    protected void OnCancel() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StaffHome.fxml"));
        root = fxmlLoader.load();
        Stage stage = (Stage) name.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
}
