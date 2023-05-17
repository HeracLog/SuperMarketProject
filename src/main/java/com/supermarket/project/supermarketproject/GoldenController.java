package com.supermarket.project.supermarketproject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.text.ParseException;

public class GoldenController {
    @FXML
    TextField Birthday;
    @FXML
    ComboBox<Product> Products;
    @FXML
    Button saveButton;

    public void initialize()
    {
        for(Product p:ApplicationMain.products)
        {
            Products.getItems().add(p);
        }
    }

    @FXML
    protected void onSave() throws ParseException {
        ProfilePageController.regularClient.setGolden(Birthday.getText(),Products.getValue());
        saveButton.getScene().getWindow().hide();
    }

}
