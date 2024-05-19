package se.iuh.demo.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import se.iuh.demo.dao.ThietBi_DAO;
import se.iuh.demo.entites.ThietBi;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DanhGiaUI extends JFrame {
    private JTable tblThongTinThietBi, tblDanhGia;
    private DefaultTableModel thongTinTableModel, danhGiaTableModel;
    private JScrollPane scrollPaneThongTin, scrollPaneDanhGia;
    private JButton btnXemThongTin, btnLuuDanhGia;
    private JTextField txtMaDanhGia, txtTinhTrang, txtNgayDanhGia;
    private JTextArea txtAreaGhiChu;
    private ThietBi_DAO thietBiDAO;

	private JTable table;
	private JButton btnXemThongTinDanhGia;
	private JButton btnXoaDanhGia;
	private JButton btnCapNhat;
	private JButton btnXoaTrang;
    public DanhGiaUI() {
        setTitle("Quản lý Thiết Bị và Đánh Giá");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
        thietBiDAO = new ThietBi_DAO();
     
    }

    private void initComponents() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel panelBang = new JPanel(new BorderLayout());
        panel.add(panelBang,BorderLayout.CENTER);
        // Bảng hiển thị thông tin thiết bị
//        thongTinTableModel = new DefaultTableModel();
        
        
        JLabel lblTieuDe =  new JLabel("ĐÁNH GIÁ THIẾT BỊ", SwingConstants.CENTER);
        lblTieuDe.setSize(20,90);
        lblTieuDe.setFont(new Font("Time new Romen", 1, 30));
        
        panel.add(lblTieuDe, BorderLayout.NORTH );
        
        thongTinTableModel = new DefaultTableModel(new String[]{"Mã Thiết Bị","Loại Thiết Bị", "Hãng Sản Xuất", "Màu Thiết Bị", "Số Seri"},0);
        tblThongTinThietBi = new JTable(thongTinTableModel);
        scrollPaneThongTin = new JScrollPane(tblThongTinThietBi);
        Dimension preferredSize = new Dimension(500, 200);
        scrollPaneThongTin.setPreferredSize(preferredSize);
       
        panelBang.add(scrollPaneThongTin, BorderLayout.NORTH);

        // Nút "Xem Thông Tin"
        btnXemThongTin = new JButton("Xem Thông Tin");
        JPanel panelXemThongTin = new JPanel();
        panelXemThongTin.add(btnXemThongTin);
        
        btnXemThongTinDanhGia = new JButton("Xem Thông Tin Bảng Đánh Giá");
        JPanel panelXemThongTinDanhGia = new JPanel();
        panelXemThongTin.add(btnXemThongTinDanhGia);
        
        panel.add(panelXemThongTin, BorderLayout.SOUTH);
        
       
       
      

        // Bảng đánh giá
        danhGiaTableModel = new DefaultTableModel(new String[] {"Mã đánh giá", "Tình trạng" , "Ngày đánh giá" , "Ghi chú" , "Mã thiết bị"} , 0);
        
        tblDanhGia = new JTable(danhGiaTableModel);
        scrollPaneDanhGia = new JScrollPane(tblDanhGia);
        panelBang.add(scrollPaneDanhGia, BorderLayout.CENTER);

        
        
        // Panel nhập thông tin đánh giá
        JPanel panelNhapDanhGia = new JPanel(new GridLayout(6, 2));
        JLabel lblMaThietBi = new JLabel("Mã Đánh Giá:");
        txtMaDanhGia = new JTextField();
        
        JLabel lblTinhTrang = new JLabel("Tình Trạng:");
        txtTinhTrang = new JTextField();
        JLabel lblNgayDanhGia = new JLabel("Ngày Đánh Giá:");
        txtNgayDanhGia = new JTextField();
        JLabel lblGhiChu = new JLabel("Ghi Chú:");
        txtAreaGhiChu = new JTextArea();
        btnLuuDanhGia = new JButton("Lưu Đánh Giá");
        btnXoaDanhGia = new JButton("Xóa bảng đánh giá");
        btnCapNhat = new JButton("Cập nhật bảng đánh giá");
        btnXoaTrang = new JButton("Xóa Trắng");
        panelNhapDanhGia.add(lblMaThietBi);
        panelNhapDanhGia.add(txtMaDanhGia);
        panelNhapDanhGia.add(lblTinhTrang);
        panelNhapDanhGia.add(txtTinhTrang);
        panelNhapDanhGia.add(lblNgayDanhGia);
        panelNhapDanhGia.add(txtNgayDanhGia);
        panelNhapDanhGia.add(lblGhiChu);
        panelNhapDanhGia.add(new JScrollPane(txtAreaGhiChu));
        panelNhapDanhGia.add(btnLuuDanhGia);
        panelNhapDanhGia.add(btnXoaDanhGia);
        panelNhapDanhGia.add(btnCapNhat);
        panelNhapDanhGia.add(btnXoaTrang);
        panel.add(panelNhapDanhGia, BorderLayout.WEST);

        getContentPane().add(panel);

        btnXemThongTin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Xử lý sự kiện khi nhấn nút "Xem Thông Tin"
                // Gọi phương thức để lấy thông tin của Thiết Bị từ mã Thiết Bị và hiển thị lên bảng thông tin
            	loadDataThietBi();
            }
        });

        btnLuuDanhGia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Xử lý sự kiện khi nhấn nút "Lưu Đánh Giá"
                // Lấy thông tin từ các trường và lưu đánh giá vào bảng DanhGia
            }
        });
    }
    
    private void loadDataThietBi() {
    	 thongTinTableModel.setRowCount(0);
         List<ThietBi> list = thietBiDAO.selectAllThietBi();
         for (ThietBi thietBi : list) {
        	 thongTinTableModel.addRow(new Object[]{thietBi.getMaThietBi(), thietBi.getLoaiThietBi(), thietBi.getHangSanXuat(), thietBi.getMauThietBi(), thietBi.getSoSeri()});
         }
	}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DanhGiaUI().setVisible(true);
            }
        });
    }
}
