package com.supermarket.project.supermarketproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

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
    protected void login(ActionEvent event) throws IOException {
        HSSFWorkbook dataStored;
        File f = new File("Client.xls");
        dataStored = new HSSFWorkbook(new FileInputStream("Client.xls"));
        HSSFSheet sheet = dataStored.getSheet("Clients");
        int i = 0;
        boolean found =false;
        Row r = sheet.getRow(i);
        while(sheet.getRow(r.getRowNum()+1) != null)
        {
            if (r.getCell(0).getStringCellValue().contains(usernameField.getText().trim()))
            {
                found = true;
                break;
            }
            else {
                i++;
                r = sheet.getRow(i);
            }
        }
        if (r.getCell(0).getStringCellValue().contains(usernameField.getText().trim()))
        {
            found = true;
        }
        if (!found || !r.getCell(7).getStringCellValue().contains(PassHash.hash(passwordField.getText().trim())))
        {
            errorLabel.setText("Invalid Username or Password");
        }
        else {
            FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("HomePage.fxml"));
            root = fxmlLoader.load();
            stage = (Stage) loginBtn.getScene().getWindow();
            stage.getIcons().add(new Image(getClass().getResourceAsStream("OIP.jpeg")));
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.show();
        }
    }
    public void signUp(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("sign-up.fxml"));
        root = fxmlLoader.load();
        stage = (Stage) signUpBtn.getScene().getWindow();
        stage.getIcons().add(new Image(getClass().getResourceAsStream("OIP.jpeg")));
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
    }
}