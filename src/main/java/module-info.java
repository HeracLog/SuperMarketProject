module com.supermarket.project.supermarketproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires poi;
    requires zxing;


    opens com.supermarket.project.supermarketproject to javafx.fxml;
    exports com.supermarket.project.supermarketproject;
}