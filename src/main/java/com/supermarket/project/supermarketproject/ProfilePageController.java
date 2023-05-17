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
    Label nameLabel,idLabel,ageLabel,phoneNumberLabel,homeNumberLabel,streetLabel,townLabel;
    @FXML
    Button homeBtn,cartBtn,profileBtn,signOutBtn,CheckForGolden;
    static RegularClient regularClient;
    public void initialize() {
        homeBtn.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("icons8-home-24.png"))));
        cartBtn.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("icons8-cart-30.png"))));
        profileBtn.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("icons8-person-30.png"))));
        regularClient = getCurrentClientSession();
        nameLabel.setText(regularClient.getName());
        idLabel.setText(regularClient.getId());
        ageLabel.setText(String.valueOf(regularClient.getAge()));
        phoneNumberLabel.setText(regularClient.getPhoneNum());
        homeNumberLabel.setText(regularClient.getAddress()[2]);
        streetLabel.setText(regularClient.getAddress()[0]);
        townLabel.setText(regularClient.getAddress()[1]);
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
        stage = (Stage) cartBtn.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("cart-page.fxml"));
        root = fxmlLoader.load();
        stage.setScene(new Scene(root));
    }
    public void signOut(ActionEvent event) throws IOException {
        stage = (Stage) signOutBtn.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
        root = fxmlLoader.load();
        stage.setScene(new Scene(root));
    }
    public void canBeGolden() throws IOException {
        if(!regularClient.isGoldenClients())
        {
            Stage s = new Stage();
            FXMLLoader load = new FXMLLoader(getClass().getResource("GoldenPrompt.fxml"));
            Scene sc = new Scene(load.load());
            s.setScene(sc);
            s.setTitle("Golden Prompt");
            s.show();
        }
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
