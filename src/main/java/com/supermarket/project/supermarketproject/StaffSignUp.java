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

public class StaffSignUp {
    private Parent root;
    private Stage stage;
    @FXML
    TextField username,id,salary,phoneNumber,address,name;
    @FXML
    Button idGenerator,signUpBtn2;
    @FXML
    PasswordField password;

    public void IdGenerator(ActionEvent event) {
        long num = System.nanoTime();
        String ID = String.valueOf(num%10000);
        id.setText(ID);
    }

    @FXML
    protected void signUp() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
        root = fxmlLoader.load();
        Staff s = new Staff(id.getText(),name.getText(),Double.parseDouble(salary.getText()),phoneNumber.getText(),address.getText(),username.getText(),PassHash.hash(password.getText()));
        ApplicationMain.staff.add(s);
        ApplicationMain.serial(ApplicationMain.staff,"Staff.ser");
        stage = (Stage) signUpBtn2.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
}
