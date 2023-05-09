module com.supermarket.project.supermarketproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires poi;
    requires core;
    requires javase;


    opens com.supermarket.project.supermarketproject to javafx.fxml;
    exports com.supermarket.project.supermarketproject;
}