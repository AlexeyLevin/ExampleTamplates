package com.alev.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        DBWorker worker = new DBWorker();

        //String query = "select * from users";
        String query = "select * from users where id=2";
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                User user = new User();
                // it works same in the next example
                //user.setId(resultSet.getInt(1));
                //user.setUsername(resultSet.getString(2).trim());
                //user.setPassword(resultSet.getString(3).trim());
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username").trim());
                user.setPassword(resultSet.getString("password").trim());

                System.out.println(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
