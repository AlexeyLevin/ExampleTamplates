package com.alev.database;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class DBStaticRequests {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            System.out.println("No MySQL driver");
        }

        try(Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            Statement statement = connection.createStatement()) {
            if(!connection.isClosed()) {
                System.out.println("Connection to " + URL + " was successful.");
            }
            //DEFAULT CRUD
            //statement.execute("INSERT INTO animal(anim_name,anim_desc) VALUES('CoolName', 'someRow');");

            //int countUpdateRows = statement.executeUpdate("UPDATE animal SET anim_name='NewCoolName' WHERE `id`='8';");
            //System.out.println(countUpdateRows);

            // ResultSet resultSet = statement.executeQuery("SELECT * FROM animal");

            // Batching
            statement.addBatch("INSERT INTO animal(anim_name,anim_desc) VALUES('batch1', 'someRow');");
            statement.addBatch("INSERT INTO animal(anim_name,anim_desc) VALUES('batch2', 'someRow');");
            statement.addBatch("INSERT INTO animal(anim_name,anim_desc) VALUES('batch3', 'someRow');");
            statement.executeBatch();

            statement.clearBatch();

            boolean status = statement.isClosed();
            System.out.println(status);


            statement.getConnection();
            statement.close();


        } catch (SQLException e) {
            System.out.println("Connection to " + URL + " is corrupt.");
            e.printStackTrace();
        }
    }
}
