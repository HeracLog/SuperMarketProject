package com.supermarket.project.supermarketproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class CartPageController {
    private Parent root;
    private Stage stage;
    @FXML
    Button homeBtn,cartBtn,profileBtn,buyButton;
    @FXML
    ComboBox<Staff> staffList;
    @FXML
    TextArea productField;
    @FXML
    Label buyLabel;
    public void initialize() {
        homeBtn.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("icons8-home-24.png"))));
        cartBtn.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("icons8-cart-30.png"))));
        profileBtn.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("icons8-person-30.png"))));
        for (Staff s:ApplicationMain.staff)
        {
            staffList.getItems().add(s);
        }
        for (Product p: HomePageController.cart)
        {
            productField.appendText(p.getName() + " " + p.getBuyPrice() +" " + p.getQuantity() + " " + p.getBuyPrice()*p.getQuantity() + "\n");
        }
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

    @FXML
    protected void onBuy()
    {
        getCurrentClientSession().buy(HomePageController.cart,staffList.getValue());
        productField.setText("");
        buyLabel.setText("Purchase complete!");
    }
    public RegularClient getCurrentClientSession()
    {
        for (RegularClient rc: ApplicationMain.regularClients)
        {
            if (ApplicationMain.currentSession[1].contains(rc.getName()))
            {
                return rc;
            }
        }
        return null;
    }
}
