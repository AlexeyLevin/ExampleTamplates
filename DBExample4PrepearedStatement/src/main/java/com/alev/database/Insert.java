package com.alev.database;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Calendar;

public class Insert {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";

    //значения подставляются
    private static final String INSERT_NEW = "INSERT INTO dish VALUES(?,?,?,?,?,?,?)";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            preparedStatement = connection.prepareStatement(INSERT_NEW);

            preparedStatement.setInt(1,3);
            preparedStatement.setString(2, "Inserted title");
            preparedStatement.setString(3, "Inserted desc");
            preparedStatement.setFloat(4, 0.2f);
            preparedStatement.setBoolean(5, true); //TINYINT(1)
            preparedStatement.setDate(6, new Date(Calendar.getInstance().getTimeInMillis()));
            preparedStatement.setBlob(7, new FileInputStream("image.png")); //LONGBLOB

            preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println("No MySQL driver");
            e.printStackTrace();
        }  catch (FileNotFoundException e) {
            System.out.println("Resourses not found");
            e.printStackTrace();
        }  finally {
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
