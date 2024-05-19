package se.iuh.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import se.iuh.demo.connection.DatabaseConnection;

public class LoginDao {
	
	 private static final String LOGIN_QUERY = "SELECT * FROM users WHERE username = ? AND password = ?";
	 public boolean validate(String username, String password) {
	        boolean status = false;

	        try (Connection connection = DatabaseConnection.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_QUERY)) {

	            preparedStatement.setString(1, username);
	            preparedStatement.setString(2, password);

	            System.out.println(preparedStatement);

	            ResultSet rs = preparedStatement.executeQuery();

	            status = rs.next();

	        } catch (SQLException e) {
	            // Xử lý ngoại lệ
	            printSQLException(e);
	        }
	        return status;
	    }
	 public String validateUser(String username, String password) {
	        String user = null;

	        try (Connection connection = DatabaseConnection.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_QUERY)) {

	            preparedStatement.setString(1, username);
	            preparedStatement.setString(2, password);

	            System.out.println(preparedStatement);

	            ResultSet rs = preparedStatement.executeQuery();

	            if (rs.next()) {
	                user = rs.getString("username");
	            }

	        } catch (SQLException e) {
	            // Xử lý ngoại lệ
	            printSQLException(e);
	        }
	        return user;
	    }


	    private void printSQLException(SQLException ex) {
	        for (Throwable e : ex) {
	            if (e instanceof SQLException) {
	                e.printStackTrace(System.err);
	                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
	                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
	                System.err.println("Message: " + e.getMessage());
	                Throwable t = ex.getCause();
	                while (t != null) {
	                    System.out.println("Cause: " + t);
	                    t = t.getCause();
	                }
	            }
	        }
	    }

	
	
	
}
