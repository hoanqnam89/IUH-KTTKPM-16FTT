package se.iuh.demo.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import se.iuh.demo.dao.KhachHang_DAO;
import se.iuh.demo.dao.ThietBi_DAO;
import se.iuh.demo.entites.KhachHang;
import se.iuh.demo.entites.ThietBi;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class ThietBiFrame extends JFrame {
    private ThietBi_DAO thietBiDAO ;
    private KhachHang_DAO khachHang_DAO;
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField txtMaThietBi, txtLoaiThietBi, txtHangSanXuat, txtMauThietBi, txtSoSeri;
    private JButton btnAdd, btnUpdate, btnDelete;
	private JComboBox<Object> cboMaKhachHang;


    public ThietBiFrame() {
        thietBiDAO = new ThietBi_DAO();
        khachHang_DAO = new KhachHang_DAO();
        initUI();
        loadData();
        loadMaKhachHang();
     
    }

    private void initUI() {
        setTitle("Quản lý Thiết Bị");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        tableModel = new DefaultTableModel(new String[]{"Mã Thiết Bị", "Loại Thiết Bị", "Hãng Sản Xuất", "Màu Thiết Bị", "Số Seri", "Mã Khách Hàng"}, 0);
        table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panel = new JPanel(new GridLayout(6, 2));

        panel.add(new JLabel("Mã Thiết Bị:"));
        txtMaThietBi = new JTextField();
        panel.add(txtMaThietBi);

        panel.add(new JLabel("Loại Thiết Bị:"));
        txtLoaiThietBi = new JTextField();
        panel.add(txtLoaiThietBi);

        panel.add(new JLabel("Hãng Sản Xuất:"));
        txtHangSanXuat = new JTextField();
        panel.add(txtHangSanXuat);

        panel.add(new JLabel("Màu Thiết Bị:"));
        txtMauThietBi = new JTextField();
        panel.add(txtMauThietBi);

        panel.add(new JLabel("Số Seri:"));
        txtSoSeri = new JTextField();
        panel.add(txtSoSeri);
        
        panel.add(new Label("Mã khách hàng"));
        cboMaKhachHang = new JComboBox<>();
        
        panel.add(cboMaKhachHang);

        add(panel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();

        btnAdd = new JButton("Gửi thông tin ");
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addThietBi();
            }
        });
        buttonPanel.add(btnAdd);

        btnUpdate = new JButton("Sửa");
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateThietBi();
            }
        });
        buttonPanel.add(btnUpdate);

        btnDelete = new JButton("Xóa");
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteThietBi();
            }
        });
        buttonPanel.add(btnDelete);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void loadData() {
        tableModel.setRowCount(0);
        List<ThietBi> list = thietBiDAO.selectAllThietBi();
        for (ThietBi thietBi : list) {
            tableModel.addRow(new Object[]{thietBi.getMaThietBi(), thietBi.getLoaiThietBi(), thietBi.getHangSanXuat(), thietBi.getMauThietBi(), thietBi.getSoSeri(), thietBi.getKhachHang().getMaKhachHang()});
        }
    }

    private void addThietBi() {
        int maThietBi = Integer.parseInt(txtMaThietBi.getText());
        String loaiThietBi = txtLoaiThietBi.getText();
        String hangSanXuat = txtHangSanXuat.getText();
        String mauThietBi = txtMauThietBi.getText();
        String soSeri = txtSoSeri.getText();
        int maKhachHang = Integer.parseInt(cboMaKhachHang.getSelectedItem().toString());
        ThietBi thietBi = new ThietBi();
        thietBi.setMaThietBi(maThietBi);
        thietBi.setLoaiThietBi(loaiThietBi);
        thietBi.setHangSanXuat(hangSanXuat);
        thietBi.setMauThietBi(mauThietBi);
        thietBi.setSoSeri(soSeri);
        KhachHang khachHang = new KhachHang(maKhachHang);
        thietBi.setKhachHang(khachHang);

        try {
            thietBiDAO.insertThietBi(thietBi);
            loadData();
            clearFields();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateThietBi() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            int maThietBi = (int) tableModel.getValueAt(selectedRow, 0);
            String loaiThietBi = txtLoaiThietBi.getText();
            String hangSanXuat = txtHangSanXuat.getText();
            String mauThietBi = txtMauThietBi.getText();
            String soSeri = txtSoSeri.getText();
            int maKhachHang = Integer.parseInt(cboMaKhachHang.getSelectedItem().toString());
            ThietBi thietBi = new ThietBi(maThietBi, loaiThietBi, hangSanXuat, mauThietBi, soSeri);

            try {
                thietBiDAO.updateThietBi(thietBi);
                loadData();
                clearFields();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một hàng để cập nhật");
        }
    }

    private void deleteThietBi() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            int maThietBi = (int) tableModel.getValueAt(selectedRow, 0);
            try {
                thietBiDAO.deleteThietBi(maThietBi);
                loadData();
                clearFields();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một hàng để xóa");
        }
    }

    private void clearFields() {
    	txtMaThietBi.setText("");
        txtLoaiThietBi.setText("");
        txtHangSanXuat.setText("");
        txtMauThietBi.setText("");
        txtSoSeri.setText("");
    }
    
    private void loadMaKhachHang() {
        List<KhachHang> khachHangs = khachHang_DAO.selectAllMaKhachHang();
        for (KhachHang khachHang : khachHangs) {
            cboMaKhachHang.addItem(khachHang.getMaKhachHang());
        }
    }
   
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ThietBiFrame().setVisible(true);
            }
        });
    }
}
