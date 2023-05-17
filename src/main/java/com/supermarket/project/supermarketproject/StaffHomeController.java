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

public class StaffHomeController {

    @FXML
    Button StaffHome,StaffProfile,AddProduct,LogoutButton;

    public void initialize()
    {
        StaffHome.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("icons8-home-24.png"))));
        StaffProfile.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("icons8-person-30.png"))));
    }
    @FXML
    protected void onProductAdd() throws IOException {
        FXMLLoader load = new FXMLLoader(StaffHomeController.class.getResource("AddProduct.fxml"));
        Stage stage = (Stage) StaffProfile.getScene().getWindow();
        Scene sc = new Scene(load.load());
        stage.getIcons().add(new Image(getClass().getResourceAsStream("OIP.jpeg")));
        stage.setScene(sc);
        stage.show();
    }
    @FXML
    protected void onProfile() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("StaffProfile.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) StaffHome.getScene().getWindow();
        stage.getIcons().add(new Image(getClass().getResourceAsStream("OIP.jpeg")));
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    protected void logout() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("login.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) StaffHome.getScene().getWindow();
        stage.getIcons().add(new Image(getClass().getResourceAsStream("OIP.jpeg")));
        stage.setResizable(false);
        stage.setScene(new Scene(root,800,450));
        stage.show();
    }
}
