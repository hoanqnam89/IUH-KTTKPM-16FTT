package se.iuh.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import se.iuh.demo.connection.DatabaseConnection;
import se.iuh.demo.entites.KhachHang;
import se.iuh.demo.entites.ThietBi;

public class ThietBi_DAO {
	private static final String INSERT_THIETBI_SQL = "INSERT INTO ThietBi (MaThietBi, LoaiThietBi, HangSanXuat, MauThietBi, SoSeri, MaKhachHang) VALUES (?, ?, ?, ?, ?,?)";
    private static final String SELECT_THIETBI_BY_ID = "SELECT MaThietBi, LoaiThietBi, HangSanXuat, MauThietBi, SoSeri FROM ThietBi WHERE MaThietBi = ?";
    private static final String SELECT_ALL_THIETBI = "SELECT * FROM ThietBi";
    private static final String DELETE_THIETBI_SQL = "DELETE FROM ThietBi WHERE MaThietBi = ?";
    private static final String UPDATE_THIETBI_SQL = "UPDATE ThietBi SET MaKhachHang = ?, LoaiThietBi = ?, HangSanXuat = ?, MauThietBi = ?, SoSeri = ? WHERE MaThietBi = ?";
    
 // Insert device
    public void insertThietBi(ThietBi thietBi) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_THIETBI_SQL)) {
            preparedStatement.setInt(1, thietBi.getMaThietBi());
            preparedStatement.setString(2, thietBi.getLoaiThietBi());
            preparedStatement.setString(3, thietBi.getHangSanXuat());
            preparedStatement.setString(4, thietBi.getMauThietBi());
            preparedStatement.setString(5, thietBi.getSoSeri());
            preparedStatement.setInt(6, thietBi.getKhachHang().getMaKhachHang());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    // Select device by ID
    public ThietBi selectThietBi(int maThietBi) {
        ThietBi thietBi = null;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_THIETBI_BY_ID)) {
            preparedStatement.setInt(1, maThietBi);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
//                int maKhachHang = rs.getInt("MaKhachHang");
            	
                String loaiThietBi = rs.getString("LoaiThietBi");
                String hangSanXuat = rs.getString("HangSanXuat");
                String mauThietBi = rs.getString("MauThietBi");
                String soSeri = rs.getString("SoSeri");
                thietBi = new ThietBi(maThietBi, loaiThietBi, hangSanXuat, mauThietBi, soSeri);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return thietBi;
    }

    // Select all devices
    public List<ThietBi> selectAllThietBi() {
        List<ThietBi> thietBiList = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_THIETBI)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int maThietBi = rs.getInt("MaThietBi");
                String loaiThietBi = rs.getString("LoaiThietBi");
                String hangSanXuat = rs.getString("HangSanXuat");
                String mauThietBi = rs.getString("MauThietBi");
                String soSeri = rs.getString("SoSeri");
                int maKhachHang = rs.getInt("MaKhachHang");
                KhachHang khachHang = new KhachHang(maKhachHang);
                
                thietBiList.add(new ThietBi(maThietBi, loaiThietBi, hangSanXuat, mauThietBi, soSeri,khachHang));
                
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return thietBiList;
    }

    // Delete device
    public boolean deleteThietBi(int maThietBi) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_THIETBI_SQL)) {
            statement.setInt(1, maThietBi);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    // Update device
    public boolean updateThietBi(ThietBi thietBi) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_THIETBI_SQL)) {
//            statement.setInt(1, thietBi.getMaKhachHang());
            statement.setString(2, thietBi.getLoaiThietBi());
            statement.setString(3, thietBi.getHangSanXuat());
            statement.setString(4, thietBi.getMauThietBi());
            statement.setString(5, thietBi.getSoSeri());
            statement.setInt(6, thietBi.getMaThietBi());

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
