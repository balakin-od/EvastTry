package com.example.realEstate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClientWin {

    @FXML
    TableView tableClients;
    @FXML
    TableColumn<Client, Integer> be;

    ObservableList<Client> clients = FXCollections.observableArrayList();
    Connections con = new Connections();
    Connection connection;

    @FXML
    private void initialize() throws SQLException {
        be.setCellValueFactory(new PropertyValueFactory<Client, Integer>("id"));
        connection = con.Connect();
        Statement statement =  connection.createStatement();
        String sql = "Select * From Grants";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()){
            clients.add(new Client(rs.getInt(1), rs.getInt(2),rs.getString(3), rs.getInt(4)));
        }
        tableClients.setItems(clients);

    }

    @FXML
    private void AddClient(ActionEvent actionEvent) throws SQLException {
        connection = con.Connect();
        Statement statement =  connection.createStatement();
        String sql = "Select * From Grants";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()){
            clients.add(new Client(rs.getInt(1), rs.getInt(2),rs.getString(3), rs.getInt(4)));
        }

    }

    @FXML
    private void EditClient(ActionEvent actionEvent) {

    }

    @FXML
    private void DeleteClient(ActionEvent actionEvent) {

    }

    @FXML
    private void AddRil(ActionEvent actionEvent) {

    }

    @FXML
    private void EditRil(ActionEvent actionEvent) {

    }

    @FXML
    private void DeleteRil(ActionEvent actionEvent) {

    }




}
