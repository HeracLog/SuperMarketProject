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
import java.util.ArrayList;

public class HomePageController {
    private Parent root;
    private Stage stage;

    @FXML
    private Label counter1,counter2,counter3,counter4,counter5,counter6;
    @FXML
    private Label price1,price2,price3,price4,price5,price6;
    @FXML
    private Button homeBtn,cartBtn,profileBtn;
    static ArrayList<Product> cart;

    public void initialize() {
        homeBtn.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("icons8-home-24.png"))));
        cartBtn.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("icons8-cart-30.png"))));
        profileBtn.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("icons8-person-30.png"))));
        cart = new ArrayList<>();
    }
    @FXML
    public void incrementCounter1(ActionEvent event) {
        int currentValue = Integer.parseInt(counter1.getText());
        int currentPrice = Integer.parseInt(price1.getText());
        counter1.setText(String.valueOf(currentValue + 1));
        if (Integer.parseInt(counter1.getText()) != 1) {
            price1.setText(String.valueOf(currentPrice + 10));
        }
    }
    @FXML
    public void incrementCounter2(ActionEvent event) {
        int currentValue = Integer.parseInt(counter2.getText());
        int currentPrice = Integer.parseInt(price2.getText());
        counter2.setText(String.valueOf(currentValue + 1));
        if (Integer.parseInt(counter2.getText()) != 1) {
            price2.setText(String.valueOf(currentPrice + 194));
        }
    }
    @FXML
    public void incrementCounter3(ActionEvent event) {
        int currentValue = Integer.parseInt(counter3.getText());
        int currentPrice = Integer.parseInt(price3.getText());
        counter3.setText(String.valueOf(currentValue + 1));
        if (Integer.parseInt(counter3.getText()) != 1) {
            price3.setText(String.valueOf(currentPrice + 60));
        }
    }
    @FXML
    public void incrementCounter4(ActionEvent event) {
        int currentValue = Integer.parseInt(counter4.getText());
        int currentPrice = Integer.parseInt(price4.getText());
        counter4.setText(String.valueOf(currentValue + 1));
        if (Integer.parseInt(counter4.getText()) != 1) {
            price4.setText(String.valueOf(currentPrice + 4));
        }
    }
    @FXML
    public void incrementCounter5(ActionEvent event) {
        int currentValue = Integer.parseInt(counter5.getText());
        int currentPrice = Integer.parseInt(price5.getText());
        counter5.setText(String.valueOf(currentValue + 1));
        if (Integer.parseInt(counter5.getText()) != 1) {
            price5.setText(String.valueOf(currentPrice + 5));
        }
    }
    @FXML
    public void incrementCounter6(ActionEvent event) {
        int currentValue = Integer.parseInt(counter6.getText());
        int currentPrice = Integer.parseInt(price6.getText());
        counter6.setText(String.valueOf(currentValue + 1));
        if (Integer.parseInt(counter6.getText()) != 1) {
            price6.setText(String.valueOf(currentPrice + 11));
        }
    }
    @FXML
    public void decrementCounter1(ActionEvent event) {
        int currentValue = Integer.parseInt(counter1.getText());
        if (currentValue > 0) {
            counter1.setText(String.valueOf(currentValue - 1));
            int currentPrice = Integer.parseInt(price1.getText());
            if (currentValue > 1) {
                price1.setText(String.valueOf(currentPrice - 10));
            }
        }
    }
    @FXML
    public void decrementCounter2(ActionEvent event) {
        int currentValue = Integer.parseInt(counter2.getText());
        if (currentValue > 0) {
            counter2.setText(String.valueOf(currentValue - 1));
            int currentPrice = Integer.parseInt(price2.getText());
            if (currentValue > 1) {
                price2.setText(String.valueOf(currentPrice - 194));
            }
        }
    }
    @FXML
    public void decrementCounter3(ActionEvent event) {
        int currentValue = Integer.parseInt(counter3.getText());
        if (currentValue > 0) {
            counter3.setText(String.valueOf(currentValue - 1));
            int currentPrice = Integer.parseInt(price3.getText());
            if (currentValue > 1) {
                price3.setText(String.valueOf(currentPrice - 60));
            }
        }
    }
    @FXML
    public void decrementCounter4(ActionEvent event) {
        int currentValue = Integer.parseInt(counter4.getText());
        if (currentValue > 0) {
            counter4.setText(String.valueOf(currentValue - 1));
            int currentPrice = Integer.parseInt(price4.getText());
            if (currentValue > 1) {
                price4.setText(String.valueOf(currentPrice - 4));
            }
        }
    }
    @FXML
    public void decrementCounter5(ActionEvent event) {
        int currentValue = Integer.parseInt(counter5.getText());
        if (currentValue > 0) {
            counter5.setText(String.valueOf(currentValue - 1));
            int currentPrice = Integer.parseInt(price5.getText());
            if (currentValue > 1) {
                price5.setText(String.valueOf(currentPrice - 5));
            }
        }
    }
    @FXML
    public void decrementCounter6(ActionEvent event) {
        int currentValue = Integer.parseInt(counter6.getText());
        if (currentValue > 0) {
            counter6.setText(String.valueOf(currentValue - 1));
            int currentPrice = Integer.parseInt(price6.getText());
            if (currentValue > 1) {
                price6.setText(String.valueOf(currentPrice - 11));
            }
        }
    }
    public void toCartPage(ActionEvent event) throws IOException {
        setUpCart();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("cart-page.fxml"));
        root = fxmlLoader.load();
        stage = (Stage) cartBtn.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
    public void toProfilePage(ActionEvent event) throws IOException {
        stage = (Stage) cartBtn.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("profile-page.fxml"));
        root = fxmlLoader.load();
//        stage.getIcons().add(new Image(getClass().getResourceAsStream("icons8-male-user-48.png")));
        stage.setScene(new Scene(root));
    }

    void setUpCart()
    {
        if (Integer.parseInt(counter1.getText()) >= 1)
        {
            ApplicationMain.products.get(4).setQuantity(Integer.parseInt(counter1.getText()));
            cart.add(ApplicationMain.products.get(4));
        }
        if (Integer.parseInt(counter2.getText()) >= 1)
        {
            ApplicationMain.products.get(1).setQuantity(Integer.parseInt(counter2.getText()));
            cart.add(ApplicationMain.products.get(1));
        }
        if (Integer.parseInt(counter3.getText()) >= 1)
        {
            ApplicationMain.products.get(2).setQuantity(Integer.parseInt(counter3.getText()));
            cart.add(ApplicationMain.products.get(2));
        }
        if (Integer.parseInt(counter4.getText()) >= 1)
        {
            ApplicationMain.products.get(3).setQuantity(Integer.parseInt(counter4.getText()));
            cart.add(ApplicationMain.products.get(3));
        }
        if (Integer.parseInt(counter5.getText()) >= 1)
        {
            ApplicationMain.products.get(0).setQuantity(Integer.parseInt(counter5.getText()));
            cart.add(ApplicationMain.products.get(0));
        }
        if (Integer.parseInt(counter6.getText()) >= 1)
        {
            ApplicationMain.products.get(5).setQuantity(Integer.parseInt(counter6.getText()));
            cart.add(ApplicationMain.products.get(5));
        }
    }

}