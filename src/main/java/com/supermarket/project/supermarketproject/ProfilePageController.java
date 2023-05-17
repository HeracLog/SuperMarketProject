package com.supermarket.project.supermarketproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class ProfilePageController {
    private Parent root;
    private Stage stage;
    @FXML
    Label nameLabel,idLabel,ageLabel;
    @FXML
    Button homeBtn,cartBtn,profileBtn;
    public void initialize() {
        homeBtn.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("icons8-home-24.png"))));
        cartBtn.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("icons8-cart-30.png"))));
        profileBtn.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("icons8-person-30.png"))));
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sign-up.fxml"));
//        RegularClient regularClient = fxmlLoader.getController();
//        nameLabel.setText(regularClient.getName());
//        idLabel.setText(regularClient.getId());
//        ageLabel.setText(String.valueOf(regularClient.getAge()));
    }
//    public void setData(ActionEvent event) {
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sign-up.fxml"));
//        RegularClient regularClient = fxmlLoader.getController();
//        nameLabel.setText(regularClient.getName());
//        idLabel.setText(regularClient.getId());
//        ageLabel.setText(String.valueOf(regularClient.getAge()));
//    }
    @FXML
    protected void toHomePage() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("home-page.fxml"));
        root = fxmlLoader.load();
        stage = (Stage) cartBtn.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
    public void toCartPage(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("cart-page.fxml"));
        root = fxmlLoader.load();
        stage = (Stage) cartBtn.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
}
