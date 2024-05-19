package se.iuh.demo.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=quanly_thietbitaiche;trustServerCertificate=true";
    private static final String USER = "sa";
    private static final String PASSWORD = "123";

    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection established successfully!");
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        // Test the connection
        Connection conn = DatabaseConnection.getConnection();
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
