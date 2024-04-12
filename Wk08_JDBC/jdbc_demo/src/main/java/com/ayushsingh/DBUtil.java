package com.ayushsingh;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class provides utility method for database connectivity.
 * It contains a static method {@link #getConnection()} to establish a connection to the MySQL database.
 *
 * @author Ayush Singh
 * @version 1.0
 * @since 12-05-2024
 */
public class DBUtil {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/ecom";
    private static final String USERNAME = "hbstudent";
    private static final String PASSWORD = "hbstudent";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }
}