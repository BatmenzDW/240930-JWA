package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {

    public static void main(String[] args) {
        createConnection();
    }
    static void createConnection(){
        /*
            If you remove the jdbc dependency in the pom this code will throw an SQLException
         */
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/database.sqlite");
            System.out.println(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
