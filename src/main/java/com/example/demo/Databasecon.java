package com.example.demo;
import java.sql.*;
class DatabaseCon {
    private static String jdbcURL = "jdbc:h2:tcp://localhost/~/orderM";
    private static String jdbcUsername = "awais";
    private static String jdbcPassword = "";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

}
