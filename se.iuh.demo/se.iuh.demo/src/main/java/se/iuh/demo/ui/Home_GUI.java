package se.iuh.demo.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home_GUI extends JFrame {

	private JPanel contentPane;



	/**
	 * Create the frame.
	 */
	public Home_GUI(String userName) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 907, 244);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("H\u1EC6 TH\u1ED0NG T\u00C1I CH\u1EBE THI\u1EBET B\u1ECA \u0110I\u1EC6N T\u1EEC ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBackground(Color.GREEN);
		lblNewLabel.setBounds(199, 10, 542, 81);
		contentPane.add(lblNewLabel);
		
		JLabel lblUser = new JLabel(userName);
		lblUser.setBounds(26, 32, 45, 13);
		contentPane.add(lblUser);
		
		JButton btnDangXuat = new JButton("\u0110\u0103ng xu\u1EA5t");
		btnDangXuat.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleLogout();
			}
		});
		btnDangXuat.setBounds(785, 10, 85, 21);
		contentPane.add(btnDangXuat);
	}
	 private void handleLogout() {
	        // Đóng HomeFrame
	        dispose();

	        // Mở lại LoginForm
	        GUI_Login loginForm = new GUI_Login();
	        loginForm.setVisible(true);
	    }
}
