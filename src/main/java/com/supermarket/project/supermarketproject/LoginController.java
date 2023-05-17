package com.supermarket.project.supermarketproject;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginController {
    private Stage stage;
    private Parent root;
    @FXML
    Button loginBtn;
    @FXML
    Button signUpBtn;
    @FXML
    TextField usernameField;
    @FXML
    PasswordField passwordField;
    @FXML
    Label errorLabel;
    @FXML
    ComboBox<String> Choice;

    @FXML
    protected void addChoiceItems()
    {
        Choice.getItems().add("Staff");
        Choice.getItems().add("Client");
    }

    @FXML
    protected void login(ActionEvent event) throws IOException {
        if (Choice.getValue().contains("Client")) {
            HSSFWorkbook dataStored;
            File f = new File("Client.xls");
            dataStored = new HSSFWorkbook(new FileInputStream("Client.xls"));
            HSSFSheet sheet = dataStored.getSheet("Clients");
            int i = 0;
            boolean found = false;
            Row r = sheet.getRow(i);
            while (sheet.getRow(r.getRowNum() + 1) != null) {
                if (r.getCell(0).getStringCellValue().contains(usernameField.getText().trim())) {
                    found = true;
                    break;
                } else {
                    i++;
                    r = sheet.getRow(i);
                }
            }
            if (r.getCell(0).getStringCellValue().contains(usernameField.getText().trim())) {
                found = true;
            }
            if (!found || !r.getCell(7).getStringCellValue().contains(PassHash.hash(passwordField.getText().trim()))) {
                errorLabel.setText("Invalid Username or Password");
            } else {
                ApplicationMain.currentSession = new String[]{"Client", usernameField.getText()};
                FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("home-page.fxml"));
                root = fxmlLoader.load();
                stage = (Stage) loginBtn.getScene().getWindow();
                stage.getIcons().add(new Image(getClass().getResourceAsStream("OIP.jpeg")));
                stage.setResizable(false);
                stage.setScene(new Scene(root));
                stage.show();
            }
        }
        else {
            HSSFWorkbook dataStored;
            File f = new File("Staff.xls");
            dataStored = new HSSFWorkbook(new FileInputStream("Staff.xls"));
            HSSFSheet sheet = dataStored.getSheet("Staff");
            int i = 0;
            boolean found = false;
            Row r = sheet.getRow(i);
            while (sheet.getRow(r.getRowNum() + 1) != null) {
                if (r.getCell(1).getStringCellValue().contains(usernameField.getText().trim())) {
                    found = true;
                    break;
                } else {
                    i++;
                    r = sheet.getRow(i);
                }
            }
            if (r.getCell(1).getStringCellValue().contains(usernameField.getText().trim())) {
                found = true;
            }
            if (!found || !r.getCell(6).getStringCellValue().contains(PassHash.hash(passwordField.getText().trim()))) {
                errorLabel.setText("Invalid Username or Password");
            } else {
                ApplicationMain.currentSession = new String[]{"Staff", usernameField.getText()};
                FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("StaffHome.fxml"));
                root = fxmlLoader.load();
                stage = (Stage) loginBtn.getScene().getWindow();
                stage.getIcons().add(new Image(getClass().getResourceAsStream("OIP.jpeg")));
                stage.setResizable(false);
                stage.setScene(new Scene(root));
                stage.show();
            }
        }
    }
    public void signUp(ActionEvent event) throws IOException {
        if (Choice.getValue().contains("Client")) {
            FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("sign-up.fxml"));
            root = fxmlLoader.load();
            stage = (Stage) signUpBtn.getScene().getWindow();
            stage.getIcons().add(new Image(getClass().getResourceAsStream("OIP.jpeg")));
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.show();
        }
        else{
            FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("staff-signup.fxml"));
            root = fxmlLoader.load();
            stage = (Stage) signUpBtn.getScene().getWindow();
            stage.getIcons().add(new Image(getClass().getResourceAsStream("OIP.jpeg")));
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.show();
        }
    }
}