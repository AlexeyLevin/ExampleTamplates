package com.alev.database;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBTestConnetion {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "vfxj06";

    public static void main(String[] args) {
        Connection connection;

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            if(!connection.isClosed()) {
                System.out.println("Connection to " + URL + " was successful.");
            }
            connection.close();
            if(connection.isClosed()) {
                System.out.println("Connection to " + URL + " was closed.");
            }

        } catch (SQLException e) {
            System.out.println("No MySQL driver");
        }
    }
}
