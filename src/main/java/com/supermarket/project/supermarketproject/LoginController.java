package com.supermarket.project.supermarketproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    private Stage stage;
    private Parent root;
    @FXML
    Button loginBtn;
    @FXML
    Button signUpBtn;

    @FXML
    protected void login(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("HomePage.fxml"));
        root = fxmlLoader.load();
        stage = (Stage) loginBtn.getScene().getWindow();
        Image image = new Image("D:\\java\\SuperMarketProject\\src\\main\\resources\\com\\supermarket\\project\\supermarketproject\\OIP.jpeg ");
        stage.getIcons().add(image);
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void signUp(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("sign-up.fxml"));
        root = fxmlLoader.load();
        stage = (Stage) signUpBtn.getScene().getWindow();
        Image image = new Image("D:\\java\\SuperMarketProject\\src\\main\\resources\\com\\supermarket\\project\\supermarketproject\\OIP.jpeg ");
        stage.getIcons().add(image);
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
    }
}