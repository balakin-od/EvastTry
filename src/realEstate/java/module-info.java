module com.example.demo1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.realEstate to javafx.fxml;
    exports com.example.realEstate;
}