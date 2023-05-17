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

public class HomePageController {
    private Parent root;
    private Stage stage;

    @FXML
    private Label counter1,counter2,counter3,counter4,counter5,counter6;
//    @FXML
//    private Button plus1,plus2,plus3,plus4,plus5,plus6;
//    @FXML
//    private Button minus1,minus2,minus3,minus4,minus5,minus6;
    @FXML
    private Button homeBtn,cartBtn,profileBtn;

    public void initialize() {
        homeBtn.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("icons8-home-24.png"))));
        cartBtn.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("icons8-cart-30.png"))));
        profileBtn.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("icons8-person-30.png"))));
    }
    @FXML
    public void incrementCounter1(ActionEvent event) {
        int currentValue = Integer.parseInt(counter1.getText());
        counter1.setText(String.valueOf(currentValue + 1));
    }
    @FXML
    public void incrementCounter2(ActionEvent event) {
        int currentValue = Integer.parseInt(counter2.getText());
        counter2.setText(String.valueOf(currentValue + 1));
    }
    @FXML
    public void incrementCounter3(ActionEvent event) {
        int currentValue = Integer.parseInt(counter3.getText());
        counter3.setText(String.valueOf(currentValue + 1));
    }
    @FXML
    public void incrementCounter4(ActionEvent event) {
        int currentValue = Integer.parseInt(counter4.getText());
        counter4.setText(String.valueOf(currentValue + 1));
    }
    @FXML
    public void incrementCounter5(ActionEvent event) {
        int currentValue = Integer.parseInt(counter5.getText());
        counter5.setText(String.valueOf(currentValue + 1));
    }
    @FXML
    public void incrementCounter6(ActionEvent event) {
        int currentValue = Integer.parseInt(counter6.getText());
        counter6.setText(String.valueOf(currentValue + 1));
    }
    @FXML
    public void decrementCounter1(ActionEvent event) {
        int currentValue = Integer.parseInt(counter1.getText());
        counter1.setText(String.valueOf(currentValue - 1));
    }
    @FXML
    public void decrementCounter2(ActionEvent event) {
        int currentValue = Integer.parseInt(counter2.getText());
        counter2.setText(String.valueOf(currentValue - 1));
    }
    @FXML
    public void decrementCounter3(ActionEvent event) {
        int currentValue = Integer.parseInt(counter3.getText());
        counter3.setText(String.valueOf(currentValue - 1));
    }
    @FXML
    public void decrementCounter4(ActionEvent event) {
        int currentValue = Integer.parseInt(counter4.getText());
        counter4.setText(String.valueOf(currentValue - 1));
    }
    @FXML
    public void decrementCounter5(ActionEvent event) {
        int currentValue = Integer.parseInt(counter5.getText());
        counter5.setText(String.valueOf(currentValue - 1));
    }
    @FXML
    public void decrementCounter6(ActionEvent event) {
        int currentValue = Integer.parseInt(counter6.getText());
        counter6.setText(String.valueOf(currentValue - 1));
    }
    public void toCartPage(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("cart-page.fxml"));
        root = fxmlLoader.load();
        stage = (Stage) cartBtn.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
    public void toProfilePage(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("profile-page.fxml"));
        root = fxmlLoader.load();
        stage = (Stage) cartBtn.getScene().getWindow();
//        stage.getIcons().add(new Image(getClass().getResourceAsStream("icons8-male-user-48.png")));
        stage.setScene(new Scene(root));
    }

}