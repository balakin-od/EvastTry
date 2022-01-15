package com.example.realEstate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import java.util.Random;

public class HelloController {


    @FXML
    PasswordField Bob;
    @FXML
    TextField Bab, Bub, Byb, Bib;
    @FXML
    Pane Captcha;
    String ss = "";

    @FXML
    private void bLog(ActionEvent actionEvent) {
        try {
            ss = getPass(Bib.getText());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (Bob.getText().equals(ss) ) {
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
        else {
            Captcha.setVisible(true);
            Bub.setText(getCaptcha().toUpperCase(Locale.ROOT));
        }
    }

    @FXML
    private void bBob(ActionEvent actionEvent) {
        CheckBox ch = (CheckBox) actionEvent.getSource();
        if(ch.isSelected()) {
            Bab.setText(Bob.getText());
            Bob.setVisible(false);
        }
        else{
            Bob.setText(Bab.getText());
            Bob.setVisible(true);
        }
    }

    private String getPass(String login) throws SQLException {
        String pass = "";
        Connections con = new Connections();
        Connection connect = con.Connect();
        Statement statement =  connect.createStatement();
        String sql = "Select * from {Table} where Login =" + login;
        ResultSet rs = statement.executeQuery(sql);
        pass = rs.getString("Password");
        return pass;
    }

    private String getCaptcha(){
        String Captcha = "";
        Random r = new Random();
        char [] sim = {'q','w','e','r','t','y','u','i','o','p','a','s','d','f','g','h','j','k','l','z','x','c','v','b','n','m','1','0','2','3','4','5','6','7','8','9'};
        for(int i = 0; i < 6; i++)
        {
            Captcha = Captcha + sim[r.nextInt(sim.length)];
        }

        return Captcha;
    }

    @FXML
    private void bBub(ActionEvent actionEvent) {
        Bub.setText(getCaptcha().toUpperCase(Locale.ROOT));
    }
}