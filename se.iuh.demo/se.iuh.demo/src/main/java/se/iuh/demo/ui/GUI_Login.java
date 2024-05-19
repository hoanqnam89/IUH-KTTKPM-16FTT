package se.iuh.demo.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import se.iuh.demo.dao.LoginDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtTenTaiKhoan;
	private JPasswordField passwordField;
	private JLabel messageLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Login frame = new GUI_Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI_Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u0110\u0103ng Nh\u1EADp");
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(156, 32, 194, 24);
		contentPane.add(lblNewLabel);
		
		txtTenTaiKhoan = new JTextField();
		txtTenTaiKhoan.setBounds(156, 92, 144, 19);
		contentPane.add(txtTenTaiKhoan);
		txtTenTaiKhoan.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(156, 135, 144, 19);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00EAn t\u00E0i kho\u1EA3n :");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(50, 83, 96, 36);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(" M\u1EADt kh\u1EA9u :");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(50, 135, 85, 19);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("\u0110\u0103ng nh\u1EADp");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleLogin2();
			}
		});
		btnNewButton.setBounds(156, 172, 145, 36);
		contentPane.add(btnNewButton);

        messageLabel = new JLabel("");
        messageLabel.setBounds(40, 110, 250, 25);
        contentPane.add(messageLabel);
        
        JButton btnngK = new JButton("Đăng ký");
        btnngK.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new GUI_DangKy().setVisible(true);
        	}
        });
        btnngK.setBounds(156, 217, 145, 36);
        contentPane.add(btnngK);
	}
    private void handleLogin2() {
        String username = txtTenTaiKhoan.getText();
        String password = new String(passwordField.getPassword());

        LoginDao loginDao = new LoginDao();
        String loggedInUser = loginDao.validateUser(username, password);
        if (loggedInUser != null) {
            messageLabel.setText("Welcome, " + loggedInUser + "!");
            // Mở cửa sổ khác hoặc chuyển sang màn hình khác ở đây nếu cần
            Home_GUI home_GUI = new Home_GUI(loggedInUser);
            home_GUI.setVisible(true);
            dispose(); 
        } else {
            messageLabel.setText("Invalid username or password.");
        }
    }
}
