package se.iuh.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import se.iuh.demo.connection.DatabaseConnection;
import se.iuh.demo.entites.KhachHang;

public class KhachHang_DAO {
	 private static final String INSERT_KHACHHANG_SQL = "INSERT INTO KhachHang (MaKhachHang,HoTen, Email, SoDienThoai, DiaChi) VALUES (?, ?, ?, ?,?)";
	    private static final String SELECT_KHACHHANG_BY_ID = "SELECT MaKhachHang, HoTen, Email, SoDienThoai, DiaChi FROM KhachHang WHERE MaKhachHang = ?";
	    private static final String SELECT_ALL_KHACHHANGS = "SELECT * FROM KhachHang";
	    private static final String DELETE_KHACHHANG_SQL = "DELETE FROM KhachHang WHERE MaKhachHang = ?";
	    private static final String UPDATE_KHACHHANG_SQL = "UPDATE KhachHang SET HoTen = ?, Email = ?, SoDienThoai = ?, DiaChi = ? WHERE MaKhachHang = ?";
	    
	    public void insertKhachHang(KhachHang khachHang) throws SQLException {
	        try (Connection connection = DatabaseConnection.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_KHACHHANG_SQL)) {
	        	 preparedStatement.setInt(1, khachHang.getMaKhachHang());
	            preparedStatement.setString(2, khachHang.getHoTen());
	            preparedStatement.setString(3, khachHang.getEmail());
	            preparedStatement.setString(4, khachHang.getSoDienThoai());
	            preparedStatement.setString(5, khachHang.getDiaChi());
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	           e.printStackTrace();
	        }
	    }
	    
	    // Select customer by ID
	    public KhachHang selectKhachHang(int maKhachHang) {
	        KhachHang khachHang = null;
	        try (Connection connection = DatabaseConnection.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_KHACHHANG_BY_ID)) {
	            preparedStatement.setInt(1, maKhachHang);
	            ResultSet rs = preparedStatement.executeQuery();

	            while (rs.next()) {
	                String hoTen = rs.getString("HoTen");
	                String email = rs.getString("Email");
	                String soDienThoai = rs.getString("SoDienThoai");
	                String diaChi = rs.getString("DiaChi");
	                khachHang = new KhachHang( maKhachHang,hoTen, email, soDienThoai, diaChi);
	            }
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	        return khachHang;
	    }

	    // Select all customers
	    public List<KhachHang> selectAllKhachHangs() {
	        List<KhachHang> khachHangs = new ArrayList<>();
	        try (Connection connection = DatabaseConnection.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_KHACHHANGS)) {
	            ResultSet rs = preparedStatement.executeQuery();

	            while (rs.next()) {
	                int maKhachHang = rs.getInt("MaKhachHang");
	                String hoTen = rs.getString("HoTen");
	                String email = rs.getString("Email");
	                String soDienThoai = rs.getString("SoDienThoai");
	                String diaChi = rs.getString("DiaChi");
	                khachHangs.add(new KhachHang(maKhachHang, hoTen, email, soDienThoai, diaChi));
	            }
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	        return khachHangs;
	    }
	    // list ma khach hang
	    public List<KhachHang> selectAllMaKhachHang() {
	        List<KhachHang> khachHangs = new ArrayList<>();
	        try (Connection connection = DatabaseConnection.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_KHACHHANGS)) {
	            ResultSet rs = preparedStatement.executeQuery();
	            while (rs.next()) {
	            	 int maKhachHang = rs.getInt("MaKhachHang");
	            	 khachHangs.add(new KhachHang(maKhachHang));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return khachHangs;
	    }
	    // Delete customer
	    public boolean deleteKhachHang(int maKhachHang) throws SQLException {
	        boolean rowDeleted;
	        try (Connection connection = DatabaseConnection.getConnection();
	             PreparedStatement statement = connection.prepareStatement(DELETE_KHACHHANG_SQL)) {
	            statement.setInt(1, maKhachHang);
	            rowDeleted = statement.executeUpdate() > 0;
	        }
	        return rowDeleted;
	    }

	    // Update customer
	    public boolean updateKhachHang(KhachHang khachHang) throws SQLException {
	        boolean rowUpdated;
	        try (Connection connection = DatabaseConnection.getConnection();
	             PreparedStatement statement = connection.prepareStatement(UPDATE_KHACHHANG_SQL)) {
	            statement.setString(1, khachHang.getHoTen());
	            statement.setString(2, khachHang.getEmail());
	            statement.setString(3, khachHang.getSoDienThoai());
	            statement.setString(4, khachHang.getDiaChi());
	            statement.setInt(5, khachHang.getMaKhachHang());

	            rowUpdated = statement.executeUpdate() > 0;
	        }
	        return rowUpdated;
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
