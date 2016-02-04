package com.alev.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBWorker {
    private final String URL = "jdbc:postgresql://localhost:5432/dbtest";
    private final String USER_NAME = "postgres";
    private  final String PASSWORD = "root";
    private Connection connection;

    public DBWorker() {
        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
