package com.unc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db {
    Connection connection;

    public Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/hopital";
        String username = "root";
        String pwd = "";
        try {
            connection = DriverManager.getConnection(url, username, pwd);
            return connection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return  null;
    }
}
