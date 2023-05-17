package com.supermarket.project.supermarketproject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HomePageController {
    @FXML
    private Button homeBtn,cartBtn,profileBtn;

    public void initialize() {
        homeBtn.setGraphic(new ImageView(new Image("D:\\java\\SuperMarketProject\\src\\main\\resources\\com\\supermarket\\project\\supermarketproject\\icons8-home-24.png")));
        cartBtn.setGraphic(new ImageView(new Image("D:\\java\\SuperMarketProject\\src\\main\\resources\\com\\supermarket\\project\\supermarketproject\\icons8-cart-30.png")));
        profileBtn.setGraphic(new ImageView(new Image("D:\\java\\SuperMarketProject\\src\\main\\resources\\com\\supermarket\\project\\supermarketproject\\icons8-person-30.png")));
    }
}