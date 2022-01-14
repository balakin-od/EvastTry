package com.example.realEstate;

import  java.sql.*;

public class Connections {

    Connection connection = null;
    public Connection Connect(){
        String url = "jdbc:sqlserver://192.168.147.53:1433;database=Science_1";
        String name = "4pk1";
        String password = "4pk1";
        String SQL = "SELECT * from Clients";
        int a = 0;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(url,name, password);
            System.out.println("Все ок!");
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
