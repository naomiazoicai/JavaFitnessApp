package dao;

import java.sql.*;

public class DatabaseConnection {
    private static Connection connection;

    private DatabaseConnection() {}
    public static void setConnection(String url, String user, String password) throws SQLException {
        // Set
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception exception) {
            throw new RuntimeException();
        }
        connection = DriverManager.getConnection(url, user, password);
    }

    public static Connection getConnection() {
        if (connection == null) throw new RuntimeException("No database connection provided.");
        return connection;
    }
}
