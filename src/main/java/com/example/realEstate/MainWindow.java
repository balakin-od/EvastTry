package com.example.realEstate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainWindow {

    @FXML
    private void bHome(ActionEvent actionEvent) {
        Res("homeWin.fxml", actionEvent);
    }

    @FXML
    private void bHouse(ActionEvent actionEvent) {
        Res("houseWin.fxml", actionEvent);
    }

    @FXML
    private void bArea(ActionEvent actionEvent) {
        Res("areaWin.fxml", actionEvent);
    }

    public void Res(String str, ActionEvent actionEvent)
    {
        FXMLLoader fxmlLoader = new FXMLLoader(MainClass.class.getResource(str));
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
