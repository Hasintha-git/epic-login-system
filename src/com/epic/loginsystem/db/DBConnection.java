package com.epic.loginsystem.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public  Connection connection;
    public DBConnection() throws ClassNotFoundException, SQLException {

    }

    public  Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/epicLoginSystem","root","1234");
        System.out.println("db");
        return connection;
    }
    public  void connnectionClose() throws SQLException {
        System.out.println("connection closed");
        connection.close();
    }
}
