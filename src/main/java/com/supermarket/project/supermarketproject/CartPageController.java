package com.supermarket.project.supermarketproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class CartPageController {
    private Parent root;
    private Stage stage;
    @FXML
    Button homeBtn,cartBtn,profileBtn;
    public void initialize() {
        homeBtn.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("icons8-home-24.png"))));
        cartBtn.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("icons8-cart-30.png"))));
        profileBtn.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("icons8-person-30.png"))));
    }
    public void toHomePage(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("home-page.fxml"));
        root = fxmlLoader.load();
        stage = (Stage) cartBtn.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
    public void toProfilePage(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("profile-page.fxml"));
        root = fxmlLoader.load();
        stage = (Stage) cartBtn.getScene().getWindow();
        stage.setScene(new Scene(root));
    }


}
