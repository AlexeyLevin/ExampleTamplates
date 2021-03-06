package com.alev.database;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class Delete {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";
    private static final String GET_ALL = "SELECT * FROM dish";
    private static final String DELETE = "DELETE FROM dish WHERE id=?";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            preparedStatement = connection.prepareStatement(DELETE);

            preparedStatement.setInt(1,2);
            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement(GET_ALL);

            ResultSet executeQuery = preparedStatement.executeQuery();

            while (executeQuery.next()) {
                int id = executeQuery.getInt("id");
                String title = executeQuery.getString("title");
                String desc = executeQuery.getString("description");
                float rating = executeQuery.getFloat("rating");
                boolean published = executeQuery.getBoolean("published");
                Date date = executeQuery.getDate("created");
                byte[] icon = executeQuery.getBytes("icon");

                System.out.println(
                                "id = " + id +
                                ", title = " + title +
                                ", desc = " + desc +
                                ", rating = " + rating +
                                ", published = " + published +
                                ", date = " + date +
                                ", icon.length = " + icon.length);
                System.out.println();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null ) {
                    preparedStatement.close();
                    System.out.println("preparedStatement is closed()");
                }
                if (connection != null) {
                    connection.close();
                    System.out.println("connection is closed");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
