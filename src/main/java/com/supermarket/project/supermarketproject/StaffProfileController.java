package com.supermarket.project.supermarketproject;

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

public class StaffProfileController {

    @FXML
    Button StaffHome,StaffProfile;
    @FXML
    Label Name,ID,Phone,Address,Salary;

    public void initialize()
    {
        StaffHome.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("icons8-home-24.png"))));
        StaffProfile.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("icons8-person-30.png"))));
        Staff s = getSession();
        Name.setText(s.getName());
        ID.setText(s.getId());
        Phone.setText(s.getPhoneNum());
        Address.setText(s.getAddress());
        Salary.setText(String.valueOf(s.getSalary()));
    }

    @FXML
    protected void onHome() throws IOException {
        Parent root;
        FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("StaffHome.fxml"));
        root = fxmlLoader.load();
        Stage stage = (Stage) StaffProfile.getScene().getWindow();
        stage.getIcons().add(new Image(getClass().getResourceAsStream("OIP.jpeg")));
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
    }

    Staff getSession()
    {
     for(Staff s:ApplicationMain.staff)
     {
        if (ApplicationMain.currentSession[1].contains(s.getPrivatecard().getUsername()))
        {
            return s;
        }
     }
     return null;
    }
}
