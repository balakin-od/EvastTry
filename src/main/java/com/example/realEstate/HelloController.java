package com.example.realEstate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {


    @FXML
    private void bLog(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(MainClass.class.getResource("clientWin.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Button b = (Button) actionEvent.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}