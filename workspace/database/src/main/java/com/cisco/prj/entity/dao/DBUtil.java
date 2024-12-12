package com.cisco.prj.entity.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtil {

    private static String DRIVER = "";
    private static String URL = "";
    private static String USER = "";
    private static String PASSWORD = "";

    static  {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("database");
        DRIVER = resourceBundle.getString("DRIVER");
        URL = resourceBundle.getString("URL");
        USER = resourceBundle.getString("USER");
        PASSWORD = resourceBundle.getString("PASSWORD");
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void closeConnection(Connection con) {
        if(con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}