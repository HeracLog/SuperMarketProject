package com.supermarket.project.supermarketproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class signUpController {
    private Parent root;
    private Stage stage;
    @FXML
    TextField username,id,age,phoneNumber,street,town,homeNumber;
    @FXML
    PasswordField password;
    @FXML
    Button idGenerator, signUpBtn2;

    public void IdGenerator(ActionEvent event) {
        long num = System.nanoTime();
        String ID = String.valueOf(num%10000);
        id.setText(ID);
    }
    public void signUp(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
        RegularClient regularClient = new RegularClient(id.getText(),username.getText(),Integer.parseInt(age.getText()),phoneNumber.getText(),street.getText(),town.getText(),homeNumber.getText(),PassHash.hash(password.getText()));
        ApplicationMain.regularClients.add(regularClient);
        ApplicationMain.serial(ApplicationMain.regularClients,"Clients.ser");
        root = fxmlLoader.load();
        stage = (Stage) signUpBtn2.getScene().getWindow();
        stage.setScene(new Scene(root));
    }


}
