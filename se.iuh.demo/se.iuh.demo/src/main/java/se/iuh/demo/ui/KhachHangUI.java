package se.iuh.demo.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import se.iuh.demo.dao.KhachHang_DAO;
import se.iuh.demo.entites.KhachHang;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class KhachHangUI extends JFrame {
    private KhachHang_DAO khachHangDAO;
    private DefaultTableModel tableModel;
    private JTable table;
    private JTextField txtMaKhachHang, txtHoTen, txtEmail, txtSoDienThoai, txtDiaChi;

    public KhachHangUI() {
        khachHangDAO = new KhachHang_DAO();
        initUI();
        loadData();
    }

    private void initUI() {
        setTitle("Quản lý Khách Hàng");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        tableModel = new DefaultTableModel(new String[]{"Mã KH", "Họ và Tên", "Email", "SĐT", "Địa chỉ"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new GridLayout(5, 2));

        inputPanel.add(new JLabel("Mã Khách Hàng:"));
        txtMaKhachHang = new JTextField();
        inputPanel.add(txtMaKhachHang);

        inputPanel.add(new JLabel("Họ và Tên:"));
        txtHoTen = new JTextField();
        inputPanel.add(txtHoTen);

        inputPanel.add(new JLabel("Email:"));
        txtEmail = new JTextField();
        inputPanel.add(txtEmail);

        inputPanel.add(new JLabel("Số Điện Thoại:"));
        txtSoDienThoai = new JTextField();
        inputPanel.add(txtSoDienThoai);

        inputPanel.add(new JLabel("Địa Chỉ:"));
        txtDiaChi = new JTextField();
        inputPanel.add(txtDiaChi);

        panel.add(inputPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();

        JButton btnAdd = new JButton("Thêm");
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addKhachHang();
            }
        });
        buttonPanel.add(btnAdd);

        JButton btnUpdate = new JButton("Cập Nhật");
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateKhachHang();
            }
        });
        buttonPanel.add(btnUpdate);

        JButton btnDelete = new JButton("Xóa");
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteKhachHang();
            }
        });
        buttonPanel.add(btnDelete);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
    }

    private void loadData() {
        tableModel.setRowCount(0);
        List<KhachHang> khachHangs = khachHangDAO.selectAllKhachHangs();
        for (KhachHang khachHang : khachHangs) {
            tableModel.addRow(new Object[]{khachHang.getMaKhachHang(), khachHang.getHoTen(), khachHang.getEmail(), khachHang.getSoDienThoai(), khachHang.getDiaChi()});
        }
    }

    private void addKhachHang() {
        int maKhachHang = Integer.parseInt(txtMaKhachHang.getText());
        String hoTen = txtHoTen.getText();
        String email = txtEmail.getText();
        String soDienThoai = txtSoDienThoai.getText();
        String diaChi = txtDiaChi.getText();

        KhachHang khachHang = new KhachHang(maKhachHang, hoTen, email, soDienThoai, diaChi);

        try {
            khachHangDAO.insertKhachHang(khachHang);
            JOptionPane.showMessageDialog(this, "Thêm khách hàng thành công!");
//            clearFields();
            loadData();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi khi thêm khách hàng: " + ex.getMessage());
        }
    }

    private void updateKhachHang() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            int maKhachHang = (int) tableModel.getValueAt(selectedRow, 0);
            String hoTen = txtHoTen.getText();
            String email = txtEmail.getText();
            String soDienThoai = txtSoDienThoai.getText();
            String diaChi = txtDiaChi.getText();

            KhachHang khachHang = new KhachHang(maKhachHang, hoTen, email, soDienThoai, diaChi);

            try {
                khachHangDAO.updateKhachHang(khachHang);
                JOptionPane.showMessageDialog(this, "Cập nhật khách hàng thành công!");
                clearFields();
                loadData();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Lỗi khi cập nhật khách hàng: " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một khách hàng để cập nhật");
        }
        }
    private void deleteKhachHang() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            int maKhachHang = (int) tableModel.getValueAt(selectedRow, 0);

            int option = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa khách hàng này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                try {
                    khachHangDAO.deleteKhachHang(maKhachHang);
                    JOptionPane.showMessageDialog(this, "Xóa khách hàng thành công!");
                    loadData();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Lỗi khi xóa khách hàng: " + ex.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một khách hàng để xóa");
        }
    }

    private void clearFields() {
        txtMaKhachHang.setText("");
        txtHoTen.setText("");
        txtEmail.setText("");
        txtSoDienThoai.setText("");
        txtDiaChi.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new KhachHangUI().setVisible(true);
            }
        });
    }
}
